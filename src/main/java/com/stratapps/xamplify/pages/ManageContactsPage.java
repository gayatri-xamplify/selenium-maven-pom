package com.stratapps.xamplify.pages;

import java.time.Duration;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.stratapps.xamplify.utils.ActionUtil;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.ScreenshotUtil;
import com.stratapps.xamplify.utils.WaitUtil;
import com.stratapps.xamplify.utils.xamplifyUtil;

public class ManageContactsPage {
	private WebDriver driver;
	private WebDriverWait wait;

	private static final Logger logger = LogManager.getLogger(ManageContactsPage.class);
	String timestamp = String.valueOf(System.currentTimeMillis());
	String uniqueEmail = "testContact_" + timestamp + new Random().nextInt(10) + "@mail.com";
    ContactsPage contactsPage = new ContactsPage(this.driver);

	public ManageContactsPage(WebDriver driver) {
		this.driver = driver;
	    this.contactsPage = new ContactsPage(driver); 
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	
	// ================ Locators   =======================================================================
	public By hoverContacts = By.xpath("//a[@href='javascript:;']//span[@class='title'][contains(text(),'Contacts')]");
	private By manageContactsBtn = By.xpath("//span[contains(text(),'Manage Contacts')]");
	private By editListButton1 = By.xpath("//*[@id=\"partner_contact_list\"]/tbody/tr[1]/td[6]/div/a[1]");
	private By editListButton2 = By.xpath("//*[@id=\"partner_contact_list\"]/tbody/tr[2]/td[6]/div/a[1]");
	private By copyListButton = By.xpath("(//table[@id='partner_contact_list']//a[@title='Copy and save'])[1]");
	private By deleteListButton = By.xpath("(//table[@id='partner_contact_list']//a[@title='Delete list'])[1]");
	private By shareListButton = By.xpath("(//table[@id='partner_contact_list']//a[@title='Share Campaigns'])[1]");
	private By contactListName = By.xpath("//input[@id='campaignName']");
	private By CopyListSaveBtn = By.xpath("//span[contains(text(),'Save')]");

	private By responsemesage = By.xpath("//span[@id=\"responseMessage\"]");
	private By yesDelete = By.xpath("//button[contains(text(), 'Yes, delete it!')]");
	private By ContactSearch = By.xpath("//input[@placeholder=\"Search for a list\"]");
	private By editContactSearch = By.xpath("//input[@placeholder='Search']");
	private By SearchSubmit = By.xpath("(//button[@type='submit'])[2]");
	private By SearchClear = By.xpath("//button[contains(@class,'remove search-box-item-clear')]");
	private By contactSort = By.xpath("//select[contains(@class,'form-control SeclectBoxPaddingsAbj')]");
	public static final By PreviousPage = By.xpath("//span[text()='Previous']/../..");
	public static final By firstPage = By.xpath("//span[text()='First']/../..");
	public static final By nextPage = By.xpath("//i[@title='Next']/../..");
	public static final By lastPage = By.xpath("//span[text()='Last']/../..");
	public static final By updateAndClose = By.xpath("//span[contains(text(),'Update & Close')]/..");

	public static final By AllContactsTile = By.xpath("(//a[contains(normalize-space(text()),'Detailed view')])[1]/..");
	public static final By AllContactsTileCount = By.xpath("(//div[contains(@class,'number')])[1]");
	public static final By ContactsTotalCount = By.xpath("(//span[text() = 'Total Records :'])[1]/..");
	
	public static final By ValidContactTile = By.xpath("(//a[contains(normalize-space(text()),'Detailed view')])[2]/..");
	public static final By ValidContactTileCount = By.xpath("(//div[contains(@class,'number')])[2]");
	
	public static final By ExecludedContactTile = By.xpath("(//a[contains(normalize-space(text()),'Detailed view')])[3]/..");
	public static final By ExecludedContactTileCount = By.xpath("(//div[contains(@class,'number')])[3]");
	
	public static final By UndeliverableContactTile = By.xpath("(//a[contains(normalize-space(text()),'Detailed view')])[4]");
	public static final By UndeliverableContactTileCount = By.xpath("(//div[contains(@class,'number')])[4]");
	
	public static final By UnsubscribedContactTile = By.xpath("(//a[contains(normalize-space(text()),'Detailed view')])[5]/..");
	public static final By UnsubscribedContactTileCount = By.xpath("(//div[contains(@class,'number')])[5]");

	
	public static final By publishIconBtn = By.xpath("//*[@id='partner_contact_list']/tbody/tr/td[6]/div/a[4]/i");
	public static final By entInfoCheckbox = By.xpath("//input[@name='all']");
	public static final By shareContentBtn = By.xpath("(//button[@type='submit'])[7]");
	public static final By closingBtn = By.xpath("(//button[@type='submit'])[8]");
	public static final By noCampaignsMsg = By.xpath("//app-share-campaigns/div[2]/strong");
	public static final By unpublishPopupCloseBtn = By.xpath("//div[@id='shareUnPublishedContentPopUp']//button[text()='Close']");
	
	private By ExportReport = By.xpath("//span[contains(@data-original-title,\"Click here to email the list\")]");
	private By ActionDropdown = By.xpath("//button[@id=\"save&delete_button\"]");
	
	private By contactNotification = By.xpath("//*[@id='row_0']/td[7]/div/a[1]");
	private By ContactEdit = By.xpath("//*[@id='row_0']/td[7]/div/a[2]");
	private By ContactDelete = By.xpath("//*[@id='row_0']/td[7]/div/a[3]");
	private By contactCampaignLaunch = By.xpath("//*[@id='row_0']/td[7]/div/a[4]");
	private By ContactAnalytics = By.xpath("//*[@id='row_0']/td[7]/div/a[5]");
	private By notificationmessage = By.xpath("//input[@value='Want to receive fewer messages']");
	private By Unsubscribe = By.xpath("//span[text()= 'Unsubscribe']/..");
	private By resubscribecomment = By.xpath("//textarea[@id='comment']");
	private By Subscribe = By.xpath("//span[text()= 'Subscribe']/..");
	private By contactMailId = By.xpath("(//b[text()= 'Email id:'])[1]/..");
	
	public static By firstName   = By.xpath("//input[@id='firstName']");
	public static By lastName    = By.xpath("//input[@id='lastName']");
	public static By titleField  = By.id("title");
	public static By addressField = By.id("address");
	public static By cityField    = By.id("city");
	public static By stateField   = By.id("state");
	public static By zipField     = By.id("zip");	
	private By ContactUpdate = By.xpath("//span[contains(text(),'Update')]/..");
	
	private By CreateList = By.xpath("//a[@id='saveAs_button']");
	private By Exportreport = By.xpath("//a[@id='exportToExcel']");
	private By CSVtempDownload = By.xpath("//a[@id='download_empy_csv']");
	private By DeleteCNT = By.xpath("//a[@id='delete_button']");
	private By AllCheckbox = By.xpath("//input[@id='checkAllExistingContacts']");
	private By legalBasisField = By.xpath("//*[@id='multiselectelement']/div//span[3]/input");
	private By Private = By.xpath("//span[@class='bootstrap-switch-handle-off bootstrap-switch-danger']");
	private By saveChanges = By.xpath("//span[text() = 'Save changes']");
	private By CopyToList = By.xpath("//a[text() = 'Copy To List']");
	private By MoveToList = By.xpath("//a[text() = 'Move To List']");
	private By CopyOrMovecontactAllCheckbox = By.xpath("//input[@id='copy-group-users-header-checkbox-id']");
	private By AddContacts = By.xpath("//span[text()='Add']");
	private By Closebtn = By.xpath("(//button[text()='Close'])[3]");
	private By sda30 = By.xpath("");	
	private By sva29 = By.xpath("");
	private By sad30 = By.xpath("");
	// ================ Methods  =============================

	/* @clickContactsTab Is Written by ganesh ***/
	public void hoverContacts_ManageContacts() throws InterruptedException {
		Thread.sleep(3000);
		ActionUtil.hover(driver, hoverContacts);
		ActionUtil.hoverAndClick(driver, manageContactsBtn);
	}

	/* @clickContactsTab Is Written by ganesh ***/
	public void clickContactsTab(String tabName) {
		By tab = By.xpath("//ul[contains(@class,'mix-filter')]//li[normalize-space(text())='" + tabName + "']");
		WaitUtil.waitForElementClickable(driver, tab, 20);
		WaitUtil.waitAndClick(driver, tab, 20);
		System.out.println("Clicked on tab: " + tabName);
	}

	/* @CopyContactList Is Written by ganesh ***/
	public void CopyContactList() throws InterruptedException {
		Thread.sleep(5000);
		WaitUtil.waitAndClick(driver, copyListButton, 60);
		WaitUtil.waitAndSendKeys(driver, contactListName, "copyList" + timestamp, 20);
		WaitUtil.waitAndClick(driver, CopyListSaveBtn, 20);
		Thread.sleep(3000);
		WaitUtil.verifyResponseMessage(driver, responsemesage, 20,
				"Your contact list has been saved successfully"
						+ " and it is being processed. If you'd like to take a break, we'll continue processing"
						+ " it in the background. We will send you an email once your list is campaign-ready.");
	}

	/* @DeleteContactList Is Written by ganesh ***/
	public void DeleteContactList() throws InterruptedException {
		Thread.sleep(2000);
		SearchContact("Contact");
		WaitUtil.waitAndClick(driver, deleteListButton, 60);
		WaitUtil.waitAndClick(driver, yesDelete, 20);
		Thread.sleep(3000);
		WaitUtil.verifyResponseMessage(driver, responsemesage, 60, "Your contact list has been deleted successfully.");
		searchClear();
	}

	/* @Edit_ContactEdit Is Written by ganesh ***/
	public void Edit_ContactEdit() throws Exception {
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, ContactEdit, 20);
		Thread.sleep(2000);
		WaitUtil.waitAndSendKeys(driver, firstName, "Contact_U", 60);
		WaitUtil.waitAndSendKeys(driver, lastName, "A_U", 60);
		WaitUtil.waitAndSendKeys(driver, titleField, "CMP_U", 60);
		WaitUtil.waitAndSendKeys(driver, addressField, "Sri Maruthi Homes, Lingampally_U", 60);
		WaitUtil.waitAndSendKeys(driver, cityField, "Hyderabad_U", 60);
		WaitUtil.waitAndSendKeys(driver, stateField, "Telangana_U", 60);
		WaitUtil.waitAndSendKeys(driver, zipField, "500052", 60);
		WaitUtil.waitAndClick(driver, ContactUpdate, 20);
		WaitUtil.verifyResponseMessage(driver, responsemesage, 20, "Your contact has been updated successfully.");
	}
	
	/* @Edit_ContactDelete Is Written by ganesh ***/
	public void Edit_ContactDelete() throws Exception {
		WaitUtil.waitAndClick(driver, ContactDelete, 20);
		WaitUtil.waitAndClick(driver, yesDelete, 20);
		Thread.sleep(1000);
		WaitUtil.verifyResponseMessage(driver, responsemesage, 60, "Your Contact have been deleted successfully.");
	}
	
	/* @Edit_ContactUnsubscribe Is Written by ganesh ***/
	public void Edit_ContactUnsubscribe() throws Exception {
		Thread.sleep(5000);
		String mailId = driver.findElement(contactMailId).getAttribute("title");
		System.out.println(mailId);
		WaitUtil.waitAndClick(driver, contactNotification, 20);
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, notificationmessage, 20);
		WaitUtil.waitAndClick(driver, Unsubscribe, 20);
		Thread.sleep(5000);
		WaitUtil.verifyResponseMessage(driver, responsemesage, 20, mailId + " has been successfully unsubscribed for receiving the emails from the company: PartnerAuto");
	}
	
	/* @Edit_ContactSubscribe Is Written by ganesh ***/
	public void Edit_ContactSearch(String SearchKeyword) throws InterruptedException {
		Thread.sleep(2000);
		WaitUtil.waitAndSendKeys(driver, editContactSearch, SearchKeyword, 20);
		WaitUtil.waitAndClick(driver, SearchSubmit, 20);
	}
	
	/* @Edit_ContactSubscribe Is Written by ganesh ***/
	public void Edit_ContactSubscribe() throws Exception {		
		Thread.sleep(5000);
		String mailId2 = driver.findElement(contactMailId).getAttribute("title");
		System.out.println(mailId2);
		WaitUtil.waitAndClick(driver, contactNotification, 20);
		WaitUtil.waitAndSendKeys(driver, resubscribecomment, "Resubscribing the Contact", 20);
		WaitUtil.waitAndClick(driver, Subscribe, 20);
		
		WaitUtil.verifyResponseMessage(driver, responsemesage, 20, mailId2 +" has been successfully resubscribed for receiving the emails from the company: PartnerAuto");

	}
	
	/* @Edit_ContactCampaignPublish Is Written by ganesh ***/
	public void Edit_ContactCampaignPublish() throws Exception {
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, contactCampaignLaunch, 20);
	    try {
	        WaitUtil.waitAndClick(driver, entInfoCheckbox, 10);
	        WaitUtil.waitAndClick(driver, shareContentBtn, 10);
	        ScreenshotUtil.captureScreenshot(driver, "campaignlaunchMPartner");
	        WaitUtil.waitAndClick(driver, closingBtn, 10);
	    } catch (Exception e) {
	        String msg = driver.findElement(noCampaignsMsg).getText();
	        System.out.println(msg);
	        ScreenshotUtil.captureScreenshot(driver, "NoCampaignlaunchMPartner");
	        WaitUtil.waitAndClick(driver, unpublishPopupCloseBtn, 10);
	    }
	}
	
	/* @Edit_CreateNewPrivateList Is Written by ganesh ***/
	public void Edit_CreateNewPrivateList() throws Exception {
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, AllCheckbox, 20);
		WaitUtil.waitAndClick(driver, ActionDropdown, 20);
		WaitUtil.waitAndClick(driver, CreateList, 20);
		WaitUtil.waitAndSendKeys(driver, titleField, "NewGP"+timestamp, 20);
		if (ElementUtil.isDisplayed(legalBasisField, driver)) {
			ElementUtil.sendKey(legalBasisField, Keys.ENTER, driver);
			WaitUtil.waitAndSendKeys(driver, legalBasisField, "Legitimate interest - existing customer", 40);
			ElementUtil.sendKey(legalBasisField, Keys.ENTER, driver); // Select from dropdown or confirm
		}
		WaitUtil.waitAndClick(driver, Private, 20);
		WaitUtil.waitAndClick(driver, saveChanges, 20);
	}
	
	/* @Edit_CreateNewPublicList Is Written by ganesh ***/
	public void Edit_CreateNewPublicContactList() throws Exception {
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, AllCheckbox, 20);
		WaitUtil.waitAndClick(driver, ActionDropdown, 20);
		WaitUtil.waitAndClick(driver, CreateList, 20);
		WaitUtil.waitAndSendKeys(driver, titleField, "NewGP"+timestamp, 20);
			ElementUtil.sendKey(legalBasisField, Keys.ENTER, driver);
			WaitUtil.waitAndSendKeys(driver, legalBasisField, "Legitimate interest - existing customer", 40);
			ElementUtil.sendKey(legalBasisField, Keys.ENTER, driver);
		WaitUtil.waitAndClick(driver, saveChanges, 20);
	}
	
	/* @Edit_exportToExcel Is Written by ganesh ***/
	public void Edit_DownloadtempAndexportToExcel() throws Exception {
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, AllCheckbox, 20);
		WaitUtil.waitAndClick(driver, ActionDropdown, 20);
		WaitUtil.waitAndClick(driver, Exportreport, 20);
	}
	
	/* @Edit_MultplecontactsDelete Is Written by ganesh ***/
	public void Edit_MultplecontactsDelete() throws Exception {
		Thread.sleep(2000);
	}
	
	/* @Edit_ContactCampaignAnalytics Is Written by ganesh ***/
	public void Edit_ContactCampaignAnalytics() throws Exception {
		Thread.sleep(2000);
	
	}
	
	/* @Edit_MoveOrMoveToList Is Written by ganesh ***/
	public void Edit_MoveOrMoveToList(By listAction) throws Exception {
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, ActionDropdown, 20);
		WaitUtil.waitAndClick(driver, listAction, 20);
		WaitUtil.waitAndClick(driver, CopyOrMovecontactAllCheckbox, 20);
		WaitUtil.waitAndClick(driver, AddContacts, 20);
		WaitUtil.waitAndClick(driver, closingBtn, 20);
	}
	
	/* @EditContactList Is Written by ganesh ***/
	public void EditContactList() throws Exception {
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, editListButton1, 60);
		Edit_ContactSearch("com");
		Edit_ContactUnsubscribe();
		Edit_ContactSubscribe();
		searchClear();
		Edit_DownloadtempAndexportToExcel();
//		Edit_MoveOrMoveToList(CopyToList);
//		Edit_MoveOrMoveToList(MoveToList);
		Edit_ContactDelete();
		Edit_ContactCampaignPublish();
		Edit_ContactEdit();
//		Edit_ContactCampaignAnalytics();
		hoverContacts_ManageContacts();
		WaitUtil.waitAndClick(driver, editListButton1, 60);
		contactsPage.completeOneAtATimeFlow("Public");
		WaitUtil.waitAndClick(driver, editListButton2, 60);
		contactsPage.uploadCSVContacts("Public", "EditList");		
		WaitUtil.waitAndClick(driver, editListButton1, 60);
		Edit_CreateNewPublicContactList();
		WaitUtil.waitAndClick(driver, editListButton2, 60);
		Edit_CreateNewPrivateList();
		Thread.sleep(3000);
//		WaitUtil.verifyResponseMessage(driver, responsemesage, 20, "");
	}

	/* @SearchTemplate written by Ganesh ***/
	public void searchClear() throws InterruptedException {
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, SearchClear, 20);
	}  
	
	/* @ExportExcelReport written by Ganesh ***/
	public void ExportExcelReport() throws InterruptedException {
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, ExportReport, 20);
	} 

	/* @SearchTemplate written by Ganesh ***/
	public void SearchContact(String searchkeyword) throws InterruptedException {
		Thread.sleep(2000);
		WaitUtil.waitAndSendKeys(driver, ContactSearch, searchkeyword, 20);
		WaitUtil.waitAndClick(driver, SearchSubmit, 20);
		Thread.sleep(3000);	
	}
	
	/* @publishCampaign written by Ganesh ***/
	public void publishCampaign() throws InterruptedException {
	    WaitUtil.waitAndClick(driver, shareListButton, 20);
	    try {
	        WaitUtil.waitAndClick(driver, entInfoCheckbox, 10);
	        WaitUtil.waitAndClick(driver, shareContentBtn, 10);
	        ScreenshotUtil.captureScreenshot(driver, "campaignlaunchMPartner");
	        WaitUtil.waitAndClick(driver, closingBtn, 10);
	    } catch (Exception e) {
	        String msg = driver.findElement(noCampaignsMsg).getText();
	        System.out.println(msg);
	        ScreenshotUtil.captureScreenshot(driver, "NoCampaignlaunchMPartner");
	        WaitUtil.waitAndClick(driver, unpublishPopupCloseBtn, 10);
	    }
	    ScreenshotUtil.captureScreenshot(driver, "publishCampaignScreenshot");
	}
	
	/* @pagination written by Ganesh ***/
	public void pagination() throws InterruptedException {
		Thread.sleep(8000);
		WaitUtil.waitAndClick(driver, nextPage, 20);
		Thread.sleep(8000);
		WaitUtil.waitAndClick(driver, lastPage, 20);
		Thread.sleep(8000);
		WaitUtil.waitAndClick(driver, PreviousPage, 20);
		Thread.sleep(8000);
		WaitUtil.waitAndClick(driver, firstPage, 20);
	}

	/* @ManageContactsTilesCountValidation written by Ganesh ***/
	public void ManageContactsTilesCountValidation() throws InterruptedException {

		xamplifyUtil.TileCountValidation(driver, AllContactsTile, AllContactsTileCount, ContactsTotalCount, 30);
		//xamplifyUtil.TileCountValidation(driver, ExecludedContactTile, ExecludedContactTileCount, ContactsTotalCount, 30);
		xamplifyUtil.TileCountValidation(driver, ValidContactTile, ValidContactTileCount, ContactsTotalCount, 30);
		xamplifyUtil.TileCountValidation(driver, UnsubscribedContactTile, UnsubscribedContactTileCount, ContactsTotalCount, 30);
		xamplifyUtil.TileCountValidation(driver, UndeliverableContactTile, UndeliverableContactTileCount, ContactsTotalCount, 30);
	}
}
