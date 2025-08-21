package com.stratapps.xamplify.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;
import com.stratapps.xamplify.utils.DropdownUtil;


public class EmailCampaignPage {
    private WebDriver driver;

    public EmailCampaignPage(WebDriver driver) {
        this.driver = driver;
    }
    
    
    // Locators
    private By campaignHover = By.xpath("//span[@class='title'][contains(text(),'Campaign')]");
    private By createCampaign = By.xpath("//span[contains(@class,'title')][contains(text(),'Create Campaign')]");
    private By openEmailCampaign = By.xpath("//h4[contains(text(),'E-mail')]");
    private By campaignName = By.xpath("//input[@id='campaignName']");
    private By throughPartner = By.xpath("//span[@class='bootstrap-switch-handle-off bootstrap-switch-success']");
    private By subjectLine = By.xpath("//*[@id='subjectLineId']");
    private By preheader = By.xpath("//input[@id='preHeader']");
    private By notifyWorkflow = By.xpath("(//span[@class='bootstrap-switch-label'])[6]");
    private By notifyMeOpened = By.xpath("(//span[@class='bootstrap-switch-label'])[7]");
    private By notifyMeLinkClick = By.xpath("(//span[@class='bootstrap-switch-label'])[8]");
    private By templateSearch = By.xpath("//div[@id='campaign-details']/div[2]/div/div/fieldset/div[1]/div[1]/input");
    private By templateSelect = By.xpath("//div[@id='campaign-details']/div[2]/div/div/fieldset/div[1]/div[4]/div/form/div/div/div/div/span[1]/label/input");
    private By clickSendTestEmail = By.xpath("(//button[.//span[contains(text(),'Send Test Email')]])[1]");
    private By sendTextEmail = By.xpath("//input[@placeholder='Please Enter Email Address']");
    private By sendTextEmailSubject = By.xpath("//input[@placeholder='Please Enter Email Subject']");
    private By sendEmailButton = By.xpath("//div[@id='send-test-email-modal-popup']/div/div/div[3]/button[2]/span");
    private By emailSentPopup = By.xpath("//button[contains(text(),'OK')]");
    private By templatePreview = By.xpath("//*[@id='campaign-details']/div[2]/div/div/fieldset/div[1]/div[4]/div/form/div/div/div/div/span[2]/a/i");
    private By nextBtn = By.xpath("//button[@class='btn btn-primary pull-right'][contains(text(),'Next')]");
    private By partnerDropdown = By.xpath("//*[@id='user-list-div']/div/div/fieldset/div/div[1]/div[1]/div[2]/select");
    private By searchPartnerList = By.xpath("//*[@id='user-list-div']/div/div/fieldset/div/div[1]/div[1]/div[1]/input");
    private By partnerListPreview = By.xpath("(//i[@class='fa fa-eye IconCustomization campaignViewIcon'])[2]");
    private By closePartnerPreview = By.xpath("//div[@id='userListUsersPreviewPopup']/div/div/div[1]/button");
    private By selectPartnerGroup = By.xpath("//div[@class='table-responsive']//tbody//td//input[@lang='Active']");
    private By backdrop = By.cssSelector("div.backdrop");

    public void createEmailCampaign(String name, String subject, String preHeader, String email, String emailSubject) {
        // Hover and click Campaign menu
        WaitUtil.waitForElementVisible(driver, campaignHover, 60);
        ElementUtil.hoverAndClick(driver.findElement(campaignHover), driver);
        

        // Create campaign flow
        WaitUtil.waitAndClick(driver, createCampaign, 60);
        WaitUtil.waitAndClick(driver, openEmailCampaign, 60);
       
        
        
        WaitUtil.waitForElementVisible(driver, campaignName, 60);
        
        ElementUtil.sendText(campaignName, name + System.currentTimeMillis(), driver);

        // Subject + Preheader
        ElementUtil.click(throughPartner, driver);
        ElementUtil.sendText(subjectLine, subject, driver);
        ElementUtil.sendText(preheader, preHeader, driver);

        // Notification settings
        ElementUtil.click(notifyWorkflow, driver);
        ElementUtil.click(notifyMeOpened, driver);
        ElementUtil.click(notifyMeLinkClick, driver);

        // Scroll into view for template search (instead of hardcoded JS scroll)
       // ElementUtil.scrollToElement(driver.findElement(templateSearch), driver);

        //ElementUtil.scrollToElement(templateSearch, driver);
        WaitUtil.waitForElementVisible(driver, templateSearch, 60);

        // Search and select template
        ElementUtil.sendText(templateSearch, "email", driver);
        ElementUtil.sendKey(templateSearch, Keys.ENTER, driver);
        WaitUtil.waitAndClick(driver, templateSelect, 60);

        // Send Test Email
        WaitUtil.waitForElementClickable(driver, clickSendTestEmail, 60);
        ElementUtil.clickWithRetry(clickSendTestEmail, driver, 3);

        WaitUtil.waitForElementVisible(driver, sendTextEmail, 60);
        ElementUtil.sendText(sendTextEmail, email, driver);
        ElementUtil.sendKey(sendTextEmail, Keys.ENTER, driver);

        ElementUtil.sendText(sendTextEmailSubject, emailSubject, driver);
        ElementUtil.sendKey(sendTextEmailSubject, Keys.ENTER, driver);

        // Send email
        WaitUtil.waitAndClick(driver, sendEmailButton, 60);
        WaitUtil.waitAndClick(driver, emailSentPopup, 60);

        // Handle preview + proceed
        ElementUtil.previewhandlingtemplate(templatePreview, driver);
        WaitUtil.waitAndClick(driver, nextBtn, 60);
    }

    public void selectPartnerList() {
    	
    	WaitUtil.waitForPageToLoad(driver, 90);
        WaitUtil.waitForVisibility(driver, partnerDropdown, 60);
        DropdownUtil.selectByVisibleText(driver, partnerDropdown, "Count(ASC)");

        WaitUtil.waitForVisibility(driver, searchPartnerList, 60);

        ElementUtil.sendText(searchPartnerList, "Active", driver);
        ElementUtil.sendKey(searchPartnerList, Keys.ENTER, driver);
        WaitUtil.waitForPageToLoad(driver, 60);
        WaitUtil.waitForVisibility(driver, partnerListPreview, 60);

        ElementUtil.click(partnerListPreview, driver);
        WaitUtil.waitForPageToLoad(driver, 60);
        WaitUtil.waitAndClick(driver, closePartnerPreview, 70);
       // ElementUtil.click(closePartnerPreview, driver);

        ElementUtil.click(selectPartnerGroup, driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    }
}
