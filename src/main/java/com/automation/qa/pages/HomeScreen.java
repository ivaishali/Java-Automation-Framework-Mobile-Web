package com.automation.qa.pages;



import com.automation.qa.annotations.FindBy;
import com.automation.qa.utils.PropertyUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.automation.qa.utils.DriverUtils.getDriver;
import static com.automation.qa.utils.PropertyUtils.getPropertyByKey;
import static com.automation.qa.utils.WaitUtils.waitForVisible;

public class HomeScreen {
    public HomeScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @AndroidFindBy(xpath = "//*[@alt='My Store']")
    @iOSXCUITFindBy(id = "getStartedButton")
    private MobileElement logoImg;

    @AndroidFindBy(xpath = "//*[@alt='My Store']")
    @iOSXCUITFindBy(id = "getStartedButton")
    private MobileElement getStartedBtn;

    public void verifyHomeScreen() {
        waitForVisible("getStartedButton");
        Assert.assertTrue(getStartedBtn.isDisplayed());
        getStartedBtn.click();
    }
}
