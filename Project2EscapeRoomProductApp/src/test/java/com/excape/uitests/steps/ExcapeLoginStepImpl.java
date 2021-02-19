package com.excape.uitests.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import com.excape.uitests.UITestRunner;
import com.excape.uitests.pages.ExcapeLogin;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExcapeLoginStepImpl {
	
	// Driver and Page
	public static WebDriver driver = UITestRunner.driver;
	public static ExcapeLogin login = UITestRunner.login;

	

	@Given("^The User is at the Excape Login Page$")
	public void the_User_is_at_the_Excape_Login_Page() {
		driver.get("file:///Users/DanielFelleman/revature/revature-projects/project2/frontend/login.html");
	}
	
	@When("^The User types in \"([^\"]*)\" and \"([^\"]*)\" and clicks log in button$")
	public void the_User_types_in_and_and_clicks_log_in_button(String username, String password) {
		// get element from page and enter in username and password
		login.usernameInput.sendKeys(username);
		login.passwordInput.sendKeys(password);
		login.loginButton.click();
	}
	
	@Then("^The title of the current page should be \"([^\"]*)\"$")
	public void the_title_of_the_current_page_should_be(String title) {
	    // check the title of the page
		assertEquals(title, driver.getTitle());
	}
	
	
	
}
