package com.lao.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		glue = "com.lao.step_definitons" ,
		dryRun = false,
		monochrome = true,
		plugin	= {"rerun:target/failed_scenarios.txt" , "junit:target/cucumber-reports/report.xml",
				//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm", "pretty"},
		publish = true
		)

public class TestRunner {

}

