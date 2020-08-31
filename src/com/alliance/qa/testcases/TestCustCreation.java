package com.alliance.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.alliance.base.ExcellReader;
import com.alliance.base.PropertyClass;

public class TestCustCreation {
	
	String userid = PropertyClass.coUserName;
	String password = PropertyClass.coPassword;
	String xlFile = PropertyClass.xlFilePath;
	WebDriver driver;
	int rownum = 4;
	 
  @Test 
  public void f() throws InterruptedException, IOException {
	  
	  System.setProperty("webdriver.chrome.driver",
				"D:\\Automation\\Selenium 06022020\\All selenium SW\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	//Login to application
		driver.get("http://10.10.60.12:8049/Login/Logout");
		driver.findElement(By.id("USER_CODE")).sendKeys(userid);
		driver.findElement(By.id("Password")).sendKeys(password);
		
		Select basebranch = new Select(driver.findElement(By.id("BASE_BR_CD")));
		basebranch.selectByVisibleText("011 - Sagaing");
		
		driver.findElement(By.xpath("//input[@value=\"LOGIN\"]")).click();
	//Navigate to Customer Page
		
		WebElement customer = driver.findElement(By.xpath("//span[contains(text(),'CUSTOMER')]"));
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(customer).perform();
		 
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/form/div[1]/div[1]/div[1]/div[1]/ul/li[1]/div/ul/li/a")).click();
	//Select Account Type
		Select AccountType = new Select(driver.findElement(By.id("ACC_TYP")));
		AccountType.selectByVisibleText("Group Loan");
		
		
		
	//Enter Group Code
		ExcellReader read = new ExcellReader(xlFile);
		String groupcode =  read.getCellData("customer", "GroupCode", rownum);
				
		driver.findElement(By.id("GRP_CODE")).sendKeys(groupcode);
		Thread.sleep(2000);
		driver.findElement(By.id("GRP_CODE")).sendKeys(Keys.TAB);
		
	//Enter Customer Name
		String custName = read.getCellData("customer", "Customer Name", rownum);
		driver.findElement(By.id("CUST_NAME_ENG")).sendKeys(custName);
		Thread.sleep(2000);
		
		
	//Selecting DOB
		driver.findElement(By.id("DOB")).click();
		
		Select month = new Select(driver.findElement(By.xpath("//select[@class=\"ui-datepicker-month\"]")));
		month.selectByVisibleText("Mar");
		
		Select year = new Select(driver.findElement(By.xpath("//select[@class=\"ui-datepicker-year\"]")));
		year.selectByVisibleText("1991");
		
		driver.findElement(By.xpath("/html/body/div[14]/table/tbody/tr[2]/td[3]/a")).click();
		
	//Select Gender
		Select gender = new Select(driver.findElement(By.id("GENDER")));
		gender.selectByVisibleText("Male-U");
		
	//select Marital Status
		Select MaritalStatus = new Select(driver.findElement(By.id("MATL_STA")));
		MaritalStatus.selectByVisibleText("Unmarried");
		
	//enter Father Name & Mother Name
		
		driver.findElement(By.id("FATHER_NAME")).sendKeys(read.getCellData("customer", "Father Name", rownum));
		driver.findElement(By.id("MOTHER_NAME")).sendKeys(read.getCellData("customer", "Mother Name", rownum));
		
	//Educational Qualification
		Select EducationalQualification = new Select(driver.findElement(By.id("EDUCATN_QUAL")));
		EducationalQualification.selectByVisibleText("University");
		
	//Enter NRC
		driver.findElement(By.id("NRC_ID")).sendKeys(read.getCellData("customer", "NRC", rownum));
		//driver.findElement(By.id("NRC_ID")).sendKeys(Keys.TAB);
		
	//Select Apply for loan
		//driver.findElement(By.id("APPLY_F_LN")).click();
		Select Applyforloan = new Select(driver.findElement(By.id("APPLY_F_LN")));
		Applyforloan.selectByValue("6");
		
	//Enter Primary Mobile Number: & Alternate Mobile Number
		driver.findElement(By.id("MOB_NO")).sendKeys(read.getCellData("customer", "Primary Mobile Number", rownum));
		driver.findElement(By.id("ALTR_MOB_NO")).sendKeys(read.getCellData("customer", "Alternate Mobile Number", rownum));
		
	//Select Occupation
		Select Occupation = new Select(driver.findElement(By.id("CUST_OCCU")));
		Occupation.selectByVisibleText("Student");
		
	//select Activity
		Select Activity = new Select(driver.findElement(By.id("ACT_ID")));
		Activity.selectByVisibleText("106-Fruit/vegetable seller");
		
	//Enter Permanent Address
		driver.findElement(By.id("KYC_CARE_OF_PER")).sendKeys(read.getCellData("customer", "Care of Person", rownum));
		driver.findElement(By.id("KYC_HOUS_NO")).sendKeys(read.getCellData("customer", "House No", rownum));
		driver.findElement(By.id("KYC_LANDMARK")).sendKeys(read.getCellData("customer", "Landmark", rownum));
		driver.findElement(By.id("KYC_STREET")).sendKeys(read.getCellData("customer", "Street", rownum));
		driver.findElement(By.id("KYC_LOCALITY")).sendKeys(read.getCellData("customer", "Locality", rownum));
		driver.findElement(By.id("KYC_PIN_CODE")).sendKeys(read.getCellData("customer", "Pin Code", rownum));
		
		Select District = new Select(driver.findElement(By.id("KYC_DISTRICT")));
		District.selectByVisibleText("SAGAING");
		
	//driver.findElement(By.id("KYC_CITY")).click();
		Select Township = new Select(driver.findElement(By.id("KYC_CITY")));
		Township.selectByVisibleText("MYAUNG");
		
		driver.findElement(By.id("KYC_TALUKA"));
		Select VillageTown = new Select(driver.findElement(By.id("KYC_TALUKA")));
		VillageTown.selectByVisibleText("AH LEL MYAUNG");
		
		Select VillageWard = new Select(driver.findElement(By.id("KYC_WARD")));
		VillageWard.selectByVisibleText("AH LEL MYAUNG");
		
	//1. upload Customer Photos for Customer Face
		
	//Select document type & Enter Docm. No.	
		Select DocumentType = new Select(driver.findElement(By.id("DOC_TYP")));
		DocumentType.selectByVisibleText("Customer Face");
		
		driver.findElement(By.id("DOC_NUM")).sendKeys("43442");
		
		driver.findElement(By.xpath("//input[@value = 'Upload Document']")).click();
		

	//perform upload by AutoIT
		
		   Thread.sleep(3000);
		   
		   Runtime.getRuntime().exec("D:\\Automation\\Excell File\\AutoITRecode customer FileUpload3.exe");
		   
		   Thread.sleep(5000);
		   
		   String alertMessage = driver.switchTo().alert().getText();
		   driver.switchTo().alert().accept();

		   System.out.println("Customer Face Photo = "+alertMessage);
		   Thread.sleep(2000);
	  //Scrolldown for add button  
		   JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.id("DOC_NUM")));

		   
		   Thread.sleep(2000);        
           driver.findElement(By.id("BTN_ADD")).click();
	
           
         //2. upload Customer Photos for Customer ID Card 
   		
       	//Select document type & Enter Docm. No.	
           Thread.sleep(3000);
       		Select DocumentType2 = new Select(driver.findElement(By.id("DOC_TYP")));
       		DocumentType2.selectByVisibleText("Customer ID Card (Back)");
       		
       		driver.findElement(By.id("DOC_NUM")).sendKeys("43564564");
       		
       		driver.findElement(By.xpath("//input[@value = 'Upload Document']")).click();
       		

       	//perform upload by AutoIT
       		
       		   Thread.sleep(3000);
       		   
       		   Runtime.getRuntime().exec("D:\\Automation\\Excell File\\AutoITRecode customer FileUpload3.exe");
       		   
       		   Thread.sleep(5000);
       		   
       		   String alertMessage1 = driver.switchTo().alert().getText();
       		   driver.switchTo().alert().accept();

       		   System.out.println("Customer ID Card = "+alertMessage1);
       		    
       			        
                  driver.findElement(By.id("BTN_ADD")).click();      
                  
                  
          //3. upload Customer Photos for Customer ID Card (Front & Signature)
             		
         //Select document type & Enter Docm. No.	
                     Thread.sleep(3000);
                 		Select DocumentType3 = new Select(driver.findElement(By.id("DOC_TYP")));
                 		DocumentType3.selectByVisibleText("Customer ID Card (Front & Signature)");
                 		
                 		driver.findElement(By.id("DOC_NUM")).sendKeys("44");
                 		
                 		driver.findElement(By.xpath("//input[@value = 'Upload Document']")).click();
                 		

          //perform upload by AutoIT
                 		
                 		   Thread.sleep(3000);
                 		   
                 		   Runtime.getRuntime().exec("D:\\Automation\\Excell File\\AutoITRecode customer FileUpload3.exe");
                 		   
                 		   Thread.sleep(5000);
                 		   
                 		   String alertMessage2 = driver.switchTo().alert().getText();
                 		   driver.switchTo().alert().accept();

                 		   System.out.println("Customer ID Card 2 = "+alertMessage2);
                 		    
                 			        
                            driver.findElement(By.id("BTN_ADD")).click();              
		
	//Enter Business Details
		Select BusinessLocation = new Select(driver.findElement(By.id("BUSINESS_lOC")));
		BusinessLocation.selectByVisibleText("Market");
		
		Select BusinessOwnership = new Select(driver.findElement(By.id("BUSINESS_OWN")));
		BusinessOwnership.selectByVisibleText("Owned");
		
		driver.findElement(By.id("YRS_BUSI_EXP")).sendKeys(read.getCellData("customer", "Years Of Business Experience", rownum));
		driver.findElement(By.id("YRS_LIV_CURR_ADDR")).sendKeys(read.getCellData("customer", "Years Living At Current Address", rownum));
		
		Select OwnershipOfHouse = new Select(driver.findElement(By.id("HOUSE_OWN")));
		OwnershipOfHouse.selectByVisibleText("Owned");
		
		driver.findElement(By.id("YRS_CURRENT")).sendKeys(read.getCellData("customer", "Current Years", rownum));
		
	//Enter Family Details (Form 10)
		driver.findElement(By.id("HOLD_REG_NO")).sendKeys(read.getCellData("customer", "Houshold Registration No", rownum));
		driver.findElement(By.id("NO_OF_FAM_MMBR")).sendKeys(read.getCellData("customer", "No. Of Family Members", rownum));
		driver.findElement(By.id("NO_OF_EARN_FAM_MMBR")).sendKeys(read.getCellData("customer", "No. Of Earning Family Members", rownum));
		driver.findElement(By.id("FAM_NAME_TMP")).sendKeys(read.getCellData("customer", "Name Of The Family Member", rownum));
		driver.findElement(By.id("FAM_AGE_TMP")).sendKeys(read.getCellData("customer", "Age", rownum));
		
		Select GenderOfFamilyMember = new Select(driver.findElement(By.id("FAM_GENDER_TMP")));
		GenderOfFamilyMember.selectByVisibleText("Female-Daw");
		
		Select Relationship = new Select(driver.findElement(By.id("FAM_REL_SHIP_TMP")));
		Relationship.selectByVisibleText("Brother");
		
		Select Occupation1 = new Select(driver.findElement(By.id("FAM_OCCUPTN_TMP")));
		Occupation1.selectByVisibleText("Business");
		
		driver.findElement(By.id("FAM_NRC_MYMR_TMP")).sendKeys(read.getCellData("customer", "NRC1", rownum));
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("BTN_FAM")).click();
		
	// Click on Submit Button
		
		driver.findElement(By.id("CREATE")).click();
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		String customerNum = driver.switchTo().alert().getText();
		
		
		System.out.println(customerNum);
  }
}
