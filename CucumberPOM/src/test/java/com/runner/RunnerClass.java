package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"./src/test/resources/com/features"},  //feature file path..
		glue = {"com.stepdefinition" , "com.hooks"  },//step definition package
	//	tags = "@All ",
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
			
				}
				
	//	publish = true
				)



public class RunnerClass {

}
