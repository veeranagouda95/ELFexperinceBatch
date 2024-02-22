package com.DemowebShop1.genericLibery;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Base_Test extends FrameWorklibeary
{
	 public  WebDriver driver;//if it mention static stale element refrence exception we get because it one copy have it
	
	 
	 
	 @BeforeSuite
	 public void reportcofig() {
		 ExtentSparkReporter sparkRepoter=new ExtentSparkReporter(EXTENT_PATH+name());
		 ExtentReports reports=new ExtentReports();
		 reports.attachReporter(sparkRepoter);
	 }
	@BeforeMethod
	public void browserSetup(Method method) throws IOException {
		
		testMethodName=method.getName();
		test=reports.createTest(testMethodName);
		if (getPropertyValue("browser").equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (getPropertyValue("browser").equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
		driver.get(getPropertyValue("url"));
		initObjects(driver);
		test.log(Status.INFO, "Browser is launched and URL is navigated");
	}

	@AfterMethod
	public void browserTearDown() {
		driver.quit();
		softassert.assertAll();
	}
	
	@AfterSuite
	public void reportFlush() {
		reports.flush();
	}
}
