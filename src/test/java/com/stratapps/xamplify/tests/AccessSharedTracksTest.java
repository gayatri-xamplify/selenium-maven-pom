package com.stratapps.xamplify.tests;

import java.awt.AWTException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.AccessSharedTracksPage;
import com.stratapps.xamplify.utils.ConfigReader;


	public class AccessSharedTracksTest extends BaseTest {

		private AccessSharedTracksPage accessSharedTracksPage;
		private static final Logger logger = LogManager.getLogger(AccessSharedTracksTest.class);
		private WebDriverWait wait;

		@BeforeClass
		public void setUpClass() {
			super.setUp();
	        logoutIfLoggedIn();

			LoginPage loginPage = new LoginPage(driver);
			loginPage.login(ConfigReader.getProperty("partner.username"), ConfigReader.getProperty("partner.password"));
			
		
			accessSharedTracksPage = new AccessSharedTracksPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			logger.info("TeamVendorTest setup completed");
		}


    @Test(priority = 1, enabled = true)
    public void testHoverTeam() throws Exception {
        logger.info("Test 1: Hover Team - STARTED");	
        accessSharedTracksPage.accesssharedTrackSection();
        accessSharedTracksPage.refreshTracksPage();
//        accessSharedTracksPage.sortTracks("Name(Z-A)");
//        accessSharedTracksPage.sortTracks("Published On(DESC)");
        //accessSharedTracksPage.searchTrack("Track");
        accessSharedTracksPage.viewTrackAndClickAssets();
        //accessSharedTracksPage.openFilterAndApply("Asset Name", "Contains", "docx");
        //accessSharedTracksPage.viewActions();
        accessSharedTracksPage.fillAllMandatoryFieldsWithVerification();
//        accessSharedTracksPage.backtohome();
    }
}