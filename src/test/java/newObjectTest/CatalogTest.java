package newObjectTest;

import org.testng.annotations.Test;

public class CatalogTest extends TestBase {

    @Test
    public void clickCatalogTest() {
        CatalogPage catalogPage = new CatalogPage(driver);

        catalogPage.rubberDucksButton();

    }

}
