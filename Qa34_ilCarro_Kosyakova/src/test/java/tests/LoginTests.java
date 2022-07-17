package tests;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase
{
     @BeforeMethod
     public void preCondition() {
         if(app.getHelperUser().isLogged2()){
             app.getHelperUser().logOut();
         }

     }

    @Test
    public void successLogin() {
        logger.info("Test start with email: 'huff@gmail.com' & 'Hhuff1234$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLogInForm("huff@gmail.com","Hhuff1234$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in");

    }
    @Test
    public void successLogin2() {
        User user = new User().setEmail("huff1@gmail.com").setPassword("Hhuff11234$");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLogInForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in");


    }
    @AfterMethod
    public void postCondition()
    {
        app.getHelperUser().clickOk();
    }
    // login negative -check later
   /*
    @Test
    public void loginNegativeTestsWrongEmail() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLogInForm("huffgmail.com","Hhuff1234$");
        app.getHelperUser().submit();

    }

    */
}
