package runnerClasses;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"./src/test/resources/Features/sample.feature", "./src/test/resources/Features/sample1.feature"},
                   tags = "@sanity and @smoke")
public class TestRunnerForTag {

}
