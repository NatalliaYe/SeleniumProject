package selenide;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


@Feature("Login tests")
//@Listeners(SoftAsserts.class)
public class LoginTests extends TestBase {


    @Story("Opening Homepage after user logs in with correct credentials")
    @Description("When user enters correct credentials, clicks Login button homepage opens")
    @Test(description = "Correct credentials test")
    public void correctCredentialsTest() throws Exception {

        SuccessLoginPage successLoginPage = new SuccessLoginPage();

        Configuration.assertionMode = AssertionMode.SOFT;

        successLoginPage.getSuccessMessageText().shouldBe(visible);
        successLoginPage.getSuccessMessageText().shouldHave(text("You are now logged in as Natallia Yel."));

    }

    @Story("Logging in with one field empty")
    @Description("When user enters with one field empty, error message appears")
    @Test(description = "Empty file message text")
    public void emptyFieldMessageTest() throws Exception {
        open("https://litecart.stqa.ru/en/login");
        LoginPage loginPage = new LoginPage();
        EmptyFieldPage emptyFieldPage = new EmptyFieldPage();

        loginPage.login("natalyhubchuk@gmail.com","" );

        Configuration.assertionMode = AssertionMode.SOFT;

        emptyFieldPage.getEmptyFieldMessageText().shouldBe(visible);
        emptyFieldPage.getEmptyFieldMessageText().shouldHave(text("You must provide both email address and password."));

    }

}
