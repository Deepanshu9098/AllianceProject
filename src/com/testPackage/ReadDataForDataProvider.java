package com.testPackage;

import java.util.ArrayList;

import com.alliance.base.ExcellReader;



 public class ReadDataForDataProvider {

	static ExcellReader reader;
	
	public static ArrayList<Object> getDataFromExcall() {
		
		
		ArrayList<Object> mydata = new ArrayList<Object>();
		try {
			reader = new ExcellReader("C:\\Users\\deepanshup\\eclipse-workspace\\SeleniumProject\\src\\com\\testdata\\testdatafile.xls");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum = 2; rowNum <= reader.getRowCount("UserIDs"); rowNum ++) {
			
			String usermane = reader.getCellData("UserIDs", "Username", rowNum);
			String password = reader.getCellData("UserIDs", "Password", rowNum);
		
		Object obj[] = {usermane,password};
		mydata.add(obj);
					
		}
		
		return mydata;
	}
}
