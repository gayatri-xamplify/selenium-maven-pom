package com.stratapps.xamplify.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.LogoutPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("role")
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("NONE") String role) {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        if (!"NONE".equalsIgnoreCase(role)) {
            driver.get(ConfigReader.getProperty("url"));
            new LoginPage(driver).login(role);
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        try {
            if (driver != null) {
                try {
                    new LogoutPage(driver).logout();
                } catch (Exception ignored) {
                }
                driver.quit();
            }
        } finally {
            driver = null;
        }
    }

    // Used by listeners
    public WebDriver getDriver() {
        return driver;
    }
}
