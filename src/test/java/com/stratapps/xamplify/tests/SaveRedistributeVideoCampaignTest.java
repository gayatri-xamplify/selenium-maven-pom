package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.RedistributeEventCampaignPage;
import com.stratapps.xamplify.pages.RedistributeVideoCampaignPage;
import com.stratapps.xamplify.pages.SaveRedistributeEventCampaignPage;
import com.stratapps.xamplify.pages.SaveRedistributeVideoCampaignPage;

public class SaveRedistributeVideoCampaignTest extends BaseTest {

    private RedistributeVideoCampaignPage redistributeVideoPage;
    private SaveRedistributeVideoCampaignPage saveRedistributeVideoCampaignPage;

    private static final Logger logger = LogManager.getLogger(SaveRedistributeVideoCampaignTest.class);
    private WebDriverWait wait;
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
	    logger.info("🔧 Setting up ManageVideoCampaignTest");

	    // At this point:
	    // - Browser is already launched (@BeforeSuite)
	    // - Partner login is already done (@Parameters role=PARTNER)

	    redistributeVideoPage = new RedistributeVideoCampaignPage(driver);
        saveRedistributeVideoCampaignPage = new SaveRedistributeVideoCampaignPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    logger.info("✅ ManageVideoCampaignTest setup completed");
	}
	
   

    // =====================================================
    //       TEST: Redistribute + SAVE Campaign
    // =====================================================
    @Test(priority = 1)
    public void testRedistributeVideoSave() throws Exception {

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

        logger.info("Step 7: Save Campaign");
        boolean result = saveRedistributeVideoCampaignPage.saveRedistributedCampaign(
                "mounika@xamplify.com"
        );

        logger.info("Step 8: Validate Save Response");
        if (result) {
            logger.info("Video Campaign Redistributed & Saved Successfully");
        } else {
            logger.error("Video Campaign Redistribution Save Failed");
        }

        assert result : "Redistribution Save failed!";
        redistributeVideoPage.backToHome();
        
    }
}
