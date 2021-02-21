package com.excape.uitests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemDetail {
	
	// Driver
	WebDriver driver;
	
	// Page Elements
	
	@FindBy(id = "itemName")
	public WebElement header;
	
	@FindBy(id = "itemImage")
	public WebElement itemImage;
	
	@FindBy(xpath = "/html/body/div[3]/button")
	public WebElement addToCart;
	
	@FindBy(id = "itemQuantity")
	public WebElement quantity;
	
	// Constructor
	public ItemDetail(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

}
