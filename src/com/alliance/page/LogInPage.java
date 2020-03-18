package com.alliance.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LogInPage {

	@FindBy (id = "USER_CODE")
	private WebElement user_ID;
	
	@FindBy(id = "Password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@class=\"btn trans\"]")
	private WebElement login_button;
	
	@FindBy(id = "BASE_BR_CD")
	private WebElement branch;
		
	@FindBy(id = "BtnLogout")
	private WebElement logOut;
	
	public void login_Application(String userID, String userpassword) throws IOException {
		
		user_ID.sendKeys(userID);
		password.sendKeys(userpassword);
		
		Select branchid = new Select(branch) ;
		branchid.selectByVisibleText("011 - Sagaing");
		login_button.click();		
	}
	
	 public void logOutFromApplication() throws InterruptedException{
	    	Thread.sleep(5000);
	    	logOut.click();
	    }
}
