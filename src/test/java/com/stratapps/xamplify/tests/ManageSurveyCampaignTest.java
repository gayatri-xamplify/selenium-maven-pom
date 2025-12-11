package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.ManageSurveyCampaignPage;

public class ManageSurveyCampaignTest extends BaseTest {

    private ManageSurveyCampaignPage manageSurveyCampaignPage;
    private static final Logger logger = LogManager.getLogger(ManageSurveyCampaignTest.class);
    private WebDriverWait wait;

    @BeforeClass
    public void setUpClass() {
        try {
            manageSurveyCampaignPage = new ManageSurveyCampaignPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            logger.info("ManageSurveyCampaignTest initial setup (multi-class) completed");
        } catch (Exception e) {
            System.out.println("Multi-class Setup: Ignored");
        }

        try {
            super.setUp();
            LoginPage loginPage = new LoginPage(driver);
            // adjust if you need loginAsPartner()
            loginPage.loginAsVendor();

            manageSurveyCampaignPage = new ManageSurveyCampaignPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            logger.info("ManageSurveyCampaignTest setup completed with login");
        } catch (Exception e) {
            System.out.println("Single class Setup Failed");
        }
    }

    
    @Test(priority = 1)
    public void testManageSurveyCampaignFullFlow() throws Exception {
        logger.info("Test: Manage Survey Campaign full flow - STARTED");
        manageSurveyCampaignPage.manageSurveyCampaignFullFlow();
        logger.info("Test: Manage Survey Campaign full flow - COMPLETED");
    }
}
