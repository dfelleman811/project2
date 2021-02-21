package com.excape.uitests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excape.uitests.pages.ExcapeLogin;
import com.excape.uitests.pages.ItemDetail;
import com.excape.uitests.pages.NavigationBar;
import com.excape.uitests.pages.ShoppingCart;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "com.excape.uitests.steps")
public class UITestRunner {

	// Selenium Driver
	public static WebDriver driver;
	
	// Pages
	public static ExcapeLogin login;
	public static NavigationBar navBar;
	public static ItemDetail itemPage;
	public static ShoppingCart shopCart;
	
	
	// Test set up
	@BeforeClass
	public static void setUp() {
		File file = new File("src/test/resources/chromedriver");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		login = new ExcapeLogin(driver);
		navBar = new NavigationBar(driver);
		itemPage = new ItemDetail(driver);
		shopCart = new ShoppingCart(driver);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	// Tear Down
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	
	
	
}
