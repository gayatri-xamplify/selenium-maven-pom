package com.stratapps.xamplify.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.utils.WaitUtil;
import com.stratapps.xamplify.utils.xamplifyUtil;
import com.stratapps.xamplify.utils.ElementUtil;

public class ManageEmailCampaignPage {

	private static WebDriver driver;
	private WebDriverWait wait;
	private static final Logger logger = LogManager.getLogger(ManageEmailCampaignPage.class);

	public ManageEmailCampaignPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	// ===================== LOCATORS =====================

	private By campaignHover = By.xpath("//span[@class='title'] [contains(text(),'Campaign')]");
	private By manageCampaigns = By.xpath("//span[ contains(@class,'title')] [contains(text(),'Manage Campaigns')]");
	private By emailTab = By.xpath("//li[contains(text(),'Email')]");

	private By gearIconRow1 = By.xpath("//tbody/tr[1]/td[4]/div[1]/div[1]/span[1]");
	private By emailEdit = By.xpath("//table[@id=\"manage-campaign-list\"]/tbody/tr[1]/td[4]/div/div/ul/li[1]/a");
	private By descriptionBox = By.xpath("//textarea[@placeholder='Description']");
	private By folderDropdown = By.xpath("//*[@id=\"modal-content\"]/form/div[3]/div/select");
	private By updateButton = By.xpath("//span[normalize-space()='Update']");
	private By updateCloseButton = By
			.xpath("//div[@class='modal-body']//button[@type='button'][normalize-space()='Close']");

	private By emailCopy = By.xpath("//*[@id=\"manage-campaign-list\"]/tbody/tr[1]/td[4]/div/div/ul/li[2]/a[1]");
	private By emailCopySaveChanges = By
			.xpath("//div[@class='modal right fade in']//button[@type='button'][normalize-space()='Save changes']");

	private By gearIconRow2 = By.xpath("(//div[contains(@class, 'btn-group pull-right')]/span[1])[2]");
	private By updateEndDateMenu = By
			.xpath("//*[@id=\"manage-campaign-list\"]/tbody/tr[2]/td[4]/div/div/ul/li[2]/a[2]");
	private By endDateInput = By.xpath("//input[@id='campaignEndDate']");
	private By endDateSelectedDate = By
			.xpath("//div[contains(@class,'open')]//span[@class='flatpickr-day today']/following-sibling::span[2]");
	private By endDateSaveChanges = By.xpath("//div[@id='endDateModal']//button[2]");

	private By gearIconRow2Again = By.xpath("//*[@id=\"manage-campaign-list\"]/tbody/tr[2]/td[4]/div/div/span");
	private By previewAndDeleteMenu = By
			.xpath("//*[@id=\"manage-campaign-list\"]/tbody/tr[2]/td[4]/div/div/ul/li[3]/a");
	private By previewDeleteSortBy = By.xpath(
			"//div[1]/div[1]/app-preview-partners[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/select[1]");
	private By previewDeleteSearchBox = By.xpath("//input[@placeholder='search...']");
	private By deletePartnerIcon = By.xpath("//tbody/tr[1]/td[2]/div[1]/a[1]/i[1]");
	private By confirmDeleteYes = By.xpath("//button[contains(text(),'Yes, delete it!')]");
	private By manageCampaignBreadcrumb = By.xpath("//a[contains(text(),' Campaigns')]");

	private By previewMenu = By.xpath("//*[@id=\"manage-campaign-list\"]/tbody/tr[2]/td[4]/div/div/ul/li[4]/a");
	private By previewCloseIcon = By.xpath("//div[@class='modal-dialog popup_width']//i[@class='fa fa-times']");

	private By archiveMenu = By.xpath("//*[@id=\"manage-campaign-list\"]/tbody/tr[2]/td[4]/div/div/ul/li[5]/a");
	private By archivedCampaignsTile = By.xpath("//app-select-manage-campaign/div/div[7]/div/div[3]");
	private By archivedSettingsDropdown = By.xpath("//*[@id=\"manage-campaign-list\"]/tbody/tr[1]/td[4]/div/div/span");
	private By unarchiveOption = By.xpath("//*[@id=\"manage-campaign-list\"]/tbody/tr[1]/td[4]/div/div/ul/li[5]/a");
	private By allCampaignsTile = By.xpath("//app-select-manage-campaign/div/div[1]/div/div[3]");

	private By deleteCampaignMenu = By
			.xpath("//*[@id=\"manage-campaign-list\"]/tbody/tr[1]/td[4]/div/div/ul/section/li/a");
	private By deleteCampaignYes = By.xpath("//button[normalize-space()='Yes, delete it!']");

	private By analyticsIcon = By.xpath("(//i[@class='fa fa-line-chart IconCustomization'])[1]");

	// Recipients tile
	private By recipientsTile = By.xpath("//div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/button[1]");
	private By recipientsSearchBox = By
			.xpath("//div[contains(@class,'modal right fade in')]//input[contains(@placeholder,'Search')]");
	private By recipientsSearchIcon = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-search')]");
	private By recipientsSearchClear = By.xpath(
			"//div[contains(@class,'modal right fade in')]//span[contains(@class,'glyphicon glyphicon-remove')]");
	private By recipientsExportDropdown = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-angle-down')]");
	private By recipientsExportExcel = By
			.xpath("//div[@class='btn-group gear-icon open']//a[contains(text(),'Export To Excel')]");
	private By recipientsCloseModal = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-times')]");

	// Total email sent tile
	private By totalEmailSentTile = By.xpath("//div[1]/div[2]/div[1]/section[1]/div[1]/div[2]/button[1]");
	private By totalEmailSentSearchBox = By
			.xpath("//div[contains(@class,'modal right fade in')]//input[contains(@placeholder,'Search')]");
	private By totalEmailSentSearchIcon = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-search')]");
	private By totalEmailSentClearSearch = By.xpath(
			"//div[contains(@class,'modal right fade in')]//span[contains(@class,'glyphicon glyphicon-remove')]");
	private By totalEmailSentExportDropdown = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-angle-down')]");
	private By totalEmailSentExportExcel = By
			.xpath("//div[@class='btn-group gear-icon open']//a[contains(text(),'Export To Excel')]");
	private By totalEmailSentCloseModal = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-times')]");

	// Deliverability tile
	private By deliverabilityTile = By.xpath("//div[1]/div[2]/div[1]/section[1]/div[1]/div[3]/button[1]");
	private By deliverabilitySearchBox = By
			.xpath("//div[contains(@class,'modal right fade in')]//input[contains(@placeholder,'Search')]");
	private By deliverabilitySearchIcon = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-search')]");
	private By deliverabilityClearSearch = By.xpath(
			"//div[contains(@class,'modal right fade in')]//span[contains(@class,'glyphicon glyphicon-remove')]");
	private By deliverabilityExportDropdown = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-angle-down')]");
	private By deliverabilityExportExcel = By
			.xpath("//div[@class='btn-group gear-icon open']//a[contains(text(),'Export To Excel')]");
	private By deliverabilityCloseModal = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-times')]");

	// Active Recipients tile
	private By activeRecipientsTile = By.xpath("//div[1]/div[2]/div[1]/section[1]/div[1]/div[4]/button[1]");
	private By activeRecipientsSearchBox = By
			.xpath("//div[contains(@class,'modal right fade in')]//input[contains(@placeholder,'Search')]");
	private By activeRecipientsSearchIcon = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-search')]");
	private By activeRecipientsSearchClear = By
			.xpath("//*[@id=\"emailActionListModal\"]/div/div/div[1]/div[2]/div[2]/button[1]/span");
	private By activeRecipientsExportDropdown = By.xpath(
			"//div[contains(@class,'modal right fade in')]//i[contains(@class,'fas fa-file-export singleIconCustomization')]");
	private By activeRecipientsExportExcel = By
			.xpath("//div[@class='btn-group gear-icon open']//a[contains(text(),'Export To Excel')]");
	private By activeRecipientsCloseModal = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-times')]");
	private By timeDropdownActive = By.xpath("//div[3]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/select[1]");

	// Open rate tile
	private By openRateTile = By.xpath("//div[1]/div[2]/div[1]/section[1]/div[1]/div[5]/button[1]");
	private By openRateSearchBox = By
			.xpath("//div[contains(@class,'modal right fade in')]//input[contains(@placeholder,'Search')]");
	private By openRateSearchIcon = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-search')]");
	private By openRateSearchClear = By
			.xpath("//*[@id=\"emailActionListModal\"]/div/div/div[1]/div[2]/div[2]/button[1]/span");
	private By openRateExportDropdown = By.xpath(
			"//div[contains(@class,'modal right fade in')]//i[contains(@class,'fas fa-file-export singleIconCustomization')]");
	private By openRateExportExcel = By
			.xpath("//div[@class='btn-group gear-icon open']//a[contains(text(),'Export To Excel')]");
	private By openRateCloseModal = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-times')]");
	private By timeDropdownOpenRate = By.xpath(
			"//div[1]/div[1]/app-analytics[1]/div[1]/app-detailed-campaign-analytics[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/select[1]");

	// Clicked URL tile
	private By clickedURLTile = By.xpath("//div[1]/div[2]/div[1]/section[1]/div[1]/div[6]/button[1]");
	private By clickedURLSearchBox = By
			.xpath("//div[contains(@class,'modal right fade in')]//input[contains(@placeholder,'Search')]");
	private By clickedURLSearchIcon = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-search')]");
	private By clickedURLSearchClear = By
			.xpath("//*[@id=\"emailActionListModal\"]/div/div/div[1]/div[2]/div[2]/button[1]/span");
	private By clickedURLExportDropdown = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-angle-down')]");
	private By clickedURLExportExcel = By
			.xpath("//div[@class='btn-group gear-icon open']//a[contains(text(),'Export To Excel')]");
	private By clickedURLCloseModal = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-times')]");
	private By timeDropdownClickedURL = By.xpath(
			"//div[1]/div[1]/app-analytics[1]/div[1]/app-detailed-campaign-analytics[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/select[1]");

	// Clicked Through Rate
	private By clickedThroughRateTile = By.xpath("//div[1]/div[2]/div[1]/section[1]/div[1]/div[7]/button[1]");
	private By clickedThroughRateSearchBox = By
			.xpath("//div[contains(@class,'modal right fade in')]//input[contains(@placeholder,'Search')]");
	private By clickedThroughRateSearchIcon = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-search')]");
	private By clickedThroughRateSearchClear = By
			.xpath("//*[@id=\"emailActionListModal\"]/div/div/div[1]/div[2]/div[2]/button[1]/span");
	private By clickedThroughRateExportDropdown = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-angle-down')]");
	private By clickedThroughRateExportExcel = By
			.xpath("//div[@class='btn-group gear-icon open']//a[contains(text(),'Export To Excel')]");
	private By clickedThroughRateCloseModal = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-times')]");
	private By timeDropdownClickedThrough = By
			.xpath("//div[3]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/select[1]");

	// Bounce tiles
	private By hardBounceTile = By.xpath("//div[1]/div[2]/div[1]/section[1]/div[1]/div[8]/button[1]");
	private By hardBounceClose = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-times')]");
	private By softBounceTile = By.xpath("//div[1]/div[2]/div[1]/section[1]/div[1]/div[9]/button[1]");
	private By softBounceClose = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-times')]");
	private By unsubscribeTile = By.xpath("//div[1]/div[2]/div[1]/section[1]/div[1]/div[10]/button[1]");
	private By unsubscribeClose = By
			.xpath("//div[contains(@class,'modal right fade in')]//i[contains(@class,'fa fa-times')]");

	// Leads
	private By leadsTile = By.xpath("//div[1]/div[2]/div[1]/section[1]/div[1]/div[11]/button[1]");
	private By leadsSearchBox = By
			.xpath("//div[contains(@class,'input-icon right')]//input[contains(@placeholder,'Search')]");
	private By leadsSearchIcon = By.xpath("//div[@class='portlet-input input-inline']//i[@class='fa fa-search']");
	private By leadsSearchClose = By.xpath("//button[@class='glyphicon glyphicon-remove search-box-item-clear']");
	private By leadsDownloadIcon = By
			.xpath("//div[1]/div[2]/div[1]/app-manage-campaign-leads[1]/div[1]/div[2]/div[1]/div[1]/span[2]/i[1]");
	private By leadsFilterIcon = By.xpath(
			"//div[1]/div[1]/app-analytics[1]/div[1]/app-detailed-campaign-analytics[1]/div[1]/div[2]/div[1]/app-manage-campaign-leads[1]/div[1]/div[2]/div[1]/div[1]/span[1]/i[1]");
	private By leadsStatusDropdown = By.xpath(
			"//app-manage-campaign-leads[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/select[1]");
	private By leadsFilterButton = By.xpath("//button[contains(text(),'Filter')]");
	private By leadsFilterClose = By
			.xpath("//button[contains(@class,'close-circle pull-right')]//i[contains(@class,'fa fa-times')]");
	private By leadsClose = By.xpath("//span[contains(@class,'glyphicon glyphicon-remove')]");

	// Deals
	private By dealsTile = By.xpath("//div[1]/div[2]/div[1]/section[1]/div[1]/div[12]/button[1]");
	private By dealsSearchBox = By
			.xpath("//div[contains(@class,'input-icon right')]//input[contains(@placeholder,'Search')]");
	private By dealsSearchIcon = By.xpath("//div[@class='portlet-input input-inline']//i[@class='fa fa-search']");
	private By dealsSearchClose = By.xpath("//button[@class='glyphicon glyphicon-remove search-box-item-clear']");
	private By dealsDownloadIcon = By
			.xpath("//div[1]/div[2]/div[1]/app-manage-campaign-deals[1]/div[1]/div[2]/div[1]/div[1]/span[2]/i[1]");
	private By dealsFilterIcon = By
			.xpath("//div[1]/div[2]/div[1]/app-manage-campaign-deals[1]/div[1]/div[2]/div[1]/div[1]/span[1]/i[1]");
	private By dealsStatusDropdown = By.xpath(
			"//div[1]/div[1]/app-analytics[1]/div[1]/app-detailed-campaign-analytics[1]/div[1]/div[2]/div[1]/app-manage-campaign-deals[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/select[1]");
	private By dealsFilterButton = By.xpath("//button[contains(text(),'Filter')]");
	private By dealsFilterClose = By
			.xpath("//button[contains(@class,'close-circle pull-right')]//i[contains(@class,'fa fa-times')]");
	private By dealsClose = By.xpath("//span[contains(@class,'glyphicon glyphiconremove')]");

	// Campaign-based analytics search & export
	private By analyticsSearchBox = By.xpath("//input[@placeholder='Search']");
	private By analyticsExportExcelIcon = By.xpath("//i[@class='fas fa-file-export']");

	// Manage campaign clicks
	private By manageCampaignsLink = By.xpath("//a[contains(text(),'Manage Campaigns')]");
	private By openHistoryByTemplateIcon = By
			.xpath("//*[@id=\"manage-campaign-list\"]/tbody/tr[1]/td[4]/div/a[2]/span/i");
	private By openHistorySortBy = By.xpath("//div/div[2]/div/div/div[1]/div[2]/div[1]/select");
	private By openHistorySearchBox = By.xpath("//input[@placeholder='search...']");
	private By openHistorySearchIcon = By.xpath("//i[@class='fa fa-search']");
	private By openHistorySearchClose = By.xpath("//button[@class='glyphicon glyphicon-remove search-box-item-clear']");

	private By showDownloadHistoryIcon = By
			.xpath("//*[@id=\"manage-campaign-list\"]/tbody/tr[1]/td[4]/div/a[1]/span/i");
	private By showDownloadHistorySortBy = By.xpath("//div/div[2]/div/div/div[1]/div[2]/div[1]/select");
	private By showDownloadHistorySearchBox = By.xpath("//input[@placeholder='search...']");
	private By showDownloadHistorySearchIcon = By.xpath("//button[@class='search-box-item-click']");
	private By showDownloadHistorySearchClose = By
			.xpath("//button[contains(@class,'glyphicon glyphicon-remove search-box-item-clear')]");

	private By viewAnalyticsToggle = By.xpath("(//span[@class='actions-block float-none'])[1]");
	private By redistributionCountIcon = By
			.xpath("(//i[@class='circled-number disabled IconCustomization fontStyleNormal'])[1]");
	private By hideAnalyticsToggle = By.xpath("//i[@class=\"down-arrow fa fa-angle-up\"]");
	private By homeLink = By.xpath("//a[normalize-space()='Home']");

	// (XamplifyUtil uses raw xpath String)
	private By View_Analytics_arrow = By.xpath("//*[@id=\"manage-campaign-list\"]/tbody/tr[1]/td[3]/div/div/div/button/span/a/i");
	private By Hide_Analytics_arrow =  By.xpath("//*[@id=\"manage-campaign-list\"]/tbody/tr[1]/td[3]/div/div[2]/div/button/span/a/i");

	// ===================== UTILITIES =====================

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

		private void scrollToBottom() {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		}

		// ✅ Common helper: scroll down by given pixels
		private void scrollDown(int px) {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, arguments[0]);", px);
		}

		// ✅ Common helper: wait+scroll element into center and return it
		private WebElement scrollIntoCenter(By locator) {
			WebElement el = WaitUtil.waitForElementVisible(driver, locator, 60);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
			sleep(300);
			return el;
		}

		// ✅ Common helper: refreshed clickable (stale-safe)
		private WebElement waitRefreshedClickable(By locator) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			return wait.until(ExpectedConditions.refreshed(
					ExpectedConditions.elementToBeClickable(locator)));
		}

		// ✅ Common helper: safe click with JS fallback
		private void safeClick(By locator) {
			WebElement el = WaitUtil.waitForElementVisible(driver, locator, 60);
			try {
				el.click();
			} catch (Exception e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
			}
		}

		// ✅ Common helper: retry click using scrollIntoCenter + JS click
		private void retryClick(By locator, int attempts) {
			for (int i = 1; i <= attempts; i++) {
				try {
					WebElement element = scrollIntoCenter(locator);
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
					logger.info("Clicked successfully on attempt " + i);
					return; // EXIT after success
				} catch (Exception e) {
					logger.warn("Attempt " + i + " failed for locator: " + locator + " | " + e.getMessage());
					sleep(500); // small wait before retry
				}
			}
			throw new RuntimeException("Failed to click element after " + attempts + " attempts: " + locator);
		}

		
		
		
		// ✅ Open a tile only if enabled; returns false if skipped
		private boolean openTileIfEnabled(By tileLocator, String tileName) {
			WebElement tile = driver.findElement(tileLocator);
			if (!tile.isEnabled()) {
				logger.info(tileName + " count is zero. Skipping tile.");
				return false;
			}
			tile.click();
			WaitUtil.waitForPageToLoad(driver, 60);
			return true;
		}

		// ✅ Common helper: select 4 time range options (1–4: Object)
		private void selectTimeRangesForFourOptions(By dropdownLocator) {
			WebElement timeDrop = WaitUtil.waitForElementVisible(driver, dropdownLocator, 60);
			Select sel = new Select(timeDrop);
			sel.selectByValue("1: Object");
			sel.selectByValue("2: Object");
			sel.selectByValue("3: Object");
			sel.selectByValue("4: Object");
		}

		// ✅ Open tile and close its modal if enabled
		private void openAndCloseIfEnabled(By tileLocator, By closeLocator, String tileName) {
			WebElement tile = driver.findElement(tileLocator);
			if (tile.isEnabled()) {
				logger.info(tileName + " tile enabled. Opening...");
				tile.click();
				WaitUtil.waitAndClick(driver, closeLocator, 60);
			} else {
				logger.info(tileName + " count is zero. Skipping tile.");
			}
		}


	
	

	// ===================== SECTION 1: Navigation =====================

	public void navigateToManageCampaigns() {
		logger.info("Navigating to Manage Campaigns...");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		// 1️⃣ Ensure the main Campaign menu is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(campaignHover));

		// 2️⃣ Move to hover menu (DOM may refresh → use locator, NOT old element)
		WebElement campaignMenu = wait
				.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(campaignHover)));
		new Actions(driver).moveToElement(campaignMenu).pause(Duration.ofMillis(600)).perform();

		// 3️⃣ Wait until Manage Campaigns becomes clickable (fresh lookup)
		waitRefreshedClickable(manageCampaigns);

		// 4️⃣ Try normal click, fallback to JS if needed (via helper)
		safeClick(manageCampaigns);

		// 5️⃣ Ensure target page loads
		WaitUtil.waitForPageToLoad(driver, 60);
		logger.info("Successfully navigated to Manage Campaigns page.");
	}

	public void openEmailTab() {
		logger.info("Opening Email tab in Manage Campaigns...");
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
		WaitUtil.waitAndClick(driver, emailTab, 60);
		WaitUtil.waitForPageToLoad(driver, 60);
	}


	// ===================== SECTION 2: Edit Campaign =====================

	public void clickGearIconRow1() throws InterruptedException {
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);

		WaitUtil.waitForPageToLoad(driver, 60);

		// 1️⃣ Wait for icon to exist & scroll to center
		scrollIntoCenter(gearIconRow1);

		// 2️⃣ Click safely (helper uses normal + JS fallback)
		safeClick(gearIconRow1);
	}

	public void editEmailCampaign() throws InterruptedException {
		logger.info("Editing first email campaign...");

		// 1️⃣ Scroll page slightly down to avoid sticky header overlap
		scrollDown(400);

		clickGearIconRow1();
		WaitUtil.waitForPageToLoad(driver, 60);

		WaitUtil.safeJsClick(driver, emailEdit);

		WaitUtil.waitForElementVisible(driver, folderDropdown, 60);

		Select folder = new Select(driver.findElement(folderDropdown));
		folder.selectByValue("2738");
		Thread.sleep(500);

		WebElement desc = WaitUtil.waitForElementVisible(driver, descriptionBox, 60);
		desc.sendKeys("Hello Email Campaign");

		WaitUtil.safeJsClick(driver, updateButton);
		WaitUtil.safeJsClick(driver, updateCloseButton);

		WaitUtil.waitForPageToLoad(driver, 60);
	}

	// ===================== SECTION 3: Copy Campaign =====================

	public void copyEmailCampaign() throws Exception {
		logger.info("Copying first email campaign...");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// 1️⃣ Ensure ACTIONS area is fully visible
		scrollDown(400);
		Thread.sleep(400);

		// 2️⃣ Scroll the row to center (avoid overlap issues)
		WebElement row = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='manage-campaign-list']/tbody/tr[1]")));
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", row);
		Thread.sleep(300);

		// 3️⃣ Open gear dropdown (your existing method)
		clickGearIconRow1();
		Thread.sleep(500);

		// 4️⃣ Click Copy using helper
		safeClick(emailCopy);
		Thread.sleep(600);

		// 5️⃣ Click Save Changes using helper
		safeClick(emailCopySaveChanges);

		// 6️⃣ Wait for reload
		WaitUtil.waitForPageToLoad(driver, 60);
		Thread.sleep(800);

		logger.info("COPY completed successfully.");
	}


	// ===================== SECTION 4: Update End Date =====================

	public void updateCampaignEndDate() {
		logger.info("Updating campaign end date...");

		// 1️⃣ Scroll page slightly down to avoid sticky header overlap
		scrollDown(400);

		retryClick(gearIconRow2, 2);
		retryClick(updateEndDateMenu, 2);

		WaitUtil.waitForElementVisible(driver, endDateInput, 60);
		WaitUtil.waitAndClick(driver, endDateInput, 60);

		retryClick(endDateSelectedDate, 2);
		retryClick(endDateSaveChanges, 2);

		WaitUtil.waitForPageToLoad(driver, 60);
	}


	// ===================== SECTION 5: Preview & Delete View =====================

	public void previewAndDeleteView() throws InterruptedException {
		logger.info("Opening Preview & Delete view (without deleting)...");

		Thread.sleep(1000);

		// 1️⃣ Scroll page slightly down to avoid sticky header overlap
		scrollDown(400);
		Thread.sleep(400);

		WaitUtil.waitAndClick(driver, gearIconRow2Again, 60);
		WaitUtil.waitAndClick(driver, previewAndDeleteMenu, 60);

		scrollToTop();
		sleep(2000);

		WebElement sort = WaitUtil.waitForElementVisible(driver, previewDeleteSortBy, 60);
		Select sortSel = new Select(sort);
		sortSel.selectByVisibleText("Email ID(A-Z)");
		sleep(1500);

		WebElement search = WaitUtil.waitForElementVisible(driver, previewDeleteSearchBox, 60);
		search.sendKeys("Automate");
		search.sendKeys(Keys.ENTER);

		sleep(3000);
		// Old code commented actual delete – keeping behaviour same.
		// If needed later, uncomment:
		// WaitUtil.waitAndClick(driver, deletePartnerIcon, 60);
		// WaitUtil.waitAndClick(driver, confirmDeleteYes, 60);

		WaitUtil.waitAndClick(driver, manageCampaignBreadcrumb, 60);
		WaitUtil.waitForPageToLoad(driver, 60);

		WaitUtil.waitAndClick(driver, emailTab, 60);
		WaitUtil.waitForPageToLoad(driver, 60);
	}


	// ===================== SECTION 6: Preview Only =====================

	public void previewOnlyView() throws Exception {
		logger.info("Previewing Email Campaign and closing preview...");
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// 1️⃣ Scroll page slightly down to avoid sticky header overlap
		scrollDown(400);
		Thread.sleep(400);

		// 2️⃣ Scroll row 2 into center view (MANDATORY)
		WebElement row2 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='manage-campaign-list']/tbody/tr[2]")));
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", row2);
		Thread.sleep(300);

		// 3️⃣ Click gear icon (refreshed, stale-safe) using helper
		waitRefreshedClickable(gearIconRow2Again);
		safeClick(gearIconRow2Again);
		Thread.sleep(400);

		// 4️⃣ Click preview option using helper
		waitRefreshedClickable(previewMenu);
		safeClick(previewMenu);

		// 5️⃣ Wait for preview modal to open
		Thread.sleep(2000);

		// 6️⃣ Close preview modal using helper
		waitRefreshedClickable(previewCloseIcon);
		safeClick(previewCloseIcon);

		WaitUtil.waitForPageToLoad(driver, 60);
	}


	// ===================== SECTION 7: Archive / Unarchive =====================

	public void archiveAndUnarchiveCampaign() throws InterruptedException {
		logger.info("Archiving and then unarchiving campaign...");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// 1️⃣ Scroll gear icon into center view to avoid top menu overlap
		WebElement gear = wait.until(ExpectedConditions.visibilityOfElementLocated(gearIconRow2Again));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", gear);
		Thread.sleep(500);

		// 2️⃣ Try normal click first, fallback to JS
		try {
			wait.until(ExpectedConditions.elementToBeClickable(gear)).click();
		} catch (Exception e) {
			logger.warn("Normal click failed, using JS click due to overlap...");
			js.executeScript("arguments[0].click();", gear);
		}

		WaitUtil.waitAndClick(driver, archiveMenu, 60);
		Thread.sleep(2000);

		// 2️⃣ Navigate to archived
		WaitUtil.waitAndClick(driver, archivedCampaignsTile, 60);
		WaitUtil.waitAndClick(driver, archivedSettingsDropdown, 60);
		WaitUtil.waitAndClick(driver, unarchiveOption, 60);

		WaitUtil.waitForPageToLoad(driver, 60);
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, allCampaignsTile, 60);

		// 4️⃣ BEFORE clicking Email tab — fix overlap issue
		scrollDown(300);
		Thread.sleep(300);

		// 5️⃣ Click Email tab using helper
		scrollIntoCenter(emailTab);
		safeClick(emailTab);

		WaitUtil.waitForPageToLoad(driver, 60);
	}


	// ===================== SECTION 8: Delete Campaign =====================

	public void deleteEmailCampaign() throws InterruptedException {
		logger.info("Deleting first email campaign...");
		Thread.sleep(1000);

		// 1️⃣ Scroll page slightly down to avoid sticky header overlap
		scrollDown(400);
		Thread.sleep(400);

		WaitUtil.waitAndClick(driver, gearIconRow1, 60);
		WaitUtil.waitAndClick(driver, deleteCampaignMenu, 60);
		WaitUtil.waitAndClick(driver, deleteCampaignYes, 60);

		WaitUtil.waitForPageToLoad(driver, 60);
	}

	// ===================== SECTION 9: Open Analytics =====================

	public void openCampaignAnalytics() throws InterruptedException {
		logger.info("Opening email campaign analytics...");

		// 1️⃣ Scroll the page to ensure icons are in view
		scrollDown(300);
		Thread.sleep(300);

		// 2️⃣ Scroll the analytics icon ROW into CENTER (MANDATORY)
		scrollIntoCenter(analyticsIcon);

		// 3️⃣ Click analytics icon with fallback to JS (via safeClick)
		safeClick(analyticsIcon);

		// 4️⃣ Wait for analytics page
		WaitUtil.waitForPageToLoad(driver, 60);
		scrollToTop();
	}

	// ---------- 9.1 Recipients ----------

	By modal = By.xpath("//div[contains(@class,'modal') and contains(@class,'right') and contains(@class,'show')]");
	private By backdrop = By.cssSelector("div.backdrop");

	public void handleRecipientsTile() {
		logger.info("Handling Recipients tile...");

		WaitUtil.waitForPageToLoad(driver, 60);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(recipientsTile));
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", el);

		js.executeScript("arguments[0].click();", el);
		WaitUtil.waitForPageToLoad(driver, 60);

		wait.until(ExpectedConditions.visibilityOfElementLocated(recipientsSearchBox));

		ElementUtil.sendText(recipientsSearchBox, "mounika", driver);
		WaitUtil.waitAndClick(driver, recipientsSearchIcon, 60);
		WaitUtil.waitAndClick(driver, recipientsSearchClear, 60);

		WaitUtil.waitAndClick(driver, recipientsExportDropdown, 60);
		WaitUtil.waitAndClick(driver, recipientsExportExcel, 60);

		WaitUtil.waitAndClick(driver, recipientsCloseModal, 60);
	}

	// ---------- 9.2 Total Email Sent ----------

	public void handleTotalEmailSentTile() {
		logger.info("Handling Total Email Sent tile...");

		WaitUtil.waitAndClick(driver, totalEmailSentTile, 60);
		WaitUtil.waitForPageToLoad(driver, 60);

		wait.until(ExpectedConditions.visibilityOfElementLocated(totalEmailSentSearchBox));

		ElementUtil.sendText(totalEmailSentSearchBox, "mounika", driver);
		WaitUtil.waitAndClick(driver, totalEmailSentSearchIcon, 60);
		WaitUtil.waitAndClick(driver, totalEmailSentClearSearch, 60);

		WaitUtil.waitAndClick(driver, totalEmailSentExportDropdown, 60);
		WaitUtil.waitAndClick(driver, totalEmailSentExportExcel, 60);

		WaitUtil.waitAndClick(driver, totalEmailSentCloseModal, 60);
	}

	// ---------- 9.3 Deliverability ----------

	public void handleDeliverabilityTile() {
		logger.info("Handling Deliverability tile...");

		// 1️⃣ Open tile
		WaitUtil.waitAndClick(driver, deliverabilityTile, 60);
		WaitUtil.waitForPageToLoad(driver, 60);

		// 3️⃣ Wait for inside elements
		wait.until(ExpectedConditions.visibilityOfElementLocated(deliverabilitySearchBox));

		// 4️⃣ Enter text
		ElementUtil.sendText(deliverabilitySearchBox, "mounika", driver);

		// 5️⃣ Actions
		WaitUtil.waitAndClick(driver, deliverabilitySearchIcon, 60);
		WaitUtil.waitAndClick(driver, deliverabilityClearSearch, 60);

		WaitUtil.waitAndClick(driver, deliverabilityExportDropdown, 60);
		WaitUtil.waitAndClick(driver, deliverabilityExportExcel, 60);

		// 6️⃣ Close modal
		WaitUtil.waitAndClick(driver, deliverabilityCloseModal, 60);
	}

	// ---------- 9.4 Active Recipients ----------

	public void handleActiveRecipientsTile() {
		logger.info("Handling Active Recipients tile...");

		if (!openTileIfEnabled(activeRecipientsTile, "Active Recipients")) {
			return;
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(activeRecipientsSearchBox));

		ElementUtil.sendText(activeRecipientsSearchBox, "automated", driver);
		WaitUtil.waitAndClick(driver, activeRecipientsSearchIcon, 60);
		WaitUtil.waitAndClick(driver, activeRecipientsSearchClear, 60);

		selectTimeRangesForFourOptions(timeDropdownActive);

		WaitUtil.safeJsClick(driver, activeRecipientsExportDropdown);
		// WaitUtil.waitAndClick(driver, activeRecipientsExportExcel, 60);
		WaitUtil.waitAndClick(driver, activeRecipientsCloseModal, 60);
	}

	// ---------- 9.5 Open Rate ----------

	public void handleOpenRateTile() {
		logger.info("Handling Open Rate tile...");

		if (!openTileIfEnabled(openRateTile, "Open Rate")) {
			return;
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(openRateSearchBox));

		ElementUtil.sendText(openRateSearchBox, "automated", driver);
		WaitUtil.waitAndClick(driver, openRateSearchIcon, 60);
		WaitUtil.waitAndClick(driver, openRateSearchClear, 60);

		selectTimeRangesForFourOptions(timeDropdownOpenRate);

		WaitUtil.safeJsClick(driver, openRateExportDropdown);
		// WaitUtil.waitAndClick(driver, openRateExportExcel, 60);
		WaitUtil.waitAndClick(driver, openRateCloseModal, 60);
	}

	// ---------- 9.6 Clicked URL ----------

	public void handleClickedURLTile() {
		logger.info("Handling Clicked URL tile...");

		if (!openTileIfEnabled(clickedURLTile, "Clicked URL")) {
			return;
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(clickedURLSearchBox));

		ElementUtil.sendText(clickedURLSearchBox, "automated", driver);
		WaitUtil.waitAndClick(driver, clickedURLSearchIcon, 60);
		WaitUtil.waitAndClick(driver, clickedURLSearchClear, 60);

		selectTimeRangesForFourOptions(timeDropdownClickedURL);

		WaitUtil.waitAndClick(driver, clickedURLExportDropdown, 60);
		// WaitUtil.waitAndClick(driver, clickedURLExportExcel, 60);
		WaitUtil.waitAndClick(driver, clickedURLCloseModal, 60);
	}

	// ---------- 9.7 Clicked Through Rate ----------

	public void handleClickedThroughRateTile() {
		logger.info("Handling Clicked Through Rate tile...");

		if (!openTileIfEnabled(clickedThroughRateTile, "Clicked Through Rate")) {
			return;
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(clickedThroughRateSearchBox));

		ElementUtil.sendText(clickedThroughRateSearchBox, "automated", driver);
		WaitUtil.waitAndClick(driver, clickedThroughRateSearchIcon, 60);
		WaitUtil.waitAndClick(driver, clickedThroughRateSearchClear, 60);

		selectTimeRangesForFourOptions(timeDropdownClickedThrough);

		WaitUtil.waitAndClick(driver, clickedThroughRateExportDropdown, 60);
		WaitUtil.waitAndClick(driver, clickedThroughRateExportExcel, 60);
		WaitUtil.waitAndClick(driver, clickedThroughRateCloseModal, 60);
	}

	// ---------- 9.8 Hard & Soft Bounce + Unsubscribe ----------

	public void handleBounceTiles() {
		logger.info("Handling Hard Bounce / Soft Bounce / Unsubscribe tiles...");

		openAndCloseIfEnabled(hardBounceTile, hardBounceClose, "Hard Bounce");
		openAndCloseIfEnabled(softBounceTile, softBounceClose, "Soft Bounce");
		openAndCloseIfEnabled(unsubscribeTile, unsubscribeClose, "Unsubscribe");
	}

	// ---------- 9.9 Leads ----------

	public void handleLeadsTile() {
		logger.info("Handling Leads tile...");

		if (!openTileIfEnabled(leadsTile, "Leads")) {
			return;
		}

		ElementUtil.sendText(leadsSearchBox, "auto_lead", driver);
		WaitUtil.waitAndClick(driver, leadsSearchIcon, 60);
		WaitUtil.waitAndClick(driver, leadsSearchClose, 60);

		WaitUtil.waitAndClick(driver, leadsFilterIcon, 60);

		WebElement status = WaitUtil.waitForElementVisible(driver, leadsStatusDropdown, 60);
		Select sel = new Select(status);
		sel.selectByValue("Opened");
		sel.selectByValue("Closed - Lost");
		sel.selectByValue("Converted");
		sel.selectByValue("Contacted");

		WaitUtil.waitAndClick(driver, leadsFilterButton, 60);
		WaitUtil.waitAndClick(driver, leadsFilterClose, 60);
		WaitUtil.waitAndClick(driver, leadsDownloadIcon, 60);
		WaitUtil.waitAndClick(driver, leadsClose, 60);
	}

	// ---------- 9.10 Deals ----------

	public void handleDealsTile() {
		logger.info("Handling Deals tile...");

		if (!openTileIfEnabled(dealsTile, "Deals")) {
			return;
		}

		ElementUtil.sendText(dealsSearchBox, "auto_deal", driver);
		WaitUtil.waitAndClick(driver, dealsSearchIcon, 60);
		WaitUtil.waitAndClick(driver, dealsSearchClose, 60);

		WaitUtil.waitAndClick(driver, dealsFilterIcon, 60);

		WebElement status = WaitUtil.waitForElementVisible(driver, dealsStatusDropdown, 60);
		Select sel = new Select(status);
		sel.selectByValue("Opened");
		sel.selectByValue("Approved");
		sel.selectByValue("Rejected");
		sel.selectByValue("Hold");

		WaitUtil.waitAndClick(driver, dealsFilterButton, 60);
		WaitUtil.waitAndClick(driver, dealsFilterClose, 60);
		WaitUtil.waitAndClick(driver, dealsDownloadIcon, 60);
		WaitUtil.waitAndClick(driver, dealsClose, 60);
	}

	// ---------- 9.11 Campaign Analytics Search & Export ----------

	public void handleCampaignAnalyticsSearchAndExport() {
		logger.info("Handling Campaign-based analytics search and export...");

		scrollToBottom();
		sleep(2000);

		WebElement search = driver.findElement(analyticsSearchBox);
		search.sendKeys("mounika");
		search.sendKeys(Keys.ENTER);
		sleep(2000);
		search.clear();

		WaitUtil.waitAndClick(driver, analyticsExportExcelIcon, 60);
		sleep(2000);
	}


	// ===================== SECTION 10: Open History By Template =====================

	public void handleOpenHistoryByTemplate() throws InterruptedException {
		logger.info("Handling Open History By Template...");

		WaitUtil.waitForPageToLoad(driver, 60);

		scrollToTop();
		Thread.sleep(300);

		WaitUtil.waitAndClick(driver, manageCampaignsLink, 60);
		WaitUtil.waitAndClick(driver, emailTab, 60);

		WaitUtil.waitAndClick(driver, openHistoryByTemplateIcon, 60);

		WebElement sort = WaitUtil.waitForElementVisible(driver, openHistorySortBy, 60);
		Select sel = new Select(sort);
		sel.selectByValue("3: Object");

		ElementUtil.sendText(openHistorySearchBox, "Automated", driver);
		WaitUtil.waitAndClick(driver, openHistorySearchIcon, 60);
		WaitUtil.waitAndClick(driver, openHistorySearchClose, 60);

		// Back from open history
		WaitUtil.waitAndClick(driver,
				By.xpath("/html/body/app-root/app-home/div/div/app-preview-partners/div/div[1]/ul/li[2]/a"), 60);
		WaitUtil.waitAndClick(driver, emailTab, 60);
	}


	// ===================== SECTION 11: Show Download History =====================

	public void handleShowDownloadHistory() {
		logger.info("Handling Show Download History...");

		WaitUtil.waitAndClick(driver, showDownloadHistoryIcon, 60);

		WebElement sort = WaitUtil.waitForElementVisible(driver, showDownloadHistorySortBy, 60);
		Select sel = new Select(sort);
		sel.selectByValue("3: Object");
		sel.selectByValue("5: Object");

		ElementUtil.sendText(showDownloadHistorySearchBox, "Automated", driver);
		WaitUtil.waitAndClick(driver, showDownloadHistorySearchIcon, 60);
		WaitUtil.waitAndClick(driver, showDownloadHistorySearchClose, 60);

		WaitUtil.waitAndClick(driver,
				By.xpath("/html/body/app-root/app-home/div/div/app-preview-partners/div/div[1]/ul/li[2]/a"), 60);
		WaitUtil.waitAndClick(driver, emailTab, 60);
		WaitUtil.waitForPageToLoad(driver, 60);
	}


	// ===================== SECTION 13: Go To Home =====================

	public void goToHome() {
		logger.info("Navigating back to HOME...");
		scrollToTop();
		WaitUtil.waitAndClick(driver, homeLink, 60);
		WaitUtil.waitForPageToLoad(driver, 60);
	}
	 //===================== SECTION 12: Redistribution Analytics  =====================
	 //=====================										=====================

	public void handleRedistributionAnalytics() {
	    logger.info("Handling redistribution analytics and view/hide analytics toggles...");

	    sleep(1000);
	    // ⭐ Scroll DOWN so the View Analytics arrow becomes fully clickable
	    WebElement arrowl = WaitUtil.waitForElementVisible(driver, View_Analytics_arrow, 60);
        ElementUtil.scrollToElement(arrowl, driver);
        sleep(400);
	   

	    // 1️⃣ Expand analytics section
	    WaitUtil.safeJsClick(driver, View_Analytics_arrow);
	    sleep(1500);

	    // 2️⃣ Read count
	    String countText = ElementUtil.getText(redistributionCountIcon, driver).trim();
	    int count = 0;

	    try {
	        count = Integer.parseInt(countText);
	    } catch (Exception e) {
	        logger.warn("Cannot parse redistribution count. Treating as 0.");
	    }

	    logger.info("Redistribution Count: " + count);

	    if (count > 0) {

	        logger.info("Count > 0. Clicking redistribution icon...");

	        WebElement iconEl = WaitUtil.waitForElementVisible(driver, redistributionCountIcon, 60);
	        ElementUtil.scrollToElement(iconEl, driver);
	        sleep(400);

	        WaitUtil.safeJsClick(driver, redistributionCountIcon);
	        sleep(2000);

	        // ⭐ Hide analytics
	        WaitUtil.safeJsClick(driver, Hide_Analytics_arrow);

	    } else {

	        logger.info("Count is 0 → No redistributed campaigns. Hiding analytics only.");

	        // ⭐ Scroll UP before clicking hide arrow (avoids overlap)
	        scrollToTop();
	        sleep(500);

	        WaitUtil.safeJsClick(driver, Hide_Analytics_arrow);
	    }
	}


	// ===================== MAIN PUBLIC FLOW =====================

		public void manageEmailCampaignFullFlow() throws Exception {

			navigateToManageCampaigns();
			openEmailTab();

			editEmailCampaign();
			copyEmailCampaign();
			updateCampaignEndDate();

			previewAndDeleteView();
			previewOnlyView();
			archiveAndUnarchiveCampaign();
			deleteEmailCampaign();

			openCampaignAnalytics();
			handleRecipientsTile();
			handleTotalEmailSentTile();
			handleDeliverabilityTile();
			handleActiveRecipientsTile();
			handleOpenRateTile();
			handleClickedURLTile();
			handleClickedThroughRateTile();
			handleBounceTiles();
			handleLeadsTile();
			handleDealsTile();
			handleCampaignAnalyticsSearchAndExport();

			handleOpenHistoryByTemplate();
			handleShowDownloadHistory();
			handleRedistributionAnalytics();

			goToHome();
			logger.info("Manage Email Campaign full flow completed successfully.");
		}

}
