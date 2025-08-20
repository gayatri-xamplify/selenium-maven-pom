package com.stratapps.xamplify.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.utils.ActionUtil;
import com.stratapps.xamplify.utils.CSVUtil;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.ScreenshotUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class ShareLeadsPage {
	WebDriver driver;
	private WebDriverWait wait;

	public ShareLeadsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(70));

	}

	// Locators
	private final By HOVER_SHARE_LEADS = By.xpath("//span[@class='title' and normalize-space()='Share Leads']");
	private final By ADD_SHARE_LEADS = By.xpath("//span[normalize-space()='Add Share Leads']");
	private final By MANAGE_SHARE_LEADS = By.xpath("//span[normalize-space()='Manage Share Leads']");
	private final By SH_ONE_AT_TIME = By.xpath("//span[normalize-space()=\"One at a Time\"]");
	private final By SH_EMAIL_ID = By.xpath("//input[@id='email1']");
	private final By SH_FIRST_NAME = By.xpath("//input[@id='firstName']");
	private final By SH_LAST_NAME = By.xpath("//input[@id='lastName']");
	private final By SH_COMPANY = By.xpath("//input[@type='company']");
	private final By SH_LEGAL_BASIS = By.xpath("//*[@id=\"multiselectelement\"]//span[3]/input");
	private final By SH_MOBILE_NO = By.xpath("//*[@id=\"blur-content-div\"]//app-country-phone-input//input");
	private final By SH_FLAG = By.xpath("//*[@id=\"blur-content-div\"]//app-country-phone-input//div/span[1]");
	private final By SH_FLAG_CODE = By
			.xpath("//*[@id=\"blur-content-div\"]//app-country-phone-input//div[@class=\"search-box\"]/input");
	private final By SH_FLAG_CODE_SELECT = By
			.xpath("//*[@id=\"blur-content-div\"]//app-country-phone-input//li/span[2]");
	private final By SH_SCROLL = By.xpath("//*[@class='modal-body border-bottom-1px popup_body']");
	private final By SHARE_LEADS_ADD = By.xpath("//div[@id='addContactModal']//button[2]");
	private final By SHARE_LEADS_SAVE = By.xpath("//button[@id=\"sample_editable_1_new\"]/span");
	private final By SHARE_LEADS_ACCEPT = By.xpath("//div[@id=\"tcModal\"]//button[2]");

	private final By SH_CSV_CLICK = By.xpath("//input[@type='file']");
	private final By SEARCH_BAR = By.xpath("//div[@id='manageContacts']//input");
	private final By EDIT_BUTTON = By.xpath("(//*[@id='partner_contact_list']//a[2]/i)[1]");
	private final By EDIT_ICON = By.xpath("(//i[contains(@class, 'fa-pencil-square-o')])[1]");
	// private final By PUBLISH_ICON =
	// By.xpath("(//*[@id='partner_contact_list']//td[7]/div/a[1]/i)[1]");

	private final By DELETE_ICON = By.xpath("(//i[contains(@class, 'fa-trash-o')])[1]");
	private final By DELETE_CONFIRM = By.xpath("//button[@class='swal2-confirm styled']");
	private final By DROPDOWN_LOCATOR = By.xpath(
			"//div[@class=\"col-xs-12 col-md-12 col-sm-12\"]//div[@class=\"col-xs-12 col-sm-6 col-lg-6 p0 pull-right\"]//select");

	private final By copyIcon = By.xpath(
			"//table[@id='partner_contact_list']//tr[1]//td//i[contains(@class, 'fa-files-o') and contains(@class, 'IconCustomization')]");

	private final By saveChangesButton = By.xpath(
			"//div[contains(@class,'modal-footer')]//button[.//span[contains(normalize-space(), 'Save changes')]]");

	private By confirmDeleteYes = By.xpath("//button[normalize-space()='Yes']");

	private final By deleteIconLocator = By
			.xpath("//table[@id='partner_contact_list']//tr[1]//td//i[contains(@class,'fa-trash')]");

	private By allTile = By.xpath("//div[contains(text(),'All')]");

	private By filterIcon = By.xpath("//i[contains(@class,'fa-filter')]");

	private By conditionDropdown = By.xpath("(//select[contains(@class,'form-control')])[2]");
	private By valueInput = By.xpath("//input[@placeholder='value*']");
	private By submitButton = By.xpath("//button[contains(text(),'Submit')]");

	private By searchInput = By.xpath("//input[@placeholder='Search']");

	private final By emailReportButton = By.xpath("//i[contains(@class, 'fa-file')]");

	private final By emailReportButton2 = By
			.xpath("//i[contains(@class, 'fa-file') and contains(@class, 'IconCustomization')]");

	private By gearIcon = By.xpath("//span[contains(@class, 'dropdown-toggle')]//i[contains(@class, 'fa-cog')]");
	private By newlist = By.xpath("//a[contains(text(),\" Create New List \")]");
	private By deleteButton = By.id("delete_button");

	private By validTile = By.xpath("//div[normalize-space()='Valid']");

	private By backdrop = By.cssSelector("div.backdrop");

	private By AllTilesortByDropdown = By
			.xpath("//div[contains(@class, 'sortingContacts')]//select[contains(@class, 'SeclectBoxPaddingsAbj')]");

	private By sortByDropdown = By
			.xpath("//div[contains(@class, 'search-css')]//select[contains(@class, 'SeclectBoxPaddingsAbj')]");

	public final static By FIRST_PUBLISH_ICON = By
			.xpath("(//i[contains(@class, 'fa-share') and contains(@class, 'IconCustomization')])[1]");
	private final By PUBLISH_viewicon = By
			.xpath("(//i[contains(@class, 'fa-eye') and contains(@class, 'IconCustomization')])[1]");

	private By fieldNameDropdown = By.xpath("(//select[contains(@class,'form-control')])[1]");

	private By campaignNameInput = By.id("campaignName");
	private By legalBasisDropdown = By.xpath("//*[@id=\"multiselectelement\"]//span[3]/input");
	private By saveButton = By.xpath("(//div[@id='saveAsModal']//button)[3]"); // update with actual value or property

	private By manageshFilterSelect = By.xpath("//input[@id='checkAllExistingContacts']");

	private final By undeliverableTile = By.xpath("(//button[contains(@class, 'yellow-gold')])[2]");
	private final By unsubscribeTile = By.xpath("//button[@class='btn-block dashboard-stat red']");

	private final By geariconAlltile = By.xpath("(//i[contains(@class,'fa-angle-down')])[2]");

	public void hoverOnShareLeads() throws Exception {
		Thread.sleep(3000);

		ActionUtil.hover(driver, HOVER_SHARE_LEADS); // hover only
		ActionUtil.hoverAndClick(driver, ADD_SHARE_LEADS); // click after hover

		ElementUtil.sendText(By.id("contactListName"), "AutoSlist" + System.currentTimeMillis(), driver);
	}

	public void createOneAtATimeLead() throws Exception {
		ElementUtil.click(SH_ONE_AT_TIME, driver);
		ElementUtil.sendText(SH_EMAIL_ID, "AutoLead" + System.currentTimeMillis() + "@test.com", driver);
		ElementUtil.sendText(SH_FIRST_NAME, "Auto", driver);
		ElementUtil.sendText(SH_LAST_NAME, "Test", driver);
		ElementUtil.sendText(SH_COMPANY, "Xamplify", driver);
		ElementUtil.sendText(SH_LEGAL_BASIS, "Legitimate interest - prospect/lead", driver);
		ElementUtil.sendKey(SH_LEGAL_BASIS, Keys.ENTER, driver);

		ElementUtil.sendText(By.id("title"), "QA Engineer", driver);

		ElementUtil.sendText(By.id("address"), "123 Street", driver);

		ElementUtil.sendText(By.id("city"), "Hyderabad", driver);

		ElementUtil.sendText(By.id("state"), "Telangana", driver);

		ElementUtil.sendText(By.id("zip"), "500001", driver);

		WebElement scrollableDiv = driver.findElement(SH_SCROLL);
		ActionUtil.scrollInsideElement(driver, scrollableDiv, 500);

		ElementUtil.click(SH_FLAG, driver);

		ElementUtil.sendText(SH_FLAG_CODE, "+91", driver);

		ElementUtil.click(SH_FLAG_CODE_SELECT, driver);

		ElementUtil.sendText(SH_MOBILE_NO, "9876543210", driver);

		ElementUtil.click(SHARE_LEADS_ADD, driver);

	}

	public void uploadCSVLeads() throws Exception {

		List<String[]> data = Arrays.asList(
				new String[] { "Auto", "Test", "Company", "Engineer", "auto.test@test.com", "Street", "City", "ST",
						"12345", "Country", "+91 1234567890" },
				new String[] { "John", "Doe", "TestCorp", "QA", "john.doe@test.com", "456 Road", "Town", "ST", "56789",
						"Country", "+91 1231231234" });

		String path = CSVUtil.generateCSV(data);
		driver.findElement(SH_CSV_CLICK).sendKeys(path);
		ElementUtil.sendText(SH_LEGAL_BASIS, "Legitimate interest - prospect/lead", driver);
		ElementUtil.sendKey(SH_LEGAL_BASIS, Keys.ENTER, driver);
	}

	public void clickSaveAndAccept() throws InterruptedException {
		ElementUtil.click(SHARE_LEADS_SAVE, driver);

		Thread.sleep(1000);
		ElementUtil.click(SHARE_LEADS_ACCEPT, driver);
		Thread.sleep(500);
	}

	public void navigateToManageShareLeads() throws Exception {
		Thread.sleep(1000);

		ActionUtil.hover(driver, HOVER_SHARE_LEADS); // hover only
		ActionUtil.hoverAndClick(driver, MANAGE_SHARE_LEADS); // click after hover

	}

	public void editShareLeadDetails() throws InterruptedException {

		WaitUtil.waitAndClick(driver, EDIT_BUTTON, backdrop, 120);

		/*
		 * // Now click safely ElementUtil.click(EDIT_BUTTON, driver);
		 */
		Thread.sleep(2000);
		ElementUtil.click(EDIT_ICON, driver);

		ElementUtil.getById(driver, "lastName").sendKeys("L1");
		WebElement mobileField = driver.findElement(SH_MOBILE_NO);
		mobileField.clear();
		mobileField.sendKeys("+91 9876543210");
		ElementUtil.click(SHARE_LEADS_ADD, driver);
	}

	public void saveEditedLeadAndConfirm() throws InterruptedException {
		Thread.sleep(2000);
		ElementUtil.getById(driver, "save&delete_button").click();
		ElementUtil.getById(driver, "save_button").click();
		Thread.sleep(2000);
		ElementUtil.click(SHARE_LEADS_ACCEPT, driver);
		Thread.sleep(1000);
	}

	public void publishAndDownloadShareLeadFlow() throws InterruptedException {

		WaitUtil.waitAndClick(driver, FIRST_PUBLISH_ICON, backdrop, 150);

		// Now click safely
		// ElementUtil.click(FIRST_PUBLISH_ICON, driver);

		// Wait and input text
		WebDriverWait inputWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		By searchInput = By.xpath("(//input[@id='sort-text'])[1]");
		inputWait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));

		ElementUtil.sendText(searchInput, "PartnerAuto", driver);
		Thread.sleep(1000);
		ElementUtil.sendKey(searchInput, Keys.ENTER, driver);
		Thread.sleep(1000);

		ElementUtil.click(By.xpath("//div[@id='partnerCompaniesPopup']//table//i[@class='fa fa-angle-right']"), driver);
		Thread.sleep(1000);
		ElementUtil.click(By.xpath("//div[@id='partnerCompaniesPopup']//table//th[1]//input"), driver);
		Thread.sleep(1000);
		ElementUtil.click(By.xpath("//div[@id='partnerCompaniesPopup']//button//span"), driver);
		Thread.sleep(1000);

		ScreenshotUtil.captureScreenshot(driver, "Published_Shareleads");
		Thread.sleep(1000);
		ElementUtil.click(By.xpath("//div[@id='partnerCompaniesPopup']//button[contains(text(),\"Close\")]"), driver);

		// Thread.sleep(58000);

		WaitUtil.waitAndClick(driver, PUBLISH_viewicon, backdrop, 80);

		// Now click safely
		// ElementUtil.click(PUBLISH_viewicon, driver);

		Thread.sleep(2000);
		ElementUtil.click(By.xpath(
				"//div[contains(@class,'d-flex') and contains(@class,'justify-content-between')] //a[contains(@class,'close-circle')]"),
				driver);
		Thread.sleep(3000);

		ElementUtil.click(By.xpath("(//i[@class='fa fa-download IconCustomization'])[1]"), driver);
		Thread.sleep(2000);
	}

	public void searchShareLead(String query) throws InterruptedException {

		WaitUtil.waitAndClick(driver, SEARCH_BAR, backdrop, 130);
		ElementUtil.sendText(SEARCH_BAR, query, driver);
		ElementUtil.sendKey(SEARCH_BAR, Keys.ENTER, driver);
		Thread.sleep(3000);
	}

	public void publishAndDownloadShareLead() throws InterruptedException {
		ElementUtil.click(FIRST_PUBLISH_ICON, driver);
		Thread.sleep(2000);
	}

	public void clickCopyIcon() {

		WaitUtil.waitAndClick(driver, copyIcon, backdrop, 80);

	}

	public void clickSaveAsButton() {
		wait.until(ExpectedConditions.elementToBeClickable(saveChangesButton)).click();
	}

	public void confirmDelete() {
		wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteYes)).click();
	}

	public void clickDeleteIcon() {
		WaitUtil.waitAndClick(driver, DELETE_ICON, backdrop, 120);
		ElementUtil.click(DELETE_CONFIRM, driver);

		// ActionUtil.clickWithRetry(driver, DELETE_ICON, 3);

	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException ignored) {
		}
	}

	public void clickAllTile() throws InterruptedException {

		WaitUtil.waitAndClick(driver, allTile, backdrop, 120);

		// ElementUtil.click(allTile, driver);
		Thread.sleep(3000);
	}

	public void clickFilterIcon() throws InterruptedException {
		Thread.sleep(8000);
		ElementUtil.click(filterIcon, driver);
		Thread.sleep(2000);
	}

	public void selectFieldName(String fieldName) {
		ElementUtil.selectDropdownByVisibleText(fieldNameDropdown, fieldName, driver);
	}

	public void selectCondition(String fieldName) {
		ElementUtil.selectDropdownByVisibleText(conditionDropdown, fieldName, driver);
	}

	public void sendValue(String fieldName) {
		ElementUtil.sendText(valueInput, fieldName, driver);

	}

	public void applyFilter() throws InterruptedException {

		// Submit
		ElementUtil.click(submitButton, driver);
		Thread.sleep(3000);
	}

	// Actions

	public void filterSearch(String searchText) {
		ElementUtil.sendText(searchInput, searchText, driver);
		ElementUtil.sendKey(searchInput, Keys.ENTER, driver);
	}

	public void sortByIndex(int index) {
		try {
			WebElement dropdown = driver.findElement(By.id("sortDropdown")); // Use actual dropdown ID
			Select select = new Select(dropdown);
			select.selectByIndex(index);
			// logger.info("Selected sort option by index: " + index);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void sortTilesAndEmailReport() throws InterruptedException {
		List<String> sortOptions = Arrays.asList("Email (A-Z)", "Email (Z-A)", "First name (ASC)", "First name (DESC)",
				"Last name (ASC)");
		for (String option : sortOptions) {
			ElementUtil.selectDropdownByVisibleText(sortByDropdown, option, driver);
			try {
				Thread.sleep(2000); // wait for UI to update
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Thread.sleep(1000); // wait for UI to update

	}

	public void EmailReport() {

		WaitUtil.waitAndClick(driver, emailReportButton, backdrop, 80);

		// Now safely click the element
		// ElementUtil.click(emailReportButton, driver);

		// ActionUtil.clickWithRetry(driver, emailReportButton, 3);
	}

	public void gearIconFromTiles() {
		WaitUtil.waitAndClick(driver, manageshFilterSelect, backdrop, 80);

	}

	public void enterListName(String baseName) throws InterruptedException {

		Thread.sleep(3000); // or replace with WebDriverWait

		ElementUtil.click(geariconAlltile, driver);
		ElementUtil.click(newlist, driver);

		String nameWithTimestamp = baseName + System.currentTimeMillis();

		// 🔽 FIXED: Ensure visibility first
		WaitUtil.waitForVisibility(driver, campaignNameInput, 70);
		WaitUtil.waitForPresence(driver, campaignNameInput, 70);

		ElementUtil.sendTextdriver(driver, campaignNameInput, nameWithTimestamp);
	}

	public void selectLegalBasis(String option) {
		ElementUtil.sendTextdriver(driver, legalBasisDropdown, option);
		ElementUtil.sendKeydriver(driver, legalBasisDropdown, Keys.ENTER);
	}

	public void clickSave() throws Exception {
		Thread.sleep(2000);
		ElementUtil.click(saveButton, driver);
	}

	public void clickValidTile() {
		try {

			WaitUtil.waitAndClick(driver, validTile, backdrop, 130);

			WebElement tile = driver.findElement(validTile);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tile);
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", tile);

			System.out.println("✅ Clicked on Valid tile successfully");
		} catch (Exception e) {
			System.out.println("❌ Failed to click Valid tile: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void sortBy(String visibleText) {

		// By dropdownLocator = By.xpath("//select[contains(@class,'form-control') and
		// contains(@class,'SelectBoxPaddingsAbJ')]");

		List<String> sortOptions = new ArrayList<>();

		// Step 1: Collect all dropdown option texts initially
		Select initialSelect = new Select(driver.findElement(sortByDropdown));
		for (WebElement option : initialSelect.getOptions()) {
			String optionText = option.getText().trim();
			if (!optionText.equalsIgnoreCase("Sort by") && !optionText.isEmpty()) {
				sortOptions.add(optionText);
			}
		}

		// Step 2: Iterate through the options by visible text
		for (String optionText : sortOptions) {
			WaitUtil.waitForVisibility(driver, sortByDropdown, 40);
			Select select = new Select(driver.findElement(sortByDropdown));
			select.selectByVisibleText(optionText);

			System.out.println("Selected Sort Option: " + optionText);

			// Optional: Wait for list to update (use AJAX or full load wait)
			WaitUtil.waitForPageToLoad(driver, 40);
			// Optionally: Wait for specific element/table to become stale and reload
		}

	}

	public void searchList(String searchTerm) {
		WaitUtil.waitForVisibility(driver, searchInput, 50);
		WebElement searchBox = driver.findElement(searchInput);
		searchBox.clear();
		searchBox.sendKeys(searchTerm);
		searchBox.sendKeys(Keys.ENTER); // Or trigger a button if needed
	}

	public boolean isExcludeTileEnabled() {
		try {
			By excludeTileLocator = By.xpath("(//button[contains(@class, 'yellow-gold')])[1]");
			WebElement excludeTile = WaitUtil.waitForElementPresent(driver, excludeTileLocator, 40);
			return excludeTile.isEnabled();
		} catch (TimeoutException e) {
			System.out.println("Exclude tile not present: " + e.getMessage());
			return false;
		}
	}

	public void clickExcludeTile() {
		try {
			By excludeTileLocator = By.xpath("(//button[contains(@class, 'yellow-gold')])[1]");
			WebElement excludeTile = WaitUtil.waitForElementClickable(driver, excludeTileLocator, 40);
			excludeTile.click();
		} catch (TimeoutException e) {
			System.out.println("Exclude tile not clickable: " + e.getMessage());
		}
	}

	public boolean isUndeliverableTileEnabled() {
		try {
			WebElement tile = WaitUtil.waitForElementPresent(driver, undeliverableTile, 30);
			return tile.isEnabled();
		} catch (TimeoutException e) {
			System.out.println("Undeliverable tile not present: " + e.getMessage());
			return false;
		}
	}

	public void clickUndeliverableTile() {
		try {
			By UndeliverableTileLocator = By.xpath("(//button[contains(@class, 'yellow-gold')])[1]");
			WebElement excludeTile = WaitUtil.waitForElementClickable(driver, UndeliverableTileLocator, 40);
			excludeTile.click();
		} catch (TimeoutException e) {
			System.out.println("UndeliverableTile tile not clickable: " + e.getMessage());
		}
	}

	public boolean isunsubscribeTileEnabled() {
		try {
			WebElement tile = WaitUtil.waitForElementPresent(driver, unsubscribeTile, 30);
			return tile.isEnabled();
		} catch (TimeoutException e) {
			System.out.println("unsubscribeTile tile not present: " + e.getMessage());
			return false;
		}
	}

	public void clickUnsubscribeTile() {
		try {
			// ✅ Updated locator for better flexibility (in case of dynamic class order)
			By unsubscribeTileLocator = By
					.xpath("//button[contains(@class, 'dashboard-stat') and contains(@class, 'red')]");

			// ✅ Wait until the element is clickable
			WebElement unsubscribeButton = WaitUtil.waitForElementClickable(driver, unsubscribeTileLocator, 40);

			// ✅ Ensure element is scrolled into view
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", unsubscribeButton);

			// ✅ Check if element has size (not hidden or collapsed)
			if (unsubscribeButton.isDisplayed() && unsubscribeButton.getSize().getHeight() > 0) {
				try {
					unsubscribeButton.click();
					System.out.println("✅ Clicked Unsubscribe tile successfully.");
				} catch (ElementNotInteractableException e) {
					// 🔁 Fallback to JS click if normal click fails
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", unsubscribeButton);
					System.out.println("⚠️ Used JS click fallback for Unsubscribe tile.");
				}
			} else {
				System.out.println("❌ Unsubscribe tile not visible or has no size.");
			}

		} catch (TimeoutException e) {
			System.out.println("❌ Unsubscribe tile not clickable (Timeout): " + e.getMessage());
		}
	}

	public By getDropdownLocator() {
		return sortByDropdown;
	}

	public void sortAllOptions(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));

		// Ensure dropdown is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(sortByDropdown));

		Select dropdown = new Select(driver.findElement(sortByDropdown));
		List<WebElement> options = dropdown.getOptions();

		for (int i = 1; i < options.size(); i++) {
			dropdown.selectByIndex(i);

			// Wait for loader to disappear after each sort
			WaitUtil.waitForLoaderToDisappear(driver, 80);

			// Wait for first publish icon as an indicator of loaded result
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-trash-o trashIconCustomization'])[1]")));

			System.out.println("Selected: " + dropdown.getFirstSelectedOption().getText());
			Thread.sleep(1000); // Optional short wait for UI animation
		}
	}

	public void sortAllTileOptions(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));

		// ✅ Loop through dropdown options, refreshing elements each time
		for (int i = 1;; i++) {
			try {
				// 🔁 Re-locate dropdown and reinitialize Select to avoid stale element
				wait.until(ExpectedConditions.visibilityOfElementLocated(AllTilesortByDropdown));
				Select Alldropdown = new Select(driver.findElement(AllTilesortByDropdown));

				List<WebElement> options = Alldropdown.getOptions();

				// 🔁 Break the loop if we reach the end of options
				if (i >= options.size())
					break;

				// ✅ Select option by index
				Alldropdown.selectByIndex(i);

				// ✅ Wait for loader to disappear (custom utility)
				WaitUtil.waitForLoaderToDisappear(driver, 80);

				// ✅ Wait for results table to appear as confirmation of reload
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//*[@id='sample_editable_1']/thead/tr")));

				// ✅ Print the selected option
				System.out.println("Selected: " + Alldropdown.getFirstSelectedOption().getText());

				Thread.sleep(1000); // Optional: short delay for UI animation
			} catch (StaleElementReferenceException e) {
				System.out.println("⚠️ Caught stale element - retrying index " + i);
				i--; // 🔁 Retry the same index
			}
		}
	}

}