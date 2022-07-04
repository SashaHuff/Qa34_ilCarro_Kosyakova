package tests;

import org.testng.annotations.Test;

public class RegistrationTests extends TestBase

{
    @Test
    public void registrationSuccess()
    {
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm("Test1","Test1","test@gmail.com","Ttest123$");
        app.getHelperUser().submitRegistration();
    }
}
