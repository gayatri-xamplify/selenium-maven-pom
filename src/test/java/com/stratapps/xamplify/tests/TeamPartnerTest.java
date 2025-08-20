package com.stratapps.xamplify.tests;


import java.awt.AWTException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.TeamPartnerPage;
import com.stratapps.xamplify.utils.ConfigReader;


	public class TeamPartnerTest extends BaseTest {

		private TeamPartnerPage teamPartnerPage;
		private static final Logger logger = LogManager.getLogger(TeamPartnerTest.class);
		private WebDriverWait wait;

		@BeforeClass
		public void setUpClass() {
			super.setUp();
	        logoutIfLoggedIn();

			LoginPage loginPage = new LoginPage(driver);
			loginPage.login(ConfigReader.getProperty("partner.username"), ConfigReader.getProperty("partner.password"));
			
			
			//PartnerLoginPage partnerloginPage = new PartnerLoginPage(driver);
			//partnerloginPage.login(ConfigReader.getProperty("partnerusername"), ConfigReader.getProperty("partnerpassword"));
			teamPartnerPage = new TeamPartnerPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			logger.info("TeamVendorTest setup completed");
		}


    @Test(priority = 1, enabled = true)
    public void testHoverTeam() {
        logger.info("Test 1: Hover Team - STARTED");	
        teamPartnerPage.openTeamPage();
        logger.info("Test 1: Hover Team- COMPLETED");

    }


    @Test(priority = 2, enabled = true)
    public void addTeamMemberTest() throws InterruptedException {
        logger.info("Test 2: Add Team Member - STARTED");
        teamPartnerPage.openTeamPage();
        teamPartnerPage.addTeamMember();
        logger.info("Test 2: Add Team Member - COMPLETED");
    }

    @Test(priority = 3, enabled = true)
    public void inviteTeammemberTest() throws InterruptedException, AWTException {
        logger.info("Test 3: Invite Team Member - STARTED");
        teamPartnerPage.inviteTeamMember();
        logger.info("Test 3: Invite Team Member - COMPLETED");
    }

    @Test(priority = 4, enabled = true)
    public void testFileUpload() throws Exception {
        logger.info("Test 4: Upload CSV - STARTED");
        teamPartnerPage.uploadCSV();
        logger.info("Test 4: Upload CSV - COMPLETED");
    }

    @Test(priority = 5, enabled = true)
    public void testSearchDeleteTM() throws InterruptedException {
        logger.info("Test 5: testSearchFilterExportTM - STARTED");
        
            teamPartnerPage.searchAndDelete("autotest@gmail.com");	
          
        logger.info("Test 5: testSearchFilterExportTM - COMPLETED");
    }


    @Test(priority = 6, enabled = true)
    public void exportTeamMembersTest() throws InterruptedException {
        logger.info("Test 6: Export Team Members - STARTED");
        teamPartnerPage.exportTeamMembers();        
        logger.info("Test 6: Export Team Members - COMPLETED");
    }

    @Test(priority = 7, enabled = true)
    public void filterTeamMembersTest() throws InterruptedException {
        logger.info("Test 7: Filter Team Members by Email and Date - STARTED");
        teamPartnerPage.applyFilters("partnerautomate@gmail.com");
        logger.info("Test 7: Filter Team Members by Email and Date - COMPLETED");
    }

    @Test(priority = 8, enabled = true)
    public void previewTeamMemberTest() throws InterruptedException {
        logger.info("Test 8: Preview Team Member - STARTED");
        teamPartnerPage.PreviewTeamMember();
        logger.info("Test 8: Preview Team Member - COMPLETED");
    }

    @Test(priority = 9, enabled = true)
    public void editTeamMemberTest() throws InterruptedException {
        logger.info("Test 9: Edit Team Member - STARTED");
        teamPartnerPage.editTeamMember("Mounika_edited");
        logger.info("Test 9: Edit Team Member - COMPLETED");
    }

    @Test(priority = 10, enabled = true)
    public void resendEmailTest() throws InterruptedException {
        logger.info("Test 10: Resend Email Notification - STARTED");
        teamPartnerPage.resendInvite();
        logger.info("Test 10: Resend Email Notification - COMPLETED");
    }
    
    @Test(priority = 11, enabled = true)
    public void checkadmins() throws InterruptedException {
        logger.info("Test 11: handleAdminsPopup- STARTED");
        teamPartnerPage.handleAdminsPopup();
        logger.info("Test 11: handleAdminsPopup - COMPLETED");
    }

    @Test(priority = 12, enabled = true)
    public void deleteTeamMemberTest() throws InterruptedException {
        logger.info("Test 12: Delete Team Member - STARTED");
        teamPartnerPage.deleteTeamMember();
        logger.info("Test 12: Delete Team Member - COMPLETED");
    }
    
 

	}


