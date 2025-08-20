package com.stratapps.xamplify.utils;

import java.util.TimeZone;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;
    private static String reportPath;

    public static ExtentReports getInstance() {
    	TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));

        if (extent == null) {
            // Set report path
            reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";

            // Create SparkReporter
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setReportName("Automation Execution Report");
            reporter.config().setDocumentTitle("Test Results");

            // Attach reporter to extent
            extent = new ExtentReports();
            extent.attachReporter(reporter);

            // Optional: Add system/environment info
            extent.setSystemInfo("Environment", ConfigReader.getProperty("env.name"));
            extent.setSystemInfo("Browser", ConfigReader.getProperty("browser.name"));
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("User", System.getProperty("user.name"));
        }
        return extent;
    }

    // ✅ Add this method
    public static void flushReport() {
        if (extent != null) {
            extent.flush();  // This writes the report to disk
        }
    }

    // To get the path of the generated report for email attachment
    public static String getReportPath() {
        return reportPath;
    }
}
