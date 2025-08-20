package com.stratapps.xamplify.utils;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {


	public static WebDriver extractDriver(Object testClassInstance) {
	    try {
	        return (WebDriver) testClassInstance.getClass().getField("driver").get(testClassInstance);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	
	  //Mounika
	public static void clickWithRetry(By locator, WebDriver driver, int retries) { for (int i = 0; i < retries; i++) { try { WebElement element =
	  driver.findElement(locator); new WebDriverWait(driver,
	  Duration.ofSeconds(10))
	  .until(ExpectedConditions.elementToBeClickable(element)); element.click();
	  return; } catch (Exception e) {
	  System.out.println("Retrying click... Attempt: " + (i + 1));
	  
	  } } throw new RuntimeException("Unable to click after retries: " + locator);
	  }
	 
	
	
    public static WebElement getById(WebDriver driver, String id) {
        return driver.findElement(By.id(id));
    }

    public static void sendText(By locator, String text, WebDriver driver) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public static void click(By locator, WebDriver driver) {
        driver.findElement(locator).click();
    }

    public static void sendKey(By locator, Keys key, WebDriver driver) {
        driver.findElement(locator).sendKeys(key);
    }
    
    
    public static void selectDropdownByVisibleText(By locator, String visibleText, WebDriver driver) {
        WebElement dropdownElement = driver.findElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    
    
    
    
    public static void sendTextdriver(WebDriver driver, By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public static void sendKeydriver(WebDriver driver, By locator, Keys key) {
        driver.findElement(locator).sendKeys(key);
    }

    

    
    
    // ✅ NEW: Safe click with JS fallback
    public static void safeClick(By locator, WebDriver driver) throws ElementClickInterceptedException {
        WebElement element = driver.findElement(locator);

        try {
            scrollToElement(element, driver);
            element.click();
        } catch (ElementNotInteractableException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    // ✅ NEW: Scroll to element
    public static void scrollToElement(WebElement element, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    // ✅ NEW: Get text from element
    public static String getText(By locator, WebDriver driver) {
        return driver.findElement(locator).getText();
    }

    // ✅ NEW: Check if element is displayed
    public static boolean isDisplayed(By locator, WebDriver driver) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    
	/*
	 * public static void clickWithRetry(By locator, WebDriver driver, int
	 * maxRetries) { int attempts = 0; while (attempts < maxRetries) { try {
	 * WebElement element = driver.findElement(locator);
	 * 
	 * // ✅ Scroll into view to avoid hidden/intercepted clicks
	 * ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
	 * element);
	 * 
	 * // ✅ Attempt regular click element.click(); return; // success } catch
	 * (StaleElementReferenceException | ElementClickInterceptedException e) {
	 * attempts++; System.out.println("Attempt " + attempts + " failed for: " +
	 * locator + " - Retrying..."); try { Thread.sleep(300); // ✅ Optional short
	 * pause } catch (InterruptedException ignored) {} } } throw new
	 * RuntimeException("❌ Click failed after " + maxRetries + " attempts for: " +
	 * locator); }
	 */
    public static void safeClick(WebDriver driver, WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    
    
    

  //Mounika
    public static void clickWhenReady(WebDriver driver, By locator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click on element: " + locator, e);
        }
    }

    public static boolean isElementVisible(By locator, WebDriver driver) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public static void safeClickFirstAsset(By locator, WebDriver driver) {
        for (int i = 0; i < 3; i++) {
            try {
                WebElement el = WaitUtil.waitForVisibility(driver, locator, 30);
                // Optional: scroll if overlay issue
                // ActionUtil.scrollToElement(el, driver);
                el.click();
                return;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                System.out.println("Retrying asset click: " + e.getMessage());
               // WaitUtil.sleep(1000);
            }
        }
        throw new RuntimeException("Failed to click first asset after 3 attempts: " + locator);
    }



public static void scrollIntoView(WebDriver driver, By locator) {
    WebElement element = driver.findElement(locator);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
}
    
    
}
