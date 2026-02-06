package com.stratapps.xamplify.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.utils.ConfigReader;
import com.stratapps.xamplify.utils.EmailUtil;
import com.stratapps.xamplify.utils.ExtentManager;
import com.stratapps.xamplify.utils.ScreenshotUtil;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestListener implements ITestListener, ISuiteListener {

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static List<String> failedScreenshotPaths = new ArrayList<>();

    private static long suiteStartTime;
    private static long suiteEndTime;

    @Override
    public void onStart(ISuite suite) {
        suiteStartTime = System.currentTimeMillis();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = ExtentManager.getInstance()
                .createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());

        WebDriver driver = null;

        if (result.getInstance() instanceof BaseTest) {
            driver = ((BaseTest) result.getInstance()).getDriver();
        }

        if (driver == null) {
            return;
        }

        try {
            String screenshotPath =
                    ScreenshotUtil.captureScreenshot(driver, result.getName());

            extentTest.get().addScreenCaptureFromPath(screenshotPath);
            failedScreenshotPaths.add(screenshotPath);

        } catch (NoSuchSessionException e) {
            // Driver already closed — do NOT fail listener
            extentTest.get().warning("Screenshot skipped: WebDriver session invalid");
        } catch (Exception e) {
            extentTest.get().warning("Screenshot capture failed: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip("Test skipped");
    }

    @Override
    public void onFinish(ISuite suite) {
        suiteEndTime = System.currentTimeMillis();

        int passed = 0, failed = 0, skipped = 0;

        for (ISuiteResult result : suite.getResults().values()) {
            ITestContext context = result.getTestContext();
            passed += context.getPassedTests().size();
            failed += context.getFailedTests().size();
            skipped += context.getSkippedTests().size();
        }

        // Time formatting
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));

        String startTime = sdf.format(new Date(suiteStartTime));
        String endTime = sdf.format(new Date(suiteEndTime));

        long durationMs = suiteEndTime - suiteStartTime;
        long minutes = (durationMs / 1000) / 60;
        long seconds = (durationMs / 1000) % 60;

        String machine;
        try {
            machine = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            machine = "Unavailable";
        }

        String browser = ConfigReader.getProperty("browser.name");
        String environment = ConfigReader.getProperty("env.name");

        String body = ""
                + "📋 Test Summary:\n"
                + "✅ Passed: " + passed + "\n"
                + "❌ Failed: " + failed + "\n"
                + "⏭ Skipped: " + skipped + "\n\n"
                + "🕒 Start: " + startTime + "\n"
                + "🕓 End: " + endTime + "\n"
                + "⏱ Duration: " + minutes + " min " + seconds + " sec\n\n"
                + "💻 Machine: " + machine + "\n"
                + "🌐 Browser: " + (browser != null ? browser : "Not Set") + "\n"
                + "🏷 Environment: " + (environment != null ? environment : "Not Set");

        ExtentManager.flushReport();

        EmailUtil.sendReportEmailWithAttachments(
                "gayatri@xamplify.com,ganesh@xamplify.com,mounika@xamplify.com",
                "📧 Automation Test Report - Summary",
                body,
                ExtentManager.getReportPath(),
                failedScreenshotPaths
        );
    }

    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override public void onTestFailedWithTimeout(ITestResult result) {}
}