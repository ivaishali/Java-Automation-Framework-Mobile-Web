package com.automation.qa.steps.common;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import static com.automation.qa.utils.DriverUtils.initDriver;
import static com.automation.qa.utils.DriverUtils.tearDown;

public class Hooks {

    @Before
    public void beforeScenario() {
        initDriver();
    }

    @After
    public void afterScenario() {
        tearDown();
    }
}
