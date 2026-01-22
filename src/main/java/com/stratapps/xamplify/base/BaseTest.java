package com.stratapps.xamplify.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.pages.LogoutPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class BaseTest {

    protected static WebDriver driver;
    private static String currentRole = "NONE";

    protected final Logger logger = LogManager.getLogger(this.getClass());

    /* =========================================================
       SUITE SETUP – Browser launch (ONCE)
       ========================================================= */
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        if (driver == null) {
            logger.info("🚀 Launching browser for test suite");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(ConfigReader.getProperty("url"));
        }
    }

    /* =========================================================
       CLASS SETUP – Role-based login (ONCE PER ROLE)
       ========================================================= */
    @BeforeClass(alwaysRun = true)
    @Parameters("role")
    public void beforeClass(@Optional("NONE") String role) {

        if ("NONE".equalsIgnoreCase(role)) {
            logger.info("ℹ️ No role specified for class {}", this.getClass().getSimpleName());
            return;
        }

        if (role.equalsIgnoreCase(currentRole)) {
            logger.info("🔁 Reusing existing {} session", role);
            return;
        }

        // Logout if switching roles
        if (!"NONE".equalsIgnoreCase(currentRole)) {
            logger.info("🔓 Logging out from {}", currentRole);
            new LogoutPage(driver).logout();
        }

        // Login for new role
        LoginPage loginPage = new LoginPage(driver);

        if ("VENDOR".equalsIgnoreCase(role)) {
            loginPage.loginAsVendor();
        } else if ("PARTNER".equalsIgnoreCase(role)) {
            loginPage.loginAsPartner();
        } else {
            throw new RuntimeException("❌ Unsupported role: " + role);
        }

        currentRole = role;
        logger.info("🔐 Logged in as {}", role);
    }

    /* =========================================================
       SUITE TEARDOWN – Browser quit (ONCE)
       ========================================================= */
    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        if (driver != null) {
            logger.info("🧹 Closing browser after suite");
            driver.quit();
            driver = null;
            currentRole = "NONE";
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
