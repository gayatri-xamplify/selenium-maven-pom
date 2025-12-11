
package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.ManageEventCampaignPage;

public class ManageEventCampaignTest extends BaseTest {

    private ManageEventCampaignPage manageEventCampaignPage;
    private static final Logger logger = LogManager.getLogger(ManageEventCampaignTest.class);
    private WebDriverWait wait;

    @BeforeClass
    public void setUpClass() {
        try {
            manageEventCampaignPage = new ManageEventCampaignPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            logger.info("ManageEventCampaignTest initial setup (multi-class) completed");
        } catch (Exception e) {
            System.out.println("Multi-class Setup: Ignored");
        }

        try {
            super.setUp();
            LoginPage loginPage = new LoginPage(driver);
            // adjust if you need loginAsPartner()
            loginPage.loginAsVendor();

            manageEventCampaignPage = new ManageEventCampaignPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            logger.info("ManageEventCampaignTest setup completed with login");
        } catch (Exception e) {
            System.out.println("Single class Setup Failed");
        }
    }
        
        
        @Test(priority = 1)

        public void testManageEventCampaignFullFlow() {
            //ManageEventCampaignPage eventPage = new ManageEventCampaignPage(driver);

        	manageEventCampaignPage.navigateToManageEventCampaigns();
        	manageEventCampaignPage.openEventTab();
        	manageEventCampaignPage.copyAndLaunchEventCampaign();
        	manageEventCampaignPage.editEventCampaignFolder();
        	manageEventCampaignPage.sendPreviewEmailAndHandlePreviewDelete();
        	manageEventCampaignPage.gridViewPreviewAndUpdateEvent();
        	manageEventCampaignPage.archiveAndDeleteEventFromGrid();
        	manageEventCampaignPage.openEventAnalyticsAndReports();
        	manageEventCampaignPage.goToHomeFromEventAnalytics();
        }
        
        
        
        
        
    }
