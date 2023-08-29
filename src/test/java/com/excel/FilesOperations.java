package com.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilesOperations {
	public static void main(String[] args) throws Exception {
		File F = new File("C:\\Users\\HEMU\\eclipse-workspace2\\ExcelProject\\FileFolder\\Sample.txt");
		FileWriter Fw = new FileWriter(F);
		Fw.write("Hemanthbabu is a software tester");
		Fw.close();
		FileReader Fr = new FileReader(F);
		char[] c = new char[25];
		Fr.read(c);
		for(char X:c) {
			System.out.print(X);
		}
		
		
	
		
		
		
	}

}
