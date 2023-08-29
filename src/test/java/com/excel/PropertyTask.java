package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyTask {
	public static void main(String[] args) throws IOException {
		File F = new File("C:\\Users\\HEMU\\eclipse-workspace2\\ExcelProject\\target\\Task.property");
		FileInputStream Fin = new FileInputStream(F);
		FileOutputStream Fout = new FileOutputStream(F);	
		Properties P = new Properties();
		P.load(Fin);
	
		String username = P.getProperty("Username");
		P.setProperty("Password","Hemanth3123");
		P.save(Fout, "Password changed");
		
		System.out.println(username);
	}

}
