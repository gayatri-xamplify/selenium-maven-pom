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
	// DOWNLOAD HTML / IMAGE / HISTORY
	// =========================================================

	 private void jsClick(WebElement element) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	    }
	public void downloadEmailTemplate() throws Exception {


		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		    WaitUtil.waitForPageToLoad(driver, 60);
		    WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);

		    // Locate download menu
		    WebElement menu = wait.until(ExpectedConditions.presenceOfElementLocated(downloadMenu));

		    // Scroll to center to avoid top-bar overlap
		    ((JavascriptExecutor) driver)
		            .executeScript("arguments[0].scrollIntoView({block:'center'});", menu);
		    Thread.sleep(600);
		  

		    // ⭐ 1) CLICK MENU (JS prevents intercepted errors)
		    jsClick(menu);

		    // ⭐ 2) DOWNLOAD HTML
		    WebElement html = wait.until(ExpectedConditions.elementToBeClickable(downloadHtml));
		    jsClick(html);
		    Thread.sleep(800);

		    // ⭐ 3) DOWNLOAD IMAGE
		    jsClick(menu);  // reopen dropdown
		    WebElement image = wait.until(ExpectedConditions.elementToBeClickable(downloadImage));
		    jsClick(image);
		    Thread.sleep(800);

		    // ⭐ 4) DOWNLOAD HISTORY → OPEN
		    WebElement history = wait.until(ExpectedConditions.elementToBeClickable(downloadHistory));
		    jsClick(history);
		    Thread.sleep(600);

		    // ⭐ 5) CLOSE HISTORY POPUP
		    WebElement close = wait.until(ExpectedConditions.elementToBeClickable(downloadHistoryClose));
		    jsClick(close);

		    Thread.sleep(800);
		

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
	

	 private By Gotohome =By.xpath("//img[@class='cls-pointer']");
	 public void backToHome() {


		    // 1️ Handle SweetAlert safely
		    WaitUtil.handleSweetAlertIfPresent(driver, 2);
		    // 2 Now wait for HOME icon (real signal)
		    WaitUtil.waitForElementClickable(driver, Gotohome, 30);
		    WaitUtil.waitAndClick(driver, Gotohome, 30);

		    WaitUtil.waitForPageToLoad(driver, 60);
		}

	 
	 
}
