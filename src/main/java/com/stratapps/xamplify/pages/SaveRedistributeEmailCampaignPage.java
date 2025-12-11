package com.stratapps.xamplify.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.stratapps.xamplify.utils.WaitUtil;
import com.stratapps.xamplify.utils.ElementUtil;

public class SaveRedistributeEmailCampaignPage {

    private WebDriver driver;

    public SaveRedistributeEmailCampaignPage(WebDriver driver) {
        this.driver = driver;
    }

    // ============================
    //          LOCATORS
    // ============================
    private By testMailBtn = By.xpath("(//button[@class='btn btn-primary'])[1]");
    private By emailInput = By.xpath("//input[@placeholder='Please Enter Email Address']");
    private By submitBtn = By.xpath("//div[@id='send-test-email-modal-popup']/div/div/div[3]/button[2]/span");
    private By okBtn = By.xpath("//button[contains(text(),'OK')]");
    private By saveBtn = By.xpath("(//button[contains(text(),'Save')])");
    private By responseMsg = By.xpath("//span[@id='responseMessage']");
    private By backdrop = By.cssSelector("div.backdrop");
    private By Gotohome =By.xpath("//img[@class='cls-pointer']");
    // ============================
    //   ONE SINGLE COMPLETE FLOW
    // ============================

    /**
     *  Complete flow:
     *  1️⃣ Click Test Mail
     *  2️⃣ Enter recipient email  
     *  3️⃣ Submit  
     *  4️⃣ Click OK  
     *  5️⃣ Click Save  
     *  6️⃣ Validate success message  
     */
    public boolean saveRedistributedCampaign(String email) {
    	WaitUtil.waitForPageToLoad(driver, 30);
   	 JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);"); // scrolls 500px down
        WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
        // Step 1: Click Test Mail
        WaitUtil.waitAndClick(driver, testMailBtn, 40);

        // Step 2: Enter email
    	WaitUtil.waitForElementVisible(driver, emailInput, 60);
		ElementUtil.sendText(emailInput, email, driver);

        // Step 3: Click SUBMIT
        WaitUtil.waitAndClick(driver, submitBtn, 40);

        // Step 4: Click OK
        WaitUtil.waitAndClick(driver, okBtn, 40);

        // Step 5: Save Campaign
        WaitUtil.waitAndClick(driver, saveBtn, 40);

        // Step 6: Validate Response Message
        String actual = WaitUtil.waitForElementVisible(driver, responseMsg, 40).getText();
        String expected = "Campaign saved successfully";

        return actual.equalsIgnoreCase(expected);
    }
    
  
}
