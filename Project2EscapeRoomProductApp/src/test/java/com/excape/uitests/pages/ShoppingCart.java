package com.excape.uitests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
	
	public WebDriver driver;

	
	@FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr[2]/td[3]")
	public WebElement quantity;
	
	@FindBy(xpath = "/html/body/div/div[3]/button[1]")
	public WebElement checkout;
	
	@FindBy(xpath = "/html/body/div/div[3]/button[2]")
	public WebElement emptyCart;
	
	
	// Constructor
	public ShoppingCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
