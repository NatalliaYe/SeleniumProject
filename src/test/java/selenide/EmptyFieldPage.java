package selenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static newObjectTest.Locators.getLocator;

@Feature("Correct error message after logging in with empty field ")
public class EmptyFieldPage {

    @Step("Check system message is visible after logging in with empty field ")
    public boolean emptyFieldMessageIsVisible () throws Exception {
        return $(getLocator("EmptyFieldPage.EmptyFieldMessage")).isDisplayed();
    }

    @Step("Get system message after logging in with empty field")
    public static SelenideElement getEmptyFieldMessageText() throws Exception {
        return $(getLocator("EmptyFieldPage.EmptyFieldMessage"));
    }

}
