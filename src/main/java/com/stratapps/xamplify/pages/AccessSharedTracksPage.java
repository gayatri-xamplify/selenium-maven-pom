
package com.stratapps.xamplify.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class AccessSharedTracksPage {

	private WebDriver driver;
	private WebDriverWait wait;
	public AccessSharedTracksPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	private By contentMenu = By.xpath("//span[normalize-space()='Content']");
	private By sharedTracksOption = By.xpath("//span[normalize-space()='Access Shared Tracks']");
	private By refreshIcon = By.xpath("//i[@class='fa fa-refresh']");
	private By sortDropdown = By.xpath("//select[contains(@class,'mDamSort')]");
	private By TrackSearchInput = By.xpath("//input[@placeholder='search...']");
	private By searchIcon = By.xpath("//i[@class='fa fa-search']");

	// View locators
	private final By hoverOnListView = By.xpath("//button[contains(@class,'fa fa-th-list btn btn-xs l-g-view mr')]");
	private final By hoverOnGridView = By.xpath("//button[contains(@class,'fa fa-th-large btn btn-xs l-g-view mr')]");
	private final By hoverOnFGV = By.xpath("(//button[contains(@class,'fa fa-folder btn-xs l-g-view')])");
	private final By hoverOnFLV = By.xpath("(//button[contains(@class,'fa fa-th btn-xs l-g-view')])");
	private final By hoverOnTrackGV = By.xpath("(//div[@class='aligntowbtns'])[1]");
	private final By clickOnTrackPreview = By.xpath("(//a[contains(@class,'custom-icon')])[1]");
	private final By clickOnTrackPreview1 = By.xpath("(//a[contains(@class,'custom-icon')])[2]");
	private final By clickOnGridView = By.xpath("//i[contains(@class,'fa fa-th-large p')]");
	private final By clickOnListView = By.xpath("//i[contains(@class,'fa fa-th-list p')]");
	private final By clickOnFolderGridView = By.xpath("//i[contains(@class,'fa fa-folder p')]");
	private final By hoverOnTrackFGV = By.xpath("(//div[contains(@class,'bg-folder')])[1]");
	private final By clickOnFolderTrackPreviewFGV = By.xpath("(//i[contains(@class,'fa fa-eye')])[1]");
	private final By clickOnFVUpArrow = By.xpath("(//i[contains(@class,'fa fa-arrow-up p')])");
	private final By clickOnFolderListView = By.xpath("(//i[contains(@class,'fa fa-th p')])");
	private final By clickOnSearchDropdownFLV = By
			.xpath("(//div[@class='inputs float-right custom-flex']//div[2]//select[1])");
	private final By clickOnSearchTrackFLV = By.xpath("(//input[@id='sort-text'])");
	private final By clickOnSearchIconTrackFLV = By.xpath("((//i[contains(@class,'fa fa-search')])[2])");
	private final By clickOnTrackDelete = By.xpath("(//i[contains(@class,'fa fa-trash')])[1]");
	private final By clickOnYesDelete = By.xpath("(//button[contains(text(),'Yes, Delete')])");
	private final By backdrop = By.id("backdrop");
	private By previewclose = By.xpath("//span[@class='glyphicon glyphicon-remove asset_cross_align']");
	private By folderUpArrow = By.xpath("//button[@title='Up']");
	private By analyticsButton = By.xpath("//*[@id=\"manage-Tracks-table\"]/tbody/tr[1]/td[5]/div/div/a[1]/i");
	private By analyticsclose = By.xpath("//a[@class='close-circle ml5']//i[@class='fa fa-times']");
	private By previewTrack = By.xpath("//*[@id=\"actions-row\"]/div/a/i[1]");
	private By viewTrack = By.xpath("//span[normalize-space()='View']");
	private By downloadTrack = By.xpath("//span[normalize-space()='Download']");
	private By ViewTrackclose = By.xpath("//span[@class='glyphicon glyphicon-remove']");
	private By viewVideoclose = By.xpath("//span[@class='glyphicon glyphicon-remove asset_cross_align']");
	private By interactedTile = By.xpath("//i[contains(@title,'Total interacted Tracks')]");
	private By nonInteractedTile = By.xpath("//i[@title='Total non interacted Tracks ']");
	private By Gotohome = By.xpath("//img[@class='cls-pointer']");
	private By disabledText = By.xpath("//div[contains(text(),'The Track expired')]");
	private By breadcrumbSharedTracks = By.xpath("//a[contains(text(),'Shared Tracks')]");
	private By firstAssetRow = By.xpath("(//table[@id='manage-assets-table']//tr[1])[2]");
	private By submitform = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By mandatoryQuestions = By
			.xpath("//div[contains(@class,'form-group')][.//span[contains(@class,'required')]]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By emailField = By.xpath("//div[@class='panel-body border-fivepx padding-20px']//div[2]//div[1]//div[1]");
	private By formclose = By.xpath("//span[@class='glyphicon glyphicon-remove']");
	private By viewAssetTrack = By.xpath("//button[normalize-space()='View']");
	private By downloadAssetTrack = By.xpath("//button[normalize-space()='Download']");
	private By goToHome = By.xpath("//img[@class='cls-pointer']");
	private By inProgressTile = By.xpath("//i[@title='Total in progress tracks']");
	private By completedTile = By.xpath("//i[@title='Total completed tracks']");
	private By notViewedTile = By.xpath("//i[@title='Total not viewed tracks']");
	private By allTile = By.xpath("//i[@title='Total records of tracks']");
	

	/** Navigate to Upload Track Page */
	public void accesssharedTrackSection() {

		WaitUtil.waitForElementVisible(driver, contentMenu, 90);
		ElementUtil.hoverAndClick(driver.findElement(contentMenu), driver);
		WaitUtil.waitAndClick(driver, sharedTracksOption, 90);
		WaitUtil.waitForPageToLoad(driver, 30);
	}

	public void refreshTracksPage() {
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

	public void sortTracks(String sortOption) {
		WaitUtil.waitForLoaderToDisappear(driver, 60);
		WaitUtil.waitForElementVisible(driver, sortDropdown, 30);
		ElementUtil.selectDropdownByVisibleText(sortDropdown, sortOption, driver);
	}

	public void searchTrack(String keyword) {
		WaitUtil.waitForElementVisible(driver, TrackSearchInput, 30);
		ElementUtil.sendText(TrackSearchInput, keyword, driver);
		ElementUtil.click(searchIcon, driver);
	}

	public void viewTrackDetails() {
		try {
			WaitUtil.waitForPageToLoad(driver, 30);
			WaitUtil.waitAndClick(driver, clickOnTrackPreview, backdrop, 30);
			WaitUtil.waitAndClick(driver, previewclose, backdrop, 30);
		} catch (Exception e) {
			throw new RuntimeException("View Track Details flow failed", e);
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
			WaitUtil.waitAndClick(driver, hoverOnTrackFGV, backdrop, 30);
			WaitUtil.waitAndClick(driver, clickOnFolderTrackPreviewFGV, backdrop, 30);

			// ---- Step 3: Navigate Up ----
			WaitUtil.waitAndClick(driver, clickOnFVUpArrow, backdrop, 30);
			WaitUtil.waitAndClick(driver, hoverOnFGV, backdrop, 30);

			// ---- Step 4: Folder List View ----
			WaitUtil.waitAndClick(driver, clickOnFolderListView, backdrop, 30);
			WaitUtil.waitAndClick(driver, clickOnSearchDropdownFLV, backdrop, 30);
			ElementUtil.selectDropdownByVisibleText(clickOnSearchDropdownFLV, "Search In Folder", driver);

			WaitUtil.waitAndSendKeys(driver, clickOnSearchTrackFLV, "jpg", 20);
			WaitUtil.waitAndClick(driver, clickOnSearchIconTrackFLV, backdrop, 30);

			// ---- Step 5: Back to List View ----
			WaitUtil.waitAndClick(driver, clickOnFVUpArrow, backdrop, 30);
			WaitUtil.waitAndClick(driver, hoverOnFLV, backdrop, 30);
			WaitUtil.waitAndClick(driver, clickOnListView, backdrop, 30);

		} catch (Exception e) {
			throw new RuntimeException("View Actions flow failed", e);
		}
	}

	public void viewTrackAndClickAssets() throws InterruptedException {

		try {
			// 1️⃣ Click the View Track button
			WaitUtil.waitAndClick(driver, clickOnTrackPreview, backdrop, 30);
			WaitUtil.waitForPageToLoad(driver, 90);

//	        // 2️⃣ Handle "Track Expired" → Breadcrumb
//	        if (ElementUtil.isDisplayed(disabledText, driver)) {
//	            ElementUtil.click(breadcrumbSharedTracks, driver);
//	            System.out.println("⚠️ Track is expired. Returned to sharedTracks.");
//	        }
//	    	
		} catch (Exception e) {
			throw new RuntimeException("View Track flow failed", e);
		}
		By clickOnTrackPreviewViewAsset = By.xpath("//*[@id=\"manage-assets-table\"]/tbody/tr[1]/td[2]/div");
		// Retry open Track Preview (2nd icon)
		WaitUtil.waitForPageToLoad(driver, 90);
		WaitUtil.waitForElementClickable(driver, clickOnTrackPreviewViewAsset, 30);
		ElementUtil.clickWithRetry(clickOnTrackPreviewViewAsset, driver, 3);
		WaitUtil.waitAndClick(driver, viewAssetTrack, 30);
		WaitUtil.waitForPageToLoad(driver, 30);
		WaitUtil.waitAndClick(driver, ViewTrackclose, 60);
		ElementUtil.click(downloadAssetTrack, driver);
		WaitUtil.waitForPageToLoad(driver, 90);
		WaitUtil.waitAndClick(driver, previewclose, 60);
		//ElementUtil.click(previewclose, driver);
		WaitUtil.waitForPageToLoad(driver, 30);

		// Video Asset view
		By clickOnTrackPreviewViewAsset2 = By.xpath("//*[@id=\"manage-assets-table\"]/tbody/tr[2]/td[2]/div");
		// Retry open Track Preview (2nd icon)
		WaitUtil.waitForPageToLoad(driver, 90);
		WaitUtil.waitForElementClickable(driver, clickOnTrackPreviewViewAsset2, 30);
		ElementUtil.clickWithRetry(clickOnTrackPreviewViewAsset2, driver, 3);
		WaitUtil.waitForPageToLoad(driver, 50);
//		WaitUtil.waitForVisibility(driver, viewVideoclose, 50);
//		WaitUtil.waitAndClick(driver, viewVideoclose, 60);
		WaitUtil.waitAndClick(driver, viewAssetTrack, 30);
		WaitUtil.waitForPageToLoad(driver, 30);
		WaitUtil.waitAndClick(driver, ViewTrackclose, 60);
		ElementUtil.click(downloadAssetTrack, driver);
		WaitUtil.waitForPageToLoad(driver, 90);
		Thread.sleep(2000);
		ElementUtil.click(previewclose, driver);
		WaitUtil.waitForPageToLoad(driver, 30);

		// Asset # Viewed
		By clickOnTrackPreviewViewAsset3 = By.xpath("//*[@id=\"manage-assets-table\"]/tbody/tr[3]/td[2]/div");
		// Retry open Track Preview (2nd icon)
		WaitUtil.waitForPageToLoad(driver, 90);
		WaitUtil.waitForElementClickable(driver, clickOnTrackPreviewViewAsset3, 30);
		ElementUtil.clickWithRetry(clickOnTrackPreviewViewAsset3, driver, 3);
		WaitUtil.waitAndClick(driver, viewAssetTrack, 30);
		WaitUtil.waitForPageToLoad(driver, 30);
		WaitUtil.waitAndClick(driver, ViewTrackclose, 60);
		ElementUtil.click(downloadAssetTrack, driver);
		WaitUtil.waitForPageToLoad(driver, 90);
		ElementUtil.click(previewclose, driver);
		WaitUtil.waitForPageToLoad(driver, 20);

// Form Submission
		
		
		   By allItems = By.xpath("//td//div[contains(@class,'thumbnail-wrapper')]");

		    WaitUtil.waitForVisibility(driver, allItems, 30);
		    List<WebElement> items = driver.findElements(allItems);

		    System.out.println("🔍 Total items inside Track: " + items.size());
			
			for (int i = 1; i <= items.size(); i++) {

		        By item = By.xpath("(//td//div[contains(@class,'thumbnail-wrapper')])[" + i + "]");
		        System.out.println("➡️ Opening item " + i);

		        try {
		            ElementUtil.clickWithRetry(item, driver, 3);
		            WaitUtil.waitForPageToLoad(driver, 30);

		            Thread.sleep(2000);


		     if (ElementUtil.isDisplayed(formclose, driver)) {
	             System.out.println("📝 Form detected – filling the form...");

	             try {
	                 // 1️⃣ Fill MOBILE NUMBER
//	                 By mobileField = By.xpath("//input[contains(@placeholder,'Mobile')]");
//	                 if (ElementUtil.isDisplayed(mobileField, driver)) {
//	                     ElementUtil.type(mobileField, "9876543210", driver);
//	                     System.out.println("✔️ Mobile number filled");
//	                 }

	                 // 2️⃣ Select mandatory radio buttons
	                 // First question → pick first option
	                 By firstMandatory = By.xpath("(//input[@type='radio'])[1]");
	                 if (ElementUtil.isDisplayed(firstMandatory, driver)) {
	                     ElementUtil.click(firstMandatory, driver);
	                     System.out.println("✔️ Selected option for Q1");
	                 }

	                 // Second question → pick first option under Q2
	                 By secondMandatory = By.xpath("(//input[@type='radio'])[5]");
	                 if (ElementUtil.isDisplayed(secondMandatory, driver)) {
	                     ElementUtil.click(secondMandatory, driver);
	                     System.out.println("✔️ Selected option for Q2");
	                 }

	                 // 3️⃣ Submit the form
	                // By submitButton = By.xpath("//button[@type='submit' or contains(text(),'Submit')]");
	                 WaitUtil.waitAndClick(driver, submitButton, 20);
	                 WaitUtil.waitForPageToLoad(driver, 20);

	                 System.out.println("✔️ Form submitted successfully!");

	             } catch (Exception ef) {
	                 System.out.println("⚠️ Error while filling form: " + ef.getMessage());
	             }

	             // 4️⃣ Finally close the form popup
	             ElementUtil.clickWithRetry(formclose, driver, 2);
	             WaitUtil.waitForPageToLoad(driver, 20);
	             System.out.println("✔️ Form popup closed.");
	         }

	         // ---------------------------
	         //   🔵 ASSET PREVIEW POPUP
	         // ---------------------------
	         else if (ElementUtil.isDisplayed(previewclose, driver)) {
	             ElementUtil.clickWithRetry(previewclose, driver, 2);
	             WaitUtil.waitForPageToLoad(driver, 20);
	            
	         }
		     
		     
		     WaitUtil.waitForPageToLoad(driver, 30);
		     WaitUtil.waitAndClick(driver, breadcrumbSharedTracks, 50);

	     	        } catch (Exception ex) {
		            System.out.println("⚠️ Skipped item " + i + " – " + ex.getMessage());
		        }
		        
			}

			} 
	
	
	public void tilesActions(String fileName) {

	    WaitUtil.waitForPageToLoad(driver, 30);

	    // 🔥 NEW IMPORTANT WAIT
	    WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 30);

	    WaitUtil.waitAndClick(driver, inProgressTile, backdrop, 30);
	    WaitUtil.waitAndClick(driver, completedTile, backdrop, 30);

	    searchTrack(fileName);

	    WaitUtil.waitAndClick(driver, notViewedTile, backdrop, 30);
	    WaitUtil.waitAndClick(driver, allTile, backdrop, 30);
	}

	
	
	
	
	public void backtohome() {
		WaitUtil.waitAndClick(driver, goToHome, 30);
		
	}
			

	}
	
	
	
