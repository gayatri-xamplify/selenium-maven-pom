
package com.stratapps.xamplify.tests;

import java.awt.AWTException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.ContactsPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.ManageContactsPage;
import com.stratapps.xamplify.pages.ManagePlaybooksPage;

public class ManagePlaybooksTest extends BaseTest {

	private ManagePlaybooksPage managePlaybooksPage;
	private static final Logger logger = LogManager.getLogger(ManagePlaybooksTest.class);
	private WebDriverWait wait;

	@BeforeClass(alwaysRun = true)
public void setUpClass() {
    logger.info("🔧 Setting up ManagePlaybooksTest");

    // At this point:
    // - Browser is already launched (@BeforeSuite)
    // - Partner login is already done (@Parameters role=PARTNER)

	managePlaybooksPage = new ManagePlaybooksPage(driver);

    wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    logger.info("✅ ManagePlaybooksTest setup completed");
}

	
	@Test(priority = 1, enabled = true)
	public void navigateToManagePlaybooksTest() throws InterruptedException {
		logger.info("Test 1: Navigate to Manage Playbooks - STARTED");
		managePlaybooksPage.navigateToContentAndManagePlaybooks();
		logger.info("Test 1: Navigate to Manage Playbooks - COMPLETED");
	}

	@Test(priority = 2, enabled = true)
	public void editPlaybookDetailsTest() throws InterruptedException {
		logger.info("Test 2: Edit Playbook Details - STARTED");
		managePlaybooksPage.editPlaybookDetails();
		logger.info("Test 2: Edit Playbook Details - COMPLETED");
	}

	@Test(priority = 3, enabled = true)
	public void unpublishPlaybookTest() {
		logger.info("Test 3: Unpublish Playbook - STARTED");
		managePlaybooksPage.unpublishPlaybook();
		logger.info("Test 3: Unpublish Playbook - COMPLETED");
	}

	@Test(priority = 4, enabled = true)
	public void publishPlaybookTest() {
		logger.info("Test 4: Publish Playbook - STARTED");
		managePlaybooksPage.publishPlaybook();
		logger.info("Test 4: Publish Playbook - COMPLETED");
	}

	@Test(priority = 5, enabled = true)
	public void previewPlaybookTest() {
		logger.info("Test 5: Preview Playbook - STARTED");
		managePlaybooksPage.previewPlaybookAndReturn();
		logger.info("Test 5: Preview Playbook - COMPLETED");
	}

	@Test(priority = 6, enabled = true)
	public void PlaybookAnalyticsTest() {
		logger.info("Test 6: Playbook Analytics - STARTED");
		managePlaybooksPage.viewPlaybookAnalytics();
		logger.info("Test 6: Playbook Analytics - COMPLETED");
	}

	@Test(priority = 7, enabled = true)
	public void sortAndDeletePlaybookTest() {
		logger.info("Test 7: Sort and Delete Playbook - STARTED");
		managePlaybooksPage.sortAndDeletePlaybook();
		managePlaybooksPage.backToHome();
		logger.info("Test 7: Sort and Delete Playbook - COMPLETED");
	}

	@Test(priority = 8, enabled = false)
	public void PlaybookViewsTest() throws AWTException {
		logger.info("Test 8: Playbook Views - STARTED");
		managePlaybooksPage.PlaybookViews("D:\\Playbook_img\\Thumbnail_file.jpg");
		logger.info("Test 8: Playbook Views - COMPLETED");
	}
}
