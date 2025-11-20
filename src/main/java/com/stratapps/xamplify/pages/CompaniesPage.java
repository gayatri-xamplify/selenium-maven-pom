package com.stratapps.xamplify.pages;

import java.time.Duration;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.utils.WaitUtil;

public class CompaniesPage {

	private WebDriver driver;
	private WebDriverWait wait;

	private static final Logger logger = LogManager.getLogger(CompaniesPage.class);
	String timestamp = String.valueOf(System.currentTimeMillis());
	String uniqueEmail = "testContact_" + timestamp + new Random().nextInt(10) + "@mail.com";

	public CompaniesPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
    ContactsPage contactsPage = new ContactsPage(this.driver);

	// ------------------------- Locators ---------------------------------------
	private By Companies = By.xpath("(//span[contains(text(), 'Companies')]/..)[1]");
	private By ViewCompany = By.xpath("(//a[@id=\"company\"])[1]");
	private By EditCompany = By.xpath("(//a[@id=\"company\"])[2]");
	private By DeleteCompany = By.xpath("(//a[@id=\"company\"])[3]");
	private By AddContact = By.xpath("(//a[@id=\"company\"])[4]");
	private By CompaniesTileCount = By.xpath("//div[text() = 'Companies']/..//span");
	private By ContactsTileCount = By.xpath("//div[text() = 'Contacts']/..//span");

	private By TotalCampaines = By.xpath("");
	private By ContactsTile = By.xpath("//div[text() = 'Contacts']/../../..");
	private By CompaniesTile = By.xpath("//div[text() = 'Companies']/../../..");
	private By PreviewClose = By.xpath("(//button[text() = 'Cancel'])[2]");
	private By YesDelete = By.xpath("//button[text() = 'Yes, delete it!']");
	private By ManageCompanies = By.xpath("//a[contains(text(),'Manage Companies')]");

	private By CompanyName = By.xpath("//input[@id='name']");
	private By Email = By.xpath("//input[@id='email']");
	private By Address = By.xpath("//input[@id='address']");
	private By City = By.xpath("//input[@id='city']");
	private By State = By.xpath("//input[@id='state']");
	private By ZipCode = By.xpath("//input[@id='zip']");
	private By CountryDropdown = By.xpath("//label[contains(text(),'Select Country')]/following::select[1]");
	private By Phone = By.xpath("//input[@placeholder=\"Enter your mobile no\"]");
	private By Fax = By.xpath("//input[@id='fax']");

	private By companyEditUpdate = By.xpath("//Span[text()= 'Update']");
	private By Sync = By.xpath("//button[text() = 'Sync']");
	private By SynchronizeCompaniesBtn = By.xpath("//span[contains(text(), 'Synchronize Companies')]");
	private By AddCompaniesBtn = By.xpath("//span[contains(text() , 'Add a Company')]");
	private By AddCMP = By.xpath("//Span[text()= 'Add']");
	private By reponsemsg = By.xpath("//span[@id=\"responseMessage\"]");
	private By sa25 = By.xpath("");
	private By sa26 = By.xpath("");
	private By sa27 = By.xpath("");
	private By sa28 = By.xpath("");
	private By sa29 = By.xpath("");
	private By sa30 = By.xpath("");

	// ========================= Methods ========================================

	/* @editCompanyDetails Is Written by ganesh ***/
	public void editCompanyDetails() {
		WaitUtil.waitAndSendKeys(driver, AddContact, timestamp, 20);
		WaitUtil.waitAndSendKeys(driver, CompanyName, "Auto_cmp", 20);
		WaitUtil.waitAndSendKeys(driver, Email, "company321@gmail.com", 20);
		WaitUtil.waitAndSendKeys(driver, Address, "Kondapur", 20);
		WaitUtil.waitAndSendKeys(driver, City, "Hyderabad", 20);
		WaitUtil.waitAndSendKeys(driver, ZipCode, "500085", 20);
		WaitUtil.waitAndSendKeys(driver, Fax, "31413", 20);

		WaitUtil.waitForElementClickable(driver, companyEditUpdate, 20);
		WaitUtil.verifyResponseMessage(driver, reponsemsg, 20, "Company Updated Successfully");
	}
	// check
	
	
	
	/* @PreviewCompany Is Written by ganesh ***/
	public void PreviewCompany() {
		WaitUtil.waitAndClick(driver, ViewCompany, 20);
		WaitUtil.waitAndClick(driver, PreviewClose, 20);
	}
	
	/* @DeleteCompany Is Written by ganesh ***/
	public void DeleteCompany() throws InterruptedException  {
		WaitUtil.waitAndClick(driver, DeleteCompany, 20);
		WaitUtil.waitAndClick(driver, YesDelete, 20);
		Thread.sleep(2000);
	}
	
	/* @AddContactUnderCompany Is Written by ganesh ***/
	public void AddContactUnderCompany() throws Exception {
		WaitUtil.waitAndClick(driver, AddContact, 20);
		Thread.sleep(3000);
		contactsPage.completeOneAtATimeFlow("Public");
		contactsPage.uploadCSVContacts("Public", "\"EditList\"");
		Thread.sleep(3000);
		WaitUtil.waitAndClick(driver, ManageCompanies, 20);
	}
	
	/* @SynchronizeCompanies Is Written by ganesh ***/
	public void SynchronizeCompanies() throws InterruptedException {
		WaitUtil.waitAndClick(driver, SynchronizeCompaniesBtn, 20);
		Thread.sleep(3000);
	}
	
	/* @AddCompany Is Written by ganesh ***/
	public void AddCompany(String company_name) {
		WaitUtil.waitAndClick(driver, AddCompaniesBtn, 20);
		WaitUtil.waitAndSendKeys(driver, AddContact, timestamp, 20);
		WaitUtil.waitAndSendKeys(driver, CompanyName, company_name, 20);
		WaitUtil.waitAndSendKeys(driver, Email, "company321@gmail.com", 20);
		WaitUtil.waitAndSendKeys(driver, Address, "Kondapur", 20);
		WaitUtil.waitAndSendKeys(driver, City, "Hyderabad", 20);
		WaitUtil.waitAndSendKeys(driver, ZipCode, "500085", 20);
		WaitUtil.waitAndSendKeys(driver, Fax, "31413", 20);

		WaitUtil.waitForElementClickable(driver, AddCMP, 20);	}

	
	
}
