package com.DemowebShop1.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class welcomePage extends Base_page {

	@FindBy(partialLinkText = "Log in")
	 private WebElement loginLink;
	
	public welcomePage(WebDriver driver) {
		super(driver);
	}
	public void clicklogin() {
		loginLink.click();
	}
	
	@FindBy(partialLinkText = "Register")
	private WebElement registerLink;
	
	public void clickOnRegisterLink()
	{
		registerLink.click();
	}
	
	@FindBy(partialLinkText = "Books")
	private WebElement headerBookLink;
	public void clickheaderBookLink() {
		headerBookLink.click();
	}
	
}
