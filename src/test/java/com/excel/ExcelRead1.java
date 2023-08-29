package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead1 {
	public static void main(String[] args) throws Throwable {
		File F = new File("C:\\Users\\HEMU\\eclipse-workspace2\\ExcelProject\\src\\test\\java\\com\\excel\\Mobiles1.xlsx");
		FileInputStream Fin = new FileInputStream(F);
		Workbook W = new XSSFWorkbook(Fin);
		Sheet S = W.getSheet("Phones");
		for(int i=0;i<S.getPhysicalNumberOfRows();i++) {
			Row row = S.getRow(i);
			for(int j=1;j<=row.getPhysicalNumberOfCells();j++) {
				Cell cell = row.getCell(j);
				RichTextString cellValue = cell.getRichStringCellValue();
				System.out.println(cellValue);
				
			}
			
		}
		
	}

}
