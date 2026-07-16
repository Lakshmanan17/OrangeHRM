package stepdefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import orangeHRM_Page_Objects.Loginpage;
import orangeHRM_Utilities.Common_utils;
import orangeHRM_Webdriver_Manager.DriverManager;
import orangeHRM_constants.Constants;

public class Common_Step_definition {
	 
	private static String scenarioName=null;
	
	 public static String getScenarioName() {
		return scenarioName;
	}


	public static final Logger logger = Logger.getLogger(Common_Step_definition.class);
	
	
	@Before
	public void setup(Scenario scenario) {
		logger.info("Execution Started");
		try {
			scenarioName= scenario.getName();
		logger.info("Instantiated the commonUtils");
		
		Common_utils.getInstance().loadproperties();
		logger.info("loading the config properties file");
		
	   // Constants.BROWSER = "chrome"; // set browser here
	    logger.info("Checking the Driver is Null or Not?");            
					if(DriverManager.getDriver() ==null) {
					logger.info("Driver is Null. Instatiating it!");
					DriverManager.launchbrowser();
					if(DriverManager.getDriver() == null) {
						// provide a clear error instead of letting a NullPointerException happen later
						throw new RuntimeException("WebDriver was not created. Check that the browser binary is installed or the CHROME_BINARY_PATH in config.properties is correct.");
					}
					DriverManager.getDriver().manage().deleteAllCookies();
					DriverManager.getDriver().manage().window().maximize();
	    Common_utils.getInstance().initWebelements();
	    login();
	    }
	  
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	private void login() {
		// TODO Auto-generated method stub
		DriverManager.getDriver().get(Constants.APP_URL);
		Loginpage.getInstance().enterUserName(Constants.USERNAME);
		Loginpage.getInstance().enterPassword(Constants.PASSWORD);
		Loginpage.getInstance().clickLoginButton();
	}
	@AfterStep
	public void attach_screenshot(Scenario scenario) throws Throwable{

		if(scenario.isFailed()){
		final byte[] screenshot=((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "screenshot");

		}
		}
	
	
}
