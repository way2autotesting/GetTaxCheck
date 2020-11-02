package com.CarTax.test.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Ibi on 01/11/2020.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/com/CarTax/test/features"},
        format = {"json:target/cucumber-json-report.json", "html:target/cucumber-report-html"},
        glue = {"com/CarTax/test/steps"}
        //, tags = "@Smoke"
)
public class CucumberRunnerWithJUit {
}
