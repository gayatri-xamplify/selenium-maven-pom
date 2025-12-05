package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.RedistributeSurveyCampaignPage;
import com.stratapps.xamplify.pages.SaveRedistributeSurveyCampaignPage;

public class SaveRedistributeSurveyCampaignTest extends BaseTest {

    private RedistributeSurveyCampaignPage redistributeSurveyPage;
    private SaveRedistributeSurveyCampaignPage saveRedistributeSurveyCampaignPage;

    private static final Logger logger = LogManager.getLogger(SaveRedistributeSurveyCampaignTest.class);
    private WebDriverWait wait;

    @BeforeClass
    public void setUpClass() {
        try {
            redistributeSurveyPage = new RedistributeSurveyCampaignPage(driver);
            saveRedistributeSurveyCampaignPage = new SaveRedistributeSurveyCampaignPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            logger.info("SaveRedistributeSurveyCampaignTest setup completed");
        } catch (Exception e) {
            System.out.println("Multi-class setup ignored");
        }

        try {
            super.setUp();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginAsPartner();

            redistributeSurveyPage = new RedistributeSurveyCampaignPage(driver);
            saveRedistributeSurveyCampaignPage = new SaveRedistributeSurveyCampaignPage(driver);

            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        } catch (Exception e) {
            System.out.println("Single-class setup failed");
        }
    }

    // =====================================================
    //       TEST: Redistribute + SAVE Campaign
    // =====================================================
    @Test(priority = 1)
    public void testRedistributeSurveySave() throws Exception {

        logger.info("Step 1: Open Redistribute Survey Campaign Workflow");
        redistributeSurveyPage.openRedistributeSurveyCampaign();
        redistributeSurveyPage.previewSurveyTemplate();
        redistributeSurveyPage.downloadSurveyTemplate();
        redistributeSurveyPage.fillCampaignDetails("redistribute_Survey_campaign");
        redistributeSurveyPage.selectContacts();

        logger.info("Step 2: Save Campaign");
        boolean result = saveRedistributeSurveyCampaignPage.saveRedistributedCampaign(
                "mounika@xamplify.com"
        );

        logger.info("Step 3: Validate Save Response");
        if (result) {
            logger.info("Survey Campaign Redistributed & Saved Successfully");
        } else {
            logger.error("Survey Campaign Redistribution Save Failed");
        }

        assert result : "Redistribution Save failed!";
        saveRedistributeSurveyCampaignPage.backToHome();
        
    }
}
