package com.stratapps.xamplify.tests;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.EmailCampaignPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.RedistributeEmailCampaignPage;
import com.stratapps.xamplify.pages.SaveEmailCampaignPage;
import com.stratapps.xamplify.pages.ScheduleVideoCampaignPage;
import com.stratapps.xamplify.pages.VideoCampaignPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class SaveEmailCampaignTest extends BaseTest {

    private EmailCampaignPage emailCampaignPage;
    private SaveEmailCampaignPage saveEmailCampaignPage;

    private WebDriverWait wait;

    private static final Logger logger = LogManager.getLogger(SaveEmailCampaignTest.class);
    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        logger.info("🔧 Setting up SaveEmailCampaignTest");

        // At this point:
        // - Browser is already launched (@BeforeSuite)
        // - Partner login is already done (@Parameters role=PARTNER)

        emailCampaignPage = new EmailCampaignPage(driver);
        saveEmailCampaignPage = new SaveEmailCampaignPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        logger.info("✅ SaveEmailCampaignTest setup completed");
    }
	
	
    @Test(priority = 1, enabled = true)
    public void createAndSaveEmailCampaignTest() {
        logger.info("Test 1: Create and Save Email Campaign - STARTED");

        // Step 1: Create campaign
        emailCampaignPage.createEmailCampaign(
        		"Email_Save_Campaign", "EmailSaveTest", "EmailsaveSubject",
				"mounika@xamplify.com", "EmailsaveSub");
      

        // Step 2: Select partner list
        emailCampaignPage.selectPartnerList();

        // Step 3: Save campaign (single call to page class)
        saveEmailCampaignPage.saveEmailCampaign("mounika@xamplify.com","SaveEmailSubject");

        logger.info("✅ Test 1: Create and Save Email Campaign - COMPLETED");
    }
}

