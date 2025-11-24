package com.stratapps.xamplify.tests;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.SurveyCampaignPage;
import com.stratapps.xamplify.pages.LaunchSurveyCampaignPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class LaunchSurveyCampaignTest extends BaseTest {

	private SurveyCampaignPage SurveyCampaignPage;
	private LaunchSurveyCampaignPage launchSurveyCampaignPage;
	private WebDriverWait wait;

	private static final Logger logger = LogManager.getLogger(LaunchSurveyCampaignTest.class);

	@BeforeClass
	public void setUpClass() {
//		super.setUp();
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		SurveyCampaignPage = new SurveyCampaignPage(driver);
		launchSurveyCampaignPage = new LaunchSurveyCampaignPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		logger.info("LaunchSurveyCampaignTest setup completed");
	}

	
	@Test(priority = 1, enabled = true)
	public void createAndLaunchSurveyCampaignTest() {
		logger.info("Test 1: Create and Launch Survey Campaign - STARTED");

		// Step 1: Create campaign
		SurveyCampaignPage.createSurveyCampaign("Survey_Launch_Campaign", "SurveyLaunchtest", "SurveyLaunchsubject", "mounika@xamplify.com",
				"Survey_launch_sub");

		// Step 2: Select partner list
		SurveyCampaignPage.selectPartnerList();
		
		// Step 3: Launch campaign (single call to page class)
		launchSurveyCampaignPage.launchSurveyCampaign();
	

		logger.info("✅ Test 1: Create and Launch Survey Campaign - COMPLETED");
	}
}

