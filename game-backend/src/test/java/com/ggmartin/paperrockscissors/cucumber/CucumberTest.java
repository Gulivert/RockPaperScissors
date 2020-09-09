package com.ggmartin.paperrockscissors.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = { "pretty",
		"json:target/cucumber-report.json" }, glue = { "com.ggmartin.paperrockscissors.cucumber" })
public class CucumberTest {
}