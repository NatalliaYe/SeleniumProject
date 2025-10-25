package selenide;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static newObjectTest.Locators.getLocator;


public class LoginPage {

    @Step("Write login")
    public void writeLogin(String username)  {
        try {
            $(getLocator("LoginPage.LoginField"))
                    .should(exist)
                    .shouldBe(visible)
                    .setValue(username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Write password")
    public void writePassword(String password)  {
        try {
            $(getLocator("LoginPage.PasswordField"))
                    .should(exist)
                    .shouldBe(visible)
                    .setValue(password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Click login button")
    public void clickLoginButton()  {
        try {
            $(getLocator("LoginPage.LoginButton"))
                    .should(exist)
                    .shouldBe(enabled)
                    .click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Login")
    public void login(String username, String password)  {
        writeLogin(username);
        writePassword(password);
        clickLoginButton();

        $("body").shouldHave(not(text("Login")));
    }

}
