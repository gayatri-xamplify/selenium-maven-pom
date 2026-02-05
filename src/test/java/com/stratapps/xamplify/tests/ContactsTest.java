package com.stratapps.xamplify.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.*;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.ContactsPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.ScheduleVideoCampaignPage;
import com.stratapps.xamplify.pages.TeamVendorPage;
import com.stratapps.xamplify.pages.VideoCampaignPage;
import com.stratapps.xamplify.utils.ConfigReader;

//import com.stratapps.xamplify.utils.PropertiesFile;
//import com.stratapps.xamplify.base.Instance;

import org.apache.logging.log4j.Logger;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;

public class ContactsTest extends BaseTest {

	private WebDriverWait wait;
	private ContactsPage contactsPage;
	private static final Logger logger = LogManager.getLogger(ContactsTest.class);
	
	@BeforeClass(alwaysRun = true) //written by gayatri
	public void setUpClass() {
	    try {
	        logger.info("🔧 Setting up ContactsTest");

	        new WebDriverWait(driver, Duration.ofSeconds(30))
	                .until(ExpectedConditions.jsReturnsValue(
	                        "return document.readyState === 'complete'"
	                ));

	        contactsPage = new ContactsPage(driver);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	        logger.info("✅ ContactsTest setup completed");

	    } catch (Exception e) {
	        logger.error("❌ ContactsTest @BeforeClass failed", e);
	        throw new RuntimeException("ContactsTest setup failed", e);
	    }
	}

	
	
	
	
	
	


	
	  @Test(priority = 1, enabled = true) public void AddPublicContact_OneAtATime()
	  throws Exception {
	  logger.info("🚀 Starting test: Add Contact - One At A Time");
	  contactsPage.hoverContacts(); contactsPage.completeOneAtATimeFlow("Public");
	  logger.info("✅ Test Passed: Add Contact - One At A Time"); }
	  
	  @Test(priority = 2, enabled = true) public void
	  AddPrivateContact_OneAtATime() throws Exception {
	  logger.info("🚀 Starting test: Add Contact - One At A Time");
	  contactsPage.hoverContacts(); contactsPage.completeOneAtATimeFlow("Private");
	  logger.info("✅ Test Passed: Add Contact - One At A Time"); }
	  
	  @Test(priority = 3, enabled = true) public void
	  testUploadPublicContacts_CSV() throws Exception {
	  logger.info("🚀 Starting test: Upload Contacts via CSV");
	  contactsPage.hoverContacts(); contactsPage.uploadCSVContacts("Public",
	  "AddContacts"); logger.info("✅ Test Passed: Upload Contacts via CSV"); }
	  
	  @Test(priority = 4, enabled = true) public void
	  testUploadPrivateContacts_CSV() throws Exception {
	  logger.info("🚀 Starting test: Upload Contacts via CSV");
	  contactsPage.hoverContacts(); contactsPage.uploadCSVContacts("Private",
	  "AddContacts"); logger.info("✅ Test Passed: Upload Contacts via CSV"); }
	 
	
	@Test(priority = 5, enabled = true)
	public void AddCompanyInPublicContact_OneAtATime() throws Exception {
		logger.info("🚀 Starting test: Add Contact - One At A Time");
		contactsPage.hoverContacts();
		contactsPage.OneAtATimeContactAndAddCompany("Public");
		logger.info("✅ Test Passed: Add Contact - One At A Time");
	}
	
	@Test(priority = 6, enabled = true)
	public void AddCompanyInPraviteContact_OneAtATime() throws Exception {
		logger.info("🚀 Starting test: Add Contact - One At A Time");
		contactsPage.hoverContacts();
		contactsPage.OneAtATimeContactAndAddCompany("Private");
		logger.info("✅ Test Passed: Add Contact - One At A Time");
	}
	
	/*
	 * @AfterClass public void tearDown() { if (driver != null) {
	 * logger.info("🔚 Quitting WebDriver..."); // Instance.quitInstance(); } }
	 */
}
