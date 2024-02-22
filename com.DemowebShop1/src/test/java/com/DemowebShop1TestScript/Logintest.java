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

public class Logintest extends Base_Test{

	@Test (dataProvider="loginData")
	public void TC_Login_001(String email,String password) throws InterruptedException  {
		welcomePage welcomepage=new welcomePage(driver);
		welcomepage.clicklogin();
		Loginpage loginpage=new Loginpage(driver);
		loginpage.enterEmail(email);
		loginpage.enterpassword(password);
		loginpage.clickloginButton();
	
		
		homepage homepage=new homepage(driver);
		try {
			softassert.assertTrue(homepage.getLogoutLink().isDisplayed());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Reporter.log("user not logged in");
		}
			
	}
	@DataProvider(name="loginData")
		public String[][] loginDataProvider() throws EncryptedDocumentException, IOException{
			return ExcelRead.multipleRead("login");
		}
	}
	
	

