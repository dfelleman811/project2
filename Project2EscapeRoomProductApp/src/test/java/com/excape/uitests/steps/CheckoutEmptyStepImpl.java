package com.excape.uitests.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excape.uitests.UITestRunner;
import com.excape.uitests.pages.ShoppingCart;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckoutEmptyStepImpl {
	
	public WebDriver driver = UITestRunner.driver;
	public ShoppingCart shopCart = UITestRunner.shopCart;
	
	@Given("^the user is at the shopping cart page$")
	public void the_user_is_at_the_shopping_cart_page() {
		driver.get("file:///Users/DanielFelleman/revature/revature-projects/project2/frontend/cart.html");
	}

	@When("^the user clicks on checkout$")
	public void the_user_clicks_on_checkout() {
		shopCart.checkout.click();
	}

	@Then("^the title of the current page is Excape - Order Confirmation$")
	public void the_title_of_the_current_page_is_Excape_Order_Confirmation() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("Excape - Order Confirmation", driver.getTitle());
	}

	@When("^the user clicks on empty cart$")
	public void the_user_clicks_on_empty_cart() {
		shopCart.emptyCart.click();
		
	}

	@Then("^the cart is empty$")
	public void the_cart_is_empty() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<WebElement> quantity = driver.findElements(By.id("cartItems"));
		System.out.println(quantity);
		assertEquals(1, quantity.size());
	}

}
