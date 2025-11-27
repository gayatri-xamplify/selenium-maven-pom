package com.stratapps.xamplify.tests;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.EventCampaignPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.SaveEventCampaignPage;
import com.stratapps.xamplify.pages.ScheduleVideoCampaignPage;
import com.stratapps.xamplify.pages.VideoCampaignPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class SaveEventCampaignTest extends BaseTest {

    private EventCampaignPage EventCampaignPage;
    private SaveEventCampaignPage saveEventCampaignPage;

    private WebDriverWait wait;

    private static final Logger logger = LogManager.getLogger(SaveEventCampaignTest.class);

	@BeforeClass
	public void setUpClass() {
		try {
		       EventCampaignPage = new EventCampaignPage(driver);
		        saveEventCampaignPage = new SaveEventCampaignPage(driver);
		        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		        logger.info("SaveEventCampaignTest setup completed");
		} catch (Exception e) {
			System.out.println("Note: Hide multiple classes Run");
		}
		try {
			super.setUp();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginAsVendor();
		       EventCampaignPage = new EventCampaignPage(driver);
		        saveEventCampaignPage = new SaveEventCampaignPage(driver);
		        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		        logger.info("SaveEventCampaignTest setup completed");
		} catch (Exception e) {
			System.out.println("Note: single class Run Fail");
		}
	}
	
	
    @Test(priority = 1, enabled = true)
    public void createAndSaveEventCampaignTest() throws Exception {
        logger.info("Test 1: Create and Save Event Campaign - STARTED");

        // Step 1: Create campaign
        EventCampaignPage.createEventCampaign(
        		"Event_Save_Campaign");
      

        // Step 2: Select partner list
        EventCampaignPage.selectPartnerList();
     // Step 3: Select template
 		EventCampaignPage.selectTemplate();
        // Step 4: Save campaign (single call to page class)
        saveEventCampaignPage.saveEventCampaign("mounika@xamplify.com","SaveEventSubject");

        logger.info("✅ Test 1: Create and Save Event Campaign - COMPLETED");
    }
}

