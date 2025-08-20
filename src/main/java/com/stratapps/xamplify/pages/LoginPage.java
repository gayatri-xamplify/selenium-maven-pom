package com.stratapps.xamplify.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import com.stratapps.xamplify.utils.ConfigReader;

import io.opentelemetry.api.internal.ConfigUtil;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    private WebDriverWait wait;

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

	/*
	 * // Constructor public LoginPage(WebDriver driver) { this.driver = driver; }
	 */
    

   

    private static final int DEFAULT_TIMEOUT_SECONDS = 30; // Define a default timeout
    
    
    
    
    public LoginPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS)); // Initialize WebDriverWait

    }


    

    // Locators
    private By emailField = By.xpath("//input[@id='username']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//button[@type='submit']");
   // private By welcomeMessage = By.xpath("//h4//span[contains(text(), 'Welcome')]");
    
    		  //private By Accdashboard = By.xpath("//span[contains(text(),'Account Dashboard')]");
    		  
    		  private By invitevendor = By.xpath("//button[contains(text(),'Invite A vendor')]");
    		  
    		  
    		

    // Actions
    public void login(String email, String password) {
        try {
            logger.info("Attempting to login with email: {}", email);

            //driver.findElement(emailField).clear();
            driver.findElement(emailField).sendKeys(email);
            
            
            
            logger.debug("Entered email.");

            driver.findElement(passwordField).clear();
            driver.findElement(passwordField).sendKeys(password);
            logger.debug("Entered password.");

            // Try JavaScript click if regular click doesn't work
            try {
                driver.findElement(loginButton).click();
            } catch (Exception e) {
                logger.warn("Regular click failed, trying JavaScript click: {}", e.getMessage());
                org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", driver.findElement(loginButton));
            }
            logger.info("Clicked Login button.");

            // Wait for welcome message with increased timeout
            new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.visibilityOfElementLocated(invitevendor));
            logger.info("Login successful. Welcome message displayed.");

        } catch (Exception e) {
            logger.error("Login failed: " + e.getMessage(), e);
            throw e;
        }
    }
    
    
    
    

    // Role-based convenience methods


    public void loginAsVendor() {
        login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
    }

    public void loginAsPartner() {
        login(ConfigReader.getProperty("partner.username"), ConfigReader.getProperty("partner.password"));
    }
    public boolean isWelcomeDisplayed() {
        boolean visible = driver.findElement(invitevendor).isDisplayed();
        logger.info("Welcome message is displayed: {}", visible);
        return visible;
    }
}
