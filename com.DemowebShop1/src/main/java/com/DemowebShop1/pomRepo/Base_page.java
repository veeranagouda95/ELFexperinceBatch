package com.DemowebShop1.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.DemowebShop1.genericLibery.FrameWorklibeary;

public class Base_page  extends FrameWorklibeary{

	

	public Base_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
