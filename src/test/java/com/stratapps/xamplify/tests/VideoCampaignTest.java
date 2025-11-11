package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.VideoCampaignPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.TeamVendorPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class VideoCampaignTest extends BaseTest {

    private VideoCampaignPage videoCampaignPage;
    private static final Logger logger = LogManager.getLogger(VideoCampaignTest.class);
    private WebDriverWait wait;

	@BeforeClass
	public void setUpClass() {
		try {
	        videoCampaignPage = new VideoCampaignPage(driver);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	        logger.info("VideoCampaignTest setup completed");
		} catch (Exception e) {
			System.out.println("Note: Hide multiple classes Run");
		}
		try {
			super.setUp();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginAsVendor();
	        videoCampaignPage = new VideoCampaignPage(driver);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	        logger.info("VideoCampaignTest setup completed");
		} catch (Exception e) {
			System.out.println("Note: single classes Run Fail");
		}
	}
	
	/*
	 * @BeforeClass public void setUpClass() { super.setUp(); LoginPage loginPage =
	 * new LoginPage(driver); loginPage.login(ConfigReader.getProperty("username"),
	 * ConfigReader.getProperty("password")); videoCampaignPage = new
	 * VideoCampaignPage(driver); wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(60)); logger.info("VideoCampaignTest setup completed"); }
	 */

//    @Test(priority = 1, enabled = true)
//    public void navigateToVideoCampaignTest() {
//        logger.info("Test 1: Navigate to Video Campaign - STARTED");
//        videoCampaignPage.createVideoCampaign();
//        logger.info("Test 1: Navigate to Video Campaign - COMPLETED");
//    }

    @Test(priority = 1, enabled = true)
    public void createVideoCampaignTest() {
        logger.info("Test 2: Create Video Campaign - STARTED");
        videoCampaignPage.createVideoCampaign(
                "Demo Video Campaign", 
                "Test Video Campaign", 
                "chmounik@stratapps.com",
                "Video Campaign Subject"
        );
        logger.info("Test 2: Create Video Campaign - COMPLETED");
    }

    @Test(priority = 3, enabled = true)
    public void selectPartnerListTest() {
        logger.info("Test 3: Select Partner List - STARTED");
        videoCampaignPage.selectPartnerList();
        logger.info("Test 3: Select Partner List - COMPLETED");
    }
}
