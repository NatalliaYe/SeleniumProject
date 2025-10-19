package selenide;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;


@Feature("UI logout test")
public class LogoutTest extends TestBase {


    @Story("Redirect to Login page after logging out")
    @Description("When user clicks Logout button login page opens")
    @Test(description = "Logout test")
    public void logoutTest() throws Exception {
        LogoutPage logoutPage = new LogoutPage();
        SuccessLogoutPage successLogoutPage = new SuccessLogoutPage();

        logoutPage.clickLogoutButton();

        Configuration.assertionMode = AssertionMode.SOFT;

        successLogoutPage.getLogoutMessageText().shouldBe(visible);
        successLogoutPage.getLogoutMessageText().shouldHave(text("You are now logged out."));


    }

}
