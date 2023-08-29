package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertyConcept {
	public static void main(String[] args) throws Exception {
		File F = new File("C:\\Users\\HEMU\\eclipse-workspace2\\ExcelProject\\target\\P1.property");
		FileOutputStream Fout = new FileOutputStream(F);
		Properties P = new Properties();
		P.setProperty("Hemanth","3023");
		P.setProperty("Vishal","3024");
		P.setProperty("Hemachandran","3025");
		P.save(Fout,"StudentsDetails");
		FileInputStream Fin = new FileInputStream(F);

		String hemanth = P.getProperty("Hemanth");
		System.out.println(hemanth);
	}

}
