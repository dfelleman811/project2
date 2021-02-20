package com.excape.uitests.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excape.uitests.UITestRunner;
import com.excape.uitests.pages.ItemDetail;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ItemToCartStepImpl {
	
	public WebDriver driver = UITestRunner.driver;
	public ItemDetail itemPage = UITestRunner.itemPage;
	
	
	@Given("^the user is on the item detail page$")
	public void the_user_is_on_the_item_detail_page() {
		driver.get("file:///Users/DanielFelleman/revature/revature-projects/project2/frontend/item.html?id=11");
	}

	@When("^the user clicks add to cart$")
	public void the_user_clicks_add_to_cart() {
		itemPage.quantity.clear();
		itemPage.quantity.sendKeys(Keys.NUMPAD2);
		itemPage.addToCart.click();
	}

	@Then("^the user is on the shopping cart page$")
	public void the_user_is_on_the_shopping_cart_page() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("Excape - Shopping Cart", driver.getTitle());
	}

	@Then("^the cart has the item in it$")
	public void the_cart_has_the_item_in_it() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebElement quantity = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr[2]/td[3]"));
		assertEquals(2, Integer.parseInt(quantity.getText()));
	}


}
