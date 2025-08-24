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
import com.stratapps.xamplify.pages.SaveVideoCampaignPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class SaveVideoCampaignTest extends BaseTest {

    private VideoCampaignPage videoCampaignPage;
    private SaveVideoCampaignPage saveVideoCampaignPage;
    private WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(SaveVideoCampaignTest.class);

    @BeforeClass
    public void setUpClass() {
        // If login is already handled in BaseTest, skip below
//         LoginPage loginPage = new LoginPage(driver);
//         loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        videoCampaignPage = new VideoCampaignPage(driver);
        saveVideoCampaignPage = new SaveVideoCampaignPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        logger.info("SaveVideoCampaignTest setup completed");
    }
    @Test(priority = 1, enabled = true)
    public void createAndSaveVideoCampaignTest() {
        logger.info("Test 1: Create and Save Video Campaign - STARTED");

        // Step 1: Create Video Campaign
        videoCampaignPage.createVideoCampaign(
      
            "MounikaSaveVideoTest",
            "SaveVideoSubject",
            "chmounika@stratapps.com",
            "SaveVideoSub"
        );

        // Step 2: Select partner list
        videoCampaignPage.selectPartnerList();

        // Step 3: Save Campaign
        saveVideoCampaignPage.saveVideoCampaign(
            "mounika@xamplify.com",
            "Save Video Subject"
        );

        logger.info("✅ Test 1: Create and Save Video Campaign - COMPLETED");
    }
}
