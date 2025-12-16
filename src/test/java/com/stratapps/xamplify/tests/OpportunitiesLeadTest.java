package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.OpportunitiesLeadPage;
import com.stratapps.xamplify.utils.ScreenshotUtil;

public class OpportunitiesLeadTest extends BaseTest {

	private OpportunitiesLeadPage opportunitiesleadPage;
	private static final Logger logger = LogManager.getLogger(OpportunitiesLeadTest.class);
	private WebDriverWait wait;

	@BeforeClass
	public void setUpClass() {
		try {
			opportunitiesleadPage = new OpportunitiesLeadPage(driver);
		} catch (Exception e) {
			System.out.println("Note: Hide multiple classes Run");
		}
		try {
		super.setUp();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginAsPartner();
		opportunitiesleadPage = new OpportunitiesLeadPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		logger.info("OpportunitiesLeadTest setup completed");
		} catch (Exception e) {
			System.out.println("Note: single classes Run Fail");
		}
	}

	@Test(priority = 1, enabled = true)
	public void OpenManageLeads() {
		logger.info("Starting test: Create share lead one at a time");
		try {
			opportunitiesleadPage.hoverOnOpportunities_ManageLeads();
			ScreenshotUtil.captureScreenshot(driver, "opportunities");
		} catch (Exception e) {
			logger.error("Error in opportunities", e);
		}
	}

	@Test(priority = 2, enabled = true)
	public void searchLeadAndEmailReport() throws Exception {
		logger.info("Starting test: search leads and send email report");
		opportunitiesleadPage.leadSearch();
		opportunitiesleadPage.leadEmailReport();
		opportunitiesleadPage.removeLeadSearch();
	}

	@Test(priority = 3, enabled = true)
	public void AddLead() throws Exception {
		logger.info("Starting test: Create new lead in Manage leads");
		opportunitiesleadPage.addLead();
		logger.info("Starting test: Create new lead in My profile");
		opportunitiesleadPage.addleadFromMyprofile();
	}

	@Test(priority = 4, enabled = true)
	public void LeadActions() throws Exception {
		logger.info("Starting test: view lead and add comment");
		opportunitiesleadPage.leadView();
		logger.info("Starting test: Edit lead and update the lead stage & lead detail");
		opportunitiesleadPage.editLead();
		logger.info("Starting test: Add comment to the lead");
		opportunitiesleadPage.addcomment();
		logger.info("Starting test: Deleting the lead");
		opportunitiesleadPage.deletelead();
	}

	@Test(priority = 5, enabled = true)
	public void DealTielsCountValidations() throws InterruptedException {
		logger.info("Starting test: Won Lead tile count and total records validation in Manage deals");
		opportunitiesleadPage.WonLeadTileCountValidation();
		logger.info("Starting test: Loss Lead tile count and total records validation in Manage deals");
		opportunitiesleadPage.LossLeadTileCountValidation();
		logger.info("Starting test: Converted Lead tile count and total records validation in Manage deals");
		opportunitiesleadPage.ConvertedLeadTileCountValidation();
		logger.info("Starting test: All Lead tile count and total records validation in Manage deals");
		opportunitiesleadPage.AllLeadTileCountValidation();
	}

	@Test(priority = 6, enabled = false)
	public void CampainViewLeads() throws Exception {
		logger.info("Starting test: Campaign Lead view in Manage leads");
		opportunitiesleadPage.CampainView();
		logger.info("Starting test: view lead and add comment");
		opportunitiesleadPage.leadView();
		opportunitiesleadPage.CampainView();
		logger.info("Starting test: Edit lead and update the lead stage & lead detail");
		opportunitiesleadPage.editLead();
		opportunitiesleadPage.CampainView();
		logger.info("Starting test: Add comment to the lead");
		opportunitiesleadPage.addcomment();
	}

	@Test(priority = 7, enabled = true)
	public void Pagination() throws Exception {
		logger.info("Starting test: Lead pagination in Manage leads");
		opportunitiesleadPage.leadsPaginationandPageCount();
	}

}