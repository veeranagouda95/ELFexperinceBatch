package com.DemowebShop1.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage  extends Base_page{

	@FindBy(id="Email")
	WebElement emailTextBox;
	
	@FindBy(id="Password")
	WebElement passwordTextbox;
	
	
	public Loginpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@value='Log in']")
	WebElement loginbutton;
	
	public void enterEmail(String email) {
		emailTextBox.sendKeys(email);
	}
	
	public void enterpassword(String password) {
		passwordTextbox.sendKeys(password);
	}
	
	public void clickloginButton() {
		loginbutton.click();
	}
	
	
	
	
}
