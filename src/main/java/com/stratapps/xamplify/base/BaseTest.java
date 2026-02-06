package com.stratapps.xamplify.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.LogoutPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * LOGIN ONCE PER ROLE
     * (Runs once for Vendor <test>, once for Partner <test>)
     */
    @BeforeTest(alwaysRun = true)
    @Parameters("role")
    public void beforeTest(@Optional("NONE") String role) {

        if ("NONE".equalsIgnoreCase(role)) {
            return;
        }

        driver.get(ConfigReader.getProperty("url"));
        new LoginPage(driver).login(role);

        System.out.println("✅ LOGIN DONE FOR ROLE: " + role);
    }

    /**
     * LOGOUT ONCE AFTER ALL CLASSES OF THAT ROLE FINISH
     */
    @AfterTest(alwaysRun = true)
    public void afterTest() {

        try {
            if (driver == null) return;

            try {
                new LogoutPage(driver).logout();
                System.out.println("✅ LOGOUT DONE");
            } catch (Exception e) {
                System.out.println("⚠ Logout skipped: " + e.getMessage());
            }

        } catch (Exception e) {
            // NEVER fail configuration
            System.out.println("⚠ AfterTest cleanup failed safely: " + e.getMessage());
        }
    }

    /**
     * CLOSE BROWSER ONCE AT VERY END
     */
    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception ignored) {
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
