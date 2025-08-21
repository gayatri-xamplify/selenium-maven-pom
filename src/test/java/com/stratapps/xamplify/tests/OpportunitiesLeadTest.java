package com.stratapps.xamplify.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.OpportunitiesLeadPage;
import com.stratapps.xamplify.utils.ScreenshotUtil;

public class OpportunitiesLeadTest extends BaseTest {

	private OpportunitiesLeadPage opportunitiesleadPage;
	private static final Logger logger = LogManager.getLogger(OpportunitiesLeadTest.class);
	private WebDriverWait wait;

	/*
	 * @BeforeClass public void setUpClass() { super.setUp(); LoginPage loginPage =
	 * new LoginPage(driver); loginPage.loginAsPartner(); opportunitiesleadPage =
	 * new OpportunitiesLeadPage(driver); wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(60));
	 * logger.info("OpportunitiesLeadTest setup completed"); }
	 */

	@BeforeClass
	public void setUpClass() {

		opportunitiesleadPage = new OpportunitiesLeadPage(driver);
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
//opportunitiesleadPage.leadFilter();
	}

	@Test(priority = 3, enabled = true)
	public void AddLead() throws Exception {
		logger.info("Starting test: Create new lead in Manage leads");
		opportunitiesleadPage.addLead();
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

	@Test(priority = 5, enabled = false)
	public void CampainViewLeads() throws Exception {
		logger.info("Starting test: Create new lead in Manage leads");
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

	@Test(priority = 6, enabled = true)
	public void LeadTilesAndPagination() throws Exception {
//logger.info("Starting test: Lead Tiles in Manage leads");
//opportunitiesleadPage.leadTiles();
		logger.info("Starting test: Lead pagination in Manage leads");
		opportunitiesleadPage.leadsPaginationandPageCount();
	}

}