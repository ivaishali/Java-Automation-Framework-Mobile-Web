package com.automation.qa.Runner;


import com.automation.qa.Listnener.TestAllureListener;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Listeners;

@Listeners({TestAllureListener.class})
@CucumberOptions(tags = "@smoke", plugin = {"pretty", "html:target/cucumber-report",
        "json:target/json-cucumber-report"}, glue = "com.automation.qa.steps",
        features = "./src/test/Feature/LoginScnearios.feature")

public class SmokeRunner extends AbstractTestNGCucumberTests {

}
