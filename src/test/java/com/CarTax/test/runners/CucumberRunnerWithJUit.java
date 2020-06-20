package com.CarTax.test.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Ibi on 19/06/2020.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/com/dvla/test/features"},
        format = {"json:target/cucumber-json-report.json", "html:target/cucumber-report-html"},
        glue = {"com/dvla/test/steps"}
        //, tags = "@Test01"
)
public class CucumberRunnerWithJUit {
}
