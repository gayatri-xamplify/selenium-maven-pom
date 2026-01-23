package com.stratapps.xamplify.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class SaveEventCampaignPage {

	private WebDriver driver;

	public SaveEventCampaignPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By testMailBtn = By.xpath("//div[@id='launch-section']/div/div/fieldset/div/div[2]/button[2]/span");
	private By EventInput = By.xpath("//input[@placeholder='Please Enter Event Address']");
	private By EventSubjectInput = By.xpath("//input[@placeholder='Please Enter Event Subject']");
	private By sendTestBtn = By.xpath("//div[@id='send-test-Event-modal-popup']/div/div/div[3]/button[2]/span");
	private By okBtn = By.xpath("//button[contains(text(),'OK')]");
	private By spamCheckBtn = By
			.xpath("//span[@class='btn Btn-Green transition txt_pd-top3'][contains(text(),'Spam')]");
	private By saveInsideSpamCheckBtn = By
			.xpath("//span[contains(@class,'btn btn-primary transition txt_pd-top3')][contains(text(),'Spam')]");
	private By refreshInsideSpamCheckBtn = By.xpath("//a[normalize-space()='Refresh']");
	private By spamCheckCloseBtn = By.xpath(
			"//div[@class='modal-dialog modal-lg modal-template mEventSpamPopUp']//a[@class='Btn-Gray'][normalize-space()='Close']");
	private By saveClickBtn = By
			.xpath("//span[contains(@class,'btn Btn-Green transition txt_pd-top3')][normalize-space()='Save']");
	private By saveBtn = By.xpath(
			"/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[1]/app-create-campaign[1]/div[1]/div[1]/div[2]/div[1]/div[6]/form[1]/div[3]/div[1]/div[2]/div[1]/button[3]");
	private By responseMessage = By.xpath("//span[@id='responseMessage']");
	private By Gotohome = By.xpath("//img[@class='cls-pointer']");

	// Clicks on "Test Mail" button

//	public void clickTestMail() {
//		WaitUtil.waitForPageToLoad(driver, 60);
//    	JavascriptExecutor js = (JavascriptExecutor) driver;
//    	js.executeScript("window.scrollTo(0, 0);");
//		WaitUtil.waitForElementVisible(driver, testMailBtn, 60);
//		ElementUtil.click(testMailBtn, driver);
//	}
//
//	
//	 // Enters Event and subject for test mail
//	 
//	public void enterTestMailDetails(String Event, String subject) {
//		WaitUtil.waitForElementVisible(driver, EventInput, 60);
//		ElementUtil.sendText(EventInput, Event, driver);
//
//		WaitUtil.waitForElementVisible(driver, EventSubjectInput, 60);
//		ElementUtil.sendText(EventSubjectInput, subject, driver);
//	}
//
//
//	 // Sends test mail
//	
//	public void sendTestMail() {
//		WaitUtil.waitForElementVisible(driver, sendTestBtn, 60);
//		ElementUtil.click(sendTestBtn, driver);
//
//		WaitUtil.waitForElementVisible(driver, okBtn, 60);
//		ElementUtil.click(okBtn, driver);
//	}

	// Runs spam check

	public void runSpamCheck() {
		WaitUtil.waitForPageToLoad(driver, 60);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
		WaitUtil.waitForElementVisible(driver, spamCheckBtn, 60);
		ElementUtil.click(spamCheckBtn, driver);

		/*
		 * WaitUtil.waitForElementVisible(driver, saveInsideSpamCheckBtn, 60);
		 * ElementUtil.click(saveInsideSpamCheckBtn, driver);
		 * 
		 * WaitUtil.waitForElementVisible(driver, refreshInsideSpamCheckBtn, 60);
		 * WaitUtil.waitAndClick(driver, refreshInsideSpamCheckBtn, 90);
		 */

		WaitUtil.waitForElementVisible(driver, spamCheckCloseBtn, 60);
		ElementUtil.click(spamCheckCloseBtn, driver);
	}

	// Saves the Event campaign

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

	public void saveEventCampaign(String Event, String subject) {

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
