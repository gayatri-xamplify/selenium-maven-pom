package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.RedistributeEventCampaignPage;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class RedistributeEventCampaignTest extends BaseTest {

    private RedistributeEventCampaignPage redistributeEventCampaignPage;
    private static final Logger logger = LogManager.getLogger(RedistributeEventCampaignTest.class);
    private WebDriverWait wait;

    @BeforeClass
    public void setUpClass() {

        try {
            redistributeEventCampaignPage = new RedistributeEventCampaignPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            logger.info("RedistributeEventCampaignTest setup completed");
        } catch (Exception e) {
            System.out.println("Multiclass Setup: Ignored");
        }

        try {
            super.setUp();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginAsPartner();

            redistributeEventCampaignPage = new RedistributeEventCampaignPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        } catch (Exception e) {
            System.out.println("Single Class Setup Failed");
        }
    }

    // =====================================================
    //   TEST: Complete Redistribute Event Campaign Flow
    // =====================================================

    @Test(priority = 1)
    public void testRedistributeEventCampaign() throws Exception {

        logger.info("Step 1: Open Redistribute Event Flow");
        redistributeEventCampaignPage.openRedistributeEventCampaign();
        redistributeEventCampaignPage.previewEventTemplate();
       redistributeEventCampaignPage.downloadEmailTemplate();

      
        logger.info("Step 2: Select Contacts");
        redistributeEventCampaignPage.selectContacts();

        logger.info("Event Redistribution Test Completed Successfully");
    }
}
