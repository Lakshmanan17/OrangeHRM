package stepdefinitions;

import org.apache.log4j.Logger;
import io.cucumber.java.Before;
import orangeHRM_Utilities.Common_utils;
import orangeHRM_Webdriver_Manager.DriverManager;
import orangeHRM_constants.Constants;

public class Common_Step_definition {
	 
	 public static final Logger logger = Logger.getLogger(Common_Step_definition.class);
	
	
	@Before
	public void setup() {
		logger.info("Execution Started");
		try {
		logger.info("Instantiated the commonUtils");
		
		Common_utils commonutils=new Common_utils();
		logger.info("loading the config properties file");
		commonutils.loadproperties();
	   // Constants.BROWSER = "chrome"; // set browser here
	    logger.info("Checking the Driver is Null or Not?");            
	    if(DriverManager.getDriver() ==null) {
	    logger.info("Driver is Null. Instatiating it!");
	    DriverManager.launchbrowser();
	    DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().manage().window().maximize();
	    DriverManager.getDriver().get(Constants.APP_URL);
	    Common_utils.initWebelements();
	    }
	  
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	
	
}
