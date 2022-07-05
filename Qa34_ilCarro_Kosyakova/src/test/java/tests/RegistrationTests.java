package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase

{
    @Test
            public void registrationSuccess()
    {
        int i = (int) (System.currentTimeMillis()/1000)%3600;
        User user = new User().setName("Test"+i).setLastName("Test"+i).setEmail("tets"+i+"@gmail.com").setPassword("Ttest"+i+"$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getMessage(),"Registered");
        app.getHelperUser().clickOk();
    }

   /* @Test
    public void registrationSuccess()
    {
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm("Test1","Test1","test@gmail.com","Ttest123$");
        app.getHelperUser().submitRegistration();
    }

    */
}
