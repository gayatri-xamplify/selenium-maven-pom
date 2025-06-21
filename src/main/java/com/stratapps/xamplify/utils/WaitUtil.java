package com.stratapps.xamplify.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {
	
	
	
	
	
	
	
	
    
    /**
     * Wait for element to be clickable
     * @param driver WebDriver instance
     * @param locator By locator
     * @param timeoutInSeconds timeout in seconds
     * @return WebElement that is clickable
     */
    public static WebElement waitForElementClickable(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    
   
    
    
    public static WebElement waitForVisibility(WebDriver driver, By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    
    public static void waitForInvisibilityOfElement(By locator, WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    
    /**
     * Wait for element to be visible
     * @param driver WebDriver instance
     * @param locator By locator
     * @param timeoutInSeconds timeout in seconds
     * @return WebElement that is visible
     */
    public static WebElement waitForElementVisible(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    /**
     * Wait for element to be present in DOM
     * @param driver WebDriver instance
     * @param locator By locator
     * @param timeoutInSeconds timeout in seconds
     * @return WebElement that is present
     */
    public static WebElement waitForElementPresent(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    /**
     * Wait for element to contain text
     * @param driver WebDriver instance
     * @param locator By locator
     * @param text text to wait for
     * @param timeoutInSeconds timeout in seconds
     * @return true if element contains text
     */
    public static boolean waitForTextPresent(WebDriver driver, By locator, String text, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
    
    /**
     * Wait for element to be clickable and then click it
     * @param driver WebDriver instance
     * @param locator By locator
     * @param timeoutInSeconds timeout in seconds
     */
    public static void waitAndClick(WebDriver driver, By locator, int timeoutInSeconds) {
        WebElement element = waitForElementClickable(driver, locator, timeoutInSeconds);
        element.click();
    }
    
    /**
     * Wait for element to be visible and then send keys to it
     * @param driver WebDriver instance
     * @param locator By locator
     * @param text text to send
     * @param timeoutInSeconds timeout in seconds
     */
    public static void waitAndSendKeys(WebDriver driver, By locator, String text, int timeoutInSeconds) {
        WebElement element = waitForElementVisible(driver, locator, timeoutInSeconds);
        element.clear();
        element.sendKeys(text);
    }
    
    /**
     * Wait for page to load by checking document.readyState
     * @param driver WebDriver instance
     * @param timeoutInSeconds timeout in seconds
     */
    public static void waitForPageToLoad(WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }
    
    /**
     * Wait for AJAX calls to complete
     * @param driver WebDriver instance
     * @param timeoutInSeconds timeout in seconds
     */
    public static void waitForAjax(WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                .executeScript("return jQuery.active == 0"));
    }


    public static void waitForDropdownToBeReady(WebDriver driver, By locator, int timeoutSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
            .until(ExpectedConditions.elementToBeClickable(locator));
    }


    
    public static void waitForLoaderToDisappear(WebDriver driver, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("backdrop")));
    }
    public static WebElement waitForPresence(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

   


}