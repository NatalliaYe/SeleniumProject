package newObjectTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

