package selenide;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.title;

@Feature("Catalog  opening test")
public class CatalogTest extends TestBase {

    @Story("Opening catalog page")
    @Description("User clicks button Rubber Ducks and goes to catalog page")
    @Test(description = "Click catalog button test")
    public void clickCatalogTest() throws Exception {
        CatalogPage catalogPage = new CatalogPage();

        catalogPage.rubberDucksButton();
        String pageTitle =  title();
        Assert.assertEquals(pageTitle, "Rubber Ducks | My Store");

    }

}
