package com.stratapps.xamplify.tests;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.DesignPages;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.ManageFormsPage;
import com.stratapps.xamplify.pages.ScheduleVideoCampaignPage;
import com.stratapps.xamplify.pages.VideoCampaignPage;

public class DesignPageTest extends BaseTest {
	private DesignPages designPages;
	private static final Logger logger = LogManager.getLogger(ManageFormsPage.class);
	private WebDriverWait wait;

	@BeforeClass
	public void setUpClass() {
		try {
			designPages = new DesignPages(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			logger.info("DesignFormPage setup completed");
		} catch (Exception e) {
			System.out.println("Note: Hide multiple classes Run");
		}
		try {
			super.setUp();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginAsVendor();
			designPages = new DesignPages(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			logger.info("DesignFormPage setup completed");
		} catch (Exception e) {
			System.out.println("Note: single class Run Fail");
		}
	}


	@Test(priority = 1, enabled = true)
	public void CreateRegularPublicPage() throws InterruptedException {
		System.out.println(" ");
		logger.info("Create Regular Public Page in Design Pages");
		designPages.designDesignPage();
		Thread.sleep(4000);
		designPages.clickPageTypeTab("Regular");
		Thread.sleep(4000);
		designPages.createPage("Regularpublicpage");
		logger.info("Successfully Created Regular Public Page in Design Pages");
		System.out.println(" ");
	}

	@Test(priority = 2, enabled = true)
	public void CreateRegularPrivatePage() throws InterruptedException {
		logger.info("Create Regular Private Page in Design Pages");
		designPages.designDesignPage();
		designPages.clickPageTypeTab("Regular");
		designPages.createPage("Regularprivatepage");
		logger.info("Successfully Created Regular Private Page in Design Pages");
		System.out.println(" ");
	}

	@Test(priority = 3, enabled = true)
	public void CreateRegularProtectedPage() throws InterruptedException {
		logger.info("Create Regular Protect Page in Design Pages");
		designPages.designDesignPage();
		designPages.clickPageTypeTab("Regular");
		designPages.createPage("RegularProtectPage");
		logger.info("Successfully Created Regular Protect Page in Design Pages");
		System.out.println(" ");
	}

	@Test(priority = 4, enabled = true)
	public void CreateCobrandedPublicPage() throws InterruptedException {
		logger.info("Create Cobranded Public Page in Design Pages");
		designPages.designDesignPage();
		designPages.clickPageTypeTab("Co-Branded");
		designPages.createPage("cobrandedpublicpage");
		logger.info("Successfully Created Cobranded Public Page in Design Pages");
		System.out.println(" ");
	}

	@Test(priority = 5, enabled = true)
	public void CreateCobrandedPrivatePage() throws InterruptedException {
		logger.info("Create Cobranded Private Page in Design Pages");
		designPages.designDesignPage();
		designPages.clickPageTypeTab("Co-Branded");
		designPages.createPage("cobrandedprivatepage");
		logger.info("Successfully Created Cobranded Private Page in Design Pages");
		System.out.println(" ");
	}

	@Test(priority = 6, enabled = true)
	public void CreateCobrandedProtectedPage() throws InterruptedException {
		logger.info("Create Cobranded Protect Page in Design Pages");
		designPages.designDesignPage();
		designPages.clickPageTypeTab("Co-Branded");
		designPages.createPage("cobrandedProtectPage");
		logger.info("Successfully Created Cobranded Protect Page in Design Pages");
		System.out.println(" ");
	}

	@Test(priority = 7, enabled = true)
	public void Regularpublicpage() throws InterruptedException, UnsupportedFlavorException, IOException {
		logger.info("Regular Public Page Actions in Manage Pages");
		designPages.designManagePage();
		designPages.PageTab("RegularPublic");
		designPages.searchPage("Page");
		designPages.copyPage();
		designPages.editpage();
		designPages.CopyAndEmbeddedPage();
		designPages.PreviewPage();
		designPages.PageAnalytics();
		designPages.DeletePage();
		logger.info(
				"Successfully copy, edit, preview, delete, Copy And Embedded Pages & Analytics actions for Regular Public Page in Manage Pages");
		System.out.println(" ");
	}

	@Test(priority = 8, enabled = true)
	public void Regularprivatepage() throws InterruptedException, UnsupportedFlavorException, IOException {
		System.out.println(" ");
		logger.info("Create Regular Private Page in Design Pages");
		designPages.designManagePage();
		designPages.PageTab("RegularPrivate");
		designPages.searchPage("Page");
		designPages.copyPage();
		designPages.editpage();
		designPages.CopyAndEmbeddedPage();
		designPages.PreviewPage();
		designPages.PageAnalytics();
		designPages.DeletePage();
		logger.info(
				"Successfully copy, edit, preview, delete, Copy And Embedded Pages & Analytics actions for Regular Private Page in Manage Pages");
		System.out.println(" ");
	}

	@Test(priority = 9, enabled = true)
	public void Regularprotectpage() throws InterruptedException, UnsupportedFlavorException, IOException {
		System.out.println(" ");
		logger.info("Create Regular Protect Page in Design Pages");
		designPages.designManagePage();
		designPages.PageTab("RegularProtect");
		designPages.searchPage("Page");
		designPages.copyPage();
		designPages.editpage();
		designPages.ProtectPageCopyURL();
		designPages.PreviewPage();
		designPages.ProtectPageAnalytics();
		designPages.DeletePage();
		logger.info(
				"Successfully copy, edit, preview, delete, Copy Pages & Analytics actions for Regular protect Page in Manage Pages");
		System.out.println(" ");
	}

	@Test(priority = 10, enabled = true)
	public void Cobrandedpublicpage() throws InterruptedException, UnsupportedFlavorException, IOException {
		System.out.println(" ");
		logger.info("Create Cobranded public Page in Design Pages");
		designPages.designManagePage();
		designPages.PageTab("CoBrandedPublic");
		designPages.searchPage("Page");
		designPages.copyPage();
		designPages.editpage();
		designPages.CopyAndEmbeddedPage();
		designPages.PreviewPage();
		designPages.PageAnalytics();
		designPages.DeletePage();
		logger.info(
				"Successfully copy, edit, preview, delete, Copy And Embedded Pages & Analytics actions for Cobranded Public Page in Manage Pages");
		System.out.println(" ");
	}

	@Test(priority = 11, enabled = true)
	public void Cobrandedprivatepage() throws InterruptedException, UnsupportedFlavorException, IOException {
		System.out.println(" ");
		logger.info("Create Cobranded Private Page in Design Pages");
		designPages.designManagePage();
		designPages.PageTab("CoBrandedPrivate");
		designPages.searchPage("Page");
		designPages.copyPage();
		designPages.editpage();
		designPages.CopyAndEmbeddedPage();
		designPages.PreviewPage();
		designPages.PageAnalytics();
		designPages.DeletePage();
		logger.info(
				"Successfully copy, edit, preview, delete, Copy And Embedded Pages & Analytics actions for CoBranded Private Page in Manage Pages");
		System.out.println(" ");
	}

	@Test(priority = 12, enabled = true)
	public void Cobrandedprotectpage() throws InterruptedException, UnsupportedFlavorException, IOException {
		System.out.println(" ");
		logger.info("Create Cobranded protect Page in Design Pages");
		designPages.designManagePage();
		designPages.PageTab("CoBrandedProtect");
		designPages.searchPage("Page");
		designPages.copyPage();
		designPages.editpage();
		designPages.ProtectPageCopyURL();
		designPages.PreviewPage();
		designPages.ProtectPageAnalytics();
		designPages.DeletePage();
		logger.info(
				"Successfully copy, edit, preview, delete, Copy Pages & Analytics actions for CoBranded Private Page in Manage Pages");
		System.out.println(" ");
	}
}