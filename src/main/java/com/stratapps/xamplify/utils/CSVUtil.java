package com.stratapps.xamplify.utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class CSVUtil {

    public static String generateCSV(List<String[]> rows) {

        // ✅ NEW: Create date-based folder (e.g., 2025-06-16)
        String dateFolder = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        // ✅ NEW: Base directory for test-output/test-data/yyyy-MM-dd
        String basePath = System.getProperty("user.dir") + "/test-output/test-data/" + dateFolder;
        new File(basePath).mkdirs();  // ✅ Ensure directory exists

        // ✅ MODIFIED: File path includes date folder
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()); 
        File file = new File(basePath + "/test_data_" + timestamp + ".csv");

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            // Header
            writer.println("FIRSTNAME,LASTNAME,COMPANY,JOBTITLE,EMAILID,ADDRESS,CITY,STATE,ZIP CODE,COUNTRY,MOBILE NUMBER");

            // Data rows
            for (String[] row : rows) {
                writer.println(String.join(",", row));
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to generate CSV", e);
        }

        return file.getAbsolutePath();  // Full path of the generated CSV
    }
}
