package newObjectTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmptyFieldPage {

    private By emptyFieldMessage = By.cssSelector(".notice.errors");

    private WebDriver driver;

    public EmptyFieldPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean emptyFieldMessageIsVisible () {
        return driver.findElement(emptyFieldMessage).isDisplayed();
    }

    public String getEmptyFieldMessageText() {
        return driver.findElement(emptyFieldMessage).getText();
    }
}
