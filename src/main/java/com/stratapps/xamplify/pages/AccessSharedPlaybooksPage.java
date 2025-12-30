
package com.stratapps.xamplify.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class AccessSharedPlaybooksPage {
	private WebDriver driver;
	private WebDriverWait wait;
	public AccessSharedPlaybooksPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	private By contentMenu = By.xpath("//span[normalize-space()='Content']");
	private By sharedPlaybooksOption = By.xpath("//span[normalize-space()='Access Shared Playbooks']");
	private By refreshIcon = By.xpath("//i[@class='fa fa-refresh']");
	private By sortDropdown = By.xpath("//div/div[2]/div[1]/select");
	private By PlaybookSearchInput = By.xpath("//input[@placeholder='search...']");
	private By searchIcon = By.xpath("//i[@class='fa fa-search']");

	// View locators
	private final By hoverOnListView = By.xpath("//button[contains(@class,'fa fa-th-list btn btn-xs l-g-view mr')]");
	private final By hoverOnGridView = By.xpath("//button[contains(@class,'fa fa-th-large btn btn-xs l-g-view mr')]");
	private final By hoverOnFGV = By.xpath("(//button[contains(@class,'fa fa-folder btn-xs l-g-view')])");
	private final By hoverOnFLV = By.xpath("(//button[contains(@class,'fa fa-th btn-xs l-g-view')])");
	private final By hoverOnPlaybookGV = By.xpath("(//div[@class='aligntowbtns'])[1]");
	private final By clickOnPlaybookPreview = By.xpath("(//a[contains(@class,'custom-icon')])[1]");
	private final By clickOnPlaybookPreview1 = By.xpath("(//a[contains(@class,'custom-icon')])[2]");
	private final By clickOnGridView = By.xpath("//i[contains(@class,'fa fa-th-large p')]");
	private final By clickOnListView = By.xpath("//i[contains(@class,'fa fa-th-list p')]");
	private final By clickOnFolderGridView = By.xpath("//i[contains(@class,'fa fa-folder p')]");
	private final By hoverOnPlaybookFGV = By.xpath("(//div[contains(@class,'bg-folder')])[1]");
	private final By clickOnFolderPlaybookPreviewFGV = By.xpath("(//i[contains(@class,'fa fa-eye')])[1]");
	private final By clickOnFVUpArrow = By.xpath("(//i[contains(@class,'fa fa-arrow-up p')])");
	private final By clickOnFolderListView = By.xpath("(//i[contains(@class,'fa fa-th p')])");
	private final By clickOnSearchDropdownFLV = By
			.xpath("(//div[@class='inputs float-right custom-flex']//div[2]//select[1])");
	private final By clickOnSearchPlaybookFLV = By.xpath("(//input[@id='sort-text'])");
	private final By clickOnSearchIconPlaybookFLV = By.xpath("((//i[contains(@class,'fa fa-search')])[2])");
	private final By clickOnPlaybookDelete = By.xpath("(//i[contains(@class,'fa fa-trash')])[1]");
	private final By clickOnYesDelete = By.xpath("(//button[contains(text(),'Yes, Delete')])");
	private final By backdrop = By.id("backdrop");
	private By previewclose = By.xpath("//span[@class='glyphicon glyphicon-remove asset_cross_align']");
	private By folderUpArrow = By.xpath("//button[@title='Up']");
	private By analyticsButton = By.xpath("//*[@id=\"manage-Playbooks-table\"]/tbody/tr[1]/td[5]/div/div/a[1]/i");
	private By analyticsclose = By.xpath("//a[@class='close-circle ml5']//i[@class='fa fa-times']");
	private By previewPlaybook = By.xpath("//*[@id=\"actions-row\"]/div/a/i[1]");
	private By viewPlaybook = By.xpath("//span[normalize-space()='View']");
	private By downloadPlaybook = By.xpath("//span[normalize-space()='Download']");
	private By ViewPlaybookclose = By.xpath("//span[@class='glyphicon glyphicon-remove']");
	private By viewVideoclose = By.xpath("//span[@class='glyphicon glyphicon-remove asset_cross_align']");
	private By interactedTile = By.xpath("//i[contains(@title,'Total interacted Playbooks')]");
	private By nonInteractedTile = By.xpath("//i[@title='Total non interacted Playbooks ']");
	private By Gotohome = By.xpath("//img[@class='cls-pointer']");
	private By disabledText = By.xpath("//div[contains(text(),'The Playbook expired')]");
	private By breadcrumbSharedPlaybooks = By.xpath("//a[contains(text(),'Shared Playbooks')]");
	private By firstAssetRow = By.xpath("(//table[@id='manage-assets-table']//tr[1])[2]");
	private By submitform = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By mandatoryQuestions = By
			.xpath("//div[contains(@class,'form-group')][.//span[contains(@class,'required')]]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By emailField = By.xpath("//div[@class='panel-body border-fivepx padding-20px']//div[2]//div[1]//div[1]");
	private By formclose = By.xpath("//span[@class='glyphicon glyphicon-remove']");
	private By viewAssetPlaybook = By.xpath("//button[normalize-space()='View']");
	private By downloadAssetPlaybook = By.xpath("//button[normalize-space()='Download']");
	private By goToHome = By.xpath("//img[@class='cls-pointer']");
	private By inProgressTile = By.xpath("//i[@title='Total in progress playbooks']");
	private By completedTile = By.xpath("//i[@title='Total completed playbooks']");
	private By notViewedTile = By.xpath("//i[@title='Total not viewed playbooks']");
	private By allTile = By.xpath("//i[@title='Total records of playbooks']");

	/** Navigate to Upload Playbook Page */
	public void accesssharedPlaybookSection() {

		WaitUtil.waitForElementVisible(driver, contentMenu, 90);
		ElementUtil.hoverAndClick(driver.findElement(contentMenu), driver);
		WaitUtil.waitAndClick(driver, sharedPlaybooksOption, 90);
		WaitUtil.waitForPageToLoad(driver, 30);
	}

	public void refreshPlaybooksPage() {
		try {
			WebElement refresh = WaitUtil.waitForElementPresent(driver, refreshIcon, 5);
			if (refresh != null) {
				ElementUtil.click(refreshIcon, driver);
				System.out.println("🔄 Refresh icon found and clicked successfully.");
			} else {
				System.out.println("⏭️ Refresh icon not present. Skipping refresh step.");
			}
		} catch (Exception e) {
			System.out.println("⚠️ Could not click Refresh icon (safe skip). Cause: " + e.getMessage());
		}
		WaitUtil.waitForPageToLoad(driver, 60);
	}

	public void sortPlaybooks(String sortOption) {
		WaitUtil.waitForElementVisible(driver, sortDropdown, 30);
		ElementUtil.selectDropdownByVisibleText(sortDropdown, sortOption, driver);
	}

	public void searchPlaybook(String keyword) {
		WaitUtil.waitForElementVisible(driver, PlaybookSearchInput, 30);
		ElementUtil.sendText(PlaybookSearchInput, keyword, driver);
		ElementUtil.click(searchIcon, driver);
	}

	public void viewPlaybookDetails() {
		try {
			WaitUtil.waitForPageToLoad(driver, 30);
			WaitUtil.waitAndClick(driver, clickOnPlaybookPreview, backdrop, 30);
			WaitUtil.waitAndClick(driver, previewclose, backdrop, 30);
		} catch (Exception e) {
			throw new RuntimeException("View Playbook Details flow failed", e);
		}
	}

	public void viewActions() {
		try {
			WaitUtil.waitForPageToLoad(driver, 30);

			// ---- Step 1: Switch to Grid View ----
			WaitUtil.waitAndClick(driver, hoverOnListView, backdrop, 30);
			WaitUtil.waitAndClick(driver, clickOnGridView, backdrop, 30);

			// ---- Step 2: Folder Grid View ----
			WaitUtil.waitAndClick(driver, hoverOnGridView, backdrop, 30);
			WaitUtil.waitAndClick(driver, clickOnFolderGridView, backdrop, 30);
			WaitUtil.waitAndClick(driver, hoverOnPlaybookFGV, backdrop, 30);
			WaitUtil.waitAndClick(driver, clickOnFolderPlaybookPreviewFGV, backdrop, 30);

			// ---- Step 3: Navigate Up ----
			WaitUtil.waitAndClick(driver, clickOnFVUpArrow, backdrop, 30);
			WaitUtil.waitAndClick(driver, hoverOnFGV, backdrop, 30);

			// ---- Step 4: Folder List View ----
			WaitUtil.waitAndClick(driver, clickOnFolderListView, backdrop, 30);
			WaitUtil.waitAndClick(driver, clickOnSearchDropdownFLV, backdrop, 30);
			ElementUtil.selectDropdownByVisibleText(clickOnSearchDropdownFLV, "Search In Folder", driver);

			WaitUtil.waitAndSendKeys(driver, clickOnSearchPlaybookFLV, "jpg", 20);
			WaitUtil.waitAndClick(driver, clickOnSearchIconPlaybookFLV, backdrop, 30);

			// ---- Step 5: Back to List View ----
			WaitUtil.waitAndClick(driver, clickOnFVUpArrow, backdrop, 30);
			WaitUtil.waitAndClick(driver, hoverOnFLV, backdrop, 30);
			WaitUtil.waitAndClick(driver, clickOnListView, backdrop, 30);

		} catch (Exception e) {
			throw new RuntimeException("View Actions flow failed", e);
		}
	}

	public void viewPlaybookAndClickAssets() throws InterruptedException {

		try {
			// 1️⃣ Click the View Playbook button
			WaitUtil.waitAndClick(driver, clickOnPlaybookPreview, backdrop, 30);
			WaitUtil.waitForPageToLoad(driver, 90);

		} catch (Exception e) {
			throw new RuntimeException("View Playbook flow failed", e);
		}
		By clickOnPlaybookPreviewViewAsset = By.xpath("//*[@id=\"manage-assets-table\"]/tbody/tr[1]/td[2]/div");
		// Retry open Playbook Preview (2nd icon)
		WaitUtil.waitForPageToLoad(driver, 90);
		WaitUtil.waitForElementClickable(driver, clickOnPlaybookPreviewViewAsset, 30);
		ElementUtil.clickWithRetry(clickOnPlaybookPreviewViewAsset, driver, 3);
		WaitUtil.waitAndClick(driver, viewAssetPlaybook, 30);
		WaitUtil.waitForPageToLoad(driver, 30);
		WaitUtil.waitAndClick(driver, ViewPlaybookclose, 60);
		ElementUtil.click(downloadAssetPlaybook, driver);
		WaitUtil.waitForPageToLoad(driver, 90);
		Thread.sleep(2000);
		ElementUtil.click(previewclose, driver);
		WaitUtil.waitForPageToLoad(driver, 30);

		// Video Asset view
		By clickOnPlaybookPreviewViewAsset2 = By.xpath("//*[@id=\"manage-assets-table\"]/tbody/tr[2]/td[2]/div");
		// Retry open Playbook Preview (2nd icon)
		WaitUtil.waitForPageToLoad(driver, 90);
		WaitUtil.waitForElementClickable(driver, clickOnPlaybookPreviewViewAsset2, 30);
		ElementUtil.clickWithRetry(clickOnPlaybookPreviewViewAsset2, driver, 3);
		WaitUtil.waitForPageToLoad(driver, 50);
//		WaitUtil.waitForVisibility(driver, viewVideoclose, 50);
//		WaitUtil.waitAndClick(driver, viewVideoclose, 60);
		WaitUtil.waitAndClick(driver, viewAssetPlaybook, 30);
		WaitUtil.waitForPageToLoad(driver, 30);
		WaitUtil.waitAndClick(driver, ViewPlaybookclose, 60);
		ElementUtil.click(downloadAssetPlaybook, driver);
		WaitUtil.waitForPageToLoad(driver, 90);
		ElementUtil.click(previewclose, driver);
		WaitUtil.waitForPageToLoad(driver, 30);

		// Asset # Viewed
		By clickOnPlaybookPreviewViewAsset3 = By.xpath("//*[@id=\"manage-assets-table\"]/tbody/tr[3]/td[2]/div");
		// Retry open Playbook Preview (2nd icon)
		WaitUtil.waitForPageToLoad(driver, 90);
		WaitUtil.waitForElementClickable(driver, clickOnPlaybookPreviewViewAsset3, 30);
		ElementUtil.clickWithRetry(clickOnPlaybookPreviewViewAsset3, driver, 3);
		WaitUtil.waitAndClick(driver, viewAssetPlaybook, 30);
		WaitUtil.waitForPageToLoad(driver, 30);
		WaitUtil.waitAndClick(driver, ViewPlaybookclose, 60);
		ElementUtil.click(downloadAssetPlaybook, driver);
		WaitUtil.waitForPageToLoad(driver, 90);
		ElementUtil.click(previewclose, driver);
		WaitUtil.waitForPageToLoad(driver, 20);
//		// Asset # Viewed
//		By clickOnPlaybookPreviewViewAsset4 = By.xpath("//*[@id=\"manage-assets-table\"]/tbody/tr[4]/td[2]/div");
//		// Retry open Playbook Preview (2nd icon)
//		WaitUtil.waitForPageToLoad(driver, 90);
//		WaitUtil.waitForElementClickable(driver, clickOnPlaybookPreviewViewAsset4, 30);
//		ElementUtil.clickWithRetry(clickOnPlaybookPreviewViewAsset4, driver, 3);
//		WaitUtil.waitAndClick(driver, viewAssetPlaybook, 30);
//		WaitUtil.waitForPageToLoad(driver, 30);
//		WaitUtil.waitAndClick(driver, ViewPlaybookclose, 60);
//		ElementUtil.click(downloadAssetPlaybook, driver);
//		WaitUtil.waitForPageToLoad(driver, 90);
//		ElementUtil.click(previewclose, driver);
//		WaitUtil.waitForPageToLoad(driver, 20);

		WaitUtil.waitAndClick(driver, breadcrumbSharedPlaybooks, 50);

	}

	public void tilesActions(String fileName) {

		WaitUtil.waitForPageToLoad(driver, 30);
		WaitUtil.waitAndClick(driver, inProgressTile, backdrop, 30);
		WaitUtil.waitAndClick(driver, completedTile, backdrop, 30);
		searchPlaybook(fileName);
		WaitUtil.waitAndClick(driver, notViewedTile, backdrop, 30);
		WaitUtil.waitAndClick(driver, allTile, backdrop, 30);

	}

	public void backtohome() {
		WaitUtil.waitAndClick(driver, goToHome, 30);

	}

}
