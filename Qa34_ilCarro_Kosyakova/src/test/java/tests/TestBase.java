package tests;

import manager.ApplicationManager;
import manager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.time.Duration;



public class TestBase
{
    Logger logger = LoggerFactory.getLogger(HelperBase.class);
    @BeforeMethod (alwaysRun = true)
    public void startLogger(Method m){
        logger.info("Start method with name --> " + m.getName());
    }
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.FIREFOX.browserName()));

    @BeforeSuite (alwaysRun = true)
    public void setUp()
    {
        app.init();
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown()
    {
        app.stop();
    }




}
