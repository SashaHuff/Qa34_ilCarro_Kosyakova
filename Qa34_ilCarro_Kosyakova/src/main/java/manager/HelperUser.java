package manager;

import com.beust.ah.A;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }


    public void openLoginForm() {

        click(By.xpath("//*[@href='/login?url=%2Fsearch']"));
        /*  WebElement logTab = wd.findElement(By.xpath("//*[@href='/login?url=%2Fsearch']"));
        or logTab = wd.findElement(By.xpath("//a[text()=' Log in ']")); find by text (xPath)
        logTab.click();
       */
    }

    public void fillLogInForm(String email, String password) {
        type(By.xpath("//*[@id='email']"), email);
        type(By.xpath("//*[@id='password']"), password);
    }

    // new
    public void openRegistrationForm() {
        click(By.xpath("//*[@href='/registration?url=%2Fsearch']"));
    }
    //new
    public void fillRegistrationForm(User user)
    {
        type(By.id("name"),user.getName());
        type(By.id("lastName"),user.getLastName());
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());
    }

    public void fillRegistrationForm(String name, String lastName, String email, String password) {

        type(By.xpath("//*[@id='name']"), name);
        type(By.xpath("//*[@id='lastName']"), lastName);
        type(By.xpath("//*[@id='email']"), email);
        type(By.xpath("//*[@id='password']"), password);
        WebElement termsOfUse = wd.findElement(By.cssSelector(".checkbox-container>input#terms-of-use"));
        termsOfUse.click();
    }

    public boolean isLogged() {
        // sign out present? --> logged
        List<WebElement> list =wd.findElements(By.xpath("//a[text()=' Logout ']"));
        return list.size()>0;
    }

    public void logOut() {
        click(By.xpath("//a[text()=' Logout ']"));
    }
    public void checkPolicy()
    {
        click(By.cssSelector("label[for ='terms-of-use']"));
    }

    public void checkPolicyXY() {

        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        Rectangle rect = label.getRect();
        int xOffSet=rect.getWidth()/2;
        int yOffSet = rect.getHeight()/2;

        Actions actions = new Actions(wd);
        actions.moveToElement(label).release().perform();
        actions.moveByOffset(-xOffSet,-yOffSet).click().release().perform();
    }
    public void clickOk() {
        click(By.xpath("//button[text()='Ok']"));
    }
}
