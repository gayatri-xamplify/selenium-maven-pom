package com.stratapps.xamplify.pages;

import java.time.Duration;

import org.openqa.selenium.By;
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

        if (driver.findElements(userProfileDropdown).isEmpty()) {
            return; // already logged out
        }

        wait.until(ExpectedConditions.elementToBeClickable(userProfileDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginUsernameField));
    }
}
