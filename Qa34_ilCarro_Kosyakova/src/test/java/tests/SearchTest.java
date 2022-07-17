package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @Test
    public void searchCurrentMonth()
    {
        app.search().searchCurrentMonth("Tel Aviv","7/25/2022","7/31/2022");
        app.search().submit();
    //    Assert.assertTrue(app.search().isListOfCarsAppeared());
    }

    @Test
    public void searchCurrentYear()
    {
        app.search().searchCurrentYear("Tel Aviv","8/10/2022","10/20/22");
    }
}
