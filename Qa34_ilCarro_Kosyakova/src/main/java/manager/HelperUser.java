package manager;

import com.beust.ah.A;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
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
    public void fillLogInForm(User user)
    {
        type(By.xpath("//*[@id='email']"), user.getEmail());
        type(By.xpath("//*[@id='password']"), user.getPassword());
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
    public boolean isLogged2()
    {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
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
        if (isElementPresent(By.xpath("//button[text()='Ok']")))
        {
            click(By.xpath("//button[text()='Ok']"));
        };
    }


    public boolean isErrorPasswordSizeDisplayed() {
        System.out.println(wd.findElement(By.cssSelector("div.error div:first-child")).getText());
        return new WebDriverWait(wd, Duration.ofSeconds(5)).until(ExpectedConditions
                .textToBePresentInElement(wd.findElement(By.cssSelector("div.error div:first-child"))
                        , "Password must contain minimum 8 symbols"));
    }
    public boolean isErrorPasswordFormatDisplayed() {
            System.out.println(wd.findElement(By.cssSelector("div.error div:last-child")).getText());
        boolean lastChild = new WebDriverWait(wd, Duration.ofSeconds(5)).until(ExpectedConditions
                .textToBePresentInElement(wd.findElement(By.cssSelector("div.error div:last-child"))
                        , "Password must contain 1 uppercase letter, 1 lowercase letter and one number"));

        return lastChild;
    }

    public boolean isYallaButtonNotActive() {
        boolean disabled = isElementPresent(By.cssSelector("button[disabled]"));
        boolean enabled = wd.findElement(By.cssSelector("[type=submit]")).isEnabled();
        return disabled&&!enabled;
    }

    public void login(User user) {
        openLoginForm();
        fillLogInForm(user);
        submit();
        clickOk();
    }

}
