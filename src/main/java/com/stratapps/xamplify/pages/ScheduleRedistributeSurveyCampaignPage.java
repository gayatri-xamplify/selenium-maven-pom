package com.stratapps.xamplify.pages;

import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.stratapps.xamplify.utils.WaitUtil;
import com.stratapps.xamplify.utils.DropdownUtil;
import com.stratapps.xamplify.utils.ElementUtil;

public class ScheduleRedistributeSurveyCampaignPage {

    private WebDriver driver;

    public ScheduleRedistributeSurveyCampaignPage(WebDriver driver) {
        this.driver = driver;
    }

    // ================= Locators =================
    private By scheduleOption = By.xpath("(//span[contains(text(),'Schedule')])[1]");
    private By launchTimeInput = By.xpath("//input[@formcontrolname='launchTime']");
    private By todayDate = By.xpath("//div[contains(@class,'open')]//span[@class='flatpickr-day today']");
    private By hourInput = By.xpath("//div[contains(@class,'open')]//input[@class='numInput flatpickr-hour']");
    private By minuteInput = By.xpath("//div[contains(@class,'open')]//input[@class='numInput flatpickr-minute']");
    private By countrySelect = By.xpath("//*[@id='countryName']");
    private By scheduleBtn = By.xpath("(//button[contains(text(),'Schedule')])");
    private By responseMsg = By.xpath("//span[@id='responseMessage']");
	private By backdrop = By.cssSelector("div.backdrop");
    private By Gotohome =By.xpath("//img[@class='cls-pointer']");

    
    
    public boolean scheduleRedistributionSurvey(String countryValue) throws InterruptedException {
    	WaitUtil.waitForPageToLoad(driver, 30);
   	 JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);"); // scrolls 500px down
        WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
        // 1️⃣ Click Schedule Option
        WaitUtil.waitAndClick(driver, scheduleOption, 40);

     // 2️⃣ Open calendar and pick today
     		WaitUtil.waitAndClick(driver, launchTimeInput, 40);
     		Thread.sleep(500);
     		WaitUtil.waitAndClick(driver, todayDate, 40);
     		Thread.sleep(300);
     		// 3️⃣ Fill time
     		Calendar calendar = Calendar.getInstance();
     		int currentHr = calendar.get(Calendar.HOUR_OF_DAY);


             if (currentHr < 12) {

                 //ElementUtil.clear(hourInput, driver);
                 ElementUtil.sendText(hourInput, "1", driver);

                 //ElementUtil.clear(minuteInput, driver);
                 ElementUtil.sendText(minuteInput, "11", driver);

             } else {

                 //ElementUtil.clear(hourInput, driver);
                 ElementUtil.sendText(hourInput, "11", driver);

                // ElementUtil.clear(minuteInput, driver);
                 ElementUtil.sendText(minuteInput, "59", driver);
             }



     		
     		Thread.sleep(2000);
     		// 4️⃣ Select country
     		DropdownUtil.selectByValue(driver, countrySelect, countryValue);

     		Thread.sleep(2000);
     		// 5️⃣ Click Schedule button
     		WaitUtil.waitAndClick(driver, scheduleBtn, 40);

     		// 6️⃣ Validate message
     		String actual = WaitUtil.waitForElementVisible(driver, responseMsg, 50).getText();
     		String expected = "Campaign scheduled successfully";

     		return actual.equalsIgnoreCase(expected);
     	}

        
  
}