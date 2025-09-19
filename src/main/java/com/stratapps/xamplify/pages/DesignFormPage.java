package com.stratapps.xamplify.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.stratapps.xamplify.utils.ActionUtil;
import com.stratapps.xamplify.utils.ScreenshotUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class DesignFormPage {
	WebDriver driver;
	private WebDriverWait wait;
	long timestamp = System.currentTimeMillis();
	static String FormType;

	public DesignFormPage(WebDriver driver) {
	this.driver = driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	
	public static final By Designmodule = By.xpath("//i[@class='fa fa-paint-brush']");
	public static final By DesignForms = By.xpath("(//span[@class=\"design-name mDisableColor\"])[2]");
	public static final By RegularForm = By.xpath("(//li[@class=\"filter\"])[1]");
	public static final By Hoveringregularform = By.xpath("(//div[@class='img-responsive center-block fit-in-image'])[1]");
	public static final By clickoncreatingregularform = By.xpath("(//a[@class=\"Iconhover custom-grid-icon\"])[1]");
	public static final By Regularformname = By.xpath("//input[@id=\"formName\"]");
	public static final By Regularformcontinue = By.xpath("//span[@class=\"btn  Btn-Green transition\"]");
	public static final By savingregularform = By.xpath("(//button/span[@class=\"btn Btn-Green transition txt_pd-top3\"])[2]");
	public static final By quizForm = By.xpath("(//li[@class=\"filter\"])[2]");
	public static final By Hoveringquizform = By.xpath("(//div[@class=\"bar gridIconCustomization\"])[1]");
	public static final By clickoncreatingquizform = By.xpath("(//a[@class=\"Iconhover custom-grid-icon\"])[1]");
	public static final By quizformname = By.xpath("//input[@id=\"formName\"]");
	public static final By quizformcontinue = By.xpath("(//button[@type=\"submit\"])[5]");
	public static final By savingquizform = By.xpath("(//button/span[@class=\"btn Btn-Green transition txt_pd-top3\"])[2]");
	public static final By formDescription = By.xpath("//textarea[@id='description']");
	public static final By salesAccountGroupDropdown = By.xpath("(//a[@title='View/Hide Team Members'])[1]");
	public static final By editFormTitle = By.xpath("//a[@class='icon-margin']");
	public static final By formPreview = By.xpath("//a[@id='preview-form']");
	public static final By FullScreen = By.xpath("//a[@id='full-screen']");
	public static final By closePreview = By.xpath("//a[@id='bottom-right']");

	
	
	public static final By allCheckbox = By.xpath("//input[@type='checkbox'][@class='ng-untouched ng-pristine ng-valid']");
	public static final By surveyForm = By.xpath("(//li[@class=\"filter\"])[3]");
	public static final By Hoveringsurveyform = By.xpath("(//div[@class=\"bar gridIconCustomization\"])[1]");
	public static final By clickoncreatingsurveyform = By.xpath("(//a[@class=\"Iconhover custom-grid-icon\"])[1]");
	public static final By surveyformname = By.xpath("//input[@id=\"formName\"]");
	public static final By surveyformcontinue = By.xpath("//span[@class=\"btn  Btn-Green transition\"]");
	public static final By savingsurveyform = By.xpath("(//button[@type=\"submit\"])[3]");
	public static final By Manageforms = By.xpath("(//span[@class=\"design-name\"])[2]");
	public static final By EditRegularForm = By.xpath("(//a[@class=\"mMobileDisable custom-icon\"])[1]");
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
	public static final By copyasregform = By.xpath("//a[@class=\"custom-icon\"][1]");
	public static final By copiedsave = By.xpath("//span[@class=\"btn btn-primary transition\"]");
	public static final By okbuttonreg = By.xpath("//button[@class=\"swal2-confirm styled\"]");
	public static final By previewregform = By.xpath("(//i[@class=\"fa fa-eye IconCustomization\"])[1]");
	public static final By closepreviewregform = By.xpath("(//a[@class=\"btn Btn-Gray\"])[2]");
	public static final By Embed = By.xpath("(//a[@class=\"custom-icon\"])[3]");
	public static final By Embedclose = By.xpath("//a[@id=\"right\"]");
	public static final By Deleteregform = By.xpath("(//a[@id=\"template-delete\"])[1]");
	public static final By yesdelete = By.xpath("//button[@class=\"swal2-confirm styled\"]");
	public static final By gridviewmanageforms = By.xpath("//button[@class=\"fa fa-th-list btn-xs l-g-view\"]");
	public static final By quizfilter = By.xpath("(//li[@class=\"filter\"])[2]");
	public static final By gridviewclick = By.xpath("//i[@class=\"fa fa-th-large p10\"]");
	public static final By gridview1 = By.xpath("(//div[@class=\"bar gridIconCustomization auto-height icons_align\"])[1]");
	public static final By gridviewpreview = By.xpath("(//a[@class=\"Iconhover custom-grid-icon\"])[2]");
	public static final By gridviewpreviewclose = By.xpath("//a[@id=\"bottom-right\"]");
	public static final By gridviewcopyquizgorm = By.xpath("(//i[@class=\"fa fa-files-o\"])[1]");
	public static final By savechangesgridviewquizform = By.xpath("//span[@class=\"btn btn-primary transition\"]");
	public static final By copyokquizform = By.xpath("//button[@class=\"swal2-confirm styled\"]");
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
	public static final By sort = By.xpath("//select[@class=\"form-control ng-pristine ng-valid ng-touched\"]");
	public static final By searchbarclose = By.xpath("//button[@class=\"glyphicon glyphicon-remove search-box-item-clear\"]");
	public static final By pagenation_last = By.xpath("//i[@class=\"fa fa-angle-double-right\"]");
	public static final By pagenation_first = By.xpath("//i[@class=\"fa fa-angle-double-left\"]");


	//=======================================================
	
	/*@Design_ClickDesignForm written by Ganesh ***/
	public void Design_ClickDesignForm() {
		WaitUtil.waitAndClick(driver, Designmodule, 10);
		WaitUtil.waitAndClick(driver, DesignForms, 10);
	} 
	 
	
	/*@SelectFormTab written by Ganesh ***/
	public  void SelectFormTab(String selectTab) throws InterruptedException {
		Thread.sleep(3000);
		if(selectTab == "REGULAR") {
			WaitUtil.waitAndClick(driver, RegularForm, 10);
		}
		else if(selectTab == "QUIZ") {
			WaitUtil.waitAndClick(driver, quizForm, 10);
		}
		else if(selectTab == "SURVEY") {
			WaitUtil.waitAndClick(driver, surveyForm, 10);
		}
		FormType = selectTab;
	}
	
	/*@SelectFormTab written by Ganesh ***/
	public void CreateForm() throws InterruptedException {

		Thread.sleep(4000);
		ActionUtil.hover(driver, Hoveringregularform);
		WaitUtil.waitAndClick(driver, clickoncreatingregularform, 10);
		Thread.sleep(3000);
		WaitUtil.waitAndSendKeys(driver, Regularformname, FormType + System.currentTimeMillis(), 10);
		WaitUtil.waitAndSendKeys(driver, formDescription, "Form Desc", 20);
		WaitUtil.waitAndClick(driver, salesAccountGroupDropdown, 20);
		WaitUtil.waitAndClick(driver, checkbox, 20);
		WaitUtil.waitAndClick(driver, Regularformcontinue, 10);
		WaitUtil.waitAndClick(driver, editFormTitle, 20);
		WaitUtil.waitAndSendKeys(driver, Regularformname, FormType + System.currentTimeMillis(), 10);
		WaitUtil.waitAndSendKeys(driver, formDescription, "Form Desc", 20);
		WaitUtil.waitAndClick(driver, Regularformcontinue, 10);
		
		WaitUtil.waitAndClick(driver, formPreview, 20);
		WaitUtil.waitAndClick(driver, closePreview, 20);
	
		WaitUtil.waitAndClick(driver, FullScreen, 20);
		WaitUtil.waitAndClick(driver, savingregularform, 10);
		Thread.sleep(3000);
		ScreenshotUtil.captureScreenshot(driver, "CreateForm");
		
		Thread.sleep(9000);  
	}	
	
}
