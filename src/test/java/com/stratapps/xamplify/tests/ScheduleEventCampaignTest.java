package com.stratapps.xamplify.tests;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.EmailCampaignPage;
import com.stratapps.xamplify.pages.EventCampaignPage;
import com.stratapps.xamplify.pages.ScheduleEventCampaignPage;
import com.stratapps.xamplify.pages.ScheduleVideoCampaignPage;
import com.stratapps.xamplify.pages.VideoCampaignPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.ScheduleEmailCampaignPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class ScheduleEventCampaignTest extends BaseTest {

    private EventCampaignPage EventCampaignPage;
    private ScheduleEventCampaignPage scheduleEventCampaignPage;
    private WebDriverWait wait;

    private static final Logger logger = LogManager.getLogger(ScheduleEventCampaignTest.class);

    
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
	    logger.info("🔧 Setting up ScheduleEventCampaignTest");

	    // At this point:
	    // - Browser is already launched (@BeforeSuite)
	    // - Partner login is already done (@Parameters role=PARTNER)

	    EventCampaignPage = new EventCampaignPage(driver);
        scheduleEventCampaignPage = new ScheduleEventCampaignPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    logger.info("✅ ScheduleEventCampaignTest setup completed");
	}
	
 
    @Test(priority = 1, enabled = true)
    public void createAndScheduleEventCampaignTest() throws Exception {
        logger.info("Test 1: Create and Schedule Event Campaign - STARTED");

        // Step 1: Create campaign
        EventCampaignPage.createEventCampaign(
        		"Event_Schedule_campaign");

        // Step 2: Select partner list
        EventCampaignPage.selectPartnerList();
     // Step 3: Select template
     		EventCampaignPage.selectTemplate();
        // Step 4: Schedule campaign (SINGLE CALL only)
        scheduleEventCampaignPage.scheduleEventCampaign("India");

        logger.info("✅ Test 1: Create and Schedule Event Campaign - COMPLETED");
    }
}

