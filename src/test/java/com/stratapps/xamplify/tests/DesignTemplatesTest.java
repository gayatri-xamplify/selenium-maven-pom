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
import com.stratapps.xamplify.pages.DesignTemplatesPage;
import com.stratapps.xamplify.pages.LoginPage;

public class DesignTemplatesTest extends BaseTest {
	private DesignTemplatesPage designTemplatesPage;
	private static final Logger logger = LogManager.getLogger(DesignTemplatesPage.class);
	private WebDriverWait wait;

	@BeforeClass
	public void setUpClass() {
		try {
			designTemplatesPage = new DesignTemplatesPage(driver);
		} catch (Exception e) {
			System.out.println("Note: Multiple classes Run Config Skipped");
		}
		try {
			super.setUp();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginAsVendor();
			designTemplatesPage = new DesignTemplatesPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			logger.info("DesignTemplatesPage setup completed");
		} catch (Exception e) {
			System.out.println("Note: single class Run Config Skipped");
		}
	}

	@Test(priority = 1, enabled = true)
	public void CreateEmailTemplate() throws InterruptedException, UnsupportedFlavorException, IOException {
		System.out.println(" ");
		logger.info("Creating Email Template in Design Templates ");
		designTemplatesPage.designDesignTemplate();
		designTemplatesPage.selectTemplateTab("Email");
		designTemplatesPage.createTemplate("EmailTemplate");
		logger.info("Successfully Created Email Template in Design Templates");
		System.out.println(" ");
	}

	@Test(priority = 2, enabled = true)
	public void CreateEmailCobrandingTemplate() throws InterruptedException, UnsupportedFlavorException, IOException {
		logger.info("Creating Email Co-Branding Template in Design Templates ");
		designTemplatesPage.designDesignTemplate();
		designTemplatesPage.selectTemplateTab("Email Co-Branding");
		designTemplatesPage.createTemplate("Email Co-Branding");
		logger.info("Successfully Created Email Co-Branding Template in Design Templates");
		System.out.println(" ");
	}

	@Test(priority = 3, enabled = true)
	public void CreateVideoTemplate() throws InterruptedException, UnsupportedFlavorException, IOException {
		logger.info("Creating Video Template in Design Templates ");
		designTemplatesPage.designDesignTemplate();
		designTemplatesPage.selectTemplateTab("Video");
		designTemplatesPage.createTemplate("VideoTemplate");
		logger.info("Successfully Created Video Template in Design Templates");
		System.out.println(" ");
	}

	@Test(priority = 4, enabled = true)
	public void CreateVideoCobrandingTemplate() throws InterruptedException, UnsupportedFlavorException, IOException {
		logger.info("Creating Video Co-Branding Template in Design Templates ");
		designTemplatesPage.designDesignTemplate();
		designTemplatesPage.selectTemplateTab("Video Co-Branding");
		designTemplatesPage.createTemplate("Video Co-Branding");
		logger.info("Successfully Created Video Co-Branding Template in Design Templates");
		System.out.println(" ");
	}

	@Test(priority = 5, enabled = true)
	public void CreateEventTemplate() throws InterruptedException, UnsupportedFlavorException, IOException {
		logger.info("Creating Event Template in Design Templates ");
		designTemplatesPage.designDesignTemplate();
		designTemplatesPage.selectTemplateTab("Event");
		designTemplatesPage.createTemplate("EventTemplate");
		logger.info("Successfully Created Event Template in Design Templates");
		System.out.println(" ");
	}

	@Test(priority = 6, enabled = true)
	public void CreateEventCobrandingTemplate() throws InterruptedException, UnsupportedFlavorException, IOException {
		logger.info("Creating Video Co-Branding Template in Design Templates ");
		designTemplatesPage.designDesignTemplate();
		designTemplatesPage.selectTemplateTab("Event Co-Branding");
		designTemplatesPage.createTemplate("Event Co-Branding");
		logger.info("Successfully Created Event Co-Branding Template in Design Templates");
		System.out.println(" ");
	}

	@Test(priority = 7, enabled = false)
	public void CreateSurveyTemplate() throws InterruptedException, UnsupportedFlavorException, IOException {
		logger.info("Creating Survey Template in Design Templates ");
		designTemplatesPage.designDesignTemplate();
		designTemplatesPage.selectTemplateTab("Survey");
		designTemplatesPage.createTemplate("SurveyTemplate");
		logger.info("Successfully Created Survey Template in Design Templates");
		System.out.println(" ");
	}
    //
	@Test(priority = 8, enabled = false)
	public void CreateSurveyCobrandingTemplate() throws InterruptedException, UnsupportedFlavorException, IOException {
		logger.info("Creating Survey Co-Branding Template in Design Templates ");
		designTemplatesPage.designDesignTemplate();
		designTemplatesPage.selectTemplateTab("Survey Co-Branding");
		designTemplatesPage.createTemplate("Survey Co-Branding");
		logger.info("Successfully Created Survey Co-Branding Template in Design Templates");
		System.out.println(" ");
	}

	@Test(priority = 7, enabled = false)
	public void CreateCustomTemplate() throws InterruptedException, UnsupportedFlavorException, IOException {
		logger.info("Creating Survey Template in Design Templates ");
		designTemplatesPage.designDesignTemplate();
		designTemplatesPage.selectTemplateTab("Survey");
		designTemplatesPage.createTemplate("SurveyTemplate");
		logger.info("Successfully Created Survey Template in Design Templates");
		System.out.println(" ");
	}

}
