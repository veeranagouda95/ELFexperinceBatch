package com.DemowebShop1.genericLibery;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class FrameWorklibeary  implements FrameworkConstants{

	
	public Actions action;
	public WebDriverWait wait;
	public SoftAssert softassert;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports reports;
	public ExtentTest test;
	public String testMethodName;
	
	
	public void SelectClass(WebElement dropDown,String option) {
		Select s=new Select(dropDown);
		int count=0;
		try {
			int indexvalue = Integer.parseInt(option);
			s.selectByIndex(indexvalue);
			count++;
			
		} catch (Exception e) {
	
			System.out.println("not and index value");
			
		}
		if (count==0) {
			
			try {
				s.selectByValue(option);
			} catch (Exception e) {
				s.selectByVisibleText(option);
				
			}
		}
	}
	
	
	public String  TakeScreenShotofPage(WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		String filePath=SCREENSHOT_PATH+name()+".png";
		 File dest = new File(filePath);
		File temp = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "."+filePath;
	}
	
	public void takeScreenShotofElement(WebElement element) {
		File temp=element.getScreenshotAs(OutputType.FILE);
		File dest=new File("SCREENSHOT_PATH"+name()+".png");
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	/**
	 * @return it return the data and time in
	 * the form of string
	 */
	public String name() {
		LocalDateTime datetime=LocalDateTime.now();
		String FileName=datetime.toString().replaceAll(":", "-");
		return FileName;
		
	}
	
	public String getPropertyValue(String key) throws IOException {
		
		File file=new File(PROPERTIES_PATH);
		FileInputStream fis=new FileInputStream(file);
		Properties pro=new Properties();
		pro.load(fis);
		return pro.getProperty(key);
		
	}
	
	public void initObjects(WebDriver driver) 
	{
		action=new Actions(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
		softassert=new SoftAssert();
	}
	
	public void scrollActionTillWebelement(WebElement element) {
		action.scrollToElement(element).build();
		
	}
	
}

