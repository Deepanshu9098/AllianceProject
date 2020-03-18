package com.alliance.page;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class LoanAppicationPage { 

	@FindBy(id = "DashBoard")
	private WebElement dashbord ;

	@FindBy(xpath = "//span[@key = 'Loan Application']")
	private WebElement loanapplication;
	
	@FindBy(xpath = "//a[contains(text(),'01100001904')]")
	WebElement customerId;
	
	@FindBy(id = "LN_AMT")
	private WebElement loanamount;
	
	@FindBy(id = "TERM_MONTHS")
	private WebElement tenure;
	
	@FindBy(id = "LN_PURPOSE")
	private WebElement loanpurpose;
	
	@FindBy(id = "ITEMS_PROC_DESC_TMP")
	private WebElement itemsprocured;
	
	@FindBy(id = "COST_OF_ITEM_TMP")
	private WebElement costofitem;
	
	@FindBy(id = "BTN_ADD")
	private WebElement addbutton;
	
	@FindBy(xpath = "/html/body/div[3]/form/div[1]/div[3]/div/div/"
			+ "div[5]/div[3]/div/div[1]/div[1]/div[2]/"
			+ "div[4]/div/table/tbody/tr[1]/td[3]/input")
	private WebElement thapayaysavingamt;
	
	@FindBy(xpath = "/html/body/div[3]/form/div[1]/div[3]/div/div/"
			+ "div[5]/div[3]/div/div[1]/div[1]/div[2]/div[4]/div/table/"
			+ "tbody/tr[3]/td[3]/input")
	private WebElement sabesavingamount;
	
	@FindBy(xpath = "/html/body/div[3]/form/div[1]/div[3]/div/div"
			+ "/div[5]/div[3]/div/div[1]/div[1]/div[2]/div[4]/div/table"
			+ "/tbody/tr[3]/td[1]/input")
	private WebElement sabeacccheck;
	
	@FindBy (xpath = "/html/body/div[3]/form/div[1]/div[3]/div"
			+ "/div/div[5]/div[3]/div/div[1]/div[1]/div[2]/div[4]"
			+ "/div/table/tbody/tr[4]/td[1]/input")
	private WebElement paduakTermDepositCheck;
	
	@FindBy (xpath = "/html/body/div[3]/form/div[1]/div[3]/div/div"
			+ "/div[5]/div[3]/div/div[1]/div[1]/div[2]/div[4]/div"
			+ "/table/tbody/tr[4]/td[3]/input")
	private WebElement paduakTermDepositamount;
	
	@FindBy (xpath = "//input[@value = 'DONE']")
	private WebElement doneOnMainWindow;
	
	@FindBy (id = "CREATE")
	private WebElement submit;
	

	String mainwindow;
	
	public void navigateToDashbord() throws InterruptedException {
	dashbord.click();
	Thread.sleep(3000);
	}
	
	public void navigateToLoanApplication() throws InterruptedException {
		loanapplication.click();
		Thread.sleep(3000);
	}
	
	public void navigateToCustomerID(WebDriver driver) throws InterruptedException{
		//get Main window Title
		    mainwindow = driver.getWindowHandle();
		    System.out.println("Main Window Title"+ driver.getTitle());
		    System.out.println(driver.getCurrentUrl());
		    
		//click on customer ID under Loan Application
		    
			customerId.click();
			
		//switch to New window	
			Set<String> winHandles = driver.getWindowHandles();
			
			for(String handle: winHandles) {
				
				if(!handle.equals(mainwindow)) {
					driver.switchTo().window(handle);
					Thread.sleep(5000);
					System.out.println("New Window Title"+ driver.getTitle());
					
					System.out.println(driver.getCurrentUrl());
			}
	    }
	}
	
	public void enterGeneralInformationOfLoan(String lnamount, String month) {
		
		loanamount.sendKeys(lnamount);
		//tenure.clear();
		tenure.sendKeys(month);
		
		Select lnpurpose = new Select(loanpurpose);
		lnpurpose.selectByVisibleText("Household Asset ");
	}
	
	public void enterItemsToBeProcured(String itemname, String itemcost) {
		
		itemsprocured.sendKeys(itemname);
		costofitem.sendKeys(itemcost);
		addbutton.click();
	}
	
	public void enterAdditionalAccountDetails(String thapayamount, String sabeamount, String paduakamount) {
		
		thapayaysavingamt.clear();
		thapayaysavingamt.sendKeys(thapayamount);
		
		sabeacccheck.click();
		sabesavingamount.clear();
		sabesavingamount.sendKeys(sabeamount);
		
		paduakTermDepositCheck.click();
		paduakTermDepositamount.clear();
		paduakTermDepositamount.sendKeys(paduakamount);
	}
	
	
	public void clickOnSubmitButton(WebDriver driver) throws InterruptedException {
		
		submit.click();
		
		Thread.sleep(2000);
		
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		
	}
	
	public void navigateToMainWindow(WebDriver driver) throws InterruptedException {
		
		driver.close();
		Thread.sleep(5000);
		driver.switchTo().window(mainwindow);
		doneOnMainWindow.click();
		Thread.sleep(5000);
		dashbord.click();
		
	}
		
}
	


