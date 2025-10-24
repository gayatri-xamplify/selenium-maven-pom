
package com.stratapps.xamplify.tests;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.UploadAssetPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class UploadAssetTest extends BaseTest {

	private UploadAssetPage uploadAssetPage;
	private static final Logger logger = LogManager.getLogger(AddTracksTest.class);
	private WebDriverWait wait;

	@BeforeClass
	public void setUpClass() {
		super.setUp();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		uploadAssetPage = new UploadAssetPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		logger.info("UploadAssetsTest setup completed");
	}

	@Test(priority = 1, enabled = true)
	public void navigateToUploadAssetsPage() {
		uploadAssetPage.openUploadAssetSection();
		
	}

	@Test(priority = 2, enabled = true)
	public void uploadNewAsset() {
		// Start asset upload flow
		uploadAssetPage.uploadFile("D:\\git\\files\\test-image.jpg");
		// uploadAssetPage.enterAssetName("Demo Test Asset");
		
	}

	@Test(priority = 3, enabled = true)
	public void selectFolder() {
		// Select folder, category, tags etc.
		//uploadAssetPage.selectFolder("xamplify");

		uploadAssetPage.addTags("Automation");
		uploadAssetPage.enterDescription("This is an automated test asset upload");
		// Click on Save / Upload button
		uploadAssetPage.saveAndPublishAsset();

		// Validate success message
		String successMsg = uploadAssetPage.getUploadSuccessMessage();
		Assert.assertTrue(successMsg.contains("successfully"), "Asset upload failed!");
	}

	@Test(priority = 3, enabled = false)
	public void uploadNewAsset_Box() {
		{

			uploadAssetPage.uploadFromBox("arohith@stratapps.com", "Xamplify@11");
//    uploadAssetPage.switchToNewWindow();
//    uploadAssetPage.enterDescription("This is an automated test asset upload from Box");
		}
	}
}
