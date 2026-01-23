package com.stratapps.xamplify.tests;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.AccessSharedAssetsPage;
import com.stratapps.xamplify.pages.AccessSharedPlaybooksPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class AccessSharedPlaybooksTest extends BaseTest {

	private AccessSharedPlaybooksPage accessSharedPlaybooksPage;
	private static final Logger logger = LogManager.getLogger(AccessSharedPlaybooksTest.class);
	private WebDriverWait wait;

	
	
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {

	    logger.info("🔧 Setting up AccessSharedPlaybooksTest");

	    // Preconditions guaranteed by BaseTest:
	    // - Browser already launched
	    // - Partner already logged in (role=PARTNER)

	    accessSharedPlaybooksPage = new AccessSharedPlaybooksPage(driver);
	    wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    logger.info("✅ AccessSharedPlaybooksTest setup completed");
	}


	
	@Test(priority = 1, enabled = true)
	public void AccessSharedPlaybooks() throws Exception {
		accessSharedPlaybooksPage.accesssharedPlaybookSection();
		accessSharedPlaybooksPage.refreshPlaybooksPage();
//       accessSharedPlaybooksPage.sortPlaybooks("Name(Z-A)");
//        accessSharedPlaybooksPage.sortPlaybooks("Published On(DESC)");
		accessSharedPlaybooksPage.searchPlaybook("Playbook");
	}

	@Test(priority = 2, enabled = true)
	public void AccessSharedPlaybooks_Actions() throws Exception {
		accessSharedPlaybooksPage.tilesActions("Playbook");
		accessSharedPlaybooksPage.viewPlaybookAndClickAssets();
		accessSharedPlaybooksPage.backtohome();
	}
}