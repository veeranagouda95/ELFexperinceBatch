package com.DemowebShop1.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartpage  extends Base_page{

	public ShoppingCartpage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//table[@class='cart']/tbody/tr[1]/td[3]/a")
	WebElement shoppingCartFirstproductName;


	public WebElement getShoppingCartFirstproductName() {
		return shoppingCartFirstproductName;
	}


	public void setShoppingCartFirstproductName(WebElement shoppingCartFirstproductName) {
		this.shoppingCartFirstproductName = shoppingCartFirstproductName;
	}
	
}
