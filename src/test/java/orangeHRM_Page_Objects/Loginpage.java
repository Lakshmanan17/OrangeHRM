package orangeHRM_Page_Objects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import orangeHRM_Webdriver_Manager.DriverManager;

public class Loginpage {
	WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10));
	
	private static Loginpage loginInstance;
	
	private Loginpage() {}
	public static Loginpage getInstance() {
		if(loginInstance==null) {
			loginInstance=new Loginpage();
		}
		return loginInstance;
	}
	
	@FindBy(name="username")
	public  WebElement USERNAME;
	@FindBy(name="password")
	public  WebElement PASSWORD;
	@FindBy(xpath="//button[@type='submit']")
	public  WebElement LOGIN_BUTTON;
	
	
	/*	
	public WebElement getUSERNAME() {
		return USERNAME;
	}
	public WebElement getPASSWORD() {
		return PASSWORD;
	}
	public WebElement getLOGIN_BUTTON() {
		return LOGIN_BUTTON;
	}
	*/
	public void enterUserName(String username) {
	   
	    wait.until(ExpectedConditions.visibilityOf(USERNAME));
	    USERNAME.sendKeys(username);
	}

	public void enterPassword(String password) {
		
		wait.until(ExpectedConditions.visibilityOf(PASSWORD));
		PASSWORD.sendKeys(password);
	}
	public void clickLoginButton() {
		wait.until(ExpectedConditions.visibilityOf(LOGIN_BUTTON));
		LOGIN_BUTTON.click();
	}

}
