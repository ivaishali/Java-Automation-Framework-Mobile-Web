package com.automation.qa.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.automation.qa.utils.DriverUtils.*;

public class Hooks {

    @BeforeSuite
    public void beforeScenario() {
        initDriver();
    }

    @AfterSuite
    public void afterScenario() {
        tearDown();
    }
}
