package com.stratapps.xamplify.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.utils.ActionUtil;
import com.stratapps.xamplify.utils.DropdownUtil;
import com.stratapps.xamplify.utils.ScreenshotUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class OpportunitiesDealPage {

WebDriver driver;
private WebDriverWait wait;
long timestamp = System.currentTimeMillis();

public OpportunitiesDealPage(WebDriver driver) {
this.driver = driver;
this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
}

public static final By opportunities = By.xpath("//*[starts-with(text(),'Opportunities')]");
public static final By opportunitiesManageDeals = By.xpath("//*[starts-with(text(),'Manage Deals')]");
public static final By addDealButton = By
.xpath("//button[contains(@class,'button_blue bgcolor-unset p0 btn-transitions mrgt')]");
public static final By dealCompany = By.xpath("//select[@id='createdForCompanyId']");
public static final By dealPipeline = By
.xpath("//select[@id='createdForPipelineId' and @placeholder='pipelineId']");
public static final By dealPipeLineStage = By.xpath("//select[@id='createdForPipelineStageId']");
public static final By dealComment = By.xpath("//textarea[@id='dealComment']");
public static final By dealAttachdrpDwn = By.xpath("//button[@class='btn Btn-Green mb_btn']");
public static final By attachLead = By.xpath("//a[contains(text(),'Attach a Lead')]");
public static final By attachContact = By.xpath("//a[contains(text(),'Attach a Contact')]");
public static final By attachAddLeadBtn = By.xpath("//i[@class='fa fa-plus  mb-btns']");
public static final By addLeadPipeline = By.xpath("//select[@id='pipelineId']");
public static final By addLeadPipelineStage = By.xpath("(//select[@id='createdForPipelineStageId'])[3]");
public static final By saveLeadButton = By.xpath("(//button[@id='saveLead' and @class='button bgcolor-unset'])[2]");
public static final By dealCommentSubmit = By.xpath("//button[contains(@class,'btn btn-primary transition mb') and contains(text(),'Submit')]");
//    public static final By = By.xpath("");
// # below xpath, if we update the numeric value, corresponding record will we
// get
public static final By dealAttachaContact = By.xpath("//input[@id='contactCheckBox-0']");
public static final By dealAttachaContact2 = By.xpath("//input[@id='contactCheckBox-1']");
// By.xpath("//input[contains(@id,'leadCheckBox')]");
// # Attach Contact index+1 is more or less index value
public static final By dealContactMoreOrLess = By.xpath("(//button[@class='border-btn-small lightgray-btn'])[5]");
public static final By dealAttachSelectedButton = By
.xpath("//button[@class='button_blue button_disabled bgcolor-unset']");
public static final By closeAttachContactWindow = By.xpath("//button[@class='close-circle']");
public static final By searchContact = By
.xpath("//input[@class='form-control pr-pl ml ng-pristine ng-valid ng-touched']");
public static final By closeSearchContact = By.xpath("//button[@class='search-box-item-click top mb_v_search']");
public static final By changeContactOrLead = By.xpath("//button[@class='button_blue bgcolor-unset p0 btn-transitions']");
public static final By detachContactOrLead = By.xpath("(//button[contains(@class,'btn Btn-Gray neg_mrg_top')])[2]");
public static final By dealAttachLead = By.xpath("//input[contains(@id,'leadCheckBox')]");
public static final By viewLead = By.xpath("(//a[@id='lead'])[2]");
public static final By attachSelectedLeadButton = By.xpath("//button[@id='saveLead']");
public static final By SelectedLeadCheckbox = By.xpath("//input[@id='leadCheckBox-0']");
public static final By SelectedLeadCheckbox2 = By.xpath("//input[@id='leadCheckBox-1']");

public static final By attachSelectedContactButton = By.xpath("//button[@class='button_blue button_disabled bgcolor-unset']");
public static final By searchLead = By.xpath("//input[@class='form-control pr-pl ml ng-untouched ng-pristine ng-valid']");
public static final By searchLeadButton = By
.xpath("//button[contains(@class,'search-box-item-click top mb_v_search')]");
public static final By searchCancel = By
.xpath("//button[contains(@class,'glyphicon-remove search-box-item-clear')]");
public static final By dealType = By.xpath("//input[@id='Deal_Type']");
public static final By dealName = By.xpath("//input[@id='Deal_Name']");
public static final By dealAmount = By.xpath("//input[@id='Amount']");
public static final By saveDeal = By.xpath("//button[@id='saveDeal']");
public static final By dealCampaignView = By.xpath("//i[contains(@class,'fa fa-folder-open p')]");
public static final By dealListView = By.xpath("//i[contains(@class,'fa fa-th-list p')]");
public static final By dealsEmailReport = By.xpath("//i[contains(@class,'fas fa-file-export p')]");
public static final By wonDeals = By.xpath("//div[contains(text(),'Won Deals')]");
public static final By lostDeals = By.xpath("//div[contains(text(),'Lost Deals')]");
public static final By totalDeals = By.xpath("//div[contains(text(),'Total Deals')]");
public static final By clickHeretoEmailReport = By.xpath("//button[@class='btn btn-xs hidden-xs l-g-view']");
public static final By searchDeals = By
.xpath("// input[contains(@class,' ng-pristine ng-valid') and @placeholder='Search']");
public static final By clickSearchDealIcon = By.xpath("//button[@class='search-box-item-click']");
public static final By clickCloseSearchDealIcon = By
.xpath("//button[@class='glyphicon glyphicon-remove search-box-item-clear']");
public static final By viewDeal = By.xpath("(//a[@id='deal'])[1]");
public static final By closeViewDeal = By.xpath("//a[contains(@class,'pull-right close-circle')]");
public static final By editDeal = By.xpath("(//a[@id='deal'])[2]");
public static final By deletedeal1 = By.xpath("//tr[2]//a[@data-original-title='Delete Deal']");
public static final By deleteDeal = By.xpath("(//a[@id='deal'])[9]");
public static final By cancelDeleteDeal = By
.xpath("//button[contains(text(),'Cancel') and @class='swal2-cancel styled']");
public static final By acceptDeleteDeal = By.xpath("//button[contains(text(),'Yes, delete it!')]");
public static final By commentDeal = By.xpath("(//a[@class='custom-icon' and @data-rel='fancybox-button'])[4]");
public static final By campaignCommentDeal = By.xpath("(//a[@class='custom-icon' and @data-rel='fancybox-button'])[2]");
public static final By commentHistoryDeal = By.xpath("//textarea[@placeholder='Write your comment here' and @name='comment']");
public static final By editDealStage = By.xpath("(//a[@data-rel='fancybox-button'])[1]");
public static final By dealStageValue = By.xpath("//select[contains(@class,'form-control ng-')]");
public static final By dealStageComment = By
.xpath("//textarea[contains(@class,'form-control ng-untouched ng-pristine ng-valid')]");
public static final By dealStageUpdateBtn = By
.xpath("//span[@class='btn btn-primary transition d-inline' and contains(text(),'Update')]");
public static final By dealStageCancelBtn = By
.xpath("(//button[contains(@class,'btn Btn-Gray neg_mrg_top4') and contains(text(),'Cancel')])[2]");
public static final By totalDealRecords = By.xpath("(//span[normalize-space()='Total Records :'])[1]");
public static final By dealNextPg = By.xpath("(//i[@title='Next'])[1]");
public static final By dealLastPg = By.xpath("(//i[@class='fa fa-angle-double-right'])[1]");
public static final By dealFirstPg = By.xpath("(//i[@class='fa fa-angle-double-left'])[1]");
public static final By dealPreviousPg = By.xpath("(//i[@class='fa fa-angle-left'])[1]");
public static final By dealRecordPageCnt = By.xpath("(//span[normalize-space()='Total Records :'])[1]");
public static final By dealCloseCommentWindow = By.xpath("(//a[@class='close-circle'])[2]");
public static final By dealCloseDate = By.xpath("(//div[contains(@class,'flatpickr-calendar animate showTimeInput open arrow')]//div[@class='dayContainer']//span[@class='flatpickr-day '])[1]");
public static final By selectCloseDate = By.xpath("(//input[@id='flat-picker'])[1]");
public static final By selectDealNextMonth = By.xpath("(//span[@class='flatpickr-next-month'])[2]");
public static final By selectFromDate = By.xpath("(//input[@id='flat-picker'])[1]");
public static final By selecttoDate = By.xpath("(//input[@id='flat-picker'])[2]");
public static final By selectPreviousMonth = By.xpath("(//span[@class='flatpickr-prev-month'])[1]");
public static final By selectDealFromDate = By.xpath("//div[contains(@class,'flatpickr-calendar animate ')]//div[@class='dayContainer']//span[contains(@class,'flatpickr-day ')]");
// public static final By selectDealToDate = By.xpath("");
public static final By dealAddedby = By.xpath("(//ejs-dropdownlist[@id='ddlelement'])[1]");
public static final By dealStatusSelectfilter = By.xpath("//span[@class='e-input-group e-control-wrapper e-ddl e-lib e-keyboard e-valid-input']");
public static final By dealAddedSelect = By.xpath("");
public static final By dealAddedfor = By.xpath("(//ejs-dropdownlist[@id='ddlelement'])[3]");
public static final By dealAddedForSelect = By.xpath("(//ejs-dropdownlist[@id='ddlelement'])[3]");
public static final By dealAddedByInput = By.xpath("(//input[@class='e-input'])[1]");
public static final By dealAddedForfilter = By.xpath("(//input[@class='e-input'])[3]");
public static final By dealStatusInput = By.xpath("(//input[@class='e-input'])[2]");
public static final By dealStatus = By.xpath("(//select[@id='ddlelement_hidden'])[2]");
public static final By applyDealFilter = By
.xpath("//span[contains(@class,'btn Btn-Green transition txt_pd') and contains(text(),'Filter')]");
public static final By cancelDealFilter = By.xpath("//button[@class='close-circle']");
public static final By dealFilter = By.xpath("//i[@class='fa fa-filter p10']");

public static final By viewLeadsfortheseCamp = By
.xpath("(//i[@class='circled-number fa fa-users IconCustomization'])[1]");
public static final By viewLeadsfortheseCampSearchBox = By
.xpath("//input[contains(@class,'form-control pr-pl ml ng-')]");
public static final By viewLeadsfortheseCampIcon = By
.xpath("//button[contains(@class,'search-box-item-click top mb_v_search top')]");
public static final By viewLeadsfortheseCampClose = By
.xpath("//button[contains(@class,'glyphicon glyphicon-remove search-box-item-clear ng-tns-c')]");
public static final By campLeadNextPg = By
.xpath("(//i[@class='fa fa-angle-right' and contains(@title,'Next')])[2]");
public static final By campLeadPreviousPg = By.xpath("(//i[@class='fa fa-angle-left'])[2]");
public static final By campLeadLastPg = By.xpath("(//i[@class='fa fa-angle-double-right' and contains(@title,'Last')])[2]");
public static final By campLeadFirstPg = By.xpath("(//i[@class='fa fa-angle-double-left'])[2]");
public static final By campViewLeadEdit = By.xpath("(//i[contains(@class,'fa fa-edit mr5 IconCustomization')])[1]");
// public static final By campViewLeadEdit = By.xpath("(//a[@id='lead'])[2]");
public static final By campViewLeadPreview = By.xpath("(//i[@class='fa fa-eye mr5 IconCustomization'])[1]");
public static final By campViewLeadComment = By.xpath("(//i[@class='fa fa-comments IconCustomization'])[1]");
public static final By campViewLeadDelete = By.xpath("(//i[@class='fa fa-trash-o trashIconCustomization'])[1]");
public static final By campPageDrpDwn = By
.xpath("(//select[contains(@class,'form-control margin-top pointer mt_')])[2]");
public static final By campViewLeadUpdate = By.xpath("(//button[@id='saveLead'])[1]");
public static final By campViewDealSearchBox = By.xpath("(//input[contains(@class,'form-control ng-')])[2]");
public static final By campViewDealSearchIcon = By.xpath("// button[contains(@class,'search-box-item-click')]");
public static final By campViewDealSearchclear = By
.xpath("//button[@class='glyphicon glyphicon-remove search-box-item-clear']");
public static final By viewDealforThisCampaign = By.xpath("(//i[@class='circled-number fa fa-users IconCustomization'])[1]");
public static final By editDealStageStatus = By.xpath("(//span[@class='fa fa-edit IconCustomization'])[1]");
public static final By campViewEditDealStage = By.xpath("//select[@id='createdForPipelineStageId']");
public static final By campViewEditAddComment = By.xpath("//textarea[@id='dealComment']");
public static final By campViewUpdateDeal = By.xpath("//span[contains(text(),'Update Deal')]");
public static final By campViewEditClose = By.xpath("//a[contains(@class,'pull-right close-circle mrg')]");
public static final By campViewDealDelete = By.xpath("(//i[@class='fa fa-trash-o trashIconCustomization'])[1]");
public static final By campViewConfirmDelete = By
.xpath("//button[@class='swal2-confirm styled' and contains(text(),'Yes, delete it!')]");
public static final By campViewCancelDelete = By
.xpath("//button[@class='swal2-cancel styled' and contains(text(),'Cancel')]");
public static final By campViewDealNextPg = By.xpath("(//i[@class='fa fa-angle-right' and @title='Next'])[2]");
public static final By campViewDealPreviousPg = By.xpath("(//i[@class='fa fa-angle-left'])[2]");
public static final By campViewDealLastPg = By
.xpath("(//i[@class='fa fa-angle-double-right' and @title='Last'])[2]");
public static final By campViewDealFirstPg = By
.xpath("(//i[@class='fa fa-angle-double-left' and @title='First'])[2]");
public static final By campViewDealDrpDwn = By
.xpath("(//select[contains(@class,'form-control margin-top pointer mt')])[2]");
   public static final By leadstageinDeal = By.xpath("//select[@id='createdForPipelineStageId'][@placeholder='createdForPipelineStageId']");
   public static final By saveLeadBtn = By.xpath("(//span[text() = 'Add Lead']/..)[2]");
// ------------------------------------------------------------------------------------------------------------------

/*** @hoverOnOpportunities_ManageDeals written by Ganesh */
public void hoverOnOpportunities_ManageDeals() throws Exception {
Thread.sleep(3000);
ActionUtil.hover(driver, opportunities); // hover only
ActionUtil.hoverAndClick(driver, opportunitiesManageDeals); // click after hover
}

/*** @dealSearch written by Ganesh */
public void dealSearch() throws InterruptedException {
WaitUtil.waitAndSendKeys(driver, searchDeals, "lead", 10);
WaitUtil.waitAndClick(driver, clickSearchDealIcon, 10);
ScreenshotUtil.captureScreenshot(driver, "DealSearch");
/*
* WebElement firstResult =
* driver.findElement(By.xpath("xpath_for_first_result")).getText();
* assertTrue(resultText.contains("AutoLead_FN_175"),
* "Search result validation failed!");
*/
}

/*** removeDealSearch written by Ganesh */
public void removeDealSearch() throws InterruptedException {
WaitUtil.waitAndClick(driver, searchCancel, 10);
}

/*** dealEmailReport written by Ganesh */
public void dealEmailReport() throws InterruptedException {
WaitUtil.waitAndClick(driver, dealsEmailReport, 10);
ScreenshotUtil.captureScreenshot(driver, "dealEmailReport");
/*
* WebElement respondMessage =
* driver.findElement(By.xpath("xpath_for_first_result")).getText();
* assertTrue(resultText.contains("AutoLead_FN_175"),
* "Search result validation failed!");
*/
}

/*** @DealForm written by Ganesh */
public void DealForm() throws InterruptedException {
WaitUtil.waitAndSendKeys(driver, dealName, "Deal" + timestamp, 10);
WaitUtil.waitAndSendKeys(driver, dealAmount, "100", 10);
WaitUtil.waitAndClick(driver, selectCloseDate, 10);
WaitUtil.waitAndClick(driver, dealCloseDate, 10);
}

/*** @attachLeadInDealForm written by Ganesh */
public void attachLeadInDealForm() throws InterruptedException {
// DropdownUtil.selectByVisibleText(driver, dealCompany, "xAmplify");
	
	Thread.sleep(80000);
	
WaitUtil.waitAndClick(driver, dealAttachdrpDwn, 10);
WaitUtil.waitAndClick(driver, attachLead, 10);
Thread.sleep(2000);
WaitUtil.waitAndClick(driver, SelectedLeadCheckbox, 10);
WaitUtil.waitAndClick(driver, dealAttachSelectedButton, 10);
Thread.sleep(2000);
}

/*** @changeAttachLeadInDealForm written by Ganesh */
public void changeAttachLeadInDealForm() throws InterruptedException {
// DropdownUtil.selectByVisibleText(driver, dealCompany, "xAmplify");
WaitUtil.waitAndClick(driver, changeContactOrLead, 10);
Thread.sleep(3000);
WaitUtil.waitAndClick(driver, SelectedLeadCheckbox2, 10);
WaitUtil.waitAndClick(driver, dealAttachSelectedButton, 10);
Thread.sleep(2000);
}

/*** @attachContactInDealForm written by Ganesh */
public void attachContactInDealForm() throws InterruptedException {
// DropdownUtil.selectByVisibleText(driver, dealCompany, "xAmplify");
	Thread.sleep(80000);

WaitUtil.waitAndClick(driver, dealAttachdrpDwn, 10);
WaitUtil.waitAndClick(driver, attachContact, 10);
WaitUtil.waitAndClick(driver, dealAttachaContact, 10);
WaitUtil.waitAndClick(driver, attachSelectedContactButton, 10);
Thread.sleep(2000);
}

/*** @changeContactInDealForm written by Ganesh */
public void changeContactInDealForm() throws InterruptedException {
WaitUtil.waitAndClick(driver, changeContactOrLead, 10);
WaitUtil.waitAndClick(driver, dealAttachaContact2, 10);
WaitUtil.waitAndClick(driver, attachSelectedContactButton, 10);
Thread.sleep(2000);
}

/*** @attachLeadInDealForm written by Ganesh */
public void addLeadAndAttachLeadInDealForm() throws InterruptedException {
Thread.sleep(80000);
WaitUtil.waitAndClick(driver, dealAttachdrpDwn, 10);
WaitUtil.waitAndClick(driver, attachLead, 10);
Thread.sleep(2000);
System.out.println("pass2");
WaitUtil.waitAndClick(driver, attachAddLeadBtn, 10);
Thread.sleep(2000);
WaitUtil.waitForDropdownToBeReady(driver, OpportunitiesLeadPage.pipelineStageId, 10);
DropdownUtil.selectByVisibleText(driver, leadstageinDeal, "Opened");
WaitUtil.waitAndSendKeys(driver, OpportunitiesLeadPage.addleadCommentId, "Lead Created through automation", 5);
//Leadform
WaitUtil.waitAndSendKeys(driver, OpportunitiesLeadPage.firstNameId, "Lead", 5);
WaitUtil.waitAndSendKeys(driver, OpportunitiesLeadPage.lastNameId, ""+timestamp, 5);
WaitUtil.waitAndSendKeys(driver, OpportunitiesLeadPage.companyId, "Trend", 5);
WaitUtil.waitAndSendKeys(driver, OpportunitiesLeadPage.emailId, "test.automation@gmail.com", 5);
WaitUtil.waitAndSendKeys(driver, OpportunitiesLeadPage.phoneNumberId, "9998889990", 5);
WaitUtil.waitAndSendKeys(driver, OpportunitiesLeadPage.websiteId, "www.trend.com", 5);
//WaitUtil.waitAndSendKeys(driver, address, "", 5);
WaitUtil.waitAndSendKeys(driver, OpportunitiesLeadPage.cityId, "Hyderabad", 5);
WaitUtil.waitAndSendKeys(driver, OpportunitiesLeadPage.stateId, "Telangana", 5);
WaitUtil.waitAndSendKeys(driver, OpportunitiesLeadPage.countryId, "India", 5);
WaitUtil.waitAndSendKeys(driver, OpportunitiesLeadPage.postalCodeId, "500085", 5);
WaitUtil.waitAndSendKeys(driver, OpportunitiesLeadPage.jobTitleId, "QA", 5);
//WaitUtil.waitAndSendKeys(driver, amountId, "", 5);
WaitUtil.waitAndSendKeys(driver, OpportunitiesLeadPage.industryId, "Fasion", 5);
WaitUtil.waitAndSendKeys(driver, OpportunitiesLeadPage.regionID, "SouthIndia", 5);
Thread.sleep(2000);
WaitUtil.waitAndClick(driver, saveLeadBtn, 10);
Thread.sleep(3000);
ScreenshotUtil.captureScreenshot(driver, "NewLeadCreated");
}

/*** @addDeal written by Ganesh */
public void addDeal() throws InterruptedException {
WaitUtil.waitAndClick(driver, addDealButton, 10);
Thread.sleep(4000);
WaitUtil.waitForDropdownToBeReady(driver, dealCompany, 10);
DropdownUtil.selectByValue(driver, dealCompany, "5430");
attachLeadInDealForm();
changeAttachLeadInDealForm();
WaitUtil.waitAndClick(driver, detachContactOrLead, 10);
attachContactInDealForm();
changeContactInDealForm();
WaitUtil.waitAndClick(driver, detachContactOrLead, 10);
WaitUtil.waitForDropdownToBeReady(driver, dealPipeLineStage, 5);
DropdownUtil.selectByVisibleText(driver, dealPipeLineStage, "Opened");
WaitUtil.waitAndSendKeys(driver, dealComment, "Deal Created through automation", 5);
DealForm();
WaitUtil.waitAndClick(driver, saveDeal, 5);
Thread.sleep(3000);
ScreenshotUtil.captureScreenshot(driver, "NewDealCreated");
}

/*** @addDealWithAttachLead written by Ganesh */
public void addDealWithAttachLead() throws InterruptedException {
WaitUtil.waitAndClick(driver, addDealButton, 10);
Thread.sleep(4000);
WaitUtil.waitForDropdownToBeReady(driver, dealCompany, 10);
DropdownUtil.selectByValue(driver, dealCompany, "5430");
attachLeadInDealForm();
WaitUtil.waitForDropdownToBeReady(driver, dealPipeLineStage, 5);
DropdownUtil.selectByVisibleText(driver, dealPipeLineStage, "Opened");
WaitUtil.waitAndSendKeys(driver, dealComment, "Deal Created through automation", 5);
DealForm();
WaitUtil.waitAndClick(driver, saveDeal, 5);
Thread.sleep(3000);
ScreenshotUtil.captureScreenshot(driver, "addDealWithAttachLead");
}

/*** @addedLeadConvertToDeal written by Ganesh */
public void addedLeadConvertToDeal() throws InterruptedException {
WaitUtil.waitAndClick(driver, addDealButton, 10);
Thread.sleep(4000);
WaitUtil.waitForDropdownToBeReady(driver, dealCompany, 10);
DropdownUtil.selectByValue(driver, dealCompany, "5430");
addLeadAndAttachLeadInDealForm();
WaitUtil.waitForDropdownToBeReady(driver, dealPipeLineStage, 5);
DropdownUtil.selectByVisibleText(driver, dealPipeLineStage, "Opened");
WaitUtil.waitAndSendKeys(driver, dealComment, "Deal Created through automation", 5);
DealForm();
WaitUtil.waitAndClick(driver, saveDeal, 5);
Thread.sleep(3000);
ScreenshotUtil.captureScreenshot(driver, "addedLeadConvertToDeal");
}

/*** @addDealWithAttachContact written by Ganesh */
public void addDealWithAttachContact() throws InterruptedException {
WaitUtil.waitAndClick(driver, addDealButton, 10);
Thread.sleep(4000);
WaitUtil.waitForDropdownToBeReady(driver, dealCompany, 10);
DropdownUtil.selectByValue(driver, dealCompany, "5430");
attachContactInDealForm();
WaitUtil.waitForDropdownToBeReady(driver, dealPipeLineStage, 5);
DropdownUtil.selectByVisibleText(driver, dealPipeLineStage, "Opened");
WaitUtil.waitAndSendKeys(driver, dealComment, "Deal Created through automation", 5);
DealForm();
WaitUtil.waitAndClick(driver, saveDeal, 5);
Thread.sleep(3000);
ScreenshotUtil.captureScreenshot(driver, "addDealWithAttachContact");
}

/*** @dealView written by Ganesh */
public void dealView() throws InterruptedException {
WaitUtil.waitAndClick(driver, viewDeal, 10);
Thread.sleep(2000);
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollTo(0, 800);");
WaitUtil.waitAndSendKeys(driver, commentHistoryDeal, "comment added in preview", 10);
Thread.sleep(1000);
WaitUtil.waitAndClick(driver, dealCommentSubmit, 10);
js.executeScript("window.scrollTo(0, 0);");
WaitUtil.waitAndClick(driver, campViewEditClose, 10);
Thread.sleep(3000);
ScreenshotUtil.captureScreenshot(driver, "dealView");
}

/*** @editDeal written by Ganesh */
public void editDeal() throws InterruptedException {
WaitUtil.waitAndClick(driver, editDeal, 10);
WaitUtil.waitForDropdownToBeReady(driver, dealPipeLineStage, 10);
Thread.sleep(4000);
DropdownUtil.selectByValue(driver, dealPipeLineStage, "88671");
WaitUtil.waitAndSendKeys(driver, dealComment, "comment added in edit deal", 10);
WaitUtil.waitAndClick(driver, saveDeal, 5);
Thread.sleep(3000);
ScreenshotUtil.captureScreenshot(driver, "editDealUpdated");
}

/*** @addDealComment written by Ganesh */
public void addDealComment() throws InterruptedException {
WaitUtil.waitAndClick(driver, commentDeal, 10);
WaitUtil.waitAndSendKeys(driver, commentHistoryDeal, "comment added in edit comment", 10);
Thread.sleep(2000);
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollTo(0, 800);");
WaitUtil.waitAndClick(driver, dealCommentSubmit, 10);
WaitUtil.waitAndClick(driver, dealCloseCommentWindow, 10);
Thread.sleep(3000);
ScreenshotUtil.captureScreenshot(driver, "AddedCommentToDead");
}

/*** @addDealCommentCampaignView written by Ganesh */
public void addDealCommentCampaignView() throws InterruptedException {
WaitUtil.waitAndClick(driver, campaignCommentDeal, 10);

// JavascriptExecutor js = (JavascriptExecutor) driver;
// js.executeScript("window.scrollTo(0, 800);");
// WebElement element = driver.findElement(commentHistoryDeal);
// ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
Thread.sleep(3000);
WaitUtil.waitAndSendKeys(driver, commentHistoryDeal, "comment added in edit comment", 10);
Thread.sleep(2000);
WaitUtil.waitAndClick(driver, dealCommentSubmit, 10);
WaitUtil.waitAndClick(driver, dealCloseCommentWindow, 10);
Thread.sleep(3000);
ScreenshotUtil.captureScreenshot(driver, "AddedCommentToDead");
}

/*** @deleteDeal written by Ganesh */
public void deleteDeal() throws InterruptedException {
Thread.sleep(10000);
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollTo(0, 0);");
WaitUtil.waitAndClick(driver, deleteDeal, 20);
Thread.sleep(4000);
WaitUtil.waitAndClick(driver, acceptDeleteDeal, 10);
Thread.sleep(3000);
ScreenshotUtil.captureScreenshot(driver, "DeleteLead");
}

/*** @dealCampainView written by Ganesh */
public void dealCampainView() throws InterruptedException {
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollTo(0, 0);");
WaitUtil.waitAndClick(driver, dealCampaignView, 10);
WaitUtil.waitAndClick(driver, viewDealforThisCampaign, 200);
//ActionUtil.hover(driver, viewDealforThisCampaign);
Thread.sleep(3000);
ScreenshotUtil.captureScreenshot(driver, "campaignViewleadslist");
}

    public static final By vendorViewCampDeal = By.xpath("(//table[@aria-describedby='leadTable']//tr//td[4])[1]//a[2]");  
    public static final By vendorViewDealCount = By.xpath("(//div[@class='portlet light']//i[@class='circled-number IconCustomization fontStyleNormal'])[1]");

/*** @VendordealCampainView written by Ganesh */
public void VendordealCampainView() throws InterruptedException {
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollTo(0, 0);");
WaitUtil.waitAndClick(driver, dealCampaignView, 10);
WaitUtil.waitAndClick(driver, vendorViewCampDeal, 10);
WaitUtil.waitAndClick(driver, vendorViewDealCount, 200);
Thread.sleep(3000);
ScreenshotUtil.captureScreenshot(driver, "campaignViewleadslist");
}

/*** @filterDeals written by Ganesh */
public void filterDeals() throws InterruptedException {
WaitUtil.waitAndClick(driver, dealFilter, 10);
   Thread.sleep(1000);

   // Click to open the dropdown
   By dropdownOpener = By.xpath("(//span[contains(@class,'e-input-group') and contains(@class,'e-ddl')])[6]");
   WaitUtil.waitAndClick(driver, dropdownOpener, 10);
   Thread.sleep(1000);
   
   // Click on the item from the dropdown list with visible text "Xamplify"
   By dropdownOption = By.xpath("//li[contains(@class,'e-list-item') and text()='Xamplify']");
   WaitUtil.waitAndClick(driver, dropdownOption, 10);
Thread.sleep(3000);
ScreenshotUtil.captureScreenshot(driver, "filterDeals");
}


/*** @leadsPaginationandPageCount written by Ganesh */
public void dealsPaginationandPageCount() throws InterruptedException {
WaitUtil.waitAndClick(driver, dealNextPg, 10);
Thread.sleep(2000);
ScreenshotUtil.captureScreenshot(driver, "DealNextPage");
WaitUtil.waitAndClick(driver, dealLastPg, 10);
Thread.sleep(5000);
System.out.println("check1");
ScreenshotUtil.captureScreenshot(driver, "DealLastPage");
//WaitUtil.waitAndClick(driver, dealPreviousPg, 10);
Thread.sleep(5000);
System.out.println("check12");
ScreenshotUtil.captureScreenshot(driver, "leadPreviousPage");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(dealFirstPg));
        js.executeScript("window.scrollTo(0, 200);");
        Thread.sleep(3000);
WaitUtil.waitAndClick(driver, dealFirstPg, 10);
Thread.sleep(5000);
System.out.println("check123");
ScreenshotUtil.captureScreenshot(driver, "DealFirstPage");
/*
* try { DropdownUtil.selectByValue(driver, leadPageCntDrpDwn, "1");
* ScreenshotUtil.captureScreenshot(driver, "leadPageCnt-1");
* DropdownUtil.selectByValue(driver, leadPageCntDrpDwn, "2");
* ScreenshotUtil.captureScreenshot(driver, "leadPageCnt-2"); } catch (Exception
* e) { ScreenshotUtil.captureScreenshot(driver, "No of pages available"); }
*/
}

}
