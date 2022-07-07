package com.magicbricks_runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true, 
		junit= "--step-notifications",
		plugin = {"pretty","html:target/html-reports/report.html","json:target/cucumber.json","junit:target/Cucumber.xml"},
		features="Feature",
		glue={"com.magicbrics_step_definitions"},
		tags={"@MagicBricks"}	
		)

public class MagicBricks_Runner{ //extends AbstractTestNGCucumberTests{
//	@DataProvider(parallel = true)

//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
//
//    @AfterSuite
//    public void teardown() {
//        SetupDriver.teardown();
//    }

}

