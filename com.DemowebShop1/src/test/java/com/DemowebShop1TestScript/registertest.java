package com.DemowebShop1TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.DemowebShop1.genericLibery.Base_Test;
import com.DemowebShop1.genericLibery.ExcelRead;
import com.DemowebShop1.pomRepo.Loginpage;
import com.DemowebShop1.pomRepo.RegisterPage;
import com.DemowebShop1.pomRepo.homepage;
import com.DemowebShop1.pomRepo.welcomePage;

public class registertest extends Base_Test {

	
	@Test(dataProvider ="registerdata")
	public void TC_register_002(String gender,String firstname,String lastname,String email,String password,String confirmapassword) {
		welcomePage welcomePage=new welcomePage(driver);
		welcomePage.clickOnRegisterLink();
		RegisterPage registerpage=new RegisterPage(driver);
		if(gender.equalsIgnoreCase("M")) {
			registerpage.clickmaleRadioButton();
			
		}
		else if (gender.equalsIgnoreCase("F")) {
			registerpage.clickfemaleradiobutton();
			
		}
		else {
			Reporter.log("gender is not valid",true);
		}
		registerpage.enterFirstName(firstname);
		registerpage.enterLastName(lastname);
		registerpage.enterPassword(password);
		registerpage.enterEmail(email);
		registerpage.enterConfirmPassword(confirmapassword);
		registerpage.clickRegisterButton();
		
		homepage homepage=new homepage(driver);
		try {
			softassert.assertTrue(homepage.getLogoutLink().isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("user not registered");
		}	
}
	@DataProvider(name="registerdata")
	public String[][] registerDataProvider() throws EncryptedDocumentException, IOException {
		return ExcelRead.multipleRead("Register");
	}
}