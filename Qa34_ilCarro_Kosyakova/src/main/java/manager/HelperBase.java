package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperBase
{
    WebDriver wd;

    public HelperBase(WebDriver wd)
    {
        this.wd = wd;
    }
    public void type (By locator, String text) {
        // find +click+clear+sendKey
        if (text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
    public void click(By locator){
        wd.findElement(locator).click();
    }
    public void submit() {
        new WebDriverWait(wd, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(wd.findElement(By.cssSelector("button[type='submit']"))));
        wd.findElement(By.cssSelector("button[type='submit']")).click();
    }
}
