package com.automation.qa.Runner;


import com.automation.qa.Listnener.TestAllureListener;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Listeners;

import static com.automation.qa.utils.DriverUtils.initDriver;
import static com.automation.qa.utils.DriverUtils.tearDown;

@Listeners({TestAllureListener.class})
//@RunWith(Cucumber.class)
@CucumberOptions(tags = "@smoke", plugin = {"pretty", "html:target/cucumber-report",
        "json:target/json-cucumber-report"}, glue = "com.automation.qa.steps.mobile",
        features = "./src/test/Feature/LoginScnearios.feature")

public class AndroidMobileRunner extends AbstractTestNGCucumberTests {

    @Before
    public void beforeScenario() {
        initDriver();
    }

    @After
    public void afterScenario() {
        tearDown();
    }
}
