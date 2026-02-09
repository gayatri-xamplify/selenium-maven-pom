package com.stratapps.xamplify.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

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
        return waitForVisibility(driver, locator, timeoutInSeconds); // 🔁 Reuse internally
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
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds)).until(ExpectedConditions.elementToBeClickable(locator));
    }


    
    public static void waitForLoaderToDisappear(WebDriver driver, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("backdrop")));
    }
    public static WebElement waitForPresence(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    
    
 // 🔁 UPDATED: Enhanced waitAndClick with full stabilization and fallback
    public static void waitAndClick(WebDriver driver, By locator, By backdropLocator, int timeout) {
        waitForPageToLoad(driver, timeout);

        // Wait for the backdrop/spinner (if any) to disappear
        waitForInvisibilityOfElement(backdropLocator, driver, timeout);
        
        // ✅ NEW: Additional safety before clicking
        try {
            Thread.sleep(500); // optional delay for flaky DOMs
        } catch (InterruptedException ignored) {}

        waitForElementClickable(driver, locator, timeout); // ✅ use elementToBeClickable instead of just visible

        // ✅ REPLACED direct click with safer version
        ElementUtil.safeClick(locator, driver); // NEW: uses JS fallback if needed
    }

    // ✅ NEW: wait for scroll & visibility then return element (optional utility)
    public static WebElement waitAndScrollToElement(WebDriver driver, By locator, int timeoutInSeconds) {
        WebElement element = waitForElementVisible(driver, locator, timeoutInSeconds);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        return element;
    }
    
    
    
    
    // Mounika
    public static void waitForNewTabAndSwitch(WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        
        // Store the original window handle
        String originalWindow = driver.getWindowHandle();

        // Wait until a new window is opened
        wait.until(driver1 -> driver1.getWindowHandles().size() > 1);

        // Get all open window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the new window
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
   
    
    
    private static String mainWindowHandle;

    public static void storeMainTabHandle(WebDriver driver) {
        mainWindowHandle = driver.getWindowHandle();
    }

    public static void switchToMainTab(WebDriver driver, String originalHandle) {
        driver.switchTo().window(originalHandle);
    }

    


    public static void waitForVisibilityElement(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public static void dragAndDrop(WebDriver driver, By sourceLocator, By targetLocator, int timeoutInSeconds) {

        try {
            WebElement source = waitForElementVisible(driver, sourceLocator, timeoutInSeconds);
            WebElement target = waitForElementVisible(driver, targetLocator, timeoutInSeconds);

            Actions actions = new Actions(driver);
            actions.clickAndHold(source).moveToElement(target).release().build().perform();

            System.out.println("✅ Drag and drop performed successfully: " + sourceLocator + " → " + targetLocator);

        } catch (Exception e) {
                   System.out.println("❌ Error performing drag and drop: " + e.getMessage());
        }

    }
    
	public static void verifyResponseMessage(WebDriver driver, By locator, int timeoutInSeconds, String expectedMessage) {
	    WebElement responseMsg = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
	            .until(ExpectedConditions.visibilityOfElementLocated(locator));
		String actualMessage = responseMsg.getText().trim();

	    if (actualMessage.equalsIgnoreCase(expectedMessage)) {
	        System.out.println("✅ Message Verified: " + actualMessage);
	    } else {
	        System.out.println("❌ Message Mismatch: Expected [" + expectedMessage + "] but found [" + actualMessage + "]");
	    }
	}

//      mounika - safeJsClick

    public static void safeJsClick(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        try {
            // 1️⃣ Wait for element to be visible (fresh reference)
            WebElement element = wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.visibilityOfElementLocated(locator)
            ));

            // 2️⃣ Scroll element into center view
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block:'center', inline:'nearest'});", 
                    element
            );
            Thread.sleep(300);

            // 3️⃣ Wait again for clickability (fresh lookup)
            element = wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(locator)
            ));

            // 4️⃣ Try normal click first
            try {
                element.click();
            } catch (Exception e) {
                // 5️⃣ Fallback to JS click
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }

        } catch (Exception e) {
            throw new RuntimeException("❌ safeJsClick FAILED for locator: " + locator + "\n" + e.getMessage(), e);
        }
    }
    
    public static void handleSweetAlertIfPresent(WebDriver driver, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

        By swalPopup = By.cssSelector(".swal2-popup");
        By confirmBtn = By.cssSelector(".swal2-confirm");

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(swalPopup));

            if (driver.findElements(confirmBtn).size() > 0) {
                driver.findElement(confirmBtn).click();
            }

            wait.until(ExpectedConditions.invisibilityOfElementLocated(swalPopup));
        } catch (TimeoutException e) {
            // SweetAlert not shown — safe to continue
        }
    }

    


//mounika

public static void clickIgnoringStale(WebDriver driver, By locator, int timeout) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

    wait.until(d -> {
        try {
            WebElement el = d.findElement(locator);
            el.click();
            return true;
        } catch (StaleElementReferenceException e) {
            return false;
        }
    });
}
}

