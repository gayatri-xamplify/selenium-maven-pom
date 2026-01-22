
package com.stratapps.xamplify.tests;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.AddTracksPage;
import com.stratapps.xamplify.pages.EventCampaignPage;
import com.stratapps.xamplify.pages.LaunchEventCampaignPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.SaveSurveyCampaignPage;
import com.stratapps.xamplify.pages.SurveyCampaignPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class LaunchEventCampaignTest extends BaseTest {

	private EventCampaignPage EventCampaignPage;
	private LaunchEventCampaignPage launchEventCampaignPage;
	private WebDriverWait wait;

	private static final Logger logger = LogManager.getLogger(LaunchEventCampaignTest.class);

	@BeforeClass(alwaysRun = true)
	public void setUpClass() {

		logger.info("🔧 Setting up AccessSharedAssetsTest");

		// Preconditions guaranteed by BaseTest:
		// - Browser already launched
		// - Partner already logged in (role=PARTNER)

		EventCampaignPage = new EventCampaignPage(driver);
		launchEventCampaignPage = new LaunchEventCampaignPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		logger.info("✅ AccessSharedAssetsTest setup completed");
	}

	@Test(priority = 1, enabled = true)
	public void createAndLaunchEventCampaignTest() throws Exception {
		logger.info("Test 1: Create and Launch Event Campaign - STARTED");

		// Step 1: Create campaign
		EventCampaignPage.createEventCampaign("Event_Launch_Campaign");

		// Step 2: Select partner list
		EventCampaignPage.selectPartnerList();
		// Step 3: Select template
		EventCampaignPage.selectTemplate();

		// Step 4: Launch campaign (single call to page class)
		launchEventCampaignPage.launchEventCampaign();

		logger.info("✅ Test 1: Create and Launch Event Campaign - COMPLETED");
	}
}
