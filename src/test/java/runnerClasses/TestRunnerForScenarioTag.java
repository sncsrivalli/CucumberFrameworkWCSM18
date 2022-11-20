package runnerClasses;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/Features/tags.feature", 
				tags = "(@sanity or @regression) and not @smoke")
public class TestRunnerForScenarioTag {

}
