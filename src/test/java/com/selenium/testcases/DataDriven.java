package com.selenium.testcases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class DataDriven
{
 XSSFWorkbook wb;
 XSSFSheet sheet;
  
 public DataDriven(String excelPath)
 {
 try
 {
 File src = new File(excelPath);
 FileInputStream fis = new FileInputStream(src);
 wb = new XSSFWorkbook(fis);
 }
  
 catch(Exception e)
 {
 System.out.println(e.getMessage());
 }
 }
  
 public String getData(int sheetnumber, int row, int column)
 {
 sheet = wb.getSheetAt(sheetnumber);
  Cell cell=sheet.getRow(row).getCell(column);
 //cell.setCellType(Cell.CELL_TYPE_STRING);
  String data;
  
 if(cell.getCellTypeEnum() == CellType.NUMERIC) 
 {
	    data = NumberToTextConverter.toText(cell.getNumericCellValue());
	    
	}
 else 
 {
 data = sheet.getRow(row).getCell(column).getStringCellValue();
 
 }
 return data;
 
 }
  
 public int getRowCount(int sheetIndex)
 {
 int row = wb.getSheetAt(sheetIndex).getLastRowNum();
 row = row + 1;
 return row;
 }
}