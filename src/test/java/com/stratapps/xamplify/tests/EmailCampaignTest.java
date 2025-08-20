package com.stratapps.xamplify.tests;

import java.awt.AWTException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.EmailCampaignPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class EmailCampaignTest extends BaseTest {

    private EmailCampaignPage emailCampaignPage;
    private static final Logger logger = LogManager.getLogger(EmailCampaignTest.class);
    private WebDriverWait wait;

    
      @BeforeClass
      public void setUpClass() {
          super.setUp();
          LoginPage loginPage = new LoginPage(driver);
          loginPage.login(ConfigReader.getProperty("username"),
                         ConfigReader.getProperty("password"));
          emailCampaignPage = new EmailCampaignPage(driver);
          wait = new WebDriverWait(driver, Duration.ofSeconds(60));
          logger.info("EmailCampaignTest setup completed");
      }
     

   
//    @Test(priority = 1, enabled = true)
//    public void navigateToEmailCampaignTest() {
//        logger.info("Test 1: Navigate to Email Campaign - STARTED");
//        emailCampaignPage.navigateToEmailCampaign();
//        logger.info("Test 1: Navigate to Email Campaign - COMPLETED");
//    }

    @Test(priority = 1, enabled = true)
    public void createEmailCampaignTest() {
        logger.info("Test 2: Create Email Campaign - STARTED");
        emailCampaignPage.createEmailCampaign("mounika", "mounikatest", "mounisubject", "chmounika@stratapps.com", "sub");
        logger.info("Test 2: Create Email Campaign - COMPLETED");
    }

//    @Test(priority = 3, enabled = false)
//    public void previewTemplateTest() {
//        logger.info("Test 3: Preview Email Template - STARTED");
//        emailCampaignPage.previewTemplate();
//        logger.info("Test 3: Preview Email Template - COMPLETED");
//    }
//
//    @Test(priority = 4, enabled = false)
//    public void sendTestEmailTest() {
//        logger.info("Test 4: Send Test Email - STARTED");
//        emailCampaignPage.sendTestEmail("test@example.com", "Test Subject");
//        logger.info("Test 4: Send Test Email - COMPLETED");
//    }
//
//    @Test(priority = 5, enabled = false)
//    public void performSpamCheckTest() {
//        logger.info("Test 5: Perform Spam Check - STARTED");
//        emailCampaignPage.performSpamCheck();
//        logger.info("Test 5: Perform Spam Check - COMPLETED");
//    }
//
//    @Test(priority = 6, enabled = false)
//    public void saveCampaignTest() {
//        logger.info("Test 6: Save Campaign - STARTED");
//        emailCampaignPage.saveCampaign();
//        logger.info("Test 6: Save Campaign - COMPLETED");
//    }
//
//    @Test(priority = 7, enabled = false)
//    public void previewCampaignAndReturnTest() {
//        logger.info("Test 7: Preview Campaign - STARTED");
//        emailCampaignPage.previewCampaignAndReturn();
//        logger.info("Test 7: Preview Campaign - COMPLETED");
//    }
//
//    @Test(priority = 8, enabled = false)
//    public void verifyCampaignResponseMessageTest() {
//        logger.info("Test 8: Verify Response Message - STARTED");
//        emailCampaignPage.verifyResponseMessage();
//        logger.info("Test 8: Verify Response Message - COMPLETED");
//    }
}
