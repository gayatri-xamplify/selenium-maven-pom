package com.stratapps.xamplify.utils;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionUtil {
	
	public static void hover(WebDriver driver, By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	    new Actions(driver).moveToElement(element).perform();
	}

	
	public static void hoverAndClick(WebDriver driver, By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            // Scroll into view (important in headless)
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

            // Wait a bit for animations (if any)
            Thread.sleep(500);

            // Ensure element has size and location
            if (element.getRect().getHeight() > 0 && element.getRect().getWidth() > 0) {
                Actions actions = new Actions(driver);
                actions.moveToElement(element).click().perform();
                System.out.println("Clicked on element successfully: " + locator.toString());
            } else {
                throw new ElementNotInteractableException("Element has no visible size or location: " + locator.toString());
            }

        } catch (TimeoutException e) {
            System.err.println("Timeout waiting for element to be visible: " + locator.toString());
            throw e;
        } catch (ElementNotInteractableException e) {
            System.err.println("Element not interactable: " + locator.toString());
            throw e;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // best practice
            System.err.println("Thread interrupted during sleep before hover/click.");
        } catch (Exception e) {
            System.err.println("Unexpected error in hoverAndClick: " + e.getMessage());
            throw e;
        }
    }

	
	
	
	


	
	
	
	
	
	
	
	

	/*
	 * public static void hoverAndClick(WebDriver driver, By hoverLocator, By
	 * clickLocator) throws Exception { WebDriverWait wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(60)); // ⏳ increased timeout
	 * 
	 * try {
	 * 
	 * 
	 * 
	 * // ✅ First wait for element to be present in the DOM
	 * wait.until(ExpectedConditions.presenceOfElementLocated(hoverLocator));
	 * 
	 * 
	 * 
	 * 
	 * // Wait for hover element to be visible WebElement hoverElement =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(hoverLocator));
	 * 
	 * 
	 * // Hover Actions actions = new Actions(driver);
	 * actions.moveToElement(hoverElement).pause(Duration.ofMillis(500)).perform();
	 * 
	 * 
	 * 
	 * // ✅ Wait for clickable target
	 * wait.until(ExpectedConditions.presenceOfElementLocated(clickLocator)); //
	 * Wait for click element to be clickable WebElement clickElement =
	 * wait.until(ExpectedConditions.elementToBeClickable(clickLocator));
	 * 
	 * // Scroll to and click ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].scrollIntoView(true);", clickElement);
	 * actions.moveToElement(clickElement).click().perform();
	 * 
	 * 
	 * } catch (TimeoutException e) {
	 * System.out.println("Timed out waiting for hover or click element.");
	 * ScreenshotUtil.captureScreenshot(driver, "hover_click_timeout_" +
	 * System.currentTimeMillis()); throw e;
	 * 
	 * 
	 * } catch (Exception e) {
	 * System.out.println("Unexpected error in hoverAndClick: " + e.getMessage());
	 * throw e; } }
	 * 
	 */
	
	public static void scrollInsideElement(WebDriver driver, WebElement element,int pixels) { 
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop += arguments[1];", element, pixels);
	
	}
	
	
	
	
	public static void jsClick(WebDriver driver, WebElement addCompanyBtn) {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addCompanyBtn);
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	
	
	
	
	
	
	
	
	
	
	
// ✅ NEW METHOD: Click with retry logic and better wait handling
public static void clickWithRetry(WebDriver driver, By locator, int maxRetries) {
    int retry = 0;
    while (retry < maxRetries) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

            // ✅ Scroll into view if not visible (helps hidden elements become clickable)
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

            element.click();
            return;
        } catch (Exception e) {
            retry++;
            System.out.println("Retry " + retry + ": Failed to click " + locator);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {}
        }
    }
    throw new RuntimeException("Failed to click after " + maxRetries + " attempts: " + locator);
}
}