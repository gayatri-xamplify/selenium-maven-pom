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
import com.stratapps.xamplify.utils.ConfigReader;

public class ManageAssetTest extends BaseTest {

	private ManageAssetPage manageAssetPage;
	private static final Logger logger = LogManager.getLogger(ManageAssetTest.class);
	private WebDriverWait wait;

	@BeforeClass
	public void setUpClass() {
		super.setUp();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		manageAssetPage = new ManageAssetPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		logger.info("ManageAssetsTest setup completed");
	}
	@Test(priority = 1, enabled = true)
	public void Refresh() throws Exception {
		manageAssetPage.openManageAssetSection();
		manageAssetPage.refreshAssetsPage();
		manageAssetPage.sortAssets("Created On(ASC)");
		manageAssetPage.searchAsset("docx");
		manageAssetPage.editAndReplaceAsset("D:\\git\\selenium-maven-pom\\files\\test-docx-updated.docx");
		manageAssetPage.deleteAssetFile("docx");
		manageAssetPage.previewAsset("docx");
		manageAssetPage.downloadAsset();
		manageAssetPage.viewAnalytics();
		//manageAssetPage.openFilterAndApply("Type" "mp4");
	
	
	}
	
	
	@Test(priority = 2, enabled = false)
	public void views() throws Exception {
		manageAssetPage.openManageAssetSection();
		manageAssetPage.openFilterAndApply("Asset name", "Contains", "mp4");
	
}
}
