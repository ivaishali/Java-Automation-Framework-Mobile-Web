package com.automation.qa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.automation.qa.utils.DriverUtils.getDriver;
import static com.automation.qa.utils.PropertyUtils.getPropertyByKey;

public class WaitUtils {

    static WebDriverWait wait = new WebDriverWait(getDriver(), 20);

    public static void waitForVisible(String loc) {
        String locValue =loc;
        if (locValue.startsWith("id")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loc.replace("id=", "").trim())));
        } else if (locValue.startsWith("css")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loc.replace("css=", "").trim())));
        } else if (locValue.startsWith("xpath")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.replace("xpath=", "").trim())));
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loc)));
        }
    }

    public static void waitForSelect(String loc) {
        String locValue = getPropertyByKey(loc);
        if (locValue.startsWith("id")) {
            wait.until(ExpectedConditions.elementToBeSelected(By.id(loc.replace("id=", "").trim())));
        } else if (locValue.startsWith("css")) {
            wait.until(ExpectedConditions.elementToBeSelected(By.cssSelector(loc.replace("css=", "").trim())));
        } else if (locValue.startsWith("xpath")) {
            wait.until(ExpectedConditions.elementToBeSelected(By.xpath(loc.replace("xpath=", "").trim())));
        } else {
            wait.until(ExpectedConditions.elementToBeSelected(By.id(loc)));
        }
    }

    public static void waitForEnable(String loc) {
        String locValue = getPropertyByKey(loc);
        if (locValue.startsWith("id")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id(loc.replace("id=", "").trim())));
        } else if (locValue.startsWith("css")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(loc.replace("css=", "").trim())));
        } else if (locValue.startsWith("xpath")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.replace("xpath=", "").trim())));
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(By.id(loc)));
        }
    }

    public static void waitForNotVisible(String loc) {
        String locValue = getPropertyByKey(loc);
        if (locValue.startsWith("id")) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(loc.replace("id=", "").trim())));
        } else if (locValue.startsWith("css")) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loc.replace("css=", "").trim())));
        } else if (locValue.startsWith("xpath")) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(loc.replace("xpath=", "").trim())));
        } else {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(loc)));
        }
    }

    public static void waitForNotSelect(String loc) {
        String locValue = getPropertyByKey(loc);
        if (locValue.startsWith("id")) {
            wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.id(loc.replace("id=", "").trim()))));
        } else if (locValue.startsWith("css")) {
            wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.cssSelector(loc.replace("css=", "").trim()))));
        } else if (locValue.startsWith("xpath")) {
            wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.xpath(loc.replace("xpath=", "").trim()))));
        } else {
            wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.id(loc))));
        }
    }

    public static void waitForDisable(String loc) {
        String locValue = getPropertyByKey(loc);
        if (locValue.startsWith("id")) {
            wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.id(loc.replace("id=", "").trim()))));
        } else if (locValue.startsWith("css")) {
            wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.cssSelector(loc.replace("css=", "").trim()))));
        } else if (locValue.startsWith("xpath")) {
            wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath(loc.replace("xpath=", "").trim()))));
        } else {
            wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.id(loc))));
        }
    }
}
