package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import orangeHRM_Page_Objects.AdminPage;

public class Verify_UserManagement_Step_def {
	@Given("The user navigate to the admin page")
	public void the_user_navigate_to_the_admin_page() {
	    // Write code here that turns the phrase above into concrete actions
	    AdminPage.getInstance().clickAdmin();
	}

	@When("the user enter the usernme as {string}")
	public void the_user_enter_the_usernme_as(String username) {
	    // Write code here that turns the phrase above into concrete actions
		AdminPage.getInstance().getUsername(username);
	}

	@When("the user select the user Role as {string}")
	public void the_user_select_the_user_role_as(String role) {
	    // Write code here that turns the phrase above into concrete actions
		AdminPage.getInstance().getUSERROLE(role);
	}

	@When("the user enter Employee name as {string}")
	public void the_user_enter_employee_name_as(String empname) {
	    // Write code here that turns the phrase above into concrete actions
		AdminPage.getInstance().getEmployeeName(empname);
	}

	@When("the user select the status as {string}")
	public void the_user_select_the_status_as(String status) {
	    // Write code here that turns the phrase above into concrete actions
		AdminPage.getInstance().getStatus(status);
	}

	@When("user click search button")
	public void user_click_search_button() {
	    // Write code here that turns the phrase above into concrete actions
		AdminPage.getInstance().clickSearch();
	}

	@Then("the user should see the admin page")
	public void the_user_should_see_the_admin_name_as() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("user on the admin page");
	}

}
