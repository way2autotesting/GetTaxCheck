package com.CarTax.test.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by Ibi on 01/11/2020.
 */
@CucumberOptions(features = {"src/test/java/com/CarTax/test/features"},
        format = {"json:target/cucumber.json", "html:target/cucumber-report-html",
                "html:target/site/cucumber-pretty"},
        glue = "com/CarTax/test/steps")
public class CucumberRunnerWithTestNG extends AbstractTestNGCucumberTests {
}
