package com.stratapps.xamplify.tests;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.SurveyCampaignPage;
import com.stratapps.xamplify.pages.UploadAssetPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.RedistributeEventCampaignPage;
import com.stratapps.xamplify.pages.SaveRedistributeEventCampaignPage;
import com.stratapps.xamplify.pages.SaveSurveyCampaignPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class SaveSurveyCampaignTest extends BaseTest {

	private SurveyCampaignPage SurveyCampaignPage;
	private SaveSurveyCampaignPage saveSurveyCampaignPage;

	private WebDriverWait wait;

	private static final Logger logger = LogManager.getLogger(SaveSurveyCampaignTest.class);
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
	    logger.info("🔧 Setting up SaveSurveyCampaignTest");

	    // At this point:
	    // - Browser is already launched (@BeforeSuite)
	    // - Partner login is already done (@Parameters role=PARTNER)

	    SurveyCampaignPage = new SurveyCampaignPage(driver);
		saveSurveyCampaignPage = new SaveSurveyCampaignPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    logger.info("✅ SaveSurveyCampaignTest setup completed");
	}
	
	

	@Test(priority = 1, enabled = true)
	public void createAndSaveSurveyCampaignTest() {
		logger.info("Test 1: Create and Save Survey Campaign - STARTED");

		// Step 1: Create campaign
		SurveyCampaignPage.createSurveyCampaign("Survey_Save_Campaign", "SurveySaveTest", "SurveysaveSubject",
				"mounika@xamplify.com", "SurveysaveSub");

		// Step 2: Select partner list
		SurveyCampaignPage.selectPartnerList();

		// Step 3: Save campaign (single call to page class)
		saveSurveyCampaignPage.saveSurveyCampaign("mounika@xamplify.com", "SaveSurveySubject");

		logger.info("✅ Test 1: Create and Save Survey Campaign - COMPLETED");
	}
}
