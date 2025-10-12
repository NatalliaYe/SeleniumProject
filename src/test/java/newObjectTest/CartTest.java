package newObjectTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends TestBase {

    @Test
    public void openCartTest() {
        CartPage cartPage = new CartPage(driver);

        cartPage.clickCartButton();

    }
}
