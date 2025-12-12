
package com.stratapps.xamplify.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.stratapps.xamplify.utils.WaitUtil;
import com.stratapps.xamplify.utils.DropdownUtil;

public class LaunchRedistributeEmailCampaignPage {

    private WebDriver driver;

    public LaunchRedistributeEmailCampaignPage(WebDriver driver) {
        this.driver = driver;
    }

    // =========================================================
    //                      LOCATORS
    // =========================================================
    private By nowOption = By.xpath("//span[contains(text(),'Now')]");
    private By launchButton = By.xpath("//button[contains(text(),'Launch')]");
    private By responseMsg = By.xpath("//span[@id='responseMessage']");
	private By backdrop = By.cssSelector("div.backdrop");
    private By Gotohome =By.xpath("//img[@class='cls-pointer']");

   

    // =========================================================
    //                 LAUNCH NOW
    // =========================================================

    public void launchNow() {
    	WaitUtil.waitForPageToLoad(driver, 30);
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0, 500);"); // scrolls 500px down
         WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);
    	WaitUtil.waitForElementVisible(driver, nowOption, 60);
        WaitUtil.waitAndClick(driver, nowOption, 60);
        WaitUtil.waitAndClick(driver, launchButton, 60);
    }

    // =========================================================
    //               VALIDATE LAUNCH RESPONSE
    // =========================================================

    public boolean validateLaunchMessage() {

        String actual = WaitUtil.waitForElementVisible(driver, responseMsg, 60).getText();

        String expected = "The campaign was successfully deployed. Please wait until the campaign is processed and launched. We will send you email updates in timely manner."
        		+ "";

        return actual.equals(expected);
    }


}
