package selenide;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static newObjectTest.Locators.getLocator;

@Feature("Open catalog page")
public class CatalogPage {


    @Step("Click button Rubber Ducks")
    public void rubberDucksButton() throws Exception {
        $(getLocator("CatalogPage.RubberDucksButton")).click();
    }

}
