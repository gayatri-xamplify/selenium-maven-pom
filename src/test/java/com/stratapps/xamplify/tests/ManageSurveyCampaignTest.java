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
import com.stratapps.xamplify.pages.ManageSurveyCampaignPage;

public class ManageSurveyCampaignTest extends BaseTest {

    private ManageSurveyCampaignPage manageSurveyCampaignPage;
    private static final Logger logger = LogManager.getLogger(ManageSurveyCampaignTest.class);
    private WebDriverWait wait;

	@BeforeClass(alwaysRun = true)
public void setUpClass() {
    logger.info("🔧 Setting up ManageContactsTest");

    // At this point:
    // - Browser is already launched (@BeforeSuite)
    // - Partner login is already done (@Parameters role=PARTNER)

    manageSurveyCampaignPage = new ManageSurveyCampaignPage(driver);

    wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    logger.info("✅ ManageContactsTest setup completed");
}
    
    
    @Test(priority = 1)
    public void testManageSurveyCampaignFullFlow() throws Exception {
        logger.info("Test: Manage Survey Campaign full flow - STARTED");
        manageSurveyCampaignPage.manageSurveyCampaignFullFlow();
        logger.info("Test: Manage Survey Campaign full flow - COMPLETED");
    }
}
