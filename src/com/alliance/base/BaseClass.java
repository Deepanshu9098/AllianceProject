package com.alliance.base;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseClass {

	public static WebDriver driver;
	public static String browerName = PropertyClass.browser;
	
	//To open browser 
	public static WebDriver initialization() {
				  
	if(browerName.equals("chrome")) {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation\\Selenium 06022020\\All selenium SW\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();

	   } else if(browerName.equals("firefox")) {
		   
		   System.setProperty("webdriver,geckodriver,driver", 
				   "D:\\Selenium 06022020\\All selenium SW\\geckodriver.exe");
		   
		   driver = new FirefoxDriver();	   
	   }
	
	   driver.manage().window().maximize();
	  // driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TIMEOUT,TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   driver.get(PropertyClass.url);
	   
	   return driver;
		
	}	
}