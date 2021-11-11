package com.ecom.appium.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import net.sourceforge.htmlunit.corejs.javascript.ObjArray;

/**
 * 
 * @author satyam
 *
 */

public class ExcelUtility implements IpathConstant
{
	public String getExcelData(String sheetName, int rowNum, int cellNum) throws Throwable 
	{
		FileInputStream file = new FileInputStream(IpathConstant.EXCEL_FILEPATH);
		
		Workbook workbook = new WorkbookFactory().create(file);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		return cell.getStringCellValue();		
	}
	
	/**
	 * 
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	
	public Object[][] getExcelData(String sheetName) throws Throwable
	{
		FileInputStream file = new FileInputStream(IpathConstant.EXCEL_FILEPATH);
		Workbook workbook = new WorkbookFactory().create(file);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		short lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i = 0; i<lastRow; i++) 
		{
			for(int j=0; j<lastCell ; j++) 
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
		
	}
	
	/** 
	 * 
	 * @param sheetname
	 * @param rownum
	 * @param column
	 * @param value
	 * @throws Throwable
	 * @throws Throwable
	 * @throws Throwable
	 */
	
	public void writeExcelData(String sheetname,int rownum, int column, String value) throws Throwable, Throwable, Throwable
	{
		FileInputStream file = new FileInputStream(IpathConstant.EXCEL_FILEPATH);
		Workbook workbook = new WorkbookFactory().create(file);
		workbook.createSheet(sheetname).createRow(rownum).createCell(column).setCellValue(value);
		FileOutputStream writefile = new FileOutputStream(IpathConstant.EXCEL_FILEPATH);
		workbook.write(writefile);
		
	}
}
