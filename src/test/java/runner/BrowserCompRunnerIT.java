package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "resources\\features" }, glue = { "stepdefs", "utils" },
tags={"@dashboard "},
//tags={"@downloadreportingMsg"},
//tags={"@downloadreport"},
//tags={"@Messages"},
//tags={"@OADreport"},
//tags = {"@fundTransfer" },
//tags={"@collections"},
//tags={"@transactionlist"},
plugin = { "html:target/cucumber-html-report" }, monochrome = true)
public class BrowserCompRunnerIT {

}