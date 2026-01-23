package com.stratapps.xamplify.tests;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.VideoCampaignPage;
import com.stratapps.xamplify.pages.ScheduleVideoCampaignPage;
import com.stratapps.xamplify.pages.SharedLeadsPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.RedistributeEventCampaignPage;
import com.stratapps.xamplify.pages.ScheduleRedistributeEventCampaignPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class ScheduleVideoCampaignTest extends BaseTest {

    private VideoCampaignPage videoCampaignPage;
    private ScheduleVideoCampaignPage scheduleVideoCampaignPage;
    private WebDriverWait wait;

    private static final Logger logger = LogManager.getLogger(ScheduleVideoCampaignTest.class);
    @BeforeClass(alwaysRun = true)
	public void setUpClass() {
	    logger.info("🔧 Setting up ScheduleVideoCampaignTest");

	    // At this point:
	    // - Browser is already launched (@BeforeSuite)
	    // - Partner login is already done (@Parameters role=PARTNER)

	    videoCampaignPage = new VideoCampaignPage(driver);
        scheduleVideoCampaignPage = new ScheduleVideoCampaignPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    logger.info("✅ ScheduleVideoCampaignTest setup completed");
	}

	

    @Test(priority = 1, enabled = true)
    public void createAndScheduleVideoCampaignTest() throws InterruptedException {
        logger.info("Test 1: Create and Schedule Video Campaign - STARTED");

        // Step 1: Create video campaign
        videoCampaignPage.createVideoCampaign(
            "mounikaVideoScheduleTest",
            "videoScheduleSubject",
            "mounika@xamplify.com",
            "videoScheduleSub"
        );

        // Step 2: Select partner list
        videoCampaignPage.selectPartnerList();

        // Step 3: Schedule campaign (SINGLE CALL only)
        scheduleVideoCampaignPage.scheduleVideoCampaign("India");

        logger.info("✅ Test 1: Create and Schedule Video Campaign - COMPLETED");
    }
}
