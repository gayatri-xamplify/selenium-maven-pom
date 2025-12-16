package com.stratapps.xamplify.pages;

import java.time.Duration;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import com.stratapps.xamplify.utils.ActionUtil;
import com.stratapps.xamplify.utils.DropdownUtil;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class ManageEventCampaignPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private static final Logger logger = LogManager.getLogger(ManageEventCampaignPage.class);

	public ManageEventCampaignPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	// ===================== LOCATORS =====================

	// Navigation
	private By campaignHover = By.xpath("//span[@class='title'] [contains(text(),'Campaign')]");
	private By manageEventCampaigns = By
			.xpath("//span[ contains(@class,'title')] [contains(text(),'Manage Campaigns')]");
	private By eventTab = By.xpath("//li[contains(text(),'Event')]");

	// List view / grid view toggles
	private By hoverGridViewButton = By
			.xpath("//div/app-manage-publish/div[1]/div[3]/div/div/div[1]/div/div[1]/div/div/div/div[1]/div/button");
	private By listViewOption = By.xpath("//div[3]/div/div/div[1]/div/div[1]/div/div/div/div[1]/div/div/div/span[2]/i");
	private By gridViewIcon = By.xpath("//i[@class='fa fa-th-large p10']");

	// Gear menu & common row actions (row 1)
	private By gearIconRow1 = By.xpath("//*[@id=\"manage-campaign-list\"]//tr[1]/td[4]//div/span[1]");
	private By editIconRow1 = By.xpath("//*[@id=\"manage-campaign-list\"]/tbody/tr[1]/td[4]/div/div/ul/li[1]/a");
	private By copyCampaignMenu = By.xpath("//*[@id=\"manage-campaign-list\"]//tr[1]/td[4]//li[2]/a[1]");
	private By copySaveChanges = By
			.xpath("//div[@id='saveAsModal']//button[@type='button'][normalize-space()='Save changes']");

	// Launch NOW
	private By launchTab = By.xpath("//*[@id=\"event-tabs\"]/div[1]/div[4]");
	private By eventNowRadio = By.xpath("//span[contains(text(),'Now')]");
	private By launchButton = By.xpath("//button[contains(.,'Launch')]");

	// Edit folder in event
	private By editFolderDropdown = By.xpath("//*[@id=\"modal-content\"]/form/div[3]/div/select");
	private By folderOption2 = By.xpath("//*[@id='modal-content']/form/div[3]//select/option[2]");
	private By updateFolderButton = By.xpath("//span[contains(text(),'Update')]");
	private By editCloseIcon = By.xpath("//div[@id=\"edit-campaign-details-popup\"]//div[1]/a/i");

	// Send preview email
	private By sendPreviewEmailMenu = By.xpath("//tr[1]/td[4]//ul/li[2]/a[3]");
	private By sendPreviewInput = By.xpath("//div[@id=\"modal-content\"]//tag-input-form/form/input");
	private By sendPreviewButton = By
			.xpath("//div[@id='public-event-email-modal-popup']//button[contains(text(),'Send')]");
	private By sendPreviewClose = By
			.xpath("//div[@id='public-event-email-modal-popup']//button[contains(text(),'Close')]");

	// Preview & Delete partners
	private By previewDeleteMenu = By.xpath("//*[@id=\"manage-campaign-list\"]/tbody/tr[1]/td[4]/div/div/ul/li[3]/a");
	private By previewDeleteSortBy = By.xpath(
			"//div[1]/div[1]/app-preview-partners[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/select[1]");
	private By previewDeleteSingleDelete = By.xpath("//tr[1]//div[@class='actions-block']//a[@title='Delete'][1]");
	private By previewDeleteConfirm = By.xpath("//button[contains(text(),'Yes, delete it!')]");
	private By navigateBackToCampaignsBreadcrumb = By.xpath("//a[contains(text(),' Campaigns')]");

	// Grid view hover / preview / update
	private By gridHoverEventCampaign = By.xpath("(//div[@class='gridViewImgBg'])[1]");
	private By gridPreviewIcon = By.xpath("//*[@id=\"manage-campaign-list\"]/tbody/tr[1]/td[4]/div/div/ul/li[4]/a/i");
	private By gridPreviewCloseIcon = By.xpath("//*[@id=\"myModal\"]/div/div/div[1]/button");
	private By gridUpdateEventIcon = By
			.xpath("//*[@id=\"manage-campaign-list\"]/tbody/tr[1]/td[4]/div/div/ul/section[2]/li/a/i");
	private By gridUpdateMessageTextarea = By.xpath("//textarea[@placeholder='Add a comment...']");
	private By gridUpdateButton = By
			.xpath("//label[@class='btn btn-primary button-border'][contains(text(),'Update')]");
	// Cancel event in grid (commented in original but kept as locators)
	private By gridCancelEventIcon = By
			.xpath("//div[1]/div[3]/div/div/div[1]/div/div[3]/div/div/div[1]/div/div[5]/span[2]/a");
	private By cancelEventSubjectInput = By.xpath("//input[@placeholder='Cancel Event Subject Line']");
	private By cancelEventMessageTextarea = By.xpath("//textarea[@placeholder='Add a comment...']");
	private By cancelEventButton = By.xpath("//button[normalize-space()='Cancel Event']");

	// Archive-related locators
	private By gridArchiveIcon = By.xpath("//div[3]//div[1]/div/div[3]/a[8]/i");
	private By archivedCampaignsButton = By.xpath("//button[normalize-space()='Archived Campaigns']");
	private By gridDeleteArchivedIcon = By.xpath("//div[3]//div[1]/div/div[3]/span/a[2]/i");
	private By deleteArchivedYesButton = By.xpath("//button[normalize-space()='Yes, delete it!']");
	private By activeCampaignsButton = By.xpath("//button[normalize-space()='Active Campaigns']");

	// Analytics reports
	private By campaignBasedReportsIcon = By
			.xpath("//*[@id=\"manage-campaign-list\"]/tbody/tr[1]/td[4]/div/a[3]/span/i");
	private By emailInfoPreviewLink = By.xpath("//span[contains(text(),'Click for preview')]");
	private By emailInfoClose = By.xpath("//*[@id=\"email_template_preivew\"]//div/div/a");
	private By listInfoPreviewLink = By.xpath("//span[contains(text(),'Click for details')]");
	private By listInfoClose = By.xpath("//*[@id=\"show_contact-list-info\"]//div[3]/a");

	// Invites tiles & views
	private By invitesTile = By.xpath("//*[@id=\"campaignreportvendor\"]/div[1]/button/div/h1/span");
	private By invitesOpenedTile = By.xpath("//*[@id=\"timeline-view\"]//div[2]/button//h1");
	private By invitesWhoHaventOpenedTab = By.xpath("//*[@id=\"timeline-view\"]//ul/li[2]");
	private By invitesReminderIcon = By.xpath("//*[@id=\"timeline-view\"]//tr[1]//a/i");
	private By invitesReminderSubject = By.xpath("//app-event-send-reminder//section/div[2]/div/input");
	private By invitesReminderMessage = By.xpath("//*[@id=\"updateEventModal\"]//textarea");
	private By invitesReminderSend = By.xpath("//button[normalize-space()='Send Reminder']");
	private By invitesReminderClose = By.xpath("//div[@id='updateEventModal']//a[@class='close-circle']");

	private By invitesNotYetTile = By.xpath("//*[@id=\"timeline-view\"]//div[4]/button/div");
	private By invitesNotYetSearchBox = By.xpath("//*[@id=\"timeline-view\"]//div[1]/input");
	private By invitesNotYetExportIcon = By.xpath("//*[@id=\"timeline-view\"]//div[2]/div/span/i[1]");
	private By invitesNotYetExcel = By.xpath("//app-detail-view//div[3]//div[2]//ul/li/a");

	private By invitesYesTile = By.xpath("//div[3]//button[@class='portlet light color1-invert crcb']");
	private By invitesLeadsTile = By.xpath("//div[5]//button[@class='portlet light color1-invert crcb']");
	private By invitesTotalTile = By.xpath("//div[6]//button[@class='portlet light color1-invert crcb']");
	private By invitesTotalDownloadIcon = By.xpath("//*[@id=\"responsive\"]//div[2]/div/a[1]/i");
	private By invitesTotalSearchBox = By.xpath("//app-form-analytics-util//div[1]//div[2]//input");
	private By invitesTotalCloseIcon = By.xpath("//section/div/div/a");

	// Your Partner / Partner analytics
	private By yourPartnerRoweExcel = By.xpath("//*[@id=\"timeline-view\"]/div/div[3]/div[2]/div[2]/div");
	private By yourPartnerRoweExcel1 = By.xpath("(//*[@id=\"delete_button\"])[1]");
	private By yourPartnerInvitesTile = By.xpath("//*[@id=\"values\"]/div[1]/button/div");
	private By yourPartnerCloseIcon = By.xpath("//*[@id=\"timeline-view\"]/div/a/span");

	private By partnerRedisAnalyticsSearchBox = By
			.xpath("//div[1]/div[2]/div/div[2]/div/div/div/div[1]/div[2]/div/input");
	private By partnerRedisAnalyticsExcelIcon = By.xpath("//*[@id=\"delete_button\"]/i");
	private By partnerRedisAnalyticsYesTile = By.xpath("//*[@id=\"float-right\"]/div[1]/button/div/i");
	private By partnerRedisAnalyticsCloseIcon = By.xpath("//*[@id=\"timeline-view\"]/div/a/span");
	private By partnerRedisAnalyticsLeadsTile = By
			.xpath("//*[@id=\"float-right\"]/div[2]/button[@class='portlet light color1-invert crcb']");

	// Your Lead Details (section search & export)
	private By yourLeadDetailsSearchBox = By.xpath("//div[1]/div[3]//div[2]/input");
	private By yourLeadDetailsGearIcon = By.xpath("//div[3]//div[3]/span/i[1]");
	private By yourLeadDetailsExcel = By.xpath("//div[3]//div[3]/ul/li/a");
    private By backdrop = By.cssSelector("div.backdrop");

	// Home (reuse same as email)
	private By homeLink = By.xpath("//a[normalize-space()='Home']");

	// ===================== LOCAL UTILITIES =====================

	private static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	private void scrollToTop() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
	}

	private void scrollDown(int px) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, arguments[0]);", px);
	}

	private WebElement scrollIntoCenter(By locator) {
		WebElement el = WaitUtil.waitForElementVisible(driver, locator, 60);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
		sleep(300);
		return el;
	}

	private void safeClick(By locator) {
		WebElement el = WaitUtil.waitForElementVisible(driver, locator, 60);
		try {
			el.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
		}
	}

	private void staleSafeClick(By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    for (int i = 1; i <= 6; i++) {
	        try {
	            // Always fetch a NEW element (avoids stale)
	            WebElement el = wait.until(
	                    ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator))
	            );

	            // Scroll into center to avoid overlap
	            js.executeScript("arguments[0].scrollIntoView({block:'center'});", el);
	            sleep(250);

	            el.click();
	            return; // SUCCESS

	        } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
	            logger.warn("Retry " + i + " → stale/intercepted for: " + locator);
	            sleep(300);

	        } catch (Exception e) {
	            logger.warn("Normal click failed, trying JS click → retry " + i);

	            try {
	                WebElement el = driver.findElement(locator);
	                js.executeScript("arguments[0].click();", el);
	                return; // SUCCESS with JS
	            } catch (Exception ignored) {
	            }
	        }
	    }

	    throw new RuntimeException("staleSafeClick FAILED after 6 retries for: " + locator);
	}


	// ===================== SECTION 1: Navigation =====================

	public void navigateToManageEventCampaigns() {
		logger.info("Navigating to Manage Event Campaigns...");

		// Hover on Campaign menu
		WaitUtil.waitForPageToLoad(driver, 60);
		ActionUtil.hover(driver, campaignHover);

		// Click Manage Campaigns under Campaign menu
		safeClick(manageEventCampaigns);
		WaitUtil.waitForPageToLoad(driver, 60);

		logger.info("Successfully opened Manage Campaigns page.");
	}

	public void openEventTab() {
		logger.info("Opening Event tab in Manage Campaigns...");
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
		sleep(3000);
		WaitUtil.waitAndClick(driver, eventTab, 60);
		WaitUtil.waitForPageToLoad(driver, 60);
	}

	// ===================== SECTION 2: Copy & Launch Event Campaign
	// =====================

	/**
	 * Copy the first Event campaign and Launch it NOW.
	 */
	public void copyAndLaunchEventCampaign() {
		logger.info("Copying and launching Event campaign...");

		WaitUtil.waitForPageToLoad(driver, 60);
		staleSafeClick(gearIconRow1); // open gear dropdown
		sleep(1000);

		// Copy campaign
		safeClick(copyCampaignMenu);
		sleep(3000);
		safeClick(copySaveChanges);
		WaitUtil.waitForPageToLoad(driver, 60);

		logger.info("Copied Event campaign successfully.");

		// Re-open gear -> Edit -> Launch tab -> Now -> Launch
		staleSafeClick(gearIconRow1);
		sleep(1000);

		safeClick(editIconRow1);
		WaitUtil.waitForPageToLoad(driver, 60);

		// Launch tab
		safeClick(launchTab);
		WaitUtil.waitForPageToLoad(driver, 60);

		// Scroll a bit down to ensure radio buttons and Launch button visible
		scrollDown(400);
		sleep(500);

		safeClick(eventNowRadio);
		sleep(1000);
		safeClick(launchButton);

		WaitUtil.waitForPageToLoad(driver, 60);
		logger.info("Event campaign launched successfully.");
	}

	// ===================== SECTION 3: Edit Event Campaign Folder
	// =====================

	public void editEventCampaignFolder() {
		logger.info("Editing Event campaign folder...");
		sleep(2000);
		// ⭐ Scroll DOWN so the View Analytics arrow becomes fully clickable
		WebElement tabl = WaitUtil.waitForElementVisible(driver, eventTab, 60);
		ElementUtil.scrollToElement(tabl, driver);
		sleep(2000);
		WaitUtil.waitForPageToLoad(driver, 60);
//        WaitUtil.waitAndClick(driver, eventTab, 60);
//        WaitUtil.waitForPageToLoad(driver, 60);

		scrollDown(600);
		staleSafeClick(gearIconRow1);
		sleep(3000);

		safeClick(editIconRow1);
		WaitUtil.waitForPageToLoad(driver, 60);

		WebElement folder = WaitUtil.waitForElementVisible(driver, editFolderDropdown, 60);
		folder.click();
		safeClick(folderOption2);
		sleep(1000);

		safeClick(updateFolderButton);
		WaitUtil.waitForPageToLoad(driver, 60);

		logger.info("Folder updated successfully for event campaign.");

		safeClick(editCloseIcon);
		WaitUtil.waitForPageToLoad(driver, 60);
	}

	// ===================== SECTION 4: Send Preview Email & Preview/Delete
	// =====================

	public void sendPreviewEmailAndHandlePreviewDelete() {
		logger.info("Sending Event Preview email and handling Preview & Delete...");

		WaitUtil.waitForPageToLoad(driver, 60);

		// Open gear menu
		staleSafeClick(gearIconRow1);
		sleep(1000);

		// Open Send Preview Email modal
		safeClick(sendPreviewEmailMenu);
		WaitUtil.waitForPageToLoad(driver, 60);

		WebElement emailInput = WaitUtil.waitForElementVisible(driver, sendPreviewInput, 60);
		emailInput.sendKeys("mounika@xamplify.com");
		emailInput.sendKeys(Keys.ENTER);
		sleep(1000);

		// Scroll page down a bit (for safety)
		scrollDown(300);
		sleep(500);

		safeClick(sendPreviewButton);
		WaitUtil.waitForPageToLoad(driver, 60);
		logger.info("Event Preview email sent successfully.");

		safeClick(sendPreviewClose);
		WaitUtil.waitForPageToLoad(driver, 60);

		// Open Preview & Delete
		staleSafeClick(gearIconRow1);
		sleep(800);

		scrollDown(300);
		sleep(500);

		safeClick(previewDeleteMenu);
		WaitUtil.waitForPageToLoad(driver, 60);

		// Sort by various options
		WebElement sortDrop = WaitUtil.waitForElementVisible(driver, previewDeleteSortBy, 60);
		Select sort = new Select(sortDrop);

		sort.selectByVisibleText("Email ID(A-Z)");
		sleep(500);
		sort.selectByVisibleText("Email ID(Z-A)");
		sleep(500);
		sort.selectByVisibleText("First Name(ASC)");
		sleep(500);
		sort.selectByVisibleText("First Name(DESC)");
		sleep(500);
		sort.selectByVisibleText("Last Name(ASC)");
		sleep(500);
		sort.selectByVisibleText("Last Name(DESC)");
		sleep(500);
		sort.selectByVisibleText("Company Name (A-Z)");
		sleep(500);
		sort.selectByVisibleText("Company Name (Z-A)");
		sleep(500);

		logger.info("Preview & Delete sort options validated for Event campaign.");

		// (Optional) delete a partner:
		/*
		 * safeClick(previewDeleteSingleDelete); safeClick(previewDeleteConfirm);
		 */

		safeClick(navigateBackToCampaignsBreadcrumb);
		WaitUtil.waitForPageToLoad(driver, 60);
	}

	// ===================== SECTION 5: Grid View Preview & Update
	// =====================

	public void gridViewPreviewAndUpdateEvent() {
		logger.info("Handling Event campaign in Grid View (preview + update)...");

		WaitUtil.waitForPageToLoad(driver, 60);

		sleep(1000);

		// Switch to grid view via hover view button → grid icon
		// safeClick(hoverGridViewButton);
//        sleep(800);
//        safeClick(gridViewIcon);
//        WaitUtil.waitForPageToLoad(driver, 60);

		// Ensure Event tab selected
		WaitUtil.waitAndClick(driver, eventTab, 60);
		WaitUtil.waitForPageToLoad(driver, 60);

		// Hover on event card & preview
//        WebElement card = WaitUtil.waitForElementVisible(driver, gridHoverEventCampaign, 60);
//        new Actions(driver).moveToElement(card).perform();
//        sleep(800);
		// Open Preview & Delete
		staleSafeClick(gearIconRow1);
		sleep(800);
		safeClick(gridPreviewIcon);
		WaitUtil.waitForPageToLoad(driver, 60);

		logger.info("Clicked preview icon in grid view successfully.");
		safeClick(gridPreviewCloseIcon);
		WaitUtil.waitForPageToLoad(driver, 60);

//        staleSafeClick(gearIconRow1);
//        sleep(800);
//        safeClick(gridUpdateEventIcon);
//        WaitUtil.waitForPageToLoad(driver, 60);
//
//        WebElement msg = WaitUtil.waitForElementVisible(driver, gridUpdateMessageTextarea, 60);
//        msg.clear();
//        msg.sendKeys("update for the message field");
//
//        logger.info("Added message successfully via update event icon.");
//
//        scrollDown(400);
//        sleep(500);
//
//        safeClick(gridUpdateButton);
//        WaitUtil.waitForPageToLoad(driver, 60);
//
//        logger.info("Event has been updated successfully.");

		// If you want, you may toggle views back to list again using same
		// hoverGridViewButton etc.
	}

	// ===================== SECTION 6: Event Analytics & Reports
	// =====================

	public void openEventAnalyticsAndReports() {
		logger.info("Handling Event analytics & campaign-based reports...");

		WaitUtil.waitForPageToLoad(driver, 60);

		// Ensure list view + event tab
//        safeClick(hoverGridViewButton);
//        sleep(800);
//        safeClick(listViewOption);
//        WaitUtil.waitForPageToLoad(driver, 60);

		WaitUtil.waitAndClick(driver, eventTab, 60);
		WaitUtil.waitForPageToLoad(driver, 60);

		// Open campaign-based reports icon
		safeClick(campaignBasedReportsIcon);
		WaitUtil.waitForPageToLoad(driver, 60);
		sleep(1000);

		// Email info preview opens in new tab
		safeClick(emailInfoPreviewLink);
		logger.info("Clicked on Email Info preview.");

		String originalWindow = driver.getWindowHandle();
		wait.until(ExpectedConditions.numberOfWindowsToBe(1));
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		WaitUtil.waitForPageToLoad(driver, 60);

		driver.close();
		driver.switchTo().window(originalWindow);
		WaitUtil.waitForPageToLoad(driver, 60);
		logger.info("Email info preview closed successfully.");

		// List info preview (same window)
		safeClick(listInfoPreviewLink);
		WaitUtil.waitForPageToLoad(driver, 60);
		logger.info("Clicked on List Info preview.");
		safeClick(listInfoClose);
		WaitUtil.waitForPageToLoad(driver, 60);
		logger.info("List info closed successfully.");

		// Invites tile
		safeClick(invitesTile);
		WaitUtil.waitForPageToLoad(driver, 60);
		logger.info("Clicked on Invites tile successfully.");

		safeClick(invitesOpenedTile);
		WaitUtil.waitForPageToLoad(driver, 60);
		logger.info("Clicked on Invites Opened successfully.");

		safeClick(invitesWhoHaventOpenedTab);
		WaitUtil.waitForPageToLoad(driver, 60);
		logger.info("Clicked on Who Haven’t Opened tab successfully.");

		safeClick(invitesReminderIcon);
		WaitUtil.waitForPageToLoad(driver, 60);
		logger.info("Clicked on Reminder icon successfully.");

		WaitUtil.waitAndClick(driver, invitesReminderSubject, 60);
		driver.findElement(invitesReminderSubject).sendKeys("subject");
		driver.findElement(invitesReminderMessage).sendKeys("Please open the email [Reminder from vendor]");
		WaitUtil.waitForPageToLoad(driver, 60);

		// safeClick(invitesReminderSend);
		WaitUtil.waitAndClick(driver, invitesReminderClose, 60);
		WaitUtil.waitForPageToLoad(driver, 60);
		logger.info("Sent Reminder successfully.");

		// Not Yet tile
		safeClick(invitesNotYetTile);
		WaitUtil.waitForPageToLoad(driver, 60);

		WebElement notYetSearch = WaitUtil.waitForElementVisible(driver, invitesNotYetSearchBox, 60);
		notYetSearch.sendKeys("automate");
		notYetSearch.sendKeys(Keys.ENTER);
		sleep(2000);

		safeClick(invitesNotYetExportIcon);
		WaitUtil.waitForPageToLoad(driver, 60);
		safeClick(invitesNotYetExcel);
		WaitUtil.waitForPageToLoad(driver, 60);
		logger.info("Export to Excel (Not Yet tile) done successfully.");

		// Yes tile
		WebElement yesTile = WaitUtil.waitForElementVisible(driver, invitesYesTile, 60);
		if (yesTile.isEnabled()) {
			logger.info("Yes tile clicked Successfully.");
			yesTile.click();
			sleep(2000);
		} else {
			logger.info("Unable to click Yes tile due to count is '0'.");
		}

		// Leads tile
		WebElement leadsTile = WaitUtil.waitForElementVisible(driver, invitesLeadsTile, 60);
		if (leadsTile.isEnabled()) {
			logger.info("Leads tile clicked Successfully.");
			leadsTile.click();
			sleep(2000);
		} else {
			logger.info("Unable to click Leads tile due to count is '0'.");
		}

		// Total tile
		WebElement totalTile = WaitUtil.waitForElementVisible(driver, invitesTotalTile, 60);
		if (totalTile.isEnabled()) {
			logger.info("Total tile clicked Successfully.");
			totalTile.click();
			WaitUtil.waitForPageToLoad(driver, 60);

			safeClick(invitesTotalDownloadIcon);
			WaitUtil.waitForPageToLoad(driver, 60);
			logger.info("Download icon clicked successfully in Total tile.");

			WebElement totalSearch = WaitUtil.waitForElementVisible(driver, invitesTotalSearchBox, 60);
			totalSearch.sendKeys("automate");
			totalSearch.sendKeys(Keys.ENTER);
			sleep(2000);

			safeClick(invitesTotalCloseIcon);
			WaitUtil.waitForPageToLoad(driver, 60);
		} else {
			logger.info("Unable to click Total tile due to count is '0'.");
		}

		// Your Partner tile
		safeClick(yourPartnerRoweExcel);
		safeClick(yourPartnerRoweExcel1);
		WaitUtil.waitForPageToLoad(driver, 60);

		/*
		 * safeClick(yourPartnerInvitesTile); WaitUtil.waitForPageToLoad(driver, 60);
		 * logger.info("Clicked on Invites inside Your Partner tile.");
		 */
		scrollToTop();
		sleep(500);
		safeClick(yourPartnerCloseIcon);
		WaitUtil.waitForPageToLoad(driver, 60);

		// Partner Redistributed Campaign Analytics
		WebElement prSearch = WaitUtil.waitForElementVisible(driver, partnerRedisAnalyticsSearchBox, 60);
		prSearch.sendKeys("automate");
		prSearch.sendKeys(Keys.ENTER);
		sleep(2000);

		safeClick(partnerRedisAnalyticsExcelIcon);
		WaitUtil.waitForPageToLoad(driver, 60);
		logger.info("Export to Excel done successfully in 'Partner REDISTRIBUTED CAMPAIGN ANALYTICS'.");

		safeClick(partnerRedisAnalyticsYesTile);
		WaitUtil.waitForPageToLoad(driver, 60);

		new Actions(driver).sendKeys(Keys.PAGE_UP).build().perform();
		sleep(1500);

		safeClick(partnerRedisAnalyticsCloseIcon);
		WaitUtil.waitForPageToLoad(driver, 60);

		WebElement leadsRedisTile = WaitUtil.waitForElementVisible(driver, partnerRedisAnalyticsLeadsTile, 60);
		if (leadsRedisTile.isEnabled()) {
			logger.info("Total leads tile clicked Successfully in Partner Redistributed Campaign Analytics section.");
			leadsRedisTile.click();
			sleep(1500);
		} else {
			logger.info(
					"Unable to click leads tile due to count is '0' in Partner Redistributed Campaign Analytics section.");
		}

		// Your Lead Details export - optional usage of search & gear icons
		WebElement yourLeadSearch = WaitUtil.waitForElementVisible(driver, yourLeadDetailsSearchBox, 60);
		yourLeadSearch.sendKeys("automate");
		yourLeadSearch.sendKeys(Keys.ENTER);
		sleep(2000);

		safeClick(yourLeadDetailsGearIcon);
		WaitUtil.waitForPageToLoad(driver, 60);
		safeClick(yourLeadDetailsExcel);
		WaitUtil.waitForPageToLoad(driver, 60);

		logger.info("Export to Excel done successfully in 'YOUR LEAD DETAILS' section.");
	}

	// ===================== SECTION 8: Go To Home =====================

	public void goToHomeFromEventAnalytics() {
		logger.info("Navigating back to HOME from Event analytics...");
		safeClick(homeLink);
		WaitUtil.waitForPageToLoad(driver, 60);
	}
}
