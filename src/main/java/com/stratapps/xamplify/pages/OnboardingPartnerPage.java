package com.stratapps.xamplify.pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.stratapps.xamplify.utils.ActionUtil;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.ScreenshotUtil;
import com.stratapps.xamplify.utils.WaitUtil;
import com.stratapps.xamplify.utils.xamplifyUtil;

public class OnboardingPartnerPage {
WebDriver driver;
private WebDriverWait wait;
long timestamp = System.currentTimeMillis();

public OnboardingPartnerPage(WebDriver driver) {
this.driver = driver;
this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
}

public static final By hoverPartner = By.xpath("/html/body/app-root/app-home/div/app-leftsidebar/div/div/ul/li[2]");
public static final By onboardingPartner = By.xpath("/html/body/app-root/app-home/div/app-leftsidebar/div/div/ul/li[2]/ul/li[1]/a/span");
public static final By oneAtATime = By.xpath("//button[@id='addContacts']");
public static final By legalBasis = By.xpath("//input[@class='e-dropdownbase']");
public static final By vertical = By.xpath("//input[@id='vertical']");
public static final By region = By.xpath("//input[@id='region']");
public static final By partnerType = By.xpath("//input[@id='partnerType']");
public static final By category = By.xpath("//input[@id='category']");
public static final By firstName = By.xpath("//input[@id='firstName']");
public static final By lastName = By.xpath("//input[@id='lastName']");
public static final By companyName = By.xpath("//input[@id='company']");
public static final By jobTitle = By.xpath("//input[@id='title']");
public static final By emailId1 = By.xpath("//input[@id='email1']");
public static final String oneAtATimeEmailId = "automated_partner@analytify.com";
public static final By address = By.xpath("//input[@id='address']");
public static final By city = By.xpath("//input[@id='city']");
public static final By state = By.xpath("//input[@id='state']");
public static final By zipCode = By.xpath("//input[@id='zip']");
public static final By country = By.xpath("//select[@placeholder='Country']");
public static final By countryCode = By.xpath("//input[@placeholder='Enter your mobile no']");
public static final By savePartner = By.xpath("//*[@id='addContactModal']/div/div/div[3]/button[2]");
public static final By acceptTerms = By.xpath("//body/app-root[1]/app-home[1]/div[1]/div[1]/app-add-partners[1]/div[4]/div[1]/div[1]/div[3]/button[2]");
public static final By addContacts = By.xpath("/html/body/app-root/app-home/div/div/app-add-partners/div[7]/div/div/div[2]/div/table/tbody/tr[1]/td[2]/input");
public static final By contactsLimit = By.xpath("//input[@name='contactsLimit']");
public static final By signupNotification = By.xpath("//span[@class='bootstrap-switch-label']");
public static final By teamMemberGroup = By.xpath("//select[@id='partner-tm-group-0']");
public static final By option = By.xpath("//select[@id='partner-tm-group-0']");
public static final By save = By.xpath("//button[contains(text(),'Save')]");
public static final By checkBox = By.xpath("(//input[@name='partnerModuleTeamMembersCheckBox-0[]'])[1]");
public static final By checkBox1 = By.xpath("//th//input[@id='checkAllExistingContacts']");
public static final By proceed = By.xpath("(//button//span[@class='btn Btn-Green transition txt_pd-top3'])[7]");
public static final By oneAtATimeProceed = By.xpath("//button[@type='submit']/span[text()='Proceed']");
public static final By continueBtn = By.xpath("(//button[@class='button bgcolor-unset'])[4]");
public static final By save1 = By.xpath("//*[@id='assignContactAndMdfPopup']/div/div/div[3]/button[1]");
public static final By download = By.xpath("//strong[contains(text(),'Download File')]");
public static final By drop = By.xpath("//input[@class='e-dropdownbase']");
public static final By clip = By.xpath("//textarea[@id='copyFromclipTextArea']");
public static final By cfcField = By.xpath("/html/body/app-root/app-home/div/div/app-add-partners/div[1]/div[3]/div[5]/div/div/div[3]/textarea");
public static final String cfcFieldId = "copyFromclipTextArea";
public static final By proceed1 = By.xpath("(//button[@class='button bgcolor-unset'])[6]");
public static final By uploadCsv = By.xpath("/html/body/app-root/app-home/div/div/app-add-partners/div[1]/div[3]/div[1]/form/div/div[1]/div/div[2]/div/span");
public static final By uploadCsvInput = By.xpath("//button[@id='uploadCSV']//input[@accept='.csv']");
public static final By exportToExcel = By.xpath("//body/app-root/app-home/div/div/app-add-partners/div[1]/div[3]/div[2]/ul/li[4]/a");
public static final By search = By.xpath("//input[@placeholder='Search']");
public static final By clear = By.xpath("/html/body/app-root/app-home/div/div/app-add-partners/div[1]/div[3]/div[6]/div/div/div[1]/div[2]/div[2]/div/button[1]");
public static final By sort = By.xpath("//select[@class='form-control SeclectBoxPaddingsAbj search_sort_shadows ng-untouched ng-pristine ng-valid']");
public static final By noOfRecordsInPage = By.xpath("(//app-pagination/div/div/select)[2]");
public static final By partnerAnalytics = By.xpath("(//a[@title='Campaign Analytics'])[1]");
public static final By managePartner = By.xpath("/html/body/app-root/app-home/div/app-leftsidebar/div/div/ul/li[2]/ul/li[2]/a/i");
public static final By resendEmail = By.xpath("(//a[@class='custom-icon'])[4]");
public static final By sendMail = By.xpath("//*[@id='envolope_0']");
public static final By editPartner = By.xpath("//*[@id='edit_0']/i");
public static final By updatePartner2 = By.xpath("//*[@id='addContactModal']/div/div/div[3]/button[2]/span");
public static final By yesDeleteIt = By.xpath("//button[text()='Yes, delete it!']");
public static final By checkAllCampaigns = By.xpath("//input[@id='checkAllCampaigns']");
public static final By closeAnalytics = By.xpath("(//i[@class='fa fa-home'])[1]");
public static final By dropDownMultiSelect = By.xpath("//*[@id='multiselectelement']/div/div/span[3]/input");
public static final By legalInGroup = By.xpath("//div[@id='multiselect-sample']//input[@placeholder='Select Legal Basis']");
public static final By updatePartnerLegalBasis = By.xpath("//*[@id='multiselectelement']/div/div/span[3]/input");
public static final By updateButton = By.xpath("//*[@id='addContactModal']/div/div/div[3]/button[2]");
public static final By searchOnboard = By.xpath("/html/body/app-root/app-home/div/div/app-add-partners/div[1]/div[3]/div[6]/div/div/div[1]/div[2]/div[2]/div/input");
public static final By deletePartnerOnboard = By.xpath("//a[@id='delete_0']");
public static final By phoneNumber = By.xpath("//input[@placeholder='Enter your mobile no']");
public static final By downloadPartners = By.xpath("//a[@id='exportToExcel']");
public static final By saveAndDelete = By.xpath("//button[@id='save&delete_button']");
public static final By createNewList = By.xpath("//a[@id='saveAs_button']");
public static final By createNewListName = By.xpath("//input[@id='campaignName']");
public static final By saveCreateNewList = By.xpath("(//button[@class='button_blue bgcolor-unset'])[4]");
public static final By csvPartnerSave = By.xpath("//button[@id='save_button']/span[text()='Save']");
public static final By pContinue = By.xpath("//button[@type='submit']/span[text()='Continue']");
public static final By successMsg = By.xpath("//span[text()='Your Partner(s) have been saved successfully']");
public static final By actionBtn = By.xpath("//button[@id='save&delete_button']");
public static final By exportToMail = By.xpath("//div[@class='portlet-title']//button[@data-placement='bottom']");
public static final By newGroup = By.xpath("//a[@id='saveAs_button']");
public static final By saveNewGroup = By.xpath("//*[@id='saveAsModal']/div/div/div[3]/button[2]/span");
public static final By addToGroup = By.xpath("//a[text()=' Add To Groups']");
public static final By groupCheckbox = By.xpath("//input[@id='copy-group-users-header-checkbox-id']");
public static final By addPartnerToGroup = By.xpath("//button[@type='submit']//span[text()='Add']");
public static final By closePopup = By.xpath("//*[@id='copyGroupUsersModalPopup']/div/div/div[3]/button");
public static final By modernPopupClose = By.xpath("//*[@id='copyGroupUsersModalPopup']/div/div/div[1]/button");
public static final By countryCodeDropdown = By.xpath("//span[@class='dropdown-arrow']");
public static final By countryCodeSearch = By.xpath("//input[@id='phoneInput']");
public static final By selectCountryCode = By.xpath("//ul[@class='dropdown-options']/li");
public static final By phoneField = By.xpath("//input[@placeholder='Enter your mobile no']");

public static final By partnerFilter = By.xpath("//span//i[@class='fa fa-filter p10']/../..");
public static final By partnerFilterFieldName = By.xpath("//b[text()='1']/..//select[@class='form-control ng-untouched ng-pristine ng-valid']");
public static final By partnerFilterCondition = By.xpath("//select[@class='form-control responsiveMargin ng-untouched ng-pristine ng-valid']");
public static final By partnerFilterValue = By.xpath("//input[@placeholder='value*']");
public static final By filterSubmit = By.xpath("//button[text()='Submit']");
public static final By addFilterRecord = By.xpath("//div[@class='col-md-1 p0 positionForAddandDelete']//button");
public static final By deleteFilterRecord = By.xpath("//b[text()='1']/../..//div[@class='col-md-1 p0 positionForAddandDelete']//span/i");

public static final By partnerFilterFieldName2 = By.xpath("//b[text()='2']/..//select[@class='form-control ng-untouched ng-pristine ng-valid']");
public static final By partnerFilterCondition2 = By.xpath("//b[text()='2']/../..//select[@class='form-control responsiveMargin ng-untouched ng-pristine ng-valid']");
public static final By partnerFilterValue2 = By.xpath("//b[text()='2']/../..//input[@placeholder='value*']");

public static final By mpartnerFlag = By.xpath("//*[@id='blur-content-div']//app-country-phone-input//div/span[@class='flag-icon flag-icon-']");
public static final By mpartnerFlagCode = By.xpath("//*[@id='blur-content-div']//app-country-phone-input//div[@class='search-box']/input");
public static final By mpartnerFlagCodeSelect = By.xpath("//*[@id='blur-content-div']//app-country-phone-input//li/span[2]");
public static final By phoneNumberInput = By.xpath("//app-country-phone-input/div/div/div[2]/input");

public static final By paginationPage2 = By.xpath("//ul[@class='pagination padding']//a[text()='2']");
public static final By paginationLast = By.xpath("//ul[@class='pagination padding']//a/span/i[@data-original-title='Last']");
public static final By paginationFirst = By.xpath("(//ul[@class='pagination padding']//a/span/i[@title='First'])[2]");

public static final By editList = By.xpath("//a/i[@class='fa fa-pencil-square-o IconCustomization']");
public static final By editingList = By.xpath("(//a/i[@class='fa fa-pencil-square-o IconCustomization'])[1]");
public static final By companyEditName = By.xpath("//input[@id='company']");
public static final By updatedBtn = By.xpath("(//button[@class='button bgcolor-unset'])[2]");
public static final By campaignList = By.xpath("//*[@id='manageContacts']/div[1]/div/div/div/div[4]/div/div/div[2]/div[3]/div/div/table/tbody/tr[1]/td[9]/div/a[2]/i");
public static final By campaignAnalytics = By.xpath("//*[@id='manageContacts']/div[1]/div/div/div/div[4]/div/div/div[2]/div[3]/div/div/table/tbody/tr[1]/td[9]/div/a[3]/i");

public static final By closesBtn = By.xpath("/html/body/app-root/app-home/div/div/app-user-campaigns-list-util/div/div[1]/a");
public static final By entityForPartners = By.xpath("//*[@id='checkAllExistingContacts']");
public static final By copyAndSave = By.xpath("(//a/i[@class='fa fa-files-o IconCustomization'])[1]");
public static final By copyAndSaveName = By.xpath("//input[@id='campaignName']");
public static final By saveNameChanges = By.xpath("//button[@class='button_blue bgcolor-unset button_height']");
public static final By downloadList = By.xpath("//*[@id='partner_contact_list']/tbody/tr[2]/td[6]/div/a[3]/i");

public static final By dropDown = By.xpath("//*[@id='multiselectelement']/div/div/span[3]/input");
public static final By entInfo = By.xpath("//input[@name='all']");
public static final By deleteManage = By.xpath("//table[@id='partner_contact_list']/tbody/tr[1]/td[6]/div/a[3]/i");
public static final By deleteManageList = By.xpath("//button[@class='swal2-confirm styled']");

public static final By sharingCampaigns = By.xpath("(//button[@type='submit'])[7]");
public static final By closing = By.xpath("(//button[@type='submit'])[6]");
public static final By publishContentIcon = By.xpath("(//*[@id='partner_contact_list']/tbody/tr/td[6]/div/a[4]/i)[1]/..");

public static final By legallInput = By.xpath("//*[@id='multiselectelement']/div/div/span[3]/input");
public static final By legalInGroupInput = By.xpath("//div[@id='multiselect-sample']//input[@placeholder='Select Legal Basis']");
public static final By button12 = By.xpath("//*[@id='saveAsModal']/div/div/div[3]/button[2]");
public static final By nameOfTheList = By.xpath("//*[@id='campaignName']");

public static final By updatePartnerLegalBasisInput = By.xpath("//*[@id='multiselectelement']/div/div/span[3]/input");
public static final By updateButton2 = By.xpath("//*[@id='addContactModal']/div/div/div[3]/button[2]");
public static final By searchOnboardInput = By.xpath("/html/body/app-root/app-home/div/div/app-add-partners/div[1]/div[3]/div[6]/div/div/div[1]/div[2]/div[2]/div/input");
public static final By deletePartnerOnboardBtn = By.xpath("//a[@id='delete_0']");

public static final By legalActive = By.xpath("//*[@id='multiselectelement']/div/div/span[3]/input");
public static final By phoneNumberField = By.xpath("//input[@placeholder='Enter your mobile no']");

public static final By manageTab = By.xpath("//*[@id='manageContacts']/app-edit-contacts/div[1]/ul/li[2]/a");
public static final By share1 = By.xpath("//*[@id='partner_contact_list']/tbody/tr[2]/td[6]/div/a[4]/i");

public static final By allCampaignsCheckBox = By.xpath("//*[@id='checkAllCampaigns']");
public static final By shareAllCampaigns = By.xpath("//*[@id='sendCampaignsPopup']/div/div/div[3]/button[1]");
public static final By closeSharePopup = By.xpath("//*[@id='sendCampaignsPopup']/div/div/div[1]/button");

public static final By selectedTeamMember = By.xpath("(//input[@class='checkBox_shadow'])[1]");
public static final By continueToAdd = By.xpath("(//button[@type='submit'])[10]");

public static final By searchClick = By.xpath("(//button[@class='search-box-item-click'])[1]");
public static final By allTile = By.xpath("(//a[@class='more'])[1]");
public static final By registeredTile = By.xpath("(//a[@class='more'])[2]");
public static final By unregisteredTile = By.xpath("(//a[@class='more'])[3]");
public static final By selectPartners = By.xpath("(//input[@id='checkAllExistingContacts'])[2]");

public static final By xamplifyLogo = By.xpath("//app-home//div[1]/div[1]/img");

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

static String uniqueEmail = "user" + System.currentTimeMillis() + "@gmail.com";
static String getMailId = "";
static String uniquecompany = "";

        ///. @CreateCSVFile('Generative CSV with data') is written by Ganesh ./
public static String CreateCSVFile() {
getMailId = "user" + System.currentTimeMillis() + "@gmail.com";
uniquecompany = "company" + System.nanoTime();
List<String[]> partnerUserData = Arrays.asList(
new String[] {
"AutomationUser", "Test", "uACCOUNT NAME", "uACCOUNT OWNER", "uACCOUNT SUB TYPE",
"cm1" + uniquecompany, "uCOMPANY DOMAIN", "uJOBTITLE", "us1" + getMailId, "", "uVERTICAL,uREGION",
"uTERRITORY", "uTYPE","uCATEGORY", "uKondapur", "uHyderabad", "uTelangana", "534350", "India", "2125554567" },
new String[] { "AutomationUser", "Test", "uACCOUNT NAME", "uACCOUNT OWNER", "uACCOUNT SUB TYPE",
"cm2" + uniquecompany, "COMPANY DOMAIN", "JOBTITLE", "us2" + getMailId, "", "VERTICAL,REGION",
"uTERRITORY", "uTYPE","uCATEGORY", "uKondapur", "uHyderabad", "uTelangana", "534350", "India", "+919999088099" });
// Step 3: Generate CSV dynamically and get the file path
String filePath = xamplifyUtil.generatePartnerCSV(partnerUserData);
return filePath;
}

///. @onboardpartnerForm is written by Ganesh ./
public  void onboardpartnerForm() throws InterruptedException {
Thread.sleep(2000);
getMailId = "user" + System.currentTimeMillis() + "@gmail.com";
uniquecompany = "company" + System.nanoTime();
Thread.sleep(3000);
WaitUtil.waitAndSendKeys(driver, emailId1, getMailId, 10);
WaitUtil.waitAndSendKeys(driver, companyName, uniquecompany, 10);
WaitUtil.waitAndSendKeys(driver, firstName, "firstname", 10);
WaitUtil.waitAndSendKeys(driver, lastName, "lastname", 10);
WaitUtil.waitAndSendKeys(driver, jobTitle, "jobtitle", 10);
WaitUtil.waitAndSendKeys(driver, address, "address", 10);
WaitUtil.waitAndSendKeys(driver, city, "city", 10);
WaitUtil.waitAndSendKeys(driver, state, "state", 10);
WaitUtil.waitAndSendKeys(driver, zipCode, "123456", 10);
WaitUtil.waitAndSendKeys(driver, vertical, "vertical", 10);
WaitUtil.waitAndSendKeys(driver, region, "Region", 10);
WaitUtil.waitAndSendKeys(driver, category, "category", 10);
WaitUtil.waitAndSendKeys(driver, partnerType, "Partnertype", 10);

WaitUtil.waitAndClick(driver, countryCodeDropdown, 10);
WaitUtil.waitAndSendKeys(driver, countryCodeSearch, "+91", 10);
WaitUtil.waitAndClick(driver, selectCountryCode, 10);

xamplifyUtil.sendmobileTextEvent(driver, phoneNumber, "9908899088");

WaitUtil.waitAndSendKeys(driver, legallInput, "Legitimate interest - prospect/lead", 10);
driver.findElement(legallInput).sendKeys(Keys.ENTER);
Thread.sleep(4000);
}

        ///. Update partner form ./
public void updatepartnerForm() throws InterruptedException {
Thread.sleep(2000);
WaitUtil.waitAndSendKeys(driver, firstName, "firstname7", 10);
WaitUtil.waitAndSendKeys(driver, lastName, "lastname7", 10);
WaitUtil.waitAndSendKeys(driver, jobTitle, "jobtitle7", 10);
WaitUtil.waitAndSendKeys(driver, address, "address7", 10);
WaitUtil.waitAndSendKeys(driver, city, "city7", 10);
WaitUtil.waitAndSendKeys(driver, state, "state7", 10);
WaitUtil.waitAndSendKeys(driver, zipCode, "1234567", 10);
WaitUtil.waitAndSendKeys(driver, vertical, "vertical7", 10);
WaitUtil.waitAndSendKeys(driver, region, "Region7", 10);
WaitUtil.waitAndSendKeys(driver, category, "category7", 10);
WaitUtil.waitAndSendKeys(driver, partnerType, "Partnertype7", 10);
WaitUtil.waitAndClick(driver, countryCodeDropdown, 10);
WaitUtil.waitAndSendKeys(driver, countryCodeSearch, "+91", 10);
WaitUtil.waitAndClick(driver, selectCountryCode, 10);
xamplifyUtil.sendmobileTextEvent(driver, phoneNumber, "9908899088");
Thread.sleep(2000);
}

// Hover on Partner module and open Onboarding partner
public void HoverPartners_OnboardingPartner( ) throws InterruptedException {
Thread.sleep(3000);
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollTo(0, 0);");
ActionUtil.hover(driver, hoverPartner);
ActionUtil.hoverAndClick(driver, onboardingPartner);
}

public  void OnboardParnerThroughUploadCSV() throws InterruptedException {
   String filePath = CreateCSVFile();
   Thread.sleep(5000);
   System.out.println(filePath);
   try {
  // WaitUtil.waitAndSendKeys(driver, uploadCsvInput, filePath, 10);

  WebElement uploadElement = driver.findElement(uploadCsvInput);
  uploadElement.sendKeys(filePath);
} catch (Exception e) {
// TODO: handle exception
System.out.println(e);
}
  // WebElement uploadElement = WaitUtil.waitForElementVisible(driver, uploadCsvInput, 10);
  // uploadElement.sendKeys(filePath);
   WaitUtil.waitAndSendKeys(driver, legallInput, "Legitimate interest - prospect/lead", 10);
   WaitUtil.waitForElementPresent(driver, legallInput, 10).sendKeys(Keys.ENTER);
   Thread.sleep(3000);
   WaitUtil.waitAndClick(driver, csvPartnerSave, 10);
   WaitUtil.waitAndClick(driver, acceptTerms, 10);
   WaitUtil.waitAndClick(driver, pContinue, 10);
ScreenshotUtil.captureScreenshot(driver, "Upload CSV");
}


// Onboarding partner through One At a Time
public void OnboardPartnerOneAtaTime() throws InterruptedException {
Thread.sleep(6000);
   WaitUtil.waitAndClick(driver, oneAtATime, 10);
   onboardpartnerForm();
   WaitUtil.waitAndClick(driver, oneAtATimeProceed, 10);
   WaitUtil.waitAndClick(driver, acceptTerms, 10);
   WaitUtil.waitAndClick(driver, pContinue, 10);
   ScreenshotUtil.captureScreenshot(driver, "OneataTime");
}


// Edit the partner and update the partner details
public  void partnerEdit() throws InterruptedException {
   HoverPartners_OnboardingPartner();
   WaitUtil.waitAndClick(driver, editPartner, 10);
   updatepartnerForm();
   WaitUtil.waitAndClick(driver, updatePartner2, 10);
   ScreenshotUtil.captureScreenshot(driver, "updatePartner");
}



// search partner and verify search result contain search word
public void searchAndVerifyPartner() throws InterruptedException {
Thread.sleep(3000);
   String searchKeyword = getMailId;
Thread.sleep(6000);
   // Step 1: Perform search
   WaitUtil.waitAndSendKeys(driver, search, searchKeyword, 30);
Thread.sleep(2000);
   driver.findElement(search).sendKeys(Keys.ENTER);
   WaitUtil.waitForLoaderToDisappear(driver, 50);
   Thread.sleep(5000);
   // Step 2: Wait for search results
   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Email Id:']/..")));
   // Step 3: Verify search results
   List<WebElement> emailRecords = driver.findElements(By.xpath("//b[text()='Email Id:']/.."));
   for (WebElement record : emailRecords) {
       String emailText = record.getText();
       
       Assert.assertTrue(emailText.contains(searchKeyword), "Search keyword does not match with the record: " + emailText);
   }
}

// Export partners excel report
public  void exportToExcel() throws InterruptedException {
   WaitUtil.waitAndClick(driver, actionBtn, 50);
   WaitUtil.waitAndClick(driver, downloadPartners, 50);
   WaitUtil.waitForLoaderToDisappear(driver, 30);
   ScreenshotUtil.captureScreenshot(driver, "exportToExcel");
}


//Export partner email report
public  void exportToEmail() throws InterruptedException {
Thread.sleep(3000);
   //searchAndVerifyPartner();
   HoverPartners_OnboardingPartner();
   Thread.sleep(6000);
   WaitUtil.waitAndClick(driver, exportToMail, 10);
   Thread.sleep(3000);
   ScreenshotUtil.captureScreenshot(driver, "exportToemail");
}


//Create Partner group
public void createGroup() throws InterruptedException {
WaitUtil.waitForPageToLoad(driver, 30);
WaitUtil.waitAndClick(driver, checkBox1, 10);
   WaitUtil.waitAndClick(driver, actionBtn, 10);
   WaitUtil.waitAndClick(driver, newGroup, 10);
   WaitUtil.waitAndSendKeys(driver, nameOfTheList, "NewGroup" + System.currentTimeMillis(), 10);
   WaitUtil.waitAndSendKeys(driver, legalInGroup, "Legitimate interest - prospect/lead", 10);
   driver.findElement(legalInGroup).sendKeys(Keys.ENTER);
   WaitUtil.waitAndClick(driver, saveNewGroup, 10);
   WaitUtil.waitForLoaderToDisappear(driver, 30);
   ScreenshotUtil.captureScreenshot(driver, "newgroup");
}


//Add partners to existing Group
public void addToGroup() throws InterruptedException {
WaitUtil.waitForPageToLoad(driver, 30);
searchAndVerifyPartner();
   WaitUtil.waitAndClick(driver, checkBox1, 10);
   WaitUtil.waitAndClick(driver, actionBtn, 10);
   WaitUtil.waitAndClick(driver, addToGroup, 10);
//WaitUtil.waitForPageToLoad(driver, 30);
Thread.sleep(15000);
   WaitUtil.waitAndClick(driver, groupCheckbox, 10);
   WaitUtil.waitAndClick(driver, addPartnerToGroup, 10);
WaitUtil.waitForPageToLoad(driver, 30);
   ScreenshotUtil.captureScreenshot(driver, "AddPartnerToGroup");
   WaitUtil.waitAndClick(driver, modernPopupClose, 10);
}


// Delete the partner
public void deletePartner() throws InterruptedException {
   JavascriptExecutor js = (JavascriptExecutor) driver;
   js.executeScript("window.scrollTo(0, 0);");
   searchAndVerifyPartner();
   WaitUtil.waitAndClick(driver, deletePartnerOnboardBtn, 30);
   WaitUtil.waitAndClick(driver, yesDeleteIt, 30);
   Thread.sleep(15000);
   ScreenshotUtil.captureScreenshot(driver, "deletePartner");
}


// Onboarding partner pagination
public void pagenation() throws Throwable {
WaitUtil.waitForPageToLoad(driver, 30);
   WebElement pagination2 = wait.until(ExpectedConditions.visibilityOfElementLocated(paginationPage2));
   JavascriptExecutor js = (JavascriptExecutor) driver;
   js.executeScript("arguments[0].scrollIntoView(true);", pagination2);
WaitUtil.waitForPageToLoad(driver, 30);
   wait.until(ExpectedConditions.elementToBeClickable(pagination2)).click();
   Thread.sleep(3000);
   ScreenshotUtil.captureScreenshot(driver, "pagination2");
}


//Sort And No of Records in Page
public void SortAndNoofrecord() throws InterruptedException {
   Thread.sleep(4000);
   WebElement sortDropdown = driver.findElement(sort);
   Select sortByIndex = new Select(sortDropdown);

   JavascriptExecutor js = (JavascriptExecutor) driver;
   js.executeScript("window.scrollBy(0, 200)");

   List<WebElement> sortOptions = sortByIndex.getOptions();
   for (int i = 0; i < sortOptions.size(); i++) {
       sortByIndex.selectByIndex(i);
       Thread.sleep(6000);
       ScreenshotUtil.captureScreenshot(driver, "sortPartner_" + i);
   }

   // No of records per page
   Thread.sleep(4000);
   WebElement noOfRecordsDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(noOfRecordsInPage));
   Select noOfRecords = new Select(noOfRecordsDropdown);
   js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

   noOfRecords.selectByIndex(1); // Select second option
WaitUtil.waitForPageToLoad(driver, 30);
   js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
WaitUtil.waitForLoaderToDisappear(driver, 30);
   ScreenshotUtil.captureScreenshot(driver, "recordsPerPage_updated");
WaitUtil.waitForLoaderToDisappear(driver, 30);
}


// Filter partners with partner fields
public void filterPartner(String Field, String Condition, String Value) throws InterruptedException {
Thread.sleep(3000);
WaitUtil.waitAndClick(driver, partnerFilter, 10);
applyFilter(Field, Condition, Value);
}

// Apply filter logic
public void applyFilter(String Field, String Condition, String Value) throws InterruptedException {
try {
WebElement field = driver.findElement(partnerFilterFieldName);
new Select(field).selectByVisibleText(Field);
Thread.sleep(1000);

WebElement condition = driver.findElement(partnerFilterCondition);
new Select(condition).selectByVisibleText(Condition);
Thread.sleep(1000);

WebElement value = driver.findElement(partnerFilterValue);
value.sendKeys(Value);
Thread.sleep(2000);

WaitUtil.waitAndClick(driver, filterSubmit, 10);
Thread.sleep(2000);

ScreenshotUtil.captureScreenshot(driver, "filterPartner_");

} catch (Exception e) {
throw e;
}
}


//add other filter record for multiple condition
public void addFilterRecord(String Field, String Condition, String Value) throws InterruptedException {
try {
Thread.sleep(4000);
WaitUtil.waitAndClick(driver, addFilterRecord, 10);

WebElement field = driver.findElement(partnerFilterFieldName2);
new Select(field).selectByVisibleText(Field);
Thread.sleep(1000);

WebElement condition = driver.findElement(partnerFilterCondition2);
new Select(condition).selectByVisibleText(Condition);
Thread.sleep(1000);

WebElement valueInput = driver.findElement(partnerFilterValue2);
valueInput.sendKeys(Value);
Thread.sleep(2000);

WaitUtil.waitAndClick(driver, filterSubmit, 10);
Thread.sleep(2000);

ScreenshotUtil.captureScreenshot(driver, "MultipleFilterConditionPartner_");

} catch (Exception e) {
//logger.error("Error in addFilterRecord method", e);
throw e;
}
}


// Delete the filter record
public void deleteFilterRecord() throws InterruptedException {
try {
WaitUtil.waitForPageToLoad(driver, 30);
WaitUtil.waitAndClick(driver, deleteFilterRecord, 10);
WaitUtil.waitAndClick(driver, filterSubmit, 10);
Thread.sleep(2000);
ScreenshotUtil.captureScreenshot(driver, "DeleteFilterConditionPartner_");
} catch (Exception e) {
//logger.error("Error in deleteFilterRecord method", e);
System.out.println("Error in deleteFilterRecord method" + e);
throw e;
}
}


}