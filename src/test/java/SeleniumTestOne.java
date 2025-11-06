import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;


public class SeleniumTestOne {

    public void actionsTestOne(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement homeButton = driver.findElement(By.className("fa-home"));
        homeButton.click();
        String pageTitle = driver.getTitle();
        Assert.assertTrue(Objects.equals(pageTitle, "Online Store | My Store"));

    }

    public void actionsTestTwo() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement headerLink = driver.findElement(By.cssSelector("[class='category-1']"));
        headerLink.click();
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Rubber Ducks | My Store");
    }



    public void actionsTestThree() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement headerLink = driver.findElement(By.linkText("Rubber Ducks"));
        WebElement subHeaderLink = driver.findElement(By.cssSelector("[class='category-2']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(headerLink).click(subHeaderLink).perform();
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Subcategory | My Store");

    }


    public void differentActionsTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement redDuck = driver.findElement(By.cssSelector("img[alt='Red Duck']"));
        redDuck.click();
        WebElement addToCartButton = driver.findElement(By.cssSelector("button[name='add_cart_product']"));
        addToCartButton.click();

    }


    public void nextActionsTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://litecart.stqa.ru/en/");
        WebElement blueDuck = driver.findElement(By.cssSelector("img[alt='Blue Duck']"));
        blueDuck.click();
        WebElement logoButton = driver.findElement(By.cssSelector("img[alt='My Store']"));
        logoButton.click();

    }



    public void seleniumFirstTest() {
        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com");
//
//        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
//        Assert.assertEquals(allLinks.size(), 46);
//
//        allLinks.get(10).click();

    }


}
