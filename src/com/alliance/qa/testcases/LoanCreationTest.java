package com.alliance.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alliance.base.BaseClass;
import com.alliance.base.ExcellReader;
import com.alliance.base.PropertyClass;
import com.alliance.page.DashBoardPage;
import com.alliance.page.LoanAppicationPage;
import com.alliance.page.LoanAppraisalPage;
import com.alliance.page.LoanCommitteePage;
import com.alliance.page.LoanFXPage;
import com.alliance.page.LogInPage;


public class LoanCreationTest {

  WebDriver driver;
  LogInPage login;
  LoanAppicationPage loanAppication;
  LoanAppraisalPage loanAppraisal;
  LoanFXPage loanFX;
  LoanCommitteePage loanCommittee;
  DashBoardPage dashBoard;
  
  String coUserid = PropertyClass.coUserName;
  String coPasswd = PropertyClass.coPassword;
  String fxUserid = PropertyClass.fxUserName;
  String fxPasswd = PropertyClass.fxPassword;
  String BMUserid = PropertyClass.BMUserName;
  String BMPasswd = PropertyClass.BMPassword;
  
  ExcellReader read;
  int rowNum;
  
  @BeforeClass
  public void configBeforeClass() throws IOException {
	  driver = BaseClass.initialization();
	  login = PageFactory.initElements(driver, LogInPage.class);
	  dashBoard = PageFactory.initElements(driver, DashBoardPage.class);
	  loanAppication = PageFactory.initElements(driver, LoanAppicationPage.class);
	  loanAppraisal = PageFactory.initElements(driver, LoanAppraisalPage.class);
	  loanFX = PageFactory.initElements(driver, LoanFXPage.class);
	  
	  loanCommittee = PageFactory.initElements(driver, LoanCommitteePage.class);
	  
	  read = new ExcellReader("D:\\Automation\\Excell File\\Datasheet.xls");
  }

 
 // @Test
  public void loanApplicationFillTest() throws Exception {
	  
	  rowNum = 2;
	  
	  login.login_Application(coUserid, coPasswd);
	  loanAppication.navigateToDashbord();
	  loanAppication.navigateToLoanApplication();
	  loanAppication.navigateToCustomerID(driver);
	  loanAppication.enterGeneralInformationOfLoan(read.getCellData("LoanApplication", "Loan Amount", rowNum), 
			                               read.getCellData("LoanApplication", "Tenure(In Month)", rowNum));
	  loanAppication.enterItemsToBeProcured(read.getCellData("LoanApplication", "Items To Be Procured", rowNum),
			                              read.getCellData("LoanApplication", "Cost Of Item/Items", rowNum));

	  loanAppication.enterAdditionalAccountDetails(read.getCellData("LoanApplication", "THA PYAY SAVINGS AMOUNT", rowNum), 
			                                   read.getCellData("LoanApplication", "Sabae Saving Plan", rowNum),
			                                   read.getCellData("LoanApplication", "Paduak Term Deposit", rowNum) );
	  loanAppication.clickOnSubmitButton(driver);
	  
	  loanAppication.navigateToMainWindow(driver);
	  
  } 

  
  //@Test
  public void loanAppraisalFillTest() throws IOException, InterruptedException {
	  
	  rowNum = 2;
	  
	    String cashamt = read.getCellData("LoanAppraisal", "Cash", rowNum);
	    String depSavAccounts = read.getCellData("LoanAppraisal", "Dep. & Sav. Accounts", rowNum);
		String payables = read.getCellData("LoanAppraisal", "Payables(Traders/Debtors)", rowNum);
		String stock =  read.getCellData("LoanAppraisal", "Stock", rowNum);
		String machEquipment =  read.getCellData("LoanAppraisal", "Mach. And Equipments", rowNum);
		String vehicle =  read.getCellData("LoanAppraisal", "Vehicles", rowNum);
		String householdArticles =  read.getCellData("LoanAppraisal", "Household Articles", rowNum);
		String gold =  read.getCellData("LoanAppraisal", "Gold/Jewelleries", rowNum);
		String livestock = read.getCellData("LoanAppraisal", "Livestock(Comm. Animals)", rowNum);
		String land = read.getCellData("LoanAppraisal", "Livestock(Comm. Animals)", rowNum);
		
		String advPayable = read.getCellData("LoanAppraisal", "Adv.Payable(Supplier/Buyer)", rowNum);
		String loansMFIs = read.getCellData("LoanAppraisal", "Loans(MFIs And Banks)", rowNum);
		String moneyLenders = read.getCellData("LoanAppraisal", "Loans(MoneyLenders)", rowNum);
		String loansFriends = read.getCellData("LoanAppraisal", "Loans(Friends/Relatives)", rowNum);
		String therCommPay = read.getCellData("LoanAppraisal", "Other Comm./Pay.(if Any)", rowNum);
		
		
		String typeOfCrop = read.getCellData("LoanAppraisal", "Type of crop", rowNum);
		String mthOfProduction = read.getCellData("LoanAppraisal", "Month for production starting", rowNum);
		String mthOfSall = read.getCellData("LoanAppraisal", "Main Month of selling", rowNum);
		String surfaceInAcre = read.getCellData("LoanAppraisal", "Surface in acre", rowNum);
		String productionAmount = read.getCellData("LoanAppraisal", "Production amount", rowNum);
		String sellingPrice = read.getCellData("LoanAppraisal", "Selling price expected", rowNum);
		String inputs = read.getCellData("LoanAppraisal", "Inputs", rowNum);
		String seasonalWorkers = read.getCellData("LoanAppraisal", "Seasonal workers", rowNum);
		String otherExpenses = read.getCellData("LoanAppraisal", "Other expenses", rowNum);
		String avgMonthlyNetProfit = read.getCellData("LoanAppraisal", "Avg. Monthly net profit", rowNum);
		String duration = read.getCellData("LoanAppraisal", "Duration", rowNum);
		String otheravgMonthlyNetProfit = read.getCellData("LoanAppraisal", "Other Avg. Monthly net profit", rowNum);
		String duration2 = read.getCellData("LoanAppraisal", "Duration1", rowNum);
				
		
		String food = read.getCellData("LoanAppraisal", "Food", rowNum);
		String education = read.getCellData("LoanAppraisal", "Education", rowNum);
		String clothing = read.getCellData("LoanAppraisal", "Clothing", rowNum);
		String housing = read.getCellData("LoanAppraisal", "Housing", rowNum);
		String health = read.getCellData("LoanAppraisal", "Health Exp", rowNum);
		String festivalExp = read.getCellData("LoanAppraisal", "Festival Exp", rowNum);
		String donation = read.getCellData("LoanAppraisal", "Donations", rowNum);
		
		
	  login.login_Application(coUserid, coPasswd);
	  loanAppraisal.navigateToDashBord();
	  loanAppraisal.navigateToLoanAppraisalbar();
	  loanAppraisal.navigateToLoanAppraisalPageByCustomerID(driver);
	  
	
	  loanAppraisal.enterFinancialStatementAssets(cashamt, depSavAccounts, payables, stock, machEquipment, vehicle,
		  	                                      householdArticles, gold, livestock, land);
	  
	
	  loanAppraisal.enterFinancialStatementLiabilities(advPayable, loansMFIs, moneyLenders, loansFriends, therCommPay);
	  
	  
	
	loanAppraisal.enterEconomicActivity(typeOfCrop, mthOfProduction, mthOfSall, surfaceInAcre, productionAmount, sellingPrice, 
			                               inputs, seasonalWorkers, otherExpenses, avgMonthlyNetProfit, duration, 
			                               otheravgMonthlyNetProfit, duration2);
 

	loanAppraisal.enterHouseHoldSurplus(food, education, clothing, housing, health, festivalExp, donation);
  
	loanAppraisal.clickOnSubmitButton(driver);
	loanAppraisal.naviageToMainWindow(driver);
	
  }
   
  
  //@Test
  
   public void FXPageTest() throws IOException, InterruptedException {
	  
	 rowNum = 2;
	  
	 String duration = read.getCellData("FX", "Duration", rowNum);
	 
	 String counterpartyName = read.getCellData("FX", "Counterparty Name 1", rowNum);
	 String counterpartyPhNumber = read.getCellData("FX", "Counterparty Ph Number1", rowNum);
	 String counterpartyName2 = read.getCellData("FX", "Counterparty Name2", rowNum);
	 String counterpartyPhNumber2 = read.getCellData("FX", "Counterparty Ph Number2", rowNum);
	 String documentNo = read.getCellData("FX", "Document No", rowNum);
	 
	 login.login_Application(fxUserid, fxPasswd);
	 
	 dashBoard.navigateToDashBoard();
	
	 dashBoard.navigateToFXVerificationTab();
	 dashBoard.navigateToFXPageByCustomerID(driver);
	 	 
	 loanFX.checkAttributeAndResponse();

	 loanFX.enterClientVisitAndObservation(duration, driver);

	 loanFX.enterCounterpartyCheck(counterpartyName, counterpartyPhNumber, counterpartyName2, counterpartyPhNumber2, driver);
	 
	 loanFX.uploadDocumnet(documentNo, driver);
	 
	 loanFX.clickOnRecommend(driver);
	 
	 dashBoard.navigateToMainWindow(driver);
	 
	 login.logOutFromApplication();
  }
   
   
   @Test
   
   public void loanCommitteeTest() throws InterruptedException, IOException {
	   
	   login.login_Application(BMUserid, BMPasswd);
	   Thread.sleep(8000);
	   driver.get("http://10.10.60.12:8049/");
	   
	   Thread.sleep(8000);
	   dashBoard.navigateToDashBoard();
	   dashBoard.clickOnLoanCommitteeHeader();
	   dashBoard.navigateToLoanCommitteePageByGroupCode(driver);
	   
	  
	   loanCommittee.enterLoanCommitteeDetails();
	   
	   loanCommittee.clickOnApproveButton(driver);
	   
	   dashBoard.navigateToMainWindow(driver);      
   }
   
   
   
}



 














