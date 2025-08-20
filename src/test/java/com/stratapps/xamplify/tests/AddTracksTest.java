
package com.stratapps.xamplify.tests;

import java.awt.AWTException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.AddTracksPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class AddTracksTest extends BaseTest {

    private AddTracksPage addTracksPage;
    private static final Logger logger = LogManager.getLogger(AddTracksTest.class);
    private WebDriverWait wait;

    @BeforeClass
    public void setUpClass() {
        super.setUp();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        addTracksPage = new AddTracksPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        logger.info("AddTracksTest setup completed");
    }

    @Test(priority = 1, enabled = true)
    public void openContentMenuTest() {
        logger.info("Test 1: Open Content Menu - STARTED");
        addTracksPage.openContentMenu();
        logger.info("Test 1: Open Content Menu - COMPLETED");
    }

    @Test(priority = 2, enabled = true)
    public void clickAddTracksTest() {
        logger.info("Test 2: Click Add Tracks - STARTED");
        addTracksPage.clickAddTracks();
        logger.info("Test 2: Click Add Tracks - COMPLETED");
    }

    @Test(priority = 3, enabled = true)
    public void enterTrackTitleTest() {
        logger.info("Test 3: Enter Track Title - STARTED");
        addTracksPage.enterTrackTitle("TestTrack");
        logger.info("Test 3: Enter Track Title - COMPLETED");
    }

    @Test(priority = 4, enabled = true)
    public void selectFolderTest() {
        logger.info("Test 4: Select Folder - STARTED");
        addTracksPage.selectFolder("xamplify2024-Default-Folder");
        logger.info("Test 4: Select Folder - COMPLETED");
    }

    @Test(priority = 5, enabled = true)
    public void addTagsTest() throws AWTException {
        logger.info("Test 5: Add Tags - STARTED");
        addTracksPage.addTags("JPG");
        logger.info("Test 5: Add Tags - COMPLETED");
    }

    @Test(priority = 6, enabled = true)
    public void addMediaAndFormTest() {
        logger.info("Test 6: Add Media and Form - STARTED");
        addTracksPage.addMediaAndForm();
        logger.info("Test 6: Add Media and Form - COMPLETED");
    }

    @Test(priority = 7, enabled = true)
    public void enterDescriptionTest() {
        logger.info("Test 7: Enter Description - STARTED");
        addTracksPage.enterDescription("Track_description");
        logger.info("Test 7: Enter Description - COMPLETED");
    }

    @Test(priority = 8, enabled = true)
    public void selectAssetsAndQuizTest() {
        logger.info("Test 8: Select Assets and Quiz - STARTED");
        addTracksPage.selectAssetsAndQuiz();
        logger.info("Test 8: Select Assets and Quiz - COMPLETED");
    }

    @Test(priority = 9, enabled = true)
    public void publishTrackTest() {
        logger.info("Test 9: Publish Track - STARTED");
        addTracksPage.publishTrack();
        logger.info("Test 9: Publish Track - COMPLETED");
    }

    @Test(priority = 10, enabled = true)
    public void getPublishConfirmationMessageTest() {
        logger.info("Test 10: Get Publish Confirmation Message - STARTED");
        String message = addTracksPage.getPublishConfirmationMessage();
        logger.info("Publish Message: " + message);
        logger.info("Test 10: Get Publish Confirmation Message - COMPLETED");
    }
} 
