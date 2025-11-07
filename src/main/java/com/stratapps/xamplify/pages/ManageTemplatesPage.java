package com.stratapps.xamplify.pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.utils.ActionUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class ManageTemplatesPage {
	WebDriver driver;
	private WebDriverWait wait;
	long timestamp = System.currentTimeMillis();

	public ManageTemplatesPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	public static final By managetemplates = By.xpath("//span[@class='design-name']");
	public static final By gridview = By.xpath("//i[@class='fa fa-th-large p10']");
	public static final By Templatename = By.xpath("//input[@name='templateName']");
	public static final By update = By.xpath("//button[@id='update']");
	public static final By updateandclose = By.xpath("//button[@id='update-and-redirect']");
	public static final By savingtemplate = By.xpath("//button[@id='save']");
	public static final By deletetemplate = By.xpath("(//a[@title='Delete'])[1]");
	public static final By SelectingvideoTemplate = By.xpath("(//li[@class='filter'])[2]");
	public static final By SelectingemailcobrandingTemplate = By.xpath("(//li[@class='filter'])[3]");
	public static final By SelectVideocobrandingTemplate = By.xpath("(//li[@class='filter'])[4]");
	public static final By SelecteventTemplate = By.xpath("(//li[@class='filter'])[6]");
	public static final By SelecteventcobrandingTemplate = By.xpath("(//li[@class='filter'])[7]");
	public static final By uploadcustomtab = By.xpath("(//li[@class='filter'])[5]");
	public static final By uploadcustomname = By.xpath("//input[@id='name']");
	public static final By clickonbrowse = By.xpath("//button[@id='browse']");
	public static final By saveuploadcustom = By.xpath("//button[@id='save']");
	public static final By previewtemplate = By.xpath("(//a[@class='Iconhover custom-grid-icon'])[3]");
	public static final By copytemplate = By.xpath("(//a[@class='Iconhover custom-grid-icon'])[1]");
	public static final By enteringthename = By.xpath("//input[@placeholder='Please Enter Name']");
	public static final By copytemplatesavechanges = By.xpath("(//button[@class='button bgcolor-unset'])[2]");
	public static final By closepopup = By.xpath("//button[@class='swal2-confirm styled']");
	public static final By emailspamscore = By.xpath("(//a[@class='Iconhover custom-grid-icon'])[2]");
	public static final By emailspamcheck = By.xpath("//button/span[@class='btn btn-primary transition txt_pd-top3']");
	public static final By emailsendtestmail = By.xpath("(//a[@class='Iconhover custom-grid-icon'])[4]");
	public static final By emailsubjectline = By.xpath("//input[@placeholder='Please Enter Email Subject']");
	public static final By Send_TestMail = By.xpath("(//button[@type='submit'])[3]");
	public static final By Edittemplate = By.xpath("(//i[@class='fa fa-pencil-square-o mDisableColor IconCustomization'])[1]");
	public static final By emailspamclose = By.xpath("(//a[@class='btn Btn-Gray'])[2]");
	public static final By EmailAddress = By.xpath("//input[@placeholder='Please Enter Email Address']");
	public static final By successOkBtn = By.xpath("//button[@class='swal2-confirm styled']");
	public static final By view = By
			.xpath("//button[@class='fa fa-th-list btn btn-xs l-g-view mr_4 view_type mobile_view_type']");
	public static final By videodiv = By.xpath("(//div[@class='bar gridIconCustomization'])[1]");
	public static final By sendtestmailvideo = By.xpath("(//a[@class='Iconhover custom-grid-icon'])[4]");
	public static final By submitandsend = By.xpath("(//button[@type='submit'])[3]");
	public static final By sentandok = By.xpath("//button[@class='swal2-confirm styled']");
	public static final By YesDeleteIt = By.xpath("//button[@class='swal2-confirm styled']");
	public static final By folderlistview = By.xpath("(//span[@class='btn btn-xs l-g-view margin-space'])[2]");
	public static final By folderemailcobranding = By.xpath("(//li[@class='filter'])[4]");
	public static final By folderview1 = By
			.xpath("//div[@class='bar barview full-width-folder gridIconCustomization']");
	public static final By viewicon = By.xpath("//a[@class='Iconhover custom-icon']");
	public static final By view1 = By
			.xpath("//button[@class='fa fa-th-list btn btn-xs l-g-view mr_4 view_type mobile_view_type']");
	public static final By foldergridviewicon1 = By.xpath("(//span[@class='btn btn-xs l-g-view margin-space'])[1]");
	public static final By videocobrandingtemplate = By.xpath("(//li[@class='filter'])[5]");
	public static final By folderlistview1 = By.xpath("//i[@class='fa fa-th p10']");
	public static final By openfolder = By.xpath("(//i[@class='fa fa-angle-right'])[4]");
	public static final By eventtemplateflist = By.xpath("(//li[@class='filter'])[6]");
	public static final By buttonsent1 = By.xpath("//button[@class='button bgcolor-unset btn-top3']");
	public static final By deletingok = By.xpath("//button[@class='swal2-confirm styled']");
	public static final By view2 = By
			.xpath("//button[@class='fa fa-th-list btn btn-xs l-g-view mr_4 view_type mobile_view_type']");
	public static final By folderlist_grid = By.xpath("(//i[@class='fa fa-th-large p10'])[2]");
	public static final By eventcobrandingtemplateflist = By.xpath("(//li[@class='filter'])[7]");
	public static final By deletetheeventcotemplatebbutton = By.xpath("(//a[@class='Iconhover custom-icon'])[1]");
	public static final By deletingtheeventco = By.xpath("//button[@class='swal2-confirm styled']");
	public static final By submitandsendevent = By.xpath("//button[@class='button bgcolor-unset btn-top3']");
	public static final By openthefolder = By.xpath("(//i[@class='fa fa-angle-right'])[4]");
	public static final By openingtheview = By.xpath("(//i[@class='fa fa-th-large p10'])[2]");
	public static final By divofthetemplate = By.xpath("(//div[@class='bar gridIconCustomization'])[1]");
	public static final By sort = By.xpath("//select[@id='alignline-m-width']");
	public static final By searchbox = By
			.xpath("(//input[@class='form-control ng-untouched ng-pristine ng-valid'])[2]");
	public static final By searchbutton2 = By.xpath("//button[@class='search-box-item-click only_content']");
	public static final By insertMergetags = By.xpath("//span[@class='btn btn-primary transition']");
	public static final By CopyIconFirstNameMergetag = By.xpath("(//i[@class='fa fa-copy IconCustomization campaignViewIcon'])[2]");
	public static final By CopyIconLastNameMergetag = By.xpath("(//i[@class='fa fa-copy IconCustomization campaignViewIcon'])[2]");
	public static final By mergetagPopupClose = By.xpath("//button[@id='bottom-right']");
	public static final By DragTextElement = By.xpath("(//div[@role=\"listitem\"])[1]");
	public static final By DropTextBox = By.xpath("(//div[@role=\"group\"])[7]");
	public static final By ClickHere = By.xpath("//a[text()='click here']");	
	public static final By Search = By.xpath("//input[@placeholder='search...']");
	public static final By searchSubmit = By.xpath("(//button[@type='submit'])[2]");
	public static final By PreviousPage = By.xpath("//i[@data-original-title=\"Previous\"]");
	public static final By firstPage = By.xpath("//i[@data-original-title=\"First\"]");
	public static final By nextPage = By.xpath("data-original-title=\"Next\"");
	public static final By lastPage = By.xpath("data-original-title=\"Last\"");
	public static final By fsfs2 = By.xpath("");
	public static final By fsfee2 = By.xpath("");
	public static final By fswfs2 = By.xpath("");
	
	
	// ---------------------------------------------

	/* @NavigateToManageTempates written by Ganesh ***/
	public void NavigateToManageTempates() throws InterruptedException {
		Thread.sleep(3000);
		WaitUtil.waitAndClick(driver, DesignTemplatesPage.Designmodule, 20);
		WaitUtil.waitAndClick(driver, managetemplates, 20);	
	}
	
	/* @copyTemplate written by Ganesh ***/
	public void copyTemplate() throws InterruptedException {
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, copytemplate, 200);
		WaitUtil.waitAndClick(driver, copytemplatesavechanges, 20);
		WaitUtil.waitAndClick(driver, successOkBtn, 20);
	}
	
	/* @DeleteTemplate written by Ganesh ***/
	public void DeleteTemplate() throws InterruptedException {
		WaitUtil.waitAndClick(driver, deletetemplate, 20);
		WaitUtil.waitAndClick(driver, YesDeleteIt, 20);
		Thread.sleep(2000);
	}
	
	/* @DeleteTemplate written by Ganesh ***/
	public void PreviewTemplate() throws InterruptedException {
		WaitUtil.waitAndClick(driver, previewtemplate, 20);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(tabs.get(0));	
		}
	
	/* @SendTestMail written by Ganesh ***/
	public void SendTestMail() throws InterruptedException {
		Thread.sleep(3000);
		WaitUtil.waitAndClick(driver, emailsendtestmail, 120);
		WaitUtil.waitAndSendKeys(driver, emailsubjectline, "Test Mail For Template", 20);
		WaitUtil.waitAndSendKeys(driver, EmailAddress, "automation.vendor2024@gmail.com", 20);
		WaitUtil.waitAndClick(driver, ClickHere, 20);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(tabs.get(0));
		WaitUtil.waitAndClick(driver, Send_TestMail, 20);
		WaitUtil.waitAndClick(driver, successOkBtn, 20);
		Thread.sleep(2000);
	}

	/* @editTemplate written by Ganesh ***/
	public void editTemplate() throws InterruptedException {
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, Edittemplate, 20);
		driver.switchTo().frame(0);	
		//WaitUtil.dragAndDrop(driver, DragTextElement, DropTextBox, 20);
		Thread.sleep(10000);
		System.out.println("ch1");
		WaitUtil.waitAndClick(driver, DesignTemplatesPage.savebutton, 100);
		driver.switchTo().defaultContent();
		WaitUtil.waitAndClick(driver, DesignTemplatesPage.SaveAndClose, 20);
		Thread.sleep(1000);
	}
	
	/* @SearchTemplate written by Ganesh ***/
	public void SearchTemplate(String searchkeyword) throws InterruptedException {
		Thread.sleep(2000);
		WaitUtil.waitAndSendKeys(driver, searchbox, searchkeyword, 20);
		WaitUtil.waitAndClick(driver, searchSubmit, 20);
		Thread.sleep(3000);
	}
	
	/* @SpamCheck written by Ganesh ***/
	public void SpamCheck() throws InterruptedException {
		WaitUtil.waitAndClick(driver, emailspamscore,20);
		Thread.sleep(8000);
		WaitUtil.waitAndClick(driver, emailspamcheck, 20);
		Thread.sleep(8000);
		WaitUtil.waitAndClick(driver, emailspamclose, 20);
	}
	
	/* @SpamCheck written by Ganesh ***/
	public void pagination() throws InterruptedException {
		Thread.sleep(8000);
		WaitUtil.waitAndClick(driver, nextPage,20);
		Thread.sleep(8000);
		WaitUtil.waitAndClick(driver, lastPage,20);
		Thread.sleep(8000);
		WaitUtil.waitAndClick(driver, PreviousPage,20);
		Thread.sleep(8000);
		WaitUtil.waitAndClick(driver, firstPage,20);
	}
}
