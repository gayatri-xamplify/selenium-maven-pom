package com.stratapps.xamplify.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class LaunchEmailCampaignPage {
    private WebDriver driver;

    public LaunchEmailCampaignPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By nowEmailCampaignBtn = By.xpath("(//div[@class='btn-group btn-group-justified']//label)[1]");
    private By launchEmailBtn = By.xpath("//span[normalize-space(text())='Launch']");
    private By responseMessage = By.xpath("//span[@id='responseMessage']");

   
     // Clicks the "Now Email Campaign" button.
    
    public void clickNowEmailCampaign() {
        WaitUtil.waitForElementVisible(driver, nowEmailCampaignBtn, 60);
        ElementUtil.click(nowEmailCampaignBtn, driver);
    }

    
     // Clicks the "Launch Email" button.
     
    public void clickLaunchEmail() {
        WaitUtil.waitForElementVisible(driver, launchEmailBtn, 60);
        ElementUtil.click(launchEmailBtn, driver);
    }

   
     // Returns the launch confirmation message.
    
    public String getResponseMessage() {
        WaitUtil.waitForElementVisible(driver, responseMessage, 60);
        return ElementUtil.getText(responseMessage, driver);
    }

    
     //Full flow: Launches the email campaign and validates the success message.
    
    public boolean launchEmailCampaign() {
        clickNowEmailCampaign();
        clickLaunchEmail();
        String actualMessage = getResponseMessage();

        String expectedMessage = "The campaign was successfully deployed. Please wait until the campaign is processed and launched. We will send you email updates in timely manner.";
        return expectedMessage.equals(actualMessage);
    }
}
