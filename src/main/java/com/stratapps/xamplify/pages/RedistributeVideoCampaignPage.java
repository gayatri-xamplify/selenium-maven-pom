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

public class RedistributeVideoCampaignPage {

	private WebDriver driver;

	public RedistributeVideoCampaignPage(WebDriver driver) {
		this.driver = driver;
	}

	// =========================================================
	// LOCATORS
	// =========================================================
	private By campaignHover = By.xpath("//span[text()='Campaign']");
	private By redistributeCampaign = By.xpath("//span[text()='Redistribute Campaign']");
	private By videoTab = By.xpath("//li[contains(text(),'Video')]");

	// Preview
	private By previewIcon = By.xpath("//*[@id='redistribute-campaign-list']/tbody/tr[1]/td[5]/div/a[1]/i");

	// Redistribute icon
	private By redistributeIcon = By.xpath("//*[@id='redistribute-campaign-list']/tbody/tr[1]/td[5]/div/span/a[1]/i");

	// Campaign fields
	private By campaignTitle = By.xpath("//input[@id='campaignName']");
	private By subjectLine = By.xpath("//input[@placeholder='{merge tag} + Subject line']");

	// Download
	private By downloadMenu = By.xpath("(//span[@id='download-drop'])[1]");
	private By downloadHtml = By.xpath("(//*[@id='download-template']/ul/li[1]/a)[1]");
	private By downloadImage = By.xpath("(//*[@id='download-template']/ul/li[3]/a)[1]");
	private By downloadHistory = By.xpath("(//i[@class='fa fa-history IconCustomization'])[1]");
	private By downloadHistoryClose = By.xpath("//button[@class='btn Btn-Gray']");

	// Contact selection
	private By selectButton = By.xpath("//span[contains(text(),'Select')]");
	private By searchContact = By.xpath("//input[@placeholder='Search for a list']");
	private By selectAllContacts = By.xpath("//input[@id='checkAllExistingContacts']");
	private By backdrop = By.cssSelector("div.backdrop");

	// =========================================================
	// MAIN ACTIONS
	// =========================================================

	/** Navigate → Click Redistribute → Video Tab */
	public void openRedistributeVideoCampaign() {
		 WaitUtil.waitForElementVisible(driver, campaignHover, 60);
		    ElementUtil.hoverAndClick(driver.findElement(campaignHover), driver);

		    WaitUtil.waitForElementVisible(driver, redistributeCampaign, 60);

		    WebElement redisElement = driver.findElement(redistributeCampaign);
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", redisElement);
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", redisElement);

		    WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 90);
		    WaitUtil.waitForPageToLoad(driver, 90);

		    // ⭐ NEW IMPORTANT WAIT ⭐
		    WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);


		// 7️⃣ Click video tab
		WaitUtil.waitAndClick(driver, videoTab, 60);
	}

	// =========================================================
	// PREVIEW VIDEO TEMPLATE
	// =========================================================

	public void previewVideoTemplate() throws Exception {

		WaitUtil.waitForPageToLoad(driver, 30);
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);

		WaitUtil.waitAndClick(driver, previewIcon, 60);

		Thread.sleep(2000); // wait for new tab to open
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		String originalWindow = driver.getWindowHandle();

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.close();
		driver.switchTo().window(originalWindow);
		Thread.sleep(2000);
	}

	// =========================================================
	// DOWNLOAD HTML / IMAGE / HISTORY
	// =========================================================

	public void downloadEmailTemplate() throws Exception {

		WaitUtil.waitForPageToLoad(driver, 30);
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
		// HTML
		WaitUtil.waitAndClick(driver, downloadMenu, 40);
		WaitUtil.waitAndClick(driver, downloadHtml, 40);

//        // PDF
//        WaitUtil.waitAndClick(driver, downloadMenu, 40);
//        WaitUtil.waitAndClick(driver, downloadPdf, 40);

		// IMAGE
		WaitUtil.waitAndClick(driver, downloadMenu, 40);
		WaitUtil.waitAndClick(driver, downloadImage, 40);

		Thread.sleep(3000);
		WaitUtil.waitForPageToLoad(driver, 80);
		WaitUtil.waitAndClick(driver, downloadHistory, 40);
		WaitUtil.waitAndClick(driver, downloadHistoryClose, 40);
	}

	

	// =========================================================
	// FILL DETAILS
	// =========================================================

	public void fillVideoCampaignDetails(String name) throws InterruptedException {

		// Wait for backdrop overlays to disappear
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
		WaitUtil.waitForInvisibilityOfElement(By.cssSelector("div.modal-backdrop"), driver, 60);
		Thread.sleep(500); // animation delay

		// Scroll to the element
		WebElement icon = WaitUtil.waitForElementClickable(driver, redistributeIcon, 60);

		// Try normal click; fall back to JS click if intercepted
		try {
			icon.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", icon);
		}

		WebElement title = WaitUtil.waitForElementVisible(driver, campaignTitle, 60);
		title.clear();
		title.sendKeys(name + "_" + System.currentTimeMillis());

		WebElement subject = WaitUtil.waitForElementVisible(driver, subjectLine, 60);
		subject.clear();
		subject.sendKeys("subject for redistributed video campaign");
	}

	// =========================================================
	// SELECT CONTACT LIST
	// =========================================================

	public void selectVideoContacts() {

		WaitUtil.waitAndClick(driver, selectButton, 60);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");

		WaitUtil.waitForElementVisible(driver, searchContact, 60);
		ElementUtil.sendText(searchContact, "gayatri", driver);

		WaitUtil.waitForElementVisible(driver, selectAllContacts, 60);
		WaitUtil.waitAndClick(driver, selectAllContacts, 60);
	}
}
