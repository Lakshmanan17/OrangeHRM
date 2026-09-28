package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import orangeHRM_Page_Objects.Loginpage;
import orangeHRM_Webdriver_Manager.DriverManager;
import orangeHRM_constants.Constants;

public class Verify_Valid_Login_Step_Def {

	@Given("the user opens the OrangeHRM login page")
	public void the_user_opens_the_orange_hrm_login_page() {
		DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().get(Constants.APP_URL);
		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(Loginpage.getInstance().USERNAME));
	}

	@When("the user logs in with the configured valid credentials")
	public void the_user_logs_in_with_the_configured_valid_credentials() {
		Loginpage loginPage = Loginpage.getInstance();
		loginPage.enterUserName(Constants.USERNAME);
		loginPage.enterPassword(Constants.PASSWORD);
		loginPage.clickLoginButton();
	}

	@Then("the user should be redirected to the dashboard")
	public void the_user_should_be_redirected_to_the_dashboard() {
		boolean redirectedToDashboard = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
				.until(ExpectedConditions.urlContains("dashboard"));
		Assert.assertTrue(redirectedToDashboard, "Valid credentials should redirect the user to the dashboard.");
	}
}
