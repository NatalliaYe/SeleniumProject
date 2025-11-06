package newObjectTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessLoginPage {

    private By successMessage = By.cssSelector(".notice.success");

    private WebDriver driver;

    public SuccessLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean successMessageIsVisible () {
        return driver.findElement(successMessage).isDisplayed();
    }

    public String getSuccessMessageText() {
        return driver.findElement(successMessage).getText();
    }

}
