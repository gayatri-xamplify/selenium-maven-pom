package com.stratapps.xamplify.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.stratapps.xamplify.pages.LoginPage;
import com.stratapps.xamplify.utils.ConfigReader;

public class BaseTest {
    protected static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    public static List<String> failedScreenshotPaths = new ArrayList<>();

    private static final Set<String> vendorClasses = new HashSet<>(Arrays.asList(
            "AddTracksTest", "ManageTracksTest", "TeamVendorTest"
    ));

    private static final Set<String> partnerClasses = new HashSet<>(Arrays.asList(
            "SharedLeadsTest", "TeamPartnerTest"
    ));

    private static int vendorTestCount = 0;
    private static int partnerTestCount = 0;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        if (driver == null) {
            logger.info("🛠 BaseTest.setUp() - START");
            driver = new ChromeDriver();  // ✅ Adjust as needed (ChromeOptions, remote, etc.)
            driver.manage().window().maximize();
            driver.get(ConfigReader.getProperty("url"));
            logger.info("✅ WebDriver initialized and navigated to URL.");
        } else {
            logger.info("🔁 Reusing existing WebDriver session");
        }

        logger.info("✅ BaseTest.setUp() - COMPLETE");
    }

    /**
     * Checks if the user is logged in by checking visibility of the Welcome element.
     */
    public boolean isLoggedIn() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            return loginPage.isWelcomeDisplayed();
        } catch (Exception e) {
            logger.warn("⚠️ isLoggedIn() failed: {}", e.getMessage());
            return false;
        }
    }

    
    
    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        String className = this.getClass().getSimpleName();

        // Vendor
        if (vendorClasses.contains(className)) {
            vendorTestCount++;
            logger.info("✅ Vendor class '{}' completed. Progress: {}/{}", className, vendorTestCount, vendorClasses.size());

            if (vendorTestCount == vendorClasses.size()) {
                logoutIfLoggedIn();
                logger.info("🔒 Logged out after all vendor classes completed.");
            } else {
                logger.info("⏳ Waiting for remaining vendor test classes. Logout skipped for now.");
            }
        }

        // Partner
        if (partnerClasses.contains(className)) {
            partnerTestCount++;
            logger.info("✅ Partner class '{}' completed. Progress: {}/{}", className, partnerTestCount, partnerClasses.size());

            if (partnerTestCount == partnerClasses.size()) {
                logoutIfLoggedIn();
                logger.info("🔒 Logged out after all partner classes completed.");
            } else {
                logger.info("⏳ Waiting for remaining partner test classes. Logout skipped for now.");
            }
        }
    }

    
    
    
    
    
    
    
    public void logoutIfLoggedIn() {
        try {
            if (isLoggedIn()) {
                logger.info("🔓 Logging out...");
                driver.get(ConfigReader.getProperty("url") + "/logout"); // ✅ Adjust as per app
            }
        } catch (Exception e) {
            logger.error("❌ Logout failed: {}", e.getMessage());
        }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        if (driver != null) {
            driver.quit();
            logger.info("🧹 WebDriver closed after suite.");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
