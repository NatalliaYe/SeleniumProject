package selenide;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static newObjectTest.Locators.getLocator;


public class CartPage {

@Step("Click cart button")
    public void clickCartButton() throws Exception {
        $(getLocator("CartPage.CartButton"))
                .should(exist)
                .shouldBe(enabled)
                .click();
    }
}
