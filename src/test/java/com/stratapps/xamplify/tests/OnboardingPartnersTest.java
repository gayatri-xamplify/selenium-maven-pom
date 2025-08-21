package com.stratapps.xamplify.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.OnboardingPartnerPage;

public class OnboardingPartnersTest extends BaseTest{

private OnboardingPartnerPage onboardingPartnerPage;
private static final Logger logger = LogManager.getLogger(OnboardingPartnersTest.class);
private WebDriverWait wait;


 @BeforeClass public void setUpClass() {
 super.setUp();
 LoginPage loginPage =  new LoginPage(driver);
 loginPage.loginAsVendor();
 onboardingPartnerPage = new OnboardingPartnerPage(driver);
 wait = new WebDriverWait(driver, Duration.ofSeconds(60));
 logger.info("OnboardingPartnerPage setup completed"); }

 @Test(priority = 1, enabled = true)
 public void UploadCSV_partner() throws InterruptedException {
  System.out.println(" ");
logger.info("Starting test: onboarding partner using Upload CSV");
  onboardingPartnerPage.HoverPartners_OnboardingPartner();
  onboardingPartnerPage.OnboardParnerThroughUploadCSV();
  logger.info("Successfully onboarded partner using Upload CSV");
  System.out.println(" ");
 }  

 @Test(priority = 2, enabled = true)
 public void OneAtaTime_partner() throws InterruptedException {
logger.info("Starting test: onboarding partner using One At a Time");
  onboardingPartnerPage.HoverPartners_OnboardingPartner();
  onboardingPartnerPage.OnboardPartnerOneAtaTime();
  logger.info("Successfully Onboarded partner using One at a time");
  System.out.println(" ");
 }

 @Test(priority = 3, enabled = true)
 public void EditPartner() throws InterruptedException {
logger.info("Starting test: edit partner and update the partner details");
  onboardingPartnerPage.HoverPartners_OnboardingPartner();
  onboardingPartnerPage.partnerEdit();
  logger.info("Successfully updated the partner details");
  System.out.println(" ");
 }

 @Test(priority = 4, enabled = true)
 public void SearchPartner() throws InterruptedException {
logger.info("Starting test: search the partner");
  onboardingPartnerPage.HoverPartners_OnboardingPartner();
  onboardingPartnerPage.searchAndVerifyPartner();
  logger.info("Successfully search the partner");
  System.out.println(" ");
 }

 @Test(priority = 5, enabled = true)
 public void ExportExcellReportPartner() throws InterruptedException {
logger.info("Starting test: export the partner details to excel report");
  onboardingPartnerPage.exportToExcel();
  logger.info("Successfully exported the partner details to excel");
  System.out.println(" ");
 }

 @Test(priority = 6, enabled = true)
 public void ExportEmailReportPartner() throws InterruptedException {
logger.info("Starting test: export the partner details to email report");
  onboardingPartnerPage.exportToEmail();
  logger.info("Successfully exported the partner details to email");
  System.out.println(" ");
 }

 @Test(priority = 7, enabled = true)
 public void CreateGroupPartner() throws InterruptedException {
logger.info("Starting test: create new partner group");
  onboardingPartnerPage.createGroup();
  logger.info("Successfully created the partner group");
  System.out.println(" ");
 }

 @Test(priority = 8, enabled = true)
 public void AddToGroupPartner() throws InterruptedException {
logger.info("Starting test: Add partner to existing group");
  onboardingPartnerPage.HoverPartners_OnboardingPartner();
  onboardingPartnerPage.addToGroup();
  logger.info("Successfully Added the partner to the group");
  System.out.println(" ");
 }

 @Test(priority = 9, enabled = true)
 public void ApplyFilter_partner() throws InterruptedException {
logger.info("Starting test: Apply Filter with partner Fields ");
  onboardingPartnerPage.HoverPartners_OnboardingPartner();
  onboardingPartnerPage.filterPartner("City", "Contains", "Hyderabad");
  logger.info("Successfully Appllied Filter");
  logger.info("Apply multiple Filter condition");
  onboardingPartnerPage.addFilterRecord("Email Id", "Contains", "us1user1743671923219@gmail.com");
  logger.info("Successfully applied Multiple filter conditions");
  logger.info("Delete applied filter record ");
  onboardingPartnerPage.deleteFilterRecord();
  logger.info("Successfully Delete applied filter record");
  System.out.println(" ");
 }

 @Test(priority = 10, enabled = true)
 public void DeletePartner() throws InterruptedException {
logger.info("Starting test: Deleted the partner");
  onboardingPartnerPage.HoverPartners_OnboardingPartner();
  onboardingPartnerPage.deletePartner();
  logger.info("Successfully Deleted the partner");
  System.out.println(" ");
 }

 @Test(priority = 11, enabled = true)
 public void PaginationPartner() throws Throwable {
logger.info("Starting test: navigate to next page through pagination");
  onboardingPartnerPage.HoverPartners_OnboardingPartner();
  onboardingPartnerPage.pagenation();
  logger.info("successfully navigated to next page through pagination");
  System.out.println(" ");
 }

 @Test(priority = 12, enabled = true)
 public void SortAndRecordsPerPage() throws Throwable {
logger.info("Starting test: Sort the records and no of records per page");
  onboardingPartnerPage.HoverPartners_OnboardingPartner();
  onboardingPartnerPage.SortAndNoofrecord();
  logger.info("successfully sort and select no of partner records per page");
  System.out.println(" ");
 }



}