package com.stratapps.xamplify.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class SaveEmailCampaignPage {

	private WebDriver driver;

	public SaveEmailCampaignPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By saveOption = By.xpath("//*[@id=\"step-6\"]/form/div[3]/div/div[1]/div[1]/label[3]");
	private By testMailBtn = By.xpath("//div[@id='launch-section']/div/div/fieldset/div/div[2]/button[2]/span");
	private By emailInput = By.xpath("//input[@placeholder='Please Enter Email Address']");
	private By emailSubjectInput = By.xpath("//input[@placeholder='Please Enter Email Subject']");
	private By sendTestBtn = By.xpath("//div[@id='send-test-email-modal-popup']/div/div/div[3]/button[2]/span");
	private By okBtn = By.xpath("//button[contains(text(),'OK')]");
	private By spamCheckBtn = By.xpath("//div[@id='launch-section']/div/div/fieldset/div/div[2]/button[4]/span");
	private By saveInsideSpamCheckBtn = By
			.xpath("//div[@id='email_spam_check']/div/div/div[2]/app-email-spam-check/div[1]/button/span");
	private By refreshInsideSpamCheckBtn = By
			.xpath("(//a[@class='btn btn-success btn-xs'][contains (text (), 'Refresh')])");
	private By spamCheckCloseBtn = By.xpath("//*[@id='email_spam_check']/div/div/div[3]/a");
	private By saveClickBtn = By.xpath("//*[@id='launch-section']/div/div/fieldset/div/div[2]/button[3]/span");
	private By saveBtn = By.xpath(
			"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[2]/div[1]/button[3]");
	private By responseMessage = By.xpath("//span[@id='responseMessage']");

	
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

		WaitUtil.waitForElementVisible(driver, saveInsideSpamCheckBtn, 60);
		ElementUtil.click(saveInsideSpamCheckBtn, driver);

		WaitUtil.waitForElementVisible(driver, refreshInsideSpamCheckBtn, 60);
		WaitUtil.waitAndClick(driver, refreshInsideSpamCheckBtn, 90);

		WaitUtil.waitForElementVisible(driver, spamCheckCloseBtn, 60);
		ElementUtil.click(spamCheckCloseBtn, driver);
	}

	
	 // Saves the email campaign
	
	public void saveCampaign() {
		WaitUtil.waitForElementVisible(driver, saveClickBtn, 60);
		ElementUtil.click(saveClickBtn, driver);
	}


	 //Gets the response message
	 
	public String getResponseMessage() {
		WaitUtil.waitForElementVisible(driver, responseMessage, 60);
		return ElementUtil.getText(responseMessage, driver);
	}

	
	 // Full flow: Test mail -> Spam check -> Save campaign
	
	public void saveEmailCampaign(String email, String subject) {
		clickTestMail();
		enterTestMailDetails(email, subject);
		sendTestMail();
		runSpamCheck();
		saveCampaign();

		/*
		 * String actualMessage = getResponseMessage(); String expectedMessage =
		 * "Campaign saved successfully"; return expectedMessage.equals(actualMessage);
		 */
	}
}
