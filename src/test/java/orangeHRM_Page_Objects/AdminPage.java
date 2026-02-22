package orangeHRM_Page_Objects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import orangeHRM_Webdriver_Manager.DriverManager;

public class AdminPage {
  WebDriverWait wait= new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10));
  private static AdminPage adminInstance;
  private AdminPage() {}
  public static AdminPage getInstance() {
	  if(adminInstance==null) {
		  adminInstance=new AdminPage();
	  }
	return adminInstance;
	  
  }
  
  @FindBy(xpath="//span[text()='Admin']")
  public WebElement ADMIN;
  
  @FindBy(xpath="//div[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
  public WebElement USERNAME;
  
  @FindBy(xpath="//div[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div")
  public WebElement USERROLE;
  
  @FindBy(xpath="//div[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input")
  public WebElement EMP_NAME;
  
  @FindBy(xpath="//div[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]")
  public WebElement STATUS;
  
  @FindBy(xpath="//div[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
  public WebElement SEARCH;



public void clickAdmin() {
	wait.until(ExpectedConditions.visibilityOf(ADMIN));
	ADMIN.click();
}

public void getUsername(String Username) {
	wait.until(ExpectedConditions.visibilityOf(USERNAME));
	USERNAME.sendKeys(Username);
}
public void getUSERROLE(String Userrole) {
	wait.until(ExpectedConditions.visibilityOf(USERROLE));
	USERROLE.isSelected();
}
public void getEmployeeName(String empname) {
	wait.until(ExpectedConditions.visibilityOf(EMP_NAME));
	EMP_NAME.sendKeys(empname);;
}

public void getStatus(String status) {
	wait.until(ExpectedConditions.visibilityOf(STATUS));
	STATUS.isSelected();
}

public void clickSearch() {
	wait.until(ExpectedConditions.visibilityOf(SEARCH));
	SEARCH.click();

}




}