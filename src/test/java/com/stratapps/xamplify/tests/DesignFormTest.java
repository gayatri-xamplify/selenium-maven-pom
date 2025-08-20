package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.DesignFormPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.OnboardingPartnerPage;

public class DesignFormTest extends BaseTest{

	
	private DesignFormPage designFormPage;
	private static final Logger logger = LogManager.getLogger(DesignFormPage.class);
	private WebDriverWait wait;


	 @BeforeClass public void setUpClass() {
	 super.setUp();
	 LoginPage loginPage =  new LoginPage(driver);
	 loginPage.loginAsVendor();
	 designFormPage = new DesignFormPage(driver);
	 wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	 logger.info("DesignFormPage setup completed"); }

	 @Test(priority = 1, enabled = true)
	 public void DesignForm() throws InterruptedException {
	  System.out.println(" ");
	 logger.info("Starting test: DesignFormPage");
	 designFormPage.Design_ClickDesignForm();
	 designFormPage.SelectFormTab("REGULAR");	
	 designFormPage.CreateForm();
	 
	 Thread.sleep(10000);
	  logger.info("Successfully onboarded partner using Upload CSV");
	  System.out.println(" ");
	 }  
}
