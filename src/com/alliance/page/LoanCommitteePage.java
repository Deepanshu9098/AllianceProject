package com.alliance.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoanCommitteePage {

	@FindBy (id = "APP_INST_FREQNCY")
	private WebElement InstallmentFrequency;
	
	@FindBy (id = "FIRST_INSTAL_DUE_DT")
	private WebElement installementDate;
	
	@FindBy(xpath = "//select[@class = 'ui-datepicker-month']")
	private WebElement monthOfInstallment;
	
	@FindBy(xpath = "//select[@class = 'ui-datepicker-year']")
	private WebElement yearOfInstallment;
	
	@FindBy(xpath = "//a[text() = '30']")
	private WebElement dateOfInstallment;
	
	@FindBy (id = "APPROVE")
	private WebElement approveButton; 
	
	
	public void enterLoanCommitteeDetails() throws InterruptedException {
		
		Select frequency = new Select(this.InstallmentFrequency);
		frequency.selectByVisibleText("28 Days");
		
		installementDate.click();
		Thread.sleep(2000);
		
		Select month = new Select(this.monthOfInstallment);
		month.selectByVisibleText("Oct");
		
		Select year = new Select(this.yearOfInstallment);
		year.selectByVisibleText("2019");
		
		dateOfInstallment.click();
		
		Thread.sleep(2000);
	}
	
	public void clickOnApproveButton(WebDriver driver) throws InterruptedException {
		
		approveButton.click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(3000);
		alert.accept();
		
	}
	
}
