package com.testPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataProvider {

    WebDriver driver;
	
	@BeforeTest
	
	public void startUpMethed() {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation\\Selenium 06022020\\All selenium SW\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.get("http://10.10.60.12:8008/");
	}


	@org.testng.annotations.DataProvider
	public Iterator<Object> getData() {

		 ArrayList<Object> testdata = ReadDataForDataProvider.getDataFromExcall();
		 return testdata.iterator();
	}
	
	
	@Test (dataProvider = "getData") 
	public void logInAndFillData(String username, String password) {

		driver.findElement(By.id("USER_CODE")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		System.out.println(username);
		
	}
	
	@AfterTest
	public void termDown() {
		//driver.findElement(By.id("BtnLogout")).click();
		//driver.quit();
			
	}
	
}
