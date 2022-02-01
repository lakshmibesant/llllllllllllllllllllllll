package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class is to handle excel sheet 
 * @author Lakshmi Raj
 *
 */

public class ExcelUtility 
{
	/**
	 * this method is used to read data from excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName,int rowNum,int celNum) throws Throwable{
		FileInputStream fis  = new FileInputStream(IPathConstant.EPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.getCell(celNum);
		String data = cel.getStringCellValue();
		wb.close();
		return data;
		
	}
	/**
	 * this method is used to get the row count 
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	 public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis  = new FileInputStream(IPathConstant.EPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	 }
	 /**
	  * this method is used to write data 
	  * @param sheetName
	  * @param rowNum
	  * @param celNum
	  * @param data
	  * @throws Throwable
	  */
	 public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable 
	   {
			FileInputStream fis  = new FileInputStream(IPathConstant.EPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			Cell cel = row.createCell(celNum);
			cel.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(IPathConstant.Filepath);
			wb.write(fos);
			wb.close();
			
		}


}
