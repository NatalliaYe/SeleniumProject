package selenide;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static newObjectTest.Locators.getLocator;


public class LogoutPage {

    @Step("Click logout button")
    public void clickLogoutButton() throws Exception {
        $(getLocator("LogoutPage.LogoutButton")).click();
    }

}
