package com.stratapps.xamplify.tests;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.AddPlaybooksPage;
import com.stratapps.xamplify.pages.EmailCampaignPage;
import com.stratapps.xamplify.pages.LaunchEmailCampaignPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.SaveSurveyCampaignPage;
import com.stratapps.xamplify.pages.SurveyCampaignPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class LaunchEmailCampaignTest extends BaseTest {

	private EmailCampaignPage emailCampaignPage;
	private LaunchEmailCampaignPage launchEmailCampaignPage;
	private WebDriverWait wait;

	private static final Logger logger = LogManager.getLogger(LaunchEmailCampaignTest.class);


	
	
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {

	    logger.info("🔧 Setting up AccessSharedAssetsTest");

	    // Preconditions guaranteed by BaseTest:
	    // - Browser already launched
	    // - Partner already logged in (role=PARTNER)

		emailCampaignPage = new EmailCampaignPage(driver);
		launchEmailCampaignPage = new LaunchEmailCampaignPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    logger.info("✅ AccessSharedAssetsTest setup completed");
	}

	
	
	
	
	@Test(priority = 1, enabled = true)
	public void createAndLaunchEmailCampaignTest() {
		logger.info("Test 1: Create and Launch Email Campaign - STARTED");

		// Step 1: Create campaign
		emailCampaignPage.createEmailCampaign("Email_Launch_Campaign", "Email_Launchtest", "Email_Launch_subject",
				"mounika@xamplify.com", "Email_Launch_sub");

		// Step 2: Select partner list
		emailCampaignPage.selectPartnerList();

		// Step 3: Launch campaign (single call to page class)
		launchEmailCampaignPage.launchEmailCampaign();

		logger.info("✅ Test 1: Create and Launch Email Campaign - COMPLETED");
	}
}
