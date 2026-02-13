package orangeHRM_Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags="",
		features= {"src/test/resources/Featurefiles"},
		glue= {"stepdefinitions"},
		dryRun= false,
		monochrome= true,
		plugin = {"pretty","html:report/WebReport","json:report/jsonreport.json" }
		 
		
		)

public class Job_runner extends AbstractTestNGCucumberTests {

}
 