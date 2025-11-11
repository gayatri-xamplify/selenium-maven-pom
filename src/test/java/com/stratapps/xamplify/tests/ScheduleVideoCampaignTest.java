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
import com.stratapps.xamplify.utils.ConfigReader;

public class ScheduleVideoCampaignTest extends BaseTest {

    private VideoCampaignPage videoCampaignPage;
    private ScheduleVideoCampaignPage scheduleVideoCampaignPage;
    private WebDriverWait wait;

    private static final Logger logger = LogManager.getLogger(ScheduleVideoCampaignTest.class);

	@BeforeClass
	public void setUpClass() {
		try {
	        videoCampaignPage = new VideoCampaignPage(driver);
	        scheduleVideoCampaignPage = new ScheduleVideoCampaignPage(driver);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	        logger.info("ScheduleVideoCampaignTest setup completed");
		} catch (Exception e) {
			System.out.println("Note: Hide multiple classes Run");
		}
		try {
			super.setUp();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginAsVendor();
	        videoCampaignPage = new VideoCampaignPage(driver);
	        scheduleVideoCampaignPage = new ScheduleVideoCampaignPage(driver);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	        logger.info("ScheduleVideoCampaignTest setup completed");
		} catch (Exception e) {
			System.out.println("Note: single class Run Fail");
		}
	}
	
	/*
	 * @BeforeClass public void setUpClass() { // super.setUp(); // // LoginPage
	 * loginPage = new LoginPage(driver); //
	 * loginPage.login(ConfigReader.getProperty("username"),
	 * ConfigReader.getProperty("password"));
	 * 
	 * videoCampaignPage = new VideoCampaignPage(driver); scheduleVideoCampaignPage
	 * = new ScheduleVideoCampaignPage(driver); wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(60));
	 * logger.info("ScheduleVideoCampaignTest setup completed"); }
	 */

    @Test(priority = 1, enabled = true)
    public void createAndScheduleVideoCampaignTest() {
        logger.info("Test 1: Create and Schedule Video Campaign - STARTED");

        // Step 1: Create video campaign
        videoCampaignPage.createVideoCampaign(
            "mounikaVideoScheduleTest",
            "videoScheduleSubject",
            "chmounika@stratapps.com",
            "videoScheduleSub"
        );

        // Step 2: Select partner list
        videoCampaignPage.selectPartnerList();

        // Step 3: Schedule campaign (SINGLE CALL only)
        scheduleVideoCampaignPage.scheduleVideoCampaign("India");

        logger.info("✅ Test 1: Create and Schedule Video Campaign - COMPLETED");
    }
}
