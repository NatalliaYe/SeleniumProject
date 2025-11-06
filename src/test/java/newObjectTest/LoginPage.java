package newObjectTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private By loginField = By.name("email");
    private By passwordField = By.name("password");
    private By loginButton = By.name("login");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void writeLogin(String username) {
        driver.findElement(loginField).sendKeys(username);
    }

    public void writePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        writeLogin(username);
        writePassword(password);
        clickLoginButton();
    }

}
