package com.stratapps.xamplify.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.utils.ActionUtil;
import com.stratapps.xamplify.utils.ConfigReader;
import com.stratapps.xamplify.utils.DropdownUtil;
import com.stratapps.xamplify.utils.ScreenshotUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class ManageFormsPage {
	WebDriver driver;
	private WebDriverWait wait;
	long timestamp = System.currentTimeMillis();
	String FormType = DesignFormPage.FormType;


	public ManageFormsPage(WebDriver driver) {
	this.driver = driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	public static final By allCheckbox = By.xpath("//input[@type='checkbox'][@class='ng-untouched ng-pristine ng-valid']");
	public static final By surveyForm = By.xpath("(//li[@class=\"filter\"])[3]");
	public static final By Hoveringsurveyform = By.xpath("(//div[@class=\"bar gridIconCustomization\"])[1]");
	public static final By clickoncreatingsurveyform = By.xpath("(//a[@class=\"Iconhover custom-grid-icon\"])[1]");
	public static final By surveyformname = By.xpath("//input[@id=\"formName\"]");
	public static final By surveyformcontinue = By.xpath("//span[@class=\"btn  Btn-Green transition\"]");
	public static final By savingsurveyform = By.xpath("(//button[@type=\"submit\"])[3]");
	public static final By Manageforms = By.xpath("(//span[@class=\"design-name\"])[2]");
	public static final By EditRegularForm = By.xpath("(//a[@class='mMobileDisable custom-icon' or @class='mMobileDisable Iconhover custom-grid-icon'])[1]");
	public static final By AddFields = By.xpath("(//button[@class=\"button_blue bgcolor-unset\"])[1]");
	public static final By singlelinetext = By.xpath("(//div[@class=\"btn-group-form\"]/button[1])[1]");
	public static final By closeregaddfields = By.xpath("(//button[@class=\"close-circle\"])[5]");
	public static final By Designbutton = By.xpath("//div[@class=\"design-btn-group\"]");
	public static final By inputurl = By.xpath("//input[@placeholder=\"Enter Url\"]");
	public static final By checkbox = By.xpath("(//input[@type=\"checkbox\"])[1]");
	public static final By submitaddedfields = By.xpath("(//button[@type=\"submit\"])[9]");
	public static final By submittoupdateregform = By.xpath("(//button[@type=\"submit\"])[3]");
	public static final By saveasregform = By.xpath("(//button[@type=\"submit\"])[4]");
	public static final By renameicon = By.xpath("(//a[@data-toggle=\"tooltip\"])[1]");
	public static final By regformfilter = By.xpath("(//li[@class=\"filter\"])[1]");
	public static final By Copyform = By.xpath("(//a[@class='custom-icon' or @class=\"Iconhover custom-grid-icon\"])[1]");
	public static final By copyasregform = By.xpath("//a[@class=\"custom-icon\"][1]");
	public static final By copiedsave = By.xpath("//span[@class=\"btn btn-primary transition\"]");
	public static final By okbuttonreg = By.xpath("//button[@class=\"swal2-confirm styled\"]");
	public static final By previewregform = By.xpath("(//i[@class='fa fa-eye IconCustomization' or @class=\"fa fa-eye\"])[1]");
	public static final By closepreviewregform = By.xpath("(//a[@class=\"btn Btn-Gray\"])[2]");
	public static final By Embed = By.xpath("(//a[@class=\"custom-icon\"])[3]");
	public static final By Embedclose = By.xpath("//a[@id=\"right\"]");
	public static final By Deleteregform = By.xpath("(//a[@id='template-delete' or @class=\"delete custom-icon\"])[1]/i");
	public static final By yesdelete = By.xpath("//button[@class=\"swal2-confirm styled\"]");
	public static final By quizfilter = By.xpath("(//li[@class=\"filter\"])[2]");
	public static final By gridviewclick = By.xpath("//i[@class=\"fa fa-th-large p10\"]");
	public static final By gridview1 = By.xpath("(//div[@class=\"bar gridIconCustomization auto-height icons_align\"])[1]");
	public static final By gridviewpreview = By.xpath("(//a[@class=\"Iconhover custom-grid-icon\"])[2]");
	public static final By gridviewpreviewclose = By.xpath("//a[@id=\"bottom-right\"]");
	public static final By gridviewcopyquizgorm = By.xpath("(//i[@class=\"fa fa-files-o\"])[1]");
	public static final By savechanges = By.xpath("//span[@class='btn btn-primary transition']");
	public static final By copyokform = By.xpath("//button[@class=\"swal2-confirm styled\"]");
	public static final By embedgridviewquiz = By.xpath("(//i[@class=\"fa fa-clipboard\"])[1]");
	public static final By closeembedgridview = By.xpath("//a[@class=\"btn Btn-Gray\"])[1]");
	public static final By Editgridviewquiz = By.xpath("(//i[@class=\"fa fa-pencil-square-o mDisableColor\"])[1]");
	public static final By Addfieldsforquiz = By.xpath("(//button[@class=\"button_blue bgcolor-unset\"])[1]");
	public static final By closeforaddfields = By.xpath("(//button/i[@class=\"fa fa-times\"])[5]");
	public static final By updatequizform = By.xpath("(//span[@class=\"btn Btn-Green transition txt_pd-top3\"])[2]");
	public static final By Renamingquizformicon = By.xpath("//a[@class=\"icon-margin\"]");
	public static final By Renamequizform = By.xpath("//input[@id=\"formName\"]");
	public static final By continueafterrename = By.xpath("//span[@class=\"btn  Btn-Green transition\"]");
	public static final By continuetosaveasquiz = By.xpath("(//button[@class=\"button bgcolor-unset\"])[2]");
	public static final By gridviewmanageforms1 = By.xpath("//button[@class=\"fa fa-th-list btn-xs l-g-view\"]");
	public static final By deletequizform = By.xpath("(//a[@class=\"delete custom-icon\"])[1]");
	public static final By deleteokgridviewquizform = By.xpath("//button[@class=\"swal2-confirm styled\"]");
	public static final By FolderGridviewforsurvey = By.xpath("//button[@class=\"fa fa-th-list btn-xs l-g-view\"]");
	public static final By FolderGridview1 = By.xpath("//i[@class=\"fa fa-folder p10\"]");
	public static final By FolderGridbar = By.xpath("//div[@class=\"bar barview full-width-folder gridIconCustomization\"]");
	public static final By FolderGridviewicon = By.xpath("//i[@class=\"fa fa-eye pos_pd_top6\"]");
	public static final By surveyformMange = By.xpath("(//li[@class=\"filter\"])[3]");
	public static final By copyassurveyform = By.xpath("(//i[@class=\"fa fa-files-o IconCustomization\"])[1]");
	public static final By previewsurveyform = By.xpath("(//i[@class=\"fa fa-eye IconCustomization\"])[1]");
	public static final By previewclosesurveyform = By.xpath("(//a[@class=\"btn Btn-Gray\"])[2]");
	public static final By copyembedsurvey = By.xpath("(//i[@class=\"fa fa-clipboard IconCustomization\"])[1]");
	public static final By Embedclosesurveyform = By.xpath("(//button[@class=\"close-circle\"])[1]");
	public static final By editiconforsurveyform = By.xpath("(//a[@class=\"mMobileDisable custom-icon\"])[1]");
	public static final By Addfieldsbuttonforsurvey = By.xpath("(//button[@class=\"button_blue bgcolor-unset\"])[1]");
	public static final By closeaddfieldsforsurvey = By.xpath("(//button[@class=\"close-circle\"])[5]");
	public static final By updatesurveform = By.xpath("(//button[@type=\"submit\"])[3]");
	public static final By renameforsurveyform = By.xpath("//input[@id=\"formName\"]");
	public static final By continuetoupdate = By.xpath("//span[@class=\"btn  Btn-Green transition\"]");
	public static final By renamingicon = By.xpath("//i[@class=\"fa fa-pencil-square-o\"]");
	public static final By saveasforsurveyform = By.xpath("(//span[@class=\"btn Btn-Green transition txt_pd-top3\"])[3]");
	public static final By Deletethesyrveform = By.xpath("(//i[@class=\"fa fa-trash-o trashIconCustomization\"])[1]");
	public static final By yesdeletethesurvey = By.xpath("//button[@class=\"swal2-confirm styled\"]");
	public static final By searchbar = By.xpath("//input[@placeholder=\"search...\"]");
	public static final By searchsubmit = By.xpath("(//button[@type=\"submit\"])[2]");
	public static final By sort = By.xpath("//select[@class='form-control ng-valid ng-touched ng-dirty']");
	public static final By searchbarclose = By.xpath("//button[@class=\"glyphicon glyphicon-remove search-box-item-clear\"]");
	public static final By pagenation_last = By.xpath("//i[@class=\"fa fa-angle-double-right\"]");
	public static final By pagenation_first = By.xpath("//i[@class=\"fa fa-angle-double-left\"]");
	public static final By Designmodule = By.xpath("//i[@class='fa fa-paint-brush']");
	public static final By RegularForm = By.xpath("(//li[@class=\"filter\"])[1]");
	public static final By quizForm = By.xpath("(//li[@class=\"filter\"])[2]");
	public static final By CopyFormpageurl = By.xpath("//span[text()= 'Copy Link']");
	public static final By CopyandEmbedFormpageurl = By.xpath("(//i[@class='fa fa-clipboard IconCustomization' or @class=\"fa fa-clipboard\"])[1]");
	
	public static final By FormUrlEmail = By.xpath("//input[@id='email']");
	public static final By FormUrlFirstName = By.xpath("//input[@id='first_name']");
	public static final By FormUrlLastName = By.xpath("//input[@id='last_name']");
	public static final By FormUrlMobileNumber = By.xpath("//input[@id='mobile_number']");
	public static final By FormUrlSubmit = By.xpath("//button[@id='bottom-right']");
	public static final By SunlifeRadiobutton = By.xpath("(//input[@name='which_of_the_following_launches_jeevan_utkarsh'])[1]");

	public static final By FormUrlName = By.xpath("//input[@id='name_of_product_or_service:']");
	public static final By productYes = By.xpath("(//input[@name='did_our_product_or_service_meet_your_expectations?'])[1]");
	public static final By SurveyFormSelectdate = By.xpath("//input[@id='flat-picker']");
	public static final By todaydatepick = By.xpath("//span[@class='flatpickr-day today']");
	public static final By satisfiedNetural = By.xpath("(//input[@class='form-check-input'])[5]");
	public static final By ManageFormRefresh = By.xpath("//a[@class='close-circle xamp-margin-left-icon not_light']");
	public static final By FormAnalytics = By.xpath("(//a[@class='custom-icon  mrgt-unset' or @data-original-title=\"Form Analytics\"])[1]");
	public static final By FormAnalyticsrefresh = By.xpath("(//a[@class='close-circle ml7'])[2]");
	public static final By SurveyFormAnalyticsrefresh = By.xpath("//a[@class=\"close-circle mr5\"]");
	
	public static final By FormAnalyticsSearch = By.xpath("//input[@id=\"search-text\"]");
	public static final By FormAnalyticsSearchsubmit = By.xpath("//button[@type=\"submit\"][@class=\"search-box-item-click only_content\"]");
	public static final By FormAnalyticsdownload = By.xpath("//a[@title='Download']");
	public static final By FormAnalyticsExtandandMinimize = By.xpath("(//a[@class=\"close-circle\"])[2]");
	public static final By FormAnalyticsexist = By.xpath("//a[@href='/home/forms/manage']");
	public static final By HoverOnView = By.xpath("//button[@class='fa fa-th-list btn-xs l-g-view']");
	public static final By gridviewmanageforms = By.xpath("(//span[@class=\"btn btn-xs l-g-view margin-space\"])[1]");
	public static final By HoverOnForm = By.xpath("(//div[@class=\"grid-box gridCardBoxHeight\"])[1]");

	//-------------------------------------------
	
	/*@Design_ClickDesignForm written by Ganesh ***/
	public void Design_ClickManageForm() throws InterruptedException {
		WaitUtil.waitAndClick(driver, Designmodule, 20);
		WaitUtil.waitAndClick(driver, Manageforms, 20);
		Thread.sleep(4000);
	} 
	
	/*@CopyForm written by Ganesh ***/
	public void CopyForm() throws InterruptedException {	
		WaitUtil.waitAndClick(driver, Copyform, 20);
		driver.findElement(DesignFormPage.Regularformname).clear();
		WaitUtil.waitAndSendKeys(driver, DesignFormPage.Regularformname, DesignFormPage.FormType + System.currentTimeMillis()+"(Copy)", 20);
		WaitUtil.waitAndSendKeys(driver, DesignFormPage.formDescription, "Copy Form Desc", 20);
		Thread.sleep(3000);
		WaitUtil.waitAndClick(driver, savechanges, 20);
		WaitUtil.waitAndClick(driver, copyokform, 20);
		Thread.sleep(2000);
	}
	 
	/*@SelectViewToGrid written by Ganesh ***/
	public void SelectViewToGrid() throws InterruptedException {
	    ActionUtil.hover(driver, HoverOnView);
	    ActionUtil.hoverAndClick(driver, gridviewmanageforms);
	    Thread.sleep(2000);
	}
	
	/*@HoveronFirstForm written by Ganesh ***/
	public void HoveronFirstForm() throws InterruptedException {
	    ActionUtil.hover(driver, HoverOnForm);
	    Thread.sleep(1000);
	}
	
	/*@EditForm written by Ganesh ***/
	public void EditForm() throws InterruptedException {
		WaitUtil.waitAndClick(driver, EditRegularForm, 20);
		WaitUtil.waitAndClick(driver, DesignFormPage.editFormTitle, 20);
		WaitUtil.waitAndSendKeys(driver, DesignFormPage.Regularformname, FormType + System.currentTimeMillis(), 10);
		WaitUtil.waitAndSendKeys(driver, DesignFormPage.formDescription, "Form Desc", 20);
		WaitUtil.waitAndClick(driver, DesignFormPage.Regularformcontinue, 10);
		
		WaitUtil.waitAndClick(driver, DesignFormPage.formPreview, 20);
		WaitUtil.waitAndClick(driver, DesignFormPage.closePreview, 20);
	
		WaitUtil.waitAndClick(driver, DesignFormPage.FullScreen, 20);
		WaitUtil.waitAndClick(driver, DesignFormPage.savingregularform, 10);
		Thread.sleep(3000);
		ScreenshotUtil.captureScreenshot(driver, "CreateForm");
		}
	
	/*@PreviewForm written by Ganesh ***/
	public void PreviewForm() throws InterruptedException {
		WaitUtil.waitAndClick(driver, previewregform, 20);
		WaitUtil.waitAndClick(driver, closepreviewregform, 20);
	}

	/*@DeleteForm written by Ganesh ***/
	public void DeleteForm() throws InterruptedException {
		WaitUtil.waitAndClick(driver, Deleteregform, 20);
		WaitUtil.waitAndClick(driver, yesdelete, 20);
	}
	
	/*@FillRegularFormAndSubmit written by Ganesh ***/
	public void FillRegularFormAndSubmit() throws InterruptedException {
		WaitUtil.waitAndSendKeys(driver, FormUrlEmail, "Form"+timestamp+"@gmail.com", 20);
		WaitUtil.waitAndSendKeys(driver, FormUrlFirstName, "First name", 20);
		WaitUtil.waitAndSendKeys(driver, FormUrlLastName, "Last name", 20);
		WaitUtil.waitAndSendKeys(driver, FormUrlMobileNumber, "9999999999", 20);
		WaitUtil.waitAndClick(driver, FormUrlSubmit, 20);
	}
	
	/*@FillQuizFormAndSubmit written by Ganesh ***/
	public void FillQuizFormAndSubmit() throws InterruptedException {
		WaitUtil.waitAndSendKeys(driver, FormUrlEmail, "Form"+timestamp+"@gmail.com", 20);
		//WaitUtil.waitAndSendKeys(driver, FormUrlFirstName, "First name", 20);
		//WaitUtil.waitAndSendKeys(driver, FormUrlLastName, "Last name", 20);
		WaitUtil.waitAndSendKeys(driver, FormUrlMobileNumber, "8888888888", 20);
		WaitUtil.waitAndClick(driver, SunlifeRadiobutton, 20);
		WaitUtil.waitAndClick(driver, FormUrlSubmit, 20);
	}
	
	/*@FillSurveyFormAndSubmit written by Ganesh ***/
	public void FillSurveyFormAndSubmit() throws InterruptedException {
		WaitUtil.waitAndSendKeys(driver, FormUrlName, "SurveyForm"+timestamp, 20);
		WaitUtil.waitAndClick(driver, SurveyFormSelectdate, 20);
		WaitUtil.waitAndClick(driver, todaydatepick, 20);
		WaitUtil.waitAndClick(driver, productYes, 20);
		WaitUtil.waitAndClick(driver, satisfiedNetural, 20);
		WaitUtil.waitAndClick(driver, FormUrlSubmit, 20);
	}
	
	/*@Design_ClickDesignForm written by Ganesh ***/
	public void CopyFormURL() throws InterruptedException, UnsupportedFlavorException, IOException {
		WaitUtil.waitAndClick(driver, CopyandEmbedFormpageurl, 20);
		WaitUtil.waitAndClick(driver, CopyFormpageurl, 20);
	    Actions actions = new Actions(driver);

	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    Transferable contents = clipboard.getContents(null);
	    String copiedUrl = (String) contents.getTransferData(DataFlavor.stringFlavor);
		
		String parentWindow = driver.getWindowHandle();
	    ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
	    for (String windowHandle : driver.getWindowHandles()) {
	        if (!windowHandle.equals(parentWindow)) {
	            driver.switchTo().window(windowHandle);
	            break;
	        }
	    }
	    // Step: Paste copied URL (Ctrl+V) and hit Enter
	    driver.get(copiedUrl);
	    System.out.println(DesignFormPage.FormType);
	    if(DesignFormPage.FormType == "REGULAR") {
	    FillRegularFormAndSubmit();
	    }
	    else if(DesignFormPage.FormType == "QUIZ") {
	    FillQuizFormAndSubmit();
	    }
	    else if(DesignFormPage.FormType == "SURVEY") {
	    	FillSurveyFormAndSubmit();
	    }
	    
	    Thread.sleep(3000); 
	    driver.close();
	    driver.switchTo().window(parentWindow);
		WaitUtil.waitAndClick(driver, Embedclose, 20);
		WaitUtil.waitAndClick(driver, ManageFormRefresh, 20);
	}

	/*@SurveyFormAnalytics written by Ganesh ***/
	public void SurveyFormAnalytics() throws InterruptedException {
		WaitUtil.waitAndClick(driver, FormAnalytics, 20);
		WaitUtil.waitAndClick(driver, SurveyFormAnalyticsrefresh, 20);
		WaitUtil.waitAndClick(driver, FormAnalyticsdownload, 20);
		WaitUtil.waitAndClick(driver, FormAnalyticsexist, 20);		
	}
	
	/*@QuizFormAnalytics written by Ganesh ***/
	public void QuizFormAnalytics() throws InterruptedException {
		WaitUtil.waitAndClick(driver, FormAnalytics, 20);
		WaitUtil.waitAndClick(driver, FormAnalyticsrefresh, 20);
		WaitUtil.waitAndSendKeys(driver, FormAnalyticsSearch, "form", 20);
		WaitUtil.waitAndClick(driver, FormAnalyticsSearchsubmit, 20);
		WaitUtil.waitAndClick(driver, FormAnalyticsdownload, 20);
		WaitUtil.waitAndClick(driver, FormAnalyticsexist, 20);		
	}
	
	/*@RegularFormAnalytics written by Ganesh ***/
	public void RegularFormAnalytics() throws InterruptedException {
		WaitUtil.waitAndClick(driver, FormAnalytics, 20);
		WaitUtil.waitAndClick(driver, FormAnalyticsrefresh, 20);
		WaitUtil.waitAndSendKeys(driver, FormAnalyticsSearch, "form", 20);
		WaitUtil.waitAndClick(driver, FormAnalyticsSearchsubmit, 20);
		WaitUtil.waitAndClick(driver, FormAnalyticsdownload, 20);
		WaitUtil.waitAndClick(driver, FormAnalyticsExtandandMinimize, 20);
		WaitUtil.waitAndClick(driver, FormAnalyticsExtandandMinimize, 20);
		WaitUtil.waitAndClick(driver, FormAnalyticsexist, 20);		
	}
	
	/*@DeleteForm written by Ganesh ***/
	public void SearchForm() throws InterruptedException {
		WaitUtil.waitAndSendKeys(driver, searchbar, "form", 20);
		WaitUtil.waitAndClick(driver, searchsubmit, 20);
		WaitUtil.waitAndClick(driver, searchbarclose, 20);
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, pagenation_last, 20);
		WaitUtil.waitAndClick(driver, pagenation_first, 20);
		
	}
}
	
