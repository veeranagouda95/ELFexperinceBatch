package com.DemowebShop1.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class homepage  extends  Base_page{

	public homepage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='header-links']//a[@class='account']")
	private WebElement loggedInEmailIDlink;
	
	public void clickEmailIdAccount() {
		loggedInEmailIDlink.click();
	}

	public WebElement getLoggedInEmailIDlink() {
		return loggedInEmailIDlink;
	}

	public void setLoggedInEmailIDlink(WebElement loggedInEmailIDlink) {
		this.loggedInEmailIDlink = loggedInEmailIDlink;
	}
	
	@FindBy(xpath = "//a[text()='Log out']")
	private WebElement logoutLink;

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public void setLogoutLink(WebElement logoutLink) {
		this.logoutLink = logoutLink;
	}
	
	public void clickLogoutLink() {
		logoutLink.click();
	}
}
