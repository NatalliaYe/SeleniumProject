package newObjectTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage {

    private By rubberDucksButton = By.linkText("Rubber Ducks");

    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void rubberDucksButton() {
        driver.findElement(rubberDucksButton).click();
    }

}
