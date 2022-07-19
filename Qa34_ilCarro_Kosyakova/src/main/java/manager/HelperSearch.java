package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelperSearch extends HelperBase {
    public HelperSearch(WebDriver wd) {
        super(wd);
    }


    public void searchCurrentMonth(String city, String dataFrom, String dataTo) {
        typeCity(city);
        selectPeriodOfCurrentMonth(dataFrom, dataTo);
    }

    private void selectPeriodOfCurrentMonth(String dataFrom, String dataTo) {
        click(By.id("dates"));
        String[] fromData = stringToArray(dataFrom);
        String locatorFrom = "//div[text()=' " + fromData[1] + " ']";
        click(By.xpath(locatorFrom));
        String[] toData = stringToArray(dataTo);
        String locatorTo = "//div[text()=' " + toData[1] + " ']";
        click(By.xpath(locatorTo));
      /*
      SECOND METHOD
      String locator2 = String.format("//div[text()=' %s ']",fromData[1]);

       */
    }

    private void typeCity(String city) {
        type(By.id("city"), city);
        pause(700);
        click(By.cssSelector(".pac-item"));


    }

    public void searchCurrentYear(String city, String dataFrom, String dataTo) {
        typeCity(city);
        selectPeriodCurrentYear(dataFrom, dataTo);

    }

    private void selectPeriodCurrentYear(String dataFrom, String dataTo) {
        String now = "07/25/2022";
        click(By.id("dates"));
        // locator to datetimepicker
        String locatorNextMonth = "button[aria-label='Next month'";
        // dates to arr
        String[] nowArr = stringToArray(now);
        String[] fromData = stringToArray(dataFrom);
        String[] toData = stringToArray(dataTo);
        //locators
        String locatorFrom = "//div[text()=' " + fromData[1] + " ']";
        String locatorTo = "//div[text()=' " + toData[1] + " ']";
        // convert string to int (Month)
        int dataNowMonth = stringToInt(nowArr[0]);
        int dataFromMonth = stringToInt(fromData[0]);
        int dataToMonth = stringToInt(toData[0]);
        // difference between dates now and fromTo
        int diff = dataFromMonth - dataNowMonth;
        int diff2 = dataToMonth - dataFromMonth;

        if (diff > 0) {
            for (int i = diff; i>0; i--) {
                click(By.cssSelector(locatorNextMonth));
            }
            click(By.xpath(locatorFrom));
        }
        if (diff==0){
            click(By.xpath(locatorFrom));
        }

        if (diff2 > 0) {
            for (int i = diff2; i>0; i--) {
                click(By.cssSelector(locatorNextMonth));
            }
            click(By.xpath(locatorTo));
        }
        else
        {
            click(By.xpath(locatorTo));
        }


    }


    private String[] stringToArray(String s) {
        String[] arr = s.split("/");
        return arr;
    }

    private int stringToInt(String a) {

        int b = Integer.parseInt(a);

        return b;
    }
}
