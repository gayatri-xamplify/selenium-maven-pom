package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.RedistributeEmailCampaignPage;
import com.stratapps.xamplify.pages.ScheduleRedistributeEmailCampaignPage;

public class ScheduleRedistributeEmailCampaignTest extends BaseTest {

    private RedistributeEmailCampaignPage redistributeemailPage;
    private ScheduleRedistributeEmailCampaignPage scheduleRedistributeEmailCampaignPage;

    private static final Logger logger = LogManager.getLogger(ScheduleRedistributeEmailCampaignTest.class);
    private WebDriverWait wait;

    @BeforeClass
    public void setUpClass() {

        try {
            redistributeemailPage = new RedistributeEmailCampaignPage(driver);
            scheduleRedistributeEmailCampaignPage = new ScheduleRedistributeEmailCampaignPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            logger.info("RedistributeScheduleEmailCampaignTest setup completed");
        } catch (Exception e) {
            System.out.println("Multi-class Setup: Ignored");
        }

        try {
            super.setUp();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginAsPartner();

            redistributeemailPage = new RedistributeEmailCampaignPage(driver);
            scheduleRedistributeEmailCampaignPage = new ScheduleRedistributeEmailCampaignPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        } catch (Exception e) {
            System.out.println("Single Class Setup Failed");
        }
    }

    // =====================================================
    //   TEST: Complete Redistribute + Schedule Flow
    // =====================================================

    @Test(priority = 1)
    public void testRedistributeEmailSchedule() throws Exception {

        logger.info("Step 1: Open Redistribute Flow");
        redistributeemailPage.openRedistributeEmailCampaign();
        redistributeemailPage.previewEmailTemplate();
        redistributeemailPage.downloadEmailTemplate();
        redistributeemailPage.fillCampaignDetails("redistribute_email_campaign");
        redistributeemailPage.selectContacts();
        logger.info("Step 2: Schedule Campaign");
        boolean result = scheduleRedistributeEmailCampaignPage.scheduleRedistributionEmail("103"); // India
        if (result) {
            logger.info("Email Campaign Redistributed & Scheduled Successfully");
        } else {
            logger.error("Email Campaign Redistribution Schedule Failed");
        }
        
        redistributeemailPage.backToHome();

    }
    
    
}

