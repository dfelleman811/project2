package com.excape.uitests.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excape.uitests.UITestRunner;
import com.excape.uitests.pages.ItemDetail;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ItemDetailStepImpl {
	
	public WebDriver driver = UITestRunner.driver;
	public ItemDetail itemPage = UITestRunner.itemPage;
	
	
	// when the user clicks on an item 
	//dot-to-dot xpath = //*[@id="decoder"]/div/a
	
	@Given("^the user is on the shop page$")
	public void the_user_is_on_the_shop_page(){
		driver.get("file:///Users/DanielFelleman/revature/revature-projects/project2/frontend/index.html");
		
	}

	@When("^the user clicks on an \"([^\"]*)\"$")
	public void the_user_clicks_on_an(String item) {	
		driver.manage().window().maximize();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		((WebElement) driver.findElement(By.cssSelector("#decoder > div > a")).getLocation()).click();
		
	}

	@Then("^the current page title should be \"([^\"]*)\"$")
	public void the_current_page_title_should_be(String title) {
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(title, driver.getTitle());
		
	}

	@Then("^the page header should be \"([^\"]*)\"$")
	public void the_page_header_should_be(String header) {
		
		assertEquals(header, itemPage.header);
		
	}

	@Then("^the item image should be \"([^\"]*)\"$")
	public void the_item_image_should_be(String image) {
		
		assertEquals(image, itemPage.itemImage.getAttribute("src"));
		
	}


}
