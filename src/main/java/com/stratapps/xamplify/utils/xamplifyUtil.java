package com.stratapps.xamplify.utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
public class xamplifyUtil {

	public static String generatePartnerCSV(List<String[]> puserData) {
		// Generate unique filename using timestamp
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String filePath = "test_data_" + timestamp + ".csv";
		File csvFile = new File(filePath);

		try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
			// Writing headers
			writer.println("FIRSTNAME,LASTNAME,ACCOUNT NAME,ACCOUNT OWNER,ACCOUNT SUB TYPE,COMPANY, COMPANY DOMAIN,"
					+ "JOBTITLE,EMAILID, WEBSITE,VERTICAL,REGION,TERRITORY,TYPE,CATEGORY,ADDRESS,CITY,STATE,ZIP,"
					+ "COUNTRY,MOBILE NUMBER");

			// Writing data rows
			for (String[] user : puserData) {
				writer.println(String.join(",", user));
			}

			System.out.println("CSV File Generated: " + csvFile.getAbsolutePath());
		} catch (IOException e) 
		{
			e.printStackTrace();
		}

		return csvFile.getAbsolutePath(); // Return the file path for test usage
	}

	public static void sendmobileTextEvent(WebDriver driver, By locator, String newNumber) throws InterruptedException {
	    WebElement phoneInput = driver.findElement(locator);

	    // Focus input
	    phoneInput.click();
	    Thread.sleep(500);

	    // Check if country code is present
	    String currentVal = phoneInput.getAttribute("value");
	    boolean hasCountryCode = currentVal != null && currentVal.contains("+");

	    // Extract country code from new number
	    String countryCode = "";
	    if (newNumber.startsWith("+")) {
	        int spaceIdx = newNumber.indexOf(" ");
	        if (spaceIdx != -1) {
	            countryCode = newNumber.substring(0, spaceIdx);
	        } else {
	            // fallback if no space (assumes code is first 2-4 chars)
	            for (int i = 2; i <= 4 && i < newNumber.length(); i++) {
	                if (!Character.isDigit(newNumber.charAt(i))) {
	                    countryCode = newNumber.substring(0, i);
	                    break;
	                }
	            }
	            if (countryCode.isEmpty()) countryCode = newNumber.substring(0, 3); // default length
	        }
	    }

	    // Update flag if needed
	    if (!hasCountryCode || !currentVal.startsWith(countryCode)) {
	        driver.findElement(locator).click();
	        Thread.sleep(500);
	        WebElement codeInput = driver.findElement(locator);
	        codeInput.clear();
	        codeInput.sendKeys(countryCode);
	        Thread.sleep(500);
	        driver.findElement(locator).click();
	        Thread.sleep(1000);

	        phoneInput = driver.findElement(locator);
	        phoneInput.click();
	        Thread.sleep(500);

	        currentVal = phoneInput.getAttribute("value");
	    }

	    // Clear existing number
	    int charsToDelete = 0;
	    if (currentVal != null && currentVal.contains(" ")) {
	        String[] parts = currentVal.split(" ");
	        if (parts.length > 1) {
	            charsToDelete = parts[1].length();
	        }
	    }

	    for (int i = 0; i < charsToDelete; i++) {
	        phoneInput.sendKeys(Keys.BACK_SPACE);
	        Thread.sleep(50);
	    }

	    // Type new number (without country code)
	    String numberOnly = newNumber.replace(countryCode + " ", "").replace(countryCode, "");
	    phoneInput.sendKeys(numberOnly);
	    Thread.sleep(500);
	}
	
}
