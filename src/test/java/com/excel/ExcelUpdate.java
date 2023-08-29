package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUpdate {
	public static void main(String[] args) throws Throwable {
		File F = new File("C:\\Users\\HEMU\\eclipse-workspace2\\ExcelProject\\target\\excelwrite.xlsx");
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
					if(name.equals("Hemanth")) {
						c.setCellValue("Lokesh");
					}
				}
				else if (cellType==1) {
					if(DateUtil.isCellDateFormatted(c)) {
						Date date = c.getDateCellValue();
						SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
						String d = sd.format(date);
						if(d.equals("13/10/1998")) {
							c.setCellValue("04/12/1995");
							
						}
						else {
							double D = c.getNumericCellValue();
							long l = (long)D;
							String number =String.valueOf(l);
							if(number.equals("312316203023")) {
								c.setCellValue("312316203024");
							}
							
							
						}
					}
						
				}
			}
	}
		FileOutputStream Fout = new FileOutputStream(F);
		W.write(Fout);
		System.out.println("Done");

}
}
