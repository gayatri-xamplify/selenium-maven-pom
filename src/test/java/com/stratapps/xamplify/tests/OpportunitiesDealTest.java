package com.stratapps.xamplify.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.OpportunitiesDealPage;
import com.stratapps.xamplify.utils.ScreenshotUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class OpportunitiesDealTest extends BaseTest{


private OpportunitiesDealPage opportunitiesDealPage;
private static final Logger logger = LogManager.getLogger(OpportunitiesDealTest.class);
private WebDriverWait wait;


/*
 * @BeforeClass public void setUpClass() { super.setUp(); LoginPage loginPage =
 * new LoginPage(driver); loginPage.loginAsPartner(); opportunitiesDealPage =
 * new OpportunitiesDealPage(driver); wait = new WebDriverWait(driver,
 * Duration.ofSeconds(60));
 * logger.info("OpportunitiesDealPage setup completed"); }
 * 
 */



@BeforeClass
public void setUp() {
    opportunitiesDealPage = new OpportunitiesDealPage(driver); 
}









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
public void searchLeadAndEmailReport() throws Exception {
logger.info("Starting test: search deals and send email report");
opportunitiesDealPage.dealSearch();
opportunitiesDealPage.dealEmailReport();
opportunitiesDealPage.removeDealSearch();
//opportunitiesleadPage.DealFilter();
}

@Test(priority = 3, enabled = true)
public void AddDeal() throws Exception {
logger.info("Starting test: Create new deal in Manage deals");
opportunitiesDealPage.addDeal();
logger.info("Starting test: Create new deal by attaching lead in Manage deals");
opportunitiesDealPage.addDealWithAttachLead();
logger.info("Starting test: Create new deal by attaching contact in Manage deals");
opportunitiesDealPage.addDealWithAttachContact();
logger.info("Starting test: Create new deal by attaching New lead attach in Manage deals");
opportunitiesDealPage.addedLeadConvertToDeal();
}

@Test(priority = 4, enabled = true)
public void DealAction() throws Exception {
logger.info("Starting test: Edit deal in Manage deals");
opportunitiesDealPage.editDeal();
opportunitiesDealPage.dealView();
opportunitiesDealPage.addDealComment();
opportunitiesDealPage.deleteDeal();
}

@Test(priority = 5, enabled = true)
public void DealsPagination() throws Exception {
logger.info("Starting test: Pagination in Manage deals");
opportunitiesDealPage.dealsPaginationandPageCount();
}

@Test(priority = 6, enabled = true)
public void DealsCampaignView() throws Exception {
logger.info("Starting test: CampaignView in Manage deals");
opportunitiesDealPage.dealCampainView();
opportunitiesDealPage.editDeal();
WaitUtil.waitAndClick(driver, opportunitiesDealPage.viewDealforThisCampaign, 200);
opportunitiesDealPage.dealView();
WaitUtil.waitAndClick(driver, opportunitiesDealPage.viewDealforThisCampaign, 200);
opportunitiesDealPage.addDealComment();
//opportunitiesDealPage.deleteDeal();

}
@Test(priority = 7, enabled = false)
public void DealsFilter() throws Exception {
logger.info("Starting test: appling filter in Manage deals");
opportunitiesDealPage.filterDeals();
}

}