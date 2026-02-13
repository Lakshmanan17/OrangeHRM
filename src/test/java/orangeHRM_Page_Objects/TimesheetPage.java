package orangeHRM_Page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimesheetPage {
	
	private static TimesheetPage TimesheetInstance;
	private TimesheetPage() {
		
	}
    public static TimesheetPage getInstance() {
    	if(TimesheetInstance==null) {
    		TimesheetInstance=new TimesheetPage();
    	}
    	return TimesheetInstance;
    	
    }
    
    @FindBy(xpath="//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active oxd-autocomplete-text-input--error']")
    public WebElement ENTEREMPOLYEENAME;
    
    @FindBy(xpath="//button[@type='submit']")
    public WebElement VIEW;
    
    @FindBy(xpath="//span[text()='No Records Found']")
	public WebElement NAME;
	
    
    public void enterEmployeeName(String employeename) {
    	ENTEREMPOLYEENAME.sendKeys(employeename);
    }
    
    public void viewName() {
    	VIEW.click();
    }
    
     public String getPersonName() {
		
		return NAME.getText();
	}
	
}
