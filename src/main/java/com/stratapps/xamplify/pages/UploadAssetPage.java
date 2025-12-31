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
	private By addTagIcon = By.xpath("//div[@id='addTagModal']//button[contains(@class,'add-btn')]");
	private By tagInput = By.xpath("//div[@id='addTagModal']//input[@placeholder='Add a tag & press Enter']");
	private By tagInputField = By.xpath(
			"(//div[contains(@class,'modal-dialog') and .//h4[contains(text(),'Enter Tag Details')]] //input[@aria-label='Add a tag & press Enter'])[2]");
	private By tagSaveButton = By.xpath("//button[.//span[text()='save']]");
	private By tagSelectCheckbox = By.xpath("//label[@class='checkbox-btn']");
	private By addMoreTagsLink = By.xpath("//a[normalize-space()='+ Add more tags']");
	private By addMoreTagsSearch = By.xpath("(//input[@placeholder='Search...'])[3]");
	private By addMoreTagsSelect = By.xpath("(//label[@class='checkbox-btn'])[1]");
	private By addMoreTagsUpdate = By.xpath("//span[contains(text(),'update')]");
	private By nextButton = By.xpath("//button[normalize-space()='Next']");
	public By active_modal = By.xpath("//div[@id='addTagModal' and contains(@style,'display: block')]");
	private By tagSaveBtn = By.xpath("//button[contains(text(),'Save Tag')]");
	private By save = By.xpath("//span[@class='btn btn-primary transition'][normalize-space()='Save']");
	private By saveasDraft = By.xpath("//span[normalize-space()='Save as Draft']");
	private By successToast = By.xpath("//div[contains(@class,'toast-success')]");
	private By backdrop = By.cssSelector("div.backdrop");
	// BOX upload
	private By boxIcon = By.xpath("//img[@alt='Box']");
	private By boxEmail = By.xpath("//input[@id='login-email']");
	private By boxNextBtn = By.xpath("//button[@id='login-submit']");
	private By boxPassword = By.xpath("//input[@id='password-login']");
	private By boxLoginBtn = By.xpath("//button[@id='login-submit-password']");
	private By boxFolderDoc = By.xpath("//li[1]//div[1]//div[2]//ul[1]");
	private By boxthirdDoc_Select = By.xpath("//ul[@id=\"box-select-item-list\"]/li[1]/div/div[2]/div/input");
	private By boxfirstDoc_Select = By.xpath("//ul[@id=\"box-select-item-list\"]/li[5]/div/div[2]/div/input");
	private By boxsecDoc_Select = By.xpath("//*[@id=\"box-select-item-list\"]/li[6]/div/div[2]/div/input");
	private By boxChooseBtn = By.xpath("//button[@id='popup_button_select']//span[@class='button_val']");
	private By searchPublishInput = By.xpath("(//input[@id='sort-text'])[1]");
	private By arrowClickAsset = By.xpath("//i[@class='fa IconCustomization fa-angle-right']");
	private By partnerSelectAsset = By.xpath("//th[@class='text-center']/input");
	private By saveAndPublishButton = By.xpath("(//span[contains(text(),'Save & Publish')])");
	private By publishConfirmationMessage = By.xpath("//div[@role='alert']//h4");
	private By Gotohome = By.xpath("//img[@class='cls-pointer']");
	private By dropBoxIcon = By.xpath("//img[@alt='Dropbox']");
	private By dropBoxEmail = By.xpath("//input[@type='email']");
	private By dropBoxContinueBtn = By
			.xpath("//*[@id=\"susi-container\"]/div/div/div[2]/div/div[2]/form/div[2]/div/button");
	private By dropBoxPassword = By.xpath("//input[@type='password']");
	private By dropBoxLoginBtn = By
			.xpath("//*[@id=\"susi-container\"]/div/div/div[2]/div/div[3]/div/div/form/button/div");
	private By dropBoxFolderDoc = By.xpath("//li[1]//div[1]//div[2]//ul[1]");
	private By dropBoxthirdDoc_Select = By.xpath("//ul[@id=\"box-select-item-list\"]/li[1]/div/div[2]/div/input");
	private By dropBoxfirstDoc_Select = By.xpath("//ul[@id=\"box-select-item-list\"]/li[5]/div/div[2]/div/input");
	private By dropBoxsecDoc_Select = By.xpath("//*[@id=\"box-select-item-list\"]/li[6]/div/div[2]/div/input");
	private By dropBoxpuzzle = By.xpath("//div[@id=\"root\"]/div/div[1]/button");

	private By WebCamicon = By.xpath("//div[contains(@class,'asset_webcam')]");
	private By WebCamrecordicon = By.xpath("//button[contains(@class, 'vjs-device-button') and @title='Device']");
	private By WebCamstartrecordicon = By.xpath("//button[@title='Record']");
	private By WebCamstoprecordicon = By.xpath("//button[@title='Record']");
	private By WebCamuploadbutton = By.xpath("//button[normalize-space()='Upload']");

	private By designpdfLink = By.xpath("//span[@class='design-name'][normalize-space()='Design']");
	private By designPdfSave = By.xpath("//button[contains(.,'SAVE') or contains(@class,'Header_saveButton')]");
	private By nameField = By.xpath("//input[@placeholder='Name' and @type='text']");
	private By pdfSave = By.xpath("//button[@type='button'][normalize-space()='Save']");
	private By pdfDraft = By.xpath("//button[normalize-space()='Save as Draft']");
	private By saveAndPublishPDF = By.xpath("//button[normalize-space()='Save & Publish']");

	// ================= METHODS ================= //

	/** Navigate to Upload Asset Page */
	public void openUploadAssetSection() {
		// Wait for Content menu
		WaitUtil.waitForElementVisible(driver, contentMenu, 90);
		ElementUtil.hoverAndClick(driver.findElement(contentMenu), driver);

		// Click Design Upload
		WaitUtil.waitAndClick(driver, designUploadOption, 90);

		// Wait for page load
		WaitUtil.waitForPageToLoad(driver, 60);

		// 🔥 Extra: wait for backdrop, if present, to be gone
		try {
			WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 30);
		} catch (Exception ignored) {
		}

		// Wait for uploadAssetsLink to be clickable
		WebElement uploadBtn = WaitUtil.waitForElementClickable(driver, uploadAssetsLink, 40);

		// Scroll into view (important for hidden elements)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", uploadBtn);

		// 🔥 Final: safe click with fallback
		try {
			uploadBtn.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", uploadBtn);
		}
	}

	/** Upload Asset */
	public void uploadFile(String filePath) {
		try {
			// 🕒 Step 1: Wait and cleanup any previous overlay or modal
			WaitUtil.waitForPageToLoad(driver, 90);
			WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
			Thread.sleep(1500); // short pause to ensure prior state cleared

			// 🧩 Step 2: Ensure file exists
			File file = new File(filePath);
			if (!file.exists()) {
				throw new RuntimeException("❌ File not found at path: " + filePath);
			}

			// 🧱 Step 3: Locate a fresh <input type='file'> each time (React replaces old
			// ones)
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement uploadInput = wait.until(ExpectedConditions.presenceOfElementLocated(fileInput));

			// 🔧 Step 4: Force visibility & enable input (in case it's hidden)
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].style.display='block';" + "arguments[0].style.visibility='visible';"
							+ "arguments[0].style.opacity='1';" + "arguments[0].removeAttribute('disabled');"
							+ "arguments[0].value='';", // clear any residual value
					uploadInput);

			System.out.println("📁 Upload element ready: " + uploadInput.getAttribute("outerHTML"));
			System.out.println("📂 Uploading file: " + file.getAbsolutePath());

			// 📤 Step 5: Upload file (direct sendKeys)
			uploadInput.sendKeys(file.getAbsolutePath());

			// ⏳ Step 6: Wait for backend / progress completion
			try {
				WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 90);
				WaitUtil.waitForPageToLoad(driver, 90);
			} catch (Exception ignored) {
				// Safe ignore if backdrop never appears
			}

			// 🩵 Step 7: Handle any Oops popup (app-level error)
			handleOopsPopup();

			// 🕒 Step 8: Optional cool-off (stabilize before next upload in queue)
			Thread.sleep(1500);

			System.out.println("✅ File uploaded successfully: " + filePath);

		} catch (Exception e) {
			e.printStackTrace();
			handleOopsPopup();
			throw new RuntimeException("❌ File upload failed. Root cause: " + e.getMessage());
		}
	}

	/** Handles the "Oops! There is some technical error" popup safely */
	public void handleOopsPopup() {
		try {
			By popupMessage = By.xpath("//div[contains(text(),'Oops') or contains(.,'technical error')]");
			By okButton = By.xpath("//button[normalize-space()='OK']");

			System.out.println("⚠️ Oops popup detected — dismissing it...");
			WebElement okBtn = driver.findElement(okButton);
			ElementUtil.click(okButton, driver);
			WaitUtil.waitForInvisibilityOfElement(popupMessage, driver, 10);

			// Refresh to reset broken upload context
			driver.navigate().refresh();
			WaitUtil.waitForPageToLoad(driver, 90);
			System.out.println("🔄 Page refreshed after Oops popup");

		} catch (Exception ignored) {
			// Popup not present — continue execution
		}
	}

	/** Selects folder dropdown and declare asset type */

	public void selectDropdown(String asset_Type, String foldersearchip, String folderName) {

		WaitUtil.waitForPageToLoad(driver, 90);
		// Wait for backdrop (overlay/spinner) to disappear
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
		// Wait for the tile to be visible
		WaitUtil.waitForVisibility(driver, assetName, 60);
		ElementUtil.sendText(assetName, asset_Type + System.currentTimeMillis(), driver);
		WaitUtil.waitForPageToLoad(driver, 90);
		// Scroll the dropdown into view
		WebElement dropdownArrow = driver.findElement(folderDropdown);
		ActionUtil.scrollToElement(driver, dropdownArrow);
		WaitUtil.waitForElementClickable(driver, folderDropdown, 60);
		// Try normal click first
		try {
			dropdownArrow.click();
			WaitUtil.waitForPageToLoad(driver, 90);

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

	/**
	 * Add Tags to Asset
	 * 
	 * @throws InterruptedException
	 */

	public void addTags(String tagName) throws InterruptedException {

		WaitUtil.waitForPageToLoad(driver, 90);
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// 1️⃣ Click "Pick up Tag(s)"
		WebElement pickUpButton = WaitUtil.waitForElementClickable(driver, pickUpTag, 30);
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", pickUpButton);
		js.executeScript("arguments[0].click();", pickUpButton);

		// 2️⃣ Wait for modal
		WaitUtil.waitForElementVisible(driver, active_modal, 30);

		Thread.sleep(2000); // short pause to ensure modal fully rendered
		// 3️⃣ Click "+ Add a tag"
		WebElement addTagBtn = WaitUtil.waitForElementPresent(driver, addTagIcon, 30);
		js.executeScript("arguments[0].click();", addTagBtn);

		// 4️⃣ Enter unique tag name
		WaitUtil.waitForElementVisible(driver, tagInputField, 30);

		String uniqueTag = tagName + "_" + System.currentTimeMillis();
		ElementUtil.sendText(tagInputField, uniqueTag, driver);
		ElementUtil.sendKey(tagInputField, Keys.ENTER, driver);

		// 5️⃣ Save tag
		WebElement saveBtn = WaitUtil.waitForElementClickable(driver, tagSaveButton, 30);
		js.executeScript("arguments[0].click();", saveBtn);

		// 6️⃣ Select newly created tag
		WebElement checkbox = WaitUtil.waitForElementClickable(driver, tagSelectCheckbox, 30);
		js.executeScript("arguments[0].click();", checkbox);
		ElementUtil.click(tagSaveButton, driver);

		// 7️⃣ Add more tags
		WebElement addMoreLink = WaitUtil.waitForElementClickable(driver, addMoreTagsLink, 30);
		js.executeScript("arguments[0].click();", addMoreLink);

		WaitUtil.waitForElementVisible(driver, addMoreTagsSearch, 30);
		ElementUtil.sendText(addMoreTagsSearch, "test", driver);
		ElementUtil.sendKey(addMoreTagsSearch, Keys.ENTER, driver);

		WebElement selectMore = WaitUtil.waitForElementClickable(driver, addMoreTagsSelect, 30);
		js.executeScript("arguments[0].click();", selectMore);

		WebElement updateBtn = WaitUtil.waitForElementClickable(driver, addMoreTagsUpdate, 30);
		js.executeScript("arguments[0].click();", updateBtn);

	}

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
		// Scroll down slightly to bring the Team menu into view
//	    ActionUtil.scrollToElement(driver, driver.findElement(searchPublishInput));
		ElementUtil.sendText(searchPublishInput, "automate", driver);
		ElementUtil.sendKey(searchPublishInput, Keys.ENTER, driver);
		WaitUtil.waitForPageToLoad(driver, 60);
		WaitUtil.waitForElementVisible(driver, arrowClickAsset, 60);
		ElementUtil.clickWithRetry(arrowClickAsset, driver, 3); // Use robust click
		// WaitUtil.waitAndClick(driver, arrowClickTrack, 70);

		WaitUtil.waitAndClick(driver, partnerSelectAsset, 70);
		ElementUtil.click(saveAndPublishButton, driver);

	}

	public String getPublishConfirmationMessage() {
		return WaitUtil.waitForElementVisible(driver, publishConfirmationMessage, 60).getText();
	}

	// ================= BOX Upload Flow ================= //

	public void uploadFromBox(String email, String password) {
		try {
			WaitUtil.waitForPageToLoad(driver, 90);
			WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
			// Click the Box icon and switch to new Box login window
			WaitUtil.waitAndClick(driver, boxIcon, 60);
			switchToNewWindow();

			// Perform Box login
			WaitUtil.waitForElementVisible(driver, boxEmail, 60);
			ElementUtil.sendText(boxEmail, email, driver);
			WaitUtil.waitAndClick(driver, boxNextBtn, 60);

			WaitUtil.waitForElementVisible(driver, boxPassword, 60);
			ElementUtil.sendText(boxPassword, password, driver);
			WaitUtil.waitAndClick(driver, boxLoginBtn, 60);
			WaitUtil.waitAndClick(driver, boxfirstDoc_Select, 60);
			WaitUtil.waitAndClick(driver, boxsecDoc_Select, 60);
			// Select first document and confirm upload
			WaitUtil.waitAndClick(driver, boxFolderDoc, 60);
			WaitUtil.waitAndClick(driver, boxthirdDoc_Select, 60);

			WaitUtil.waitAndClick(driver, boxChooseBtn, 60);

			// ✅ Switch back to main window
			switchToMainWindow();

			// ✅ Wait for upload to finish and overlay to disappear
			WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);

			// ✅ Ensure Description section is visible and ready
			WaitUtil.waitForElementVisible(driver, searchPublishInput, 60);
			System.out.println("✅ Switched back to main window successfully after Box upload.");

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("❌ Error during Box upload: " + e.getMessage());
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

	public void backToHome() {
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

	// ==================== Design PDF ====================//

	public void openDesignPDFSection() throws InterruptedException {
		try {
			// 🔹 Step 1: Ensure previous overlay/backdrop gone
			WaitUtil.waitForPageToLoad(driver, 90);
			WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
			Thread.sleep(1000);

			// 🔹 Step 2: Refresh DOM to avoid stale references after upload
			driver.navigate().refresh();
			WaitUtil.waitForPageToLoad(driver, 90);
			WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);

			// 🔹 Step 3: Re-locate and click Content Menu
			WaitUtil.waitForElementVisible(driver, contentMenu, 60);
			WebElement content = driver.findElement(contentMenu);
			ActionUtil.hover(driver, contentMenu);
			WaitUtil.waitAndClick(driver, contentMenu, 30);
			WaitUtil.waitForPageToLoad(driver, 60);

			// 🔹 Step 4: Click Design Upload and then Design PDF
			WaitUtil.waitAndClick(driver, designUploadOption, 40);
			WaitUtil.waitAndClick(driver, designpdfLink, 40);
			WaitUtil.waitForPageToLoad(driver, 90);
			WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
			Thread.sleep(2000); // Let the iframe load properly

			// 🔹 Step 5: Switch to PDF iframe safely
			List<WebElement> frames = driver.findElements(By.tagName("iframe"));
			if (!frames.isEmpty()) {
				driver.switchTo().frame(frames.get(0));
				System.out.println("🧩 Switched into Design PDF iframe");
			} else {
				throw new RuntimeException("❌ No iframe found for PDF editor.");
			}

			// 🔹 Step 6: Wait and click SAVE button with retry
			WaitUtil.waitForElementClickable(driver, designPdfSave, 60);
			clickWithStaleRetry(designPdfSave, driver, 3);
			System.out.println("💾 Clicked SAVE inside PDF editor");

			// 🔹 Step 7: Switch back to main content
			driver.switchTo().defaultContent();
			WaitUtil.waitForPageToLoad(driver, 90);
			WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);

			// 🔹 Step 8: Enter asset name safely
			WaitUtil.waitForVisibility(driver, nameField, 40);
			String assetName = "Automation_Test_PDFDraft_" + System.currentTimeMillis();
			ElementUtil.sendText(nameField, assetName, driver);
			System.out.println("📝 Entered PDF name: " + assetName);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("❌ Failed to open Design PDF section: " + e.getMessage());
		}
	}

	// =========================
	// SAVE ACTIONS
	// =========================
	public void fillAssetDetailsAndSave() {
		try {
			WaitUtil.waitForVisibility(driver, pdfSave, 60);
			ActionUtil.hoverAndClick(driver, pdfSave);
			WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
			WaitUtil.waitForPageToLoad(driver, 60);
			System.out.println("✅ PDF asset saved successfully.");

		} catch (Exception e) {
			System.err.println("❌ Failed during SAVE action: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	public void fillAssetDetailsAndSaveDraft() {
		try {
			WaitUtil.waitForVisibility(driver, pdfDraft, 60);
			ActionUtil.hoverAndClick(driver, pdfDraft);
			WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
			WaitUtil.waitForPageToLoad(driver, 60);
			System.out.println("✅ PDF asset saved as draft successfully.");

		} catch (Exception e) {
			System.err.println("❌ Failed during SAVE AS DRAFT action: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	public void fillAssetDetailsAndSaveAndPublish() {
		try {
			WaitUtil.waitForVisibility(driver, saveAndPublishPDF, 60);
			ActionUtil.hoverAndClick(driver, saveAndPublishPDF);
			WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
			WaitUtil.waitForPageToLoad(driver, 60);
			System.out.println("✅ PDF asset saved and published successfully.");

		} catch (Exception e) {
			System.err.println("❌ Failed during SAVE & PUBLISH action: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	// =========================
	// PARTNER PDF SELECTION FLOW
	// =========================
	public void selectPartnerPDF() {
		try {
			WaitUtil.waitForPageToLoad(driver, 60);
			WaitUtil.waitForVisibility(driver, searchPublishInput, 60);

			ElementUtil.sendText(searchPublishInput, "automate", driver);
			ElementUtil.sendKey(searchPublishInput, Keys.ENTER, driver);

			WaitUtil.waitForPageToLoad(driver, 60);
			WaitUtil.waitForVisibility(driver, arrowClickAsset, 60);

			// 🔹 Click arrow with retry
			ElementUtil.clickWithRetry(arrowClickAsset, driver, 3);

			WaitUtil.waitAndClick(driver, partnerSelectAsset, 60);

			// 🔹 Final publish click
			ActionUtil.hoverAndClick(driver, saveAndPublishPDF);
			WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
			WaitUtil.waitForPageToLoad(driver, 60);

			System.out.println("✅ Partner PDF selected and published successfully.");
		} catch (Exception e) {
			System.err.println("❌ Failed during partner PDF selection: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	// =========================
	// RETRY LOGIC FOR STALE ELEMENTS
	// =========================
	private void clickWithStaleRetry(By locator, WebDriver driver, int maxRetries) throws InterruptedException {
		int attempts = 0;
		while (attempts < maxRetries) {
			try {
				WaitUtil.waitForElementClickable(driver, locator, 30);
				WebElement element = driver.findElement(locator);
				ActionUtil.hoverAndClick(driver, locator);
				return;
			} catch (StaleElementReferenceException e) {
				attempts++;
				System.out.println("Retrying click due to stale element (attempt " + attempts + ")");
				Thread.sleep(1000);
			} catch (ElementClickInterceptedException e) {
				attempts++;
				System.out.println("Retrying click due to intercepted element (attempt " + attempts + ")");
				Thread.sleep(1000);
			} catch (Exception e) {
				if (attempts == maxRetries - 1) {
					throw new RuntimeException("Failed to click element after " + maxRetries + " retries: " + locator,
							e);
				}
			}
		}
	}

	// ================WebCamp Upload Flow ================= //
	// public class WebcamUpload {

	public void uploadFromWebcam() {
		WebDriver localDriver = null;

		try {
			// Step 1: Set Chrome Options for auto-allow webcam and mic permissions
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			Map<String, Object> contentSettings = new HashMap<>();

			contentSettings.put("media_stream_camera", 1); // Auto-allow camera
			contentSettings.put("media_stream_mic", 1); // Auto-allow microphone
			prefs.put("profile.default_content_setting_values", contentSettings);
			options.setExperimentalOption("prefs", prefs);

			// Automatically dismiss permission dialogs
			options.addArguments("--use-fake-ui-for-media-stream");
			options.addArguments("--use-fake-device-for-media-stream");
			options.addArguments("disable-infobars"); // Disable popups like "Chrome is being controlled by automated
														// test software"

			// Step 2: Launch Chrome with these options
			localDriver = new ChromeDriver(options);
			localDriver.manage().window().maximize();
			localDriver.get("https://xamplify.co/home/dam/upload");

			// Wait for the WebCam icon to be visible and clickable
			WebDriverWait wait = new WebDriverWait(localDriver, Duration.ofSeconds(60));
			WebElement webCamIcon = wait.until(ExpectedConditions.elementToBeClickable(By.id("WebCamIconId")));
			// Update with actual Webcam icon locator
			webCamIcon.click();

			// Step 3: Handle iframe (if applicable) and interaction with webcam permissions
			// Check if WebCam modal or permissions are inside an iframe, if so, switch to
			// it.
			try {
				localDriver.switchTo().frame("iframe_id"); // Update with the iframe ID, if needed
			} catch (NoSuchFrameException e) {
				// If no iframe, continue with normal interaction
			}

			// Step 4: Click the record icon
			WebElement recordIcon = wait.until(ExpectedConditions.elementToBeClickable(By.id("WebCamRecordIconId"))); // Update
																														// with
																														// the
																														// correct
																														// locator
			recordIcon.click();

			// Step 5: Start recording (clicking start recording button)
			WebElement startRecordButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.id("WebCamStartRecordIconId"))); // Update with
																										// the correct
																										// locator
			startRecordButton.click();

			// Step 6: Wait for a few seconds to record
			Thread.sleep(3000); // Adjust as necessary

			// Step 7: Stop the recording
			WebElement stopRecordButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.id("WebCamStopRecordIconId"))); // Update with the
																										// correct
																										// locator
			stopRecordButton.click();

			// Step 8: Upload the recorded video
			WebElement uploadButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.id("WebCamUploadButtonId"))); // Update with the
																									// correct locator
			uploadButton.click();

			System.out.println("✅ Webcam recording uploaded successfully.");

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("❌ Error during WebCam upload: " + e.getMessage());
		} finally {
			if (localDriver != null) {
				localDriver.quit();
			}
		}
	}

//================= DropBOX Upload Flow ================= //
	public void uploadFromDropBox(String email, String password) {

		try {

//			// Click the DropBox icon and switch to new DropBox login window

			WaitUtil.waitAndClick(driver, dropBoxIcon, 60);
			switchToNewWindow();
			// Perform DropBox login
			WaitUtil.waitForElementVisible(driver, dropBoxEmail, 60);
			ElementUtil.sendText(dropBoxEmail, email, driver);
			WaitUtil.waitAndClick(driver, dropBoxContinueBtn, 60);
			WaitUtil.waitForElementVisible(driver, dropBoxPassword, 60);
			ElementUtil.sendText(dropBoxPassword, password, driver);
			WaitUtil.waitAndClick(driver, dropBoxLoginBtn, 60);

		}

		catch (Exception e) {
			e.printStackTrace();
			System.err.println("❌ Error during DropBox upload: " + e.getMessage());
		}

	}
}
