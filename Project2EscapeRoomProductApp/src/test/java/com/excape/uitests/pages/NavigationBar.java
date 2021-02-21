package com.excape.uitests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBar {
	
	// Driver
	WebDriver driver;
	
	// Page Elements (NavBarItem)
	@FindBy(xpath = "/html/body/nav/div/a")
	public WebElement excape;
	
	@FindBy(xpath = "//*[@id=\"navbarResponsive\"]/ul/li[1]/a")
	public WebElement shop;
	
	@FindBy(xpath = "//*[@id=\"navbarResponsive\"]/ul/li[2]/a")
	public WebElement aboutUs;
	
	@FindBy(xpath = "//*[@id=\"navbarResponsive\"]/ul/li[3]/a")
	public WebElement login;
	
	@FindBy(xpath = "//*[@id=\"navbarResponsive\"]/ul/li[4]/a")
	public WebElement register;
	
	@FindBy(xpath = "//*[@id=\"navbarResponsive\"]/ul/li[5]/a")
	public WebElement cart;
	
	
	// Constructor
	public NavigationBar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
