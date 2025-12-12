package com.stratapps.xamplify.pages;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;
import com.stratapps.xamplify.utils.xamplifyUtil;

public class SharedLeadsPage {
	WebDriver driver;
	private WebDriverWait wait;
	Logger logger = LogManager.getLogger(SharedLeadsPage.class);

	public SharedLeadsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(80));
	}

	// XPaths and Locators
	private By sharedLeadsMenu = By.xpath("//span[@class='title'][contains(text(),'Shared Leads')]");
	private By allCountBox = By.xpath("//div[contains(@class,'NumberFontDecrease')]/parent::div[contains(.,'All')]");
	private By validCountBox = By
			.xpath("//div[contains(@class,'NumberFontDecrease')]/parent::div[contains(.,'Valid')]");
	private By excludedCountBox = By
			.xpath("//div[contains(@class,'NumberFontDecrease')]/parent::div[contains(.,'Excluded')]");
	private By undeliverableCountBox = By
			.xpath("//div[contains(@class,'NumberFontDecrease')]/parent::div[contains(.,'Undeliverable')]");
	private By unsubscribedCountBox = By
			.xpath("//div[contains(@class,'NumberFontDecrease')]/parent::div[contains(.,'Unsubscribed')]");
	private By firstInfoIcon = By.xpath("(//i[contains(@class,'IconCustomization')])[1]");

	private By sortDropdown = By.xpath("//*[@id='manageContacts']//div[@class='inputs']//select");
	private By emailReportIcon = By.xpath("//i[contains(@class,'fa-file-export')]/ancestor::button");
	private By emailReportIcon2 = By.xpath("//i[contains(@class,'fa-file-export')]/..");
	private By buttonid = By.xpath("(//button[starts-with(@id, 'more_less_button')])[1]");
	private By unsubIcon = By.xpath("(//i[contains(@class,'fa fa-bell')])[1]");
	private By unsubReason = By.xpath("//input[@value='Want to receive fewer messages']");
	private By unsubSubmit = By.xpath("//span[contains(text(),'Unsubscribe')]");
	private By filterIcon = By.xpath("//i[contains(@class, 'fa-filter')]");
	private By filterFieldDropdown = By.xpath("(//select[@class='form-control ng-untouched ng-pristine ng-valid'])[1]");
	private By filterOperatorDropdown = By
			.xpath("//select[contains(@class, 'form-control') and contains(@class, 'responsiveMargin')]");
	private By filterInputField = By.xpath("//select[contains(@class, 'responsiveMargin')]/following::input[1]");
	private By filterSubmitBtn = By.xpath("//button[contains(text(),'Submit')]");
	private By filterCloseIcon = By.xpath("//div[contains(@class, 'd-flex')]//a[contains(@class, 'close-circle')]");
	private By filterSearchBox = By.xpath("(//app-manage-contacts//div/input)[1]");

	private By validTile = By.xpath("//button[contains(@class,'dashboard-stat') and .//div[contains(text(),'Valid')]]");
	private By validTile2 = By
			.xpath("(//button[contains(@class,'dashboard-stat') and .//div[contains(text(),'')]])[2]");

	private By excludeTile = By
			.xpath("//button[contains(@class,'dashboard-stat') and .//div[contains(text(),'Excluded')]]");
	private By undeliverableTile = By
			.xpath("//button[contains(@class,'dashboard-stat') and .//div[contains(text(),'Undeliverable')]]");
	private By unsubscribedTile = By
			.xpath("//button[contains(@class,'dashboard-stat') and .//div[contains(text(),'Unsubscribed')]]");
	private By resubscribeButton = By.xpath("(//i[contains(@class,'fa fa-bell')])[1]");
	private By resubscribeSubmit = By.xpath("//span[contains(text(),'Subscribe')]");
	private By sharedleadsAllBtn = By
			.xpath("//button[contains(@class,'dashboard-stat') and .//div[contains(text(),'All')]]");
	private By manageSharedSort = By.xpath("//*[@id='manageContacts']//div[@class='search-css']//select");
	private By manageSharedGrid = By.xpath("//i[contains(@class, 'fa-th-large') and contains(@class, 'p10')]");
	private By manageSharedGridInfoicon = By.xpath("(//a[@class='Iconhover custom-grid-icon'])[1]");

	private By SORT_BY_DROPDOWN = By.xpath("//div[@id='manageContacts']//select");
	private By reponsemsg = By.xpath("//span[@id=\"responseMessage\"]");
	public By SharedLeadMailId = By.xpath("(//b[text()= 'Email id:'])[1]/..");
	public By SubscribeBtn = By.xpath("(//button[contains(text(),'Subscribe')])[1]");
	private By SearchClear = By.xpath("//button[contains(@class,'remove search-box-item-clear')]");

	public String Sharedleadmail;

	// --------------------- Navigation ---------------------

	public void navigateToSharedLeads() throws InterruptedException { //
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
		wait.until(ExpectedConditions.elementToBeClickable(sharedLeadsMenu)).click();
		WaitUtil.waitForDropdownToBeReady(driver, sharedLeadsMenu, 60);
		ElementUtil.click(sharedLeadsMenu, driver);

	}

	public void waitForCountsToLoad() {
		logger.info("Waiting for tile counts to load");
		WaitUtil.waitForVisibility(driver, allCountBox, 60); // ✅ generic tile count visibility
	}

	public void clickFirstInfoIcon() {
		logger.info("Clicking on first info icon");
		WaitUtil.waitForVisibility(driver, firstInfoIcon, 60);
		ElementUtil.clickWithRetry(firstInfoIcon, driver, 3); // ✅ retry-safe click
	}

	public void loopSortByValues() throws InterruptedException {
		Thread.sleep(2000);
		WaitUtil.waitForElementVisible(driver, SORT_BY_DROPDOWN, 20);
		WebElement dropdown = driver.findElement(SORT_BY_DROPDOWN);
		Select select = new Select(dropdown);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			dropdown = driver.findElement(SORT_BY_DROPDOWN);
			select = new Select(dropdown);
			select.selectByIndex(i);
			System.out.println("Selected Sort By option: " + options.get(i).getText());
			Thread.sleep(1000);
		}
	}

	public void applyAllEditTileSortOptions() throws InterruptedException {
		WaitUtil.waitForDropdownToBeReady(driver, SORT_BY_DROPDOWN, 20);
		Select selectsort = new Select(driver.findElement(SORT_BY_DROPDOWN));
		List<WebElement> options = selectsort.getOptions();
		for (WebElement option : options) {
			String value = option.getAttribute("Value");
			WaitUtil.waitForDropdownToBeReady(driver, SORT_BY_DROPDOWN, 20);
			ElementUtil.selectDropdownByValue(SORT_BY_DROPDOWN, value, driver);
			System.out.println("Sorted by Value: " + option.getText());
			Thread.sleep(1000);
		}
		Thread.sleep(1000);

	}

	private int extractTileCount(By locator) {
		try {
			String text = driver.findElement(locator).getText().replaceAll("[^0-9]", "");
			return text.isEmpty() ? 0 : Integer.parseInt(text);
		} catch (Exception e) {
			logger.warn("Failed to extract count from: " + locator);
			return 0;
		}
	}

	public int getUnsubscribedTileCount() {
		return extractTileCount(unsubscribedTile);
	}

	public int getValidTileCount() {
		return extractTileCount(validTile);
	}

	public int getExcludeTileCount() {
		return extractTileCount(excludeTile);
	}

	public int getUndeliverableTileCount() {
		return extractTileCount(undeliverableTile);
	}

	private void selectDropdownValueWithRetry(By locator, String value) {
		int attempts = 3;
		for (int i = 0; i < attempts; i++) {
			try {
				Select dropdown = new Select(driver.findElement(locator));
				dropdown.selectByValue(value);
				return;
			} catch (StaleElementReferenceException e) {
				logger.warn("Stale element. Retrying... Attempt " + (i + 1));
			}
		}
	}

	// --------------------- Filtering ---------------------
	public void applyFilter(String field, String operator, String value) {
		try {
			WaitUtil.waitForDropdownToBeReady(driver, filterIcon, 60);
			ElementUtil.click(filterIcon, driver);
			Select fieldDropdown = new Select(
					wait.until(ExpectedConditions.visibilityOfElementLocated(filterFieldDropdown)));
			fieldDropdown.selectByVisibleText(field);
			Select operatorDropdown = new Select(
					wait.until(ExpectedConditions.visibilityOfElementLocated(filterOperatorDropdown)));
			operatorDropdown.selectByVisibleText(operator);
			WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(filterInputField));
			inputField.clear();
			inputField.sendKeys(value);
			WaitUtil.waitForDropdownToBeReady(driver, filterSubmitBtn, 60);
			ElementUtil.click(filterSubmitBtn, driver);
			WaitUtil.waitForDropdownToBeReady(driver, filterCloseIcon, 60);
			ElementUtil.click(filterCloseIcon, driver);

		} catch (Exception e) {
			logger.error(
					"Failed to apply filter with field: " + field + ", operator: " + operator + ", value: " + value, e);
			throw e;
		}
	}

	public void filterSearch(String Searchkey) {
		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(filterSearchBox));
		search.sendKeys(Searchkey);
		search.sendKeys(Keys.ENTER);
	}

	// --------------------- Tile Actions ---------------------
	public void manageSharedleadsTilesEmailreports() throws InterruptedException {
		WaitUtil.waitForDropdownToBeReady(driver, emailReportIcon, 60);
		ElementUtil.click(emailReportIcon, driver);
		Thread.sleep(3000);
		WaitUtil.verifyResponseMessage(driver, reponsemsg, 20,
				"We are processing your list(s) reports. We will send it over an email when the report is ready");
	}

	public void clickMoreLessButton() throws InterruptedException {
		logger.info("Clicking More/Less button");
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, buttonid, 60);
		WaitUtil.waitAndClick(driver, buttonid, 60);
	}
	// -----------------------

	public void clickUnsubscribeIcon() throws InterruptedException {
		logger.info("Starting unsubscribe action");
		Sharedleadmail = driver.findElement(SharedLeadMailId).getAttribute("title");
		System.out.println(Sharedleadmail);
		WaitUtil.waitForDropdownToBeReady(driver, unsubIcon, 60);
		ElementUtil.clickWithRetry(unsubIcon, driver, 3);
		WaitUtil.waitForDropdownToBeReady(driver, unsubReason, 60);
		ElementUtil.clickWithRetry(unsubReason, driver, 3);
		WaitUtil.waitForDropdownToBeReady(driver, unsubSubmit, 60);
		ElementUtil.clickWithRetry(unsubSubmit, driver, 3);
		Thread.sleep(3000);
		WaitUtil.verifyResponseMessage(driver, reponsemsg, 20, Sharedleadmail
				+ " has been successfully unsubscribed for receiving the emails from the company: PartnerAuto");
	}
	// -----------------------------

	public void clicksubscribeIcon() throws InterruptedException {
		filterSearch(Sharedleadmail);
		WaitUtil.waitForDropdownToBeReady(driver, resubscribeButton, 80);
		ElementUtil.click(resubscribeButton, driver);
		driver.findElement(By.id("comment")).sendKeys("Resubscribe sharedlead 123");
		ElementUtil.click(resubscribeSubmit, driver);
		Thread.sleep(2000);
		WaitUtil.verifyResponseMessage(driver, reponsemsg, 20, Sharedleadmail
				+ " has been successfully resubscribed for receiving the emails from the company: PartnerAuto");
	}

	public void sharedLeadsListUnsubscribeTile(String Searchkeyword) throws InterruptedException {
		Thread.sleep(10000);
		WaitUtil.waitForDropdownToBeReady(driver, unsubscribedTile, 80);
		Thread.sleep(10000);
		WaitUtil.waitAndClick(driver, unsubscribedTile, 60);
		filterSearch(Searchkeyword);
		Thread.sleep(2000);
		manageSharedleadsTilesEmailreports();
		WaitUtil.waitForDropdownToBeReady(driver, resubscribeButton, 80);
		ElementUtil.click(resubscribeButton, driver);
		driver.findElement(By.id("comment")).sendKeys("Resubscribe sharedlead 123");
		ElementUtil.click(resubscribeSubmit, driver);

	}

	public void UnsubscribeTileManageShareleads(String Searchkeyword) throws InterruptedException {
		Thread.sleep(10000);
		if (extractTileCount(unsubscribedTile) > 0) {
			WaitUtil.waitForDropdownToBeReady(driver, unsubscribedTile, 80);
			Thread.sleep(10000);
			WaitUtil.waitAndClick(driver, unsubscribedTile, 60);
			filterSearch(Searchkeyword);
			Thread.sleep(2000);
			WaitUtil.waitForDropdownToBeReady(driver, emailReportIcon2, 60);
			ElementUtil.click(emailReportIcon2, driver);
			Thread.sleep(3000);
			WaitUtil.verifyResponseMessage(driver, reponsemsg, 20,
					"We are processing your list(s) reports. We will send it over an email when the report is ready");
			WaitUtil.waitForDropdownToBeReady(driver, SubscribeBtn, 80);
			ElementUtil.click(SubscribeBtn, driver);
			driver.findElement(By.id("comment")).sendKeys("Resubscribe sharedlead 123");
			ElementUtil.click(resubscribeSubmit, driver);
			Thread.sleep(100);
		} else {
			System.out.println("'unsubscribed SharedLead' Tile count is " + extractTileCount(unsubscribedTile)
					+ ", So Unable to click on Valid Tile");
		}
	}

	public void ValidTileManageShareleads(String Searchkeyword) throws InterruptedException {
		Thread.sleep(10000);
		WaitUtil.waitForDropdownToBeReady(driver, validTile2, 80);
		Thread.sleep(10000);
		WaitUtil.waitAndClick(driver, validTile2, 60);
		filterSearch(Searchkeyword);
		Thread.sleep(2000);
		WaitUtil.waitForDropdownToBeReady(driver, emailReportIcon2, 60);
		ElementUtil.click(emailReportIcon2, driver);
		Thread.sleep(3000);
		WaitUtil.verifyResponseMessage(driver, reponsemsg, 20,
				"We are processing your list(s) reports. We will send it over an email when the report is ready");
		Thread.sleep(3000);
		try {
			WaitUtil.waitAndClick(driver, SearchClear, 20);
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void sharedLeadsEditListValidTile(int count) {
		if (count > 0)

			WaitUtil.waitForDropdownToBeReady(driver, validTile, 80);
		ElementUtil.click(validTile, driver);

	}

	public void sharedLeadsEditListExcludeTile(int count) throws InterruptedException {
		if (count > 0) {
			WaitUtil.waitForDropdownToBeReady(driver, excludeTile, 80);
			ElementUtil.click(excludeTile, driver);
			Thread.sleep(2000);
			WaitUtil.waitForDropdownToBeReady(driver, emailReportIcon2, 60);
			ElementUtil.click(emailReportIcon2, driver);
			Thread.sleep(3000);
			WaitUtil.verifyResponseMessage(driver, reponsemsg, 20,
					"We are processing your list(s) reports. We will send it over an email when the report is ready");
		} else {
			System.out.println("'Exclude SharedLead' Tile count is " + count + ", So Unable to click on Exclude Tile");
		}

	}

	public void sharedLeadsEditListUndeliverableTile(int count) throws InterruptedException {
		if (count > 0) {
			WaitUtil.waitForDropdownToBeReady(driver, undeliverableTile, 80);
			ElementUtil.click(undeliverableTile, driver);
			Thread.sleep(2000);
			WaitUtil.waitForDropdownToBeReady(driver, emailReportIcon2, 60);
			ElementUtil.click(emailReportIcon2, driver);
			Thread.sleep(3000);
			WaitUtil.verifyResponseMessage(driver, reponsemsg, 20,
					"We are processing your list(s) reports. We will send it over an email when the report is ready");
		}

		else {
			System.out.println(
					"'Undeliverable SharedLead' Tile count is " + count + ", So Unable to click on Undeliverable Tile");
		}

	}

	// --------------------- Full Tile Flow ---------------------
	public void manageAllSharedLeadsTileActions() throws InterruptedException {
		logger.info("Starting Shared Leads Listview Actions on All Tile.");
		navigateToSharedLeads();
		waitForCountsToLoad();
		clickFirstInfoIcon();
		applyAllEditTileSortOptions();
		clickMoreLessButton();
		applyFilter("City", "Contains", "Hyderabad");
		manageSharedleadsTilesEmailreports();
		clickUnsubscribeIcon();
		clicksubscribeIcon();
		clickUnsubscribeIcon();
		logger.info("Completed Shared Leads Listview Actions on All Tile.");
	}

	public void manageValidSharedLeadsTileActions() throws InterruptedException {
		if (extractTileCount(validTile) > 0) {
			WaitUtil.waitForDropdownToBeReady(driver, validTile, 80);
			ElementUtil.click(validTile, driver);
			applyAllEditTileSortOptions();
			applyFilter("City", "Contains", "Hyderabad");
			filterSearch(Sharedleadmail);
			manageSharedleadsTilesEmailreports();
		} else {
			System.out.println("'Valid SharedLead' Tile count is " + extractTileCount(validTile)
					+ ", So Unable to click on Valid Tile");
		}
	}

	public void manageExcludeSharedLeadsTileActions() throws InterruptedException {
		if (getExcludeTileCount() > 0) {
			WaitUtil.waitForDropdownToBeReady(driver, excludeTile, 80);
			ElementUtil.click(excludeTile, driver);
			applyAllEditTileSortOptions();
			applyFilter("City", "Contains", "Hyderabad");
			manageSharedleadsTilesEmailreports();
		} else {
			System.out.println("Excluded SharedLead Tile count is " + getExcludeTileCount()
					+ ", So Unable to click on Excluded Tile");
		}
	}

	public void manageUndeliverableSharedLeadsTileActions() throws InterruptedException {
		if (getUndeliverableTileCount() > 0) {
			WaitUtil.waitForDropdownToBeReady(driver, undeliverableTile, 80);
			ElementUtil.click(undeliverableTile, driver);
			applyAllEditTileSortOptions();
			applyFilter("City", "Contains", "Hyderabad");
			manageSharedleadsTilesEmailreports();
		} else {
			System.out.println("Undeliverable SharedLead Tile count is " + getUndeliverableTileCount()
					+ ", So Unable to click on Undeliverable Tile");
		}
	}

	public void manageUnsubscribeSharedLeadsTileActions() throws InterruptedException {
		if (extractTileCount(unsubscribedTile) > 0) {
			WaitUtil.waitForDropdownToBeReady(driver, unsubscribedTile, 80);
			ElementUtil.click(unsubscribedTile, driver);
			applyAllEditTileSortOptions();
			applyFilter("City", "Contains", "Hyderabad");
			manageSharedleadsTilesEmailreports();
			filterSearch(Sharedleadmail);
			Thread.sleep(1000);
			WaitUtil.waitForDropdownToBeReady(driver, SubscribeBtn, 80);
			ElementUtil.click(SubscribeBtn, driver);
			driver.findElement(By.id("comment")).sendKeys("Resubscribe sharedlead 123");
			ElementUtil.click(resubscribeSubmit, driver);
			Thread.sleep(2000);
			WaitUtil.verifyResponseMessage(driver, reponsemsg, 20, Sharedleadmail
					+ " has been successfully resubscribed for receiving the emails from the company: PartnerAuto");
			WaitUtil.waitAndClick(driver, SearchClear, 20);
			Thread.sleep(1000);
		} else {
			System.out.println("Unsubscribed SharedLead Tile count is " + extractTileCount(unsubscribedTile)
					+ ", So Unable to click on Valid Tile");
		}
	}

	// --------------------- Grid and Sort ---------------------
	public void manageSharedLeadsSort() {
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(manageSharedSort));
		for (int i = 1; i <= 4; i++) {
			new Select(dropdown).selectByValue(i + ": Object");
		}
	}

	public void manageSharedLeadsGrid() {
		try {
			WebElement gridToggle = wait.until(ExpectedConditions.presenceOfElementLocated(manageSharedGrid));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", gridToggle);

			// Wait for backdrop if visible
			try {
				WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(55));
				shortWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.backdrop")));
			} catch (Exception e) {
				System.out.println("Backdrop not found or already disappeared.");
			}

			// Click using JavaScript to avoid overlay issues
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", gridToggle);

			// Wait and click on the info icon
			WebElement gridInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(manageSharedGridInfoicon));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", gridInfo);
			new Actions(driver).moveToElement(gridInfo).click().perform();

			applyFilter("City", "Contains", "Hyderabad");
			manageSharedleadsTilesEmailreports();

		} catch (TimeoutException te) {
			System.out.println("Timeout waiting for shared leads grid: " + te.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
