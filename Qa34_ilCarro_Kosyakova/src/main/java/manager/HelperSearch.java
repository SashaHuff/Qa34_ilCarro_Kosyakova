package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
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
            clickByNextMonth(diff);
            click(By.xpath(locatorFrom));
        }

        if (diff == 0) {
            click(By.xpath(locatorFrom));
        }

        if (diff2 > 0) {
            clickByNextMonth(diff2);
            click(By.xpath(locatorTo));
        } else {
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

    // new method
    public void clickByNextMonth(int count) {
        for (int i = 0; i < count; i++) {
            click(By.cssSelector("button[aria-label='Next month'"));
        }

    }

    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.cssSelector(".cars-container.ng-star-inserted"));
    }

    public boolean isPageResultAppeared() {
        String currentURL = wd.getCurrentUrl();
        System.out.println(currentURL);
        // we can use String.contains
        return currentURL.startsWith("https://ilcarro-1578153671498.web.app/search/results");
    }

    public void returnToSearch() {
        click(By.cssSelector("a[href='/search']"));
    }
    public void selectPeriodInNextMonth(String dataFrom, String dataTo){
        click(By.id("dates"));
        click(By.cssSelector("button[aria-label='Next month'"));

        String[] fromData = stringToArray(dataFrom);
        String locatorFrom = "//div[text()=' " + fromData[1] + " ']";
        click(By.xpath(locatorFrom));

        String[] toData = stringToArray(dataTo);
        String locatorTo = "//div[text()=' " + toData[1] + " ']";
        click(By.xpath(locatorTo));
    }
    public void searchNextMonth(String city, String dataFrom, String dataTo) {
        typeCity(city);
        selectPeriodInNextMonth(dataFrom, dataTo);

    }

    public void searchCurrentYearLocalDate(String city,String dataFrom, String dataTo) {
        typeCity(city);
        LocalDate now = LocalDate.now();
        LocalDate from = LocalDate.parse(dataFrom,DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dataTo,DateTimeFormatter.ofPattern("M/d/yyyy"));
        click(By.id("dates"));
        if (now.getMonthValue()!=from.getMonthValue()){
            int count = from.getMonthValue() - now.getMonthValue();
            clickByNextMonth(count);
        }
        String locator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(locator));
        if (from.getMonthValue()!=to.getMonthValue()){
            int count = to.getMonthValue() - from.getMonthValue();
            clickByNextMonth(count);
        }
        locator = String.format("//div[text()=' %s ']",to.getDayOfMonth());
        click(By.xpath(locator));
    }
    public void searchAnyPeriodLocalDate2(String city, String dataFrom, String dataTo) {
        typeCity(city);
        LocalDate now = LocalDate.now();
        LocalDate from= LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dataTo,DateTimeFormatter.ofPattern("M/d/yyyy"));
        click(By.id("dates"));

        int diffMonth = from.getYear()-now.getYear()
                ==0 ? from.getMonthValue() -now.getMonthValue() : 12-now.getMonthValue()+ from.getMonthValue();

        clickByNextMonth(diffMonth);
        String locator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(locator));

        diffMonth= to.getYear()-from.getYear()
                ==0  ?to.getMonthValue()-from.getMonthValue(): 12-from.getMonthValue()+to.getMonthValue();

        clickByNextMonth(diffMonth);
        locator=String.format("//div[text()=' %s ']",to.getDayOfMonth());
        click(By.xpath(locator));
    }


    public void searchAnyPeriodLocalDate(String city, String dataFrom, String dataTo) {
        typeCity(city);
        LocalDate now = LocalDate.now();
        LocalDate from= LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dataTo,DateTimeFormatter.ofPattern("M/d/yyyy"));
        click(By.id("dates"));
        // "8/10/2022", "3/20/2023"
        int diffYear;
        int diffMonth;

        diffYear=from.getYear()-now.getYear();
        if(diffYear==0){
            diffMonth= from.getMonthValue()-now.getMonthValue(); /// 8-7 =1
        }else {
            diffMonth= 12-now.getMonthValue()+from.getMonthValue(); //12-7+3
        }
        clickByNextMonth(diffMonth);
        String locator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(locator));

        ///**************
        diffYear=to.getYear()-from.getYear();

        if(diffYear==0){
            diffMonth = to.getMonthValue()-from.getMonthValue();
        }else {
            diffMonth= 12-from.getMonthValue()+to.getMonthValue();
        }
        clickByNextMonth(diffMonth);
        locator=String.format("//div[text()=' %s ']",to.getDayOfMonth());
        click(By.xpath(locator));


    }
    public void searchPeriodInPast(String city, String dataFrom, String dataTo) {
        typeCity(city);
        selectPeriodInPast(dataFrom,dataTo);

    }
    public String checkSystem(){
        String os = System.getProperty("os.name");
        return os;
    }

    public void clearData(){
        WebElement elData = wd.findElement(By.id("dates"));
        checkSystem();
        if (checkSystem().contains("Win"))
        {
            click(By.id("dates"));
            elData.sendKeys(Keys.chord(Keys.CONTROL,"a"));
            elData.sendKeys(Keys.DELETE);
        }
        if (checkSystem().contains("Mac"))
        {

            click(By.id("dates"));
            elData.sendKeys(Keys.chord(Keys.COMMAND,"a"));
            elData.sendKeys(Keys.DELETE);
        }
    }
    public void selectPeriodInPast(String dataFrom, String dataTo) {

        WebElement el = wd.findElement(By.id("dates"));
        clearData();
        el.sendKeys(dataFrom);
        el.sendKeys("-");
        el.sendKeys(dataTo);

    }

    public boolean buttonIsDisabled() {
        boolean disabled = isElementPresent(By.cssSelector("button[disabled]"));
        boolean enabled = wd.findElement(By.cssSelector("[type=submit]")).isEnabled();
        return disabled&&!enabled;
    }
    //
    public boolean isDataErrorDisplayed() {
        System.out.println(wd.findElement(By.cssSelector("div.error div:first-child")).getText());
        return new WebDriverWait(wd, Duration.ofSeconds(5)).until(ExpectedConditions
                .textToBePresentInElement(wd.findElement(By.cssSelector("div.error div:first-child"))
                        , "You can't pick date before today"));
    }

}
