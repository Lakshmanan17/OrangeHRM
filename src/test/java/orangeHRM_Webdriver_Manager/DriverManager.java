package orangeHRM_Webdriver_Manager;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import orangeHRM_constants.Constants;

public class DriverManager {
	 private static final Logger logger = Logger.getLogger(DriverManager.class);

	private static WebDriver driver=null;
	
	
public static WebDriver getDriver() {
		return driver;
	}


public static void launchbrowser() {
		
		try {
         switch(Constants.BROWSER) {
         case "chrome":
         WebDriverManager.chromedriver().setup();	
         logger.info("Launching"+ Constants.BROWSER);
         driver= new ChromeDriver();
         break;
         case "firefox":
        	 WebDriverManager.firefoxdriver().setup();	
        	 logger.info("Launching"+ Constants.BROWSER);
             driver= new FirefoxDriver();
             break;
         case "opera":
        	 WebDriverManager.operadriver().setup();	
        	 logger.info("Launching"+ Constants.BROWSER);
 //       	 driver = new OperaDriver();
        	 break;
         case "edge":
        	 WebDriverManager.edgedriver().setup();
        	 logger.info("Launching"+ Constants.BROWSER);
        	 driver = new EdgeDriver();
             break;    
         }
         
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
