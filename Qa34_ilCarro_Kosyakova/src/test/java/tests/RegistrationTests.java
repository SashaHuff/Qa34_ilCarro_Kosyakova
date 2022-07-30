package tests;

import manager.MyDataProviderRegistration;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged2()) {
            app.getHelperUser().logOut();
        }

    }

    @Test
    public void registrationSuccess() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().setName("Test" + i).setLastName("Test" + i).setEmail("tets" + i + "@gmail.com").setPassword("Ttest" + i + "$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();

        app.getHelperUser().submit();
        logger.info("Registration was succssesful with data --->" + user.toString());
        Assert.assertEquals(app.getHelperUser().getMessage(), "Registered");

    }

    @Test(dataProvider = "dataReg", dataProviderClass = MyDataProviderRegistration.class)
    public void registrationSuccess1(User user) {
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Registered");
    }



    @Test
    public void registrationWrongPasswordFormatAndSize() {
        User user = new User()
                .setName("Snow")
                .setLastName("White")
                .setEmail("snowwhite@gmail.com")
                .setPassword("SNow");
        logger.info("Registration was unsuccssesful with data --->" + user.toString());
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
       Assert.assertTrue(app.getHelperUser().isErrorPasswordSizeDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorPasswordFormatDisplayed());
       Assert.assertTrue(app.search().isYallaButtonNotActive());
    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOk();
        app.search().returnToSearch();
    }


}
