package orangeHRM_Utilities;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import orangeHRM_Page_Objects.DirectoryPage;
import orangeHRM_Page_Objects.HomePage;
import orangeHRM_Page_Objects.Loginpage;
import orangeHRM_Webdriver_Manager.DriverManager;
import orangeHRM_constants.Constants;


public class Common_utils {

    

    public void loadproperties() {
    	
            Properties properties = new Properties();
            try {
            properties.load(getClass().getResourceAsStream("/config.properties"));           
            }
            catch (IOException e) {         
                e.printStackTrace();
               
            }
            
           
                Constants.BROWSER = properties.getProperty("BROWSER");
                Constants.APP_URL = properties.getProperty("APP_URL");
                Constants.USERNAME = properties.getProperty("UserName");
                Constants.PASSWORD = properties.getProperty("Password");
                Constants.CHROME_DRIVER_LOCATION = properties.getProperty("CHROME_DRIVER_LOCATION");
                Constants.FIREFOX_DRIVER_LOCATION = properties.getProperty("FIREFOX_DRIVER_LOCATION");
                Constants.EDGE_DRIVER_LOCATION = properties.getProperty("EDGE_DRIVER_LOCATION");
                
           
            }
    public static void initWebelements() {
            PageFactory.initElements(DriverManager.getDriver(),Loginpage.getInstance()); 
             PageFactory.initElements(DriverManager.getDriver(),HomePage.getInstance());
             PageFactory.initElements(DriverManager.getDriver(),DirectoryPage.getInstance());
        }
}

   

