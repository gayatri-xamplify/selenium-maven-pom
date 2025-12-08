package com.stratapps.xamplify.pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.utils.WaitUtil;
import com.stratapps.xamplify.utils.ElementUtil;

public class RedistributeEventCampaignPage {

	private WebDriver driver;

	public RedistributeEventCampaignPage(WebDriver driver) {
		this.driver = driver;
	}

	// =========================================================
	// LOCATORS
	// =========================================================
	private By campaignHover = By.xpath("//span[text()='Campaign']");
	private By redistributeCampaign = By.xpath("//span[text()='Redistribute Campaign']");
	private By eventTab = By.xpath("//li[contains(text(),'Event')]");

	// Preview
	private By previewIcon = By.xpath("//*[@id='redistribute-campaign-list']/tbody/tr[1]/td[5]/div/a[1]/i");
	// Download
		private By downloadMenu = By.xpath("(//span[@id='download-drop'])[1]");
		private By downloadHtml = By.xpath("(//*[@id='download-template']/ul/li[1]/a)[1]");
	// Download History
	private By downloadHistory = By.xpath("//table[@id='redistribute-campaign-list']/tbody/tr[1]/td[5]/div/span/a[2]");
	private By downloadHistoryClose = By.xpath("//button[@class='btn Btn-Gray']");

	// Redistribute icon for editing
	private By redistributeIcon = By.xpath("//table[@id='redistribute-campaign-list']/tbody/tr[1]/td[5]/div/span/a[1]");

	// Campaign fields
	private By campaignTitle = By.xpath("//input[@id='campaignName']");
	private By subjectLine = By.xpath("//input[@placeholder='{merge tag} + Subject line']");

	// Contact selection
	private By searchContact = By.xpath("//input[@placeholder='Search for a list']");
	private By searchIcon = By.xpath("(//i[@class='fa fa-search'])[2]");
	private By selectAllContacts = By.xpath("//input[@id='checkAllExistingContacts']");
	private By searchCampaign = By.xpath("//div[3]/div/div/input");
	private By searchiconcampaign = By.xpath("//button[@class='search-box-item-click only_content']//i[@class='fa fa-search']");
	private By backdrop = By.cssSelector("div.backdrop");

	// =========================================================
	// STEP 1 – OPEN REDISTRIBUTE EVENT CAMPAIGN MODULE
	// =========================================================
	public void openRedistributeEventCampaign() {
		WaitUtil.waitForElementVisible(driver, campaignHover, 60);
		ElementUtil.hoverAndClick(driver.findElement(campaignHover), driver);

		WaitUtil.waitForElementVisible(driver, redistributeCampaign, 60);

		WebElement redisElement = driver.findElement(redistributeCampaign);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", redisElement);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", redisElement);

		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 90);
		WaitUtil.waitForPageToLoad(driver, 90);
		WaitUtil.waitAndClick(driver, searchCampaign, 30);
		ElementUtil.sendText(searchCampaign, "Event", driver);
		WaitUtil.waitAndClick(driver, searchiconcampaign, 30);
		
//		// ⭐ NEW IMPORTANT WAIT ⭐
//		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
//
//		WaitUtil.waitAndClick(driver, eventTab, 60);
	}

	// =========================================================
	// PREVIEW EVENT TEMPLATE
	// =========================================================
	public void previewEventTemplate() throws Exception {

		  // 1️⃣ Wait until the entire page is loaded
	    WaitUtil.waitForPageToLoad(driver, 120);
	    WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 120);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));

	    // 2️⃣ Wait until preview icon EXISTS in DOM
	    wait.until(ExpectedConditions.presenceOfElementLocated(previewIcon));

	    // 3️⃣ Scroll preview icon into view (mandatory)
	    WebElement preview = driver.findElement(previewIcon);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", preview);
	    Thread.sleep(800);

	    // 4️⃣ Wait until preview is CLICKABLE
	    wait.until(ExpectedConditions.elementToBeClickable(previewIcon));

	    // 5️⃣ Click using JS (Selenium click often fails with heavy DOM)
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", preview);

	    // 6️⃣ Now wait for NEW TAB to open
	    String originalWindow = driver.getWindowHandle();
	    wait.until(driver1 -> driver.getWindowHandles().size() > 1);

	    // 7️⃣ Switch to new tab
	    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));

	    // 8️⃣ Wait for the preview page to load completely
	    WaitUtil.waitForPageToLoad(driver, 60);

	    Thread.sleep(1500);

	    // 9️⃣ Close the preview tab
	    driver.close();

	    // 🔟 Switch back to original tab
	    driver.switchTo().window(originalWindow);

	    WaitUtil.waitForPageToLoad(driver, 60);
	}

	// =========================================================
	// DOWNLOAD HISTORY ONLY
	// =========================================================

	public void downloadEmailTemplate() throws Exception {

		WaitUtil.waitForPageToLoad(driver, 30);
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
		
		 // 🔼 Scroll up before clicking the first element
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, 0);");
	    Thread.sleep(500); // small wait to stabilize

//		// HTML
//		WaitUtil.waitAndClick(driver, downloadMenu, 40);
//		WaitUtil.waitAndClick(driver, downloadHtml, 40);
		WaitUtil.waitAndClick(driver, downloadHistory, 40);
		WaitUtil.waitAndClick(driver, downloadHistoryClose, 40);
	}

	// =========================================================
	// FILL EVENT CAMPAIGN DETAILS
	// =========================================================
	public void fillEventCampaignDetails(String name) {

		WaitUtil.waitAndClick(driver, redistributeIcon, 60);

		WebElement title = WaitUtil.waitForElementVisible(driver, campaignTitle, 60);
		title.clear();
		title.sendKeys(name + "_" + System.currentTimeMillis());

		WebElement subject = WaitUtil.waitForElementVisible(driver, subjectLine, 60);
		subject.clear();
		subject.sendKeys("subject for redistributed event campaign");
	}

	// =========================================================
	// SELECT CONTACT LIST
	// =========================================================
	public void selectContacts() throws Exception {
		WaitUtil.waitForPageToLoad(driver, 30);
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
		WaitUtil.waitAndClick(driver, redistributeIcon, 60);
		WaitUtil.waitForPageToLoad(driver, 30);
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
		WaitUtil.waitForElementVisible(driver, searchContact, 60);
		ElementUtil.sendText(searchContact, "gayatri", driver);

		WaitUtil.waitAndClick(driver, searchIcon, 60);

		WaitUtil.waitAndClick(driver, selectAllContacts, 60);
	}
	
	 private By Gotohome =By.xpath("//img[@class='cls-pointer']");
	    public void backToHome() throws Exception {
	        By overlay = By.cssSelector(".swal2-overlay");

	        // Wait for page load
	        WaitUtil.waitForPageToLoad(driver, 60);

	        // Wait for SweetAlert overlay to disappear
	        WaitUtil.waitForInvisibilityOfElement(overlay, driver, 60);

	        // Now safely click home button
	        WaitUtil.waitAndClick(driver, Gotohome, 60);
	    }
}
