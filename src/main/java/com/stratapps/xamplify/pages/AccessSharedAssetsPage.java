package com.stratapps.xamplify.pages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.utils.ActionUtil;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.ScreenshotUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class AccessSharedAssetsPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public AccessSharedAssetsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	private By contentMenu = By.xpath("//span[normalize-space()='Content']");
	private By sharedAssetsOption = By.xpath("//span[normalize-space()='Access Shared Assets']");
	private By refreshIcon = By.xpath("//i[@class='fa fa-refresh']");
	private By sortDropdown = By.xpath("//select[@id='alignline-m-width']");
	private By assetSearchInput = By.xpath("//input[@placeholder='search...']");
	private By searchIcon = By.xpath("//i[@class='fa fa-search']");

	// Filter locators
	private By filterIcon = By.xpath("//i[@class='fa fa-filter p10']");
	private By fieldNameDropdown = By.xpath("(//div/div[1]/select)[2]");
	private By conditionDropdown = By.xpath("(//div/div[2]/select)[1]");
	private By TypeDropdown = By.xpath("(//div/div[2]/select)[1]");
	private By valueField = By.xpath("//input[@placeholder='value*']");
	private By submitFilter = By.xpath("//button[normalize-space()='Submit']");
	private By removeFilter = By.xpath("//i[@class='fa fa-filter']");
	private By applyFilterClose = By.xpath("(//button[normalize-space()='Cancel'])[2]");

	// View locators
	private final By hoverOnListView = By.xpath("//button[contains(@class,'fa fa-th-list btn btn-xs l-g-view mr')]");
	private final By hoverOnGridView = By.xpath("//button[contains(@class,'fa fa-th-large btn btn-xs l-g-view mr')]");
	private final By hoverOnFGV = By.xpath("(//button[contains(@class,'fa fa-folder btn-xs l-g-view')])");
	private final By hoverOnFLV = By.xpath("(//button[contains(@class,'fa fa-th btn-xs l-g-view')])");
	private final By hoverOnAssetGV = By.xpath("(//div[@class='aligntowbtns'])[1]");
	private final By clickOnAssetPreview = By.xpath("(//a[contains(@class,'Iconhover custom-grid-icon')])[2]");
	private final By clickOnGridView = By.xpath("//i[contains(@class,'fa fa-th-large p')]");
	private final By clickOnListView = By.xpath("//i[contains(@class,'fa fa-th-list p')]");
	private final By clickOnFolderGridView = By.xpath("//i[contains(@class,'fa fa-folder p')]");
	private final By hoverOnAssetFGV = By.xpath("(//div[contains(@class,'bg-folder')])[1]");
	private final By clickOnFolderAssetPreviewFGV = By.xpath("(//i[contains(@class,'fa fa-eye')])[1]");
	private final By clickOnFVUpArrow = By.xpath("(//i[contains(@class,'fa fa-arrow-up p')])");
	private final By clickOnFolderListView = By.xpath("(//i[contains(@class,'fa fa-th p')])");
	private final By clickOnSearchDropdownFLV = By
			.xpath("(//div[@class='inputs float-right custom-flex']//div[2]//select[1])");
	private final By clickOnSearchAssetFLV = By.xpath("(//input[@id='sort-text'])");
	private final By clickOnSearchIconAssetFLV = By.xpath("((//i[contains(@class,'fa fa-search')])[2])");
	private final By clickOnAssetDelete = By.xpath("(//i[contains(@class,'fa fa-trash')])[1]");
	private final By clickOnYesDelete = By.xpath("(//button[contains(text(),'Yes, Delete')])");
	private final By backdrop = By.id("backdrop");
	private By previewclose = By.xpath("//app-preview-content//a[1]/span");
	private By folderUpArrow = By.xpath("//button[@title='Up']");
	private By analyticsButton = By.xpath("//*[@id=\"manage-assets-table\"]/tbody/tr[1]/td[5]/div/div/a[1]/i");
	private By analyticsclose = By.xpath("//a[@class='close-circle ml5']//i[@class='fa fa-times']");
	private By previewasset = By.xpath("//*[@id=\"manage-assets-table\"]/tbody/tr[1]/td[5]/div/div/a[2]/i");
	private By viewAsset = By.xpath("//span[normalize-space()='View']");
	private By downloadAsset = By.xpath("//span[normalize-space()='Download']");
	private By ViewAssetclose = By.xpath("//a[@title='Close']//i[@class='fa fa-times']");
	private By videoAssetClose = By.xpath("//div/div[2]/div/div/a/i");
	private By interactedTile = By.xpath("//i[contains(@title,'Total interacted assets')]");
	private By nonInteractedTile = By.xpath("//i[@title='Total non interacted assets ']");
	private By Gotohome = By.xpath("//img[@class='cls-pointer']");
	private By accessSharedBreadCrumb = By.xpath("//a[normalize-space()='Access Shared Assets']");

	/** Navigate to Upload Asset Page */
	public void accesssharedAssetSection() {
		WaitUtil.waitForElementVisible(driver, contentMenu, 90);
		ElementUtil.hoverAndClick(driver.findElement(contentMenu), driver);
		WaitUtil.waitAndClick(driver, sharedAssetsOption, 90);
		WaitUtil.waitForPageToLoad(driver, 30);
	}

	public void refreshAssetsPage() {
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

	public void sortAssets(String sortOption) {
		WaitUtil.waitForElementVisible(driver, sortDropdown, 30);
		ElementUtil.selectDropdownByVisibleText(sortDropdown, sortOption, driver);
	}

	public void searchAsset(String keyword) {
		WaitUtil.waitForElementVisible(driver, assetSearchInput, 30);
		ElementUtil.sendText(assetSearchInput, keyword, driver);
		ElementUtil.click(searchIcon, driver);
	}

	public void openFilterAndApply(String fieldName, String condition, String value) {
		try {
			// Click filter icon and wait for dropdown
			WaitUtil.waitAndClick(driver, filterIcon, 20);
			WaitUtil.waitForElementVisible(driver, fieldNameDropdown, 20);

			// ✅ Ensure dropdown is a <select>, re-locate fresh before using Select
			WebElement dropdownElement = WaitUtil.waitForElementVisible(driver, fieldNameDropdown, 20);
			Select dropdown = new Select(dropdownElement);

			boolean optionFound = dropdown.getOptions().stream()
					.anyMatch(opt -> opt.getText().trim().equalsIgnoreCase(fieldName.trim()));

			if (!optionFound) {
				System.out.println("⚠️ Option not yet available: " + fieldName + " — retrying...");
				WaitUtil.waitForPageToLoad(driver, 20);// or small wait util (not Thread.sleep)
				dropdown = new Select(driver.findElement(fieldNameDropdown));
			}

			dropdown.selectByVisibleText(fieldName);
			System.out.println("✅ Field name selected: " + fieldName);

			// Select condition
			ElementUtil.selectDropdownByVisibleText(conditionDropdown, condition, driver);
			System.out.println("✅ Condition selected: " + condition);

			// Enter value and apply filter
			ElementUtil.sendText(valueField, value, driver);
			ElementUtil.click(submitFilter, driver);
			System.out.println("✅ Filter applied successfully for: " + value);
			ElementUtil.click(removeFilter, driver);
			ElementUtil.click(applyFilterClose, driver);

		} catch (NoSuchElementException e) {
			throw new RuntimeException(
					"❌ Dropdown option not found for: " + fieldName + ". Verify exact visible text or wait for load.",
					e);
		} catch (Exception e) {
			throw new RuntimeException("❌ openFilterAndApply failed. Root cause: " + e.getMessage(), e);
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
			WaitUtil.waitAndClick(driver, hoverOnAssetFGV, backdrop, 30);
			WaitUtil.waitAndClick(driver, clickOnFolderAssetPreviewFGV, backdrop, 30);

			// ---- Step 3: Navigate Up ----
			WaitUtil.waitAndClick(driver, clickOnFVUpArrow, backdrop, 30);
			WaitUtil.waitAndClick(driver, hoverOnFGV, backdrop, 30);

			// ---- Step 4: Folder List View ----
			WaitUtil.waitAndClick(driver, clickOnFolderListView, backdrop, 30);
			WaitUtil.waitAndClick(driver, clickOnSearchDropdownFLV, backdrop, 30);
			ElementUtil.selectDropdownByVisibleText(clickOnSearchDropdownFLV, "Search In Folder", driver);

			WaitUtil.waitAndSendKeys(driver, clickOnSearchAssetFLV, "jpg", 20);
			WaitUtil.waitAndClick(driver, clickOnSearchIconAssetFLV, backdrop, 30);

			// ---- Step 5: Back to List View ----
			WaitUtil.waitAndClick(driver, clickOnFVUpArrow, backdrop, 30);
			WaitUtil.waitAndClick(driver, hoverOnFLV, backdrop, 30);
			WaitUtil.waitAndClick(driver, clickOnListView, backdrop, 30);

		} catch (Exception e) {
			throw new RuntimeException("View Actions flow failed", e);
		}
	}

	public void accessAssetViewandDownloadOptions(String fileName) {

		searchAsset(fileName);
		try {
			WaitUtil.waitForPageToLoad(driver, 30);
			// Preview Asset
			WaitUtil.waitAndClick(driver, previewasset, 30);
			WaitUtil.waitForPageToLoad(driver, 30);
			WaitUtil.waitAndClick(driver, viewAsset, 30);
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

			WaitUtil.waitForPageToLoad(driver, 90);

			// Step 4: Close the preview
			// Ensure close button is visible and clickable
			WaitUtil.waitForVisibility(driver, previewclose, 60);
			WaitUtil.waitForElementClickable(driver, previewclose, 60);
			ElementUtil.clickWithRetry(previewclose, driver, 3);
			WaitUtil.waitAndClick(driver, downloadAsset, 30);
			WaitUtil.waitAndClick(driver, ViewAssetclose, 30);
			// View Analytics
			WaitUtil.waitAndClick(driver, analyticsButton, 30);
			WaitUtil.waitForPageToLoad(driver, 30);
			WaitUtil.waitAndClick(driver, analyticsclose, 30);

		}

		catch (Exception e) {
			throw new RuntimeException("View and Download Actions flow failed", e);
		}
	}

	
	public void videoActions(String fileName) {
		searchAsset(fileName);
	
			WaitUtil.waitForPageToLoad(driver, 30);
			// Preview Asset
			WaitUtil.waitAndClick(driver, previewasset, 30);
			WaitUtil.waitForPageToLoad(driver, 30);
			WaitUtil.waitAndClick(driver, accessSharedBreadCrumb, backdrop, 90);
//			WaitUtil.waitForPageToLoad(driver, 30);
//			WaitUtil.waitForVisibility(driver, accessSharedBreadCrumb, 60);
//			WaitUtil.waitForElementClickable(driver, accessSharedBreadCrumb, 60);
//			ElementUtil.clickWithRetry(accessSharedBreadCrumb, driver, 3);

	}
	public void tilesActions(String fileName) {

		WaitUtil.waitForPageToLoad(driver, 30);
		WaitUtil.waitAndClick(driver, interactedTile, backdrop, 30);
		WaitUtil.waitAndClick(driver, nonInteractedTile, backdrop, 30);
		searchAsset(fileName);
		accessAssetViewandDownloadOptions(fileName);

	}

	public void backtohome() {
		try {
			// Wait for the page and any overlay to settle
			WaitUtil.waitForPageToLoad(driver, 60);
			WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 30);

			// Always switch to main DOM in case we're inside an iframe
			driver.switchTo().defaultContent();

			// Retry up to 3 times in case element goes stale
			for (int attempt = 1; attempt <= 3; attempt++) {
				try {
					// Wait for home icon to become clickable
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
					WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(Gotohome));

					// Scroll into view (optional, prevents hidden element issues)
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
							homeButton);

					// Try normal click first
					try {
						homeButton.click();
					} catch (Exception e) {
						// Fallback to JS click if intercepted or stale
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", homeButton);
					}

					// Wait for navigation to complete
					WaitUtil.waitForPageToLoad(driver, 60);
					System.out.println("🏠 Navigated back to home page successfully!");
					return;
				} catch (StaleElementReferenceException e) {
					System.out.println("⚠️ StaleElementReferenceException while clicking home, retry " + attempt);
				} catch (TimeoutException e) {
					System.out.println("⚠️ Home icon not clickable yet, retry " + attempt);
				}

				// Small pause before retrying
				Thread.sleep(1000);
			}

			throw new RuntimeException("❌ Failed to navigate back to home after multiple retries.");

		} catch (Exception e) {
			throw new RuntimeException("❌ Error in backToHome(): " + e.getMessage(), e);
		}
	}

}
