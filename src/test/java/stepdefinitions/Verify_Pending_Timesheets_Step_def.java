package stepdefinitions;

import org.apache.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import orangeHRM_Page_Objects.HomePage;
import orangeHRM_Page_Objects.TimesheetPage;
import orangeHRM_Webdriver_Manager.DriverManager;

public class Verify_Pending_Timesheets_Step_def {
	 private static final Logger logger = Logger.getLogger(Verify_Pending_Timesheets_Step_def.class);
	@Given("user is on homepage")
	public void user_is_on_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	    String URL= DriverManager.getDriver().getCurrentUrl();
	    if(URL.contains("dashboard")) {
	    	logger.info("User is on HomePage");
	    }
	}

	@Given("the user clicks on the time option from the menu")
	public void the_user_clicks_on_the_time_option_from_the_menu() {
	    // Write code here that turns the phrase above into concrete actions
	   HomePage.getInstance().clickTime();
	}

	@Given("the user enter the name as {string}")
	public void the_user_enter_the_name_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		TimesheetPage.getInstance().enterEmployeeName(string);
		TimesheetPage.getInstance().viewName();
	}

	@Then("user should see the message as {string}")
	public void user_should_see_the_message_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		TimesheetPage.getInstance().getPersonName();
	}



}
