package org.flipkart.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static String getdata(int rownum, int cellnum) throws IOException {
		File f=new File("C:\\Users\\umapathy\\eclipse-workspace\\BaseClass\\Excel\\New Practice.xlsx");
		String stringCellValue=null;
		try {
			FileInputStream fi=new FileInputStream(f);
			Workbook wb=new XSSFWorkbook(fi);
			Sheet sh=wb.getSheet("Sheet1");
			Row row=sh.getRow(rownum);
			Cell cell = row.getCell(cellnum);
			 stringCellValue = cell.getStringCellValue();
				FileOutputStream fo = new FileOutputStream(f);
				wb.write(fo);
				wb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stringCellValue;
	}

	
	public static String[][] dataexcel(){
		File f=new File("C:\\Users\\umapathy\\eclipse-workspace\\TestNGTest\\Excel\\New Practice.xlsx");
		
		String[][]  data=null;
		try {
			FileInputStream fi=new FileInputStream(f);
			Workbook wb=new XSSFWorkbook(fi);
			Sheet sh=wb.getSheet("Sheet1");
			int physicalNumberOfRows = sh.getPhysicalNumberOfRows();
			Row r = sh.getRow(physicalNumberOfRows);
			int physicalNumberOfCells = r.getPhysicalNumberOfCells();
			data =new String[physicalNumberOfRows][physicalNumberOfCells];
			for (int i = 0; i < physicalNumberOfRows; i++) {
				for (int j = 0; j < physicalNumberOfCells; j++) {
					Row row = sh.getRow(i);
					
						Cell cell = row.getCell(j);
						String cellvalue =cell.getStringCellValue();
						data[i][j]=cellvalue;
					}
				
				}
			}
		
	
		
	
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("error may occcur when u define a name called vedha");
		}
		return data;
	
}
}