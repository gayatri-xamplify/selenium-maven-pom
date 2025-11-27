package com.stratapps.xamplify.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.CloseableThreadContext.Instance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.EmailCampaignPage;
import com.stratapps.xamplify.pages.EventCampaignPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.UploadAssetPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class EventCampaignTest extends BaseTest {

   
    private EventCampaignPage eventCampaignPage;
    private static final Logger logger = LogManager.getLogger(EventCampaignTest.class);
    private WebDriverWait wait;

    
    @BeforeClass
	public void setUpClass() {
		try {
	    	  eventCampaignPage = new EventCampaignPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			logger.info("EventCampaign setup completed");
		} catch (Exception e) {
			System.out.println("Note: Hide multiple classes Run");
		}
		try {
			super.setUp();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginAsVendor();
	    	  eventCampaignPage = new EventCampaignPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			logger.info("EventCampaign setup completed");
		} catch (Exception e) {
			System.out.println("Note: single class Run Fail");
		}
	}
    
	
    
    
  

       @Test(priority = 1, enabled = true)
       public void createEmailCampaignTest() throws Exception {
    	   eventCampaignPage.createEventCampaign("EventCampaign");
    	   eventCampaignPage.selectPartnerList();
    	   eventCampaignPage.selectTemplate();

    }
}
