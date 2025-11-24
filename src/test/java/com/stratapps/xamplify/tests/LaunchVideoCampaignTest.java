package com.stratapps.xamplify.tests;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.VideoCampaignPage;
import com.stratapps.xamplify.pages.LaunchVideoCampaignPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class LaunchVideoCampaignTest extends BaseTest {

	private VideoCampaignPage videoCampaignPage;
	private LaunchVideoCampaignPage launchVideoCampaignPage;
	private WebDriverWait wait;

	private static final Logger logger = LogManager.getLogger(LaunchVideoCampaignTest.class);

	@BeforeClass
	public void setUpClass() {
		// If login is required, uncomment below
//		 super.setUp();
//		 LoginPage loginPage = new LoginPage(driver);
//		 loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		videoCampaignPage = new VideoCampaignPage(driver);
		launchVideoCampaignPage = new LaunchVideoCampaignPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		logger.info("LaunchVideoCampaignTest setup completed");
	}

	@Test(priority = 1, enabled = true)
	public void createAndLaunchVideoCampaignTest() {
		logger.info("Test 1: Create and Launch Video Campaign - STARTED");

		// Step 1: Create campaign
		 videoCampaignPage.createVideoCampaign(
	                "Demo launch Video Campaign", 
	                "Test launch Video Campaign", 
	                "mounika@xamplify.com",
	                "Launch Video Campaign Subject"
	        );

		// Step 2: Select partner list
		videoCampaignPage.selectPartnerList();

		// Step 3: Launch campaign
		launchVideoCampaignPage.launchVideoCampaign();

		logger.info("✅ Test 1: Create and Launch Video Campaign - COMPLETED");
	}
}
