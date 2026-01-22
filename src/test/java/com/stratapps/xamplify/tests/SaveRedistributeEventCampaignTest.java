package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.RedistributeEmailCampaignPage;
import com.stratapps.xamplify.pages.RedistributeEventCampaignPage;
import com.stratapps.xamplify.pages.SaveRedistributeEventCampaignPage;

public class SaveRedistributeEventCampaignTest extends BaseTest {

	private RedistributeEventCampaignPage redistributeEventCampaignPage;
	private SaveRedistributeEventCampaignPage saveRedistributeEventCampaignPage;

	private static final Logger logger = LogManager.getLogger(SaveRedistributeEventCampaignTest.class);
	private WebDriverWait wait;
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
	    logger.info("🔧 Setting up ManageVideoCampaignTest");

	    // At this point:
	    // - Browser is already launched (@BeforeSuite)
	    // - Partner login is already done (@Parameters role=PARTNER)

	    redistributeEventCampaignPage = new RedistributeEventCampaignPage(driver);
		saveRedistributeEventCampaignPage = new SaveRedistributeEventCampaignPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    logger.info("✅ ManageVideoCampaignTest setup completed");
	}
	

	// =====================================================
	// TEST: Redistribute + SAVE Campaign
	// =====================================================
	@Test(priority = 1)
	public void testRedistributeEventSave() throws Exception {

		logger.info("Step 1: Open Redistribute Event Flow");
		redistributeEventCampaignPage.openRedistributeEventCampaign();
		redistributeEventCampaignPage.previewEventTemplate();
		redistributeEventCampaignPage.downloadEmailTemplate();

		logger.info("Step 2: Select Contacts");
		redistributeEventCampaignPage.selectContacts();
		logger.info("Event Redistribution Test Completed Successfully");

		logger.info("Step 3: Save Campaign");
		saveRedistributeEventCampaignPage.saveRedistributedCampaign("mounika@xamplify.com");
		redistributeEventCampaignPage.backToHome();

	

	}
}
