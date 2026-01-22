package com.stratapps.xamplify.pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;
import com.stratapps.xamplify.utils.DropdownUtil;

public class EventCampaignPage {

	private WebDriver driver;

	public EventCampaignPage(WebDriver driver) {
		this.driver = driver;
	}

	// ==========================================
	// LOCATORS
	// ==========================================

	private By campaignHover = By.xpath("//span[@class='title'][contains(text(),'Campaign')]");
	private By createCampaign = By.xpath("//span[contains(@class,'title')][contains(text(),'Create Campaign')]");
	private By openEventCampaign = By.xpath("//h4[contains(text(),'Event')]");

	private By eventTitle = By.id("eventTitle");
	private By subjectLine = By.xpath("(//input[@id='subjectLine'])[2]");

	private By throughPartner = By.xpath("//span[@class='bootstrap-switch-handle-off bootstrap-switch-success']");
	private By publicToggle = By.xpath("//span[contains(text(),'Private')]");

	private By showForms = By.xpath("//span[normalize-space()='Show Forms']");
	private By formPreview = By.xpath("//tbody/tr[1]/td/a[1]/i");
	private By formPreviewClose = By.xpath("//div[@class='modal-dialog modal-lg']//i[@class='fa fa-times']");
	private By selectForm = By.xpath("//*[@id='forms-list']//table//tr[1]/td/input");
	private By closeFormList = By.xpath("//div[@id='forms-list']//button[@class='close-circle']");

	private By datePicker = By.xpath("//input[@id='startDatePicker']");
	private By selectDate = By.xpath(
			"//div[contains(@class,'open')]//span[contains(@class,'flatpickr-day today')]/following-sibling::span[2]");
	private By allDay = By.id("allDay");

	private By countryTimezone = By.xpath("(//div/div[1]/select)[5]");
	private By nextPage1 = By.xpath("//button[@title='Please Fill Campaign Details']");

	// Partner list page
	private By partnerSearch = By.xpath("//*[@id='step-4']//input");
	private By partnerCheckbox = By.xpath("//tr[1]//div[@class='form-group']//input");
	private By partnerPreview = By.xpath("//tbody/tr[1]/td[8]/a/i");
	private By closePartnerPreview = By.xpath("//*[@id='userListUsersPreviewPopup']//button");
	private By nextPage2 = By.xpath("//*[@id='step-4']//button[2]/span");

	// Template page
	private By templateSearch = By.xpath("//input[@placeholder='Search for a template']");
	private By templateSelect = By.xpath("//img[contains(@src,'email_templates')]/preceding::input[@type='radio'][1]");
	private By templatePreview = By.xpath(
			"//*[@id=\"event-tabs\"]/div[2]/div[1]/div[1]/div[2]/section/ul[1]/li/div/div/div/div/div/span[2]/a/i");
	private By templateHover = By.xpath("//div[@class='grid-box imgage-paddings template-selected-border']//img[contains(@class,'img-grid-track')]");
	private By templateEdit = By.xpath("//a/div/div/span");
	private By templateEditClose = By.xpath("//*[@id='edit-template']//a/i");
	private By nextPage3 = By.xpath(
			"//div[contains(@class,'button-group-align')]//span[contains(@class,'btn Btn-Green transition txt_pd-top3')][normalize-space()='Next']");

	private By backdrop = By.cssSelector(".backdrop");

	// ==========================================
	// EVENT CAMPAIGN MAIN CREATION FLOW
	// ==========================================
	public void createEventCampaign(String campaignName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		// 1️⃣ Hover → Create → Select Event Campaign
		WaitUtil.waitForElementVisible(driver, campaignHover, 60);
		ElementUtil.hoverAndClick(driver.findElement(campaignHover), driver);
		WaitUtil.waitAndClick(driver, createCampaign, 60);
		WaitUtil.waitAndClick(driver, openEventCampaign, 60);
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);

		// 2️⃣ Enter Event Title
		WebElement title = wait.until(ExpectedConditions.elementToBeClickable(eventTitle));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", title);
		((JavascriptExecutor) driver).executeScript("arguments[0].focus();", title);

		title.clear();
		title.sendKeys(campaignName + "_" + System.currentTimeMillis());

		// 3️⃣ Enter Subject Line
		ElementUtil.sendText(subjectLine, "Event Campaign Subject", driver);

		// 4️⃣ Toggle Through Partner
		try {
			ElementUtil.click(throughPartner, driver);
		} catch (ElementClickInterceptedException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(throughPartner));
		}

		Thread.sleep(2000);
		// Toggle Public/Private
		ElementUtil.click(publicToggle, driver);

		// 5️⃣ Forms – Show → Preview → Select
		WaitUtil.waitAndClick(driver, showForms, 60);
		WaitUtil.waitAndClick(driver, formPreview, 60);
		WaitUtil.waitAndClick(driver, formPreviewClose, 60);
		WaitUtil.waitAndClick(driver, selectForm, 60);
		WaitUtil.waitAndClick(driver, closeFormList, 60);

		// 6️⃣ Date Selection
		WaitUtil.waitAndClick(driver, datePicker, 60);
		WaitUtil.waitAndClick(driver, selectDate, 60);
		ElementUtil.click(allDay, driver);

		// 7️⃣ Timezone
		Select select = new Select(driver.findElement(countryTimezone));
		select.selectByValue("103"); // India

		// 8️⃣ Next
		WaitUtil.waitAndClick(driver, nextPage1, 60);
	}

	// ==========================================
	// PARTNER LIST PAGE
	// ==========================================
	public void selectPartnerList() throws Exception {

		Thread.sleep(3000); // wait for page load
		WaitUtil.waitForVisibility(driver, partnerSearch, 60);
		ElementUtil.sendText(partnerSearch, "Active", driver);
		ElementUtil.sendKey(partnerSearch, Keys.ENTER, driver);

		WaitUtil.waitAndClick(driver, partnerCheckbox, 60);

		WaitUtil.waitAndClick(driver, partnerPreview, 60);
		WaitUtil.waitAndClick(driver, closePartnerPreview, 60);

		WaitUtil.waitAndClick(driver, nextPage2, 60);
	}

	// ==========================================
	// TEMPLATE SELECTION PAGE
	// ==========================================

	public void selectTemplate() throws Exception {

		// search template
		WaitUtil.waitForVisibility(driver, templateSearch, 60);
		ElementUtil.sendText(templateSearch, "Event", driver);
		ElementUtil.sendKey(templateSearch, Keys.ENTER, driver);

		// select first template
		WaitUtil.waitAndClick(driver, templateSelect, 60);

		// preview (opens in new tab)
		String original = driver.getWindowHandle();
		ElementUtil.click(templatePreview, driver);
		Thread.sleep(3000); // Wait for new tab to open
		// WaitUtil.waitForNewWindow(driver, 2);

		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.close();
		driver.switchTo().window(original);


		// next button
		WaitUtil.waitAndClick(driver, nextPage3, 60);
	}
}
