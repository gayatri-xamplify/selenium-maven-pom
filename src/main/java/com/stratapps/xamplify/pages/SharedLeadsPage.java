package com.stratapps.xamplify.pages;

import java.time.Duration;

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
	private By buttonid = By.xpath("(//button[starts-with(@id, 'more_less_button')])[1]");
	private By unsubIcon = By.xpath("(//i[contains(@class,'fa fa-bell')])[2]");
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

	private By validTile = By.xpath("//button//div[contains(text(),'Valid')]");
	private By excludeTile = By.xpath("//button//div[contains(text(),'Excluded')]");
	private By undeliverableTile = By.xpath("//button//div[contains(text(),'Undeliverable')]");
	private By unsubscribedTile = By.xpath("//button//div[contains(text(),'Unsubscribed')]");
	private By resubscribeButton = By.xpath("(//button[@class='btn-primary'])[1]");
	private By resubscribeSubmit = By.xpath("//span[contains(text(),'Subscribe')]");
	private By sharedleadsAllBtn = By
			.xpath("//button[contains(@class,'dashboard-stat') and .//div[contains(text(),'All')]]");
	private By manageSharedSort = By.xpath("//*[@id='manageContacts']//div[@class='search-css']//select");
	private By manageSharedGrid = By.xpath("//i[contains(@class, 'fa-th-large') and contains(@class, 'p10')]");
	private By manageSharedGridInfoicon = By.xpath("(//a[@class='Iconhover custom-grid-icon'])[1]");

	// --------------------- Navigation ---------------------
	
	  public void navigateToSharedLeads() { //
	  wait.until(ExpectedConditions.elementToBeClickable(sharedLeadsMenu)).click();
	  
	  WaitUtil.waitForDropdownToBeReady(driver, sharedLeadsMenu, 60);
	  ElementUtil.click(sharedLeadsMenu, driver);
	  
	  }
	 

		/*
		 * public void navigateToSharedLeads() {
		 * logger.info("Navigating to Shared Leads page");
		 * WaitUtil.waitForPageToLoad(driver, 60);
		 * ElementUtil.clickWithRetry(sharedLeadsMenu, driver, 3); // ✅ safe click
		 * WaitUtil.waitForLoaderToDisappear(driver, 60); }
		 */

	public void waitForCountsToLoad() {
		logger.info("Waiting for tile counts to load");
		WaitUtil.waitForVisibility(driver, allCountBox, 60); // ✅ generic tile count visibility
	}

	/*
	 * public void waitForCountsToLoad() { WaitUtil.waitForElementVisible(driver,
	 * allCountBox, 60); WaitUtil.waitForElementVisible(driver, validCountBox, 60);
	 * WaitUtil.waitForElementVisible(driver, excludedCountBox, 60);
	 * WaitUtil.waitForElementVisible(driver, undeliverableCountBox, 60);
	 * WaitUtil.waitForElementVisible(driver, unsubscribedCountBox, 60);
	 * 
	 * }
	 */

	// ✅ 3. Click on first info icon with retry logic
	public void clickFirstInfoIcon() {
		logger.info("Clicking on first info icon");
		WaitUtil.waitForVisibility(driver, firstInfoIcon, 60);
		ElementUtil.clickWithRetry(firstInfoIcon, driver, 3); // ✅ retry-safe click
	}

	/*
	 * public void clickFirstInfoIcon() {
	 * 
	 * WaitUtil.waitForDropdownToBeReady(driver, firstInfoIcon, 60);
	 * ElementUtil.click(firstInfoIcon, driver);
	 * 
	 * }
	 */

	// ✅ 4. Sort dropdown using safe retry in loop
	public void applyAllEditTileSortOptions() {
		logger.info("Applying all tile sort options");
		for (int i = 1; i <= 6; i++) {
			By option = By.xpath("//select[@id='sortDropdown']/option[" + i + "]");
			WaitUtil.waitForElementClickable(driver, sortDropdown, 30);
			ElementUtil.clickWithRetry(sortDropdown, driver, 3); // open dropdown
			ElementUtil.clickWithRetry(option, driver, 3); // ✅ retry for each dropdown option
			WaitUtil.waitForLoaderToDisappear(driver, 30); // wait after sort
		}
	}

	/*
	 * // --------------------- Sorting --------------------- public void
	 * applyAllEditTileSortOptions() { for (int i = 1; i <= 6; i++) {
	 * selectDropdownValueWithRetry(sortDropdown, i + ": Object"); } }
	 */

	// --------------------- Tile Count ---------------------
	private int extractTileCount(By locator) {
		try {
			String text = driver.findElement(locator).getText().replaceAll("[^0-9]", "");
			return text.isEmpty() ? 0 : Integer.parseInt(text);
		} catch (Exception e) {
			logger.warn("Failed to extract count from: " + locator);
			return 0;
		}
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

	private void filterSearch() {
		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(filterSearchBox));
		search.sendKeys("e");
		search.sendKeys(Keys.ENTER);
	}

	// --------------------- Tile Actions ---------------------
	public void manageSharedleadsTilesEmailreports() {

		WaitUtil.waitForDropdownToBeReady(driver, emailReportIcon, 60);
		ElementUtil.click(emailReportIcon, driver);

	}

	/*
	 * public void clickMoreLessButton() { try {
	 * 
	 * WaitUtil.waitForPresence(driver, buttonid, 60);
	 * 
	 * WaitUtil.waitForDropdownToBeReady(driver, buttonid, 60);
	 * ElementUtil.click(buttonid, driver);
	 * 
	 * logger.info("Clicked on More/Less button successfully."); } catch (Exception
	 * e) { logger.error("Failed to click on More/Less button.", e); throw e; } }
	 */

	// ✅ 6. Click More/Less button with wait and retry
	public void clickMoreLessButton() {
		logger.info("Clicking More/Less button");
		WaitUtil.waitForPresence(driver, buttonid, 60);
		WaitUtil.waitForDropdownToBeReady(driver, buttonid, 60);
		ElementUtil.clickWithRetry(buttonid, driver, 3); // ✅ retry for flaky click
	}

	/*
	 * 
	 * 
	 * 
	 * public void clickMoreLessButton() { try { By moreLessButtonLocator =
	 * buttonid; // assuming buttonid is a By object
	 * 
	 * WaitUtil.waitForPresence(driver, moreLessButtonLocator, 80);
	 * WaitUtil.waitForDropdownToBeReady(driver, moreLessButtonLocator, 80);
	 * 
	 * // Retry logic try { ElementUtil.click(moreLessButtonLocator, driver); }
	 * catch (StaleElementReferenceException stale) {
	 * logger.warn("StaleElementReferenceException caught, retrying click...");
	 * WaitUtil.waitForPresence(driver, moreLessButtonLocator, 80);
	 * ElementUtil.click(moreLessButtonLocator, driver); }
	 * 
	 * logger.info("Clicked on More/Less button successfully."); } catch (Exception
	 * e) { logger.error("Failed to click on More/Less button.", e); throw e; } }
	 * 
	 * 
	 * 
	 * 
	 */

	// ✅ 7. Click Unsubscribe icon flow with multi-step retry
	public void clickUnsubscribeIcon() {
		logger.info("Starting unsubscribe action");

		WaitUtil.waitForDropdownToBeReady(driver, unsubIcon, 60);
		ElementUtil.clickWithRetry(unsubIcon, driver, 3); // ✅ open unsubscribe dialog

		WaitUtil.waitForDropdownToBeReady(driver, unsubReason, 60);
		ElementUtil.clickWithRetry(unsubReason, driver, 3); // ✅ choose reason

		WaitUtil.waitForDropdownToBeReady(driver, unsubSubmit, 60);
		ElementUtil.clickWithRetry(unsubSubmit, driver, 3); // ✅ submit
	}

	/*
	 * 
	 * 
	 * 
	 * public void clickUnsubscribeIcon() {
	 * 
	 * WaitUtil.waitForDropdownToBeReady(driver, unsubIcon, 60);
	 * ElementUtil.click(unsubIcon, driver);
	 * WaitUtil.waitForDropdownToBeReady(driver, unsubReason, 60);
	 * ElementUtil.click(unsubReason, driver);
	 * WaitUtil.waitForDropdownToBeReady(driver, unsubSubmit, 60);
	 * ElementUtil.click(unsubSubmit, driver);
	 * 
	 * 
	 * }
	 */

	public void sharedLeadsListUnsubscribeTile() {

		WaitUtil.waitForDropdownToBeReady(driver, unsubscribedTile, 80);
		ElementUtil.click(unsubscribedTile, driver);

		filterSearch();
		manageSharedleadsTilesEmailreports();

		WaitUtil.waitForDropdownToBeReady(driver, resubscribeButton, 80);
		ElementUtil.click(resubscribeButton, driver);

		driver.findElement(By.id("comment")).sendKeys("Resubscribe sharedlead 123");
		ElementUtil.click(resubscribeSubmit, driver);

	}

	public void sharedLeadsEditListValidTile(int count) {
		if (count > 0)

			WaitUtil.waitForDropdownToBeReady(driver, validTile, 80);
		ElementUtil.click(validTile, driver);

	}

	public void sharedLeadsEditListExcludeTile(int count) {
		if (count > 0)

			WaitUtil.waitForDropdownToBeReady(driver, excludeTile, 80);
		ElementUtil.click(excludeTile, driver);

		// wait.until(ExpectedConditions.elementToBeClickable(excludeTile)).click();
	}

	public void sharedLeadsEditListUndeliverableTile(int count) {
		if (count > 0)
			WaitUtil.waitForDropdownToBeReady(driver, undeliverableTile, 80);
		ElementUtil.click(undeliverableTile, driver);

	}

	// --------------------- Full Tile Flow ---------------------
	public void manageAllSharedLeadsTileActions() {

		WaitUtil.waitForDropdownToBeReady(driver, sharedleadsAllBtn, 80);
		ElementUtil.click(sharedleadsAllBtn, driver);

		applyFilter("City", "Contains", "Hyderabad");

		filterSearch();
		manageSharedleadsTilesEmailreports();
	}

	public void manageValidSharedLeadsTileActions() {

		WaitUtil.waitForDropdownToBeReady(driver, validTile, 80);
		ElementUtil.click(validTile, driver);

		applyFilter("City", "Contains", "Hyderabad");

		manageSharedleadsTilesEmailreports();
	}

	public void manageExcludeSharedLeadsTileActions() {
		if (getExcludeTileCount() > 0) {

			WaitUtil.waitForDropdownToBeReady(driver, excludeTile, 80);
			ElementUtil.click(excludeTile, driver);

			applyFilter("City", "Contains", "Hyderabad");

			manageSharedleadsTilesEmailreports();
		}
	}

	public void manageUndeliverableSharedLeadsTileActions() {
		if (getUndeliverableTileCount() > 0) {

			WaitUtil.waitForDropdownToBeReady(driver, undeliverableTile, 80);
			ElementUtil.click(undeliverableTile, driver);

			applyFilter("City", "Contains", "Hyderabad");

			manageSharedleadsTilesEmailreports();
		}
	}

	public void manageUnsubscribeSharedLeadsTileActions() {
		if (extractTileCount(unsubscribedTile) > 0) {
			WaitUtil.waitForDropdownToBeReady(driver, unsubscribedTile, 80);
			ElementUtil.click(unsubscribedTile, driver);

			// wait.until(ExpectedConditions.elementToBeClickable(unsubscribedTile)).click();
			applyFilter("City", "Contains", "Hyderabad");

			manageSharedleadsTilesEmailreports();
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
