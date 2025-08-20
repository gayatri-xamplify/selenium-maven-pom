package com.stratapps.xamplify.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.stratapps.xamplify.utils.ActionUtil;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;
import com.stratapps.xamplify.utils.DropdownUtil;

import java.util.ArrayList;

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
    private By clickSendTestEmail = By.xpath("//*[@id='campaign-details']/div[2]/div/div/fieldset/div[1]/div[3]/button/span");
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
        WaitUtil.waitForElementVisible(driver, campaignHover, 60);
        WebElement campaignElement = driver.findElement(campaignHover);
        ElementUtil.hoverAndClick(campaignElement, driver);

        WaitUtil.waitAndClick(driver, createCampaign, 60);
        WaitUtil.waitAndClick(driver, openEmailCampaign, 60);

        WaitUtil.waitForElementVisible(driver, campaignName, 60);
        ElementUtil.sendText(campaignName, name + System.currentTimeMillis(), driver);

        ElementUtil.click(throughPartner, driver);
        ElementUtil.sendText(subjectLine, subject, driver);
        ElementUtil.sendText(preheader, preHeader, driver);

        ElementUtil.click(notifyWorkflow, driver);
        ElementUtil.click(notifyMeOpened, driver);
        ElementUtil.click(notifyMeLinkClick, driver);

        // Scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(document.body.scrollHeight, 300)");
        WaitUtil.waitForElementVisible(driver, templateSearch, 60);

        ElementUtil.sendText(templateSearch, "email", driver);
        ElementUtil.sendKey(templateSearch, Keys.ENTER, driver);

        WaitUtil.waitAndClick(driver, templateSelect, 60);
        
        WaitUtil.waitForPageToLoad(driver, 80);
        WaitUtil.waitForElementVisible(driver, clickSendTestEmail, 60);
        ElementUtil.clickWhenReady(driver, clickSendTestEmail, 30);
        //WaitUtil.waitAndClick(driver, clickSendTestEmail, 60);
        ElementUtil.clickWhenReady(driver, sendTextEmail, 30);

        ElementUtil.sendText(sendTextEmail, email, driver);
        ElementUtil.sendKey(sendTextEmail, Keys.ENTER, driver);
        ElementUtil.sendText(sendTextEmailSubject, emailSubject, driver);
        ElementUtil.sendKey(sendTextEmailSubject, Keys.ENTER, driver);

        WaitUtil.waitAndClick(driver, sendEmailButton, 60);
        WaitUtil.waitAndClick(driver, emailSentPopup, 60);

        ElementUtil.clickWhenReady(driver, templatePreview, 30);

        //ElementUtil.click(templatePreview, driver);

        WaitUtil.waitForNewTabAndSwitch(driver);
        driver.close();
        WaitUtil.switchToMainTab(driver);

        ElementUtil.click(nextBtn, driver);
    }

    public void selectPartnerList() {
        WaitUtil.waitForVisibility(driver, partnerDropdown, 60);
        DropdownUtil.selectByVisibleText(driver, partnerDropdown, "Count(DESC)");

        ElementUtil.sendText(searchPartnerList, "Active", driver);
        ElementUtil.sendKey(searchPartnerList, Keys.ENTER, driver);
        WaitUtil.waitForPageToLoad(driver, 60);

        ElementUtil.click(partnerListPreview, driver);
        WaitUtil.waitForPageToLoad(driver, 60);
        ElementUtil.click(closePartnerPreview, driver);

        ElementUtil.click(selectPartnerGroup, driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    }
}
