package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.ManageEmailCampaignPage;

public class ManageEmailCampaignTest extends BaseTest {

    private ManageEmailCampaignPage manageEmailCampaignPage;
    private static final Logger logger = LogManager.getLogger(ManageEmailCampaignTest.class);
    private WebDriverWait wait;

    @BeforeClass
    public void setUpClass() {
        try {
            manageEmailCampaignPage = new ManageEmailCampaignPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            logger.info("ManageEmailCampaignTest initial setup (multi-class) completed");
        } catch (Exception e) {
            System.out.println("Multi-class Setup: Ignored");
        }

        try {
            super.setUp();
            LoginPage loginPage = new LoginPage(driver);
            // adjust if you need loginAsPartner()
            loginPage.loginAsVendor();

            manageEmailCampaignPage = new ManageEmailCampaignPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            logger.info("ManageEmailCampaignTest setup completed with login");
        } catch (Exception e) {
            System.out.println("Single class Setup Failed");
        }
    }

    @Test(priority = 1)
    public void testManageEmailCampaignFullFlow() throws Exception {
        logger.info("Test: Manage Email Campaign full flow - STARTED");
        manageEmailCampaignPage.manageEmailCampaignFullFlow();
        logger.info("Test: Manage Email Campaign full flow - COMPLETED");
    }
}
