package com.stratapps.xamplify.pages;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.stratapps.xamplify.utils.ActionUtil;
import com.stratapps.xamplify.utils.CSVUtil;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class ContactsPage {

	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger(ContactsPage.class);
	String timestamp = String.valueOf(System.currentTimeMillis());
	String uniqueEmail = "CNT" + timestamp + new Random().nextInt(10) + "@mail.com";

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
	}

	// =================== LOCATORS ===================
	public By hoverContacts = By.xpath("//a[@href='javascript:;']//span[@class='title'][contains(text(),'Contacts')]");
	private By addContactsBtn = By.xpath("//span[contains(text(),'Add Contacts')]");
	public By oneAtATimeOption = By.xpath("//button[@id='add_contact' or @id='addContacts']");

	private By emailField = By.xpath("//input[@id='email1']");
	private By legalBasisField = By.xpath("//*[@id='multiselectelement']/div//span[3]/input");

	public static By firstName   = By.xpath("//input[@id='firstName']");
	public static By lastName    = By.xpath("//input[@id='lastName']");
	public static By titleField  = By.id("title");
	public static By addressField = By.id("address");
	public static By cityField    = By.id("city");
	public static By stateField   = By.id("state");
	public static By zipField     = By.id("zip");


	private By addCompanyButton = By.xpath("//div[@id=\"addContactModal\"]//button[2]/span");
	private By companyModal = By.id("addCompanyModal");
	private By companyName = By.id("name");
	private By companyWebsite = By.id("website");
	private By confirmContactAdd = By.xpath("//*[@id='addContactModal']/div//div[3]/button[2]/span");
	private By saveButton = By.xpath("//button[@id='sample_editable_1_new']");
	private By Listname = By.xpath("//*[@id='contactListName']");
	private By existNameMsg = By.xpath("//p[contains(text(),'already exists')]");
	private By acceptButton = By.xpath("//span[text()='Accept']");
	private By uploadCSV = By.xpath("//input[@accept='.csv']");
	private By legalBasisCSV = By.xpath("//input[@placeholder='Select Legal Basis']");
	private By csvSaveBtn = By.xpath("//button[@id='sample_editable_1_new']");
	private By csvVerifyBtn = By.xpath("//button[@id='verifyCSV']");
	private By csvErrorMsg = By.xpath("//span[contains(text(),'already exists')]");
	private By csvListName = By.xpath("//input[@id='listName']");
	private By Gotohome = By.xpath("//img[@class='cls-pointer']");
	private By ContactStatus = By.xpath("//div[@id='contactStatus']//select");
	private By Private = By.xpath("//span[@class='bootstrap-switch-handle-off bootstrap-switch-danger']");
	private By DownloadCSVTemp = By.xpath("//span[text()='Download CSV Template ']/..");
	private By saveEditcsv = By.xpath("//a[@id=\"save_button\"]");
	private By ActionDropdown = By.xpath("//button[@id=\"save&delete_button\"]");

	
	private By AddCompany = By.xpath("//button[@id='addContactuser']");
	private By fgd = By.xpath("//button[@id=\"save&delete_button\"]");

	private By CompanyName = By.xpath("//input[@id='name']");
	private By Email = By.xpath("//input[@id='email']");
	private By Address = By.xpath("//input[@id='address']");
	private By City = By.xpath("//input[@id='city']");
	private By State = By.xpath("//input[@id='state']");
	private By ZipCode = By.xpath("//input[@id='zip']");
	private By CountryDropdown = By.xpath("//label[contains(text(),'Select Country')]/following::select[1]");
	private By Phone = By.xpath("//input[@placeholder=\"Enter your mobile no\"]");
	private By Fax = By.xpath("//input[@id='fax']");
	private By Website = By.xpath("//input[@placeholder='Website']");

	
	private By companyEditUpdate = By.xpath("//Span[text()= 'Update']");
	private By Sync = By.xpath("//button[text() = 'Sync']");
	private By SynchronizeCompaniesBtn = By.xpath("//span[contains(text(), 'Synchronize Companies')]");
	private By AddCompaniesBtn = By.xpath("//span[contains(text() , 'Add a Company')]");
	private By AddCMP = By.xpath("(//Span[text()= 'Add']/..)[2]");
	private By reponsemsg = By.xpath("//span[@id=\"responseMessage\"]");
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
	
	/* @AddCompany Is Written by ganesh ***/
	public void AddCompany(String company_name) throws InterruptedException {
		WaitUtil.waitAndClick(driver, AddCompany, 20);
		String timestamp1 = String.valueOf(System.currentTimeMillis());

		WaitUtil.waitAndSendKeys(driver, CompanyName, company_name + timestamp1, 20);
		WaitUtil.waitAndSendKeys(driver, Email, "company321@gmail.com", 20);
		WaitUtil.waitAndSendKeys(driver, Address, "Kondapur", 20);
		WaitUtil.waitAndSendKeys(driver, City, "Hyderabad", 20);
		WaitUtil.waitAndSendKeys(driver, ZipCode, "500085", 20);
		WaitUtil.waitAndSendKeys(driver, Website, "www.CMP7756.com", 20);
		WaitUtil.waitAndSendKeys(driver, Fax, "31413", 20);
		WaitUtil.waitForElementClickable(driver, AddCMP, 20);	
		WaitUtil.waitAndClick(driver, AddCMP, 20);
	
	}
	
	public void OneAtATimeContactAndAddCompany(String contactType) throws Exception {
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
		WaitUtil.waitAndSendKeys(driver, titleField, "CMP", 60);
		WaitUtil.waitAndSendKeys(driver, addressField, "Sri Maruthi Homes, Lingampally", 60);
		WaitUtil.waitAndSendKeys(driver, cityField, "Hyderabad", 60);
		WaitUtil.waitAndSendKeys(driver, stateField, "Telangana", 60);
		WaitUtil.waitAndSendKeys(driver, zipField, "500050", 60);
		// DropdownUtil.selectByValue(driver, ContactStatus, "4");
		Thread.sleep(3000);
		WaitUtil.waitAndClick(driver, confirmContactAdd, 30);

		try {
			WebElement listName = driver.findElement(Listname);
			if (listName.isDisplayed()) {
				WaitUtil.waitAndSendKeys(driver, Listname, "List_" + timestamp + new Random().nextInt(10), 30);
			}

			if (contactType == "Private") {
				Thread.sleep(2000);
				WaitUtil.waitAndClick(driver, Private, 20);
			}
			WaitUtil.waitAndClick(driver, saveButton, 30);

		} catch (Exception e) {
			System.out.println("ListName is not visible");
			// Element not visible or not available → skip or log
		}
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
		Thread.sleep(2000);
	}

	public void completeOneAtATimeFlow(String contactType) throws Exception {
		logger.info("Starting 'One at a Time' contact creation flow.");
		Thread.sleep(2000);
		String timestamp1 = String.valueOf(System.currentTimeMillis());

		WaitUtil.waitAndClick(driver, oneAtATimeOption, 80);
		WaitUtil.waitAndSendKeys(driver, emailField, uniqueEmail, 60);
		WaitUtil.waitAndSendKeys(driver, firstName, "GAYATRI", 60);
		if (ElementUtil.isDisplayed(legalBasisField, driver)) {
			ElementUtil.sendKey(legalBasisField, Keys.ENTER, driver);
			WaitUtil.waitAndSendKeys(driver, legalBasisField, "Legitimate interest - existing customer", 40);
			ElementUtil.sendKey(legalBasisField, Keys.ENTER, driver); // Select from dropdown or confirm
		}
		WaitUtil.waitAndSendKeys(driver, lastName, "A", 60);
		WaitUtil.waitAndSendKeys(driver, titleField, "CMP", 60);
		WaitUtil.waitAndSendKeys(driver, addressField, "Sri Maruthi Homes, Lingampally", 60);
		WaitUtil.waitAndSendKeys(driver, cityField, "Hyderabad", 60);
		WaitUtil.waitAndSendKeys(driver, stateField, "Telangana", 60);
		WaitUtil.waitAndSendKeys(driver, zipField, "500050", 60);
		// DropdownUtil.selectByValue(driver, ContactStatus, "4");
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, confirmContactAdd, 30);

		try {
			WebElement listName = driver.findElement(Listname);
			if (listName.isDisplayed()) {
				WaitUtil.waitAndSendKeys(driver, Listname, "List_" + timestamp1 + new Random().nextInt(10), 30);
			}

			if (contactType == "Private") {
				Thread.sleep(2000);
				WaitUtil.waitAndClick(driver, Private, 20);
			}
			WaitUtil.waitAndClick(driver, saveButton, 30);

		} catch (Exception e) {
			System.out.println("ListName is not visible");
			// Element not visible or not available → skip or log
		}
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
		Thread.sleep(2000);
	}

	/// . @downloadCSVTemplate is written by Ganesh ./
	public void downloadCSVTemplate() {
		WaitUtil.waitAndClick(driver, DownloadCSVTemp, 20);
	}

	public static String CreateCSVFile() {
		String getMailId = "CNT" + System.currentTimeMillis() + "@gmail.com";
		String uniquecompany = "company" + System.nanoTime();
		List<String[]> ContactUserData = Arrays.asList(
				new String[] { "AutomationUser", "Test", uniquecompany, "Automation Tester", "C1" + getMailId,
						"Kondapur", "Hyderabad", "Telangana", "534350", "India", "+919999088099", "" },
				new String[] { "AutomationUser2", "Test2", uniquecompany, "Automation Tester2", "C2" + getMailId,
						"Kondapur", "Hyderabad", "Telangana", "534350", "India", "+919999088099", "" });
		String filePath = CSVUtil.generateContatcsCSV(ContactUserData);
		return filePath;
	}

	/// . @uploadCSVContacts is updated by Ganesh ./
	public void uploadCSVContacts(String contactType, String uploadIn) throws Exception {
		logger.info("Uploading contact via CSV...");
		String CsvFilePath = CreateCSVFile();
		Thread.sleep(5000);
		System.out.println(CsvFilePath);
		try {
			WebElement uploadElement = driver.findElement(uploadCSV);
			uploadElement.sendKeys(CsvFilePath);
		} catch (Exception e) {
			System.out.println(e);
		}
		Thread.sleep(5000);

		ElementUtil.sendKey(legalBasisCSV, Keys.ENTER, driver);
		WaitUtil.waitAndSendKeys(driver, legalBasisField, "Legitimate interest - existing customer", 40);
		ElementUtil.sendKey(legalBasisCSV, Keys.ENTER, driver);
		Thread.sleep(2000);
		if (contactType == "Private") {
			Thread.sleep(2000);
			WaitUtil.waitAndClick(driver, Private, 20);
			WaitUtil.waitAndClick(driver, Private, 20);

		}
		Thread.sleep(2000);
//		WaitUtil.waitAndClick(driver, ActionDropdown, 30);
//		WaitUtil.waitAndClick(driver, saveEditcsv, 30);
		if(uploadIn == "AddContacts") {
			WaitUtil.waitAndClick(driver, csvSaveBtn, 30);
		}
		if (uploadIn == "EditList") {
			WaitUtil.waitAndClick(driver, ActionDropdown, 30);
			WaitUtil.waitAndClick(driver, saveEditcsv, 30);
		} 
		WaitUtil.waitAndClick(driver, acceptButton, 30);

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

}
