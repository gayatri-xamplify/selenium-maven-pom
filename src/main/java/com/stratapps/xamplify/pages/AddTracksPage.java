package com.stratapps.xamplify.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.stratapps.xamplify.utils.ActionUtil;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;
import com.stratapps.xamplify.utils.DropdownUtil;

public class AddTracksPage {
	private WebDriver driver;

	public AddTracksPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By contentMenu = By.xpath("//span[normalize-space()='Content']");
	private By addTracksButton = By.xpath("//span[normalize-space()='Add Tracks']");
	private By titleTextField = By.xpath("//input[contains(@placeholder,'Add title')]");
	private By folderDropdown = By.xpath("//div[contains(@class,'dropdown')]//input[contains(@type,'text')]");
	private By folderSearchField = By.xpath("//input[@id='myInput']");
	private By folderSelectOption = By.xpath("//div[contains(text(),'xamplify2024-Default-Folder')]");

	private By tagPlusIcon = By.xpath("//div[@class='row form-group mTags']/div/button");
	private By addTagButton = By.xpath("//button[@data-original-title='Add a Tag']");
	private By tagInputField = By.xpath("(//input[@aria-label='Add a tag & press Enter'])[2]");
	private By tagSaveButton = By.xpath("//span[contains(text(),'save')]");
	private By tagSelectCheckbox = By.xpath("//label[@class='checkbox-btn']");
	private By addMoreTagsLink = By.xpath("//div[contains(@class,'row form-group mTags')]/div/a");
	private By addMoreTagsSearch = By.xpath("(//input[@placeholder='Search...'])[2]");
	private By addMoreTagsSelect = By.xpath("(//label[@class='checkbox-btn'])[1]");
	private By addMoreTagsUpdate = By.xpath("//span[contains(text(),'update')]");
	private By nextButton = By.xpath("//button[normalize-space()='Next']");

	private By addMediaButton = By.xpath("(//span[contains(text(),'Add')])[2]");
	private By firstAssetClick = By.xpath("(//input[@class='radioButton_shadow'])[1]");
	private By displayTextField = By.xpath("//div[@id='media-link-title']//input");
	private By confirmButton = By.xpath("//span[normalize-space()='Confirm']");
	private By closePopupMedia = By.xpath("//div[@id='media-asset-list']//i[@class='fa fa-times']");

	private By addFormButton = By.xpath("(//span[contains(text(),'Add')])[3]");
	private By firstFormClick = By.xpath("(//input[@class='radioButton_shadow'])[1]");
	private By formPreview = By.xpath("(//i[@class='fa fa-eye IconCustomization'])[1]");
	private By formPreviewClose = By.xpath("//div[@id='form-preview-modal']//i[@class='fa fa-times']");
	private By closePopupForm = By.xpath("//div[@id='formsList']//i[@class='fa fa-times']");

	private By descriptionField = By.xpath("//body[@contenteditable='true']");

	private By searchAssetBox = By.xpath("(//input[@placeholder='Search...'])[2]");
	private By searchIcon = By.xpath("//i[@class='fa fa-search cesf-xamp']");
	private By clearSearchIcon = By
			.xpath("//div[@id='icon']//button[@class='glyphicon glyphicon-remove search-box-item-clear']");
	private By firstAssetSelect = By.xpath("(//span[@class='select-box-asset']/label)[1]");
	private By assetTypeDropdown = By.xpath("(//*[@id='left']/select)[2]");

	private By selectQuizBtn = By.xpath("//button//span[contains(text(),'Select')]");
	private By quizSortBy = By.xpath("(//*[@id='left']/select)[4]");
	private By quizSearchBox = By.xpath("(//input[@id='search-text'])[2]");
	private By firstQuizClick = By
			.xpath("//*[@id='quiz-list']/div/div/div[2]/div[1]/div/div/div[2]/table/tbody/tr/td[1]/input");
	private By previewQuiz = By.xpath("(//tbody/tr[1]/td[4]/div/a/i)[2]");
	private By closeQuizPopup1 = By.xpath("//a[@id='bottom-right']");
	private By closeQuizPopup = By
			.xpath("//div[@id='quiz-list']//span[@class='btn Btn-Gray'][normalize-space()='Close']");

	private By orderAssetsButton = By.xpath("//span[contains(text(),'Order')]");
	private By previewOrderAsset = By
			.xpath("(//*[@id='actions-row ']/div/a[1]/i[@class='fa fa-eye IconCustomization'])[1]");
	private By closeOrderAssetPreview = By.xpath("//button[@class='btn Btn-Gray']");
	private By removeOrderAsset = By.xpath("(//*[@id='actions-row ']/div/a[2]/i[@class='fa fa-times remove-button IconCustomization'])[1]");
	private By followSequenceToggle = By.xpath("//span[@class='labels']");
	private By  removeAsset = By.xpath("//button[contains(text(), 'Yes, Remove')]");
	private By closeOrderAssetSection = By.xpath("//div[@id='order-assets']//span[contains(text(),'Close')]");

	private By searchPublishInput = By.xpath("(//input[@id='sort-text'])[1]");
	private By arrowClickTrack = By.xpath("//i[@class='fa IconCustomization fa-angle-right']");
	private By partnerSelectTrack = By.xpath("//th[@class='text-center']/input");
	private By saveAndPublishButton = By.xpath("(//span[contains(text(),'Save & Publish')])");
	private By refreshButton = By.xpath("//i[@class='fa fa-refresh']");
	private By publishConfirmationMessage = By.xpath("//div[@role='alert']//h4");

	private By backdrop = By.cssSelector("div.backdrop");

	public void openContentMenu() {
		WaitUtil.waitForElementVisible(driver, contentMenu, 60);
		ElementUtil.click(contentMenu, driver);
	}

	public void clickAddTracks() {
		WaitUtil.waitAndClick(driver, addTracksButton, 60);
	}

	public void enterTrackTitle(String title) {
		WaitUtil.waitForPageToLoad(driver, 70);
		// Wait for backdrop (overlay/spinner) to disappear
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
		// Wait for the tile to be visible
		WaitUtil.waitForVisibility(driver, titleTextField, 60);
		ElementUtil.sendText(titleTextField, title + System.currentTimeMillis(), driver);
	}

	public void selectFolder(String folderName) {
		WaitUtil.waitForPageToLoad(driver, 70);
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
		WaitUtil.waitForVisibility(driver, folderDropdown, 60);

		WaitUtil.waitAndClick(driver, folderDropdown, 80);
		ElementUtil.sendText(folderSearchField, folderName, driver);
		WaitUtil.waitAndClick(driver, folderSelectOption, 80);

	}

	public void addTags(String tagName) {

		WaitUtil.waitAndClick(driver, tagPlusIcon, 60);
		WaitUtil.waitAndClick(driver, addTagButton, 90);
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

		ElementUtil.click(nextButton, driver);
	}

	public void addMediaAndForm() {

		WaitUtil.waitAndClick(driver, addMediaButton, 60);
		WaitUtil.waitForPageToLoad(driver, 70);
		WaitUtil.waitForVisibility(driver, firstAssetClick, 60);

		if (driver.findElement(firstAssetClick).isDisplayed()) {

			WaitUtil.waitForPageToLoad(driver, 70);
			WaitUtil.waitForVisibility(driver, firstAssetClick, 60);
			WaitUtil.waitAndClick(driver, firstAssetClick, 60);
			ElementUtil.sendText(displayTextField, "Asset", driver);
			WaitUtil.waitAndClick(driver, confirmButton, 60);

		} else {
			ElementUtil.click(closePopupMedia, driver);
		}

		ElementUtil.click(addFormButton, driver);

		if (driver.findElement(firstFormClick).isDisplayed()) {

			WaitUtil.waitForPageToLoad(driver, 70);
			WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
			WaitUtil.waitForVisibility(driver, formPreview, 60);
			ElementUtil.click(formPreview, driver);
			ElementUtil.click(formPreviewClose, driver);
			ElementUtil.click(firstFormClick, driver);
		} else {
			ElementUtil.click(closePopupForm, driver);
		}
	}

	public void enterDescription(String description) {
	    // Wait for page load
	    WaitUtil.waitForPageToLoad(driver, 60);

	    // Interact with iframe content
	    driver.switchTo().frame(0);
	    WaitUtil.waitForElementClickable(driver, descriptionField, 60);
	    ElementUtil.click(descriptionField, driver);
	    ElementUtil.sendText(descriptionField, description, driver);
	    driver.switchTo().defaultContent();

	    // Wait for nextButton to be present in DOM
	    WaitUtil.waitForVisibility(driver, nextButton, 30);

	    // Scroll and pause to let it settle
	    WebElement nextBtnElement = driver.findElement(nextButton);
	    ElementUtil.scrollToElement(nextBtnElement, driver);
	    // Optional hard scroll up in case button is covered
	    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -150);");

	    ElementUtil.click(nextButton, driver);
	}

	public void selectAssetsAndQuiz() {
	    // Asset Selection - jpg
	    WaitUtil.waitForElementClickable(driver, searchAssetBox, 60);
	    ElementUtil.sendText(searchAssetBox, "jpg", driver);
	    ElementUtil.sendKey(searchAssetBox, Keys.ENTER, driver);
	    WaitUtil.waitForPageToLoad(driver, 60);
	    WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
	    ElementUtil.safeClickFirstAsset(firstAssetSelect, driver);

	    WaitUtil.waitAndClick(driver, clearSearchIcon, 60);
	    WaitUtil.waitForPageToLoad(driver, 60);

	    // Asset Selection - pdf
	    WaitUtil.waitForElementClickable(driver, searchAssetBox, 60);
	    ElementUtil.sendText(searchAssetBox, "pdf", driver);
	    ElementUtil.sendKey(searchAssetBox, Keys.ENTER, driver);
	    WaitUtil.waitForPageToLoad(driver, 60);
	    WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
	    ElementUtil.safeClickFirstAsset(firstAssetSelect, driver);

	    WaitUtil.waitAndClick(driver, clearSearchIcon, 60);
	    WaitUtil.waitForPageToLoad(driver, 60);

	    // Asset Type Dropdown - ppt
	    WaitUtil.waitForDropdownToBeReady(driver, assetTypeDropdown, 60);
	    DropdownUtil.selectByValue(driver, assetTypeDropdown, "11: ppt");
	    WaitUtil.waitForPageToLoad(driver, 60);
	    WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
	    ElementUtil.safeClickFirstAsset(firstAssetSelect, driver);

	    WaitUtil.waitForPageToLoad(driver, 60);

	    // Asset Type Dropdown - mp4
	    WaitUtil.waitForDropdownToBeReady(driver, assetTypeDropdown, 60);
	    DropdownUtil.selectByVisibleText(driver, assetTypeDropdown, "mp4");
	    WaitUtil.waitForPageToLoad(driver, 60);
	    WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
	    ElementUtil.safeClickFirstAsset(firstAssetSelect, driver);

	    WaitUtil.waitForPageToLoad(driver, 60);

	    // Reset Dropdown
	    WaitUtil.waitForDropdownToBeReady(driver, assetTypeDropdown, 60);
	    DropdownUtil.selectByVisibleText(driver, assetTypeDropdown, "Select Asset Type");
	    WaitUtil.waitForPageToLoad(driver, 60);
	    WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);

	    // Quiz selection
	    WaitUtil.waitForVisibility(driver, selectQuizBtn, 60);
	    ElementUtil.click(selectQuizBtn, driver);
	    WaitUtil.waitForDropdownToBeReady(driver, quizSortBy, 60);
	    DropdownUtil.selectByVisibleText(driver, quizSortBy, "Created On (DESC)");
	    ElementUtil.sendText(quizSearchBox, "quiz", driver);
	    
	    WebElement quiz = WaitUtil.waitForElementPresent(driver, firstQuizClick, 60);
	    if (quiz.isDisplayed()) {
	        if (ElementUtil.isElementVisible(firstQuizClick, driver)) {
	            ElementUtil.click(firstQuizClick, driver);
	            ElementUtil.click(previewQuiz, driver);
	            WaitUtil.waitForPageToLoad(driver, 60);
	            WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
	            WaitUtil.waitAndClick(driver, closeQuizPopup1, 70);
	            ElementUtil.click(closeQuizPopup, driver);
	        } else {
	            ElementUtil.click(closeQuizPopup, driver);
	        }

	        ElementUtil.click(orderAssetsButton, driver);
	        ElementUtil.click(previewOrderAsset, driver);
	        WaitUtil.waitAndClick(driver, closeOrderAssetPreview, 70);
	        WaitUtil.waitAndClick(driver, removeOrderAsset, 70);    
	        WaitUtil.waitAndClick(driver, removeAsset, 70);
	        ElementUtil.click(followSequenceToggle, driver);
	        WaitUtil.waitAndClick(driver, closeOrderAssetSection, 70);
	        ElementUtil.click(nextButton, driver);
	    }
	}


	public void publishTrack() {
		WaitUtil.waitForPageToLoad(driver, 60);

		ElementUtil.sendText(searchPublishInput, "automate", driver);
		ElementUtil.sendKey(searchPublishInput, Keys.ENTER, driver);
		WaitUtil.waitForPageToLoad(driver, 60);
		WaitUtil.waitForElementVisible(driver, arrowClickTrack, 60);
		ElementUtil.clickWithRetry(arrowClickTrack, driver, 3); // Use robust click
		//WaitUtil.waitAndClick(driver, arrowClickTrack, 70);

		WaitUtil.waitAndClick(driver, partnerSelectTrack, 70);
		ElementUtil.click(saveAndPublishButton, driver);

		// Wait for loader to disappear
		WaitUtil.waitForLoaderToDisappear(driver, 60);

		// Wait for confirmation message
		WaitUtil.waitForElementVisible(driver, publishConfirmationMessage, 60);
	}

	public String getPublishConfirmationMessage() {
		return WaitUtil.waitForElementVisible(driver, publishConfirmationMessage, 60).getText();
	}
}