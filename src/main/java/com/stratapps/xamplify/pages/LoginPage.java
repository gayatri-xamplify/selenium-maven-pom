package com.stratapps.xamplify.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import com.stratapps.xamplify.utils.ConfigReader;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Login fields
    private By emailField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");

    // Role landing elements
    private By vendorLanding = By.xpath("//button[contains(text(),'Invite A vendor')]");
    private By partnerLanding = By.xpath("//span[contains(text(),'Account Dashboard')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private void login(String email, String password, String role) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).clear();
        driver.findElement(emailField).sendKeys(email);

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).clear();
        driver.findElement(passwordField).sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

        // Wait for correct role landing page
        if ("VENDOR".equalsIgnoreCase(role)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(vendorLanding));
        } else if ("PARTNER".equalsIgnoreCase(role)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(partnerLanding));
        }
    }

    public void loginAsVendor() {
        login(
            ConfigReader.getProperty("username"),
            ConfigReader.getProperty("password"),
            "VENDOR"
        );
    }

    public void loginAsPartner() {
        login(
            ConfigReader.getProperty("partner.username"),
            ConfigReader.getProperty("partner.password"),
            "PARTNER"
        );
    }
}
