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
import com.stratapps.xamplify.pages.UploadAssetPage;
import com.stratapps.xamplify.pages.AccessSharedAssetsPage;
import com.stratapps.xamplify.utils.ConfigReader;


	public class AccessSharedAssetsTest extends BaseTest {

		private AccessSharedAssetsPage accessSharedAssetsPage;
		private static final Logger logger = LogManager.getLogger(AccessSharedAssetsTest.class);
		private WebDriverWait wait;
		
		
		
		@BeforeClass
		public void setUpClass() {
			try {
				accessSharedAssetsPage = new AccessSharedAssetsPage(driver);
				wait = new WebDriverWait(driver, Duration.ofSeconds(60));
				logger.info("OnboardingPartnerPage setup completed");
			} catch (Exception e) {
				System.out.println("Note: Hide multiple classes Run");
			}
			try {
				super.setUp();
				LoginPage loginPage = new LoginPage(driver);
				loginPage.loginAsPartner();
				accessSharedAssetsPage = new AccessSharedAssetsPage(driver);
				wait = new WebDriverWait(driver, Duration.ofSeconds(60));
				logger.info("OnboardingPartnerPage setup completed");
			} catch (Exception e) {
				System.out.println("Note: single class Run Fail");
			}
		}
		
		
		
		
		


    @Test(priority = 1, enabled = false)
    public void testHoverTeam() {
        logger.info("Test 1: Hover Team - STARTED");	
        accessSharedAssetsPage.accesssharedAssetSection();
        accessSharedAssetsPage.refreshAssetsPage();
        accessSharedAssetsPage.sortAssets("Name(Z-A)");
        accessSharedAssetsPage.sortAssets("Published On(DESC)");
        accessSharedAssetsPage.searchAsset("docx");
        accessSharedAssetsPage.openFilterAndApply("Asset Name", "Contains", "docx");
        accessSharedAssetsPage.viewActions();
        accessSharedAssetsPage.tilesActions("ppt");
        accessSharedAssetsPage.backtohome();
    }
    
    @Test(priority = 2, enabled = true)
    public void testAccessSharedAssetDetails() {
		logger.info("Test 2: Access Shared Asset Details - STARTED");	
		accessSharedAssetsPage.accesssharedAssetSection();
		accessSharedAssetsPage.accessAssetViewandDownloadOptions("png");
		accessSharedAssetsPage.accessAssetViewandDownloadOptions("pdf");
		accessSharedAssetsPage.accessAssetViewandDownloadOptions("ppt");
		accessSharedAssetsPage.videoActions("mp4");


		accessSharedAssetsPage.backtohome();
	}
	}