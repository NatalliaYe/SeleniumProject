package selenide;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static newObjectTest.Locators.getLocator;

@Feature("UI login test")
public class LoginPage {

    @Step("Write login")
    public void writeLogin(String username) throws Exception {
        $(getLocator("LoginPage.LoginField")).sendKeys(username);
    }
    @Step("Write password")
    public void writePassword(String password) throws Exception {
        $(getLocator("LoginPage.PasswordField")).sendKeys(password);
    }
    @Step("Click login button")
    public void clickLoginButton() throws Exception {
        $(getLocator("LoginPage.LoginButton")).click();
    }
    @Step("Login")
    public void login(String username, String password) throws Exception {
        writeLogin(username);
        writePassword(password);
        clickLoginButton();
    }

}
