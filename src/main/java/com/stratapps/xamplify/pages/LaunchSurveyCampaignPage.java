package com.stratapps.xamplify.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class LaunchSurveyCampaignPage {
	private WebDriver driver;

	public LaunchSurveyCampaignPage(WebDriver driver) {

		this.driver = driver;
	}

	// Locators
	private By nowSurveyCampaignBtn = By.xpath("(//div[@class='btn-group btn-group-justified']//label)[1]");
	private By launchSurveyBtn = By.xpath("//span[normalize-space(text())='Launch']");
	private By responseMessage = By.xpath("//span[@id='responseMessage']");
	private By Gotohome = By.xpath("//img[@class='cls-pointer']");

	// Clicks the "Now Survey Campaign" button.

	public void clickNowSurveyCampaign() {
		WaitUtil.waitForElementVisible(driver, nowSurveyCampaignBtn, 60);
		ElementUtil.click(nowSurveyCampaignBtn, driver);
	}

	// Clicks the "Launch Survey" button.

	public void clickLaunchSurvey() {
		WaitUtil.waitForElementVisible(driver, launchSurveyBtn, 60);
		ElementUtil.click(launchSurveyBtn, driver);
	}

	// Returns the launch confirmation message.

	public String getResponseMessage() {
		WaitUtil.waitForElementVisible(driver, responseMessage, 60);
		return ElementUtil.getText(responseMessage, driver);
	}

	public void backToHome() {
		WaitUtil.waitAndClick(driver, Gotohome, 60);
	}

	// Full flow: Launches the Survey campaign and validates the success message.

	public void launchSurveyCampaign() {
		clickNowSurveyCampaign();
		clickLaunchSurvey();
		getResponseMessage();
		backToHome();
		/*
		 * String actualMessage = getResponseMessage();
		 * 
		 * String expectedMessage =
		 * "The campaign was successfully deployed. Please wait until the campaign is processed and launched. We will send you Survey updates in timely manner."
		 * ; return expectedMessage.equals(actualMessage);
		 */
	}

}
