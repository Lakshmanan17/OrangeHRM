package orangeHRM_Page_Objects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import orangeHRM_Webdriver_Manager.DriverManager;

public class Job_titlePage {
	WebDriverWait wait= new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(20));
private static Job_titlePage jobtitleInstance;
private Job_titlePage() {}
public static Job_titlePage getInstance() {
	if(jobtitleInstance==null) {
		jobtitleInstance=new Job_titlePage();
	}
	return jobtitleInstance;
}

@FindBy(xpath="//span[text()='Job ']")
public  WebElement JOB;

@FindBy(xpath="//a[text()='Job Titles']")
public  WebElement JOBTITLE;

@FindBy(xpath="//button[text()=\" Add \"]")
public  WebElement ADD;

@FindBy(xpath="//div[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")
public  WebElement JOBTITLENAME;


@FindBy(xpath="//div[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea")
public  WebElement JOBDESCRIPTION;


@FindBy(xpath="//div[text()='Browse']")
public  WebElement JOBSPEC_FILE;

@FindBy(xpath="//div[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[2]/textarea")
public  WebElement NOTES;

@FindBy(xpath="//button[@type='submit']")
public  WebElement SAVES;

public void clickJob() {
	wait.until(ExpectedConditions.visibilityOf(JOB));
	JOB.click();
}
public void selectJobTitle() {
	wait.until(ExpectedConditions.visibilityOf(JOBTITLE));
	JOBTITLE.click();
}

public void clickAdd() {
	wait.until(ExpectedConditions.visibilityOf(ADD));
	ADD.click();
}
public void enterJobTitleName(String jobtitle) {
	wait.until(ExpectedConditions.visibilityOf(JOBTITLENAME));
	JOBTITLENAME.sendKeys(jobtitle);
}

public void enterJobDescription(String jobdescription) {
	wait.until(ExpectedConditions.visibilityOf(JOBDESCRIPTION));
	JOBDESCRIPTION.sendKeys(jobdescription);
}

public void enterJobSpecification_file() {
	wait.until(ExpectedConditions.visibilityOf(JOBSPEC_FILE));
	JOBSPEC_FILE.sendKeys("C:\\Users\\Lakshmanan\\OneDrive\\Desktop\\Carrier_info.txt");
}

public void enterNotes(String notes) {
	wait.until(ExpectedConditions.visibilityOf(NOTES));
	NOTES.sendKeys(notes);
}
public void clickSaves() {
	wait.until(ExpectedConditions.visibilityOf(SAVES));
	SAVES.click();
}
}
