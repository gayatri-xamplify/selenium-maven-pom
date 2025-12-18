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
import com.stratapps.xamplify.pages.ManageAssetPage;
import com.stratapps.xamplify.pages.UploadAssetPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class ManageAssetTest extends BaseTest {

	private ManageAssetPage manageAssetPage;
	private static final Logger logger = LogManager.getLogger(ManageAssetTest.class);
	private WebDriverWait wait;

	
		@BeforeClass
		public void setUpClass() {
			try {
				manageAssetPage = new ManageAssetPage(driver);
				wait = new WebDriverWait(driver, Duration.ofSeconds(60));
				logger.info("ManageAsset setup completed");
			} catch (Exception e) {
				System.out.println("Note: Hide multiple classes Run");
			}
			try {
				super.setUp();
				LoginPage loginPage = new LoginPage(driver);
				loginPage.loginAsVendor();
				manageAssetPage = new ManageAssetPage(driver);
				wait = new WebDriverWait(driver, Duration.ofSeconds(60));
				logger.info("ManageAsset setup completed");
			} catch (Exception e) {
				System.out.println("Note: single class Run Fail");
			}
		}
		
		
		
	@Test(priority = 1, enabled = true)
	public void manage_docx() throws Exception {
	    String filePath = System.getProperty("user.dir") + "/files/test-docx-updated.docx";

		manageAssetPage.openManageAssetSection();
		manageAssetPage.refreshAssetsPage();
		manageAssetPage.sortAssets("Created On (ASC)");
		manageAssetPage.searchAsset("docx");
		manageAssetPage.editAndReplaceAsset(filePath);
		manageAssetPage.deleteAssetFile("docx");
		manageAssetPage.previewAsset("docx");
		manageAssetPage.downloadAsset();
		manageAssetPage.viewAnalytics();
	
	}
	
	
	@Test(priority = 2, enabled = true)
	public void views() throws Exception {
	    String filePath = System.getProperty("user.dir") + "/files/test-mp4.mp4";

		manageAssetPage.openManageAssetSection();
		manageAssetPage.openFilterAndApply("Asset Name", "Contains", "docx");
		manageAssetPage.searchAsset("mp4");
		manageAssetPage.videoActions(filePath);
	
}
	
	
	@Test(priority = 3, enabled = true)
	public void manage_csv() throws Exception {
		manageAssetPage.openManageAssetSection();
		manageAssetPage.refreshAssetsPage();
		manageAssetPage.sortAssets("Created On (ASC)");
		manageAssetPage.searchAsset("docx");
		manageAssetPage.deleteAssetFile("csv");
		manageAssetPage.previewAsset("csv");
		manageAssetPage.downloadAsset();
		manageAssetPage.viewAnalytics();
	
	}
	
	
	
	
	
	@Test(priority = 4, enabled = true)
	public void manage_ppt() throws Exception {
		manageAssetPage.openManageAssetSection();
		manageAssetPage.refreshAssetsPage();
		manageAssetPage.sortAssets("Created On (DESC)");
		manageAssetPage.searchAsset("ppt");
		manageAssetPage.deleteAssetFile("ppt");
		manageAssetPage.previewAsset("ppt");
		manageAssetPage.downloadAsset();
		manageAssetPage.viewAnalytics();
	
	}
	
	
	
	
	@Test(priority = 5, enabled = true)
	public void manage_pdf() throws Exception {
		manageAssetPage.openManageAssetSection();
		manageAssetPage.refreshAssetsPage();
		manageAssetPage.sortAssets("Created On (DESC)");
		manageAssetPage.searchAsset("pdf");
		manageAssetPage.pdfAssetActions("pdf");
	
	}
	
	
	
	
}
