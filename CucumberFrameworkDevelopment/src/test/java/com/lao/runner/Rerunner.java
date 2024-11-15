package com.lao.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/failed_scenarios.txt", glue = "com.lao.step_definitons", monochrome = true, dryRun = false)
public class Rerunner {

}
