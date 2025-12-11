package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.ManageVideoCampaignPage;

public class ManageVideoCampaignTest extends BaseTest {

    private ManageVideoCampaignPage manageVideoCampaignPage;
    private static final Logger logger = LogManager.getLogger(ManageVideoCampaignTest.class);
    private WebDriverWait wait;

    @BeforeClass
    public void setUpClass() {
        try {
            manageVideoCampaignPage = new ManageVideoCampaignPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            logger.info("ManageVideoCampaignTest initial setup (multi-class) completed");
        } catch (Exception e) {
            System.out.println("Multi-class Setup: Ignored");
        }

        
        try {
            super.setUp();
            LoginPage loginPage = new LoginPage(driver);
            // adjust if you need loginAsPartner()
            loginPage.loginAsVendor();

            manageVideoCampaignPage = new ManageVideoCampaignPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            logger.info("ManageVideoCampaignTest setup completed with login");
        } catch (Exception e) {
            System.out.println("Single class Setup Failed");
        }
    }

    @Test(priority = 1)
    public void testManageVideoCampaignFullFlow() throws Exception {
        logger.info("Test: Manage Video Campaign full flow - STARTED");
        manageVideoCampaignPage.manageVideoCampaignFullFlow();
        logger.info("Test: Manage Video Campaign full flow - COMPLETED");
    }
}
