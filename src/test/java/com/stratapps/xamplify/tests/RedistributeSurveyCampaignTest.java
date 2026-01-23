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
import com.stratapps.xamplify.pages.RedistributeSurveyCampaignPage;

public class RedistributeSurveyCampaignTest extends BaseTest {

    private RedistributeSurveyCampaignPage redistributeSurveyCampaignPage;
    private static final Logger logger = LogManager.getLogger(RedistributeSurveyCampaignTest.class);
    private WebDriverWait wait;
	@BeforeClass(alwaysRun = true)
public void setUpClass() {
    logger.info("🔧 Setting up RedistributeSurveyCampaignTest");

    // At this point:
    // - Browser is already launched (@BeforeSuite)
    // - Partner login is already done (@Parameters role=PARTNER)

    redistributeSurveyCampaignPage = new RedistributeSurveyCampaignPage(driver);
    wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    logger.info("✅ RedistributeSurveyCampaignTest setup completed");
}
    
    // ================================
    //      TEST 1: OPEN REDISTRIBUTE
    // ================================
    @Test(priority = 1, enabled = true)
    public void openRedistributeSurveyCampaignTest() throws Exception {
        logger.info("Test 1: Open Redistribute Survey Campaign - STARTED");

        redistributeSurveyCampaignPage.openRedistributeSurveyCampaign();
        redistributeSurveyCampaignPage.previewSurveyTemplate();
        redistributeSurveyCampaignPage.downloadSurveyTemplate();
        //redistributeSurveyCampaignPage.viewDownloadHistory();
        redistributeSurveyCampaignPage.fillCampaignDetails("redistribute_Survey_campaign");
        redistributeSurveyCampaignPage.selectContacts();

        logger.info("Test 1: Open Redistribute Survey Campaign - COMPLETED");
    }

    // ================================
    //      TEST 2: FILL DETAILS
    // ================================
    @Test(priority = 2, enabled = false)
    public void fillCampaignDetailsTest() throws InterruptedException {
        logger.info("Test 2: Fill Redistribute Survey Campaign Details - STARTED");

        redistributeSurveyCampaignPage.fillCampaignDetails("redistribute_Survey_campaign");

        logger.info("Test 2: Fill Redistribute Survey Campaign Details - COMPLETED");
    }

    
}
