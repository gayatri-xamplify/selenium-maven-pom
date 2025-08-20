package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.SharedLeadsPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class SharedLeadsTest extends BaseTest {

	private SharedLeadsPage sharedleadsPage;
	private static final Logger logger = LogManager.getLogger(SharedLeadsTest.class);
	private WebDriverWait wait;

	@BeforeClass
	public void setUpClass() {
		super.setUp();
		logoutIfLoggedIn();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(ConfigReader.getProperty("partner.username"), ConfigReader.getProperty("partner.password"));

		sharedleadsPage = new SharedLeadsPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		logger.info("SharedleadsTest setup completed");
	}

	@Test(priority = 0, enabled = true)
	public void testSharedleadsListviewActionsAllTile() throws Exception {
		logger.info("Starting Shared Leads Listview Actions on All Tile.");
		sharedleadsPage.navigateToSharedLeads();
		sharedleadsPage.waitForCountsToLoad();
		sharedleadsPage.clickFirstInfoIcon();
		sharedleadsPage.applyAllEditTileSortOptions();
		sharedleadsPage.manageSharedleadsTilesEmailreports();
		sharedleadsPage.clickMoreLessButton();
		sharedleadsPage.clickUnsubscribeIcon();
		sharedleadsPage.applyFilter("City", "Contains", "Hyderabad");
		logger.info("Completed Shared Leads Listview Actions on All Tile.");
	}

	@Test(priority = 1, enabled = true)
	public void testSharedLeadsListUnsubscribeTile() throws Exception {
		sharedleadsPage.sharedLeadsListUnsubscribeTile();
	}

	@Test(priority = 2, enabled = true)
	public void testSharedLeadsValidTileClick() throws Exception {
		int validTileCount = sharedleadsPage.getValidTileCount();
		sharedleadsPage.sharedLeadsEditListValidTile(validTileCount);
	}

	@Test(priority = 3, enabled = true)
	public void testSharedLeadsExcludeTileClick() throws Exception {
		int excludeTileCount = sharedleadsPage.getExcludeTileCount();
		sharedleadsPage.sharedLeadsEditListExcludeTile(excludeTileCount);
	}

	@Test(priority = 4, enabled = true)
	public void testSharedLeadsUndeliverableTileClick() throws Exception {
		int undeliverableTileCount = sharedleadsPage.getUndeliverableTileCount();
		sharedleadsPage.sharedLeadsEditListUndeliverableTile(undeliverableTileCount);
	}

	@Test(priority = 5, enabled = true)
	public void testManageAllSharedLeadsTileActions() throws Exception {
		sharedleadsPage.manageAllSharedLeadsTileActions();
	}

	@Test(priority = 6, enabled = true)
	public void testManageValidSharedLeadsTileActions() throws Exception {
		sharedleadsPage.manageValidSharedLeadsTileActions();
	}

	@Test(priority = 7, enabled = true)
	public void testManageExcludeSharedLeadsTileActions() throws Exception {
		sharedleadsPage.manageExcludeSharedLeadsTileActions();
	}

	@Test(priority = 8, enabled = true)
	public void testManageUndeliverableSharedLeadsTileActions() throws Exception {
		sharedleadsPage.manageUndeliverableSharedLeadsTileActions();
	}

	@Test(priority = 9, enabled = true)
	public void testManageUnsubscribeSharedLeadsTileActions() throws Exception {
		sharedleadsPage.manageUnsubscribeSharedLeadsTileActions();
	}

	@Test(priority = 10, enabled = true)
	public void testManageSharedLeadsSort() throws Exception {
		sharedleadsPage.navigateToSharedLeads();
		sharedleadsPage.manageSharedLeadsSort();
	}

	@Test(priority = 11, enabled = true)
	public void testManageSharedLeadsGrid() throws Exception {
		sharedleadsPage.manageSharedLeadsGrid();
	}
}
