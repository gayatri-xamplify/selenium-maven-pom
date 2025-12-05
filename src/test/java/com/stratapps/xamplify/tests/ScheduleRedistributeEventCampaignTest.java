package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.RedistributeEventCampaignPage;
import com.stratapps.xamplify.pages.ScheduleRedistributeEventCampaignPage;

public class ScheduleRedistributeEventCampaignTest extends BaseTest {

	private RedistributeEventCampaignPage redistributeEventCampaignPage;
	private ScheduleRedistributeEventCampaignPage scheduleRedistributeEventCampaignPage;

	private static final Logger logger = LogManager.getLogger(ScheduleRedistributeEventCampaignTest.class);
	private WebDriverWait wait;

	@BeforeClass
	public void setUpClass() {

		try {
			redistributeEventCampaignPage = new RedistributeEventCampaignPage(driver);
			scheduleRedistributeEventCampaignPage = new ScheduleRedistributeEventCampaignPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			logger.info("RedistributeScheduleEventCampaignTest setup completed");
		} catch (Exception e) {
			System.out.println("Multi-class Setup: Ignored");
		}

		try {
			super.setUp();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginAsPartner();

			redistributeEventCampaignPage = new RedistributeEventCampaignPage(driver);
			scheduleRedistributeEventCampaignPage = new ScheduleRedistributeEventCampaignPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		} catch (Exception e) {
			System.out.println("Single Class Setup Failed");
		}
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
		boolean result = scheduleRedistributeEventCampaignPage.scheduleRedistributionEvent("103"); // India
		if (result) {
			logger.info("Event Campaign Redistributed & Scheduled Successfully");
		} else {
			logger.error("Event Campaign Redistribution Schedule Failed");
		}

		scheduleRedistributeEventCampaignPage.backToHome();

	}

}
