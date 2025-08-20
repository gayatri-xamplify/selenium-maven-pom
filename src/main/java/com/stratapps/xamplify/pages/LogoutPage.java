package com.stratapps.xamplify.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators (update if exact match differs in your HTML)
    private By userProfileDropdown = By.xpath("//i[contains(@class, 'fa-angle-down')]");
    private By logoutButton = By.xpath("//a[normalize-space()='Log Out']");

    // Constructor
    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Actions
    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(userProfileDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}