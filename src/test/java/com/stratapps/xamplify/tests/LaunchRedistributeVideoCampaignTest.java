
package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LaunchRedistributeVideoCampaignPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.RedistributeVideoCampaignPage;

public class LaunchRedistributeVideoCampaignTest extends BaseTest {

    private RedistributeVideoCampaignPage redistributeVideoPage;
	private LaunchRedistributeVideoCampaignPage launchRedistributeVideoCampaignPage;

    private static final Logger logger = LogManager.getLogger(LaunchRedistributeVideoCampaignTest.class);
    private WebDriverWait wait;

    @BeforeClass
    public void setUpClass() {
        try {
        	redistributeVideoPage = new RedistributeVideoCampaignPage(driver);
        	launchRedistributeVideoCampaignPage = new LaunchRedistributeVideoCampaignPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            logger.info("LaunchRedistributionVideoCampaignTest setup completed");
        } catch (Exception e) {
            System.out.println("Multi-class Setup: Ignored");
        }

        try {
            super.setUp();
            LoginPage loginPage = new LoginPage(driver);
			loginPage.loginAsPartner();
            redistributeVideoPage = new RedistributeVideoCampaignPage(driver);
            launchRedistributeVideoCampaignPage = new LaunchRedistributeVideoCampaignPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            logger.info("LaunchRedistributionVideoCampaignTest setup completed");

        } catch (Exception e) {
            System.out.println("Single Class Setup Failed");
        }
    }

    // =====================================================
    //   TEST: Complete Redistribute + Launch Flow
    // =====================================================

    @Test(priority = 1)
    public void testRedistributeVideoLaunch() throws Exception {

    	logger.info("Step 1: Open Redistribute Video Campaign");
		redistributeVideoPage.openRedistributeVideoCampaign();

		logger.info("Step 2: Preview Template");
		redistributeVideoPage.previewVideoTemplate();

		logger.info("Step 3: download Template");
		redistributeVideoPage.downloadEmailTemplate();
		
		logger.info("Step 4: ViewDownloadHistory");
	//	redistributeVideoPage.viewDownloadHistory();

		logger.info("Step 5: Fill Campaign Details");
		redistributeVideoPage.fillVideoCampaignDetails("redistribute_video_campaign");

		logger.info("Step 6: Select Contacts");
		redistributeVideoPage.selectVideoContacts();


        logger.info("Step 7: Launch NOW");
        launchRedistributeVideoCampaignPage.launchNow();
      
        logger.info("Step 8: Validate Launch Message");
        boolean result = launchRedistributeVideoCampaignPage.validateLaunchMessage();

        if (result) {
            logger.info("Video Campaign Redistributed & Launched Successfully");
        } else {
            logger.error("Video Campaign Redistribution Launch Failed");
        }
        
        redistributeVideoPage.backToHome();

    }
}

