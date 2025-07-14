package com.stratapps.xamplify.base;

import com.stratapps.xamplify.pages.LogoutPage;
import com.stratapps.xamplify.utils.ConfigReader;
import com.stratapps.xamplify.utils.EmailUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; // 🔁 CHANGED
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    protected WebDriver driver;
    public static List<String> failedScreenshotPaths = new ArrayList<>();

    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    private static WebDriver staticDriver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {
        if (staticDriver == null) {
            String browser = ConfigReader.getProperty("browser.name");

            if (browser == null) {
                throw new IllegalStateException("Browser property is missing in config.properties");
            }

            logger.info("Setting up WebDriver. Browser: {}", browser);

            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
               

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");// prevent shared memory
                options.addArguments("--remote-allow-origins=*");// optional but prevents newer driver errors
                options.addArguments("--disable-gpu");
                options.addArguments("--start-maximized");
                options.addArguments("--force-device-scale-factor=1");

                // ✅ Run headless only in CI
                if (System.getenv("CI") != null) {
                    options.addArguments("--headless=new");
                }

                // ✅ Isolate user profile in CI
                String uniqueProfile = System.getProperty("java.io.tmpdir") + "/chrome-profile-" + System.currentTimeMillis();
                options.addArguments("--user-data-dir=" + uniqueProfile);

                // ✅ Initialize driver
                staticDriver = new ChromeDriver(options);
                logger.debug("Initialized ChromeDriver");

              
                staticDriver.manage().window().maximize();
                // ✅ Set window size AFTER driver init
                //staticDriver.manage().window().setSize(new Dimension(1920, 1080));
                logger.info("Browser window maximized");

            }
                
          
      
            String url = ConfigReader.getProperty("url");
            if (url == null) {
                throw new IllegalStateException("URL property is missing in config.properties");
            }
            staticDriver.get(url);
            logger.info("Navigated to URL: {}", url);
        }

        driver = staticDriver;
    }
    
    
    
    protected void logoutIfLoggedIn() {
        try {
            LogoutPage logoutPage = new LogoutPage(driver);
            logoutPage.logout();
            logger.info("Logout successful.");
        } catch (Exception e) {
            logger.warn("Logout failed or not needed: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
    	logoutIfLoggedIn();
    	
        if (driver != null) {
            logger.info("Test completed, browser remains open");
            // staticDriver.quit(); // Uncomment to close after each test class
        }
    }


}
