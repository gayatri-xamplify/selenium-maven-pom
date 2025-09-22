package com.stratapps.xamplify.pages;

import java.awt.Desktop.Action;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.utils.ActionUtil;
import com.stratapps.xamplify.utils.DropdownUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class DesignPages {
	
	WebDriver driver;
	private WebDriverWait wait;
	long timestamp = System.currentTimeMillis();

	public DesignPages(WebDriver driver) {
	this.driver = driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	public static final By Designmodule = By.xpath("//i[@class='fa fa-paint-brush']");
	public static final By DesignPages = By.xpath("(//span[@class=\"design-name mDisableColor\"])[3]");
	public static final By Regular = By.xpath("(//li[@class=\"filter\"])[1]");
	public static final By Templatediv = By.xpath("(//div[@class=\"bar gridIconCustomization\"])[1]/..");
	public static final By creatediv = By.xpath("(//a[@class=\"Iconhover custom-grid-icon\"])[1]");
	public static final By Openlinkinnewtab = By.xpath("//input[@class=\"pointer checkBox_shadow\"]");
	public static final By savebutton = By.xpath("//span[contains(text(),'SAVE')]");
	public static final By EditSavebutton = By.xpath("//span[contains(text(),'SAVE')]/..");

	
	public static final By nameoftheregularpage = By.xpath("//*[@id=\"templateNameId\"]");
	public static final By sort = By.xpath("//select[@id=\"page-folder-dropdown\"]");
	public static final By saveandclose = By.xpath("//input[@value=\"Save & Close\"]");
	public static final By pagetypedropdown = By.xpath("//select[@id=\"pageType\"]");
	public static final By cobrandedtab = By.xpath("(//li[@class=\"filter\"])[2]");
	public static final By ManagePages = By.xpath("(//span[@class=\"design-name\"])[3]");
	public static final By regularpublictab = By.xpath("(//li[@class=\"filter\"])[1]");
	public static final By copypage = By.xpath("(//i[@class=\"fa fa-files-o IconCustomization\"])[1]");
	public static final By copiedname = By.xpath("//input[@name=\"copiedName\"]");
	public static final By savingcopiedregpublicpage = By.xpath("(//span[@class=\"btn btn-primary transition txt_pd-top3\"])[2]");
	public static final By okbutton1 = By.xpath("//button[@class=\"swal2-confirm styled\"]");
	public static final By Editregpublicpage = By.xpath("(//i[@class=\"fa fa-pencil-square-o mDisableColor IconCustomization\"])[1]");
	public static final By editupdateandclose = By.xpath("//input[@value=\"Update & Close\"]");
	public static final By previewtheregpublicpage = By.xpath("(//i[@class=\"fa fa-eye IconCustomization\"])[1]");
	public static final By AddDesign = By.xpath("//app-leftsidebar//a[@href=\"/home/design/add\"]");

	public static final By demoLandingPage = By.xpath("//h4[text()=\"Demo Landing Page \"]");
	public static final By Test_paGE_1032_from_adm = By.xpath("//h4[text()=\"Test_paGE_1032_from_adm \"]");
	public static final By tabAll = By.xpath("//ul[@class=\"mix-filter\"]/li[1]");
	public static final By tabRegularPublic = By.xpath("//ul[@class=\"mix-filter\"]/li[2]");
	public static final By tabRegularPrivate = By.xpath("//ul[@class=\"mix-filter\"]/li[3]");
	public static final By tabCoBrandedPublic = By.xpath("//ul[@class=\"mix-filter\"]/li[4]");
	public static final By tabCoBrandedPrivate = By.xpath("//ul[@class=\"mix-filter\"]/li[5]");
	public static final By DeletePage = By.xpath("//tr[2]//a[@title=\"Delete\"]");
	public static final By yesDelete = By.xpath("//button[text()=\"Yes, delete it!\"]");
	public static final By CopyOrEmbed = By.xpath("//tr[1]/td//div//i[@class=\"fa fa-clipboard IconCustomization\"]/..");
	public static final By embedButton = By.xpath("//div[@id=\"landing-page-url-modal\"]//span[contains(text(), \"Copy Embed\")]");
	public static final By copylinkButton = By.xpath("//label[contains(text(), \"Copy Link\")]/..//span[contains(text(), \"Copy\")]");
	public static final By closeCopyOrEmbedPopup = By.xpath("//a[@id=\"right\"][text()=\"Close\"]");
	public static final By analyticsCount = By.xpath("//tr[1]//span[@id=\"notification-list\"]");
	public static final By pageAnalytics = By.xpath("//tr[1]//a[@title=\"Analytics\"]");
	public static final By managePageBreadcrumb = By.xpath("//ul[@class=\"page-breadcrumb\"]//a[text()=\"Manage Pages\"]");
	public static final By viewType = By.xpath("//button[@class=\"fa fa-th-large btn btn-xs l-g-view\"]");
	public static final By gridView = By.xpath("//span[@data-original-title=\"Grid View\"]");

	public static final By sortPages = By.xpath("//select[@id=\"select-dropdown\"][@class=\"form-control SeclectBoxPaddingsAbj ng-pristine ng-valid ng-touched\"]");
	public static final By pageSearch = By.xpath("//input[@placeholder=\"Search for a page\"]");
	public static final By searchSubmit = By.xpath("//input[@placeholder=\"Search for a page\"]/../button");

	
	
    public void designDesignPage() throws InterruptedException {
    	Thread.sleep(3000);
        WaitUtil.waitAndClick(driver, Designmodule, 20);
        WaitUtil.waitAndClick(driver, DesignPages, 20);
    }

    public void RegularTab() {
        WaitUtil.waitAndClick(driver, Regular, 20);
    }

    public void createPage() throws InterruptedException {
        //WebElement hoveringregularpage = WaitUtil.waitForElementVisible(driver, Templatediv, 20);
        //action.moveToElement(hoveringregularpage).perform();
    	Thread.sleep(3000);
        ActionUtil.hover(driver, Templatediv);
        WaitUtil.waitAndClick(driver, creatediv, 20);
        //ActionUtil.hoverAndClick(driver, creatediv);
    	Thread.sleep(3000);
    	//WaitUtil.waitAndClick(driver, creatediv, 20);
        WaitUtil.waitAndClick(driver, Openlinkinnewtab, 20);
        driver.switchTo().frame(0);
        Thread.sleep(2000);
        WaitUtil.waitAndClick(driver, savebutton, 20);
        driver.switchTo().defaultContent();
    }

    public void regularPrivatePageSaveandClose() {
        WaitUtil.waitAndSendKeys(driver, nameoftheregularpage, "Regularprivatepage"+timestamp, 20);
        WaitUtil.waitAndClick(driver, saveandclose, 20);
    }

    public void regularpublicPageSaveandClose() {
        WaitUtil.waitAndSendKeys(driver, nameoftheregularpage, "Regularpublicpage"+timestamp, 20);
        DropdownUtil.selectByIndex(driver, pagetypedropdown, 1);
        WaitUtil.waitAndClick(driver, saveandclose, 20);
    }

    public void cobrandedTab() {
        WaitUtil.waitAndClick(driver, cobrandedtab, 20);
    }

    public void cobrandedprivatepagecreation() {
        WaitUtil.waitAndSendKeys(driver, nameoftheregularpage, "cobrandedprivatepage"+timestamp, 20);
        WaitUtil.waitAndClick(driver, saveandclose, 20);
    }

    public  void cobrandedpublicpagecreation() {
        WaitUtil.waitAndSendKeys(driver, nameoftheregularpage, "cobrandedpublicpage"+timestamp, 20);
        DropdownUtil.selectByIndex(driver, pagetypedropdown, 1);
        WaitUtil.waitAndClick(driver, saveandclose, 20);
    }

    public void designManagePage() {
        WaitUtil.waitAndClick(driver, Designmodule, 20);
        WaitUtil.waitAndClick(driver, ManagePages, 20);
    }
    
    public void PageTab(String selectTab) {
        if (selectTab.equals("RegularPublic")) {
            WaitUtil.waitAndClick(driver, tabRegularPublic, 20);
        } else if (selectTab.equals("RegularPrivate")) {
            WaitUtil.waitAndClick(driver, tabRegularPrivate, 20);
        } else if (selectTab.equals("CoBrandedPublic")) {
            WaitUtil.waitAndClick(driver, tabCoBrandedPublic, 20);
        } else if (selectTab.equals("CoBrandedPrivate")) {
            WaitUtil.waitAndClick(driver, tabCoBrandedPrivate, 20);
        } else if (selectTab.equals("All")) {
            WaitUtil.waitAndClick(driver, tabAll, 20);
        }
    }

    public void copyPage() {
        WaitUtil.waitAndClick(driver, copypage, 20);
        WaitUtil.waitAndClick(driver, savingcopiedregpublicpage, 20);
        WaitUtil.waitAndClick(driver, okbutton1, 20);
    }

    public void editpage() throws InterruptedException {
        WaitUtil.waitAndClick(driver, Editregpublicpage, 20);
        driver.switchTo().frame(0);
        Thread.sleep(4000);
        WaitUtil.waitAndClick(driver, EditSavebutton, 20);
        driver.switchTo().defaultContent();
        WaitUtil.waitAndClick(driver, editupdateandclose, 20);
    }

    public void PreviewPage() {
        WaitUtil.waitAndClick(driver, previewtheregpublicpage, 20);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public void DeletePage() {
        WaitUtil.waitAndClick(driver, DeletePage, 20);
        WaitUtil.waitAndClick(driver, yesDelete, 20);
    }
    
	String parentWindow = driver.getWindowHandle();
    public void openPageWithUrl() throws UnsupportedFlavorException, IOException {
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    Transferable contents = clipboard.getContents(null);
	    String copiedUrl = (String) contents.getTransferData(DataFlavor.stringFlavor);
		
	    ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
	    for (String windowHandle : driver.getWindowHandles()) {
	        if (!windowHandle.equals(parentWindow)) {
	            driver.switchTo().window(windowHandle);
	            break;
	        }        
	    }
	    // Step: Paste copied URL (Ctrl+V) and hit Enter
	    driver.get(copiedUrl);
    }

    public  void CopyAndEmbeddedPage() throws UnsupportedFlavorException, IOException, InterruptedException {
        WaitUtil.waitAndClick(driver, CopyOrEmbed, 20);
        WaitUtil.waitAndClick(driver, embedButton, 20);
        WaitUtil.waitAndClick(driver, copylinkButton, 20);
        openPageWithUrl();
	    Thread.sleep(3000);
        driver.close();
	    driver.switchTo().window(parentWindow);
        WaitUtil.waitAndClick(driver, closeCopyOrEmbedPopup, 20);
    }

    public void PageAnalytics() {
        WaitUtil.waitAndClick(driver, searchSubmit, 20);
        String getAnlaytics = driver.findElement(pageAnalytics).getText();
        if (!getAnlaytics.equals("0")) {
            WaitUtil.waitAndClick(driver, pageAnalytics, 20);
            WaitUtil.waitAndClick(driver, managePageBreadcrumb, 20);
        }
    }

    public void openNewWindow(WebDriver driver, String url) {
        ((JavascriptExecutor) driver).executeScript("window.open('" + url + "','_blank');");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public void sortAndNoOfRecordPage() {
        designManagePage();
        for (int i = 1; i <= 5; i++) {
            DropdownUtil.selectByIndex(driver, sortPages, i);
        }
    }

    public void searchPage() {
        WaitUtil.waitAndSendKeys(driver, pageSearch, "page", 20);
        WaitUtil.waitAndClick(driver, searchSubmit, 20);
    }

    public void PageView() {
    	ActionUtil.hover(driver, viewType);
       // WaitUtil.hoverAndClick(driver, viewType, gridView, 20);
        WaitUtil.waitAndClick(driver, gridView, 20);
    }
	
	
}
