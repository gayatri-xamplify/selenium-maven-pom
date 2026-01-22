package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.OpportunitiesDealPage;
import com.stratapps.xamplify.pages.ScheduleVideoCampaignPage;
import com.stratapps.xamplify.pages.VideoCampaignPage;
import com.stratapps.xamplify.utils.ScreenshotUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class VendorOpportunitiesDealTest extends BaseTest {
	private OpportunitiesDealPage opportunitiesDealPage;
	private static final Logger logger = LogManager.getLogger(OpportunitiesDealTest.class);
	private WebDriverWait wait;
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
	    logger.info("🔧 Setting up ManageVideoCampaignTest");

	    // At this point:
	    // - Browser is already launched (@BeforeSuite)
	    // - Partner login is already done (@Parameters role=PARTNER)
		opportunitiesDealPage = new OpportunitiesDealPage(driver);

		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    logger.info("✅ ManageVideoCampaignTest setup completed");
	}

	
	/*
	 * @BeforeClass public void setUp() { opportunitiesDealPage = new
	 * OpportunitiesDealPage(driver); }
	 */

	@Test(priority = 1, enabled = true)
	public void OpenManageDealsPage() {
		logger.info("Starting test: Navigate to Manage Deals");
		try {
			opportunitiesDealPage.hoverOnOpportunities_ManageDeals();
			ScreenshotUtil.captureScreenshot(driver, "opportunities");
		} catch (Exception e) {
			logger.error("Error in opportunities", e);
		}
	}

	@Test(priority = 2, enabled = true)
	public void searchDealAndEmailReport() throws Exception {
		logger.info("Starting test: search deals and send email report");
		opportunitiesDealPage.dealSearch("deal");
		opportunitiesDealPage.dealEmailReport();
		opportunitiesDealPage.removeDealSearch();
		// opportunitiesleadPage.DealFilter();
	}

	@Test(priority = 3, enabled = true)
	public void DealAction() throws Exception {
		logger.info("Starting test: view deal in Manage deals");
		opportunitiesDealPage.dealView();
		logger.info("Starting test: add comment to deal in Manage deals");
		opportunitiesDealPage.addDealComment();
		logger.info("Starting test: update Status to deal in Manage deals");
		opportunitiesDealPage.editDealStatus();
	}

	@Test(priority = 5, enabled = true)
	public void DealTielsCountValidations() throws InterruptedException {
		logger.info("Starting test: Won deal tile count and total records validation in Manage deals");
		opportunitiesDealPage.WonDealTileCountValidation();
		logger.info("Starting test: Loss deal tile count and total records validation in Manage deals");
		opportunitiesDealPage.LossDealTileCountValidation();
		logger.info("Starting test: All deals tile count and total records validation in Manage deals");
		opportunitiesDealPage.AllDealTileCountValidation();
	}

	@Test(priority = 6, enabled = true)
	public void DealsPagination() throws Exception {
		logger.info("Starting test: Pagination in Manage deals");
		opportunitiesDealPage.dealsPaginationandPageCount();
	}

	@Test(priority = 7, enabled = false)
	public void DealsCampaignView() throws Exception {
		logger.info("Starting test: CampaignView in Manage deals");
		opportunitiesDealPage.VendordealCampainView();
		opportunitiesDealPage.dealView();
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, opportunitiesDealPage.vendorViewCampDeal, 10);
		WaitUtil.waitAndClick(driver, opportunitiesDealPage.vendorViewDealCount, 200);
		opportunitiesDealPage.addDealCommentCampaignView();
		opportunitiesDealPage.dealEmailReport();
	}

	// pending
	@Test(priority = 8, enabled = false)
	public void DealsFilter() throws Exception {
		logger.info("Starting test: appling filter in Manage deals");
		opportunitiesDealPage.filterDeals();
	}
}
