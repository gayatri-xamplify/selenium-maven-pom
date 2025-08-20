package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.ManagePartnerPage;
import com.stratapps.xamplify.pages.OnboardingPartnerPage;

public class ManagePartnerTest extends BaseTest{
	
	private ManagePartnerPage managePartnerPage;
	private static final Logger logger = LogManager.getLogger(ManagePartnerTest.class);
	private WebDriverWait wait;
	
    OnboardingPartnerPage onboardingPartnerPage = new OnboardingPartnerPage(this.driver);

	
	/*
	 * @BeforeClass public void setUpClass() { super.setUp(); LoginPage loginPage =
	 * new LoginPage(driver); loginPage.loginAsVendor(); managePartnerPage = new
	 * ManagePartnerPage(driver); wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(60));
	 * logger.info("OnboardingPartnerPage setup completed"); }
	 * 
	 */

		@Test(priority = 1, enabled = true)
		public void CreatePartnerGroup_ManagePartner() throws InterruptedException {
			System.out.println(" ");
			logger.info("Creating new partner group in Manage partners");
			managePartnerPage.HoverOnPartnersManagePartners();
			managePartnerPage.CreateNewPartnerGroup();
			logger.info("Successfully Created new partner group");
			System.out.println(" ");
		}

		@Test(priority = 2, enabled = true)
		public void Sortandsearch_Copyandsavegroup_ManagePartner() throws Throwable {
			System.out.println(" ");
			logger.info("Sort & search partner group and copy&save the partner group in Manage partners");
			managePartnerPage.HoverOnPartnersManagePartners();
			managePartnerPage.Mpartners_Sortandsearch_Copyandsavegroup();
			logger.info("Successfully Sort & search partner group and copy&save the partner group in Manage partners");
			System.out.println(" ");
		}
		
		@Test(priority = 3, enabled = true)
		public void EmailReport_ManagePartner() throws InterruptedException {
			System.out.println(" ");
			logger.info("Generate partner EmailReport in Manage partners");
			managePartnerPage.HoverOnPartnersManagePartners();
			managePartnerPage.exportToMail();
			logger.info("Successfully Generated partner EmailReport in Manage partners");
			System.out.println(" ");
		}
		
		@Test(priority = 4, enabled = true)
		public void EditGroup_ManagePartner() throws InterruptedException {
			System.out.println(" ");
			logger.info("Edit partner group in Manage partners");
			managePartnerPage.HoverOnPartnersManagePartners();
			managePartnerPage.Mpartners_EditGroup();
			logger.info("Apply Filter with partner Fields ");
			managePartnerPage.filterManagePartner("City", "Contains", "Hyderabad");
			logger.info("Successfully Appllied Filter");
			logger.info("Apply multiple Filter condition");
			onboardingPartnerPage.addFilterRecord("Email Id", "Contains", "us1user1743671923219@gmail.com");
			logger.info("Successfully applied Multiple filter conditions");
			logger.info("Delete applied filter record ");
			onboardingPartnerPage.deleteFilterRecord();	
			logger.info("Successfully Delete applied filter record");
			logger.info("Successfully Edit partner group in Manage partners");
			System.out.println(" ");
		}

		@Test(priority = 5, enabled = true)
		public void PublishContent_ManagePartner() throws InterruptedException {
			System.out.println(" ");
			logger.info("Publish Content to partner in Manage partners");
			managePartnerPage.HoverOnPartnersManagePartners();
			managePartnerPage.Mpartners_publishContent();
			logger.info("Successfully Publish Content to partner in Manage partners");
			System.out.println(" ");
		}
		
		@Test(priority = 6, enabled = true)
		public void DeleteGroup_ManagePartner() throws InterruptedException {
			System.out.println(" ");
			logger.info("Delete partner group in Manage partners");
			managePartnerPage.HoverOnPartnersManagePartners();
			managePartnerPage.Mpartners_DeleteGroup();
			logger.info("Successfully Deleted the partner group in Manage partners");
			System.out.println(" ");
		}
		
		@Test(priority = 7, enabled = true)
		public void ExportExcelReport_ManagePartner() throws InterruptedException {
			System.out.println(" ");
			logger.info("Export partner Excel Report in Manage partners");
			managePartnerPage.HoverOnPartnersManagePartners();
			managePartnerPage.exportToExcel();
			logger.info("Successfully Export partner Excel Report Manage partners");
			System.out.println(" ");
		}
		
		@Test(priority = 8, enabled = true)
		public void Pagination_ManagePartner() throws Throwable {
			System.out.println(" ");
			logger.info("Edit partner group in Manage partners");
			managePartnerPage.HoverOnPartnersManagePartners();
			managePartnerPage.pagenation();
			logger.info("Successfully Edit partner group in Manage partners");
			System.out.println(" ");
		}
		
		@Test(priority = 11, enabled = true)
		public void Home() throws Throwable {
			System.out.println(" ");
			logger.info("Navigate to Home Page");
			managePartnerPage.backToHome();
			logger.info("Successfully Navigate to Home Page");
			System.out.println(" ");
		}
		
	  
	  

}
