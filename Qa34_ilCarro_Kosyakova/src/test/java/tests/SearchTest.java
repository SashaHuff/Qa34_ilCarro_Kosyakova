package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{



    @Test
    public void searchCurrentMonth()
    {
        app.search().searchCurrentMonth("Tel Aviv","7/28/2022","7/31/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        app.search().takeScreenshots("C:\\Users\\alexa\\Documents\\GitHub\\Qa34_ilCarro_Kosyakova\\Qa34_ilCarro_Kosyakova\\src\\test\\screenshots/screenCurrentMonth.png");
    }

    @Test
    public void searchCurrentYear()
    {
        app.search().searchCurrentYear("Jerusalem","10/28/2022","12/10/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        Assert.assertTrue(app.search().isPageResultAppeared());
        app.search().takeScreenshots("C:\\Users\\alexa\\Documents\\GitHub\\Qa34_ilCarro_Kosyakova\\Qa34_ilCarro_Kosyakova\\src\\test\\screenshots/screenCurrentYear.png");

    }
    @Test
    public void searchPeriodPast()
    {
        app.search().searchPeriodInPast("Jerusalem","7/8/2022","7/10/2022");
        app.search().submitWithoutWait();
        Assert.assertTrue(app.search().isYallaButtonNotActive());
        Assert.assertTrue(app.search().isDataErrorDisplayed());
        app.search().takeScreenshots("C:\\Users\\alexa\\Documents\\GitHub\\Qa34_ilCarro_Kosyakova\\Qa34_ilCarro_Kosyakova\\src\\test\\screenshots/screenPeriodPast.png");


    }
    @Test
    public void searchNextMonth(){
        app.search().searchNextMonth("Jerusalem","8/8/2022","8/20/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        app.search().takeScreenshots("C:\\Users\\alexa\\Documents\\GitHub\\Qa34_ilCarro_Kosyakova\\Qa34_ilCarro_Kosyakova\\src\\test\\screenshots/screenNextMonth.png");

    }
   @Test
    public void searchCurrentYearLocalDate(){
        app.search().searchCurrentYearLocalDate("Tel-Aviv","8/10/2022","10/20/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
       app.search().takeScreenshots("C:\\Users\\alexa\\Documents\\GitHub\\Qa34_ilCarro_Kosyakova\\Qa34_ilCarro_Kosyakova\\src\\test\\screenshots/screensearchCurrentYearLocalDate.png");

   }


    @Test
    public void searchAnyPeriod(){
        app.search().searchAnyPeriodLocalDate2("Haifa", "6/10/2023", "7/15/2023");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        app.search().takeScreenshots("C:\\Users\\alexa\\Documents\\GitHub\\Qa34_ilCarro_Kosyakova\\Qa34_ilCarro_Kosyakova\\src\\test\\screenshots/screensearchAnyPeriod.png");


    }

    @AfterMethod
    public void returnToSearch()
    {
                app.search().returnToSearch();
        }
}


