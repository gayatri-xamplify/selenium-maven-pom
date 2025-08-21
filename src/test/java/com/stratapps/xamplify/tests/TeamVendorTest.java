
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
import com.stratapps.xamplify.pages.TeamVendorPage;
import com.stratapps.xamplify.utils.ConfigReader;
public class TeamVendorTest extends BaseTest {

	private TeamVendorPage teamvendorPage;
	private static final Logger logger = LogManager.getLogger(TeamVendorTest.class);
	private WebDriverWait wait;

	

	  @BeforeClass
	    public void setUpClass() {
	        super.setUp();  // ✅ Ensure driver setup and URL navigation happens

	        if (!isLoggedIn()) {  // ✅ Only log in if session isn't active
	            LoginPage loginPage = new LoginPage(driver);
	            loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
	        }

	        teamvendorPage = new TeamVendorPage(driver);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	        logger.info("AddTracksTest setup completed");
	    }

	    

    @Test(priority = 1, enabled = true)
    public void addTeamMemberTest() throws InterruptedException {
        logger.info("Test 1: Add Team Member - STARTED");
        teamvendorPage.hoverTeam();
        teamvendorPage.addTeammember();
        logger.info("Test 1: Add Team Member - COMPLETED");
    }

    @Test(priority = 2, enabled = true)
    public void inviteTeammemberTest() throws InterruptedException, AWTException {
        logger.info("Test 2: Invite Team Member - STARTED");
        teamvendorPage.inviteTeammember();
        logger.info("Test 2: Invite Team Member - COMPLETED");
    }

    @Test(priority = 3, enabled = true)
    public void testFileUpload() throws Exception {
        logger.info("Test 3: Upload CSV - STARTED");
        teamvendorPage.testFileUpload();
        logger.info("Test 3: Upload CSV - COMPLETED");
    }

    @Test(priority = 4, enabled = true)
    public void searchTeamMemberTest() throws InterruptedException {
        logger.info("Test 4: Search Team Member - STARTED");
        teamvendorPage.searchTeamMember();
        logger.info("Test 4: Search Team Member - COMPLETED");
    }

    @Test(priority = 5, enabled = true)
    public void deleteUploadedMemberTest() throws InterruptedException {
        logger.info("Test 5: Delete Uploaded Member - STARTED");
        teamvendorPage.deleteSearchedMember();
        logger.info("Test 5: Delete Uploaded Member - COMPLETED");
    }

    @Test(priority = 6, enabled = true)
    public void exportTeamMembersTest() throws InterruptedException {
        logger.info("Test 6: Export Team Members - STARTED");
        teamvendorPage.exportTeamMembers();
        logger.info("Test 6: Export Team Members - COMPLETED");
    }

    @Test(priority = 7, enabled = true)
    public void filterTeamMembersTest() throws InterruptedException {
        logger.info("Test 7: Filter Team Members by Email and Date - STARTED");
        teamvendorPage.filterByEmailAndDate("automation.vendor2024@gmail.com");
        logger.info("Test 7: Filter Team Members by Email and Date - COMPLETED");
    }

    @Test(priority = 8, enabled = true)
    public void previewTeamMemberTest() throws InterruptedException {
        logger.info("Test 8: Preview Team Member - STARTED");
        teamvendorPage.PreviewTeamMember();
        logger.info("Test 8: Preview Team Member - COMPLETED");
    }

    @Test(priority = 9, enabled = true)
    public void editTeamMemberTest() throws InterruptedException {
        logger.info("Test 9: Edit Team Member - STARTED");
        teamvendorPage.editTeammember("Mounika_edited");
        logger.info("Test 9: Edit Team Member - COMPLETED");
    }

    @Test(priority = 10, enabled = true)
    public void resendEmailTest() throws InterruptedException {
        logger.info("Test 10: Resend Email Notification - STARTED");
        teamvendorPage.resendEmailNotification();
        logger.info("Test 10: Resend Email Notification - COMPLETED");
    }
    
    @Test(priority = 11, enabled = true)
    public void checkadmins() throws InterruptedException {
        logger.info("Test 11: handleAdminsPopup- STARTED");
        teamvendorPage.handleAdminsPopup();
        logger.info("Test 11: handleAdminsPopup - COMPLETED");
    }


    @Test(priority = 12, enabled = true)
    public void deleteTeamMemberTest() throws InterruptedException {
        logger.info("Test 12: Delete Team Member - STARTED");
        teamvendorPage.deleteTeammember();
        logger.info("Test 12: Delete Team Member - COMPLETED");
    }
} 
