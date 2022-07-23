package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @BeforeMethod
    public void returnToSearch()
    {
        app.search().returnToSearch();

    }

    @Test
    public void searchCurrentMonth()
    {
        app.search().searchCurrentMonth("Tel Aviv","7/28/2022","7/31/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }

    @Test
    public void searchCurrentYear()
    {
        app.search().searchCurrentYear("Jerusalem","10/28/2022","12/10/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        Assert.assertTrue(app.search().isPageResultAppeared());
    }
    @Test
    public void searchPeriodPast()
    {
        app.search().searchPeriodInPast("Haifa","7/8/2022","7/10/2022");
        Assert.assertTrue(app.search().buttonIsDisabled());
        Assert.assertTrue(app.search().isDataErrorDisplayed());

    }
    @Test
    public void searchNextMonth(){
        app.search().searchNextMonth("Haifa","8/8/2022","8/20/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }
   @Test
    public void searchCurrentYearLocalDate(){
        app.search().searchCurrentYearLocalDate("Haifa","8/10/2022","10/20/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }

/*
    @Test
    public void searchAnyPeriod(){
        app.search().searchAnyPeriodLocalDate2("Haifa", "6/10/2023", "7/15/2023");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());

    }

 */

}
