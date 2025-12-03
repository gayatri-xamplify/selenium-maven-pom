package com.stratapps.xamplify.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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

public class RedistributeEmailCampaignPage {

    private WebDriver driver;

    public RedistributeEmailCampaignPage(WebDriver driver) {
        this.driver = driver;
    }

    // =========================================================
    //                      LOCATORS 
    // =========================================================
    private By campaignHover = By.xpath("//span[text()='Campaign']");
    private By redistributeCampaign = By.xpath("//span[text()='Redistribute Campaign']");
    private By emailTab = By.xpath("//li[contains(text(),'Email')]");

    // Preview
    private By previewIcon = By.xpath("//*[@id='redistribute-campaign-list']/tbody/tr[1]/td[5]/div/a[1]/i");

    // Download
    private By downloadMenu = By.xpath("(//span[@id='download-drop'])[1]");
    private By downloadHtml = By.xpath("(//*[@id='download-template']/ul/li[1]/a)[1]");
    private By downloadImage = By.xpath("(//*[@id='download-template']/ul/li[3]/a)[1]");
    private By downloadHistory = By.xpath("(//i[@class='fa fa-history IconCustomization'])[1]");
    private By downloadHistoryClose = By.xpath("//button[@class='btn Btn-Gray']");

    // Redistribute icon for editing
    private By redistributeIcon = By.xpath("//*[@id='redistribute-campaign-list']/tbody/tr[1]/td[5]/div/span/a[1]/i");

    // Campaign fields
    private By campaignTitle = By.xpath("//input[@id='campaignName']");
    private By subjectLine = By.xpath("//input[@placeholder='{merge tag} + Subject line']");

    // Contact selection
    private By selectButton = By.xpath("//span[contains(text(),'Select')]");
    private By searchContact = By.xpath("//*[@id=\"user_list_tb_wrapper\"]/div[1]/div[2]/div/div/div/input");
    private By searchIcon = By.xpath("//button[@class='search-box-item-click']");
    private By selectAllContacts = By.xpath("//input[@id='checkAllExistingContacts']");
	private By backdrop = By.cssSelector("div.backdrop");

    // =========================================================
    //                     MAIN ACTIONS
    // =========================================================

    public void openRedistributeEmailCampaign() {
        WaitUtil.waitForElementVisible(driver, campaignHover, 60);
        ElementUtil.hoverAndClick(driver.findElement(campaignHover), driver);

        WaitUtil.waitAndClick(driver, redistributeCampaign, 60);
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);

        WaitUtil.waitAndClick(driver, emailTab, 60);
    }

    // =========================================================
    //                   PREVIEW TEMPLATE
    // =========================================================

    public void previewEmailTemplate() throws Exception {

    	WaitUtil.waitForPageToLoad(driver, 30);
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
        WaitUtil.waitAndClick(driver, previewIcon, 60);
        Thread.sleep(3000); // Wait for new tab to open
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        String original = driver.getWindowHandle();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(original);
    }

    // =========================================================
    //                  DOWNLOAD HTML / IMAGE / HISTORY
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
    }

    // =========================================================
    //                  REDISTRIBUTE ACTION
    // =========================================================

    public void fillCampaignDetails(String name) {
    	
    	WaitUtil.waitForPageToLoad(driver, 30);
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
        WaitUtil.waitAndClick(driver, redistributeIcon, 60);

        WebElement title = WaitUtil.waitForElementVisible(driver, campaignTitle, 60);
        title.clear();
        title.sendKeys(name + "_" + System.currentTimeMillis());

        WebElement subject = WaitUtil.waitForElementVisible(driver, subjectLine, 60);
        subject.clear();
        subject.sendKeys("subject for redistributed email campaign");
    }

    // =========================================================
    //                SELECT CONTACT LIST
    // =========================================================

    public void selectContacts() {

        WaitUtil.waitAndClick(driver, selectButton, 60);

        WaitUtil.waitForPageToLoad(driver, 30);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);"); // scrolls 500px down
        WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
        WaitUtil.waitForElementVisible(driver, searchContact, 60);
        ElementUtil.sendText(searchContact, "gayatri", driver);
        WaitUtil.waitAndClick(driver, searchIcon, 60);

        WaitUtil.waitAndClick(driver, selectAllContacts, 60);
    }
}
