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
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.ManageFormsPage;
import com.stratapps.xamplify.pages.ManageTemplatesPage;
import com.stratapps.xamplify.pages.ManageTracksPage;

public class ManageFormsTest extends BaseTest {

	private ManageFormsPage manageFormsPage;
	private DesignFormPage designFormPage;
	private static final Logger logger = LogManager.getLogger(ManageFormsPage.class);
	private WebDriverWait wait;

	@BeforeClass
	public void setUpClass() {
		try {
			manageFormsPage = new ManageFormsPage(driver);
			designFormPage = new DesignFormPage(driver);
		} catch (Exception e) {
			System.out.println("Note: Hide multiple classes Run");
		}
		try {
			super.setUp();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginAsVendor();
			manageFormsPage = new ManageFormsPage(driver);
			designFormPage = new DesignFormPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			logger.info("ManageFormsPage & DesignFormPage setup completed");
		} catch (Exception e) {
			System.out.println("Note: single classes Run Fail");
		}
	}

	@Test(priority = 1, enabled = true)
	public void ManageRegularForm() throws InterruptedException, UnsupportedFlavorException, IOException {
		System.out.println(" ");
		logger.info("Starting test: ManageRegularForm");
		manageFormsPage.Design_ClickManageForm();
		designFormPage.SelectFormTab("REGULAR");
		manageFormsPage.EditForm();
		designFormPage.SelectFormTab("REGULAR");
		manageFormsPage.CopyForm();
		designFormPage.SelectFormTab("REGULAR");
		manageFormsPage.PreviewForm();
		manageFormsPage.CopyFormURL();
		manageFormsPage.RegularFormAnalytics();
		manageFormsPage.DeleteForm();
		manageFormsPage.SearchForm();
		Thread.sleep(4000);
		logger.info("Manage Regular Form - Edit, copy, preview, copyFormUrl, delete form is succesfull");
		System.out.println(" ");
	}

	@Test(priority = 2, enabled = true)
	public void ManageQuizForm() throws InterruptedException, UnsupportedFlavorException, IOException {
		System.out.println(" ");
		logger.info("Starting test: Manage Quiz Form");
		manageFormsPage.Design_ClickManageForm();
		designFormPage.SelectFormTab("QUIZ");
		manageFormsPage.EditForm();
		designFormPage.SelectFormTab("QUIZ");
		manageFormsPage.CopyForm();
		designFormPage.SelectFormTab("QUIZ");
		manageFormsPage.PreviewForm();
		manageFormsPage.CopyFormURL();
		manageFormsPage.QuizFormAnalytics();
		manageFormsPage.DeleteForm();
		Thread.sleep(4000);
		logger.info("Manage Quiz Form - Edit, copy, preview, copyFormUrl, delete form is succesfull");
		System.out.println(" ");
	}

	@Test(priority = 3, enabled = true)
	public void ManageSurveyForm() throws InterruptedException, UnsupportedFlavorException, IOException {
		System.out.println(" ");
		logger.info("Starting test: Manage Survey Form");
		manageFormsPage.Design_ClickManageForm();
		designFormPage.SelectFormTab("SURVEY");
		manageFormsPage.EditForm();
		designFormPage.SelectFormTab("SURVEY");
		manageFormsPage.CopyForm();
		designFormPage.SelectFormTab("SURVEY");
		manageFormsPage.PreviewForm();
		manageFormsPage.CopyFormURL();
		manageFormsPage.SurveyFormAnalytics();
		manageFormsPage.DeleteForm();
		Thread.sleep(4000);
		logger.info("Manage Survey Form - Edit, copy, preview, copyFormUrl, delete form is succesfull");
		System.out.println(" ");
	}

	@Test(priority = 4, enabled = true)
	public void ManageRegularFormInGridView() throws InterruptedException, UnsupportedFlavorException, IOException {
		System.out.println(" ");
		logger.info("Starting test: ManageRegularForm");
		manageFormsPage.Design_ClickManageForm();
		designFormPage.SelectFormTab("REGULAR");
		manageFormsPage.SelectViewToGrid();
		manageFormsPage.HoveronFirstForm();
		manageFormsPage.EditForm();
		designFormPage.SelectFormTab("REGULAR");
		manageFormsPage.SelectViewToGrid();
		manageFormsPage.HoveronFirstForm();
		manageFormsPage.CopyForm();
		designFormPage.SelectFormTab("REGULAR");
		manageFormsPage.SelectViewToGrid();
		manageFormsPage.HoveronFirstForm();
		manageFormsPage.PreviewForm();
		manageFormsPage.HoveronFirstForm();
		manageFormsPage.CopyFormURL();
		// manageFormsPage.HoveronFirstForm();
		// Thread.sleep(2000);
		// manageFormsPage.RegularFormAnalytics();
		manageFormsPage.HoveronFirstForm();
		manageFormsPage.DeleteForm();
		Thread.sleep(4000);
		logger.info("Manage Regular Form - Edit, copy, preview, copyFormUrl, delete form is succesfull");
		System.out.println(" ");
	}

	@Test(priority = 5, enabled = true)
	public void ManageQuizFormInGridView() throws InterruptedException, UnsupportedFlavorException, IOException {
		System.out.println(" ");
		logger.info("Starting test: ManageRegularForm");
		manageFormsPage.Design_ClickManageForm();
		designFormPage.SelectFormTab("QUIZ");
		manageFormsPage.SelectViewToGrid();
		manageFormsPage.HoveronFirstForm();
		manageFormsPage.EditForm();
		designFormPage.SelectFormTab("QUIZ");
		manageFormsPage.SelectViewToGrid();
		manageFormsPage.HoveronFirstForm();
		manageFormsPage.CopyForm();
		designFormPage.SelectFormTab("QUIZ");
		manageFormsPage.SelectViewToGrid();
		manageFormsPage.HoveronFirstForm();
		manageFormsPage.PreviewForm();
		manageFormsPage.HoveronFirstForm();
		manageFormsPage.CopyFormURL();
		// manageFormsPage.HoveronFirstForm();
		// Thread.sleep(2000);
		// manageFormsPage.RegularFormAnalytics();
		manageFormsPage.HoveronFirstForm();
		manageFormsPage.DeleteForm();
		Thread.sleep(4000);
		logger.info("Manage Regular Form - Edit, copy, preview, copyFormUrl, delete form is succesfull");
		System.out.println(" ");
	}

	@Test(priority = 6, enabled = true)
	public void ManageSurveyFormInGridView() throws InterruptedException, UnsupportedFlavorException, IOException {
		System.out.println(" ");
		logger.info("Starting test: ManageRegularForm");
		manageFormsPage.Design_ClickManageForm();
		designFormPage.SelectFormTab("SURVEY");
		manageFormsPage.SelectViewToGrid();
		manageFormsPage.HoveronFirstForm();
		manageFormsPage.EditForm();
		designFormPage.SelectFormTab("SURVEY");
		manageFormsPage.SelectViewToGrid();
		manageFormsPage.HoveronFirstForm();
		manageFormsPage.CopyForm();
		designFormPage.SelectFormTab("SURVEY");
		manageFormsPage.SelectViewToGrid();
		manageFormsPage.HoveronFirstForm();
		manageFormsPage.PreviewForm();
		manageFormsPage.HoveronFirstForm();
		manageFormsPage.CopyFormURL();
		// manageFormsPage.HoveronFirstForm();
		// Thread.sleep(2000);
		// manageFormsPage.RegularFormAnalytics();
		manageFormsPage.HoveronFirstForm();
		Thread.sleep(1000);
		manageFormsPage.DeleteForm();
		Thread.sleep(4000);
		logger.info("Manage Regular Form - Edit, copy, preview, copyFormUrl, delete form is succesfull");
		System.out.println(" ");
	}

}
