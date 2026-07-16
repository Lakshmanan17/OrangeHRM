package orangeHRM_Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags="",
		features= {"src/test/resources/Featurefiles"},
		glue= {"stepdefinitions"},
		dryRun= false,
		monochrome= true,
		publish=true,
		plugin = {//"rerun:failed_scenarios/failed_scenarios.txt",
				//"pretty","html:report/WebReport","json:report/jsonreport.json",
				
				//"html:target/cucumber-reports/report.html"
				//"json:target/cucumber-reports/report.json"
				//"testng:target/cucumber-reports/report.xml"
				//"io.qameta.allure.cucumber7jvm.AllureCucumberJvm",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}
		 
		
		)

public class Job_runner extends AbstractTestNGCucumberTests {

}
 