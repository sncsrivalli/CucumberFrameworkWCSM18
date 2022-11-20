package runnerClasses;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/Features/ActiTimeLoginPOM.feature", 
				glue = "stepDefinitions")

public class TestRunnerPOM {
	
}
