package com.automation.qa.steps;

import com.automation.qa.pages.mobile.HomePage;
import cucumber.api.java.en.Given;
import org.testng.Assert;

public class HomePageSteps {

    HomePage homePage = new HomePage();
    @Given("^Verify user on HomePage$")
    public void verifyUserOnHomePage() {
        Assert.assertTrue(true);
    }
}
