package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fis;
	public static FileOutputStream fout;
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		worksheet = workbook.getSheet(xlsheet);
		int rowcount = worksheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowcount;
	}
	
	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
		
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		worksheet = workbook.getSheet(xlsheet);
		row=worksheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fis.close();
		return rownum;
		
	}

	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		worksheet = workbook.getSheet(xlsheet);
		row=worksheet.getRow(rownum);
		cell = row.getCell(colnum);
		String data;
		try {
			DataFormatter dataFormatter = new DataFormatter();
			String cellData = dataFormatter.formatCellValue(cell);
			return cellData;
		}
		catch (Exception e) {
			data = "";
		}
		workbook.close();
		fis.close();
		return data;
		
	}
public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data) throws IOException {
		
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		worksheet = workbook.getSheet(xlsheet);
		row=worksheet.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fout=new FileOutputStream(xlfile);
		workbook.write(fout);
		workbook.close();
		fis.close();
		fout.close();
		
	}
	
}
