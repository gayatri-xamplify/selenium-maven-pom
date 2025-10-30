
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
	public void uploadAndSaveAsset() {
		uploadAssetPage.openUploadAssetSection();
		// Start asset upload flow
		uploadAssetPage.uploadFile("D:\\git\\files\\test-docx.docx");
		 //Select folder, category, tags etc.
		uploadAssetPage.selectDropdown("Jpg","xamplify","xamplify2024-Default-Folder");
		uploadAssetPage.enterDescription("This is an automated test asset upload");
		uploadAssetPage.addTags("automation");
		uploadAssetPage.saveAsset();
		uploadAssetPage.getPublishConfirmationMessage();
		uploadAssetPage.backToHome();
		
	}

	@Test(priority = 2, enabled = false)
	public void uploadAndsaveasDraft() {
		
		uploadAssetPage.openUploadAssetSection();
		// Start asset upload flow
		uploadAssetPage.uploadFile("D:\\git\\files\\test-mp3.mp3");
		 //Select folder, category, tags etc.
		uploadAssetPage.selectDropdown("Jpg","xamplify","xamplify2024-Default-Folder");
		uploadAssetPage.enterDescription("This is an automated test asset upload");
		uploadAssetPage.addTags("automation");
		uploadAssetPage.saveAsDraftAsset();
		uploadAssetPage.getPublishConfirmationMessage();
		uploadAssetPage.backToHome();
	}
	
	
	
	@Test(priority = 3, enabled = false)
	public void uploadAndPublishAsset1() {
		uploadAssetPage.openUploadAssetSection();
		// Start asset upload flow
		uploadAssetPage.uploadFile("D:\\git\\files\\test-mp4.mp4");
		 //Select folder, category, tags etc.
		uploadAssetPage.selectDropdown("Jpg","xamplify","xamplify2024-Default-Folder");
		uploadAssetPage.enterDescription("This is an automated test asset upload");
		uploadAssetPage.addTags("automation");
		uploadAssetPage.selectPartner();
		uploadAssetPage.getPublishConfirmationMessage();
		uploadAssetPage.backToHome();
		
	}
	
	@Test(priority = 4, enabled = false)
	public void uploadAndPublishAsset2() {
		uploadAssetPage.openUploadAssetSection();
		// Start asset upload flow
		uploadAssetPage.uploadFile("D:\\git\\files\\test-doc.doc");
		 //Select folder, category, tags etc.
		uploadAssetPage.selectDropdown("Jpg","xamplify","xamplify2024-Default-Folder");
		uploadAssetPage.enterDescription("This is an automated test asset upload");
		uploadAssetPage.addTags("automation");
		uploadAssetPage.selectPartner();
		uploadAssetPage.getPublishConfirmationMessage();
		uploadAssetPage.backToHome();
		
	}
	
	
	
	@Test(priority = 5, enabled = false)
	public void uploadAndPublishAsset3() {
		uploadAssetPage.openUploadAssetSection();
		// Start asset upload flow
		uploadAssetPage.uploadFile("D:\\git\\files\\test-image.jpg");
		 //Select folder, category, tags etc.
		uploadAssetPage.selectDropdown("Jpg","xamplify","xamplify2024-Default-Folder");
		uploadAssetPage.enterDescription("This is an automated test asset upload");
		uploadAssetPage.addTags("automation");
		uploadAssetPage.selectPartner();
		uploadAssetPage.getPublishConfirmationMessage();
		uploadAssetPage.backToHome();
		
	}
	
	
	
	@Test(priority = 6, enabled = false)
	public void uploadAndPublishAsset4() {
		uploadAssetPage.openUploadAssetSection();
		// Start asset upload flow
		uploadAssetPage.uploadFile("D:\\git\\files\\test-ppt.ppt");
		 //Select folder, category, tags etc.
		uploadAssetPage.selectDropdown("Jpg","xamplify","xamplify2024-Default-Folder");
		uploadAssetPage.enterDescription("This is an automated test asset upload");
		uploadAssetPage.addTags("automation");
		uploadAssetPage.selectPartner();
		uploadAssetPage.getPublishConfirmationMessage();
		uploadAssetPage.backToHome();
		
	}
	
	
	@Test(priority = 7, enabled = false)
	public void uploadAndPublishAsset5() {
		uploadAssetPage.openUploadAssetSection();
		// Start asset upload flow
		uploadAssetPage.uploadFile("D:\\git\\files\\test-zip.zip");
		 //Select folder, category, tags etc.
		uploadAssetPage.selectDropdown("Jpg","xamplify","xamplify2024-Default-Folder");
		uploadAssetPage.enterDescription("This is an automated test asset upload");
		uploadAssetPage.addTags("automation");
		uploadAssetPage.selectPartner();
		uploadAssetPage.getPublishConfirmationMessage();
		uploadAssetPage.backToHome();
		
	}
	
	@Test(priority = 8, enabled = false)
	public void uploadAndPublishAsset6() {
		uploadAssetPage.openUploadAssetSection();
		// Start asset upload flow
		uploadAssetPage.uploadFile("D:\\git\\files\\test-file.pdf");
		 //Select folder, category, tags etc.
		uploadAssetPage.selectDropdown("Jpg","xamplify","xamplify2024-Default-Folder");
		uploadAssetPage.enterDescription("This is an automated test asset upload");
		uploadAssetPage.addTags("automation");
		uploadAssetPage.selectPartner();
		uploadAssetPage.getPublishConfirmationMessage();
		uploadAssetPage.backToHome();
		
	}
	
	@Test(priority = 9, enabled = false)
	public void uploadAndPublishAsset7() {
		uploadAssetPage.openUploadAssetSection();
		// Start asset upload flow
		uploadAssetPage.uploadFile("D:\\git\\files\\test-csv.csv");
		 //Select folder, category, tags etc.
		uploadAssetPage.selectDropdown("Jpg","xamplify","xamplify2024-Default-Folder");
		uploadAssetPage.enterDescription("This is an automated test asset upload");
		uploadAssetPage.addTags("automation");
		uploadAssetPage.selectPartner();
		uploadAssetPage.getPublishConfirmationMessage();
		uploadAssetPage.backToHome();
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test(priority = 9, enabled = false)
	public void PublishConfirmationMessage() {

		uploadAssetPage.getPublishConfirmationMessage();
	}
	
	
	@Test(priority = 10, enabled = false)
	public void Home() {

		uploadAssetPage.backToHome();
	}
	
	
	
	

	@Test(priority = 11, enabled = true)
	public void uploadNewAsset_Box() {
		{
			uploadAssetPage.openUploadAssetSection();
			uploadAssetPage.uploadFromBox("arohith@stratapps.com", "Xamplify@11");
    uploadAssetPage.switchToNewWindow();
    uploadAssetPage.enterDescription("This is an automated test asset upload from Box");
		}
	}
}
