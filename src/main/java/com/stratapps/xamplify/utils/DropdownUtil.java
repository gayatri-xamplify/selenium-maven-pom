package com.stratapps.xamplify.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtil {

    public static void selectByVisibleText(WebDriver driver, By locator, String text) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(text);
    }

    public static void selectByIndex(WebDriver driver, By locator, int index) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByIndex(index);
    }

    public static void selectByValue(WebDriver driver, By locator, String value) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByValue(value);
    }
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    
}
