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
import com.stratapps.xamplify.pages.ManageTracksPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class ManageTracksTest extends BaseTest {

    private ManageTracksPage manageTracksPage;
    private static final Logger logger = LogManager.getLogger(ManageTracksTest.class);
    private WebDriverWait wait;

	/*
	 * @BeforeClass public void setUpClass() { super.setUp(); LoginPage loginPage =
	 * new LoginPage(driver); loginPage.login(ConfigReader.getProperty("username"),
	 * ConfigReader.getProperty("password")); manageTracksPage = new
	 * ManageTracksPage(driver); wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(60)); logger.info("ManageTracksTest setup completed"); }
	 */

    
    
    @BeforeClass public void setUpClass() {
    
    manageTracksPage = new
    		  ManageTracksPage(driver);
    
    
    }
    
    @Test(priority = 1, enabled = true)
    public void navigateToManageTracksTest() {
        logger.info("Test 1: Navigate to Manage Tracks - STARTED");
        manageTracksPage.navigateToContentAndManageTracks();
        logger.info("Test 1: Navigate to Manage Tracks - COMPLETED");
    }

    @Test(priority = 2, enabled = true)
    public void editTrackDetailsTest() {
        logger.info("Test 2: Edit Track Details - STARTED");
        manageTracksPage.editTrackDetails();
        logger.info("Test 2: Edit Track Details - COMPLETED");
    }

    @Test(priority = 3, enabled = true)
    public void unpublishTrackTest() {
        logger.info("Test 3: Unpublish Track - STARTED");
        manageTracksPage.unpublishTrack();
        logger.info("Test 3: Unpublish Track - COMPLETED");
    }

    @Test(priority = 4, enabled = true)
    public void publishTrackTest() {
        logger.info("Test 4: Publish Track - STARTED");
        manageTracksPage.publishTrack();
        logger.info("Test 4: Publish Track - COMPLETED");
    }

    @Test(priority = 5, enabled = true)
    public void previewTrackTest() {
        logger.info("Test 5: Preview Track - STARTED");
        manageTracksPage.previewTrackAndReturn();
        logger.info("Test 5: Preview Track - COMPLETED");
    }

    @Test(priority = 6, enabled = true)
    public void trackAnalyticsTest() {
        logger.info("Test 6: Track Analytics - STARTED");
        manageTracksPage.viewTrackAnalytics();
        logger.info("Test 6: Track Analytics - COMPLETED");
    }

    @Test(priority = 7, enabled = true)
    public void sortAndDeleteTrackTest() {
        logger.info("Test 7: Sort and Delete Track - STARTED");
        manageTracksPage.sortAndDeleteTrack();
        logger.info("Test 7: Sort and Delete Track - COMPLETED");
    }

    @Test(priority = 8, enabled = true)
    public void trackViewsTest() throws AWTException {
        logger.info("Test 8: Track Views - STARTED");
        manageTracksPage.trackViews("D:\\Track_img\\Thumbnail_file.jpg");
        logger.info("Test 8: Track Views - COMPLETED");
    }
}

