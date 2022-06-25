package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;



public class TestBase {
    WebDriver wd;

    @BeforeMethod
    public void preCondition()
    {
        wd = new FirefoxDriver();
        wd.navigate().to("https://ilcarro-1578153671498.web.app/search");
        wd.manage().window().maximize(); // open full window
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

  /*  @AfterMethod
    public void tearDown()
    {
        wd.quit();
    }
*/
    public void openLoginForm()
    {
        WebElement logTab = wd.findElement(By.xpath("//*[@href='/login?url=%2Fsearch']"));
        logTab.click();
    }
    public void fillLogInForm(String email, String password){

        type(By.xpath("//*[@id='email']"),email);
        type(By.xpath("//*[@id='password']"),password);
    }
    public void submitLogin() {
        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void openRegistrationForm(){
        WebElement regTab = wd.findElement(By.xpath("//*[@href='/registration?url=%2Fsearch']"));
        regTab.click();
    }
    public void submitRegistration() {



        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }
    public void fillRegistrationForm(String name, String lastName, String email, String password){

        type(By.xpath("//*[@id='name']"),name);
        type(By.xpath("//*[@id='lastName']"),lastName);
        type(By.xpath("//*[@id='email']"),email);
        type(By.xpath("//*[@id='password']"),password);
        WebElement termsOfUse = wd.findElement(By.cssSelector(".checkbox-container>input#terms-of-use"));
        termsOfUse.click();
    }
    public void type (By locator, String text)
    {
        // find +click+clear+sendKey
        if(text!=null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }

    }

}
