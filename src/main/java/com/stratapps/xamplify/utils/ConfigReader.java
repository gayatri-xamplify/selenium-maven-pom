package com.stratapps.xamplify.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try {
            InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config/config.properties");
            if (input != null) {
                properties.load(input);
            } else {
                System.out.println("❌ config.properties not found in classpath!");
            }
        } catch (Exception e) {
            System.out.println("❌ Could not load config.properties: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            System.out.println("❌ Property not found for key: " + key);
        }
        return value;
    }
}
