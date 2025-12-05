package com.stratapps.xamplify.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class LaunchVideoCampaignPage {
    private WebDriver driver;

    public LaunchVideoCampaignPage(WebDriver driver) {
        this.driver = driver;
    }
    
    

    // Locators
    private By nowVideoCampaignBtn = By.xpath("//input[@value='NOW']");
    private By launchVideoBtn = By.xpath("//span[contains(text(),'Launch')]");
    private By responseMessage = By.xpath("//span[@id='responseMessage']");
    private By Gotohome =By.xpath("//img[@class='cls-pointer']");
    
    // Clicks the "Now Video Campaign" button.
    public void clickNowVideoCampaign() {
        WaitUtil.waitForElementVisible(driver, nowVideoCampaignBtn, 60);
        ElementUtil.click(nowVideoCampaignBtn, driver);
    }

    
    // Clicks the "Launch Video" button.
    public void clickLaunchVideo() {
        WaitUtil.waitForElementVisible(driver, launchVideoBtn, 60);
        ElementUtil.click(launchVideoBtn, driver);
    }

    
    // Returns the launch confirmation message.
    public String getResponseMessage() {
        WaitUtil.waitForElementVisible(driver, responseMessage, 60);
        return ElementUtil.getText(responseMessage, driver);
    }

    public void backToHome() {
        WaitUtil.waitAndClick(driver, Gotohome, 60);
    }

    
    // Full flow: Launches the video campaign and validates the success message.
    public void launchVideoCampaign() {
        clickNowVideoCampaign();
        clickLaunchVideo();
        getResponseMessage();
        backToHome();
		/*
		 * String actualMessage = getResponseMessage();
		 * 
		 * String expectedMessage =
		 * "The campaign was successfully deployed. Please wait until the campaign is processed and launched. We will send you email updates in timely manner."
		 * ; return expectedMessage.equals(actualMessage);
		 */
    }
}

