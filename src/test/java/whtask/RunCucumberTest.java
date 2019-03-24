package whtask;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
                 glue = "whtask",
                 features = "src/test/resources/whtask/")
public class RunCucumberTest {
}