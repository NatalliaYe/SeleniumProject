package selenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static newObjectTest.Locators.getLocator;

@Feature("Logout page test message")
public class SuccessLogoutPage {

    @Step("Check system message is visible after logout")
    public boolean logoutMessageIsVisible () throws Exception {
        return $(getLocator("SuccessLogoutPage.SuccessLogoutMessage")).isDisplayed();
    }

    @Step("Get logout message text")
    public static SelenideElement getLogoutMessageText() throws Exception {
        return $(getLocator("SuccessLogoutPage.SuccessLogoutMessage"));

    }

}
