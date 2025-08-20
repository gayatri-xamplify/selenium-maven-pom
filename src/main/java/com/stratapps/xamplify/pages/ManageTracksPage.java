package com.stratapps.xamplify.pages;

import java.awt.AWTException;
import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.stratapps.xamplify.utils.ActionUtil;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;
import com.stratapps.xamplify.utils.DropdownUtil;

public class ManageTracksPage {
	private WebDriver driver;

	private By contentMenu = By.xpath("//span[normalize-space()='Content']");
	private By manageTracks = By.xpath("//span[contains(text(),'Manage Tracks')]");
	private By editTrack = By.xpath(
			"(//a[contains(@class,'custom-icon')]//i[contains(@class,'fa fa-pencil-square-o IconCustomization')])[1]");
	private By clearEndDate = By.xpath("//i[@class='fa fa-refresh npcfs']");
	private By endDateInput = By.xpath("//input[@id='flat-picker']");
	private By selectEndDate = By
			.xpath("//div[contains(@class,'open')]//span[@class='flatpickr-day today']/following-sibling::span[5]");
	private By endHourInput = By.xpath("//div[contains(@class,'open')]//input[@class='numInput flatpickr-hour']");
	private By endMinuteInput = By.xpath("//div[contains(@class,'open')]//input[@class='numInput flatpickr-minute']");
	private By assetsSection = By.xpath("//*[@id='step-3']/div//h5[normalize-space()='Assets']");
	private By addOnAsset = By
			.xpath("(//ul[@class='content__list mContentWid']/li/div/div[1]/span[@class='select-box-asset'])[4]");
	private By shareSection = By.xpath("//h5[normalize-space()='Share']");
	private By updateTrack = By.xpath("//span[normalize-space()='Update']");
	private By refreshButton = By.xpath("//i[@class='fa fa-refresh']");

	private By unpublishIcon = By.xpath("(//i[@class='fa fa-reply IconCustomization'])[1]");
	private By otherRadio = By.xpath("//input[@value='Other']");
	private By unpublishButton = By.xpath("//span[normalize-space()='Unpublish']");
	private By publishIcon = By.xpath("(//i[@class='fa fa-share IconCustomization'])[1]");
	private By confirmPublish = By.xpath("//button[normalize-space()='Yes']");

	private By previewTrack = By.xpath("(//i[@class='fa fa-eye IconCustomization'])[1]");
	private By addToPlaybook = By.xpath("//button[normalize-space()='Add To PlayBooks']");
	private By previewClose = By.xpath("//span[@class='glyphicon glyphicon-remove asset_cross_align']");
	private By trackNavigation = By.xpath("//a[normalize-space()='Manage Tracks']");

	private By trackAnalytics = By.xpath("(//i[@class='fa fa-line-chart IconCustomization'])[1]");
	private By companyAnalytics = By.xpath("(//i[@class='fa fa-line-chart IconCustomization'])[1]");
	private By analyticsSearch = By.xpath("(//input[@placeholder='Search...'])[2]");
	private By partnerAnalytics = By.xpath("(//i[@class='fa fa-line-chart IconCustomization'])[1]");
	private By partnerAnalyticsPopupClose = By.xpath("//div[@id='analytics-list']//i[@class='fa fa-times']");
	private By partnerAnalyticsClose = By
			.xpath("//a[@class='close-circle xamp-margin-left-icon']//i[@class='fa fa-times']");

	private By sortByDropdown = By.xpath("//div[contains(@class, 'float-left')]/select");
	private By searchTrack = By.xpath("//input[@placeholder='search...']");
	private By deleteTrack = By.xpath("(//i[@class='fa fa-trash-o trashIconCustomization'])[1]");
	private By confirmDelete = By.xpath("//button[normalize-space()='Yes, delete it!']");
	private By clearSearch = By.xpath("//button[@class='glyphicon glyphicon-remove search-box-item-clear']");

	private By trackGroupDropdown = By.xpath("//div[@class='group-dropdown']");
	private By gridViewBtn = By.xpath("(//span[@class='btn btn-xs l-g-view margin-space'])[1]");
	private By gridAsset = By.xpath("(//img[@class='img-grid-track'])[1]");
	private By editGridTrack = By.xpath("(//i[@class='fa fa-pencil-square-o'])[1]");
	private By thumbnailIcon = By.xpath("//i[@class='fa fa-camera icon']");
	private By uploadButton = By.xpath("//div[contains(@class, 'fileinput-button-css')]");
	private By cropImageSave = By.xpath("//div[@id='cropImage']/div/div/div[2]/div[3]/div[2]/button/span");
	private By folderView = By.xpath("//div[@class='bg-folder']");
	private By viewFolderTracks = By.xpath("//a[@class='Iconhover custom-icon']");
	private By goBackArrow = By.xpath("//i[contains(@class, 'fa fa-arrow-up ')]");
	private By folderGridDropdown = By
			.xpath("//span[@class='btn btn-xs l-g-view margin-space folder-list-span-custom-width']");
	private By folderSortDropdown = By.xpath("(//select[@id='select-dropdown'])[1]");
	private By folderSearchTypeDropdown = By.xpath("(//select[@id='select-dropdown'])[2]");
	private By folderSearchInput = By.xpath("//input[@placeholder='Search']");
	private By folderArrowIcon = By.xpath("//i[@id='fa-folder-custom-size']");
	private By listViewBtn = By.xpath("//span[@class='btn btn-xs l-g-view']");
	private By homeLink = By.xpath("//a[normalize-space()='Home']");
	private By backdrop = By.cssSelector("div.backdrop");

	public ManageTracksPage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToContentAndManageTracks() {
		WaitUtil.waitForElementVisible(driver, contentMenu, 60);
		ElementUtil.click(contentMenu, driver);
		WaitUtil.waitAndClick(driver, manageTracks, 60);
	}

		public void editTrackDetails() {
	    WaitUtil.waitForPageToLoad(driver, 70);
	    WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);

	    WaitUtil.waitForVisibility(driver, editTrack, 60);
	    ElementUtil.click(editTrack, driver);

	    // Clear & select end date
	    WaitUtil.waitForElementVisible(driver, clearEndDate, 60);
	    ElementUtil.clickWithRetry(clearEndDate, driver, 3);

	    WaitUtil.waitAndClick(driver, endDateInput, 60);
	    ElementUtil.click(selectEndDate, driver);

	    // Set hour/minute based on time
	    Calendar calendar = Calendar.getInstance();
	    int hours = calendar.get(Calendar.HOUR_OF_DAY);

	    if (hours < 12) {
	        ElementUtil.sendText(endHourInput, "1", driver);
	        ElementUtil.sendText(endMinuteInput, "11", driver);
	    } else {
	        ElementUtil.sendText(endHourInput, "11", driver);
	        ElementUtil.sendText(endMinuteInput, "59", driver);
	    }

	    // 💡 Scroll to 'Assets' tab before clicking
	    WebElement assetsTab = driver.findElement(assetsSection);
	    ElementUtil.scrollToElement(assetsTab, driver);  // centers the view
	    //WaitUtil.sleep(500); // allow scroll to settle
	    WaitUtil.waitForElementClickable(driver, assetsSection, 30);
	   //ElementUtil.clickWithRetry(driver, assetsSection, 3);  // robust click
	   ElementUtil.clickWithRetry(assetsSection, driver, 3);

	    // Wait for Add on Asset section and proceed
	    WaitUtil.waitAndClick(driver, addOnAsset, 60);

	    // Click Share tab
	    WaitUtil.waitAndClick(driver, shareSection, 60);

	    // Click update
	    ElementUtil.click(updateTrack, driver);
	    WaitUtil.waitForPageToLoad(driver, 60);

	    // Refresh
	    WaitUtil.waitAndClick(driver, refreshButton, 60);
	}

	public void unpublishTrack() {

		WaitUtil.waitAndClick(driver, unpublishIcon, 60);
		WaitUtil.waitForPageToLoad(driver, 60);
		WaitUtil.waitAndClick(driver, otherRadio, 60);
		ElementUtil.click(unpublishButton, driver);
		WaitUtil.waitForPageToLoad(driver, 60);

	}

	public void publishTrack() {
		WaitUtil.waitAndClick(driver, publishIcon, 60);
		WaitUtil.waitAndClick(driver, confirmPublish, 60);

	}

	public void previewTrackAndReturn() {

		WaitUtil.waitAndClick(driver, previewTrack, 50);
		WaitUtil.waitAndClick(driver, previewTrack, 50);
		WaitUtil.waitForPageToLoad(driver, 60);
		WaitUtil.waitAndClick(driver, previewClose, 50);
		WaitUtil.waitForPageToLoad(driver, 60);
		WaitUtil.waitAndClick(driver, addToPlaybook, 90);
		WaitUtil.waitForPageToLoad(driver, 60);
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);

		WaitUtil.waitAndClick(driver, trackNavigation, 90);
	}

	public void uploadThumbnail(String localFilePath) {
		WebElement fileInput = driver.findElement(By.id("custom-input"));
		fileInput.sendKeys(localFilePath);
	}

	public void viewTrackAnalytics() {

		WaitUtil.waitForPageToLoad(driver, 70);
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
		WaitUtil.waitAndClick(driver, trackAnalytics, 60);
		WaitUtil.waitForPageToLoad(driver, 70);
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
		WaitUtil.waitForVisibility(driver, companyAnalytics, 60);
		ElementUtil.click(companyAnalytics, driver);
		ElementUtil.sendText(analyticsSearch, "Automate", driver);
		ElementUtil.sendKey(analyticsSearch, Keys.ENTER, driver);
		WaitUtil.waitForPageToLoad(driver, 70);
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
		WaitUtil.waitForVisibility(driver, partnerAnalytics, 60);
		ElementUtil.click(partnerAnalytics, driver);
		WaitUtil.waitAndClick(driver, partnerAnalyticsPopupClose, 60);
		WaitUtil.waitAndClick(driver, partnerAnalyticsClose, 60);
		WaitUtil.waitForPageToLoad(driver, 70);
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
		ElementUtil.click(trackNavigation, driver);
	}

	public void sortAndDeleteTrack() {
		WaitUtil.waitForPageToLoad(driver, 70);
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
		DropdownUtil.selectByValue(driver, sortByDropdown, "1: Object");
		ElementUtil.sendText(searchTrack, "track", driver);
		ElementUtil.sendKey(searchTrack, Keys.ENTER, driver);
		WaitUtil.waitAndClick(driver, deleteTrack, 70);
		WaitUtil.waitForVisibility(driver, confirmDelete, 60);
		WaitUtil.waitAndClick(driver, confirmDelete, 70);
		WaitUtil.waitForElementVisible(driver, clearSearch, 60);
		ElementUtil.clickWithRetry(clearSearch, driver, 3);
	}

	public void trackViews(String localFilePath) {
		WaitUtil.waitForPageToLoad(driver, 70);
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
		ElementUtil.click(trackGroupDropdown, driver);

		WaitUtil.waitForElementVisible(driver, gridViewBtn, 60);
		ElementUtil.clickWithRetry(gridViewBtn, driver, 3); // Use robust click
		WaitUtil.waitForVisibility(driver, gridAsset, 70);
		ElementUtil.click(gridAsset, driver);
		ElementUtil.click(editGridTrack, driver);
		WaitUtil.waitForElementVisible(driver, thumbnailIcon, 60);


//		WaitUtil.waitForVisibility(driver, editGridTrack, 60);
//
//		// Scroll directly to the element
//		WebElement editIcon = driver.findElement(editGridTrack);
//		ElementUtil.scrollToElement(editIcon, driver);
//
//		// Additional scroll to handle sticky headers if needed
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", editIcon);
//		//Thread.sleep(500); // Give time for scroll animation if needed
//
//		// Ensure clickable and then click
//		WaitUtil.waitForElementClickable(driver, editGridTrack, 30);
//		ElementUtil.click(editGridTrack, driver);
	    
	    WaitUtil.waitForElementVisible(driver, thumbnailIcon, 60);

	    ElementUtil.clickWhenReady(driver, thumbnailIcon, 30);
	    WaitUtil.waitForVisibility(driver, uploadButton, 70);

	    // ✅ Upload thumbnail file directly
	    uploadThumbnail(localFilePath);

	    ElementUtil.clickWhenReady(driver, cropImageSave, 30);
	    ElementUtil.clickWhenReady(driver, shareSection, 30);
	    ElementUtil.clickWhenReady(driver, updateTrack, 30);

	    WaitUtil.waitForVisibility(driver, refreshButton, 70);
	    ElementUtil.clickWhenReady(driver, refreshButton, 30);

	    ElementUtil.clickWhenReady(driver, trackGroupDropdown, 30);
	    ElementUtil.clickWhenReady(driver, gridViewBtn, 30);

	    WaitUtil.waitForPageToLoad(driver, 70);
	    WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
	    WaitUtil.waitForVisibility(driver, folderView, 70);

	    ElementUtil.clickWhenReady(driver, folderView, 30);
	    ElementUtil.clickWhenReady(driver, viewFolderTracks, 30);

	    WaitUtil.waitAndClick(driver, goBackArrow, 60);
	    WaitUtil.waitForPageToLoad(driver, 70);

	    WaitUtil.waitAndClick(driver, trackGroupDropdown, 60);
	    WaitUtil.waitForPageToLoad(driver, 70);
	    WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
	    WaitUtil.waitForVisibility(driver, folderView, 70);
	    WaitUtil.waitForVisibility(driver, folderGridDropdown, 70);

	    ElementUtil.clickWhenReady(driver, folderGridDropdown, 30);
	    WaitUtil.waitForPageToLoad(driver, 70);

	    WaitUtil.waitAndClick(driver, folderSortDropdown, 60);
	    DropdownUtil.selectByVisibleText(driver, folderSortDropdown, "Name(Z-A)");

	    WaitUtil.waitAndClick(driver, folderSearchTypeDropdown, 60);
	    DropdownUtil.selectByVisibleText(driver, folderSearchTypeDropdown, "Search In Folder");

	    ElementUtil.sendText(folderSearchInput, "default", driver);
	    ElementUtil.sendKey(folderSearchInput, Keys.ENTER, driver);

	    WaitUtil.waitAndClick(driver, goBackArrow, 80);
	    WaitUtil.waitAndClick(driver, folderArrowIcon, 80);
	    WaitUtil.waitAndClick(driver, trackGroupDropdown, 80);

	    ElementUtil.clickWhenReady(driver, listViewBtn, 30);
	    WaitUtil.waitAndClick(driver, homeLink, 80);
	}



}
