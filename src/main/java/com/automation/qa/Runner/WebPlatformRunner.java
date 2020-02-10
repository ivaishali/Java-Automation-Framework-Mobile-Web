package com.automation.qa.Runner;

import com.automation.qa.Listnener.TestAllureListener;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Listeners;

@Listeners({TestAllureListener.class})
@CucumberOptions(tags = "@web", plugin = {"pretty", "html:target/cucumber-report",
        "json:target/cucumber.json"}, glue = {"com.automation.qa.steps.web", "com.automation.qa.steps.common"},
        features = "./src/test/Feature")

public class WebPlatformRunner extends AbstractTestNGCucumberTests {

}
