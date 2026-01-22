package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.ContactsPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.ManageContactsPage;
import com.stratapps.xamplify.pages.ManageVideoCampaignPage;

public class ManageVideoCampaignTest extends BaseTest {

    private ManageVideoCampaignPage manageVideoCampaignPage;
    private static final Logger logger = LogManager.getLogger(ManageVideoCampaignTest.class);
    private WebDriverWait wait;
	@BeforeClass(alwaysRun = true)
public void setUpClass() {
    logger.info("🔧 Setting up ManageVideoCampaignTest");

    // At this point:
    // - Browser is already launched (@BeforeSuite)
    // - Partner login is already done (@Parameters role=PARTNER)

    manageVideoCampaignPage = new ManageVideoCampaignPage(driver);
    wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    logger.info("✅ ManageVideoCampaignTest setup completed");
}
    
    @Test(priority = 1)
    public void testManageVideoCampaignFullFlow() throws Exception {
        logger.info("Test: Manage Video Campaign full flow - STARTED");
        manageVideoCampaignPage.manageVideoCampaignFullFlow();
        logger.info("Test: Manage Video Campaign full flow - COMPLETED");
    }
}
