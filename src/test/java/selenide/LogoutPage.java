package selenide;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static newObjectTest.Locators.getLocator;

@Feature("Logout and redirect to login page")
public class LogoutPage {

    @Step("Click logout button")
    public void clickLogoutButton() throws Exception {
        $(getLocator("LogoutPage.LogoutButton")).click();
    }

}
