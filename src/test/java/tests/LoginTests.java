package tests;

import manager.MyDataProviderLogin;
import manager.MyDataProviderLoginFromCSV;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTests extends TestBase
{
     @BeforeMethod (alwaysRun = true)
     public void preCondition() {
         if(app.getHelperUser().isLogged2()){
             app.getHelperUser().logOut();
         }

     }

    @Test(dataProvider = "dataLogin",dataProviderClass = MyDataProviderLogin.class)
    public void successLogin(String email, String password) {
        logger.info("Test start with email: "+ email +"password: "+ password);
     //   logger.info("Test start with email: 'huff@gmail.com' & 'Hhuff1234$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLogInForm(email,password);
     //   app.getHelperUser().fillLogInForm("huff@gmail.com","Hhuff1234$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in");

    }
    @Test
    public void successLogin2() {
        User user = new User().setEmail("joe@gmail.com").setPassword("Dow1234+");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLogInForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in");
    }
    @Test (dataProvider = "loginCSV", dataProviderClass = MyDataProviderLoginFromCSV.class)
    public void successLoginDP(User user) {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLogInForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in");
    }
    @AfterMethod (alwaysRun = true)
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
