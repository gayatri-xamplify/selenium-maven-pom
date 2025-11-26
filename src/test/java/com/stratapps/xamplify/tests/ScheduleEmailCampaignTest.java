package com.stratapps.xamplify.tests;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.EmailCampaignPage;
import com.stratapps.xamplify.pages.ScheduleEmailCampaignPage;
import com.stratapps.xamplify.pages.ScheduleVideoCampaignPage;
import com.stratapps.xamplify.pages.VideoCampaignPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class ScheduleEmailCampaignTest extends BaseTest {

    private EmailCampaignPage emailCampaignPage;
    private ScheduleEmailCampaignPage scheduleEmailCampaignPage;
    private WebDriverWait wait;

    private static final Logger logger = LogManager.getLogger(ScheduleEmailCampaignTest.class);

	@BeforeClass
	public void setUpClass() {
		try {
	        emailCampaignPage = new EmailCampaignPage(driver);
	        scheduleEmailCampaignPage = new ScheduleEmailCampaignPage(driver);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	        logger.info("ScheduleEmailCampaignTest setup completed");
		} catch (Exception e) {
			System.out.println("Note: Hide multiple classes Run");
		}
		try {
			super.setUp();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginAsVendor();
	        emailCampaignPage = new EmailCampaignPage(driver);
	        scheduleEmailCampaignPage = new ScheduleEmailCampaignPage(driver);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	        logger.info("ScheduleEmailCampaignTest setup completed");
		} catch (Exception e) {
			System.out.println("Note: single class Run Fail");
		}
	}
	


    @Test(priority = 1, enabled = true)
    public void createAndScheduleEmailCampaignTest() {
        logger.info("Test 1: Create and Schedule Email Campaign - STARTED");

        // Step 1: Create campaign
        emailCampaignPage.createEmailCampaign(
        		"Email_Schedule_campaign", "EmailScheduleTest", "EmailscheduleSubject",
				"mounika@xamplify.com", "EmailscheduleSub"
        );

        // Step 2: Select partner list
        emailCampaignPage.selectPartnerList();
        // Step 3: Schedule campaign (SINGLE CALL only)
        scheduleEmailCampaignPage.scheduleEmailCampaign("India");

        logger.info("✅ Test 1: Create and Schedule Email Campaign - COMPLETED");
    }
}
