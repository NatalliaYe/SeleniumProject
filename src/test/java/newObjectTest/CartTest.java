package newObjectTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.title;

public class CartTest extends TestBase {

    @Test
    public void openCartTest() throws Exception {

        CartPage cartPage = new CartPage(driver);

        cartPage.clickCartButton();

        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Checkout | My Store");

    }
}
