package com.stratapps.xamplify.tests;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.AccessSharedPlaybooksPage;
import com.stratapps.xamplify.pages.AccessSharedTracksPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class AccessSharedTracksTest extends BaseTest {

	private AccessSharedTracksPage accessSharedTracksPage;
	private static final Logger logger = LogManager.getLogger(AccessSharedTracksTest.class);
	private WebDriverWait wait;

	
	
	
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {

	    logger.info("🔧 Setting up AccessSharedAssetsTest");

	    // Preconditions guaranteed by BaseTest:
	    // - Browser already launched
	    // - Partner already logged in (role=PARTNER)

	    accessSharedTracksPage = new AccessSharedTracksPage(driver);
	    wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    logger.info("✅ AccessSharedAssetsTest setup completed");
	}

	
	
	
	
	
	
	
	

	@Test(priority = 1, enabled = true)
	public void AccessSharedTracks() throws Exception {
		accessSharedTracksPage.accesssharedTrackSection();
		accessSharedTracksPage.refreshTracksPage();
		accessSharedTracksPage.sortTracks("Name(Z-A)");
		accessSharedTracksPage.sortTracks("Published On(DESC)");
		accessSharedTracksPage.searchTrack("Track");
	}

	@Test(priority = 2, enabled = true)
	public void AccessSharedTracks_Actions() throws Exception {
		accessSharedTracksPage.viewTrackAndClickAssets();
		accessSharedTracksPage.tilesActions("Track");
		accessSharedTracksPage.backtohome();

	}
}