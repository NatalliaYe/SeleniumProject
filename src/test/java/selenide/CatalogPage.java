package selenide;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static newObjectTest.Locators.getLocator;


public class CatalogPage {

    @Step("Click button Rubber Ducks")
    public void rubberDucksButton() throws Exception {
        $(getLocator("CatalogPage.RubberDucksButton"))
                .should(exist)
                .shouldBe(enabled)
                .click();
    }

}
