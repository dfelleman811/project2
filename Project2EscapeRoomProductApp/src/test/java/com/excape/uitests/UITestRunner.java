package com.excape.uitests;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excape.uitests.pages.ExcapeLogin;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "com.excape.uitests.steps")
public class UITestRunner {

	// Selenium Driver
	public static WebDriver driver;
	
	// Pages
	public static ExcapeLogin login;
	
	
	// Test set up
	@BeforeClass
	public static void setUp() {
		File file = new File("src/test/resources/chromedriver");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		login = new ExcapeLogin(driver);
	}
	
	// Tear Down
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	
	
	
}
