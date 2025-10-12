package newObjectTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        String browser = System.getProperty("browser", "chrome");

        driver= switch (browser) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            default -> new ChromeDriver();
        };

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get ("https://litecart.stqa.ru/en/");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("natalyhubchuk@gmail.com", "Test-01");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
