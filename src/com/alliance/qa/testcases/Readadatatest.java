package com.alliance.qa.testcases;

import java.io.FileInputStream;
import java.io.IOException;

import com.alliance.base.ExcellReader;

public class Readadatatest  {
	
	public static void main(String[] args) throws IOException {
		
	//	FileInputStream fil = new FileInputStream("D:\\Excell File\\Datasheet.xls");
		
	/*
		Workbook wb = new WorkbookFactory().create(fil);
		Sheet sh = wb.getSheet("Sheet1");
		Row rw = sh.getRow(0);
		Cell cell = rw.getCell(1);
		 if(cell.getCellType() == CellType.STRING) {
		String data = rw.getCell(1).getStringCellValue();
		 
		System.out.println(data);
		 }*/
		
		
		ExcellReader read = new ExcellReader("D:\\Automation\\Excell File\\Datasheet.xls");
		
		String s1 = read.getCellData("customer", "Customer Name", 4);
		//  read.getCellData(sheetname, colName, rowNum)
		
		System.out.println(s1);
	}

}
