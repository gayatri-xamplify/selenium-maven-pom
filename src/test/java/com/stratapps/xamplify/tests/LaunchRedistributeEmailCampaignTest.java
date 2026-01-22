package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LaunchRedistributeEmailCampaignPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.RedistributeEmailCampaignPage;

public class LaunchRedistributeEmailCampaignTest extends BaseTest {

    private RedistributeEmailCampaignPage redistributeemailPage;
	private LaunchRedistributeEmailCampaignPage launchRedistributeEmailCampaignPage;

    private static final Logger logger = LogManager.getLogger(LaunchRedistributeEmailCampaignTest.class);
    private WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {

        logger.info("🔧 Setting up LaunchRedistributionEmailCampaignTest");

        // At this point:
        // - Browser is already open (BeforeSuite)
        // - Partner is already logged in (role=PARTNER from testng.xml)

        redistributeemailPage = new RedistributeEmailCampaignPage(driver);
        launchRedistributeEmailCampaignPage =
                new LaunchRedistributeEmailCampaignPage(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        logger.info("✅ LaunchRedistributionEmailCampaignTest setup completed");
    }

    // =====================================================
    //   TEST: Complete Redistribute + Launch Flow
    // =====================================================

    @Test(priority = 1)
    public void testRedistributeEmailLaunch() throws Exception {

        logger.info("Step 1: Open Redistribute Flow");
        redistributeemailPage.openRedistributeEmailCampaign();
        redistributeemailPage.previewEmailTemplate();
        redistributeemailPage.downloadEmailTemplate();
        redistributeemailPage.fillCampaignDetails("redistribute_email_campaign");
        redistributeemailPage.selectContacts();

        logger.info("Step 2: Launch NOW");
        launchRedistributeEmailCampaignPage.launchNow();
      
        logger.info("Step 3: Validate Launch Message");
        boolean result = launchRedistributeEmailCampaignPage.validateLaunchMessage();

        if (result) {
            logger.info("Email Campaign Redistributed & Launched Successfully");
        } else {
            logger.error("Email Campaign Redistribution Launch Failed");
        }
        
        redistributeemailPage.backToHome();

    }
}

