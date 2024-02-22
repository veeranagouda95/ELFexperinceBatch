package com.DemowebShop1.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.DemowebShop1.genericLibery.FrameWorklibeary;

public class Bookpage  extends Base_page{

	public Bookpage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//a[text()='Computing and Internet']/parent::h2/..//input")	
	private WebElement computingAndInternetAddtoCartButton;
	
	public void clickcomptingAndInternetAddtoCartButton() {
		computingAndInternetAddtoCartButton.click();
	}
	
	@FindBy(xpath = "//a[text()='Shopping cart']")
	private WebElement shoppingCartLinkAfterAddingProductToCart;
	
	public void clickBannershoppingCartlink() {
		shoppingCartLinkAfterAddingProductToCart.click();
	}
	
	
}
