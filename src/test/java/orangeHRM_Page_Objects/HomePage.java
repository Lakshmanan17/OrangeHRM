package orangeHRM_Page_Objects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import orangeHRM_Webdriver_Manager.DriverManager;

public class HomePage {
	WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10));
	
	private static HomePage homePageInstance;
	public HomePage() {
		
	}
	public static HomePage getInstance() {
		if(homePageInstance==null) {
			homePageInstance=new HomePage();
		}
		return homePageInstance;
	}

    @FindBy(xpath = "//span[text()='Directory']")
    public WebElement directoryMenu;
    
    @FindBy(xpath="//span[text()='Time']")
    public WebElement TIME;
    
    
    
   /* 
	public WebElement getDirectoryMenu() {
		return directoryMenu;
	}*/
	public void clickDirectory() {
		wait.until(ExpectedConditions.visibilityOf(directoryMenu));
    	directoryMenu.click();
    }
    public void clickTime() {
    	wait.until(ExpectedConditions.visibilityOf(TIME));
    	TIME.click();
    }
}
