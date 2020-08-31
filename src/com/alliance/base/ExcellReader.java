package com.alliance.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcellReader {

	public FileInputStream fis = null;
	public Workbook workbook = null;
	public Sheet sheet = null;
	public Row row = null;
	public Cell cell = null;
	
	
	public ExcellReader(String xFilepath) throws IOException {
		fis = new FileInputStream(xFilepath);

        workbook = new WorkbookFactory().create(fis);
       fis.close();
		}

	// returns the row count in a sheet

		public int getRowCount(String sheetName) {
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
				return 0;
			else {
				sheet = workbook.getSheetAt(index);
				int number = sheet.getLastRowNum() + 1;
				return number;
			}

		}

		// returns the data from a cell
	public String getCellData(String sheetname, String colName, int rowNum) {
		try {
			int col_Num = -1;
			sheet = workbook.getSheet(sheetname);
			row = sheet.getRow(0); 	
			for(int i=0; i<row.getLastCellNum(); i++) {
				
				if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName)) 
					col_Num = i;		
			}
				
		   row = sheet.getRow(rowNum-1);
		   cell = row.getCell(col_Num);
			
		   
		  if(cell.getCellType() == CellType.STRING)  
			  
		return cell.getStringCellValue();
		  
		else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
			
			String cellValue =String.valueOf(cell.getNumericCellValue());
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
				Date date = cell.getDateCellValue();
				cellValue = df.format(date);
			}
			return cellValue;
		}else if (cell.getCellTypeEnum() == CellType.BLANK)
			return "";
		else 
			
		 // return cell.getStringCellValue();
		  return String.valueOf(cell.getBooleanCellValue());
		}
		catch (Exception e) {
			e.printStackTrace();
			return "row "+rowNum+" or columnName "+colName +" does not exist  in Excel";
			 
	   }
	}
	
}
