package newObjectTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginTests extends TestBase {


    @Test
    public void correctCredentialsTest() {
        LoginPage loginPage = new LoginPage(driver);
        SuccessLoginPage successLoginPage = new SuccessLoginPage(driver);

        loginPage.login("natalyhubchuk@gmail.com","Test-01" );

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(successLoginPage.successMessageIsVisible());
        softAssert.assertEquals(successLoginPage.getSuccessMessageText(),
                "You are now logged in as Natallia Yel.");

        softAssert.assertAll();

    }

    @Test
    public void emptyFieldMessageTest() {
        LoginPage loginPage = new LoginPage(driver);
        EmptyFieldPage emptyFieldPage = new EmptyFieldPage(driver);

        loginPage.login("natalyhubchuk@gmail.com","" );

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(emptyFieldPage.emptyFieldMessageIsVisible());
        softAssert.assertEquals(emptyFieldPage.getEmptyFieldMessageText(),
                "You must provide both email address and password.");

        softAssert.assertAll();

    }

}
