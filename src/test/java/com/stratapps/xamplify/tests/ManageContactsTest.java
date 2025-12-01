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
		manageContactsPage.hoverContacts_ManageContacts("MyContacts");
		manageContactsPage.DeleteContactList();
		manageContactsPage.EditContactList("MyContacts");
		manageContactsPage.CopyContactList();
		manageContactsPage.publishCampaign();
	}

	@Test(priority = 2, enabled = false)
	public void FormContactsActions() throws Exception {
		Thread.sleep(3000);
		manageContactsPage.hoverContacts_ManageContacts("FormContact");
		manageContactsPage.CopyContactList();
		manageContactsPage.EditContactList("FormContact");
	}

	@Test(priority = 4, enabled = true)
	public void CompanyContactsActions() throws Exception {
		Thread.sleep(3000);
		manageContactsPage.hoverContacts_ManageContacts("CompanyContact");
		manageContactsPage.CopyContactList();
		manageContactsPage.EditContactList("CompanyContact");
		manageContactsPage.publishCampaign();
	}

	@Test(priority = 5, enabled = true)
	public void ContactTilesvalidation() throws Exception {
		manageContactsPage.hoverContacts_ManageContacts("MyContacts");
		manageContactsPage.ManageContactsTilesCountValidation();
		manageContactsPage.ExportExcelReport();
	}

    @Test(priority = 6, enabled = true)
	public void ManageContactPagination() throws Exception {
    	manageContactsPage.ManageContactPagination();
    }

}
