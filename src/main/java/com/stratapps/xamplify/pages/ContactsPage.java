package com.stratapps.xamplify.pages;

import com.stratapps.xamplify.utils.ActionUtil;
import com.stratapps.xamplify.utils.CSVUtil;
import com.stratapps.xamplify.utils.DropdownUtil;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;
import com.stratapps.xamplify.utils.xamplifyUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ContactsPage {

	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger(ContactsPage.class);
	String timestamp = String.valueOf(System.currentTimeMillis());
	String uniqueEmail = "testContact_" + timestamp + new Random().nextInt(10) + "@mail.com";
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
	}

	// =================== LOCATORS ===================
	private By hoverContacts = By.xpath("//a[@href='javascript:;']//span[@class='title'][contains(text(),'Contacts')]");
	private By addContactsBtn = By.xpath("//span[contains(text(),'Add Contacts')]");
	private By oneAtATimeOption = By.xpath("//button[@id='addContacts']/span/img");

	private By emailField = By.xpath("//input[@id='email1']");
	private By legalBasisField = By.xpath("//*[@id='multiselectelement']/div//span[3]/input");

	private By firstName = By.xpath("//input[@id='firstName']");
	private By lastName = By.xpath("//input[@id='lastName']");
	private By titleField = By.id("title");
	private By addressField = By.id("address");
	private By cityField = By.id("city");
	private By stateField = By.id("state");
	private By zipField = By.id("zip");

	private By addCompanyButton = By.xpath("//div[@id=\"addContactModal\"]//button[2]/span");
	private By companyModal = By.id("addCompanyModal");
	private By companyName = By.id("name");
	private By companyWebsite = By.id("website");
	private By confirmCompanyAdd = By.xpath("//*[@id='addContactModal']/div//div[3]/button[2]/span");
	private By saveButton = By.xpath("//button[@id='sample_editable_1_new']");
	private By Listname = By.xpath("//*[@id='contactListName']");
	private By existNameMsg = By.xpath("//p[contains(text(),'already exists')]");
	private By acceptButton = By.xpath("//span[text()='Accept']");
	private By uploadCSV = By.id("uploadCSV");
	private By legalBasisCSV = By.xpath("//input[@id='legalCSV']");
	private By csvSaveBtn = By.xpath("//button[@id='saveCSV']");
	private By csvVerifyBtn = By.xpath("//button[@id='verifyCSV']");
	private By csvErrorMsg = By.xpath("//span[contains(text(),'already exists')]");
	private By csvListName = By.xpath("//input[@id='listName']");
	private By Gotohome = By.xpath("//img[@class='cls-pointer']");
	private By ContactStatus = By.xpath("//div[@id='contactStatus']//select");
	private By Private = By.xpath("//span[@class='bootstrap-switch-handle-off bootstrap-switch-danger']");
	private By DownloadCSVTemp = By.xpath("//span[text()='Download CSV Template ']/..");
	// =================== METHODS ===================

	public void backToHome() {
		WaitUtil.waitAndClick(driver, Gotohome, 60);
	}

	public void hoverContacts() throws InterruptedException {
		Thread.sleep(3000);
		logger.info("Hovering over 'Contacts' menu.");
		ActionUtil.hover(driver, hoverContacts);
		logger.info("Clicking 'Add Contacts' button.");
		ActionUtil.hoverAndClick(driver, addContactsBtn);
	}
	
	public void addPrivateContact() {
		
	}

	public void completeOneAtATimeFlow(String contactType) throws Exception {
		logger.info("Starting 'One at a Time' contact creation flow.");
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, oneAtATimeOption, 80);
		WaitUtil.waitAndSendKeys(driver, emailField, uniqueEmail, 60);
		WaitUtil.waitAndSendKeys(driver, firstName, "GAYATRI", 60);
		if (ElementUtil.isDisplayed(legalBasisField, driver)) {
			ElementUtil.sendKey(legalBasisField, Keys.ENTER, driver);
			WaitUtil.waitAndSendKeys(driver, legalBasisField, "Legitimate interest - existing customer", 40);
			ElementUtil.sendKey(legalBasisField, Keys.ENTER, driver); // Select from dropdown or confirm
		}
		WaitUtil.waitAndSendKeys(driver, lastName, "A", 60);
		WaitUtil.waitAndSendKeys(driver, titleField, "sse", 60);
		WaitUtil.waitAndSendKeys(driver, addressField, "Sri Maruthi Homes, Lingampally", 60);
		WaitUtil.waitAndSendKeys(driver, cityField, "Hyderabad", 60);
		WaitUtil.waitAndSendKeys(driver, stateField, "Telangana", 60);
		WaitUtil.waitAndSendKeys(driver, zipField, "500050", 60);
		//DropdownUtil.selectByValue(driver, ContactStatus, "4");
		WaitUtil.waitAndClick(driver, confirmCompanyAdd, 30);
		WaitUtil.waitAndSendKeys(driver, Listname, "List_"+timestamp + new Random().nextInt(10), 30);
		if(contactType == "Private") {
			Thread.sleep(2000);
			System.out.println("chh");
			WaitUtil.waitAndClick(driver, Private, 20);
		}
		WaitUtil.waitAndClick(driver, saveButton, 30);
		/*
		 * WaitUtil.waitAndSendKeys(driver, companyName, "AutoTestCompany", 30);
		 * WaitUtil.waitAndSendKeys(driver, companyWebsite, "www.automate.com", 30);
		 * 
		 * WaitUtil.waitAndClick(driver, confirmCompanyAdd, 30);
		 */
		/*
		 * try { WebElement errorMsg = WaitUtil.waitForVisibility(driver,
		 * By.id("responseMessage"), 5); if
		 * (errorMsg.getText().contains("Duplicate Entry")) { String uniqueName =
		 * "AutoTestCompany_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new
		 * Date()); WaitUtil.waitAndSendKeys(driver, companyName, uniqueName, 10);
		 * WaitUtil.waitAndClick(driver, confirmCompanyAdd, 10); } } catch
		 * (TimeoutException ignored) { }
		 * 
		 * WaitUtil.waitAndClick(driver, saveButton, 30);
		 */
		try {
			WebElement errMsg = WaitUtil.waitForVisibility(driver, existNameMsg, 15);
			if (errMsg.getText().contains("already exists")) {
				WebElement listField = WaitUtil.waitForVisibility(driver, By.xpath("//*[@id='contactListName']"), 30);
				listField.sendKeys("_A1_" + System.currentTimeMillis());
				WaitUtil.waitAndClick(driver, saveButton, 10);
			}
		} catch (TimeoutException e) {
			logger.info("No duplicate list name issue.");
		}
		WaitUtil.waitAndClick(driver, acceptButton, 30);
	}
	
	public void downloadCSVTemplate() {
		WaitUtil.waitAndClick(driver, DownloadCSVTemp, 20);
	}

	public void uploadCSVAndHandle() throws Exception {
		logger.info("Uploading contact via CSV...");

		WaitUtil.waitAndClick(driver, uploadCSV, 60);

		Thread.sleep(2000);
		// You should replace this with an automation-friendly approach later
		Runtime.getRuntime().exec("D:\\git\\xAmplifyQA\\xAmplifyQA\\Uploadcontacts.exe");
		Thread.sleep(3000);

		ElementUtil.sendKey(legalBasisCSV, Keys.ENTER, driver);
		ElementUtil.sendKey(legalBasisCSV, Keys.ENTER, driver);

		WaitUtil.waitAndClick(driver, csvSaveBtn, 30);
		WaitUtil.waitAndClick(driver, csvVerifyBtn, 30);

		try {
			WebElement errmsg = WaitUtil.waitForVisibility(driver, csvErrorMsg, 5);
			if (errmsg.getText().contains("already exists")) {
				String newList = "_G" + System.currentTimeMillis();
				WaitUtil.waitAndSendKeys(driver, csvListName, newList, 10);
				WaitUtil.waitAndClick(driver, csvSaveBtn, 10);
				WaitUtil.waitAndClick(driver, csvVerifyBtn, 10);
			}
		} catch (TimeoutException e) {
			logger.debug("No CSV duplicate error.");
		}
	}
	
//	public static String CreateCSVFile() {
//		String getMailId = "user" + System.currentTimeMillis() + "@gmail.com";
//		String uniquecompany = "company" + System.nanoTime();
//		List<String[]> ContactUserData = Arrays.asList(
//				new String[] { "AutomationUser", "Test", uniquecompany, "Automation Tester", "us1" + getMailId,
//						"Kondapur", "Hyderabad", "Telangana", "534350", "India", "+919999088099" },
//				new String[] {  "AutomationUser2", "Test2", uniquecompany, "Automation Tester2", "us2" + getMailId,
//						"Kondapur", "Hyderabad", "Telangana", "534350", "India", "+919999088099" });
//		
//// Step 3: Generate CSV dynamically and get the file path
//		
////		  String filePath = CSVUtil.generateCSV(ContactUserData);
////		 		return filePath;}
	}


