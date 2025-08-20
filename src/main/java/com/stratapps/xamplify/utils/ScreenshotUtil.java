package com.stratapps.xamplify.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;  
import java.util.Date;              

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // ✅ ADDED: Get current date to create date-wise folder
        String dateFolder = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        // ✅ MODIFIED: Screenshot path now includes date-wise folder
        String timestamp = String.valueOf(System.currentTimeMillis());
        String screenshotPath = System.getProperty("user.dir")
                + "/test-output/screenshots/" + dateFolder + "/" + testName + "_" + timestamp + ".png";

        File destFile = new File(screenshotPath);

        try {
            // ✅ MODIFIED: Create directory structure including date folder
            Files.createDirectories(destFile.getParentFile().toPath());
            Files.copy(srcFile.toPath(), destFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}
