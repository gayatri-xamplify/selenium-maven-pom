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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.utils.ActionUtil;
import com.stratapps.xamplify.utils.DropdownUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class DesignTemplatesPage {
	WebDriver driver;
	private WebDriverWait wait;
	long timestamp = System.currentTimeMillis();

	public DesignTemplatesPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	public static final By Designmodule = By.xpath("//a/i[@class='fa fa-paint-brush']");
	public static final By DesignTemplates = By.xpath("(//span[@class='design-name mDisableColor'])[1]");
	public static final By SelectingemailTemplate = By.xpath("(//li[@class='filter'])[1]");
	public static final By searchtemplate = By.xpath("//input[@placeholder='Search for a template']");
	public static final By searchbutton = By.xpath("(//button[@type='submit'])[1]");
	public static final By Templatediv = By.xpath("(//div[@class='bar gridIconCustomization'])[1]/..");
	public static final By creatediv = By.xpath("//div[@class='bar gridIconCustomization'][1]");
	public static final By savebutton = By.xpath("//span[contains(text(),'SAVE')]/..");
	public static final By Templatename = By.xpath("//input[@name='templateName']");

	public static final By SaveAndClose = By.xpath("//span[contains(text(),'Save & Close')]/..");
	public static final By SurveyForm = By.xpath("//Span[text()='Show Surveys']");
	public static final By SurveyFormsort = By.xpath("(//select[@class=\"form-control ng-untouched ng-pristine ng-valid\"])[1]");
	public static final By SurveyFormSearch = By.xpath("//input[@id='search-text']");
	public static final By SurveyFormSearchbutton = By.xpath("(//button[@type='submit'])[2]");
	public static final By SurveyFormPreview = By.xpath("(//i[@class='fa fa-eye IconCustomization campaignViewIcon'])[1]");
	public static final By SurveyFormPreviewClose = By.xpath("(//span[text()='Close'])[1]/..");
	public static final By SurveyFormLinkCopy = By.xpath("//span[@id='custom-margin-0']/a/i");
	public static final By DraganddropButton = By.xpath("(//div[@class=\"image-drag SidebarModule_imageDrag__-XEVH\"])[3]");
	public static final By DraganddropButton1 = By.xpath("//div[@class=\"sidebar-draggable--cs SidebarDraggable_sidebarDraggable__Nf2rL sidebar-draggable-button--cs\"]");
	public static final By DropElement = By.xpath("(//div[@class=\"txtTinyMce-wrapper\"])[1]");
	public static final By surveybutton = By.xpath("//div[@class=\"buttonwrapper editor-wrapper buttonmodule__wrapper buttonwrapper_item_5a846028-314d-47ca-8037-1888680f4913_c027130d-560d-4e56-96dd-0184da6846ca_be29e559-13cc-4260-98ac-b90aee21f836 item_5a846028-314d-47ca-8037-1888680f4913_c027130d-560d-4e56-96dd-0184da6846ca_be29e559-13cc-4260-98ac-b90aee21f836 module--selected\"]");
	public static final By Pastesurveyformurl = By.xpath("(//p[text()='Button'])[1]");
	public static final By surveyformpreviewX = By.xpath("//div[@id=\"form-background-image\"]/..//button[@class=\"close-circle\"]");
	public static final By fwq = By.xpath("");
	public static final By f32 = By.xpath("");

	
	// -------------------------------------------------------------------------------------------------------------

	/* @designDesignPage written by Ganesh ***/
	public void designDesignTemplate() throws InterruptedException {
		Thread.sleep(3000);
		WaitUtil.waitAndClick(driver, Designmodule, 20);
		WaitUtil.waitAndClick(driver, DesignTemplates, 20);
	}
  
	/* @selectTemplateTab written by Ganesh ***/
	public void selectTemplateTab(String TabName) {
	    By filterOption = By.xpath("//ul[contains(@class,'mix-filter')]//li[normalize-space(text())='" + TabName + "']");
	    WaitUtil.waitAndClick(driver, filterOption, 20);
	    System.out.println("Selected design Template Tab : " + TabName);
	} 

	/* @createTemplate written by Ganesh ***/
	public void createTemplate(String TemplateType) throws InterruptedException, UnsupportedFlavorException, IOException {		
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 200);");
		Thread.sleep(1000);
		ActionUtil.hover(driver, Templatediv);
		WaitUtil.waitAndClick(driver, creatediv, 20);
		Thread.sleep(10000);
		if(TemplateType=="SurveyTemplate" || TemplateType=="Survey Co-Branding") {
			SurveyForm();
		}
		else {
			System.out.println("survey form not available for "+ TemplateType);
		}
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		String copiedUrl = (String) contents.getTransferData(DataFlavor.stringFlavor);
		System.out.println("Copy link is " + copiedUrl);
		driver.switchTo().frame(0);	
		WaitUtil.dragAndDrop(driver, DraganddropButton, DropElement, 20);
		Thread.sleep(1000);
	//	WaitUtil.waitAndClick(driver, surveybutton, 20);
	//	WaitUtil.waitAndSendKeys(driver, Pastesurveyformurl, copiedUrl, 20);
		WaitUtil.waitAndClick(driver, savebutton, 20);
		driver.switchTo().defaultContent();
		WaitUtil.waitAndSendKeys(driver, Templatename, TemplateType + timestamp, 20);
		WaitUtil.waitAndClick(driver, SaveAndClose, 20);
		Thread.sleep(1000);

	}
	
	/* @SurveyForm written by Ganesh ***/
	public void SurveyForm() throws InterruptedException, UnsupportedFlavorException, IOException {	
		WaitUtil.waitAndClick(driver, SurveyForm, 20);
		Thread.sleep(3000);
//		DropdownUtil.selectByValue(driver, SurveyFormsort, "1");
//		DropdownUtil.selectByValue(driver, SurveyFormsort, "2");
		WaitUtil.waitAndSendKeys(driver, SurveyFormSearch, "Survey", 20);
//		WaitUtil.waitAndClick(driver, SurveyFormSearchbutton, 20);
		WaitUtil.waitAndClick(driver, SurveyFormPreview, 20);
		WaitUtil.waitAndClick(driver, surveyformpreviewX, 20);
		Thread.sleep(2000);
		WaitUtil.waitAndClick(driver, SurveyFormLinkCopy, 20);
		WaitUtil.waitAndClick(driver, SurveyFormPreviewClose, 20);

	}
	
	

}

