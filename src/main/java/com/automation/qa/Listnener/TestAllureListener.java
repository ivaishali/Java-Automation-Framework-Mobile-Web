package com.automation.qa.Listnener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.reporters.jq.Model;

import static com.automation.qa.utils.DriverUtils.getDriver;

public class TestAllureListener implements ITestListener {

    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] saveScreenShotAsPNG(WebDriver driver) {
        return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test fails "+ getTestMethodtName(iTestResult));
        Object testClass = iTestResult.getInstance();
        WebDriver driver = getDriver();
        if (driver instanceof WebDriver) {
            saveScreenShotAsPNG(driver);
        }

    }

    private String getTestMethodtName(ITestResult iTestResult) {
        return iTestResult.getTestName();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
