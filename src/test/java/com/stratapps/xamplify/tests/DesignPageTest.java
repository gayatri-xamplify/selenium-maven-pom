package com.stratapps.xamplify.tests;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.DesignPages;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.ManageFormsPage;

public class DesignPageTest extends BaseTest{
	private DesignPages designPages;
	private static final Logger logger = LogManager.getLogger(ManageFormsPage.class);
	private WebDriverWait wait;
 
	 @BeforeClass 
	 public void setUpClass() {
	 super.setUp();
	 LoginPage loginPage =  new LoginPage(driver);
	 loginPage.loginAsVendor();
	 designPages = new DesignPages(driver);
	 wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	 logger.info("DesignFormPage setup completed"); 
	 }
	
//    @BeforeClass public void setUpClass() {	    
//    	designPages = new DesignPages(driver);   
//    }
	
		
		  @Test(priority = 1, enabled = true) public void
		  CreateRegularPublicPage()throws InterruptedException {
		  System.out.println(" ");
		  logger.info("Create Regular Public Page in Design Pages");
		  designPages.designDesignPage(); Thread.sleep(4000); designPages.RegularTab();
		  Thread.sleep(4000); designPages.createPage();
		  designPages.regularpublicPageSaveandClose();
		  logger.info("Successfully Created Regular Public Page in Design Pages");
		  System.out.println(" "); }
		  
		  @Test(priority = 2, enabled = true) public void
		  CreateRegularPrivatePage()throws InterruptedException {
		  logger.info("Create Regular Private Page in Design Pages");
		  designPages.designDesignPage(); designPages.RegularTab();
		  designPages.createPage(); designPages.regularPrivatePageSaveandClose();
		  logger.info("Successfully Created Regular Private Page in Design Pages");
		  System.out.println(" "); }
		  
		  @Test(priority = 3, enabled = true) public void
		  CreateRegularProtectedPage()throws InterruptedException {
		  logger.info("Create Regular Protect Page in Design Pages");
		  designPages.designDesignPage(); designPages.RegularTab();
		  designPages.createPage(); designPages.regularProtectedPageSaveandClose();
		  logger.info("Successfully Created Regular Protect Page in Design Pages");
		  System.out.println(" "); }
		  
		  @Test(priority = 4, enabled = true) public void CreateCobrandedPublicPage()
		  throws InterruptedException {
		  logger.info("Create Cobranded Public Page in Design Pages");
		  designPages.designDesignPage(); designPages.cobrandedTab();
		  designPages.createPage(); designPages.cobrandedpublicpagecreation();
		  logger.info("Successfully Created Cobranded Public Page in Design Pages");
		  System.out.println(" "); }
		  
		  @Test(priority = 5, enabled = true) public void CreateCobrandedPrivatePage()
		  throws InterruptedException {
		  logger.info("Create Cobranded Private Page in Design Pages");
		  designPages.designDesignPage(); designPages.cobrandedTab();
		  designPages.createPage(); designPages.cobrandedprivatepagecreation();
		  logger.info("Successfully Created Cobranded Private Page in Design Pages");
		  System.out.println(" "); }
		  
		  @Test(priority = 6, enabled = true) public void
		  CreateCobrandedProtectedPage() throws InterruptedException {
		  logger.info("Create Cobranded Protect Page in Design Pages");
		  designPages.designDesignPage(); designPages.cobrandedTab();
		  designPages.createPage(); designPages.cobrandedProtectedPageSaveandClose();
		  logger.info("Successfully Created Cobranded Protect Page in Design Pages");
		  System.out.println(" "); }
		 	
		  @Test(priority = 7, enabled = true) 
		  public void regularpublicpage() throws
		  InterruptedException, UnsupportedFlavorException, IOException {
		  logger.info("Regular Public Page Actions in Manage Pages");
		  designPages.designManagePage(); 
		  designPages.PageTab("RegularPublic");
		  designPages.searchPage(); 
		  designPages.copyPage(); 
		  designPages.editpage();
		  designPages.CopyAndEmbeddedPage(); 
		  designPages.PreviewPage();
		  designPages.PageAnalytics(); 
		  designPages.DeletePage(); logger.
		  info("Successfully copy, edit, preview, delete, Copy And Embedded Pages & Analytics actions for Regular Public Page in Manage Pages"
		  ); System.out.println(" "); }
		  
		  @Test(priority = 8, enabled = true) public void regularprivatepage() throws
		  InterruptedException, UnsupportedFlavorException, IOException {
		  System.out.println(" ");
		  logger.info("Create Regular Private Page in Design Pages");
		  designPages.designManagePage(); designPages.PageTab("RegularPrivate");
		  designPages.searchPage(); designPages.copyPage(); 
		   designPages.editpage();
		  designPages.CopyAndEmbeddedPage(); designPages.PreviewPage();
		  designPages.PageAnalytics(); designPages.DeletePage(); logger.
		  info("Successfully copy, edit, preview, delete, Copy And Embedded Pages & Analytics actions for Regular Private Page in Manage Pages"
		  ); System.out.println(" "); }
		  
		  @Test(priority = 9, enabled = true) 
		  public void regularprotectpage() throws
		  InterruptedException, UnsupportedFlavorException, IOException {
		  System.out.println(" ");
		  logger.info("Create Regular Protect Page in Design Pages");
		  designPages.designManagePage();
		  designPages.PageTab("RegularProtect");
		  designPages.searchPage();
		  designPages.copyPage();
		   designPages.editpage();
		  designPages.ProtectPageCopyURL();
		  designPages.PreviewPage();
		  designPages.ProtectPageAnalytics();
		  designPages.DeletePage(); logger.
		  info("Successfully copy, edit, preview, delete, Copy Pages & Analytics actions for Regular protect Page in Manage Pages"
		  ); System.out.println(" "); }
		  
		  @Test(priority = 10, enabled = true) public void cobrandedpublicpage() throws
		  InterruptedException, UnsupportedFlavorException, IOException {
		  System.out.println(" ");
		  logger.info("Create Cobranded public Page in Design Pages");
		  designPages.designManagePage(); designPages.PageTab("CoBrandedPublic");
		  designPages.searchPage(); designPages.copyPage(); 
		   designPages.editpage();
		  designPages.CopyAndEmbeddedPage(); designPages.PreviewPage();
		  designPages.PageAnalytics(); designPages.DeletePage(); logger.
		  info("Successfully copy, edit, preview, delete, Copy And Embedded Pages & Analytics actions for Cobranded Public Page in Manage Pages"
		  ); System.out.println(" "); }
		  
		  @Test(priority = 11, enabled = true) public void cobrandedprivatepage()
		  throws InterruptedException, UnsupportedFlavorException, IOException {
		  System.out.println(" ");
		  logger.info("Create Cobranded Private Page in Design Pages");
		  designPages.designManagePage(); designPages.PageTab("CoBrandedPrivate");
		  designPages.searchPage(); designPages.copyPage(); 
		   designPages.editpage();
		  designPages.CopyAndEmbeddedPage(); designPages.PreviewPage();
		  designPages.PageAnalytics(); designPages.DeletePage(); logger.
		  info("Successfully copy, edit, preview, delete, Copy And Embedded Pages & Analytics actions for CoBranded Private Page in Manage Pages"
		  ); System.out.println(" "); }
		 

	  @Test(priority = 12, enabled = true) 
	  public void cobrandedprotectpage() throws
	  InterruptedException, UnsupportedFlavorException, IOException {
	  System.out.println(" ");
	  logger.info("Create Cobranded protect Page in Design Pages");
	  designPages.designManagePage(); 
	  designPages.PageTab("CoBrandedProtect");
	  designPages.searchPage(); 
	  designPages.copyPage(); 
	  designPages.editpage();
	  designPages.ProtectPageCopyURL();
	  designPages.PreviewPage(); 
	  designPages.ProtectPageAnalytics(); 
	  designPages.DeletePage(); logger.
	  info("Successfully copy, edit, preview, delete, Copy Pages & Analytics actions for CoBranded Private Page in Manage Pages"); 
	  System.out.println(" "); 
	  }
}
