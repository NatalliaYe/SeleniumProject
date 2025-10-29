package selenide;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;


@Feature("UI logout test")
@Listeners(SoftAsserts.class)
public class LogoutTest extends TestBase {


    @Story("Redirect to Login page after logging out")
    @Description("When user clicks Logout button login page opens")
    @Test(description = "Logout test")
    public void logoutTest() throws IllegalArgumentException {
        LogoutPage logoutPage = new LogoutPage();
        SuccessLogoutPage successLogoutPage = new SuccessLogoutPage();

        try {
            logoutPage.clickLogoutButton();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Configuration.assertionMode = AssertionMode.SOFT;

        try {
            successLogoutPage.getLogoutMessageText().shouldBe(visible);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            successLogoutPage.getLogoutMessageText().shouldHave(text("You are now logged out."));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
