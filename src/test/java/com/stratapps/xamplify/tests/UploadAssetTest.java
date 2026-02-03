
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
import com.stratapps.xamplify.pages.OnboardingPartnerPage;
import com.stratapps.xamplify.pages.ScheduleVideoCampaignPage;
import com.stratapps.xamplify.pages.UploadAssetPage;
import com.stratapps.xamplify.pages.VideoCampaignPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class UploadAssetTest extends BaseTest {

	private UploadAssetPage uploadAssetPage;
	private static final Logger logger = LogManager.getLogger(UploadAssetTest.class);
	private WebDriverWait wait;
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
	    logger.info("🔧 Setting up UploadAssetTest");

	    // At this point:
	    // - Browser is already launched (@BeforeSuite)
	    // - Partner login is already done (@Parameters role=PARTNER)

		uploadAssetPage = new UploadAssetPage(driver);

		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    logger.info("✅ UploadAssetTest setup completed");
	}

	
	
	
	
	

	@Test(priority = 1, enabled = false)
	public void uploadAndSaveAsset_docx() throws InterruptedException {

	    String filePath = System.getProperty("user.dir") + "/files/test-docx.docx";

	    uploadAssetPage.openUploadAssetSection();
	    uploadAssetPage.uploadFile(filePath);
	    uploadAssetPage.selectDropdown("docx", "xamplify", "xamplify2024-Default-Folder");
	    uploadAssetPage.enterDescription("This is an automated test asset upload");
	    //uploadAssetPage.addTags("automation");
	    uploadAssetPage.saveAsset();
	    uploadAssetPage.getPublishConfirmationMessage();
	    uploadAssetPage.backToHome();
	}
	
	

	@Test(priority = 2, enabled = false)
	public void uploadAndsaveasDraft_mp3() throws InterruptedException {

	    String filePath = System.getProperty("user.dir") + "/files/test-mp3.mp3";

		uploadAssetPage.openUploadAssetSection();
		  uploadAssetPage.uploadFile(filePath);
		// Start asset upload flow
		//uploadAssetPage.uploadFile("D:\\git\\selenium-maven-pom\\files\\test-mp3.mp3");
		// Select folder, category, tags etc.
		uploadAssetPage.selectDropdown("mp3", "xamplify", "xamplify2024-Default-Folder");
		uploadAssetPage.enterDescription("This is an automated test asset upload");
		uploadAssetPage.saveAsDraftAsset();
		uploadAssetPage.getPublishConfirmationMessage();
		uploadAssetPage.backToHome();
	}

	@Test(priority = 3, enabled = false)
	public void uploadAndPublishAsset_mp4() throws InterruptedException {
	    String filePath = System.getProperty("user.dir") + "/files/test-mp4.mp4";

		uploadAssetPage.openUploadAssetSection();
		// Start asset upload flow
		uploadAssetPage.uploadFile(filePath);
		// Select folder, category, tags etc.
		uploadAssetPage.selectDropdown("mp4", "xamplify", "xamplify2024-Default-Folder");
		uploadAssetPage.enterDescription("This is an automated test asset upload");
		uploadAssetPage.selectPartner();
		uploadAssetPage.getPublishConfirmationMessage();
		uploadAssetPage.backToHome();

	}

	@Test(priority = 4, enabled = false)
	public void uploadAndPublishAsset_doc() throws InterruptedException {
	    String filePath = System.getProperty("user.dir") + "/files/test-doc.doc";

		uploadAssetPage.openUploadAssetSection();
		// Start asset upload flow
		uploadAssetPage.uploadFile(filePath);
		// Select folder, category, tags etc.
		uploadAssetPage.selectDropdown("doc", "xamplify", "xamplify2024-Default-Folder");
		uploadAssetPage.enterDescription("This is an automated test asset upload");
		uploadAssetPage.selectPartner();
		uploadAssetPage.getPublishConfirmationMessage();
		uploadAssetPage.backToHome();

	}

	@Test(priority = 5, enabled = false)
	public void uploadAndPublishAsset_jpg() throws InterruptedException {
	    String filePath = System.getProperty("user.dir") + "/files/test-image.jpg";

		uploadAssetPage.openUploadAssetSection();
		// Start asset upload flow
		uploadAssetPage.uploadFile(filePath);
		// Select folder, category, tags etc.
		uploadAssetPage.selectDropdown("Jpg", "xamplify", "xamplify2024-Default-Folder");
		uploadAssetPage.enterDescription("This is an automated test asset upload");
		uploadAssetPage.selectPartner();
		uploadAssetPage.getPublishConfirmationMessage();
		uploadAssetPage.backToHome();

	}

	@Test(priority = 6, enabled = false)
	public void uploadAndPublishAsset_ppt() throws InterruptedException {
	    String filePath = System.getProperty("user.dir") + "/files/test-ppt.ppt";

		uploadAssetPage.openUploadAssetSection();
		// Start asset upload flow
		uploadAssetPage.uploadFile(filePath);
		// Select folder, category, tags etc.
		uploadAssetPage.selectDropdown("ppt", "xamplify", "xamplify2024-Default-Folder");
		uploadAssetPage.enterDescription("This is an automated test asset upload");
		uploadAssetPage.selectPartner();
		uploadAssetPage.getPublishConfirmationMessage();
		uploadAssetPage.backToHome();

	}

	@Test(priority = 7, enabled = false)
	public void uploadAndPublishAsset_zip() throws InterruptedException {
	    String filePath = System.getProperty("user.dir") + "/files/test-zip.zip";

		uploadAssetPage.openUploadAssetSection();
		// Start asset upload flow
		uploadAssetPage.uploadFile(filePath);
		// Select folder, category, tags etc.
		uploadAssetPage.selectDropdown("zip", "xamplify", "xamplify2024-Default-Folder");
		uploadAssetPage.enterDescription("This is an automated test asset upload");
		uploadAssetPage.selectPartner();
		uploadAssetPage.getPublishConfirmationMessage();
		uploadAssetPage.backToHome();

	}

	@Test(priority = 8, enabled = false)
	public void uploadAndPublishAsset_pdf() throws InterruptedException {
	    String filePath = System.getProperty("user.dir") + "/files/test-file.pdf";

		uploadAssetPage.openUploadAssetSection();
		// Start asset upload flow
		uploadAssetPage.uploadFile(filePath);
		// Select folder, category, tags etc.
		uploadAssetPage.selectDropdown("pdf", "xamplify", "xamplify2024-Default-Folder");
		uploadAssetPage.enterDescription("This is an automated test asset upload");
		uploadAssetPage.selectPartner();
		uploadAssetPage.getPublishConfirmationMessage();
		uploadAssetPage.backToHome();

	}

	@Test(priority = 9, enabled = false)
	public void uploadAndPublishAsset_csv() throws InterruptedException {
	    String filePath = System.getProperty("user.dir") + "/files/test-csv.csv";

		uploadAssetPage.openUploadAssetSection();
		// Start asset upload flow
		uploadAssetPage.uploadFile(filePath);
		// Select folder, category, tags etc.
		uploadAssetPage.selectDropdown("csv", "xamplify", "xamplify2024-Default-Folder");
		uploadAssetPage.enterDescription("This is an automated test asset upload");
		uploadAssetPage.selectPartner();
		uploadAssetPage.getPublishConfirmationMessage();
		uploadAssetPage.backToHome();

	}

	@Test(priority = 9, enabled = false)
	public void PublishConfirmationMessage() {

		uploadAssetPage.getPublishConfirmationMessage();
		uploadAssetPage.backToHome();
	}

	@Test(priority = 10, enabled = true)
	public void uploadNewAsset_Box() throws InterruptedException {
		{
			uploadAssetPage.openUploadAssetSection();
			uploadAssetPage.uploadFromBox("arohith@stratapps.com", "Sarigamapa@xamplify2026");
			uploadAssetPage.switchToNewWindow();
			uploadAssetPage.selectPartner();
			uploadAssetPage.getPublishConfirmationMessage();
			uploadAssetPage.backToHome();
		}
	}

	@Test(priority = 13, enabled = false)
	public void DesignPDFPublish() throws Exception {
		uploadAssetPage.openDesignPDFSection();
		uploadAssetPage.selectPartnerPDF();
		uploadAssetPage.backToHome();
	}

	@Test(priority = 12, enabled = false)
	public void DesignPDFSave() throws Exception {
		uploadAssetPage.openDesignPDFSection();
		uploadAssetPage.fillAssetDetailsAndSave();
		uploadAssetPage.backToHome();

	}

	@Test(priority = 11, enabled = false)
	public void DesignPDFDraft() throws Exception {
		uploadAssetPage.openDesignPDFSection();
		uploadAssetPage.fillAssetDetailsAndSaveDraft();
		uploadAssetPage.backToHome();

	}

}
