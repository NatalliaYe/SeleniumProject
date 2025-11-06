package newObjectTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private By cartButton = By.tagName("strong");

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }

}
