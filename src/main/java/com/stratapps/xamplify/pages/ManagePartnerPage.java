package com.stratapps.xamplify.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.utils.ActionUtil;
import com.stratapps.xamplify.utils.ScreenshotUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class ManagePartnerPage {

	WebDriver driver;
	private WebDriverWait wait;
	long timestamp = System.currentTimeMillis();

	public ManagePartnerPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
    OnboardingPartnerPage onboardingPartnerPage = new OnboardingPartnerPage(this.driver);

	
	public static final By managepartner = By.xpath("//div/div/ul/li[2]/ul/li[2]/a/span");
	public static final By hoverpartner = By.xpath("/html/body/app-root/app-home/div/app-leftsidebar/div/div/ul/li[2]");
	public static final By Alltile = By.xpath("//*[@id='manageContacts']/div/div/div/div/div[1]/div[1]/button");
	public static final By checkAll = By.xpath("//input[@id='checkAllExistingContacts']");
	public static final By Action = By.xpath("//app-manage-contacts/div[1]/div[3]/div/div/div/div/div[3]/div/div/div[1]/div[2]/div[2]/span[1]");
	public static final By CreateGroup = By.xpath("//a[text()=' Create New Group ']");
	public static final By exportexcel = By.xpath("//*[@id='delete_button']");
	public static final By groupName = By.xpath("//input[@id='campaignName']");
	public static final By legalInGroup = By.xpath("//div[@id='multiselect-sample']//input[@placeholder='Select Legal Basis']");
	public static final By savechanges = By.xpath("//*[@id='saveAsModal']/div/div/div[3]/button[2]");
	public static final By exportemail = By.xpath("//app-manage-contacts/div[1]/div[3]/div/div/div/div/div[3]/div/div/div[1]/div[2]/div[2]/span[2]/i");
	public static final By editGroup = By.xpath("(//table[@id='partner_contact_list']//tr)[2]/td/div/a");
	public static final By entinfo = By.xpath("//input[@name='all']");
	public static final By shareContent = By.xpath("(//button[@type='submit'])[7]");
	public static final By unpublishPopupClose = By.xpath("//div[@id='shareUnPublishedContentPopUp']//button[text()='Close']");
	public static final By NoCampaignsMsg = By.xpath("//app-share-campaigns/div[2]/strong");
	public static final By NoAssetMsg = By.xpath("//app-share-assets/div[2]/strong");
	public static final By NoTrackPlaybookMsg = By.xpath("//app-share-tracks-or-playbooks/div[2]/strong");
	public static final By closing = By.xpath("(//button[@type='submit'])[6]");
	public static final By unpublishAssets = By.xpath("//div[@id='shareUnPublishedContentPopUp']//li[contains(text(), 'Assets')]");
	public static final By unpublishTrack = By.xpath("//div[@id='shareUnPublishedContentPopUp']//li[contains(text(), 'Tracks')]");
	public static final By unpublishPlaybook = By.xpath("//div[@id='shareUnPublishedContentPopUp']//li[contains(text(), 'Playbooks')]");
	public static final By oneatatime = By.xpath("//button[@id='add_contact']");
	public static final By acceptTnC = By.xpath("//div[@id='tcModal']/div/div/div[3]/button[2]/span");
	public static final By pContinue = By.xpath("//button[text()='Continue']");
	public static final By uploadCSV = By.xpath("//div[@id='upload_csv']//input[@accept='.csv']");
	public static final By actionCSV = By.xpath("//button[@id='save&delete_button']");
	public static final By saveCSV = By.xpath("//a[@id='save_button']");
	public static final By acceptTnCCSV = By.xpath("//span[text()='Accept']");
	public static final By editpartner = By.xpath("//tr[@id='row_0']/td[9]/div/a[1]/i");
	public static final By updatepartner = By.xpath("//button//span[text()='Update']");
	public static final By search = By.xpath("//input[@placeholder='Search']");
	public static final By publishIcon = By.xpath("//*[@id='partner_contact_list']/tbody/tr/td[6]/div/a[4]/i");
	public static final By managePartner_filter = By.xpath("//*[@id='manageContacts']//span/i[@class='fa fa-filter p10']");

	public static final By sortDropdown = By.xpath("//*[@id=\"manageContacts\"]//div[3]/div[2]/div/div/div[1]/select");
	public static final By searchInput = By.xpath("//input[@placeholder='Search for a group']");
	public static final By searchInputAlltile = By.xpath("//input[@placeholder='Search']");

	public static final By copyAndSaveButton = By.xpath("(//a/i[@class='fa fa-files-o IconCustomization'])[1]");
	public static final By copyAndSaveNameField = By.xpath("//input[@id='campaignName']");
	public static final By saveNameChangesButton = By.xpath("//button[@class='button_blue bgcolor-unset button_height']");
	public static final By uploadCSVInput = By.xpath("//div[@id='upload_csv']//input[@accept='.csv']");
	public static final By legalInput = By.xpath("//*[@id='multiselectelement']/div/div/span[3]/input");
	public static final By actionCSVBtn = By.xpath("//button[@id='save&delete_button']");
	public static final By saveCSVBtn = By.xpath("//a[@id='save_button']");
	public static final By continueBtn = By.xpath("//button[@type='submit']/span[text()='Continue']");
	public static final By acceptTCBtn = By.xpath("//span[text()='Accept']");

	public static final By editGroupBtn = By.xpath("(//table[@id='partner_contact_list']//tr)[2]/td/div/a");
	public static final By oneAtATimeBtn = By.xpath("//button[@id='add_contact']");
	public static final By editPartnerIcon = By.xpath("//tr[@id='row_0']/td[9]/div/a[1]/i");
	public static final By updatePartnerBtn = By.xpath("//button//span[text()='Update']");
	public static final By searchBox = By.xpath("//input[@placeholder='Search']");

	public static final By searchManageGroup = By.xpath("//input[@placeholder='Search for a group']");
	public static final By publishIconBtn = By.xpath("//*[@id='partner_contact_list']/tbody/tr/td[6]/div/a[4]/i");
	public static final By entInfoCheckbox = By.xpath("//input[@name='all']");
	public static final By shareContentBtn = By.xpath("(//button[@type='submit'])[7]");
	public static final By closingBtn = By.xpath("(//button[@type='submit'])[6]");
	public static final By noCampaignsMsg = By.xpath("//app-share-campaigns/div[2]/strong");
	public static final By noAssetsMsg = By.xpath("//app-share-assets/div[2]/strong");
	public static final By noTracksMsg = By.xpath("//app-share-tracks-or-playbooks/div[2]/strong");
	public static final By unpublishPopupCloseBtn = By.xpath("//div[@id='shareUnPublishedContentPopUp']//button[text()='Close']");
	public static final By unpublishAssetsTab = By.xpath("//div[@id='shareUnPublishedContentPopUp']//li[contains(text(), 'Assets')]");
	public static final By unpublishTracksTab = By.xpath("//div[@id='shareUnPublishedContentPopUp']//li[contains(text(), 'Tracks')]");
	public static final By unpublishPlaybookTab = By.xpath("//div[@id='shareUnPublishedContentPopUp']//li[contains(text(), 'Playbooks')]");
	public static final By managePartnerFilter = By.xpath("//*[@id='manageContacts']//span/i[@class='fa fa-filter p10']");

	public static final By searchManageInput = By.xpath("//input[@placeholder='Search for a group']");
	public static final By deleteManageBtn = By.xpath("//table[@id='partner_contact_list']/tbody/tr[1]/td[6]/div/a[3]/i");
	public static final By deleteManageListConfirmBtn = By.xpath("//button[@class='swal2-confirm styled']");

	public static final By allTile = By.xpath("//*[@id='manageContacts']/div/div/div/div/div[1]/div[1]/button");
	public static final By actionBtn = By.xpath("//app-manage-contacts/div[1]/div[3]/div/div/div/div/div[3]/div/div/div[1]/div[2]/div[2]/span[1]");
	public static final By exportExcel = By.xpath("//*[@id='delete_button']");
	public static final By paginationPage2 = By.xpath("//ul[@class='pagination padding']//a[text()='2']");
	public static final By xamplifyLogo = By.xpath("//div[@class='company-logo-thumbnail-wrapper']");

	public static final By proceedButton = By.xpath("//button[@type='submit']/span[text()='Proceed']");
	public static final By continueButton = By.xpath("//button[text()='Continue']");
	public static final By acceptTermsButton = By.xpath("//div[@id='tcModal']/div/div/div[3]/button[2]/span");

	//------------------------------------------------------------------------------------------------------------
	
	
	public void HoverOnPartnersManagePartners() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, 0);");
	    ActionUtil.hover(driver, hoverpartner);
	    ActionUtil.hoverAndClick(driver, managepartner);
	}

	public void CreateNewPartnerGroup() throws InterruptedException {
	    WebElement allTile = WaitUtil.waitForVisibility(driver, Alltile, 10);
	    WaitUtil.waitForElementClickable(driver, Alltile, 10).click();
	    WaitUtil.waitForElementClickable(driver, checkAll, 10).click();
	    WaitUtil.waitForElementClickable(driver, Action, 10).click();
	    WaitUtil.waitForElementClickable(driver, CreateGroup, 10).click();
	    WaitUtil.waitAndSendKeys(driver, groupName, "NewGroup" + System.currentTimeMillis(), 10);
	    WaitUtil.waitAndSendKeys(driver, legalInGroup, "Legitimate interest - prospect/lead", 10);
	    driver.findElement(legalInGroup).sendKeys(Keys.ENTER);
	    WaitUtil.waitForElementClickable(driver, savechanges, 10).click();
	    Thread.sleep(3000);
	    ScreenshotUtil.captureScreenshot(driver, "newGroupManagePartner");
	}
	
	public void exportToMail() throws InterruptedException {
	    WebElement allTile = WaitUtil.waitForVisibility(driver, Alltile, 10);
	    WaitUtil.waitForElementClickable(driver, Alltile, 10).click();
	    WaitUtil.waitForElementClickable(driver, checkAll, 10).click();
	    WaitUtil.waitForElementClickable(driver, exportemail, 10).click();
	    Thread.sleep(3000);
	    ScreenshotUtil.captureScreenshot(driver, "exportMailManagePartner");
	}

	public void Mpartners_Sortandsearch_Copyandsavegroup() throws InterruptedException {
	    Select sortby1 = new Select(WaitUtil.waitForElementVisible(driver, sortDropdown, 10));
	    sortby1.selectByIndex(2);
	    ScreenshotUtil.captureScreenshot(driver, "sortManagePartner");
	    // Search for Partner Group
	    WaitUtil.waitForElementClickable(driver, searchInput, 10).click();
	    WaitUtil.waitAndSendKeys(driver, searchInput, "group", 10);
	    driver.findElement(searchInput).sendKeys(Keys.ENTER);
	    ScreenshotUtil.captureScreenshot(driver, "SearchManagePartner");
	    // Sort again by index 4
	    sortby1.selectByIndex(4);
	    // Copy and Save Partner Group
	    WaitUtil.waitForElementClickable(driver, copyAndSaveButton, 10).click();
	    WebElement nameField = WaitUtil.waitForElementVisible(driver, copyAndSaveNameField, 10);
	    nameField.clear();
	    WaitUtil.waitAndSendKeys(driver, copyAndSaveNameField, "automated list_" + System.currentTimeMillis(), 10);
	    WaitUtil.waitForElementClickable(driver, saveNameChangesButton, 10).click();
	    ScreenshotUtil.captureScreenshot(driver, "CopyandsaveGroup");
	}

	public  void oneAtATime_EditGroup() throws InterruptedException {
	    // Step 1: Fill the partner form
	    onboardingPartnerPage.onboardpartnerForm();
	    // Step 2: Click proceed button
	    WaitUtil.waitForElementClickable(driver, proceedButton, 10).click();
	    // Step 3: Click continue button
	    WaitUtil.waitForElementClickable(driver, continueButton, 10).click();
	    // Step 4: Accept Terms and Conditions
	    WaitUtil.waitForElementClickable(driver, acceptTermsButton, 10).click();
	    Thread.sleep(3000);
	    ScreenshotUtil.captureScreenshot(driver, "OneataTime");
	}

	public void uploadCsv_EditGroup() throws InterruptedException {
	    // Wait before upload starts
	    String filePath = OnboardingPartnerPage.CreateCSVFile();
	    // Upload CSV file
	    WebElement uploadElement = driver.findElement(uploadCSVInput);
	    uploadElement.sendKeys(filePath);
	    // Select Legal Basis
	    WaitUtil.waitAndSendKeys(driver, legalInput, "Legitimate interest - prospect/lead", 10);
		driver.findElement(legalInput).sendKeys(Keys.ENTER);
	    // Click action and save buttons
	    WaitUtil.waitForElementClickable(driver, actionCSVBtn, 10).click();
	    WaitUtil.waitForElementClickable(driver, saveCSVBtn, 10).click();
	    // Click Continue and Accept T&C
	    WaitUtil.waitForElementClickable(driver, continueBtn, 10).click();
	    WaitUtil.waitForElementClickable(driver, acceptTCBtn, 10).click();
	    Thread.sleep(3000);
	    ScreenshotUtil.captureScreenshot(driver, "Upload CSV EditGroup");
	}

	
	public void Mpartners_EditGroup() throws InterruptedException {
	    WaitUtil.waitForElementClickable(driver, editGroupBtn, 10).click();
	    WaitUtil.waitForElementClickable(driver, oneAtATimeBtn, 10).click();
	    // Upload One At a Time in edit Group
	    oneAtATime_EditGroup();
	    HoverOnPartnersManagePartners();
	    WaitUtil.waitForElementClickable(driver, editGroupBtn, 10).click();
	    // Upload Csv in edit Group
	    uploadCsv_EditGroup();
	    // Edit and update the partner
	    WaitUtil.waitForElementClickable(driver, editGroupBtn, 10).click();
	    WaitUtil.waitForElementClickable(driver, editPartnerIcon, 10).click();
	    onboardingPartnerPage.updatepartnerForm();
	    WaitUtil.waitForElementClickable(driver, updatePartnerBtn, 10).click();
	    Thread.sleep(3000);
	    ScreenshotUtil.captureScreenshot(driver, "updatePartnerInGroup");
	    // Search the partner in partner group
	    String searchKey = OnboardingPartnerPage.getMailId;
	    WaitUtil.waitForElementClickable(driver, searchBox, 10).click();
	    WaitUtil.waitAndSendKeys(driver, searchBox, searchKey, 10);
	    driver.findElement(searchBox).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    ScreenshotUtil.captureScreenshot(driver, "SearchpartnerInGroup");
	}

	public void Mpartners_publishContent() throws InterruptedException {
	    // Search and publish campaigns
	    driver.findElement(searchManageGroup).clear();
	    WaitUtil.waitAndSendKeys(driver, searchManageGroup, "group", 10);
	    driver.findElement(searchManageGroup).sendKeys(Keys.ENTER);
	    WaitUtil.waitForElementClickable(driver, publishIconBtn, 20);
	    WaitUtil.waitAndClick(driver, publishIconBtn, 10);

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

	    // Publish assets
	    WaitUtil.waitAndClick(driver, publishIconBtn, 15);
	    WaitUtil.waitAndClick(driver, unpublishAssetsTab, 10);

	    try {
	        WaitUtil.waitAndClick(driver, entInfoCheckbox, 10);
	        WaitUtil.waitAndClick(driver, shareContentBtn, 10);
	        ScreenshotUtil.captureScreenshot(driver, "AssetlaunchMPartner");
	        WaitUtil.waitAndClick(driver, closingBtn, 10);
	    } catch (Exception e) {
	        String msg = driver.findElement(noAssetsMsg).getText();
	        System.out.println(msg);
	        ScreenshotUtil.captureScreenshot(driver, "noAssetslaunchMPartner");
	        WaitUtil.waitAndClick(driver, unpublishPopupCloseBtn, 10);
	    }

	    // Publish tracks
	    WaitUtil.waitAndClick(driver, publishIconBtn, 15);
	    WaitUtil.waitAndClick(driver, unpublishTracksTab, 10);

	    try {
	        WaitUtil.waitAndClick(driver, entInfoCheckbox, 10);
	        WaitUtil.waitAndClick(driver, shareContentBtn, 10);
	        ScreenshotUtil.captureScreenshot(driver, "TracklaunchMPartner");
	        WaitUtil.waitAndClick(driver, closingBtn, 10);
	    } catch (Exception e) {
	        String msg = driver.findElement(noTracksMsg).getText();
	        System.out.println(msg);
	        ScreenshotUtil.captureScreenshot(driver, "noTracklaunchMPartner");
	        WaitUtil.waitAndClick(driver, unpublishPopupCloseBtn, 10);
	    }

	    // Publish playbooks
	    WaitUtil.waitAndClick(driver, publishIconBtn, 15);
	    WaitUtil.waitAndClick(driver, unpublishPlaybookTab, 10);

	    try {
	        WaitUtil.waitAndClick(driver, entInfoCheckbox, 10);
	        WaitUtil.waitAndClick(driver, shareContentBtn, 10);
	        ScreenshotUtil.captureScreenshot(driver, "PlaybooklaunchMPartner");
	        WaitUtil.waitAndClick(driver, closingBtn, 10);
	    } catch (Exception e) {
	        String msg = driver.findElement(noTracksMsg).getText();
	        System.out.println(msg);
	        ScreenshotUtil.captureScreenshot(driver, "noPlaybooklaunchMPartner");
	        WaitUtil.waitAndClick(driver, unpublishPopupCloseBtn, 10);
	    }

	    ScreenshotUtil.captureScreenshot(driver, "finalScreenshotMPartner");
	}

	public void filterManagePartner(String Field, String Condition, String Value) throws InterruptedException {
	    WaitUtil.waitAndClick(driver, managePartnerFilter, 10);
	    onboardingPartnerPage.applyFilter(Field, Condition, Value);
	}
	
	public void Mpartners_DeleteGroup() throws InterruptedException {
	    WaitUtil.waitAndClick(driver, searchManageInput, 10);
	    WaitUtil.waitAndSendKeys(driver, searchManageInput, "groupName", 10);
	    driver.findElement(searchManageInput).sendKeys(Keys.ENTER);
	    WaitUtil.waitAndClick(driver, deleteManageBtn, 15);
	    WaitUtil.waitAndClick(driver, deleteManageListConfirmBtn, 10);
	    ScreenshotUtil.captureScreenshot(driver, "DeleteManagePartner");
	}

	public void exportToExcel() throws InterruptedException {
	    // Click All Tile
	    WebElement allTileElement = wait.until(ExpectedConditions.elementToBeClickable(allTile));
	    allTileElement.click();
	    // Search for the partner using email
	    WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputAlltile));
	    searchBox.click();
	    searchBox.sendKeys("user");
	    //searchBox.sendKeys(OnboardingPartnerPage.getMailId);
	    searchBox.sendKeys(Keys.ENTER);
	    // Click 'Check All'
	    WebElement checkAllElement = wait.until(ExpectedConditions.elementToBeClickable(checkAll));
	    checkAllElement.click();
	    // Click 'Action' Button
	    WebElement actionElement = wait.until(ExpectedConditions.elementToBeClickable(actionBtn));
	    actionElement.click();
	    // Click 'Export to Excel'
	    WebElement exportExcelElement = wait.until(ExpectedConditions.elementToBeClickable(exportExcel));
	    exportExcelElement.click();
	    // Capture screenshot
	    ScreenshotUtil.captureScreenshot(driver, "exportExcelManagePartner");
	}

	public void pagenation() throws Throwable {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, 2000)");
	    WaitUtil.waitAndClick(driver, paginationPage2, 10);
	    Thread.sleep(2000);
	    ScreenshotUtil.captureScreenshot(driver, "pagination2");
	}
	
	public void backToHome() {
	    WaitUtil.waitAndClick(driver, xamplifyLogo, 10);
	}

}
