package com.stratapps.xamplify.tests;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.ContactsPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.utils.ConfigReader;

//import com.stratapps.xamplify.utils.PropertiesFile;
//import com.stratapps.xamplify.base.Instance;

import org.apache.logging.log4j.Logger;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;

public class ContactsTest extends BaseTest  {

  //  private WebDriver driver;
	private WebDriverWait wait;

    private ContactsPage contactsPage;
    private static final Logger logger = LogManager.getLogger(ContactsTest.class);

    @BeforeClass
    public void setUp() {
        logger.info("✅ Initializing WebDriver and ContactsPage...");
  
    		super.setUp();
    		logoutIfLoggedIn();

    		LoginPage loginPage = new LoginPage(driver);
    		loginPage.login(ConfigReader.getProperty("partner.username"), ConfigReader.getProperty("partner.password"));

    		contactsPage = new ContactsPage(driver);
    		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    		logger.info("SharedleadsTest setup completed");
    	}
        


    @Test(priority = 1, enabled = true)
    public void testAddContact_OneAtATime() {
        logger.info("🚀 Starting test: Add Contact - One At A Time");
        try {
            contactsPage.hoverContacts();
            contactsPage.clickAddContacts();
            contactsPage.completeOneAtATimeFlow();
            logger.info("✅ Test Passed: Add Contact - One At A Time");
        } catch (Exception e) {
            logger.error("❌ Test Failed: Add Contact - One At A Time", e);
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 2, enabled = false)
    public void testUploadContacts_CSV() {
        logger.info("🚀 Starting test: Upload Contacts via CSV");
        try {
            contactsPage.hoverContacts();
            contactsPage.clickAddContacts();
            contactsPage.uploadCSVAndHandle();
            logger.info("✅ Test Passed: Upload Contacts via CSV");
        } catch (Exception e) {
            logger.error("❌ Test Failed: Upload Contacts via CSV", e);
            throw new RuntimeException(e);
        }
    }

	/*
	 * @AfterClass public void tearDown() { if (driver != null) {
	 * logger.info("🔚 Quitting WebDriver..."); // Instance.quitInstance(); } }
	 */
}
