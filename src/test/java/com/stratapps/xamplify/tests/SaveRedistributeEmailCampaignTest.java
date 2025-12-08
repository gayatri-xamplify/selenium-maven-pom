package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.RedistributeEmailCampaignPage;
import com.stratapps.xamplify.pages.SaveRedistributeEmailCampaignPage;

public class SaveRedistributeEmailCampaignTest extends BaseTest {

    private RedistributeEmailCampaignPage redistributeemailPage;
    private SaveRedistributeEmailCampaignPage saveRedistributeEmailCampaignPage;

    private static final Logger logger = LogManager.getLogger(SaveRedistributeEmailCampaignTest.class);
    private WebDriverWait wait;

    @BeforeClass
    public void setUpClass() {
        try {
            redistributeemailPage = new RedistributeEmailCampaignPage(driver);
            saveRedistributeEmailCampaignPage = new SaveRedistributeEmailCampaignPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            logger.info("SaveRedistributeEmailCampaignTest setup completed");
        } catch (Exception e) {
            System.out.println("Multi-class setup ignored");
        }

        try {
            super.setUp();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginAsPartner();

            redistributeemailPage = new RedistributeEmailCampaignPage(driver);
            saveRedistributeEmailCampaignPage = new SaveRedistributeEmailCampaignPage(driver);

            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        } catch (Exception e) {
            System.out.println("Single-class setup failed");
        }
    }

    // =====================================================
    //       TEST: Redistribute + SAVE Campaign
    // =====================================================
    @Test(priority = 1)
    public void testRedistributeEmailSave() throws Exception {

        logger.info("Step 1: Open Redistribute Email Campaign Workflow");
        redistributeemailPage.openRedistributeEmailCampaign();
        redistributeemailPage.previewEmailTemplate();
        redistributeemailPage.downloadEmailTemplate();
        redistributeemailPage.fillCampaignDetails("redistribute_email_campaign");
        redistributeemailPage.selectContacts();

        logger.info("Step 2: Save Campaign");
        boolean result = saveRedistributeEmailCampaignPage.saveRedistributedCampaign(
                "mounika@xamplify.com"
        );

        logger.info("Step 3: Validate Save Response");
        if (result) {
            logger.info("Email Campaign Redistributed & Saved Successfully");
        } else {
            logger.error("Email Campaign Redistribution Save Failed");
        }

        assert result : "Redistribution Save failed!";
        redistributeemailPage.backToHome();
        
    }
}
