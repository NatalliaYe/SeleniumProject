package newObjectTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessLogoutPage {

    private By successLogoutMessage = By.cssSelector(".notice.success");

    private WebDriver driver;

    public SuccessLogoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean logoutMessageIsVisible () {
        return driver.findElement(successLogoutMessage).isDisplayed();
    }

    public String getLogoutMessageText() {
        return driver.findElement(successLogoutMessage).getText();
    }

}
