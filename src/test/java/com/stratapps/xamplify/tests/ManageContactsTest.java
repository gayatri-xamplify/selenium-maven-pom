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
		    contactsPage = new ContactsPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
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
	public void MyContactsActions() throws Exception {
		Thread.sleep(3000);
		manageContactsPage.hoverContacts_ManageContacts();
		manageContactsPage.DeleteContactList();
		manageContactsPage.EditContactList();
		manageContactsPage.CopyContactList();
		manageContactsPage.publishCampaign();
	}
    
	
//    @Test(priority = 2, enabled = true)
//	public void FormContactsActions() throws Exception {
//		Thread.sleep(3000);
//		manageContactsPage.hoverContacts_ManageContacts();
//		manageContactsPage.clickContactsTab("Form");
//		manageContactsPage.CopyContactList();
//		manageContactsPage.EditContactList();
//	}
//    
//    @Test(priority = 4, enabled = true)
//	public void CompanyContactsActions() throws Exception {
//		Thread.sleep(3000);
//		manageContactsPage.hoverContacts_ManageContacts();
//		manageContactsPage.clickContactsTab("Company");
//		manageContactsPage.CopyContactList();
//		manageContactsPage.EditContactList();
//		manageContactsPage.publishCampaign();
//	}
//    
//    @Test(priority = 8, enabled = true)
//	public void ContactTilesvalidation() throws Exception {
//		manageContactsPage.SearchContact("Test");
//		manageContactsPage.ExportExcelReport();
//		  
//	}
//    
//    @Test(priority = 9, enabled = true)
//	public void searchSortandExportReport() throws Exception {
//		manageContactsPage.ManageContactsTilesCountValidation();
//	}
    
    
}




