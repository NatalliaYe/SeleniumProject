package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import io.qameta.allure.Feature;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


@Feature("UI tests")
@Listeners(ReportPortalTestNGListener.class)
public class TestBase {


    @BeforeMethod
    public void setup() throws Exception {

        String browser = System.getProperty("browser", "chrome");

        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;

        Configuration.browser = switch(browser.toLowerCase()) {
            case "chrome" -> "chrome";
            case "firefox" -> "firefox";
            default -> "chrome";
        };

        open("https://litecart.stqa.ru/en/");


        LoginPage loginPage = new LoginPage();
        loginPage.login("natalyhubchuk@gmail.com", "Test-01");
    }

    @AfterMethod
    public void teardown() {
        closeWebDriver();
    }

}
