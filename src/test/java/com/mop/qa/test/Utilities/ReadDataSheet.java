package com.mop.qa.test.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.openqa.selenium.WebDriver;

public class ReadDataSheet {
  public WebDriver dr;
  
  public HSSFWorkbook wb;
  
  public HSSFSheet ws;
  
  public int rowCount;
  
  public String className;
  
  public String sheetName;
  
  public String colName;
  
  public String value;
  
  List<TestParameter> list;
  
  public int getRownumber(String testCaseName, String colHeader) throws MPException {
    int rownumber = 0;
    this.rowCount = this.ws.getLastRowNum();
    for (int j = 1; j <= this.rowCount; j++) {
      HSSFRow row = this.ws.getRow(j);
      if (row.getCell(0).getStringCellValue().equalsIgnoreCase(testCaseName)) {
        rownumber = j;
        break;
      } 
    } 
    if (rownumber == 0)
//      throw new MPException("Class Entry missing in DataSheet"); 
    getColumnNumber(colHeader);
    return rownumber;
  }
  
  public int getColumnNumber(String columnHeader) throws MPException {
    HSSFRow row = this.ws.getRow(0);
    int columnNumber = 0;
    int isValid = 0;
    for (int j = this.ws.getFirstRowNum(); j < row.getPhysicalNumberOfCells(); j++) {
      if (row.getCell(j).toString().equalsIgnoreCase(columnHeader)) {
        columnNumber = j;
        isValid = 1;
        break;
      } 
    } 
    if (isValid == 0)
      throw new MPException("Enter proper column in DataSheet"); 
    return columnNumber;
  }
  
  public String getValue(String SheetName, String className, String columnHeader) throws MPException {
    try {
      FileInputStream file = new FileInputStream(new File("./DataSheet.xls"));
      this.wb = new HSSFWorkbook(file);
      this.ws = this.wb.getSheet(SheetName);
      int rownumber = getRownumber(className, columnHeader);
      int columnNumber = getColumnNumber(columnHeader);
      HSSFCell cell = this.ws.getRow(rownumber).getCell(columnNumber);
      if (cell != null)
        this.value = cell.toString(); 
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return this.value;
  }
  
  public String getSetUpValue(String SheetName, String className, String columnHeader) throws MPException {
	    try {
	      FileInputStream file = new FileInputStream(new File("./TestRunner.xls"));
	      this.wb = new HSSFWorkbook(file);
	      this.ws = this.wb.getSheet(SheetName);
	      int rownumber = getRownumber(className, columnHeader);
	      int columnNumber = getColumnNumber(columnHeader);
	      HSSFCell cell = this.ws.getRow(rownumber).getCell(columnNumber);
	      if (cell != null)
	        this.value = cell.toString(); 
	      for (int i = 2; i <= 3; i++) {
	       // for (int j = 1; j <= 3; j++)
	          //HSSFCell hSSFCell = this.ws.getRow(i).getCell(j); 
	      } 
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	    return this.value;
	  }
	  
  public String getAppProperties(String key) throws IOException {
    String value = "";
    try {
      FileInputStream fileInputStream = new FileInputStream("data.properties");
      Properties property = new Properties();
      property.load(fileInputStream);
      value = property.getProperty(key);
      fileInputStream.close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return value;
  }
  
  @SuppressWarnings("unused")
private String getCellValueAsString(HSSFCell cell, FormulaEvaluator formulaEvaluator) {
    if (cell == null || cell.getCellType() == 3)
      return ""; 
    formulaEvaluator.evaluate((Cell)cell).getCellType();
    DataFormatter dataFormatter = new DataFormatter();
    return dataFormatter.formatCellValue(formulaEvaluator.evaluateInCell((Cell)cell));
  }
  
  public String getNumericValue(String SheetName, String className, String columnHeader) throws MPException {
    try {
      FileInputStream file = new FileInputStream(new File("./DataSheet.xls"));
      this.wb = new HSSFWorkbook(file);
      this.ws = this.wb.getSheet(SheetName);
      int rownumber = getRownumber(className, columnHeader);
      int columnNumber = getColumnNumber(columnHeader);
      HSSFCell cell = this.ws.getRow(rownumber).getCell(columnNumber);
      if (cell != null) {
        Long i = Long.valueOf((long)cell.getNumericCellValue());
        this.value = i.toString();
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return this.value;
  }
}
