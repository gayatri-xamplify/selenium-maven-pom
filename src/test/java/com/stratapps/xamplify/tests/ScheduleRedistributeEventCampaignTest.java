package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.EventCampaignPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.RedistributeEventCampaignPage;
import com.stratapps.xamplify.pages.ScheduleEventCampaignPage;
import com.stratapps.xamplify.pages.ScheduleRedistributeEventCampaignPage;

public class ScheduleRedistributeEventCampaignTest extends BaseTest {

	private RedistributeEventCampaignPage redistributeEventCampaignPage;
	private ScheduleRedistributeEventCampaignPage scheduleRedistributeEventCampaignPage;

	private static final Logger logger = LogManager.getLogger(ScheduleRedistributeEventCampaignTest.class);
	private WebDriverWait wait;
    
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
	    logger.info("🔧 Setting up ScheduleRedistributeEventCampaignTest");

	    // At this point:
	    // - Browser is already launched (@BeforeSuite)
	    // - Partner login is already done (@Parameters role=PARTNER)

	    redistributeEventCampaignPage = new RedistributeEventCampaignPage(driver);
		scheduleRedistributeEventCampaignPage = new ScheduleRedistributeEventCampaignPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    logger.info("✅ ScheduleRedistributeEventCampaignTest setup completed");
	}


	// =====================================================
	// TEST: Complete Redistribute + Schedule Flow
	// =====================================================

	@Test(priority = 1)
	public void testRedistributeEventSchedule() throws Exception {

		logger.info("Step 1: Open Redistribute Event Flow");
		redistributeEventCampaignPage.openRedistributeEventCampaign();
		redistributeEventCampaignPage.previewEventTemplate();
		redistributeEventCampaignPage.downloadEmailTemplate();

		logger.info("Step 2: Select Contacts");
		redistributeEventCampaignPage.selectContacts();
		logger.info("Event Redistribution Test Completed Successfully");
		
		logger.info("Step 3: Schedule Campaign");
		scheduleRedistributeEventCampaignPage.scheduleRedistributionEvent("103"); // India
		redistributeEventCampaignPage.backToHome();

		

	}

}
