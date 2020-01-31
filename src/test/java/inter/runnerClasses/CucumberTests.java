package inter.runnerClasses;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"pretty"},
        glue = {"inter/glueCode"},
        features = {"src/test/features"})

public class CucumberTests {
}