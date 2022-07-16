package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager
{
    WebDriver wd;
    HelperUser helperUser;
    HelperCar car;

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public void init()
    {
        wd = new FirefoxDriver();
        logger.info("All test run in firefox browser");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wd.navigate().to("https://ilcarro-1578153671498.web.app/search");
        logger.info("current url ---->"+ wd.getCurrentUrl());
        helperUser = new HelperUser(wd);
        car = new HelperCar(wd);
    }

    public void stop()
    {
        //wd.quit();
    }

    public HelperUser getHelperUser()
    {
        return helperUser;
    }

    public HelperCar car() {
        return car;
    }

}
