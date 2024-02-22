package com.DemowebShop1.genericLibery;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.checkerframework.common.value.qual.StaticallyExecutable;

public class ExcelRead implements FrameworkConstants{
	
	
		
		
		public static String[][] multipleRead(String sheetname) throws EncryptedDocumentException, IOException{
			File f=new File(EXCEL_PATH);
			FileInputStream fis=new FileInputStream(f);
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetname);
			int row_size = sheet.getPhysicalNumberOfRows();
			int col_size = sheet.getRow(0).getPhysicalNumberOfCells();
			String[][] data=new String[row_size-1][col_size];
			for (int i = 0; i < row_size-1; i++) 
			{
				
				for (int j = 0; j < col_size; j++) 
				{
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
			}
			return data;
		}
		
		
	public static String readStringvalue(String sheetname,int row,int cell) throws Throwable {
		File  f=new File(EXCEL_PATH);
		FileInputStream fis=new FileInputStream(f);
		Workbook workBook=WorkbookFactory.create(fis);
		Sheet sheet = workBook.getSheet(sheetname);
		return sheet.getRow(row).getCell(cell).toString();
	}
	public static double readNumericvalue(String sheetname,int row ,int cell) throws Throwable {
		File f=new File(EXCEL_PATH);
		FileInputStream fis=new FileInputStream(f);
				
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetname);
		return sheet.getRow(row).getCell(cell).getNumericCellValue();	
	}
	public static boolean readBooleanvalue(String sheetname,int row,int cell) throws Throwable {
		File f=new File(EXCEL_PATH);
		FileInputStream fis=new FileInputStream(f);
		
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetname);
		return sheet.getRow(row).getCell(cell).getBooleanCellValue();
	}
	
	public static boolean readDatavalue(String sheetname,int row,int cell) throws Throwable {
		File f=new File(EXCEL_PATH);
		FileInputStream fis=new FileInputStream(f);
		
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetname);
		return sheet.getRow(row).getCell(cell).getBooleanCellValue();
	}
	
}
