package com.excape.uitests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExcapeLogin {
	
	// Driver
	public WebDriver driver;
	
	
	// Page elements
	@FindBy(id = "username")
	public WebElement usernameInput;
	
	@FindBy(id = "password")
	public WebElement passwordInput;
	
	@FindBy(id = "loginButton")
	public WebElement loginButton;
	
	// Constructor to build page
	public ExcapeLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

}
