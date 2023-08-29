package com.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedmiPrice {
	public static void main(String[] args) throws InterruptedException, Throwable {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		search.sendKeys("redmi",Keys.ENTER);
		Thread.sleep(2000);
		File F = new File("C:\\Users\\HEMU\\eclipse-workspace2\\ExcelProject\\target\\Redmiprices.xlsx");
		Workbook W =new XSSFWorkbook();
		Sheet S = W.createSheet("RedmiPrices");
		List<WebElement> R = driver.findElements(By.xpath("//div[contains(@class,'_4rR01T')]"));
		Map<String,String> M = new TreeMap<String, String>();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		for(int i=0;i<R.size();i++) {
			WebElement mobiles=R.get(i);
			String redminames =mobiles.getText();
			Row r = S.createRow(i);
			Cell c = r.createCell(0);
			c.setCellValue(redminames);
			
			System.out.println(redminames);
			List<WebElement> P = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
			for(int j=i;j==i;j++) {
				WebElement Price =P.get(j);
				String Prices= Price.getText();
				Cell c1 = r.createCell(1);
				c1.setCellValue(Prices);
				M.put(redminames, Prices);
				Set<Entry<String,String>> entry =M.entrySet();
				for(Entry<String,String> RP:entry) {
					System.out.println(RP);
				}
				
				
			}
		}
		FileOutputStream Fout = new FileOutputStream(F);
		W.write(Fout);

		
	
	}

}
