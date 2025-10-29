package selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

@Feature("Catalog  opening test")
public class CatalogTest extends TestBase {

    @Story("Opening catalog page")
    @Description("User clicks button Rubber Ducks and goes to catalog page")
    @Test(description = "Click catalog button test")
    public void clickCatalogTest() throws Exception {
        CatalogPage catalogPage = new CatalogPage();

        catalogPage.rubberDucksButton();

        String currentUrl = WebDriverRunner.url();
        Assert.assertTrue(currentUrl.contains("rubber-ducks"),
                "URL must contain 'rubber-ducks'. Current URL: " + currentUrl);

        String pageTitle =  title();
        Assert.assertEquals(pageTitle, "Rubber Ducks | My Store",
                "Page header doesn`t correspond the expected");
    }

}
