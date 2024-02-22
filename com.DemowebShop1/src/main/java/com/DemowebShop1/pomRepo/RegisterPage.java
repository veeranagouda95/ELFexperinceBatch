package com.DemowebShop1.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage  extends Base_page {

	public RegisterPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(id = "FirstName")
	private WebElement firstnametextfield;

	@FindBy(id = "LastName")
	private WebElement lastnametextfield;

	@FindBy(id="Email")
	private WebElement emailidfield;


	@FindBy(xpath = "//input[@id='gender-male']")
	private WebElement maleGenderRadioButton;

	public void clickmaleRadioButton() {
		maleGenderRadioButton.click();
	}


	@FindBy(xpath = "//input[@id='gender-female']")
	private  WebElement femaleGenderRadioButton;

	public void clickfemaleradiobutton() {
		femaleGenderRadioButton.click();
	}

	@FindBy(id="register-button")
	private WebElement registerButton;

	@FindBy(id="Password")
	private WebElement passwordtextfield;

	@FindBy(id = "ConfirmPassword")
	private WebElement confirmapasswordfield;

	
	public void enterLastName(String lastname) {
		lastnametextfield.sendKeys(lastname);
	}

	public void enterEmail(String email) 
	{
		emailidfield.sendKeys(email);
	}

	public void enterPassword(String password ) {
		passwordtextfield.sendKeys(password);
	}
	public void enterConfirmPassword(String confirmapassword) {
		confirmapasswordfield.sendKeys(confirmapassword);
	}

	public void clickRegisterButton() {
		registerButton.click();
	}
	public void enterFirstName(String firstname) {
		firstnametextfield.sendKeys(firstname);
		
	}

}
