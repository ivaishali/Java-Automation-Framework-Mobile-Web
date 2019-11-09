package com.automation.qa.pages;

import com.automation.qa.utils.DriverUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automation.qa.utils.DriverUtils.*;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @AndroidFindBy(xpath = "//*[@alt='My Store']")
    @iOSXCUITFindBy(id = "getStartedButton")
    private WebElement getStartedBtn;

    public void verifyHomeScreen() {

    }
}
