package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        WebElement logTab = wd.findElement(By.xpath("//*[@href='/login?url=%2Fsearch']"));
        //  logTab = wd.findElement(By.xpath("//a[text()=' Log in ']")); find by text (xPath)
        logTab.click();
    }

    public void fillLogInForm(String email, String password) {

        type(By.xpath("//*[@id='email']"), email);
        type(By.xpath("//*[@id='password']"), password);
    }

    public void submitLogin() {
        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void openRegistrationForm() {
        WebElement regTab = wd.findElement(By.xpath("//*[@href='/registration?url=%2Fsearch']"));
        regTab.click();
    }

    public void submitRegistration() {


        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void fillRegistrationForm(String name, String lastName, String email, String password) {

        type(By.xpath("//*[@id='name']"), name);
        type(By.xpath("//*[@id='lastName']"), lastName);
        type(By.xpath("//*[@id='email']"), email);
        type(By.xpath("//*[@id='password']"), password);
        WebElement termsOfUse = wd.findElement(By.cssSelector(".checkbox-container>input#terms-of-use"));
        termsOfUse.click();
    }
}
