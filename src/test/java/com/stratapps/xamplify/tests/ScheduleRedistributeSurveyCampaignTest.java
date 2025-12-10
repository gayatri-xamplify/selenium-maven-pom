package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.RedistributeSurveyCampaignPage;
import com.stratapps.xamplify.pages.ScheduleRedistributeSurveyCampaignPage;

public class ScheduleRedistributeSurveyCampaignTest extends BaseTest {

    private RedistributeSurveyCampaignPage redistributeSurveyPage;
    private ScheduleRedistributeSurveyCampaignPage scheduleRedistributeSurveyCampaignPage;

    private static final Logger logger = LogManager.getLogger(ScheduleRedistributeSurveyCampaignTest.class);
    private WebDriverWait wait;

    @BeforeClass
    public void setUpClass() {

        try {
            redistributeSurveyPage = new RedistributeSurveyCampaignPage(driver);
            scheduleRedistributeSurveyCampaignPage = new ScheduleRedistributeSurveyCampaignPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            logger.info("RedistributeScheduleSurveyCampaignTest setup completed");
        } catch (Exception e) {
            System.out.println("Multi-class Setup: Ignored");
        }

        try {
            super.setUp();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginAsPartner();

            redistributeSurveyPage = new RedistributeSurveyCampaignPage(driver);
            scheduleRedistributeSurveyCampaignPage = new ScheduleRedistributeSurveyCampaignPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        } catch (Exception e) {
            System.out.println("Single Class Setup Failed");
        }
    }

    // =====================================================
    //   TEST: Complete Redistribute + Schedule Flow
    // =====================================================

    @Test(priority = 1)
    public void testRedistributeSurveySchedule() throws Exception {

        logger.info("Step 1: Open Redistribute Flow");
        redistributeSurveyPage.openRedistributeSurveyCampaign();
        redistributeSurveyPage.previewSurveyTemplate();
        redistributeSurveyPage.downloadSurveyTemplate();
        redistributeSurveyPage.fillCampaignDetails("redistribute_Survey_campaign");
        redistributeSurveyPage.selectContacts();
        logger.info("Step 2: Schedule Campaign");
        boolean result = scheduleRedistributeSurveyCampaignPage.scheduleRedistributionSurvey("103"); // India
        if (result) {
            logger.info("Survey Campaign Redistributed & Scheduled Successfully");
        } else {
            logger.error("Survey Campaign Redistribution Schedule Failed");
        }
        
        redistributeSurveyPage.backToHome();

    }
    
    
}

