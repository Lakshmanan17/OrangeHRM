package stepdefinitions;

import java.time.Duration;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import orangeHRM_Page_Objects.DirectoryPage;
import orangeHRM_Page_Objects.HomePage;
import orangeHRM_Utilities.Common_utils;
import orangeHRM_Webdriver_Manager.DriverManager;




public class VerifyCEOName_Step_Def {
	//WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
	 private static final Logger logger = Logger.getLogger(VerifyCEOName_Step_Def.class);
	@Given("the user is logged in successfully and is on home page")
	public void the_user_is_logged_in_successfully_and_is_on_home_page() {
		try {
		
		String url=DriverManager.getDriver().getCurrentUrl();
		if(url.contains("dashboard")){
			logger.info(" the user is logged in successfully and is on Home Page");
			}
		}catch(Exception e) {
			logger.error(e);
			 //Common_utils.getInstance().takescreenshot();
		}
		
	}
	 
	/*  @Given("the user is logged in successfully and is on home page")
	 public void the_user_is_logged_in_successfully_and_is_on_home_page() {

	     DriverManager.getDriver().get(Constants.APP_URL);

	     Loginpage loginPage = new Loginpage();
	     PageFactory.initElements(DriverManager.getDriver(), loginPage);

	  

	     wait.until(ExpectedConditions.visibilityOf(loginPage.USERNAME))
	             .sendKeys(Constants.USERNAME);

	     loginPage.PASSWORD.sendKeys(Constants.PASSWORD);
	     loginPage.LOGIN_BUTTON.click();

	     wait.until(ExpectedConditions.urlContains("dashboard"));

	     logger.info("User logged in successfully and is on Home Page");
	 }
*/

	@When("the user clicks on the directory option from the menu bar")
	public void the_user_clicks_on_the_directory_option_from_the_menu_bar() {
	    // Write code here that turns the phrase above into concrete actions
		try {
		HomePage.getInstance().clickDirectory();
		logger.info("the user clicks on the directory option from the menu bar");
		}catch(Exception e) {
			logger.error(e);
			// Common_utils.getInstance().takescreenshot();
		}
	}
	 
	/* @When("the user clicks on the directory option from the menu bar")
	 public void the_user_clicks_on_the_directory_option_from_the_menu_bar() {

	     HomePage homePage = new HomePage();
	     PageFactory.initElements(DriverManager.getDriver(), homePage);

	     

	     wait.until(ExpectedConditions.elementToBeClickable(
	             homePage.directoryMenu)).click();

	     logger.info("User clicked on Directory menu");
	 }--*/


	@When("the user selects the job title as {string} from the drop down")
	public void the_user_selects_the_job_title_as_from_the_drop_down(String jobtitle) {
	    // Write code here that turns the phrase above into concrete actions
	/*	DirectoryPage directory= new DirectoryPage();
		PageFactory.initElements(DriverManager.getDriver(),directory);
		wait.until(ExpectedConditions.elementToBeClickable(
				DirectoryPage.JOB_TITLE)).click();
		
		
		Select select =new Select(DirectoryPage.JOB_TITLE);
		select.selectByVisibleText(jobtitle);
  */
		try {
		DirectoryPage.getInstance().selectJobTitle();
		
		DirectoryPage.getInstance().selectValue(jobtitle);
		
		logger.info("the user selects the job title as from the drop down");
		}catch(Exception e) {
			logger.error(e);
			// Common_utils.getInstance().takescreenshot();
		}
	}

	@When("clicks the search button")
	public void clicks_the_search_button() {
	    // Write code here that turns the phrase above into concrete actions
		try {
		DirectoryPage.getInstance().clickSearch();
		logger.info("clicks the search button");
		}catch(Exception e) {
			logger.error(e);
			 Common_utils.getInstance().takescreenshot();
		}
	}

	@Then("the user should see the CEO name as {string}")
	public void the_user_should_see_the_ceo_name_as(String expectedName) {

	   String actualName=DirectoryPage.getInstance().getPersonName();

	    //WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='row']//div[normalize-space()='" + expectedName + "']")));

	//    String actualName = nameElement.getText().trim();

	    Assert.assertEquals(actualName, expectedName);
	}

}