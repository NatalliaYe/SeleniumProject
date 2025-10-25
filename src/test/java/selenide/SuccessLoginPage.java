package selenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static newObjectTest.Locators.getLocator;


public class SuccessLoginPage {

    @Step("Check system message is visible after logging in with correct credentials")
    public boolean successMessageIsVisible () throws Exception {
        return $(getLocator("SuccessLoginPage.SuccessMessage")).isDisplayed();
    }

    @Step("Get message after success login")
    public static SelenideElement getSuccessMessageText() throws Exception {
        return $(getLocator("SuccessLoginPage.SuccessMessage"));

    }

}
