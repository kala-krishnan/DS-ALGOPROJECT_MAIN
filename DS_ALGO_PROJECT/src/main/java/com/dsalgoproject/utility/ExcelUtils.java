package com.dsalgoproject.utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	
	static String path;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

public ExcelUtils(String excelPath, String sheetName) {
try {

path=System.getProperty("user.dir");
workbook= new XSSFWorkbook(excelPath);
sheet= workbook.getSheet(sheetName);

}catch(Exception e) {

e.printStackTrace();
}	
}

public static void main(String[] args) {
	
	//	getRowCount();
		getCellDataString(1,1);
		getCellDataNumber(1,1);
	}

public static void getRowCount() {

try {

	path=System.getProperty("user.dir");
	workbook= new XSSFWorkbook(path+"//src//test//resources//ExcelData//ExcelData.xlsx");
	sheet= workbook.getSheet("Login");	
	int rowCount= sheet.getPhysicalNumberOfRows();
	System.out.println("No.of rows:" +rowCount);
	}
catch(Exception exp) {
	System.out.println(exp.getMessage());
	System.out.println(exp.getCause());
	exp.printStackTrace();
	}

}

public static String getCellDataString(int rowNum, int cellNum) {

	String cellData=" ";
try {

	 cellData= sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
	 System.out.println(cellData);
	 return cellData;
	}
catch(Exception exp) {
	System.out.println(exp.getMessage());
	System.out.println(exp.getCause());
	exp.printStackTrace();
	return cellData;
	}

}

public static String getCellDataNumber(int rowNum, int cellNum) {
	
	
	String cellData=" ";
try {
	cellData= sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
	System.out.println(cellData);
	return cellData;
	}
catch(Exception exp) {
	System.out.println(exp.getMessage());
	System.out.println(exp.getCause());
	exp.printStackTrace();
	return cellData;
	}
}



}
