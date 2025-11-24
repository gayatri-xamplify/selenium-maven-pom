package com.stratapps.xamplify.tests;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.SurveyCampaignPage;
import com.stratapps.xamplify.pages.ScheduleSurveyCampaignPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class ScheduleSurveyCampaignTest extends BaseTest {

    private SurveyCampaignPage SurveyCampaignPage;
    private ScheduleSurveyCampaignPage scheduleSurveyCampaignPage;
    private WebDriverWait wait;

    private static final Logger logger = LogManager.getLogger(ScheduleSurveyCampaignTest.class);

    @BeforeClass
    public void setUpClass() {
        super.setUp();
    
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        SurveyCampaignPage = new SurveyCampaignPage(driver);
        scheduleSurveyCampaignPage = new ScheduleSurveyCampaignPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        logger.info("ScheduleSurveyCampaignTest setup completed");
    }

    @Test(priority = 1, enabled = true)
    public void createAndScheduleSurveyCampaignTest() {
        logger.info("Test 1: Create and Schedule Survey Campaign - STARTED");

        // Step 1: Create campaign
        SurveyCampaignPage.createSurveyCampaign(
            "Survey_Schedule_Campaign",
            "SurveyScheduleTest",
            "SurveyscheduleSubject",
            "mounika@xamplify.com",
            "scheduleSub"
        );

        // Step 2: Select partner list
        SurveyCampaignPage.selectPartnerList();
        // Step 3: Schedule campaign (SINGLE CALL only)
        scheduleSurveyCampaignPage.scheduleSurveyCampaign("India");

        logger.info("✅ Test 1: Create and Schedule Survey Campaign - COMPLETED");
    }
}
