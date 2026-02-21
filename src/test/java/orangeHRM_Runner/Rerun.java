package orangeHRM_Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
tags="",
features= {"@failed_scenarios/failed_scenarios.txt"},
glue= {"stepdefinitions"},
dryRun= false,
monochrome= true
)
public class Rerun extends AbstractTestNGCucumberTests {

}
