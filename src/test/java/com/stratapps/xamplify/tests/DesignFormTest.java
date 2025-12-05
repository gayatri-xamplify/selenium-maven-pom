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
import com.stratapps.xamplify.pages.ManageFormsPage;
import com.stratapps.xamplify.pages.OnboardingPartnerPage;
import com.stratapps.xamplify.pages.ScheduleVideoCampaignPage;
import com.stratapps.xamplify.pages.VideoCampaignPage;

public class DesignFormTest extends BaseTest {
	private DesignFormPage designFormPage;
	private static final Logger logger = LogManager.getLogger(DesignFormPage.class);
	private WebDriverWait wait;

	@BeforeClass
	public void setUpClass() {
		try {
			designFormPage = new DesignFormPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			logger.info("DesignFormPage setup completed");
		} catch (Exception e) {
			System.out.println("Note: Hide multiple classes Run");
		}
		try {
			super.setUp();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginAsVendor();
			designFormPage = new DesignFormPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			logger.info("DesignFormPage setup completed");
		} catch (Exception e) {
			System.out.println("Note: single class Run Fail");
		}
	}
	
	
	
	 
	/*
	 * @BeforeClass public void setUpClass() { designFormPage = new
	 * DesignFormPage(driver); }
	 */

	/*
	 * @BeforeClass public void setUpClass() { designFormPage = new
	 * DesignFormPage(driver); }
	 */

	@Test(priority = 1, enabled = true)
	public void DesignRegularForm() throws InterruptedException {
		System.out.println(" ");
		logger.info("Starting test: DesignFormPage");
		designFormPage.Design_ClickDesignForm();
		designFormPage.SelectFormTab("REGULAR");
		designFormPage.CreateForm();
		Thread.sleep(2000);
		logger.info("Regular Form created successfully ");
		System.out.println(" ");
	}

	@Test(priority = 2, enabled = true)
	public void DesignQuizForm() throws InterruptedException {
		System.out.println(" ");
		logger.info("Starting test: DesignQuizForm");
		designFormPage.Design_ClickDesignForm();
		designFormPage.SelectFormTab("QUIZ");
		designFormPage.CreateForm();
		Thread.sleep(2000);
		logger.info("Quiz Form created successfully ");
		System.out.println(" ");
	}

	@Test(priority = 3, enabled = true)
	public void DesignSurveyForm() throws InterruptedException {
		System.out.println(" ");
		logger.info("Starting test: DesignSurveyFormPage");
		designFormPage.Design_ClickDesignForm();
		designFormPage.SelectFormTab("SURVEY");
		designFormPage.CreateForm();
		Thread.sleep(2000);
		logger.info("Survey Form created successfully ");
		System.out.println(" ");
	}
}
