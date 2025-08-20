package com.stratapps.xamplify.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.stratapps.xamplify.base.BaseTest;
import com.stratapps.xamplify.utils.ConfigReader;
import com.stratapps.xamplify.utils.EmailUtil;
import com.stratapps.xamplify.utils.ExtentManager;
import com.stratapps.xamplify.utils.ScreenshotUtil;

import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestListener implements ITestListener, ISuiteListener {

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    public static long suiteStartTime;
    public static long suiteEndTime;

    @Override
    public void onStart(ISuite suite) {
        suiteStartTime = System.currentTimeMillis();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = ExtentManager.getInstance().createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());

        Object testClass = result.getInstance();
        WebDriver driver = null;

        if (testClass instanceof BaseTest) {
            driver = ((BaseTest) testClass).getDriver();
        }

        if (driver != null) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
            extentTest.get().addScreenCaptureFromPath(screenshotPath);
            BaseTest.failedScreenshotPaths.add(screenshotPath);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip("Test skipped");
    }

    @Override
    public void onFinish(ISuite suite) {
        suiteEndTime = System.currentTimeMillis();

        int passedCount = 0, failedCount = 0, skippedCount = 0;

        for (ISuiteResult result : suite.getResults().values()) {
            ITestContext context = result.getTestContext();
            passedCount += context.getPassedTests().size();
            failedCount += context.getFailedTests().size();
            skippedCount += context.getSkippedTests().size();
        }

        // Time details
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        String startTimeStr = sdf.format(new Date(suiteStartTime));
        String endTimeStr = sdf.format(new Date(suiteEndTime));
        long durationMillis = suiteEndTime - suiteStartTime;
        long durationMinutes = (durationMillis / 1000) / 60;
        long durationSeconds = (durationMillis / 1000) % 60;

        String machine = "Unknown";
        try {
            machine = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            machine = "Unavailable";
        }

        String browser = ConfigReader.getProperty("browser.name");
        String environment = ConfigReader.getProperty("env.name");

        StringBuilder emailBody = new StringBuilder();
        emailBody.append("\uD83D\uDCCB Test Summary:\n")
                .append("\u2705 Passed: ").append(passedCount).append("\n")
                .append("\u274C Failed: ").append(failedCount).append("\n")
                .append("\u23ED️ Skipped: ").append(skippedCount).append("\n\n")
                .append("\uD83D\uDD52 Start Time: ").append(startTimeStr).append("\n")
                .append("\uD83D\uDD53 End Time: ").append(endTimeStr).append("\n")
                .append("\u23F1️ Duration: ").append(durationMinutes).append(" min ").append(durationSeconds).append(" sec\n\n")
                .append("\uD83D\uDCBB Machine: ").append(machine).append("\n")
                .append("\uD83C\uDF10 Browser: ").append(browser != null ? browser : "Not Set").append("\n")
                .append("\uD83C\uDFF7️ Environment: ").append(environment != null ? environment : "Not Set").append("\n\n")
                .append("\uD83D\uDCCC Please find the attached test execution report and any screenshots.");

        String subject = "\uD83D\uDCE7 Automation Test Report - Summary";
        String reportPath = ExtentManager.getReportPath();

        ExtentManager.flushReport();

        EmailUtil.sendReportEmailWithAttachments(
                "agayatri@stratapps.com",
                subject,
                emailBody.toString(),
                reportPath,
                BaseTest.failedScreenshotPaths
        );
    }

    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override public void onTestFailedWithTimeout(ITestResult result) {}
}
