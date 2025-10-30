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
	private By assetName = By.xpath("(//input[@placeholder=\"Enter Name\"])[1]");
	private By descriptionFrame = By.xpath("//iframe[contains(@title, 'Rich Text Editor')]");
	private By descriptionInput = By.xpath("//body[@contenteditable='true']");
	private By folderDropdown = By.xpath("//div[contains(@class,'dropdown')]//input[contains(@type,'text')]");
	private By folderSearchInput = By.xpath("//input[@id='myInput']");
	private By folder_name = By.xpath("//div[@title='xamplify2024-Default-Folder']");
	private By pickUpTag = By.xpath("//button[@class='btn btn-primary add-btn']");
	private By addTagIcon = By.xpath("//button[normalize-space()='Add a tag']");
	private By tagInput = By.xpath("(//input[@placeholder='Add a tag & press Enter'])[2]");
	private By tagInputField = By.xpath(
			"(//div[contains(@class,'modal-dialog') and .//h4[contains(text(),'Enter Tag Details')]] //input[@aria-label='Add a tag & press Enter'])[2]");
	private By tagSaveButton = By.xpath("//span[contains(text(),'save')]");
	private By tagSelectCheckbox = By.xpath("//label[@class='checkbox-btn']");
	private By addMoreTagsLink = By.xpath("//a[normalize-space()='+ Add more tags']");
	private By addMoreTagsSearch = By.xpath("(//input[@placeholder='Search...'])[3]");
	private By addMoreTagsSelect = By.xpath("(//label[@class='checkbox-btn'])[1]");
	private By addMoreTagsUpdate = By.xpath("//span[contains(text(),'update')]");
	private By nextButton = By.xpath("//button[normalize-space()='Next']");
	private By tagSaveBtn = By.xpath("//button[contains(text(),'Save Tag')]");
	private By save = By.xpath("//span[@class='btn btn-primary transition'][normalize-space()='Save']");
	private By saveasDraft=By.xpath("//span[normalize-space()='Save as Draft']");
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
	private By searchPublishInput = By.xpath("(//input[@id='sort-text'])[1]");
	private By arrowClickAsset = By.xpath("//i[@class='fa IconCustomization fa-angle-right']");
	private By partnerSelectAsset = By.xpath("//th[@class='text-center']/input");
	private By saveAndPublishButton = By.xpath("(//span[contains(text(),'Save & Publish')])");
	private By publishConfirmationMessage = By.xpath("//div[@role='alert']//h4");
    private By Gotohome =By.xpath("//img[@class='cls-pointer']");

	// ================= METHODS ================= //

	/** Navigate to Upload Asset Page */
	public void openUploadAssetSection() {
		WaitUtil.waitForElementVisible(driver, contentMenu, 60);
		ElementUtil.hoverAndClick(driver.findElement(contentMenu), driver);
		WaitUtil.waitAndClick(driver, designUploadOption, 60);
		WaitUtil.waitAndClick(driver, uploadAssetsLink, 60);
	}

	
	/** Upload Asset */
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

	
	/** Selects folder dropdown and declare asset type */
	
	public void selectDropdown(String asset_Type, String foldersearchip, String folderName) {

		WaitUtil.waitForPageToLoad(driver, 70);
		// Wait for backdrop (overlay/spinner) to disappear
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
		// Wait for the tile to be visible
		WaitUtil.waitForVisibility(driver, assetName, 60);
		ElementUtil.sendText(assetName, asset_Type + System.currentTimeMillis(), driver);

		// Scroll the dropdown into view
		WebElement dropdownArrow = driver.findElement(folderDropdown);
		ActionUtil.scrollToElement(driver, dropdownArrow);
		WaitUtil.waitForElementClickable(driver, folderDropdown, 60);
		// Try normal click first
		try {
			dropdownArrow.click();

		} catch (Exception e) {
			// If intercepted, try JS click
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdownArrow);
		}

		WaitUtil.waitForElementVisible(driver, folderSearchInput, 60);
		WebElement searchInput = driver.findElement(folderSearchInput);
		searchInput.sendKeys(foldersearchip);
		searchInput.sendKeys(Keys.ENTER);
		WaitUtil.waitForElementVisible(driver, folder_name, 60);
		ActionUtil.hover(driver, folder_name);
		WaitUtil.waitForElementClickable(driver, folder_name, 10);
		ElementUtil.click(folder_name, driver);
		WaitUtil.waitForPageToLoad(driver, 60);

	}

	/** Add Tags to Asset */
	public void addTags(String tagName) {
		WaitUtil.waitForPageToLoad(driver, 90);
		// ✅ Step 1: Wait for and click on 'Pick up Tag(s)'
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
		WaitUtil.waitForElementVisible(driver, pickUpTag, 30);
		WaitUtil.waitForElementClickable(driver, pickUpTag, 30);
		WebElement pickUpButton = driver.findElement(pickUpTag);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", pickUpButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", pickUpButton);

		System.out.println("✅ Clicked on 'Pick up Tag(s)' successfully");

		// ✅ Step 2: Click on + icon to add new tag
		WaitUtil.waitAndClick(driver, addTagIcon, 30);

		// ✅ Step 3: Enter new tag name
		WaitUtil.waitForElementVisible(driver, tagInputField, 30);
		String uniqueTag = tagName + "_" + System.currentTimeMillis();
		ElementUtil.sendText(tagInputField, uniqueTag, driver);
		ElementUtil.sendKey(tagInputField, Keys.ENTER, driver);

		// ✅ Step 4: Save and select tag
		WaitUtil.waitAndClick(driver, tagSaveButton, 30);
		WaitUtil.waitAndClick(driver, tagSelectCheckbox, 30);
		ElementUtil.click(tagSaveButton, driver);

		// ✅ Step 5: Add more tags
		WaitUtil.waitForElementVisible(driver, addMoreTagsLink, 30);
		ElementUtil.click(addMoreTagsLink, driver);
		WaitUtil.waitForElementVisible(driver, addMoreTagsSearch, 30);
		ElementUtil.sendText(addMoreTagsSearch, "test", driver);
		ElementUtil.sendKey(addMoreTagsSearch, Keys.ENTER, driver);
		WaitUtil.waitAndClick(driver, addMoreTagsSelect, 30);
		WaitUtil.waitAndClick(driver, addMoreTagsUpdate, 30);
		WaitUtil.waitForPageToLoad(driver, 60);
		System.out.println("✅ Tags added successfully.");
	}

	/** Enter Asset Description */
//	public void enterDescription(String text) {
//		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
//		WaitUtil.waitForElementVisible(driver, descriptionFrame, 60);
//		driver.switchTo().frame(driver.findElement(descriptionFrame));
//		WebElement descBox = driver.findElement(descriptionInput);
//		descBox.clear();
//		descBox.sendKeys(text);
//		driver.switchTo().defaultContent();
//
//	}

	
	
	/** Enters description text inside the asset description editor. */
	public void enterDescription(String text) {
	    try {
	        // Wait for any overlay/backdrop to disappeara
	        WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);

	        // Wait until the description iframe is present and visible
	        WaitUtil.waitForPresence(driver, descriptionFrame, 60);
	        WaitUtil.waitForElementVisible(driver, descriptionFrame, 60);

	        // Switch to the description iframe safely
	        driver.switchTo().frame(driver.findElement(descriptionFrame));

	        // Wait for description input box to appear inside the iframe
	        WaitUtil.waitForElementVisible(driver, descriptionInput, 30);
	        WebElement descBox = driver.findElement(descriptionInput);

	        // Clear and enter description text
	        descBox.clear();
	        descBox.sendKeys(text);

	        // Switch back to main DOM after entering text
	        driver.switchTo().defaultContent();

	        // Wait for the page to stabilize before proceeding
	        WaitUtil.waitForPageToLoad(driver, 10);

	       // logger.info("Description entered successfully: " + text);
	    } catch (Exception e) {
	       // logger.error("Failed to enter description: " + e.getMessage());
	        throw e;
	    }
	}

	/** Save Asset */
	public void saveAsset() {
		// Wait for page stability after frame switch
		WaitUtil.waitForPageToLoad(driver, 20);
		// Ensure Save button is visible and clickable
		WebElement saveBtn = driver.findElement(save);
		ActionUtil.scrollToElement(driver, saveBtn);
		WaitUtil.waitForElementClickable(driver, save, 30);

		try {
			ElementUtil.click(save, driver);
			System.out.println("✅ Save button clicked successfully.");
		} catch (Exception e) {
			// fallback with JS click if normal click fails
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveBtn);
			System.out.println("⚠️ Normal click failed, performed JS click on Save button.");
		}
	}
	
	
	/** Save As draft Asset */
	public void saveAsDraftAsset() {
		// Wait for page stability after frame switch
		WaitUtil.waitForPageToLoad(driver, 20);
		// Ensure Save button is visible and clickable
		WebElement savedraftBtn = driver.findElement(saveasDraft);
		ActionUtil.scrollToElement(driver, savedraftBtn);
		WaitUtil.waitForElementClickable(driver, saveasDraft, 30);

		try {
			ElementUtil.click(saveasDraft, driver);
			System.out.println("✅ SaveasDraft button clicked successfully.");
		} catch (Exception e) {
			// fallback with JS click if normal click fails
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", savedraftBtn);
			System.out.println("⚠️ Normal click failed, performed JS click on SaveasDraft button.");
		}
	}
	
	
	
	public void selectPartner() {
		
		
		WaitUtil.waitForPageToLoad(driver, 60);

		ElementUtil.sendText(searchPublishInput, "automate", driver);
		ElementUtil.sendKey(searchPublishInput, Keys.ENTER, driver);
		WaitUtil.waitForPageToLoad(driver, 60);
		WaitUtil.waitForElementVisible(driver, arrowClickAsset, 60);
		ElementUtil.clickWithRetry(arrowClickAsset, driver, 3); // Use robust click
		//WaitUtil.waitAndClick(driver, arrowClickTrack, 70);

		WaitUtil.waitAndClick(driver, partnerSelectAsset, 70);
		ElementUtil.click(saveAndPublishButton, driver);
	}
	
	
	
	public String getPublishConfirmationMessage() {
		return WaitUtil.waitForElementVisible(driver, publishConfirmationMessage, 60).getText();
	}	
	 public void backToHome() {
	        WaitUtil.waitAndClick(driver, Gotohome, 60);
	    }

	 


	// ================= BOX Upload Flow ================= //

	public void uploadFromBox(String email, String password) {
		try {
			//WaitUtil.waitAndClick(driver, browseBtn, 60);
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

	public void switchToNewWindow() {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
	}

	private void switchToMainWindow() {
		driver.switchTo().window(driver.getWindowHandles().iterator().next());
	}
}
