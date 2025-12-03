package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.RedistributeVideoCampaignPage;

public class RedistributeVideoCampaignTest extends BaseTest {

	private RedistributeVideoCampaignPage redistributeVideoPage;
	private static final Logger logger = LogManager.getLogger(RedistributeVideoCampaignTest.class);
	private WebDriverWait wait;

	@BeforeClass
	public void setUpClass() {

		try {
			redistributeVideoPage = new RedistributeVideoCampaignPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			logger.info("RedistributeVideoCampaignTest setup completed");
		} catch (Exception e) {
			System.out.println("Multi-class Init Ignored");
		}

		try {
			super.setUp();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginAsPartner();

			redistributeVideoPage = new RedistributeVideoCampaignPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		} catch (Exception e) {
			System.out.println("Single class Init Failed");
		}
	}

	// =====================================================
	// TEST: VIDEO REDISTRIBUTION FLOW
	// =====================================================
	@Test(priority = 1)
	public void redistributeVideoCampaignTest() throws Exception {

		logger.info("Step 1: Open Redistribute Video Campaign");
		redistributeVideoPage.openRedistributeVideoCampaign();

		logger.info("Step 2: Preview Template");
		redistributeVideoPage.previewVideoTemplate();

		logger.info("Step 3: download Template");
		redistributeVideoPage.downloadEmailTemplate();
		
		logger.info("Step 4: ViewDownloadHistory");
	//	redistributeVideoPage.viewDownloadHistory();

		logger.info("Step 5: Fill Campaign Details");
		redistributeVideoPage.fillVideoCampaignDetails("redistribute_video_campaign");

		logger.info("Step 6: Select Contacts");
		redistributeVideoPage.selectVideoContacts();

		logger.info("Video Redistribution Steps Completed Successfully");
	}
}
