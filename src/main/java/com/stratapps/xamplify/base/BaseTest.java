package com.stratapps.xamplify.base;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.LogoutPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class BaseTest {

    protected static WebDriver driver;
    private static String currentRole = "NONE";

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(ConfigReader.getProperty("url"));
        }
    }

    @BeforeClass(alwaysRun = true)
    @Parameters("role")
    public void beforeClass(@Optional("NONE") String role) {

        if ("NONE".equalsIgnoreCase(role)) {
            return;
        }

        waitForPageStable();

        if (!"NONE".equalsIgnoreCase(currentRole)) {
            LogoutPage logoutPage = new LogoutPage(driver);
            logoutPage.logout();
        }

        driver.manage().deleteAllCookies();
        driver.get(ConfigReader.getProperty("url"));
        waitForPageStable();

        LoginPage loginPage = new LoginPage(driver);

        if ("VENDOR".equalsIgnoreCase(role)) {
            loginPage.loginAsVendor();
        } else if ("PARTNER".equalsIgnoreCase(role)) {
            loginPage.loginAsPartner();
        } else {
            throw new RuntimeException("Unsupported role: " + role);
        }

        currentRole = role;
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        if (driver != null) {
            driver.quit();
            driver = null;
            currentRole = "NONE";
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    private void waitForPageStable() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(
                d -> ((JavascriptExecutor) d)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
    }
}
