package orangeHRM_Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import orangeHRM_Page_Objects.AdminPage;
import orangeHRM_Page_Objects.DirectoryPage;
import orangeHRM_Page_Objects.HomePage;
import orangeHRM_Page_Objects.Job_titlePage;
import orangeHRM_Page_Objects.Loginpage;
import orangeHRM_Webdriver_Manager.DriverManager;
import orangeHRM_constants.Constants;
import stepdefinitions.Common_Step_definition;


public class Common_utils {

	private static Common_utils commonUtilsInstance=null;
	private Common_utils() {
		
	}
	public static Common_utils getInstance() {
		if(commonUtilsInstance==null) {
			commonUtilsInstance=new Common_utils();
		}
		return commonUtilsInstance;
		
	}
    

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
    public void initWebelements() {
            PageFactory.initElements(DriverManager.getDriver(),Loginpage.getInstance()); 
             PageFactory.initElements(DriverManager.getDriver(),HomePage.getInstance());
             PageFactory.initElements(DriverManager.getDriver(),DirectoryPage.getInstance());
             PageFactory.initElements(DriverManager.getDriver(),AdminPage.getInstance());
             PageFactory.initElements(DriverManager.getDriver(),Job_titlePage.getInstance());
        }
    
    public void takescreenshot() {
    	File screenshot=((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
    	try {
    		FileUtils.copyFile(screenshot,new File(Common_Step_definition.getScenarioName()+".png" ));
    	}catch(IOException e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    public void highlightElement(WebElement element) {
    	JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    	js.executeScript("arguments[0].setAttribute('style','border: 3px solid red');", element);

    }
    
    
    
}

   

