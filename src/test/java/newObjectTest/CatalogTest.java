package newObjectTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.title;

public class CatalogTest extends TestBase {

    @Test
    public void clickCatalogTest() throws Exception {
        CatalogPage catalogPage = new CatalogPage(driver);

        catalogPage.rubberDucksButton();
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Rubber Ducks | My Store");

    }

}
