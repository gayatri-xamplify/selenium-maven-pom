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
import com.stratapps.xamplify.pages.ManageEmailCampaignPage;

public class ManageEmailCampaignTest extends BaseTest {

    private ManageEmailCampaignPage manageEmailCampaignPage;
    private static final Logger logger = LogManager.getLogger(ManageEmailCampaignTest.class);
    private WebDriverWait wait;

	@BeforeClass(alwaysRun = true)
public void setUpClass() {
    logger.info("🔧 Setting up ManageEmailCampaignTest");

    // At this point:
    // - Browser is already launched (@BeforeSuite)
    // - Partner login is already done (@Parameters role=PARTNER)

    manageEmailCampaignPage = new ManageEmailCampaignPage(driver);

    wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    logger.info("✅ ManageEmailCampaignTest setup completed");
}

   

    @Test(priority = 1)
    public void testManageEmailCampaignFullFlow() throws Exception {
        logger.info("Test: Manage Email Campaign full flow - STARTED");
        manageEmailCampaignPage.manageEmailCampaignFullFlow();
        logger.info("Test: Manage Email Campaign full flow - COMPLETED");
    }
}
