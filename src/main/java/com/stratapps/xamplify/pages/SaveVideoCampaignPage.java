package com.stratapps.xamplify.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class SaveVideoCampaignPage {

    private WebDriver driver;

    public SaveVideoCampaignPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By testMailBtn = By.xpath("//div[@id='launch-section']/div/div/fieldset/div/div[2]/button[2]/span");
    private By emailInput = By.xpath("//input[@placeholder='Please Enter Email Address']");
    private By emailSubjectInput = By.xpath("//input[@placeholder='Please Enter Email Subject']");
    private By sendTestBtn = By.xpath("//span[normalize-space()='Send Test']");
    private By okBtn = By.xpath("//button[normalize-space()='OK']");

    private By saveClickBtn = By.xpath("//*[@id='launch-section']/div/div/fieldset/div/div[2]/button[3]/span");

    private By spamCheckBtn = By.xpath("//*[@id='launch-section']/div/div/fieldset/div/div[2]/button[4]");
    private By saveInsideSpamCheckBtn = By.xpath("//*[@id='email_spam_check']/div/div/div[2]/app-email-spam-check/div[1]/button/span");
    private By refreshInsideSpamCheckBtn = By.xpath("//a[normalize-space()='Refresh']");
    private By spamCheckCloseBtn = By.xpath("(//a[contains(@class,'Btn-Gray')][normalize-space()='Close'])[2]");

    private By responseMessage = By.xpath("//span[@id='responseMessage']");
    private By Gotohome =By.xpath("//img[@class='cls-pointer']");
    // Clicks on "Test Mail" button
    public void clickTestMail() {
        WaitUtil.waitForElementVisible(driver, testMailBtn, 60);
        ElementUtil.click(testMailBtn, driver);
    }

    // Enters email and subject for test mail
    public void enterTestMailDetails(String email, String subject) {
        WaitUtil.waitForElementVisible(driver, emailInput, 60);
        ElementUtil.sendText(emailInput, email, driver);

        WaitUtil.waitForElementVisible(driver, emailSubjectInput, 60);
        ElementUtil.sendText(emailSubjectInput, subject, driver);
    }

    // Sends test mail
    public void sendTestMail() {
        WaitUtil.waitForElementVisible(driver, sendTestBtn, 60);
        ElementUtil.click(sendTestBtn, driver);

        WaitUtil.waitForElementVisible(driver, okBtn, 60);
        ElementUtil.click(okBtn, driver);
    }

    // Runs spam check
    public void runSpamCheck() {
        WaitUtil.waitForElementVisible(driver, spamCheckBtn, 60);
        ElementUtil.click(spamCheckBtn, driver);

		/*
		 * WaitUtil.waitForElementVisible(driver, saveInsideSpamCheckBtn, 60);
		 * ElementUtil.click(saveInsideSpamCheckBtn, driver);
		 * 
		 * WaitUtil.waitForElementVisible(driver, refreshInsideSpamCheckBtn, 60);
		 * WaitUtil.waitAndClick(driver, refreshInsideSpamCheckBtn, 120);
		 */

        WaitUtil.waitForElementVisible(driver, spamCheckCloseBtn, 60);
        ElementUtil.click(spamCheckCloseBtn, driver);
    }

    // Saves the video campaign
    public void saveCampaign() {
        WaitUtil.waitForElementVisible(driver, saveClickBtn, 60);
        ElementUtil.click(saveClickBtn, driver);
    }

    // Gets the response message
    public String getResponseMessage() {
        WaitUtil.waitForElementVisible(driver, responseMessage, 60);
        return ElementUtil.getText(responseMessage, driver);
    }
    public void backToHome() {
        WaitUtil.waitAndClick(driver, Gotohome, 60);
    }

    // Full flow: Test mail -> Spam check -> Save campaign
    public void saveVideoCampaign(String email, String subject) {
        clickTestMail();
        enterTestMailDetails(email, subject);
        sendTestMail();
        runSpamCheck();
        saveCampaign();
        getResponseMessage();
        backToHome();

		/*
		 * String actualMessage = getResponseMessage(); String expectedMessage =
		 * "Campaign saved successfully"; return expectedMessage.equals(actualMessage);
		 */
    }
}
