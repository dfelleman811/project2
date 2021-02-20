package com.excape.uitests.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excape.uitests.UITestRunner;
import com.excape.uitests.pages.NavigationBar;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NavBarStepImpl {
	
	// Instantiate page and driver
	public WebDriver driver = UITestRunner.driver;
	public NavigationBar navBar = UITestRunner.navBar;
	
	@Given("^the user is at the Excape index page$")
	public void the_user_is_at_the_Excape_index_page() {
		driver.get("file:///Users/DanielFelleman/revature/revature-projects/project2/frontend/index.html");
	}

	@When("^the user clicks on Excape$")
	public void the_user_clicks_on_Excape() {
		navBar.excape.click();
	}

	@Then("^the title of the current page should be Excape - Escape Room Supplies$")
	public void the_title_of_the_current_page_should_be_Excape_Escape_Room_Supplies() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals("Excape - Escape Room Supplies", driver.getTitle());
	}

	@When("^the user clicks on the Shop$")
	public void the_user_clicks_on_the_Shop() {
		navBar.shop.click();
	}

	@Then("^the title of the current page should be Excape - Excape Room Supplies$")
	public void the_title_of_the_current_page_should_be_Excape_Excape_Room_Supplies() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals("Excape - Escape Room Supplies", driver.getTitle());
	}

	@When("^the user clicks on the About Us$")
	public void the_user_clicks_on_the_About_Us() {
		navBar.aboutUs.click();
	}

	@Then("^the title of the current page should be Excape - About Us$")
	public void the_title_of_the_current_page_should_be_Excape_About_Us() throws Throwable {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals("Excape - About Us", driver.getTitle());
	}

	@When("^the user clicks on the Login$")
	public void the_user_clicks_on_the_Login() {
		navBar.login.click();
	}

	@Then("^the title of the current page should be Excape - Log In$")
	public void the_title_of_the_current_page_should_be_Excape_Log_In() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals("Excape - Log In", driver.getTitle());
	}

	@When("^the user clicks on the Register$")
	public void the_user_clicks_on_the_Register() {
		navBar.register.click();
	}

	@Then("^the title of the current page should be Excape - Registration$")
	public void the_title_of_the_current_page_should_be_Excape_Registration() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals("Excape - Registration", driver.getTitle());
	}

	@When("^the user clicks on the Cart$")
	public void the_user_clicks_on_the_Cart() {
		navBar.cart.click();
	}

	@Then("^the title of the current page should be Excape - Shopping Cart$")
	public void the_title_of_the_current_page_should_be_Excape_Shopping_Cart() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals("Excape - Shopping Cart", driver.getTitle());
	}
	

}
