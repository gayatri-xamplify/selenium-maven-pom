package com.stratapps.xamplify.pages;

import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class ScheduleVideoCampaignPage {
    private WebDriver driver;

    public ScheduleVideoCampaignPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By scheduleVideoCampaignBtn = By.xpath("(//span[normalize-space()='Schedule'])[1]");
    private By selectDateInput = By.xpath("//input[@id='launchTime']");
    private By todayDate = By.xpath("//div[contains(@class,'open')]//span[@class='flatpickr-day today']");
    private By scheduleHour = By.xpath("//div[contains(@class,'open')]//input[@class='numInput flatpickr-hour']");
    private By scheduleMinute = By.xpath("//div[contains(@class,'open')]//input[@class='numInput flatpickr-minute']");
    private By selectCountryDropdown = By.xpath("//select[@id='countryName']");
    private By scheduleLaunchBtn = By.xpath("(//span[contains(text(),'Schedule')])[2]");
    private By responseMessage = By.xpath("//span[@id='responseMessage']");

    // Clicks the "Schedule Video Campaign" button
    public void clickScheduleVideoCampaign() {
        WaitUtil.waitForElementVisible(driver, scheduleVideoCampaignBtn, 60);
        ElementUtil.click(scheduleVideoCampaignBtn, driver);
    }

    // Opens the date picker
    public void openDatePicker() {
        WaitUtil.waitForElementVisible(driver, selectDateInput, 60);
        ElementUtil.click(selectDateInput, driver);
    }

    // Selects today's date
    public void selectTodayDate() {
        WaitUtil.waitForElementVisible(driver, todayDate, 60);
        ElementUtil.click(todayDate, driver);
    }

    // Sets the hour and minute manually
    public void setScheduleTime(String hour, String minute) {
        WaitUtil.waitForElementVisible(driver, scheduleHour, 60);
        ElementUtil.sendText(scheduleHour, hour, driver);

        WaitUtil.waitForElementVisible(driver, scheduleMinute, 60);
        ElementUtil.sendText(scheduleMinute, minute, driver);
    }

    // Dynamically picks schedule time based on current system hour (AM/PM)
    public void setDynamicScheduleTime() {
        Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR_OF_DAY);

        String hourToSet, minuteToSet;
        if (hours < 12) {
            hourToSet = "1";
            minuteToSet = "11";
        } else {
            hourToSet = "11";
            minuteToSet = "59";
        }

        System.out.println("Scheduling Video at -> Hour: " + hourToSet + " Minute: " + minuteToSet);
        setScheduleTime(hourToSet, minuteToSet);
    }

    // Selects country
    public void selectCountry(String countryName) {
        WaitUtil.waitForElementVisible(driver, selectCountryDropdown, 60);
        ElementUtil.selectDropdownByVisibleText(selectCountryDropdown, countryName, driver);
        WaitUtil.waitForPageToLoad(driver, 60);
    }

    // Clicks the "Schedule Launch" button
    public void clickScheduleLaunch() {
        WaitUtil.waitForPageToLoad(driver, 60);
        WaitUtil.waitForElementVisible(driver, scheduleLaunchBtn, 60);
        WaitUtil.waitAndClick(driver, scheduleLaunchBtn, 90);
    }

    // Returns response message
    public String getResponseMessage() {
        WaitUtil.waitForElementVisible(driver, responseMessage, 60);
        return ElementUtil.getText(responseMessage, driver);
    }

    // Full flow: Schedule video campaign
    public boolean scheduleVideoCampaign(String countryName) {
        clickScheduleVideoCampaign();
        openDatePicker();
        selectTodayDate();
        setDynamicScheduleTime();
        selectCountry(countryName);
        clickScheduleLaunch();
        String actualMessage = getResponseMessage();
        String expectedMessage = "The campaign was successfully scheduled. Please wait until the scheduled time to see it launched.";
        return expectedMessage.equals(actualMessage);
    }
}
