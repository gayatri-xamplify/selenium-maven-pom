package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.ContactsPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.ManageContactsPage;

public class ManageContactsTest extends BaseTest {
	private WebDriverWait wait;
	private ManageContactsPage manageContactsPage;
	private ContactsPage contactsPage;
	private static final Logger logger = LogManager.getLogger(ManageContactsTest.class);

	@BeforeClass
	public void setUpClass() {
		try {
			manageContactsPage = new ManageContactsPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		    contactsPage = new ContactsPage(driver);
			logger.info("ManageContactsTest setup completed");
		} catch (Exception e) {
			System.out.println("Note: Hide multiple classes Run");
		}
		try {
			super.setUp();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginAsPartner();
			contactsPage = new ContactsPage(driver);  
			manageContactsPage = new ManageContactsPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			logger.info("ManageContactsTest setup completed");
		} catch (Exception e) {
			System.out.println("Note: single class Run Fail");
		}  
	}
	
	
	
	
	
    @Test(priority = 1, enabled = true)
	public void NavigateToManageContacts() throws InterruptedException {
		Thread.sleep(3000);
		manageContactsPage.hoverContacts_ManageContacts();
//		manageContactsPage.clickContactsTab("All");
//		manageContactsPage.DeleteContactList();
//		manageContactsPage.CopyContactList();
		Thread.sleep(4000);
		manageContactsPage.ManageContactsTilesCountValidation();
	}
}




