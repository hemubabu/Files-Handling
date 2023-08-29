package com.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LGExcel {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		search.sendKeys("LGTV",Keys.ENTER);
		Thread.sleep(3000);
		File F = new File("C:\\Users\\HEMU\\eclipse-workspace2\\ExcelProject\\target\\LGexcel.xlsx");
		Workbook W = new XSSFWorkbook();
		Sheet S = W.createSheet("LG Models Sheet");
		
	
		List<WebElement> Tv = driver.findElements(By.xpath("//div[contains(text(),'LG')]"));
		Thread.sleep(3000);
		int size = Tv.size();
		System.out.println(size);
		
		for(int i=1;i<17;i++) {
			WebElement Tvnames = Tv.get(i);
			
			String Tvnameslist = Tvnames.getText();
			Row r = S.createRow(i);
			Cell c = r.createCell(0);
			c.setCellValue(Tvnameslist);
			System.out.println(Tvnameslist);	
		}		
		FileOutputStream Fout = new FileOutputStream(F);
		W.write(Fout);
	
		
	
	}		

	}


