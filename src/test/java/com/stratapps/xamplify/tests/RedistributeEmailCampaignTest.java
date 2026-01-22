package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.ManageVideoCampaignPage;
import com.stratapps.xamplify.pages.RedistributeEmailCampaignPage;

public class RedistributeEmailCampaignTest extends BaseTest {

    private RedistributeEmailCampaignPage redistributeEmailCampaignPage;
    private static final Logger logger = LogManager.getLogger(RedistributeEmailCampaignTest.class);
    private WebDriverWait wait;
	@BeforeClass(alwaysRun = true)
public void setUpClass() {
    logger.info("🔧 Setting up ManageVideoCampaignTest");

    // At this point:
    // - Browser is already launched (@BeforeSuite)
    // - Partner login is already done (@Parameters role=PARTNER)

    redistributeEmailCampaignPage = new RedistributeEmailCampaignPage(driver);
    wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    logger.info("✅ ManageVideoCampaignTest setup completed");
}
    
  
    // ================================
    //      TEST 1: OPEN REDISTRIBUTE
    // ================================
    @Test(priority = 1, enabled = true)
    public void openRedistributeEmailCampaignTest() throws Exception {
        logger.info("Test 1: Open Redistribute Email Campaign - STARTED");

        redistributeEmailCampaignPage.openRedistributeEmailCampaign();
        redistributeEmailCampaignPage.previewEmailTemplate();
        redistributeEmailCampaignPage.downloadEmailTemplate();
        //redistributeEmailCampaignPage.viewDownloadHistory();
        redistributeEmailCampaignPage.fillCampaignDetails("redistribute_email_campaign");
        redistributeEmailCampaignPage.selectContacts();

        logger.info("Test 1: Open Redistribute Email Campaign - COMPLETED");
    }

    // ================================
    //      TEST 2: FILL DETAILS
    // ================================
    @Test(priority = 2, enabled = false)
    public void fillCampaignDetailsTest() throws InterruptedException {
        logger.info("Test 2: Fill Redistribute Email Campaign Details - STARTED");

        redistributeEmailCampaignPage.fillCampaignDetails("redistribute_email_campaign");

        logger.info("Test 2: Fill Redistribute Email Campaign Details - COMPLETED");
    }

    
}
