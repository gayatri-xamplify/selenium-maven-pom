package com.stratapps.xamplify.pages;

import java.time.Duration;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.stratapps.xamplify.utils.WaitUtil;

public class CompaniesPage {

	private static WebDriver driver;
	private WebDriverWait wait;

	private static final Logger logger = LogManager.getLogger(CompaniesPage.class);
	String timestamp = String.valueOf(System.currentTimeMillis());
	String uniqueEmail = "testContact_" + timestamp + new Random().nextInt(10) + "@mail.com";

	public CompaniesPage(WebDriver driver) {
		this.driver = driver;
	    this.contactsPage = new ContactsPage(driver); 
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
    ContactsPage contactsPage = new ContactsPage(this.driver);

	// ------------------------- Locators ---------------------------------------
	private By Companies = By.xpath("(//span[contains(text(), 'Companies')]/..)[1]");
	private By ViewCompany = By.xpath("(//a[@id=\"company\"])[1]");
	private By EditCompany = By.xpath("(//a[@id=\"company\"])[2]");
	private By DeleteCompany = By.xpath("(//a[@id=\"company\"])[3]");
	private By AddContact = By.xpath("(//a[@id='company'])[4]");
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
	private By Website = By.xpath("//input[@placeholder='Website']");

	
	private By companyEditUpdate = By.xpath("//Span[text()= 'Update']");
	private By Sync = By.xpath("//button[text() = 'Sync']");
	private By SynchronizeCompaniesBtn = By.xpath("//span[contains(text(), 'Synchronize Companies')]");
	private By AddCompaniesBtn = By.xpath("//span[contains(text() , 'Add a Company')]/..");
	private By AddCMP = By.xpath("//Span[text()= 'Add']/..");
	private By reponsemsg = By.xpath("//span[@id=\"responseMessage\"]");
	private static By CompanyTileCount = By.xpath("(//*[@id=\"deals-page-content-div\"]//div[1]/span)[1]");
	private static By TotalCompaniesCount = By.xpath("(//span[text() = 'Total Records :'])[1]/..");
	private By Searchcompany = By.xpath("//input[@placeholder=\"Search\"]");
	private By searchSubmt = By.xpath("(//button[@type='submit'])[2]");
	private By SearchClear = By.xpath("//button[contains(@class,'remove search-box-item-clear')]");
	private By sa30 = By.xpath("");

	// ========================= Methods ========================================
	/* @NavigateToCompany Is Written by ganesh ***/
	public void NavigateToCompany() throws InterruptedException {
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, Companies, 20);
	}
	
	/* @editCompanyDetails Is Written by ganesh ***/
	public void editCompanyDetails() throws InterruptedException {
		String CmpName = "Cmp_update"+ timestamp;
		WaitUtil.waitAndClick(driver, EditCompany, 20);
		WaitUtil.waitAndSendKeys(driver, CompanyName, CmpName, 20);
		WaitUtil.waitAndSendKeys(driver, Email, CmpName+"@gmail.com", 20);
		WaitUtil.waitAndSendKeys(driver, Address, "Kondapur", 20);
		WaitUtil.waitAndSendKeys(driver, City, "Hyderabad", 20);
		WaitUtil.waitAndSendKeys(driver, ZipCode, "500085", 20);
		WaitUtil.waitAndSendKeys(driver, Fax, "31413", 20);
		WaitUtil.waitForElementClickable(driver, companyEditUpdate, 20);
		WaitUtil.waitAndClick(driver, companyEditUpdate, 20);
		Thread.sleep(2000);
		WaitUtil.verifyResponseMessage(driver, reponsemsg, 20, "Company Updated Successfully");	
	}
	
	/* @PreviewCompany Is Written by ganesh ***/
	public void PreviewCompany() throws InterruptedException {
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, ViewCompany, 20);
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, PreviewClose, 20);
	}
	
	/* @DeleteCompany Is Written by ganesh ***/
	public void DeleteCompany() throws InterruptedException  {
		WaitUtil.waitAndClick(driver, DeleteCompany, 20);
		WaitUtil.waitAndClick(driver, YesDelete, 20);
		Thread.sleep(2000);
		WaitUtil.verifyResponseMessage(driver, reponsemsg, 20, "Company Deleted Successfully");	
	}
	
	/* @SearchCompany Is Written by ganesh ***/
	public void SearchCompany(String searchKeyword) throws InterruptedException  {
		WaitUtil.waitAndSendKeys(driver, Searchcompany, searchKeyword, 20);
		Thread.sleep(1000);
		WaitUtil.waitAndClick(driver, searchSubmt, 20);
		Thread.sleep(3000);
	}
	
	/* @SearchClear Is Written by ganesh ***/
	public void SearchClear() throws InterruptedException  {
		WaitUtil.waitAndClick(driver, SearchClear, 20);
		Thread.sleep(3000);
	}
	
	/* @AddContactUnderCompany Is Written by ganesh ***/
	public void AddContactUnderCompany() throws Exception {
		Thread.sleep(4000);
		WaitUtil.waitAndClick(driver, AddContact, 20);
		Thread.sleep(3000);
		contactsPage.completeOneAtATimeFlow("Public");
		Thread.sleep(4000);
		WaitUtil.waitAndClick(driver, AddContact, 20);
		contactsPage.uploadCSVContacts("Public", "EditList");
		Thread.sleep(3000);
		WaitUtil.waitAndClick(driver, ManageCompanies, 20);
	}
	
	/* @SynchronizeCompanies Is Written by ganesh ***/
	public void SynchronizeCompanies() throws InterruptedException {
		Thread.sleep(3000);
		WaitUtil.waitAndClick(driver, SynchronizeCompaniesBtn, 20);
		WaitUtil.waitAndClick(driver, Sync, 20);
		Thread.sleep(3000);
	}
	
	/* @AddCompany Is Written by ganesh ***/
	public void AddCompany(String company_name) throws InterruptedException {
		Thread.sleep(3000);
		WaitUtil.waitAndClick(driver, AddCompaniesBtn, 20);
		WaitUtil.waitAndSendKeys(driver, CompanyName, company_name + timestamp, 20);
		WaitUtil.waitAndSendKeys(driver, Email, "company321@gmail.com", 20);
		WaitUtil.waitAndSendKeys(driver, Address, "Kondapur", 20);
		WaitUtil.waitAndSendKeys(driver, City, "Hyderabad", 20);
		WaitUtil.waitAndSendKeys(driver, ZipCode, "500085", 20);
		WaitUtil.waitAndSendKeys(driver, Website, "www.CMP7756.com", 20);
		WaitUtil.waitAndSendKeys(driver, Fax, "31413", 20);
		WaitUtil.waitForElementClickable(driver, AddCMP, 20);	
		WaitUtil.waitAndClick(driver, AddCMP, 20);
		Thread.sleep(2000);
		WaitUtil.verifyResponseMessage(driver, reponsemsg, 20, "Company Added Successfully");	

//		if(driver.findElement(reponsemsg).isDisplayed()) {
//			WaitUtil.waitAndSendKeys(driver, CompanyName,  timestamp + company_name, 20);
//			WaitUtil.waitForElementClickable(driver, AddCMP, 20);	
//
//		}
	
	}
	
	/* @TileCountValidation Is Written by ganesh ***/
	public static void TileCountValidation() throws InterruptedException {
	    Thread.sleep(3000);
	    String TileCountText = driver.findElement(CompanyTileCount).getText();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement totalCompaniesCount = driver.findElement(TotalCompaniesCount);
		js.executeScript("arguments[0].scrollIntoView();", totalCompaniesCount);
	    String TotalRecordText = driver.findElement(TotalCompaniesCount).getText();
	    System.out.println(TotalRecordText +"  "+ TileCountText);
	    // Convert to int
	    int tileCount = Integer.parseInt(TileCountText.replaceAll("[^0-9]", ""));
	    int totalRecordCount = Integer.parseInt(TotalRecordText.replaceAll("[^0-9]", ""));    
	    System.out.println("Tile Count: " + tileCount);
	    System.out.println("Total Records: " + totalRecordCount);	    
	    // Assertion to compare both values
	    Assert.assertEquals(tileCount, totalRecordCount, "Mismatch between Tile count and Total record count!");    
	}

	
}
