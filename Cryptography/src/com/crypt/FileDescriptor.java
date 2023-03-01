package com.crypt;


import java.io.*;
import java.util.*;
public class FileDescriptor {
	
	public static String readFile(String filename) {
		String originaltext="";
		try {
			
		FileReader fr=new FileReader("abc.txt");
		int i;
		while((i=fr.read())!=-1) {
			char c=(char)i;
			if(c>='A'&&c<='Z'||c>='a'&&c<='z') {
				originaltext+=c;
			}
		   }
		
			fr.close();
      
	}catch(Exception e) {
		
		System.out.println("File Not Found");
	}
 	 return originaltext;
	}
	
	public static void fileRead(String file)
	{
		try {
			FileReader fr=new FileReader(file);
			
		}catch(Exception e) {
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename="abc.txt";
		
        System.out.print(readFile(filename));
		
	}
}
