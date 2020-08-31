package com.alliance.page;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoanFXPage {

	@FindBy (id = "DashBoard") 
	private WebElement dashbord;
	
	
	@FindBy (xpath = "//span[text() = 'FX Verification']")
	private WebElement fxVerification;
	
	@FindBy (xpath = "//a[contains(text(),'01100001904')]")
	private WebElement customerID;
	
	@FindBy(xpath ="//tr[td[contains(text(),'Were the guidelines"
			+ "/procedures of Alliance properly followed?')]]/td[3]/input")
	private WebElement Response1;
	
	@FindBy(xpath = "//tr[td[contains(text(),'Is the "
			+ "counterparty check of the group positive?')]]/td[3]/input")
	private WebElement Response2;
	
	@FindBy(xpath = "//tr[td[contains(text(),'Have group responsibility "
			+ "and ')]]/td[3]/input")
	private WebElement Response3;
	
	@FindBy(xpath = "//tr[td[contains(text(),'How do you rate the group on the "
			+ "clarity')]]/td[3]/input")
	private WebElement Response4;
	
	@FindBy(xpath = "//tr[td[contains(text(),'Were the differences (loan amount,"
			+ " loan duration')]]/td[3]/input")
	private WebElement Response5;
	
	@FindBy (id = "DURATION_RECOMM")
	private WebElement duration;
	
	@FindBy (id = "FX_CRCHK_LN_SIZE")
	private WebElement landSize;
	
	@FindBy (id = "FX_CR_BUYER_SUPPLIER")
	private WebElement bsItems;
	
	@FindBy (id = "FX_CR_Crop_Budget")
	private WebElement budget;
	
	@FindBy (id = "FX_CASH_Cash_Flows")
	private WebElement flows;
	
	@FindBy(id = "FX_REASONS")
	private WebElement reasons;
	
	@FindBy(id = "CP_NAME_TMP1")
	private WebElement counterpartyName;
	
	@FindBy (id = "CP_CONTACT_NO_TMP1")
	private WebElement counterpartyPhNumber;
	
	@FindBy(id = "CP_RELATION_TMP1")
	private WebElement relationship;
	
	@FindBy(id = "BTN_ADD_PRTY1")
	private WebElement addCounterparty;
	
	@FindBy(id = "CP_COMMENTS_TMP1")
	private WebElement counterpartyComment;
	
	@FindBy (id ="DOC_TYP")
	private WebElement documentType;
	
	@FindBy (id ="DOC_NUM")
	private WebElement documentNo;

	@FindBy(xpath = "//input[@value='Upload Document']")
	private WebElement uploadDocumentButton;
	
	@FindBy(id = "Button1")
	private WebElement addDocumentButton;
	
	
	@FindBy(id = "RECOMMEND")
	private WebElement recommendButton;
	
	@FindBy (xpath = "//input[@value = 'DONE']")
	private WebElement doneOnMainWindow;
	
	
	public void checkAttributeAndResponse() {
		
		 Response1.click();
		 Response2.click();
		 Response3.click();
		 Response4.click();
		 Response5.click();
		 
	}
	
	public void enterClientVisitAndObservation(String duration, WebDriver driver) throws InterruptedException {
		
		this.duration.sendKeys(duration);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView();", this.duration);
		
	  //  reasons.sendKeys("sdfgsdf");
		Thread.sleep(3000);
		landSize.click();
		bsItems.click();
		budget.click();
		flows.click();
	}
	
	public void enterCounterpartyCheck(String counterpartyName, String counterpartyPhNumber, 
			String counterpartyName2, String counterpartyPhNumber2, WebDriver driver) throws InterruptedException {
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", addCounterparty);
		 
		//counterpartyComment.sendKeys("gjtifndjf");
		this.counterpartyName.sendKeys(counterpartyName);
		this.counterpartyPhNumber.sendKeys(counterpartyPhNumber);
		
		relationship.click();
			
		Select relationship1  = new Select(relationship);
		relationship1.selectByVisibleText("Brother");
		
		addCounterparty.click();
		
	   Thread.sleep(2000);
	   
	   this.counterpartyName.sendKeys(counterpartyName2);
		this.counterpartyPhNumber.sendKeys(counterpartyPhNumber2);
		
		relationship.click();
			
		Select relationship2  = new Select(relationship);
		relationship2.selectByVisibleText("Brother");
		
		addCounterparty.click();
		
		 Thread.sleep(2000);
		   
		   this.counterpartyName.sendKeys(counterpartyName2);
			this.counterpartyPhNumber.sendKeys(counterpartyPhNumber2);
			
			relationship.click();
				
			Select relationship3  = new Select(relationship);
			relationship3.selectByVisibleText("Brother");
			
			addCounterparty.click();
	}
	
	public void uploadDocumnet(String documentNo, WebDriver driver) throws IOException, InterruptedException {
		
		Select doc = new Select(documentType);
		doc.selectByVisibleText("Back NRC");
		
		this.documentNo.sendKeys(documentNo);
		
		uploadDocumentButton.click();
		
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("D:\\Automation\\Excell File\\AutoITRecode customer FileUpload3.exe");
		Thread.sleep(5000);
		String alertMessage = driver.switchTo().alert().getText();
		   driver.switchTo().alert().accept();

		   System.out.println("Customer Face Photo = "+alertMessage);
		   Thread.sleep(2000);
		
		addDocumentButton.click();
	}
	
	public void clickOnRecommend(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		recommendButton.click();
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		Thread.sleep(3000);
		alert.accept();
	}
	
}




