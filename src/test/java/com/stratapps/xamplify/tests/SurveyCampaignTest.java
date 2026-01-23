package com.stratapps.xamplify.tests;

import java.awt.AWTException;
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
import com.stratapps.xamplify.pages.RedistributeEventCampaignPage;
import com.stratapps.xamplify.pages.ScheduleRedistributeEventCampaignPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class SurveyCampaignTest extends BaseTest {

	private SurveyCampaignPage SurveyCampaignPage;
	private static final Logger logger = LogManager.getLogger(SurveyCampaignTest.class);
	private WebDriverWait wait;
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
	    logger.info("🔧 Setting up SurveyCampaignTest");

	    // At this point:
	    // - Browser is already launched (@BeforeSuite)
	    // - Partner login is already done (@Parameters role=PARTNER)

		SurveyCampaignPage = new SurveyCampaignPage(driver);		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    logger.info("✅ SurveyCampaignTest setup completed");
	}

	
	
	


	@Test(priority = 1, enabled = true)
	public void createSurveyCampaignTest() {
		logger.info("Test 2: Create Survey Campaign - STARTED");
		SurveyCampaignPage.createSurveyCampaign("mounika", "mounikatest", "mounisubject", "chmounika@stratapps.com",
				"sub");

		logger.info("Test 2: Create Survey Campaign - COMPLETED");
	}

	@Test(priority = 3, enabled = true)
	public void selectPartnerList() {
		logger.info("Test 3: Select Partner List - STARTED");
		SurveyCampaignPage.selectPartnerList();
		logger.info("Test 3: Select Partner List - COMPLETED");

	}
}