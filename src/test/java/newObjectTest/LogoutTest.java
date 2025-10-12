package newObjectTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LogoutTest extends TestBase {

    @Test
    public void logoutTest() {
        LogoutPage logoutPage = new LogoutPage(driver);
        SuccessLogoutPage successLogoutPage = new SuccessLogoutPage(driver);

        logoutPage.clickLogoutButton();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(successLogoutPage.logoutMessageIsVisible());
        softAssert.assertEquals(successLogoutPage.getLogoutMessageText(),
                "You are now logged out.");

        softAssert.assertAll();

    }

}
