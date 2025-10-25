package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.conditions.webdriver.Url;
import com.codeborne.selenide.testng.SoftAsserts;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


@Feature("UI tests")
//@Listeners({ SoftAsserts.class, ReportPortalTestNGListener.class })
public class TestBase {


    @BeforeMethod
    public void setup() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        String browser = System.getProperty("browser", "chrome");
        String os = System.getProperty("os", "windows");

        caps.setBrowserName(CHROME);
        switch (os.toLowerCase()) {
            case "win11", "win" -> caps.setPlatform(Platform.WINDOWS);
            case "mac" -> caps.setPlatform(Platform.MAC);
            case "linux" -> caps.setPlatform(Platform.LINUX);
            default -> caps.setPlatform(Platform.ANY);
        }

        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-natalyhubchuk-9cca5");
        sauceOptions.put("accessKey", "2df357b1-b1f7-4487-a453-007b11b36576");
        sauceOptions.put("build", "<My Selenide build 1.1>");
        sauceOptions.put("name", "<Regression>");
        caps.setCapability("sauce:options", sauceOptions);


        Configuration.browser = "browser";
        Configuration.remote = "https://oauth-natalyhubchuk-9cca5:2df357b1-b1f7-4487-a453-007b11b36576@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
        Configuration.browserCapabilities = caps;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;
        Configuration.pageLoadTimeout = 15000;

        open("https://litecart.stqa.ru/en/login");

        LoginPage loginPage = new LoginPage();
        loginPage.login("natalyhubchuk@gmail.com", "Test-01");

        System.out.println("Current URL: " + WebDriverRunner.url());
    }

    @AfterMethod
    public void teardown() {

        closeWebDriver();
    }
}
