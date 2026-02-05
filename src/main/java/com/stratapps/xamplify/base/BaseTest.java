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
     * Login ONCE per role (Vendor / Partner)
     */
    @BeforeTest(alwaysRun = true)
    @Parameters("role")
    public void beforeTest(@Optional("NONE") String role) {

        if ("NONE".equalsIgnoreCase(role)) {
            return;
        }

        driver.get(ConfigReader.getProperty("url"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(role);
    }

    /**
     * Logout ONCE per role
     * NEVER fail suite from here
     */
 
    
    
    
    
    
    
    @AfterTest(alwaysRun = true)
    public void afterTest() {
        try {
            if (driver == null) {
                return;
            }

            // Logout safely
            new LogoutPage(driver).logout();

            // Delete cookies ONLY if session is still alive
            try {
                driver.manage().deleteAllCookies();
            } catch (Exception e) {
                System.out.println("Skipping cookie deletion: " + e.getMessage());
            }

        } catch (Exception e) {
            // Absolutely never fail configuration
            System.out.println("AfterTest cleanup skipped: " + e.getMessage());
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception ignored) {
        } finally {
            driver = null;
        }
    }

    // Required if you use listeners
    public WebDriver getDriver() {
        return driver;
    }
}
