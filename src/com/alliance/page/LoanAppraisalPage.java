package com.alliance.page;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoanAppraisalPage  {

		
	@FindBy (id = "DashBoard")
	private WebElement DashBoard;
	
	@FindBy (xpath = "//span[contains(text(),'Loan Appraisal')]")
	private WebElement loanAppraisal;
	
	@FindBy (xpath = "//a[contains(text(),'01100001904')]")
	private WebElement customerID;
	
	@FindBy (id = "CASH_SAVING")
	private WebElement cash;
	
	@FindBy(id = "CR_GIVEN")
	private WebElement depSavAccounts;
	
	@FindBy(id = "PAY_TRADERS")
	private WebElement payables;
	
	@FindBy (id = "STOCK")
	private WebElement stock;
	
	@FindBy(id = "MACH_EQUIP")
	private WebElement machEquipment;
	
	@FindBy(id = "VEHICLE")
	private WebElement vehicle;
	
	@FindBy(id = "HH_ARTICLE")
	private WebElement householdArticles;
	
	@FindBy(id = "GOLD")
	private WebElement gold;
	
	@FindBy(id = "HOUSE_TYPE")
	private WebElement housetyp;
	
	@FindBy(id = "LIVESTOCK")
	private WebElement livestock;
	
	@FindBy(id = "LAND")
	private WebElement land;
	
	@FindBy(id = "PAY_SUPPLIER")
	private WebElement advPayable;
	
	@FindBy(id = "LOAN_FI")
	private WebElement loansMFIs;
	
	@FindBy(id = "LOAN_MNY_LND")
	private WebElement moneyLenders;
	
	@FindBy(id = "LOAN_FRND")
	private WebElement loansFriends;
	
	@FindBy(id = "OTHER_COMMITMENT")
	private WebElement otherCommPay;
	
	@FindBy(xpath = "/html/body/div[3]/form/div[1]/div[3]/div/div/div[5]/div[3]"
			+ "/div/div[1]/div[2]/div[4]/table/tbody/tr[1]/td/div"
			+ "/table[2]/tbody/tr[2]/td[2]/input")
	private WebElement typeOfCrop;
	
	@FindBy(xpath = "/html/body/div[3]/form/div[1]/div[3]/div/div/"
			+ "div[5]/div[3]/div/div[1]/div[2]/div[4]/table/tbody/"
			+ "tr[1]/td/div/table[2]/tbody/tr[3]/td[2]/input")
	private WebElement mthOfProduction;
	
	@FindBy(xpath = "/html/body/div[3]/form/div[1]/div[3]/div"
			+ "/div/div[5]/div[3]/div/div[1]/div[2]/div[4]/table/tbody"
			+ "/tr[1]/td/div/table[2]/tbody/tr[4]/td[2]/input")
	private WebElement mthOfSall;
	
	@FindBy(xpath = "/html/body/div[3]/form/div[1]/div[3]/div/div/div[5]/"
			+ "div[3]/div/div[1]/div[2]/div[4]/table/tbody/tr[1]/td/div/"
			+ "table[2]/tbody/tr[5]/td[2]/input")
	private WebElement surfaceInAcre;
	
	@FindBy(xpath = "/html/body/div[3]/form/div[1]/div[3]/div/div/div[5]/"
			+ "div[3]/div/div[1]/div[2]/div[4]/table/tbody/tr[1]/td/div/"
			+ "table[2]/tbody/tr[6]/td[2]/input")
	private WebElement productionAmount;
	
	@FindBy(xpath = "/html/body/div[3]/form/div[1]/div[3]/div/div/div[5]/"
			+ "div[3]/div/div[1]/div[2]/div[4]/table/tbody/tr[1]/td/div/"
			+ "table[2]/tbody/tr[7]/td[2]/input")
	private WebElement sellingPrice;
	
	@FindBy(xpath = "/html/body/div[3]/form/div[1]/div[3]/div/div/div[5]/"
			+ "div[3]/div/div[1]/div[2]/div[4]/table/tbody/tr[1]/td/div/"
			+ "table[2]/tbody/tr[9]/td[2]/input")
	private WebElement inputs;
	
	@FindBy(xpath = "/html/body/div[3]/form/div[1]/div[3]/div/div/div[5]/"
			+ "div[3]/div/div[1]/div[2]/div[4]/table/tbody/tr[1]/td/div/"
			+ "table[2]/tbody/tr[10]/td[2]/input")
	private WebElement seasonalWorkers;
	
	@FindBy(xpath = "/html/body/div[3]/form/div[1]/div[3]/div/div/div[5]/"
			+ "div[3]/div/div[1]/div[2]/div[4]/table/tbody/tr[1]/td/div/"
			+ "table[2]/tbody/tr[11]/td[2]/input")
	private WebElement otherExpenses;
	
	@FindBy(id = "ITEM")
	private WebElement spouseActivity;
	
	@FindBy(id = "AVG_MON_NET_PRO")
	private WebElement avgMonthlyNetProfit;
	
	@FindBy(id = "DURATION_OTHER")
	private WebElement duration;
	
	@FindBy(id = "ITEM1")
	private WebElement otherActivity;
	
	@FindBy(id = "AVG_MON_NET_PRO1")
	private WebElement otheravgMonthlyNetProfit;
	
	@FindBy(id = "DURATION_OTHER1")
	private WebElement duration2;
	
	
	@FindBy(id = "FOOD")
	private WebElement food;
	
	@FindBy(id = "EDUCATION")
	private WebElement education;
	
	@FindBy(id = "CLOTHING")
	private WebElement clothing;
	
	@FindBy(id = "HOUSING")
	private WebElement housing;
	
	@FindBy(id = "HELTH")
	private WebElement health;
	
	@FindBy(id = "FESTIVAL_EXP")
	private WebElement festivalExp;
	
	@FindBy(id = "DONATION")
	private WebElement donation;
	
	@FindBy(id = "SUBMIT")
	private WebElement Submit;
	
	@FindBy (xpath = "//input[@value = 'DONE']")
	private WebElement doneOnMainWindow;
	
	String mainWindow ;
	
	
	public void navigateToDashBord() throws InterruptedException {
		DashBoard.click();
		Thread.sleep(3000);
	}
	
	public void navigateToLoanAppraisalbar() throws InterruptedException{
		loanAppraisal.click();
		Thread.sleep(3000);
	}
	
	public void navigateToLoanAppraisalPageByCustomerID(WebDriver driver) throws InterruptedException {
		
		mainWindow = driver.getWindowHandle();
		String mainWindowTitle = driver.getTitle();
		System.out.println("Main Window Title is -->"+mainWindowTitle);
		System.out.println("Main Window URl-->"+driver.getCurrentUrl());

		customerID.click();
		Thread.sleep(5000);
		
		Set<String> allWindow = driver.getWindowHandles();
		
		for(String handle : allWindow) {
			if(!handle.equalsIgnoreCase(mainWindow)) {
				driver.switchTo().window(handle);
				
				Thread.sleep(3000);
				System.out.println("Cuttern Window Title -->"+driver.getTitle());
				System.out.println("Currernt Window URl-->"+driver.getCurrentUrl());
			}
		}
   	}
	
	public void enterFinancialStatementAssets(String cashamt,String depSavAccounts, String payables, String stock,
			String machEquipment,String vehicle,String householdArticles,String gold, String livestock, String land) throws InterruptedException {
		
		
		cash.sendKeys(cashamt);
		cash.sendKeys(Keys.TAB);
		
		this.depSavAccounts.sendKeys(depSavAccounts);
		this.depSavAccounts.sendKeys(Keys.TAB);
		
		this.payables.sendKeys(payables);
		this.payables.sendKeys(Keys.TAB);
		
		this.stock.sendKeys(stock);
		this.stock.sendKeys(Keys.TAB);
		
		this.machEquipment.sendKeys(machEquipment);
		this.machEquipment.sendKeys(Keys.TAB);
		
		this.vehicle.sendKeys(vehicle);
		this.vehicle.sendKeys(Keys.TAB);
		
		this.householdArticles.sendKeys(householdArticles);
		this.householdArticles.sendKeys(Keys.TAB);
		
		this.gold.sendKeys(gold);
		this.gold.sendKeys(Keys.TAB);
		
		Select houseType = new Select(housetyp);
		houseType.selectByVisibleText("Brick");
		
		
		this.livestock.sendKeys(livestock);
		this.livestock.sendKeys(Keys.TAB);
		
		
		this.land.sendKeys(land);
		this.land.sendKeys(Keys.TAB);
	}
	
	public void enterFinancialStatementLiabilities(String advPayable, String loansMFIs, String moneyLenders,String loansFriends,
			                        String otherCommPay ) {
		
		this.advPayable.sendKeys(advPayable);
		this.advPayable.sendKeys(Keys.TAB);
		
		this.loansMFIs.sendKeys(loansMFIs);
		this.loansMFIs.sendKeys(Keys.TAB);
		
		this.moneyLenders.sendKeys(moneyLenders);
		this.moneyLenders.sendKeys(Keys.TAB);
		
		this.loansFriends.sendKeys(loansFriends);
		this.loansFriends.sendKeys(Keys.TAB);
		
		this.otherCommPay.sendKeys(otherCommPay);
		this.otherCommPay.sendKeys(Keys.TAB);

	}
	
	public void enterEconomicActivity(String typeOfCrop, String mthOfProduction, String mthOfSall, String surfaceInAcre, 
			String productionAmount, String sellingPrice, String inputs, String seasonalWorkers, String otherExpenses,
			String avgMonthlyNetProfit, String duration, String otheravgMonthlyNetProfit, String duration2) {
		
		this.typeOfCrop.sendKeys(typeOfCrop);
		this.mthOfProduction.sendKeys(mthOfProduction);
		this.mthOfSall.sendKeys(mthOfSall);
		this.surfaceInAcre.sendKeys(surfaceInAcre);
		
		this.productionAmount.clear();
		this.productionAmount.sendKeys(productionAmount);
		
		this.sellingPrice.clear();
		this.sellingPrice.sendKeys(sellingPrice);
		
		this.inputs.clear();
		this.inputs.sendKeys(inputs);
		
		this.seasonalWorkers.clear();
		this.otherExpenses.sendKeys(otherExpenses);
		
		
		Select incomeFromNonfarming = new Select (spouseActivity);
		incomeFromNonfarming.selectByVisibleText("105-Rice shop");
		this.spouseActivity.sendKeys(Keys.TAB);
		
		this.avgMonthlyNetProfit.sendKeys(avgMonthlyNetProfit);
		this.avgMonthlyNetProfit.sendKeys(Keys.TAB);
		
		this.duration.sendKeys(duration);
		
		Select otherIncomeFrmNonfarming = new Select (otherActivity);
		otherIncomeFrmNonfarming.selectByVisibleText("103-Cold drinks");
		this.otherActivity.sendKeys(Keys.TAB);
		
		this.otheravgMonthlyNetProfit.sendKeys(otheravgMonthlyNetProfit);
		this.otheravgMonthlyNetProfit.sendKeys(Keys.TAB);
		
		this.duration2.sendKeys(duration2);
		this.duration2.sendKeys(Keys.TAB);
	}

    public void enterHouseHoldSurplus(String food, String education, String clothing, String housing, String health,String festivalExp,
    		                            String donation) throws InterruptedException {
    	
    	this.food.sendKeys(food);
    	this.food.sendKeys(Keys.TAB);
    	
    	this.education.sendKeys(education);
    	this.education.sendKeys(Keys.TAB);
    	
    	this.clothing.sendKeys(clothing);
    	this.clothing.sendKeys(Keys.TAB);
    	
    	this.housing.sendKeys(housing);
    	this.housing.sendKeys(Keys.TAB);
    	
    	this.health.sendKeys(health);
    	this.health.sendKeys(Keys.TAB);
    	
    	this.festivalExp.sendKeys(festivalExp);
    	this.festivalExp.sendKeys(Keys.TAB);
    	
    	this.donation.sendKeys(donation);
    	this.donation.sendKeys(Keys.TAB);
    	
    	Thread.sleep(5000);
    }

    public void clickOnSubmitButton(WebDriver driver) {
    	
    	Submit.click();
    	
    	Alert alert = driver.switchTo().alert();
    	
    	System.out.println(alert.getText());
    	
    	alert.accept();  		
    }
    
    public void naviageToMainWindow(WebDriver driver) throws InterruptedException {
    	Thread.sleep(5000);
    	driver.close();
    	
    	driver.switchTo().window(mainWindow);
    	
    	doneOnMainWindow.click();
    	Thread.sleep(2000);
    	DashBoard.click();
    	Thread.sleep(2000);
    }
}

















