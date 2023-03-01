package com.substitution;

import com.crypt.*;
import java.util.*;

public class Substitution {

	
	
	public static String generateKey(String s) {
		ShuffleChar c=new ShuffleChar();
		return c.shuffle(s);
	}
	
	public static String encryption(String message,LinkedHashMap<Character,Character > m) {
		String cipher="";
		try {
		
		Substitution sb=new Substitution();
		for(int i=0;i<message.length();i++) {
			char c=message.charAt(i);
			char k=m.get(c);
			cipher+=k;
			
		}
		return cipher;
		}catch(Exception e) {
			return cipher;
		}
	}
	
	public static String decryption(String cipher,LinkedHashMap<Character,Character > c) {
		String message="";
		Substitution sb=new Substitution();
		for(int i=0;i<cipher.length();i++) {
			char p=cipher.charAt(i);
			char k=c.get(p);
			message+=k;
			
		}
		return message;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyPairTable kp=new KeyPairTable();
		ProbabilityTable pb=new ProbabilityTable();
		SortMapByValue sv=new SortMapByValue();
		HashMap<Character,Double> h=sv.sortByValDouble(pb.freqTable());
		System.out.println(h);
//      Scanner sc=new Scanner(System.in);
        String str="abcdefghijklmnopqrstuvwxyz";
        String key=generateKey(str);
        // System.out.println("Read the message from file: ");
        //String message=sc.nextLine();
        ReadFiles fr=new ReadFiles();
        String message=fr.readFile("abc.txt").toLowerCase();
        //System.out.print(message);
        System.out.println();
        LinkedHashMap<Character,Character > m=kp.MessageToCipherMap(key);
        System.out.println(m);
        String cipher=encryption(message,m);
        System.out.println("Encrypted Message: "+cipher);
        LinkedHashMap<Character,Character > c=kp.CipherToMessageMap(m);
        String mess=decryption(cipher,c);
        System.out.println(c);
        System.out.println("Decrypted Message: "+mess);
        System.out.println(message.equals(mess));
        
        
	}

}
