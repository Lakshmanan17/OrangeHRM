package stepdefinitions;

import org.apache.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import orangeHRM_Page_Objects.AdminPage;

public class Verify_UserManagement_Step_def {
	private static final Logger logger= Logger.getLogger(Verify_UserManagement_Step_def.class);
	@Given("The user navigate to the admin page")
	public void the_user_navigate_to_the_admin_page() {
	    // Write code here that turns the phrase above into concrete actions
		try {
	    AdminPage.getInstance().clickAdmin();
	    logger.info("The user navigate to the admin page");
	}catch(Exception e) {
		logger.error(e);
	}
	}
	@When("the user enter the usernme as {string}")
	public void the_user_enter_the_usernme_as(String username) {
	    // Write code here that turns the phrase above into concrete actions
		try {
		AdminPage.getInstance().getUsername(username);
		logger.info("the user enter the usernme");
	}catch(Exception e) {
		logger.error(e);
	}
	}
	@When("the user select the user Role as {string}")
	public void the_user_select_the_user_role_as(String role) {
	    // Write code here that turns the phrase above into concrete actions
		try {
		AdminPage.getInstance().getUSERROLE(role);
		logger.info("the user select the user Role");
	}catch(Exception e) {
		logger.error(e);
	}
	}
	@When("the user enter Employee name as {string}")
	public void the_user_enter_employee_name_as(String empname) {
	    // Write code here that turns the phrase above into concrete actions
	try {	AdminPage.getInstance().getEmployeeName(empname);
	logger.info("the user enter Employee name ");
	}catch(Exception e) {
		logger.error(e);
	}
	}
	@When("the user select the status as {string}")
	public void the_user_select_the_status_as(String status) {
	    // Write code here that turns the phrase above into concrete actions
	try {	AdminPage.getInstance().getStatus(status);
	logger.info("the user select the status ");
	}catch(Exception e) {
		logger.error(e);
	}}

	@When("user click search button")
	public void user_click_search_button() {
	    // Write code here that turns the phrase above into concrete actions
		try {
		AdminPage.getInstance().clickSearch();
		logger.info("user click search button");
	}catch(Exception e) {
		logger.error(e);
	}
	}
	@Then("the user should see the admin page")
	public void the_user_should_see_the_admin_name_as() {
	    // Write code here that turns the phrase above into concrete actions
	   logger.info("user on the admin page");
	}

}
