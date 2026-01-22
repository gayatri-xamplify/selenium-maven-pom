
package com.stratapps.xamplify.tests;

import java.awt.AWTException;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.AccessSharedPlaybooksPage;
import com.stratapps.xamplify.pages.AddPlaybooksPage;
import com.stratapps.xamplify.pages.LoginPage;

public class AddPlaybooksTest extends BaseTest {

    private AddPlaybooksPage addPlaybooksPage;
    private static final Logger logger = LogManager.getLogger(AddPlaybooksTest.class);
    private WebDriverWait wait;

  
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {

	    logger.info("🔧 Setting up AccessSharedAssetsTest");

	    // Preconditions guaranteed by BaseTest:
	    // - Browser already launched
	    // - Partner already logged in (role=PARTNER)

		 addPlaybooksPage = new AddPlaybooksPage(driver);
	    wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    logger.info("✅ AccessSharedAssetsTest setup completed");
	}

	
	
	
    

    @Test(priority = 1, enabled = true)
    public void openContentMenuTest() {
        logger.info("Test 1: Open Content Menu - STARTED");
        addPlaybooksPage.openContentMenu();
        logger.info("Test 1: Open Content Menu - COMPLETED");
    }

    @Test(priority = 2, enabled = true)
    public void clickAddPlaybooksTest() {
        logger.info("Test 2: Click Add Playbooks - STARTED");
        addPlaybooksPage.clickAddPlaybooks();
        logger.info("Test 2: Click Add Playbooks - COMPLETED");
    }

    @Test(priority = 3, enabled = true)
    public void enterPlaybookTitleTest() {
        logger.info("Test 3: Enter Playbook Title - STARTED");
        addPlaybooksPage.enterPlaybookTitle("TestPlaybook");
        logger.info("Test 3: Enter Playbook Title - COMPLETED");
    }

    @Test(priority = 4, enabled = true)
    public void selectFolderTest() {
        logger.info("Test 4: Select Folder - STARTED");
        addPlaybooksPage.selectFolder("xamplify2024-Default-Folder");
        logger.info("Test 4: Select Folder - COMPLETED");
    }

    @Test(priority = 5, enabled = false)
    public void addTagsTest() throws AWTException, InterruptedException {
        logger.info("Test 5: Add Tags - STARTED");
        addPlaybooksPage.addTags("JPG");
        logger.info("Test 5: Add Tags - COMPLETED");
    }

    @Test(priority = 6, enabled = true)
    public void addMediaAndFormTest() throws InterruptedException {
        logger.info("Test 6: Add Media and Form - STARTED");
        addPlaybooksPage.addMediaAndForm();
        logger.info("Test 6: Add Media and Form - COMPLETED");
    }

    @Test(priority = 7, enabled = true)
    public void enterDescriptionTest() {
        logger.info("Test 7: Enter Description - STARTED");
        addPlaybooksPage.enterDescription("Playbook_description");
        logger.info("Test 7: Enter Description - COMPLETED");
    }

    @Test(priority = 8, enabled = true)
    public void AssetsAndQuizTest() throws Exception {
        logger.info("Test 8: Select Assets and Quiz - STARTED");
        addPlaybooksPage.selectAsset("jpg");
        addPlaybooksPage.selectAssetslist();
        logger.info("Test 8: Select Assets and Quiz - COMPLETED");
    }

    @Test(priority = 9, enabled = true)
    public void publishPlaybookTest() {
        logger.info("Test 9: Publish Playbook - STARTED");
        addPlaybooksPage.publishPlaybook();
        logger.info("Test 9: Publish Playbook - COMPLETED");
    }

    @Test(priority = 10, enabled = true)
    public void getPublishConfirmationMessageTest() {
        logger.info("Test 10: Get Publish Confirmation Message - STARTED");
        String message = addPlaybooksPage.getPublishConfirmationMessage();
        logger.info("Publish Message: " + message);
        addPlaybooksPage.backToHome();
        logger.info("Test 10: Get Publish Confirmation Message - COMPLETED");
    }
} 
