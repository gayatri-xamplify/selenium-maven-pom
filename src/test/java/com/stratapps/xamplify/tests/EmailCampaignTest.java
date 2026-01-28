package com.stratapps.xamplify.tests;

import java.awt.AWTException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.AddPlaybooksPage;
import com.stratapps.xamplify.pages.EmailCampaignPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.ScheduleVideoCampaignPage;
import com.stratapps.xamplify.pages.VideoCampaignPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class EmailCampaignTest extends BaseTest {

    private EmailCampaignPage emailCampaignPage;
    private static final Logger logger = LogManager.getLogger(EmailCampaignTest.class);
    private WebDriverWait wait;


	
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {

	    logger.info("🔧 Setting up EmailCampaignTest");

	    // Preconditions guaranteed by BaseTest:
	    // - Browser already launched
	    // - Partner already logged in (role=PARTNER)

	    emailCampaignPage = new EmailCampaignPage(driver);
	    wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    logger.info("✅ EmailCampaignTest setup completed");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * @BeforeClass public void setUpClass() { // super.setUp(); // LoginPage
	 * loginPage = new LoginPage(driver); //
	 * loginPage.login(ConfigReader.getProperty("username"), //
	 * ConfigReader.getProperty("password")); emailCampaignPage = new
	 * EmailCampaignPage(driver); wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(60)); logger.info("EmailCampaignTest setup completed"); }
	 */
     

   
//    @Test(priority = 1, enabled = true)
//    public void navigateToEmailCampaignTest() {
//        logger.info("Test 1: Navigate to Email Campaign - STARTED");
//        emailCampaignPage.navigateToEmailCampaign();
//        logger.info("Test 1: Navigate to Email Campaign - COMPLETED");
//    }


    @Test(priority = 1, enabled = true)
    public void createEmailCampaignTest() {
        logger.info("Test 2: Create Email Campaign - STARTED");
        emailCampaignPage.createEmailCampaign(
        	    "mounika", 
        	    "mounikatest", 
        	    "mounisubject", 
        	    "chmounika@stratapps.com", 
        	    "sub"
        	);

        logger.info("Test 2: Create Email Campaign - COMPLETED");
    }

    @Test(priority = 3, enabled = true)
    public void selectPartnerList() {
        logger.info("Test 3: Select Partner List - STARTED");
        emailCampaignPage.selectPartnerList();
        logger.info("Test 3: Select Partner List - COMPLETED");
  

}
}