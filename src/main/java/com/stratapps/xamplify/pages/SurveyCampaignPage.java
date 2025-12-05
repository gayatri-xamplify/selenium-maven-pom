package com.stratapps.xamplify.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;
import com.stratapps.xamplify.utils.DropdownUtil;

public class SurveyCampaignPage {

    private WebDriver driver;

    public SurveyCampaignPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By campaignHover = By.xpath("//span[@class='title'][contains(text(),'Campaign')]");
    private By createCampaign = By.xpath("//span[contains(@class,'title')][contains(text(),'Create Campaign')]");
    private By openSurveyCampaign = By.xpath("//h4[normalize-space()='Survey']");
    private By campaignName = By.id("campaignName");
    private By throughPartner = By.xpath("//span[@class='bootstrap-switch-handle-off bootstrap-switch-success']");
    private By subjectLine = By.id("subjectLineId");
    private By preheader = By.id("preHeader");
    private By notifyWorkflow = By.xpath("(//span[@class='bootstrap-switch-label'])[6]");
    private By notifyMeOpened = By.xpath("(//span[@class='bootstrap-switch-label'])[7]");
    private By notifyMeLinkClick = By.xpath("(//span[@class='bootstrap-switch-label'])[8]");
    private By templateSearch = By.xpath("//div[@id='campaign-details']//input[@placeholder='Search here']");
    private By templateSelect = By.xpath("//input[@class='radio-custimization pointer radioButton_shadow']");
    private By clickSendTestEmail = By.xpath("(//button[.//span[contains(text(),'Send Test Email')]])[1]");
    private By sendTextEmail = By.xpath("//input[@placeholder='Please Enter Email Address']");
    private By sendTextEmailSubject = By.xpath("//input[@placeholder='Please Enter Email Subject']");
    private By sendEmailButton = By.xpath("//div[@id='send-test-email-modal-popup']//button[2]/span");
    private By emailSentPopup = By.xpath("//button[contains(text(),'OK')]");
    private By templatePreview = By.xpath("//i[@class='fa fa-external-link-square preview-edit-color tooltip-cls']");
    private By nextBtn = By.xpath("//button[@class='btn btn-primary pull-right'][contains(text(),'Next')]");
    private By partnerDropdown = By.xpath("//*[@id='user-list-div']//select");
    private By searchPartnerList = By.xpath("//*[@id='user-list-div']//input[@placeholder='Search here']");
    private By partnerListPreview = By.xpath("(//i[@class='fa fa-eye IconCustomization campaignViewIcon'])[2]");
    private By closePartnerPreview = By.xpath("//div[@id='userListUsersPreviewPopup']//button");
    private By selectPartnerGroup = By.xpath("//div[@class='table-responsive']//tbody//td//input[@lang='Active']");
    private By backdrop = By.cssSelector("div.backdrop");

    // ==========================
    //   Create Survey Campaign
    // ==========================
    public void createSurveyCampaign(String name, String subject, String preHeader, String Survey, String SurveySubject) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // 1️⃣ Hover and click Campaign menu
        WaitUtil.waitForElementVisible(driver, campaignHover, 60);
        ElementUtil.hoverAndClick(driver.findElement(campaignHover), driver);
        WaitUtil.waitAndClick(driver, createCampaign, 60);
        WaitUtil.waitAndClick(driver, openSurveyCampaign, 60);

        // 2️⃣ Wait for Campaign Name input and handle overlay
        WaitUtil.waitForPageToLoad(driver, 60);
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(campaignName));
        WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input);
        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", input);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", input);
        input.sendKeys(name + "_" + System.currentTimeMillis());

        WaitUtil.waitForPageToLoad(driver, 120);

        // 3️⃣ Toggle 'Through Partner' safely
        try {
            WaitUtil.waitForElementClickable(driver, throughPartner, 30);
            ElementUtil.click(throughPartner, driver);
        } catch (ElementClickInterceptedException e) {
            WebElement toggle = driver.findElement(throughPartner);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", toggle);
        }   
        // 4️⃣ Subject + Preheader
        ElementUtil.sendText(subjectLine, subject, driver);
        ElementUtil.sendText(preheader, preHeader, driver);
        WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
        // 5️⃣ Enable Notification settings
        ElementUtil.click(notifyWorkflow, driver);
        ElementUtil.click(notifyMeOpened, driver);
        ElementUtil.click(notifyMeLinkClick, driver);

        // 6️⃣ Select Survey Template
        WaitUtil.waitForElementVisible(driver, templateSearch, 60);
        ElementUtil.sendText(templateSearch, "Survey", driver);
        ElementUtil.sendKey(templateSearch, Keys.ENTER, driver);
        WaitUtil.waitAndClick(driver, templateSelect, 60);
        WaitUtil.waitForPageToLoad(driver, 60);

        // 7️⃣ Send Test Survey
        WaitUtil.waitForElementClickable(driver, clickSendTestEmail, 60);
        try {
            ElementUtil.click(clickSendTestEmail, driver);
        } catch (ElementClickInterceptedException e) {
            WebElement btn = driver.findElement(clickSendTestEmail);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        }

        WaitUtil.waitForElementVisible(driver, sendTextEmail, 60);
        ElementUtil.sendText(sendTextEmail, Survey, driver);
        ElementUtil.sendKey(sendTextEmail, Keys.ENTER, driver);
        ElementUtil.sendText(sendTextEmailSubject, SurveySubject, driver);
        ElementUtil.sendKey(sendTextEmailSubject, Keys.ENTER, driver);

        WaitUtil.waitAndClick(driver, sendEmailButton, 60);
        WaitUtil.waitAndClick(driver, emailSentPopup, 60);

        // 8️⃣ Template Preview and Proceed
        ElementUtil.previewhandlingtemplate(templatePreview, driver);
        WaitUtil.waitAndClick(driver, nextBtn, 60);
    }

    // ==========================
    //   Select Partner List
    // ==========================
    public void selectPartnerList() {
        WaitUtil.waitForPageToLoad(driver, 90);
        WaitUtil.waitForVisibility(driver, partnerDropdown, 60);
        DropdownUtil.selectByVisibleText(driver, partnerDropdown, "Count(ASC)");

        WaitUtil.waitForVisibility(driver, searchPartnerList, 60);
        ElementUtil.sendText(searchPartnerList, "Active", driver);
        ElementUtil.sendKey(searchPartnerList, Keys.ENTER, driver);
        WaitUtil.waitForPageToLoad(driver, 60);

        WaitUtil.waitAndClick(driver, partnerListPreview, 60);
        WaitUtil.waitAndClick(driver, closePartnerPreview, 60);
        WaitUtil.waitAndClick(driver, selectPartnerGroup, 60);

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    }
}

