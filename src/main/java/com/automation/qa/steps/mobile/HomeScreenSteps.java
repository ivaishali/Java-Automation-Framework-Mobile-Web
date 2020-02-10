package com.automation.qa.steps.mobile;

import com.automation.qa.pages.HomeScreen;
import cucumber.api.java.en.Given;

public class HomeScreenSteps {
    HomeScreen homeScreen = new HomeScreen();

    @Given("^Verify user on HomePage$")
    public void verifyUserOnHomePage() {
        homeScreen.verifyHomeScreen();
    }

}
