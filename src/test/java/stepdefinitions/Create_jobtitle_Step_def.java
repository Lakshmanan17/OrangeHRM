package stepdefinitions;


import org.apache.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import orangeHRM_Page_Objects.Job_titlePage;

public class Create_jobtitle_Step_def {
	private static final Logger logger= Logger.getLogger(Create_jobtitle_Step_def.class);
	
	
	@Given("The User click the job dropdown")
	public void the_user_click_the_job_dropdown() {
	    // Write code here that turns the phrase above into concrete actions
	   try { Job_titlePage.getInstance().clickJob();
	   logger.info("The User click the job dropdown");
	   }catch(Exception e) {
		   logger.error(e);
		   
	   }
	}
	@Given("select to the job Title page")
	public void select_to_the_job_title_page() {
	    // Write code here that turns the phrase above into concrete actions
		
		try{Job_titlePage.getInstance().selectJobTitle();
		logger.info("select to the job Title page");
		}catch(Exception e) {
			logger.error(e);
		}
	}
	@Given("User click the Add button to create job title")
	public void user_click_the_add_button_to_create_job_title() {
	    // Write code here that turns the phrase above into concrete actions
		try{
			Job_titlePage.getInstance().clickAdd();
			logger.info("User click the Add button to create job title");
		}catch(Exception e) {
			logger.error(e);
		}
	}
	@When("Enter the job title as {string}")
	public void enter_the_job_title_as(String jobtitle) {
	    // Write code here that turns the phrase above into concrete actions
		try {
		Job_titlePage.getInstance().enterJobTitleName(jobtitle);
		logger.info("Enter the job title");
	}catch(Exception e) {
		logger.error(e);
	}
	}
	@When("Enter the job description as {string}")
	public void enter_the_job_description_as(String description) {
	    // Write code here that turns the phrase above into concrete actions
		try {
		Job_titlePage.getInstance().enterJobDescription(description);
		logger.info("Enter the job description");
	}catch(Exception e) {
		logger.error(e);
	}
		
	}
	@Then("Upload job specification file")
	public void upload_job_specification_file() {
	    // Write code here that turns the phrase above into concrete actions
		try{
			Job_titlePage.getInstance().enterJobSpecification_file();
			logger.info("Upload job specification file");
			
		}catch(Exception  e) {
			logger.error(e);
		}
	}
	@Then("Enter the note as {string}")
	public void enter_the_note_as(String note) {
	    // Write code here that turns the phrase above into concrete actions
		try{
			Job_titlePage.getInstance().enterNotes(note);
			logger.info("Enter the note ");
		}catch(Exception e) {
			logger.error(e);
		}
	}
	@Then("User click the save button")
	public void user_click_the_save_button() {
	    // Write code here that turns the phrase above into concrete actions
		try {
		Job_titlePage.getInstance().clickSaves();
		logger.info("User click the save button");
	}catch(Exception e) {
		logger.error(e);
	}
		
}
}
