package stepdefinitions;

import java.time.Duration;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import orangeHRM_Page_Objects.DirectoryPage;
import orangeHRM_Page_Objects.HomePage;
import orangeHRM_Page_Objects.Loginpage;
import orangeHRM_Webdriver_Manager.DriverManager;
import orangeHRM_constants.Constants;




public class VerifyCEOName_Step_Def {
	WebDriverWait wait = new WebDriverWait(
            DriverManager.getDriver(), Duration.ofSeconds(10));
	 private static final Logger logger = Logger.getLogger(DriverManager.class);
	@Given("the user is logged in successfully and is on home page")
	public void the_user_is_logged_in_successfully_and_is_on_home_page() {
		
		Loginpage.getInstance().enterUserName(Constants.USERNAME);
		Loginpage.getInstance().enterPassword(Constants.PASSWORD);
		Loginpage.getInstance().clickLoginButton();
		String url=DriverManager.getDriver().getCurrentUrl();

		if(url.contains("dashboard")){
		logger.info(" the user is logged in successfully and is on Home Page");
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
		HomePage.getInstance().clickDirectory();
		logger.info("the user clicks on the directory option from the menu bar");
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
		DirectoryPage.getInstance().selectJobTitle();
		
		DirectoryPage.getInstance().selectValue(jobtitle);
		
		logger.info("the user selects the job title as from the drop down");
	}

	@When("clicks the search button")
	public void clicks_the_search_button() {
	    // Write code here that turns the phrase above into concrete actions
		DirectoryPage.getInstance().clickSearch();
		logger.info("clicks the search button");
	}

	@Then("the user should see the CEO name as{string}")
	public void the_user_should_see_the_ceo_name_as_ceo_name(String Expectedname) {
	    // Write code here that turns the phrase above into concrete actions
		String actualname=DirectoryPage.getInstance().getPersonName();
		if(actualname.equalsIgnoreCase(Expectedname)) {
			logger.info("the user should see the CEO name as No record found");
		}
		
	}



}
