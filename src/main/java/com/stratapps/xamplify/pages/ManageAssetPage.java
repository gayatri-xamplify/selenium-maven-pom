package com.stratapps.xamplify.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.ScreenshotUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class ManageAssetPage {

	private WebDriver driver;
	private UploadAssetPage uploadAssetPage;

	public ManageAssetPage(WebDriver driver) {
		this.driver = driver;
		this.uploadAssetPage = new UploadAssetPage(driver); // ✅ assign to the field
	}

	// ================= LOCATORS =================

	private By contentMenu = By.xpath("//span[contains(text(),'Content')]");
	private By ManageAssets = By.xpath("//span[normalize-space()='Manage Assets']");
	private By refreshIcon = By.xpath("//i[@class='fa fa-refresh']");
	private By sortDropdown = By.xpath("//select[@id='alignline-m-width']");
	private By assetSearchInput = By.xpath("//input[@placeholder='search...']");
	private By searchIcon = By.xpath("//i[@class='fa fa-search']");
	private By editAssetButton = By
			.xpath("(//table[@id='manage-assets-table']//a[@title='Edit']//i[contains(@class,'fa-edit')])[1]");
	private By editVideoAsset = By.xpath("//*[@id=\"manage-assets-table\"]/tbody/tr[1]/td[5]/div/div/a[1]/i");
	// private By browseButton = By.xpath("//input[@type='file']");
	private By updateButton = By.xpath("//span[@class='btn btn-primary transition']");
	private By successMessage = By.xpath("//h4[@class='ng-tns-c11-16']");
	private By downloadButton = By.xpath("//tbody/tr[1]/td[5]/div[1]/div[1]/a[3]/i[1]");
	private By analyticsButton = By.xpath("//tbody/tr[1]/td[5]/div[1]/div[1]/a[4]/i[1]");
	private By manageAssetsBreadcrumb = By.xpath("//a[normalize-space()='Manage Assets']");
	private By deleteButton = By.xpath("//tbody/tr[3]/td[5]/div[1]/div[1]/a[5]/i[1]");
	private By confirmYes = By.xpath("//button[normalize-space()='Yes, delete it!']");


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
	private By previewButton = By.xpath("//table[@id='manage-assets-table']//tr[1]//td[5]//a[2]");
	private By previewclose = By.xpath("//app-preview-content//a[1]/span");
	private By folderUpArrow = By.xpath("//button[@title='Up']");
	// Filter locators
	private By filterIcon = By.xpath("//i[@class='fa fa-filter p10']");
	private By fieldNameDropdown = By.xpath("(//div/div[1]/select)[2]");
	private By conditionDropdown = By.xpath("(//div/div[2]/select)[1]");
	private By TypeDropdown = By.xpath("(//div/div[2]/select)[1]");
	private By valueField = By.xpath("//input[@placeholder='value*']");
	private By submitFilter = By.xpath("//button[normalize-space()='Submit']");
	private By removeFilter = By.xpath("//i[@class='fa fa-filter']");
	private By applyFilterClose = By.xpath("(//button[normalize-space()='Cancel'])[2]");
	private By replacebutton = By.xpath("//span[normalize-space()='Replace']");
	private By previewVideoAsset = By.xpath("//*[@id=\"manage-assets-table\"]/tbody/tr[1]/td[5]/div/div/a[3]/i");
	private By videoAnalytics = By.xpath("//*[@id=\"manage-assets-table\"]/tbody/tr[1]/td[5]/div/div/a[5]/i");
	private By despdfAsseticon = By.xpath("//*[@id=\"manage-assets-table\"]/tbody/tr[1]/td[5]/div/div/a[2]/i");
	private By editpdfAssetButton = By.xpath("//*[@id=\"manage-assets-table\"]/tbody/tr[1]/td[5]/div/div/a[2]/i");
	private By previewpdfAssetButton = By.xpath("//*[@id=\"manage-assets-table\"]/tbody/tr[1]/td[5]/div/div/a[3]/i");
	private By downloadpdfAssetButton = By.xpath("//*[@id=\"manage-assets-table\"]/tbody/tr[1]/td[5]/div/div/a[4]/i");
	private By analyticspdfAssetButton = By.xpath("//*[@id=\"manage-assets-table\"]/tbody/tr[1]/td[5]/div/div/a[5]/i");
	private By deletepdfAssetButton = By.xpath("//*[@id=\"manage-assets-table\"]/tbody/tr[1]/td[5]/div/div/a[6]/i");
	private By loader   = By.xpath("//*[contains(@class,'spinner') or contains(@class,'loader')]");

	// ================= ACTION METHODS =================
	public void openManageAssetSection() {
		WaitUtil.waitForElementVisible(driver, contentMenu, 90);
		ElementUtil.hoverAndClick(driver.findElement(contentMenu), driver);
		WaitUtil.waitAndClick(driver, ManageAssets, 90);
	}

	public void refreshAssetsPage() {
		WaitUtil.waitAndClick(driver, refreshIcon, 30);
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

	public void editAndReplaceAsset(String filePath) {

		// Wait until element is visible and clickable
		WaitUtil.waitForVisibility(driver, editAssetButton, 60);
		WaitUtil.waitForElementClickable(driver, editAssetButton, 60);

		// Click using a safe retry utility
		ElementUtil.clickWithRetry(editAssetButton, driver, 3);

		// ElementUtil.click(editAssetButton, driver);

		uploadAssetPage.uploadFile(filePath);
		uploadAssetPage.handleOopsPopup();

		ElementUtil.click(updateButton, driver);
		// WaitUtil.waitForElementVisible(driver, successMessage, 30);
	}

	public void deleteAssetFile(String fileName) {
		// Search for the asset
		searchAsset(fileName);

		// Wait until element is visible and clickable
		WaitUtil.waitForVisibility(driver, deleteButton, 60);
		WaitUtil.waitForElementClickable(driver, deleteButton, 60);

		// Click using a safe retry utility
		ElementUtil.clickWithRetry(deleteButton, driver, 3);

		// ElementUtil.click(deleteButton, driver);
		WaitUtil.waitAndClick(driver, confirmYes, 10);

		ScreenshotUtil.captureScreenshot(driver, "Asset Deletion Confirmation");
	}

	public void previewAsset(String fileName) throws Exception {
	    try {

	        // ================================
	        // STEP 1 → SAFE REFRESH
	        // ================================
	        WaitUtil.waitForPageToLoad(driver, 60);

	        try { WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 20); } catch (Exception ignore) {}
	        try { WaitUtil.waitForInvisibilityOfElement(loader, driver, 20); } catch (Exception ignore) {}

	        WebElement refreshBtn = WaitUtil.waitForElementVisible(driver, refreshIcon, 40);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", refreshBtn);

	        try {
	            WaitUtil.waitForElementClickable(driver, refreshIcon, 20).click();
	        } catch (Exception e) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", refreshBtn);
	        }

	        WaitUtil.waitForPageToLoad(driver, 60);
	        Thread.sleep(700);  // Angular reflow buffer


	        // ================================
	        // STEP 2 → SAFE PREVIEW CLICK
	        // ================================
	        try { WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 20); } catch (Exception ignore) {}
	        try { WaitUtil.waitForInvisibilityOfElement(loader, driver, 20); } catch (Exception ignore) {}

	        WebElement previewBtn = WaitUtil.waitForElementVisible(driver, previewButton, 40);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", previewBtn);

	        try {
	            WaitUtil.waitForElementClickable(driver, previewButton, 20).click();
	        } catch (Exception e) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", previewBtn);
	        }

	        Thread.sleep(1500);  // Let preview open fully


	        // ================================
	        // STEP 3 → OPTIONAL REFRESH AFTER PREVIEW
	        // ================================
	        try {
	            WebElement refresh = WaitUtil.waitForElementPresent(driver, refreshIcon, 3);
	            if (refresh != null) {
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", refresh);
	                System.out.println("🔄 Refresh icon found and clicked successfully.");
	            }
	        } catch (Exception ignore) {}


	        // ================================
	        // STEP 4 → SAFE CLOSE PREVIEW
	        // ================================
	        WebElement closeBtn = WaitUtil.waitForElementVisible(driver, previewclose, 40);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", closeBtn);

	        try {
	            WaitUtil.waitForElementClickable(driver, previewclose, 20).click();
	        } catch (Exception e) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);
	        }

	        System.out.println("✅ Preview opened and closed successfully for asset: " + fileName);

	    } catch (Exception e) {
	        System.err.println("❌ Failed to preview asset '" + fileName + "': " + e.getMessage());
	        throw e;
	    }
	}


	public void downloadAsset() {

		// Wait until element is visible and clickable
		WaitUtil.waitForVisibility(driver, downloadButton, 60);
		WaitUtil.waitForElementClickable(driver, downloadButton, 60);

		// Click using a safe retry utility
		ElementUtil.clickWithRetry(downloadButton, driver, 3);

	}

	public void viewAnalytics() {
		WaitUtil.waitForVisibility(driver, analyticsButton, 60);
		WaitUtil.waitForElementClickable(driver, analyticsButton, 60);

		// Click using a safe retry utility
		ElementUtil.clickWithRetry(analyticsButton, driver, 3);
		WaitUtil.waitForElementVisible(driver, manageAssetsBreadcrumb, 20);
		ElementUtil.click(manageAssetsBreadcrumb, driver);
		uploadAssetPage.backToHome();
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
			WaitUtil.waitAndClick(driver, clickOnAssetDelete, backdrop, 30);
			WaitUtil.waitAndClick(driver, confirmYes, backdrop, 30);
			ScreenshotUtil.captureScreenshot(driver, "Asset Deletion Confirmation");

			// ---- Step 5: Back to List View ----
			WaitUtil.waitAndClick(driver, clickOnFVUpArrow, backdrop, 30);
			WaitUtil.waitAndClick(driver, hoverOnFLV, backdrop, 30);
			WaitUtil.waitAndClick(driver, clickOnListView, backdrop, 30);

		} catch (Exception e) {
			throw new RuntimeException("View Actions flow failed", e);
		}
	}

	public void videoActions(String filePath) {
		try {
			// 🔄 Step 1: Refresh twice
			WaitUtil.waitAndClick(driver, refreshIcon, 30);
			WaitUtil.waitForPageToLoad(driver, 60);
			System.out.println("🔁 First refresh done");

			WaitUtil.waitAndClick(driver, refreshIcon, 30);
			WaitUtil.waitForPageToLoad(driver, 60);
			System.out.println("🔁 Second refresh done");

			// 🎬 Step 2: Click Edit Video Asset
			WaitUtil.waitForVisibility(driver, editVideoAsset, 60);
			ElementUtil.clickWithRetry(editVideoAsset, driver, 3);
			WaitUtil.waitForPageToLoad(driver, 60);
			System.out.println("🎬 Edit video asset clicked");

			// ♻️ Step 3: Click Replace button
			WaitUtil.waitAndClick(driver, replacebutton, 30);
			WaitUtil.waitForPageToLoad(driver, 60);
			System.out.println("♻️ Replace button clicked");

			// 📂 Step 4: Upload file (sendKeys preferred)
			uploadAssetPage.uploadFile(filePath);
			uploadAssetPage.handleOopsPopup();

			// 💾 Step 5: Click Replace Update
			WaitUtil.waitAndClick(driver, updateButton, 30);
			WaitUtil.waitForPageToLoad(driver, 60);
			System.out.println("💾 Replace update clicked");
			uploadAssetPage.backToHome();

		} catch (Exception e) {
			throw new RuntimeException("Video Actions flow failed", e);
		}
	}

	public void pdfAssetActions(String fileName) {

		try {
			// ===== Wait for Manage Assets page to load =====
			WaitUtil.waitForPageToLoad(driver, 60);
			System.out.println("📄 Manage Assets page loaded.");

			// ===== Optional Refresh Step =====
			try {
				WebElement refresh = WaitUtil.waitForElementPresent(driver, refreshIcon, 5);
				if (refresh != null) {
					ElementUtil.click(refreshIcon, driver);
					System.out.println("🔄 Page refreshed successfully.");
				} else {
					System.out.println("⏭️ Refresh icon not found, skipping.");
				}
			} catch (Exception e) {
				System.out.println("⚠️ Could not click refresh icon. Cause: " + e.getMessage());
			}

			// ===== Perform each action sequentially =====

			// Preview action
			searchAsset(fileName);
			WaitUtil.waitAndClick(driver, previewpdfAssetButton, 30);
			WaitUtil.waitForPageToLoad(driver, 30);
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
			WaitUtil.waitForVisibility(driver, previewclose, 60);
			WaitUtil.waitForElementClickable(driver, previewclose, 60);
			ElementUtil.clickWithRetry(previewclose, driver, 3);

			// Download action
			searchAsset(fileName);
			WaitUtil.waitAndClick(driver, downloadpdfAssetButton, 30);
			System.out.println("⬇️ Download Asset action triggered.");

			// Analytics action
			WaitUtil.waitForElementVisible(driver, analyticspdfAssetButton, 30);
			WaitUtil.waitAndClick(driver, analyticspdfAssetButton, 30);
			WaitUtil.waitForPageToLoad(driver, 30);
			System.out.println("📊 Analytics Asset action performed.");
			WaitUtil.waitAndClick(driver, manageAssetsBreadcrumb, 30);

			// Delete action — Optional & Safe
			searchAsset(fileName);
			WaitUtil.waitForElementVisible(driver, deletepdfAssetButton, 30);

			ElementUtil.click(deletepdfAssetButton, driver);
			System.out.println("🗑️ Delete Asset clicked. Confirm popup should be handled separately.");

			uploadAssetPage.backToHome();
			System.out.println("✅ All PDF asset actions executed successfully.");

		} catch (Exception e) {
			System.out.println("❌ Failed to perform PDF asset actions. Cause: " + e.getMessage());
		}
	}

}
