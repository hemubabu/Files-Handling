package com.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	public static void main(String[] args) throws Throwable {
		File F = new File("C:\\Users\\HEMU\\eclipse-workspace2\\ExcelProject\\target\\excelwrite1.xlsx");
		FileOutputStream Fout = new FileOutputStream(F);
		Workbook W = new XSSFWorkbook();
		Sheet S = W.createSheet("Sheet1");
		for(int i=0;i<10;i++) {
			Row r = S.createRow(i);
			for(int j=0;j<3;j++) {
				Cell c0 = r.createCell(j);
				c0.setCellValue("Hemanth");
				j++;
				Cell c1 = r.createCell(j);
				c1.setCellValue("13/10/1998");
				j++;
				Cell c2 = r.createCell(j);
				c2.setCellValue(312316203023l);
				
			}
		}
		
//		Cell c0 = r.createCell(0);
//		Cell c1 = r.createCell(1);
//		Cell c2 = r.createCell(2);
//		c0.setCellValue("Hemanth");
//		c1.setCellValue("13/10/1998");
//		c2.setCellValue(312316203023l);
		
		W.write(Fout);
		
	}

}
