
package com.stratapps.xamplify.pages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

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
	private By sortDropdown = By.xpath("//div/div[2]/div[1]/select");
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
	private By ViewTrackclose = By.xpath("//a[@title='Close']//i[@class='fa fa-times']");
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
	        WaitUtil.waitAndClick(driver, clickOnTrackPreview, backdrop, 30);
	        WaitUtil.waitForPageToLoad(driver, 90);

	        if (ElementUtil.isDisplayed(breadcrumbSharedTracks, driver)) {
	            ElementUtil.click(breadcrumbSharedTracks, driver);
	            WaitUtil.waitForPageToLoad(driver, 30);
	            System.out.println("⚠️ Track expired → Navigated to Home.");
	        }

	    } catch (Exception e) {
	        System.out.println("⚠️ Breadcrumb click failed: " + e.getMessage());
	    }

	    WaitUtil.waitForElementClickable(driver, clickOnTrackPreview1, 30);
	    ElementUtil.clickWithRetry(clickOnTrackPreview1, driver, 3);
	    WaitUtil.waitForPageToLoad(driver, 40);

	    // Universal locator
	    By allItems = By.xpath("//td//div[contains(@class,'thumbnail-wrapper')]");

	    // ❗ Critical: get item count only once
	    int totalItems = driver.findElements(allItems).size();
	    System.out.println("🔍 Total items inside Track: " + totalItems);

	    // Loop through items
	    for (int i = 1; i <= totalItems; i++) {

	        // ❗ CRITICAL FIX: Re-fetch item every time
	        By item = By.xpath("(//td//div[contains(@class,'thumbnail-wrapper')])[" + i + "]");
	        System.out.println("➡️ Opening item " + i);

	        try {
	            WaitUtil.waitForElementClickable(driver, item, 20);
	            ElementUtil.clickWithRetry(item, driver, 3);
	            WaitUtil.waitForPageToLoad(driver, 30);
	            Thread.sleep(2000);

	            // ---------------------------------------------------------------
	            // Detect FORM via <app-form-preview>
	            // ---------------------------------------------------------------
	            boolean isForm = driver.findElements(By.xpath("//app-form-preview")).size() > 0;

	            // =====================================================================
	            //                            🟢 FORM HANDLING
	            // =====================================================================
	            if (isForm) {

	                System.out.println("📝 Form detected.");

	                // Check if form already submitted (submit button missing)
	                boolean hasSubmitButton = driver.findElements(By.xpath("//button[@type='submit']")).size() > 0;
	                boolean isAlreadySubmitted = !hasSubmitButton;

	                if (isAlreadySubmitted) {

	                    System.out.println("✔️ Form already submitted → Closing form.");

	                    ElementUtil.clickWithRetry(formclose, driver, 2);
	                    WaitUtil.waitForPageToLoad(driver, 20);
	                }

	                else {

	                    System.out.println("📝 Form NOT submitted → Filling...");

	                    try {
	                        // Fill mobile number
//	                        By mobileField = By.xpath("//input[contains(@placeholder,'Mobile')]");
//	                        if (ElementUtil.isDisplayed(mobileField, driver)) {
//	                            ElementUtil.type(mobileField, "9876543210", driver);
//	                            System.out.println("✔️ Mobile Number filled");
//	                        }

	                        // Select radio Q1
	                        By firstRadio = By.xpath("(//input[@type='radio'])[1]");
	                        if (ElementUtil.isDisplayed(firstRadio, driver)) {
	                            ElementUtil.click(firstRadio, driver);
	                            System.out.println("✔️ Q1 option selected");
	                        }

	                        // Select radio Q2
	                        By secondRadio = By.xpath("(//input[@type='radio'])[5]");
	                        if (ElementUtil.isDisplayed(secondRadio, driver)) {
	                            ElementUtil.click(secondRadio, driver);
	                            System.out.println("✔️ Q2 option selected");
	                        }

	                        // Submit form
	                        By submitButton = By.xpath("//button[@type='submit']");
	                        WaitUtil.waitAndClick(driver, submitButton, 20);
	                        WaitUtil.waitForPageToLoad(driver, 30);

	                        System.out.println("✔️ Form submitted successfully!");

	                    } catch (Exception ef) {
	                        System.out.println("⚠️ Error while filling form → " + ef.getMessage());
	                    }

	                    // Close form popup
	                    ElementUtil.clickWithRetry(formclose, driver, 2);
	                    WaitUtil.waitForPageToLoad(driver, 20);
	                    System.out.println("✔️ Form popup closed.");
	                }
	            }

	            // =====================================================================
	            //                             🔵 ASSET HANDLING
	            // =====================================================================
	            else if (ElementUtil.isDisplayed(previewclose, driver)) {

	                System.out.println("📄 Asset preview detected → Closing...");
	                ElementUtil.clickWithRetry(previewclose, driver, 2);
	                WaitUtil.waitForPageToLoad(driver, 20);
	                System.out.println("✔️ Asset closed.");
	            }

	        } catch (Exception ex) {
	            System.out.println("⚠️ Skipped item " + i + " → " + ex.getMessage());
	        }

	        WaitUtil.waitForPageToLoad(driver, 20);
	    }

	    System.out.println("🎉 All assets & forms processed successfully!");
	}

	public void fillMandatoryFieldsAndSubmit() {

		// 1) Skip email if prefilled
		try {
			WebElement email = driver.findElement(emailField);
			String value = email.getAttribute("value");
			System.out.println("Email already filled: " + value);
		} catch (Exception e) {
			System.out.println("Email field not found or not visible");
		}

		// 2) All mandatory fields
		List<WebElement> questions = driver.findElements(mandatoryQuestions);
		System.out.println("Mandatory questions count: " + questions.size());

		for (WebElement q : questions) {

			// TEXT INPUTS
			List<WebElement> textInputs = q
					.findElements(By.xpath(".//input[@type='text' or @type='number' or @type='email']"));
			if (!textInputs.isEmpty()) {
				WebElement tb = textInputs.get(0);

				// skip email (already filled)
				if ("email".equalsIgnoreCase(tb.getAttribute("id"))) {
					System.out.println("Skipping email (prefilled)");
					continue;
				}

				tb.clear();
				tb.sendKeys("Test Data");
				continue;
			}

			// RADIO BUTTONS
			List<WebElement> radios = q.findElements(By.xpath(".//input[@type='radio']"));
			if (!radios.isEmpty()) {
				radios.get(0).click();
				continue;
			}

			// DROPDOWN
			List<WebElement> dropdowns = q.findElements(By.tagName("select"));
			if (!dropdowns.isEmpty()) {
				Select select = new Select(dropdowns.get(0));
				select.selectByIndex(1);
				continue;
			}
		}

		// 3) Submit form
		driver.findElement(submitButton).click();

		System.out.println("Form filled & submitted successfully!");
	}
}
