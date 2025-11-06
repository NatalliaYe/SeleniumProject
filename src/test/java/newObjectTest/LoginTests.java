package newObjectTest;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTests extends TestBase {


    @Test
    public void correctCredentialsTest() throws IllegalArgumentException {

        SuccessLoginPage successLoginPage = new SuccessLoginPage(driver);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(successLoginPage.successMessageIsVisible());
        softAssert.assertEquals(successLoginPage.getSuccessMessageText(),
                "You are now logged in as Natallia Yel.");

        softAssert.assertAll();

    }

    @Test
    public void emptyFieldMessageTest() throws IllegalArgumentException {
        LoginPage loginPage = new LoginPage(driver);
        EmptyFieldPage emptyFieldPage = new EmptyFieldPage(driver);

        driver.get ("https://litecart.stqa.ru/en/login");
        loginPage.login("natalyhubchuk@gmail.com","" );

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(emptyFieldPage.emptyFieldMessageIsVisible());
        softAssert.assertEquals(emptyFieldPage.getEmptyFieldMessageText(),
                "You must provide both email address and password.");

        softAssert.assertAll();

    }

}
