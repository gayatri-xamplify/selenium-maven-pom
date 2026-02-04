package com.stratapps.xamplify.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By userProfileDropdown = By.xpath("//i[contains(@class,'fa-angle-down')]");
    private By logoutButton = By.xpath("//a[normalize-space()='Log Out']");
    private By loginUsernameField = By.id("username");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void logout() {

        // If already on login page, skip logout
        if (!driver.findElements(loginUsernameField).isEmpty()) {
            return;
        }

        // Open profile dropdown
        wait.until(ExpectedConditions.elementToBeClickable(userProfileDropdown)).click();

        // Click logout with stale-safe retry
        wait.until(d -> {
            try {
                d.findElement(logoutButton).click();
                return true;
            } catch (StaleElementReferenceException e) {
                return false;
            }
        });

        // Wait until redirected to login page
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginUsernameField));
    }
}
