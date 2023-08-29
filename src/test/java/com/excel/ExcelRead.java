package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public static void main(String[] args) throws Throwable {
		File F = new File("C:\\Users\\HEMU\\eclipse-workspace2\\ExcelProject\\target\\excelread.xlsx");
		FileInputStream Fi = new FileInputStream(F);
		Workbook W = new XSSFWorkbook(Fi);
		Sheet S = W.getSheet("Sheet1");
		for(int i=0;i<S.getPhysicalNumberOfRows();i++) {
			Row r = S.getRow(i);
			for(int j=0;j<r.getPhysicalNumberOfCells();j++) {
				Cell c = r.getCell(j);
				int cellType = c.getCellType();
				if(cellType==1) {
					String name = c.getStringCellValue();
					System.out.println(name);
				}
				else if(cellType==0){
					if(DateUtil.isCellDateFormatted(c)) {
						Date date= c.getDateCellValue();
						System.out.println(date);	
					}
					else {
						double d = c.getNumericCellValue();
						long l =(long)d;
						String number = String.valueOf(l);
						System.out.println(number);	
					}
					
				}
			}
		}
		System.out.println("DONE");
	}
	

}
