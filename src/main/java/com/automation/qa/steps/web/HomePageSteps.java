package com.automation.qa.steps.web;
import com.automation.qa.utils.DriverUtils;
import cucumber.api.java.en.Given;
import org.testng.Assert;

import static com.automation.qa.utils.DriverUtils.getDriver;

public class HomePageSteps {

//    HomePage homePage = new HomePage();
    @Given("^Verify user on HomePage of application$")
    public void verifyUserOnHomePage() {
        Assert.assertTrue(true);
        getDriver().manage().window().maximize();
    }
}
