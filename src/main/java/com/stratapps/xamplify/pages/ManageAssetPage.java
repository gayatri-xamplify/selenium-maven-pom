package com.stratapps.xamplify.pages;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.ScreenshotUtil;
import com.stratapps.xamplify.utils.WaitUtil;
import com.stratapps.xamplify.utils.ActionUtil;

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
	private By deletemsg = By.xpath("//*[@id=\"responseMessage\"]");
	private By clearSearch = By.xpath("//button[@title='Clear Search']");

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
    private final By clickOnSearchDropdownFLV = By.xpath("(//div[@class='inputs float-right custom-flex']//div[2]//select[1])");
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
			// Step 1: Refresh and wait for table load
			WaitUtil.waitAndClick(driver, refreshIcon, 30);
			WaitUtil.waitForPageToLoad(driver, 60);

			// Step 2: Wait for and click preview button
			WaitUtil.waitForVisibility(driver, previewButton, 60);
			WaitUtil.waitForElementClickable(driver, previewButton, 60);
			ElementUtil.clickWithRetry(previewButton, driver, 3);
			
			// Step 3: Verify preview opened
			// Give buffer time for full render
			Thread.sleep(2000);
			WaitUtil.waitAndClick(driver, refreshIcon, 30);
			WaitUtil.waitForPageToLoad(driver, 90);
			
			// Step 4: Close the preview
			// Ensure close button is visible and clickable
			WaitUtil.waitForVisibility(driver, previewclose, 60);
			WaitUtil.waitForElementClickable(driver, previewclose, 60);
			ElementUtil.clickWithRetry(previewclose, driver, 3);

			// Step 5: Verify preview closed
			// WaitUtil.waitForInvisibilityOfElement(fileViewer, driver, 30);

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
	}


	public void openFilterAndApply(String fieldName, String condition, String value) {
		WaitUtil.waitAndClick(driver, filterIcon, 20);
		ElementUtil.selectDropdownByVisibleText(fieldNameDropdown, fieldName, driver);
		ElementUtil.selectDropdownByVisibleText(conditionDropdown, condition, driver);
		ElementUtil.sendText(valueField, value, driver);
		ElementUtil.click(submitFilter, driver);
		ElementUtil.click(editVideoAsset, driver);
		WaitUtil.waitAndClick(driver, replacebutton, 10);
		uploadAssetPage.uploadFile("D:\\git\\selenium-maven-pom\\files\\test-mp4.mp4");
		uploadAssetPage.handleOopsPopup();
		WaitUtil.waitAndClick(driver, updateButton, 10);
//		WaitUtil.waitAndClick(driver, removeFilter, 10);
//		WaitUtil.waitAndClick(driver, applyFilterClose, 10);
	}

	
	
	public void viewActions() {
        try {
            WaitUtil.waitForPageToLoad(driver, 30);

            // ---- Step 1: Switch to Grid View ----
            WaitUtil.waitAndClick(driver, hoverOnListView, backdrop, 30);
            WaitUtil.waitAndClick(driver, clickOnGridView, backdrop, 30);

//            // ---- Step 2: Preview Asset in Grid View ----
//            WaitUtil.waitAndClick(driver, hoverOnAssetGV, backdrop, 30);
//            WaitUtil.waitAndClick(driver, clickOnAssetPreview, backdrop, 30);

          

            // ---- Step 4: Folder Grid View ----
            WaitUtil.waitAndClick(driver, hoverOnGridView, backdrop, 30);
            WaitUtil.waitAndClick(driver, clickOnFolderGridView, backdrop, 30);
            WaitUtil.waitAndClick(driver, hoverOnAssetFGV, backdrop, 30);
            WaitUtil.waitAndClick(driver, clickOnFolderAssetPreviewFGV, backdrop, 30);

            // ---- Step 5: Navigate Up ----
            WaitUtil.waitAndClick(driver, clickOnFVUpArrow, backdrop, 30);
            WaitUtil.waitAndClick(driver, hoverOnFGV, backdrop, 30);

            // ---- Step 6: Folder List View ----
            WaitUtil.waitAndClick(driver, clickOnFolderListView, backdrop, 30);
            WaitUtil.waitAndClick(driver, clickOnSearchDropdownFLV, backdrop, 30);
            ElementUtil.selectDropdownByVisibleText(clickOnSearchDropdownFLV, "Search In Folder",driver);

            WaitUtil.waitAndSendKeys(driver, clickOnSearchAssetFLV, "jpg", 20);
            WaitUtil.waitAndClick(driver, clickOnSearchIconAssetFLV, backdrop, 30);
            WaitUtil.waitAndClick(driver, clickOnAssetDelete, backdrop, 30);
            WaitUtil.waitAndClick(driver, confirmYes, backdrop, 30);
            ScreenshotUtil.captureScreenshot(driver, "Asset Deletion Confirmation");

            // ---- Step 7: Back to List View ----
            WaitUtil.waitAndClick(driver, clickOnFVUpArrow, backdrop, 30);
            WaitUtil.waitAndClick(driver, hoverOnFLV, backdrop, 30);
            WaitUtil.waitAndClick(driver, clickOnListView, backdrop, 30);

        } catch (Exception e) {
            throw new RuntimeException("View Actions flow failed", e);
        }
    }
	

}
