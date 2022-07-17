package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd) {
        super(wd);
    }


    public void searchCurrentMonth(String city, String dataFrom, String dataTo) {
        typeCity(city);
        selectPeriodOfCurrentMonth(dataFrom,dataTo);
    }

    private void selectPeriodOfCurrentMonth(String dataFrom, String dataTo) {
        click(By.id("dates"));
        String [] fromData = dataFrom.split("/");
        String locatorFrom = "//div[text()=' "+fromData[1]+" ']";
        click(By.xpath(locatorFrom));
        String [] toData = dataTo.split("/");
        String locatorTo = "//div[text()=' "+toData[1]+" ']";
        click(By.xpath(locatorTo));
      /*
      SECOND METHOD
      String locator2 = String.format("//div[text()=' %s ']",fromData[1]);

       */
    }

    private void typeCity(String city) {
        type(By.id("city"),city);
        pause(700);
        click(By.cssSelector(".pac-item"));


    }

    public void searchCurrentYear(String city, String dataFrom, String dataTo) {
        typeCity(city);

    }
}
