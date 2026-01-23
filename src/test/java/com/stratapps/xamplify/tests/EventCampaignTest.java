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
import com.stratapps.xamplify.pages.AddPlaybooksPage;
import com.stratapps.xamplify.pages.EmailCampaignPage;
import com.stratapps.xamplify.pages.EventCampaignPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.UploadAssetPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class EventCampaignTest extends BaseTest {

   
    private EventCampaignPage eventCampaignPage;
    private static final Logger logger = LogManager.getLogger(EventCampaignTest.class);
    private WebDriverWait wait;

    
   

    
    @BeforeClass(alwaysRun = true)
	public void setUpClass() {

	    logger.info("🔧 Setting up EventCampaignTest");

	    // Preconditions guaranteed by BaseTest:
	    // - Browser already launched
	    // - Partner already logged in (role=PARTNER)

  	  eventCampaignPage = new EventCampaignPage(driver);
	    wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    logger.info("✅ EventCampaignTest setup completed");
	}

	
    
    
  

       @Test(priority = 1, enabled = true)
       public void createEmailCampaignTest() throws Exception {
    	   eventCampaignPage.createEventCampaign("EventCampaign");
    	   eventCampaignPage.selectPartnerList();
    	   eventCampaignPage.selectTemplate();

    }
}
