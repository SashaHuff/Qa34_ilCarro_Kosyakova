package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTests extends TestBase
{
    @Test
    public void successLogin() {

        openLoginForm();
        fillLogInForm("huff@gmail.com","Hhuff1234$");
        submitLogin();


    }
    // login negative
    @Test
    public void loginNegativeTestsWrongEmail() {
        openLoginForm();
        fillLogInForm("huffgmail.com","Hhuff1234$");
        submitLogin();

    }
}
