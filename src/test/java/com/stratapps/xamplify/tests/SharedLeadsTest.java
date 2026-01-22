package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.RedistributeEventCampaignPage;
import com.stratapps.xamplify.pages.ScheduleRedistributeEventCampaignPage;
import com.stratapps.xamplify.pages.ShareLeadsPage;
import com.stratapps.xamplify.pages.SharedLeadsPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class SharedLeadsTest extends BaseTest {

	private SharedLeadsPage sharedleadsPage;
	private static final Logger logger = LogManager.getLogger(SharedLeadsTest.class);
	private WebDriverWait wait;
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
	    logger.info("🔧 Setting up ManageVideoCampaignTest");

	    // At this point:
	    // - Browser is already launched (@BeforeSuite)
	    // - Partner login is already done (@Parameters role=PARTNER)

		sharedleadsPage = new SharedLeadsPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    logger.info("✅ ManageVideoCampaignTest setup completed");
	}

	
	@Test(priority = 1, enabled = true)
	public void SharedleadsListviewActionsValidTile1() throws Exception {
		sharedleadsPage.manageAllSharedLeadsTileActions();
		sharedleadsPage.manageUnsubscribeSharedLeadsTileActions();
		sharedleadsPage.manageValidSharedLeadsTileActions();
		sharedleadsPage.manageUndeliverableSharedLeadsTileActions();
		sharedleadsPage.manageExcludeSharedLeadsTileActions();		
	}

	@Test(priority = 2, enabled = true)
	public void testSharedLeadsListUnsubscribeTile() throws Exception {
		sharedleadsPage.navigateToSharedLeads();
		sharedleadsPage.waitForCountsToLoad();
		sharedleadsPage.UnsubscribeTileManageShareleads("com");
	}

	@Test(priority = 3, enabled = true)
	public void testSharedLeadsListValidTile() throws Exception {
		sharedleadsPage.ValidTileManageShareleads("");
	}

	@Test(priority = 4, enabled = true)
	public void testSharedLeadsExcludeTileClick() throws Exception {
		int excludeTileCount = sharedleadsPage.getExcludeTileCount();
		sharedleadsPage.sharedLeadsEditListExcludeTile(excludeTileCount);
	}

	@Test(priority = 5, enabled = true)
	public void testSharedLeadsUndeliverableTileClick() throws Exception {
		int undeliverableTileCount = sharedleadsPage.getUndeliverableTileCount();
		sharedleadsPage.sharedLeadsEditListUndeliverableTile(undeliverableTileCount);
	}

	@Test(priority = 6, enabled = true)
	public void testManageSharedLeadsGrid() throws Exception {
		sharedleadsPage.manageSharedLeadsGrid();
	}
}
