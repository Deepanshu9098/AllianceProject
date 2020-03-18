package com.alliance.page;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage {

	@FindBy (id = "DashBoard")
	private WebElement dashboard;
	
//FX Page 	
	@FindBy (xpath = "//span[text() = 'FX Verification']")
	private WebElement fxVerification;
	
	@FindBy (xpath = "//a[contains(text(),'01100001904')]")
	private WebElement customerID;
	
//Loan Committee Page	
	@FindBy (xpath = "//span[@key = 'Loan Committee(Group Loans)']")
	private WebElement loanCommittee;

	@FindBy(xpath = "//a[contains(text(),'287')]")
	private WebElement groupCodeLoanCommittee;
	
	@FindBy (xpath = "//input[@value = 'DONE']")
	private WebElement doneOnMainWindow;
	
	String mainWindow;
	
	public void navigateToDashBoard() throws InterruptedException {
		
		dashboard.click();
		Thread.sleep(5000);
	}
	
//FX Page	
	public void navigateToFXVerificationTab() throws InterruptedException {
		fxVerification.click();
		Thread.sleep(2000);
	}
	
	public void navigateToFXPageByCustomerID(WebDriver driver) throws InterruptedException {
		
		mainWindow = driver.getWindowHandle();
		System.out.println("Mian Window  -->" + mainWindow);
		customerID.click();
		Thread.sleep(5000);
	    
		Set<String> otherWindow = driver.getWindowHandles();
		
		for(String handles : otherWindow) {
		
			if(!handles.equalsIgnoreCase(mainWindow)) {
				driver.switchTo().window(handles);
				Thread.sleep(3000);
			}
		}
	}

//Loan Committee Page
	
	public void clickOnLoanCommitteeHeader() throws InterruptedException {
		
		loanCommittee.click();
		Thread.sleep(3000);
	}
	
	public void navigateToLoanCommitteePageByGroupCode(WebDriver driver) throws InterruptedException {
		
		String mainWindoe = driver.getWindowHandle();
		
		groupCodeLoanCommittee.click();
		Thread.sleep(3000);
		
		Set<String> allwindow = driver.getWindowHandles();
		
		  for(String headle : allwindow) {
			 
			  if(!mainWindoe.equalsIgnoreCase(headle)) {
				driver.switchTo().window(headle);
				Thread.sleep(3000);
			}		
		} 
	}
	
//SwichTo Main Window
    public void navigateToMainWindow(WebDriver driver) throws InterruptedException {
		
		driver.close();
		Thread.sleep(5000);
		driver.switchTo().window(mainWindow);
		doneOnMainWindow.click();
		Thread.sleep(5000);
		dashboard.click();
		
	}
	
}








