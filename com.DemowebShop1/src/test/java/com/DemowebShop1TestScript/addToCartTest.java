package com.DemowebShop1TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.DemowebShop1.genericLibery.Base_Test;
import com.DemowebShop1.genericLibery.ExcelRead;
import com.DemowebShop1.pomRepo.Loginpage;
import com.DemowebShop1.pomRepo.ShoppingCartpage;
import com.DemowebShop1.pomRepo.Bookpage;
import com.DemowebShop1.pomRepo.homepage;
import com.DemowebShop1.pomRepo.welcomePage;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class addToCartTest  extends Base_Test{

	@Test(dataProvider = "addToCartData")
	
	public void TC_ShoppingCart_001(String email,String password) {
		welcomePage welcomePage=new welcomePage(driver);
		welcomePage.clicklogin();
		test.log(Status.INFO, "login page is displayed");
		Loginpage loginpage=new Loginpage(driver);
		loginpage.enterEmail(email);
		loginpage.enterpassword(password);
		loginpage.clickloginButton();
		homepage homepage=new homepage(driver);
		try {
			softassert.assertTrue(homepage.getLogoutLink().isDisplayed());
			if (homepage.getLogoutLink().isDisplayed()) 
			{
				test.log(Status.PASS, "user is successfully logged in");
				welcomePage.clickheaderBookLink();
				Bookpage bookpage=new Bookpage(driver);
				bookpage.clickcomptingAndInternetAddtoCartButton();
				bookpage.clickBannershoppingCartlink();
				ShoppingCartpage shoppingCartPage=new ShoppingCartpage(driver);
				softassert.assertTrue(shoppingCartPage.getShoppingCartFirstproductName().getText().contains("Computing and Internet"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "user is not logged in and product is not added to cart");
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenShotofPage(driver)).build());
					
			Reporter.log("user not logged in");
		}
	}
	@DataProvider(name="addToCartData")
	public String[][] addToCartDataProvider() throws EncryptedDocumentException, IOException{
		return ExcelRead.multipleRead("addTocart");
		
	}
}
