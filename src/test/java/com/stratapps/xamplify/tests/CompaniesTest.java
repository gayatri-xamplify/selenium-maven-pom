package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.CompaniesPage;
import com.stratapps.xamplify.pages.DesignFormPage;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.ManageContactsPage;

public class CompaniesTest extends BaseTest{
	private CompaniesPage companiesPage;
	private ManageContactsPage manageContactsPage;
	private static final Logger logger = LogManager.getLogger(CompaniesTest.class);
	private WebDriverWait wait;
  
	@BeforeClass
	public void setUpClass() {  
		try {
			companiesPage = new CompaniesPage(driver);
			manageContactsPage = new ManageContactsPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			logger.info("CompaniesPage setup completed");
		} catch (Exception e) {
			System.out.println("Note: Hide multiple classes Run");
		}
		try {
			super.setUp();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginAsPartner();
			companiesPage = new CompaniesPage(driver);
			manageContactsPage = new ManageContactsPage(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			logger.info("companiesPage setup completed");
		} catch (Exception e) {
			System.out.println("Note: single class Run Fail");
		}
	}
	
	@Test(priority = 1, enabled = true)
	public void AddCompany() throws InterruptedException {
		System.out.println(" ");
		logger.info("Create Company in Companies Pages");
		companiesPage.NavigateToCompany();
		companiesPage.AddCompany("CMP7664");
		logger.info("Successfully Created Company in Companies Pages");
		System.out.println("check1 ");
	}
	
	@Test(priority = 2, enabled = true)
	public void CompanyActions() throws Exception {
		logger.info("perform Company actions in Companies Pages");
		System.out.println("check3 ");
		companiesPage.editCompanyDetails();
		companiesPage.AddContactUnderCompany();
		companiesPage.SearchCompany("Cmp");
		companiesPage.DeleteCompany();
		companiesPage.SearchClear();
		companiesPage.PreviewCompany();
		companiesPage.SynchronizeCompanies();
		logger.info("Successfully perform Company action in Companies Pages");
		System.out.println(" ");
	}
	
    @Test(priority = 3, enabled = true)
	public void CompanyCountValidationAndPagination() throws Exception {
    	companiesPage.TileCountValidation();
    	manageContactsPage.ManageContactPagination();
    }
	
}
