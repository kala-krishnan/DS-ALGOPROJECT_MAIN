package com.dsalgoproject.testrunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"pretty"},
		monochrome=false,  //console output color
		features = "src/test/resources/feature", //location of feature files
		glue= {"com.dsalgoproject.apphooks","com.dsalgoproject.stepdefinitions"} )

public class RunnerFile extends AbstractTestNGCucumberTests{
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
				
		return super.scenarios();
    }

}
