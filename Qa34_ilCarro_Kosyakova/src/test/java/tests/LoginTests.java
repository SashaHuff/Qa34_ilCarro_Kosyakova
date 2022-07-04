package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTests extends TestBase
{
    @Test
    public void successLogin() {

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLogInForm("huff@gmail.com","Hhuff1234$");
        app.getHelperUser().submitLogin();

    }
    // login negative
    @Test
    public void loginNegativeTestsWrongEmail() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLogInForm("huffgmail.com","Hhuff1234$");
        app.getHelperUser().submitLogin();

    }
}
