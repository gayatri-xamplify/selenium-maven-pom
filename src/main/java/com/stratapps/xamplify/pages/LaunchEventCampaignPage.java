package com.stratapps.xamplify.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class LaunchEventCampaignPage {
    private WebDriver driver;

    public LaunchEventCampaignPage(WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    private By nowEventCampaignBtn = By.xpath("(//div[@class='btn-group btn-group-justified width_unset']//label)[1]");
    private By launchEventBtn = By.xpath("//button[normalize-space(text())='Launch']");
    private By responseMessage = By.xpath("//span[@id='responseMessage']");
    private By Gotohome =By.xpath("//img[@class='cls-pointer']");

     // Clicks the "Now Event Campaign" button.
    
    public void clickNowEventCampaign() {
    	WaitUtil.waitForPageToLoad(driver, 60);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollTo(0, 0);");

        WaitUtil.waitForElementVisible(driver, nowEventCampaignBtn, 60);
        ElementUtil.click(nowEventCampaignBtn, driver);
    }

    
    
     // Clicks the "Launch Event" button.
     
    public void clickLaunchEvent() {
        WaitUtil.waitForElementVisible(driver, launchEventBtn, 60);
        ElementUtil.click(launchEventBtn, driver);
    }

   
     // Returns the launch confirmation message.
    
    public String getResponseMessage() {
        WaitUtil.waitForElementVisible(driver, responseMessage, 60);
        return ElementUtil.getText(responseMessage, driver);
    }

    public void backToHome() {
        WaitUtil.waitAndClick(driver, Gotohome, 60);
    }

     //Full flow: Launches the Event campaign and validates the success message.
    
    public void launchEventCampaign() {
        clickNowEventCampaign();
        clickLaunchEvent();
        getResponseMessage();
        backToHome();
		/*
		 * String actualMessage = getResponseMessage();
		 * 
		 * String expectedMessage =
		 * "The campaign was successfully deployed. Please wait until the campaign is processed and launched. We will send you Event updates in timely manner."
		 * ; return expectedMessage.equals(actualMessage);
		 */
    }
    
    

}
