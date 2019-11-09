package com.automation.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertyUtils {
    static Properties prop = new Properties();
    private static List<File> fileList = new ArrayList<>();

    public static void loadProperties() {
        try {
            // load config.properties file
            prop.load(new FileInputStream(new File(System.getProperty("user.dir") + "/src/main/resources/config.properties")));

            // load locators properties
            File file = new File(System.getProperty("user.dir") + "/src/main/resources/locators");
            File[] files = file.listFiles();
            for (File f : files) {
                prop.load(new FileInputStream(f));
            }

            System.out.println(prop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyByKey(String key) {
        return prop.getProperty(key);
    }


    public static List<File> listingAllFiles(String directoryName, List<File> files) {
        File directory = new File(directoryName);

        // Get all files from a directory.
        File[] fList = directory.listFiles();
        if (fList != null)
            for (File file : fList) {
                if (file.isFile()) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    listingAllFiles(file.getAbsolutePath(), files);
                }
            }
        return files;
    }
}
