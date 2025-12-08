package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LaunchRedistributeEventCampaignPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.RedistributeEventCampaignPage;

public class LaunchRedistributeEventCampaignTest extends BaseTest {

	private RedistributeEventCampaignPage redistributeEventCampaignPage;
	private LaunchRedistributeEventCampaignPage launchRedistributeEventCampaignPage;

	private static final Logger logger = LogManager.getLogger(LaunchRedistributeEventCampaignTest.class);
	private WebDriverWait wait;

	@BeforeClass
	public void setUpClass() {
		try {
			redistributeEventCampaignPage = new RedistributeEventCampaignPage(driver);
			launchRedistributeEventCampaignPage = new LaunchRedistributeEventCampaignPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			logger.info("LaunchRedistributionEventCampaignTest setup completed");
		} catch (Exception e) {
			System.out.println("Multi-class Setup: Ignored");
		}

		try {
			super.setUp();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginAsPartner();
			redistributeEventCampaignPage = new RedistributeEventCampaignPage(driver);
			launchRedistributeEventCampaignPage = new LaunchRedistributeEventCampaignPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		} catch (Exception e) {
			System.out.println("Single Class Setup Failed");
		}
	}

	// =====================================================
	// TEST: Complete Redistribute + Launch Flow
	// =====================================================

	@Test(priority = 1)
	public void testRedistributeEventLaunch() throws Exception {

		logger.info("Step 1: Open Redistribute Event Flow");
		redistributeEventCampaignPage.openRedistributeEventCampaign();
		redistributeEventCampaignPage.previewEventTemplate();
		redistributeEventCampaignPage.downloadEmailTemplate();

		logger.info("Step 2: Select Contacts");
		redistributeEventCampaignPage.selectContacts();
		logger.info("Event Redistribution Test Completed Successfully");
		
		logger.info("Step 3: Launch NOW");
		launchRedistributeEventCampaignPage.launchNow();

		logger.info("Step 4: Validate Launch Message");
		boolean result = launchRedistributeEventCampaignPage.validateLaunchMessage();

		if (result) {
			logger.info("Event Campaign Redistributed & Launched Successfully");
		} else {
			logger.error("Event Campaign Redistribution Launch Failed");
		}

		redistributeEventCampaignPage.backToHome();

	}
}
