package selenide;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.title;

@Feature("Cart page")
public class CartTest extends TestBase {

    @Story("User goes to cart page")
    @Description("When user clicks  cart button cart page opens")
    @Test(description = "Open cart test")
    public void openCartTest() throws Exception {

        CartPage cartPage = new CartPage();

        cartPage.clickCartButton();

        String pageTitle = title();
        Assert.assertEquals(pageTitle, "Checkout | My Store");

    }
}
