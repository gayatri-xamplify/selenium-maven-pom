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
import com.stratapps.xamplify.pages.DesignFormPage;
import com.stratapps.xamplify.pages.DesignTemplatesPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.ManageFormsPage;
import com.stratapps.xamplify.pages.ManageTemplatesPage;

public class ManageTemplatesTest extends BaseTest {
	private ManageTemplatesPage manageTemplatesPage;
	private DesignTemplatesPage designTemplatesPage;
	private static final Logger logger = LogManager.getLogger(ManageTemplatesTest.class);

	private ManageFormsPage manageFormsPage;
	private DesignFormPage designFormPage;
	private WebDriverWait wait;

	@BeforeClass
	public void setUpClass() {
		try {
			manageTemplatesPage = new ManageTemplatesPage(driver);
			designTemplatesPage = new DesignTemplatesPage(driver);
		} catch (Exception e) {
			System.out.println("Note: Hide multiple classes Run");
		}
		try {
			super.setUp();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginAsVendor();
			manageTemplatesPage = new ManageTemplatesPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			logger.info("ManageTemplatesPage setup completed");
		} catch (Exception e) {
			System.out.println("Note: single classes Run Fail");
		}
	}

	@Test(priority = 1, enabled = true)
	public void ManageEmailTemplate() throws InterruptedException, UnsupportedFlavorException, IOException {
		System.out.println(" ");
		logger.info("Starting test: ManageEmailTemplate");
		manageTemplatesPage.NavigateToManageTempates();
		designTemplatesPage.selectTemplateTab("Email");
//		manageTemplatesPage.editTemplate();
		manageTemplatesPage.copyTemplate();
	    manageTemplatesPage.SpamCheck();
		manageTemplatesPage.SendTestMail();
		manageTemplatesPage.PreviewTemplate();
		manageTemplatesPage.SearchTemplate("Template");
		manageTemplatesPage.DeleteTemplate();
		manageTemplatesPage.pagination();

		logger.info("Manage Email Template- Edit, copy, preview, copyFormUrl, delete form is succesfull");
		System.out.println(" ");
	}

	/*
	 * @Test(priority = 4, enabled = true) public void
	 * ManageEmailCobrandingTemplate() throws InterruptedException {
	 * System.out.println(" "); logger.info("Starting test: ManageEmailTemplate");
	 * manageTemplatesPage.NavigateToManageTempates();
	 * designTemplatesPage.selectTemplateTab("Email Co-Branding");
	 * manageTemplatesPage.copyTemplate(); manageTemplatesPage.SpamCheck();
	 * manageTemplatesPage.SendTestMail(); manageTemplatesPage.PreviewTemplate();
	 * manageTemplatesPage.SearchTemplate("Template");
	 * manageTemplatesPage.DeleteTemplate(); // manageTemplatesPage.pagination();
	 * 
	 * logger.
	 * info("Manage Email Co-branding Template- Edit, copy, preview, copyFormUrl, delete form is succesfull"
	 * ); System.out.println(" "); }
	 * 
	 * @Test(priority = 2, enabled = true) public void ManageVideoTemplate() throws
	 * InterruptedException { System.out.println(" ");
	 * logger.info("Starting test: ManageEmailTemplate");
	 * manageTemplatesPage.NavigateToManageTempates();
	 * designTemplatesPage.selectTemplateTab("Video");
	 * manageTemplatesPage.copyTemplate(); manageTemplatesPage.SpamCheck();
	 * manageTemplatesPage.SendTestMail(); manageTemplatesPage.PreviewTemplate();
	 * manageTemplatesPage.SearchTemplate("Template");
	 * manageTemplatesPage.DeleteTemplate(); // manageTemplatesPage.pagination();
	 * 
	 * logger.
	 * info("Manage Video Template- Edit, copy, preview, copyFormUrl, delete form is succesfull"
	 * ); System.out.println(" "); }
	 * 
	 * @Test(priority = 5, enabled = true) public void
	 * ManageVideoCobrandingTemplate() throws InterruptedException,
	 * UnsupportedFlavorException, IOException { System.out.println(" ");
	 * logger.info("Starting test: ManageVideo Co-Branding Template");
	 * manageTemplatesPage.NavigateToManageTempates();
	 * designTemplatesPage.selectTemplateTab("Video Co-Branding");
	 * manageTemplatesPage.copyTemplate(); manageTemplatesPage.SendTestMail();
	 * manageTemplatesPage.SpamCheck(); manageTemplatesPage.PreviewTemplate();
	 * manageTemplatesPage.SearchTemplate("Template");
	 * manageTemplatesPage.DeleteTemplate(); // manageTemplatesPage.pagination();
	 * 
	 * logger.
	 * info("Manage Video Co-branding Template- Edit, copy, preview, copyFormUrl, delete form is succesfull"
	 * ); System.out.println(" "); }
	 * 
	 * @Test(priority = 3, enabled = true) public void ManageEventTemplate() throws
	 * InterruptedException { System.out.println(" ");
	 * logger.info("Starting test: ManageEmailTemplate");
	 * manageTemplatesPage.NavigateToManageTempates();
	 * designTemplatesPage.selectTemplateTab("Event");
	 * manageTemplatesPage.copyTemplate(); manageTemplatesPage.SendTestMail();
	 * manageTemplatesPage.SpamCheck(); manageTemplatesPage.PreviewTemplate();
	 * manageTemplatesPage.SearchTemplate("Template");
	 * manageTemplatesPage.DeleteTemplate(); // manageTemplatesPage.pagination();
	 * 
	 * logger.
	 * info("Manage Event Template- Edit, copy, preview, copyFormUrl, delete form is succesfull"
	 * ); System.out.println(" "); }
	 * 
	 * @Test(priority = 6, enabled = true) public void
	 * ManageEventCobrandingTemplate() throws InterruptedException,
	 * UnsupportedFlavorException, IOException { System.out.println(" ");
	 * logger.info("Starting test: ManageVideo Co-Branding Template");
	 * manageTemplatesPage.NavigateToManageTempates();
	 * designTemplatesPage.selectTemplateTab("Event Co-Branding");
	 * manageTemplatesPage.copyTemplate(); manageTemplatesPage.SpamCheck();
	 * manageTemplatesPage.SendTestMail(); manageTemplatesPage.PreviewTemplate();
	 * manageTemplatesPage.SearchTemplate("Template");
	 * manageTemplatesPage.DeleteTemplate(); // manageTemplatesPage.pagination();
	 * 
	 * logger.
	 * info("Manage Event Co-branding Template- Edit, copy, preview, copyFormUrl, delete form is succesfull"
	 * ); System.out.println(" "); }
	 */
}
