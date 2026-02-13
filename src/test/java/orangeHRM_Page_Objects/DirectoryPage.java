package orangeHRM_Page_Objects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import orangeHRM_Utilities.Common_utils;
import orangeHRM_Webdriver_Manager.DriverManager;

public class DirectoryPage {
	WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10));
	
	private static DirectoryPage directoryPageInstance;
	
	public DirectoryPage() {
		
	}
	public static DirectoryPage getInstance() {
		if(directoryPageInstance==null) {
			directoryPageInstance= new DirectoryPage();
		}
		return directoryPageInstance;
	}
	
	
	@FindBy(xpath="//div[contains(@class,'oxd-select-text')]")
	public WebElement JOB_TITLE;
	
	@FindBy(xpath="//div[@role='listbox']//span[text()='Chief Executive Officer']")
	public WebElement VALUE;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement SEARCH;
	
	@FindBy(xpath="//span[text()='No Records Found']")
	public WebElement NAME;

	/*public WebElement getJOB_TITLE() {
		return JOB_TITLE;
	}
	public WebElement getVALUE() {
		return VALUE;
	}
	public WebElement getSEARCH() {
		return SEARCH;
	}
	public WebElement getNAME() {
		return NAME;
	}
	*/
	
	public void selectJobTitle() {
		
		wait.until(ExpectedConditions.visibilityOf(JOB_TITLE));
		JOB_TITLE.click();
		
	}
	public void selectValue(String value) {
		
		wait.until(ExpectedConditions.visibilityOf(VALUE));
		VALUE.isSelected();
		
	}
	
	public void clickSearch() {
		Common_utils.getInstance().highlightElement(SEARCH);
		wait.until(ExpectedConditions.visibilityOf(SEARCH));
		SEARCH.click();
		
	}
	public String getPersonName() {
		
		return NAME.getText();
	}
	


}
