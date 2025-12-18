package com.stratapps.xamplify.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ElementClickInterceptedException;

import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;
import com.stratapps.xamplify.utils.DropdownUtil;

public class VideoCampaignPage {
    private WebDriver driver;

    public VideoCampaignPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By campaignHover = By.xpath("//span[@class='title'][contains(text(),'Campaign')]");
    private By createCampaign = By.xpath("//span[contains(@class,'title')][contains(text(),'Create Campaign')]");
    private By openVideoCampaign = By.xpath("//h4[contains(text(),'Video')]");
    private By campaignName = By.id("campaignName");
    private By throughPartner = By.xpath("//span[@class='bootstrap-switch-handle-off bootstrap-switch-success']");
    private By subjectLine = By.id("subjectLineId");
    private By preheader = By.name("preHeader");
    private By notifyWorkflow = By.xpath("(//span[@class='bootstrap-switch-label'])[5]");
    private By notifyMeOpened = By.xpath("(//span[@class='bootstrap-switch-label'])[6]");
    private By notifyMeLinkClick = By.xpath("(//span[@class='bootstrap-switch-label'])[7]");
    private By notifyMeVideo = By.xpath("(//span[@class='bootstrap-switch-label'])[8]");
    private By dropdownSort = By.xpath("(//select[@id='select-dropdown'])[1]");
    private By searchVideo = By.xpath("(//input[@placeholder='Search here'])[1]");
    private By searchVideoClick = By.xpath("(//i[@class='fa fa-search cesf-xamp'])[1]");
    private By videoCategory = By.xpath("//select[@class='select_filter form-control']");
    private By selectVideo1 = By.xpath("//input[@name='videoFileId']");
    private By searchTemplate = By.xpath("(//input[@placeholder='Search here'])[2]");
    private By searchTemplateClick = By.xpath("(//i[@class='fa fa-search cesf-xamp'])[2]");
    private By selectTemplate = By.xpath("//input[@class='radio-custimization pointer radioButton_shadow']");
    private By clickSendTestEmail = By.xpath("(//button[normalize-space()='Send Test Email'])[1]");
    private By sendTextEmail = By.xpath("//input[@placeholder='Please Enter Email Address']");
    private By sendTextEmailSubject = By.xpath("//input[@placeholder='Please Enter Email Subject']");
    private By sendEmailButton = By.xpath("//div[@id='send-test-email-modal-popup']//button[2]/span");
    private By emailSentPopup = By.xpath("//button[contains(text(),'OK')]");
    private By templatePreview = By.xpath("//i[@class='fa fa-external-link-square preview-edit-color tooltip-cls']");
    private By nextBtn = By.xpath("//button[@class='btn btn-primary pull-right'][contains(text(),'Next')]");
    private By partnerDropdown = By.xpath("//*[@id='user-list-div']//select");
    private By searchPartnerList = By.xpath("(//input[@placeholder='Search here'])[3]");
    private By searchPartnerListClick = By.xpath("//div[@class='table-responsive']//tbody//td//input[@lang='Active']");
    private By partnerListPreview = By.xpath("(//i[@class='fa fa-eye IconCustomization campaignViewIcon'])[2]");
    private By closePartnerPreview = By.xpath("//button[@class='btn Btn-Gray']");
    private By backdrop = By.cssSelector("div.backdrop");

    public void createVideoCampaign(String subject, String preHeader, String email, String emailSubject) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // 1️⃣ Open Campaign section
        WaitUtil.waitForElementVisible(driver, campaignHover, 60);
        ElementUtil.hoverAndClick(driver.findElement(campaignHover), driver);
        WaitUtil.waitAndClick(driver, createCampaign, 60);
        WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);

        WaitUtil.waitAndClick(driver, openVideoCampaign, 60);

        // 2️⃣ Campaign name input
        WaitUtil.waitForPageToLoad(driver, 60);
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(campaignName));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", input);
        input.sendKeys("video Campaign_" + System.currentTimeMillis());
        WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);

        // 3️⃣ Handle 'Through Partner' toggle (prevent intercepted click)
        try {
            WaitUtil.waitForElementClickable(driver, throughPartner, 30);
            ElementUtil.click(throughPartner, driver);
        } catch (ElementClickInterceptedException e) {
            WebElement toggle = driver.findElement(throughPartner);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", toggle);
        }
        // 4️ Fill subject + preheader
        ElementUtil.sendText(subjectLine, subject, driver);
        ElementUtil.sendText(preheader, preHeader, driver);
        WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
        // 5️⃣ Enable notification toggles
        ElementUtil.click(notifyWorkflow, driver);
        ElementUtil.click(notifyMeOpened, driver);
        ElementUtil.click(notifyMeLinkClick, driver);
        ElementUtil.click(notifyMeVideo, driver);
        // 6️⃣ Select video
        WaitUtil.waitForElementVisible(driver, dropdownSort, 60);
        DropdownUtil.selectByValue(driver, dropdownSort, "3: Object");

        WaitUtil.waitForElementVisible(driver, searchVideo, 60);
        ElementUtil.sendText(searchVideo, "video", driver); 
        ElementUtil.sendKey(searchVideo, Keys.ENTER, driver); 
        WaitUtil.waitAndClick(driver, searchVideoClick, 60);
        WaitUtil.waitForElementVisible(driver, videoCategory, 60); 
        DropdownUtil.selectByValue(driver, videoCategory, "108"); 
        WaitUtil.waitAndClick(driver, selectVideo1, 60);

        // 7️⃣ Select template
        WaitUtil.waitForElementVisible(driver, searchTemplate, 60);
        ElementUtil.sendText(searchTemplate, "video", driver);
        ElementUtil.sendKey(searchTemplate, Keys.ENTER, driver);
        WaitUtil.waitAndClick(driver, searchTemplateClick, 60);
        WaitUtil.waitAndClick(driver, selectTemplate, 60);
        WaitUtil.waitForPageToLoad(driver, 60);

        // 8️⃣ Send test email
        WaitUtil.waitAndClick(driver, clickSendTestEmail, 60);
        WaitUtil.waitForElementVisible(driver, sendTextEmail, 60);
        ElementUtil.sendText(sendTextEmail, email, driver);
        ElementUtil.sendKey(sendTextEmail, Keys.ENTER, driver);
        ElementUtil.sendText(sendTextEmailSubject, emailSubject, driver);
        ElementUtil.sendKey(sendTextEmailSubject, Keys.ENTER, driver);

        WaitUtil.waitAndClick(driver, sendEmailButton, 60);
        WaitUtil.waitAndClick(driver, emailSentPopup, 60);

        // 9️⃣ Handle template preview and next step
        ElementUtil.previewhandlingtemplate(templatePreview, driver);
        WaitUtil.waitAndClick(driver, nextBtn, 60);
    }

    public void selectPartnerList() {
        WaitUtil.waitForPageToLoad(driver, 90);
        WaitUtil.waitForVisibility(driver, partnerDropdown, 60);
        DropdownUtil.selectByVisibleText(driver, partnerDropdown, "Count(DESC)");

        WaitUtil.waitForVisibility(driver, searchPartnerList, 60);
        ElementUtil.sendText(searchPartnerList, "Active", driver);
        ElementUtil.sendKey(searchPartnerList, Keys.ENTER, driver);
        WaitUtil.waitForPageToLoad(driver, 60);

        WaitUtil.waitAndClick(driver, searchPartnerListClick, 60);
        WaitUtil.waitAndClick(driver, partnerListPreview, 60);
        WaitUtil.waitAndClick(driver, closePartnerPreview, 60);

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    }

}
