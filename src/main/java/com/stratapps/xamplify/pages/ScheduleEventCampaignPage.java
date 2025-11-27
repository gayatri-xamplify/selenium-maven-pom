package com.stratapps.xamplify.pages;

import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class ScheduleEventCampaignPage {
	private WebDriver driver;

	public ScheduleEventCampaignPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By scheduleEventCampaignBtn = By
			.xpath("//label[contains(@class,'btn btn-warning button-border Sch-class')]//input[contains(@name,'scheduleCampaign')]");
	private By selectDateInput = By.xpath("//input[@id='launchTimeInString']");
	private By selectCountryDropdown = By.xpath("//select[@id='countryName']");
	private By scheduleLaunchBtn = By.xpath("//button[normalize-space()='Schedule']");
	private By todayDate = By.xpath("//div[contains(@class,'open')]//span[@class='flatpickr-day today']");
	private By scheduleHour = By.xpath("//div[contains(@class,'open')]//input[@class='numInput flatpickr-hour']");
	private By scheduleMinute = By.xpath("//div[contains(@class,'open')]//input[@class='numInput flatpickr-minute']");
	private By responseMessage = By.xpath("//span[@id='responseMessage']");
	private By Gotohome = By.xpath("//img[@class='cls-pointer']");

	public void clickScheduleEventCampaign() {
		WaitUtil.waitForPageToLoad(driver, 60);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollTo(0, 0);");
		WaitUtil.waitForElementVisible(driver, scheduleEventCampaignBtn, 60);
		ElementUtil.click(scheduleEventCampaignBtn, driver);
	}

	// Opens the date picker for scheduling.

	public void openDatePicker() {
		WaitUtil.waitForElementVisible(driver, selectDateInput, 60);
		ElementUtil.click(selectDateInput, driver);
	}

	
	// Selects today's date in the date picker.

	public void selectTodayDate() {
		WaitUtil.waitForElementVisible(driver, todayDate, 60);
		ElementUtil.click(todayDate, driver);
	}

	// Sets the hour and minute for schedule.

	public void setScheduleTime(String hour, String minute) {
		WaitUtil.waitForElementVisible(driver, scheduleHour, 60);
		ElementUtil.sendText(scheduleHour, hour, driver);

		WaitUtil.waitForElementVisible(driver, scheduleMinute, 60);
		ElementUtil.sendText(scheduleMinute, minute, driver);
	}

	// Dynamically selects time based on current system time (AM/PM logic).

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

		System.out.println("Scheduling Event at -> Hour: " + hourToSet + " Minute: " + minuteToSet);
		setScheduleTime(hourToSet, minuteToSet);
	}

	// Selects a country from the dropdown.

	public void selectCountry(String countryName) {
		WaitUtil.waitForElementVisible(driver, selectCountryDropdown, 60);
		ElementUtil.selectDropdownByVisibleText(selectCountryDropdown, countryName, driver);
		// wait for page to load after selection
		WaitUtil.waitForPageToLoad(driver, 60);
	}

	// Clicks the "Schedule Launch" button.

	public void clickScheduleLaunch() throws InterruptedException {
		WaitUtil.waitForPageToLoad(driver, 60);
		Thread.sleep(2000); // Adding a brief wait to ensure stability
		WaitUtil.waitForElementVisible(driver, scheduleLaunchBtn, 60);
		WaitUtil.waitAndClick(driver, scheduleLaunchBtn, 90);
		// ElementUtil.click(scheduleLaunchBtn, driver);
	}

	// Returns the schedule confirmation message.

	public String getResponseMessage() {
		WaitUtil.waitForElementVisible(driver, responseMessage, 60);
		return ElementUtil.getText(responseMessage, driver);
	}

	// Full flow: Schedules the Event campaign using dynamic time and validates
	// success message.
	public void backToHome() {
		WaitUtil.waitAndClick(driver, Gotohome, 60);
	}

	public void scheduleEventCampaign(String countryName) throws InterruptedException {
		clickScheduleEventCampaign();
		openDatePicker();
		selectTodayDate();
		setDynamicScheduleTime(); // <-- New Dynamic Time logic
		selectCountry(countryName);
		clickScheduleLaunch();
		getResponseMessage();
		backToHome();

		/*
		 * String actualMessage = getResponseMessage(); String expectedMessage =
		 * "The campaign was successfully scheduled. Please wait until the scheduled time to see it launched."
		 * ; return expectedMessage.equals(actualMessage);
		 */
	}
}
