package com.crypt;

import java.io.*;

public class WriteFiles {
	
	public void writeFiles(String s,String filename) {
		try {
		File f=new File(filename);	
		FileWriter fr=new FileWriter(filename);
		fr.write(s);
		fr.close();
	}catch(Exception e) {
		System.out.println("File Not Found");
	}
   System.out.println("File Written success fully");
}
}
