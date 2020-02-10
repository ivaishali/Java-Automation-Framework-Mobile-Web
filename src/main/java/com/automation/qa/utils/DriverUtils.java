package com.automation.qa.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.automation.qa.utils.PropertyUtils.getPropertyByKey;
import static com.automation.qa.utils.PropertyUtils.loadProperties;

public class DriverUtils {

    static WebDriver driver = null;
    static AppiumDriverLocalService service = null;

    public static void initDriver() {
        loadProperties();
        if (getPropertyByKey("automation.platform").equalsIgnoreCase("web")) {
            launchWebDriver();
        } else {
            try {
                launchMobileDriver();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void launchWebDriver() {
        if (getPropertyByKey("driver.name").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(getPropertyByKey("base.url"));
    }

    public static void launchMobileDriver() throws MalformedURLException {
        if (getPropertyByKey("mobile.platform").equalsIgnoreCase("iOS")) {
//            URL hostUrl = getAppiumDriverLocalService().getUrl();
            final DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", getPropertyByKey("mobile.caps.deviceName"));
            capabilities.setCapability(CapabilityType.PLATFORM_NAME, getPropertyByKey("mobile.caps.platformName"));
            capabilities.setCapability("platformVersion", getPropertyByKey("mobile.caps.platformVersion"));

            if (getPropertyByKey("mobile.platform").equalsIgnoreCase("iOS")) {
                capabilities.setCapability("bundleId", getPropertyByKey("mobile.caps.bundleId"));
                driver = new IOSDriver<WebElement>(new URL(getPropertyByKey("server.host.url")), capabilities);
            } else {
                capabilities.setCapability("appPackage", "com.android.settings");
                capabilities.setCapability("appActivity", ".Settings");
                driver = new AndroidDriver<WebElement>(new URL(getPropertyByKey("server.host.url")), capabilities);
            }

//            driver = new RemoteWebDriver(new URL(getPropertyByKey("server.host.url")), capabilities);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
    }

    public static void tearDown() {
        if (getPropertyByKey("automation.platform").equalsIgnoreCase("web")) {
            getDriver().quit();
        } else {
            tearDownAppiumServer();
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static AppiumDriverLocalService getAppiumDriverLocalService() {
        if (service == null) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;
    }

    public static void tearDownAppiumServer() {
        service = getAppiumDriverLocalService();
        service.stop();
    }
}
