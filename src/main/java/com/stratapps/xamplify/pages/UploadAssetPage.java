package com.stratapps.xamplify.pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;
import com.stratapps.xamplify.utils.ActionUtil;

public class UploadAssetPage {

	private WebDriver driver;

	public UploadAssetPage(WebDriver driver) {
		this.driver = driver;
	}

	// ================= LOCATORS ================= //

	private By contentMenu = By.xpath("//span[contains(text(),'Content')]");
	private By designUploadOption = By.xpath("//a[contains(text(),'Design / Upload')]");
	private By uploadAssetsLink = By.xpath("//span[normalize-space()='Upload']");
	private By fileInput = By.xpath("//input[@type='file']");
	private By browseBtn = By.xpath("//button[normalize-space()='Browse Files']");
	private By assetName = By.id("assetName");
	private By descriptionFrame = By.xpath("//iframe[@title='Rich Text Editor, editor1']");
	private By descriptionInput = By.xpath("//body[@contenteditable='true']");
	private By folderDropdown = By.xpath("//div[@class='xamplify-dropdown']");
	private By folderSelectOption_search = By.xpath("//input[@id='myInput']");
	private By pickUpTag = By.xpath("//button[@class='btn btn-primary add-btn']");
	private By addTagIcon = By.xpath("//button[normalize-space()='Add a tag']");
	private By tagInput = By.xpath("(//input[@placeholder='Add a tag & press Enter'])[2]");
	private By tagInputField = By.xpath("(//div[contains(@class,'modal-dialog') and .//h4[contains(text(),'Enter Tag Details')]] //input[@aria-label='Add a tag & press Enter'])[2]");
	private By tagSaveButton = By.xpath("//span[contains(text(),'save')]");
	private By tagSelectCheckbox = By.xpath("//label[@class='checkbox-btn']");
	private By addMoreTagsLink = By.xpath("//div[contains(@class,'row form-group mTags')]/div/a");
	private By addMoreTagsSearch = By.xpath("(//input[@placeholder='Search...'])[2]");
	private By addMoreTagsSelect = By.xpath("(//label[@class='checkbox-btn'])[1]");
	private By addMoreTagsUpdate = By.xpath("//span[contains(text(),'update')]");
	private By nextButton = By.xpath("//button[normalize-space()='Next']");
	private By tagSaveBtn = By.xpath("//button[contains(text(),'Save Tag')]");
	private By save = By.xpath("//span[@class='btn btn-primary transition'][normalize-space()='Save']");
	private By successToast = By.xpath("//div[contains(@class,'toast-success')]");
	private By backdrop = By.cssSelector("div.backdrop");

	// BOX upload
	private By boxIcon = By.xpath("//img[@alt='Box']");
	private By boxEmail = By.xpath("//input[@type='email']");
	private By boxNextBtn = By.xpath("//input[@type='submit']");
	private By boxPassword = By.xpath("//input[@type='password']");
	private By boxLoginBtn = By.xpath("//button[@type='submit']");
	private By boxFirstDoc = By.xpath("(//span[contains(@class,'ItemName')])[1]");
	private By boxChooseBtn = By.xpath("//button[contains(text(),'Choose')]");

	// ================= METHODS ================= //

	/** Navigate to Upload Asset Page */
	public void openUploadAssetSection() {
		WaitUtil.waitForElementVisible(driver, contentMenu, 60);
		ElementUtil.hoverAndClick(driver.findElement(contentMenu), driver);
		WaitUtil.waitAndClick(driver, designUploadOption, 60);
		WaitUtil.waitAndClick(driver, uploadAssetsLink, 60);
		// WaitUtil.waitForElementVisible(driver, browseBtn, 60);
		// ElementUtil.click(browseBtn, driver);
	}

	public void uploadFile(String filePath) {
		try {
			// Ensure the file actually exists before uploading
			File file = new File(filePath);
			if (!file.exists()) {
				throw new RuntimeException("❌ File not found at path: " + filePath);
			}

			// Locate the <input type="file"> element directly
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement uploadInput = wait.until(ExpectedConditions.presenceOfElementLocated(fileInput));

			// Avoid clicking any button that opens the native file picker
			// Force visibility and enable the file input if it is hidden
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].style.display='block'; " + "arguments[0].style.visibility='visible'; "
							+ "arguments[0].style.opacity='1'; " + "arguments[0].removeAttribute('disabled');",
					uploadInput);

			// Log debug info
			System.out.println("Uploading file via input: " + uploadInput.getAttribute("outerHTML"));
			System.out.println("Using file path: " + filePath);

			// Send file path directly to input (bypasses native dialog)
			uploadInput.sendKeys(file.getAbsolutePath());

			// Optional wait for upload completion if a loading overlay/backdrop appears
			try {
				WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
			} catch (Exception ignored) {
				// In case the backdrop never appears — continue without failure
			}

			System.out.println("✅ File uploaded successfully! Path: " + filePath);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("❌ File upload failed. Check locator or file path! " + e.getMessage());
		}
	}



	/** Enter Asset Description */
	public void enterDescription(String text) {
		WaitUtil.waitForElementVisible(driver, descriptionFrame, 60);
		driver.switchTo().frame(driver.findElement(descriptionFrame));
		WebElement descBox = driver.findElement(descriptionInput);
		descBox.clear();
		descBox.sendKeys(text);
		driver.switchTo().defaultContent();
	}

	/** Upload File directly using sendKeys (No Robot) */

	/** Select Folder from Dropdown */
	public void selectFolder(String folderName) {
		
			// Step 1: Open the folder dropdown
			WaitUtil.waitAndClick(driver, folderDropdown, 60);

			// Step 2: Click on the search box inside the dropdown
			WaitUtil.waitAndClick(driver, folderSelectOption_search, 60);

			// Step 3: Type the folder name into the search field
			WebElement searchInput = driver.findElement(folderSelectOption_search);
			searchInput.clear();
			searchInput.sendKeys(folderName);

			// Step 4: Press ENTER to confirm or select the folder
			searchInput.sendKeys(Keys.ENTER);

			System.out.println("✅ Folder '" + folderName + "' selected successfully!");
		
	}

	/** Add Tag to Asset */	
		
		public void addTags(String tagName) {

			WaitUtil.waitAndClick(driver, pickUpTag, 60);
			WaitUtil.waitAndClick(driver, addTagIcon, 90);
			WaitUtil.waitForPageToLoad(driver, 70);
			WaitUtil.waitForElementVisible(driver, tagInputField, 90);
			ElementUtil.sendText(tagInputField, tagName + "_" + System.currentTimeMillis(), driver);
			ElementUtil.sendKey(tagInputField, Keys.ENTER, driver);
			WaitUtil.waitAndClick(driver, tagSaveButton, 60);
			WaitUtil.waitAndClick(driver, tagSelectCheckbox, 60);
			ElementUtil.click(tagSaveButton, driver);

			WaitUtil.waitForElementVisible(driver, addMoreTagsLink, 60);
			ElementUtil.click(addMoreTagsLink, driver);
			WaitUtil.waitForElementVisible(driver, addMoreTagsSearch, 60);
			ElementUtil.sendText(addMoreTagsSearch, "test", driver);
			ElementUtil.sendKey(addMoreTagsSearch, Keys.ENTER, driver);
			WaitUtil.waitAndClick(driver, addMoreTagsSelect, 60);
			WaitUtil.waitAndClick(driver, addMoreTagsUpdate, 60);

			//ElementUtil.click(nextButton, driver);
		}
		
	
	/** Save and Publish Asset */
	public void saveAndPublishAsset() {
		WaitUtil.waitAndClick(driver, save, 60);
	}

	/** Validate success message */
	public String getUploadSuccessMessage() {
		WaitUtil.waitForElementVisible(driver, successToast, 60);
		return driver.findElement(successToast).getText().trim();
	}

	// ================= BOX Upload Flow ================= //

	public void uploadFromBox(String email, String password) {
		try {
			WaitUtil.waitAndClick(driver, browseBtn, 60);
			WaitUtil.waitAndClick(driver, boxIcon, 60);

			switchToNewWindow();

			WaitUtil.waitForElementVisible(driver, boxEmail, 60);
			ElementUtil.sendText(boxEmail, email, driver);
			WaitUtil.waitAndClick(driver, boxNextBtn, 60);

			WaitUtil.waitForElementVisible(driver, boxPassword, 60);
			ElementUtil.sendText(boxPassword, password, driver);
			WaitUtil.waitAndClick(driver, boxLoginBtn, 60);

			WaitUtil.waitAndClick(driver, boxFirstDoc, 60);
			WaitUtil.waitAndClick(driver, boxChooseBtn, 60);

			switchToMainWindow();
			WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ================= UTILITIES ================= //

	private void switchToNewWindow() {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
	}

	private void switchToMainWindow() {
		driver.switchTo().window(driver.getWindowHandles().iterator().next());
	}
}
