package com.vigenere;

import com.crypt.*;
public class Encryption {
	
	
	    public static String encrypt(String text, final String key) {
	        String result = "";
	        text = text.toUpperCase();
	        for (int i = 0, j = 0; i < text.length(); i++) {
	            char c = text.charAt(i);
	            if (c < 'A' || c > 'Z') continue;
	            result += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
	            j = ++j % key.length();
	        }
	        return result.toLowerCase();
	    }

	    public static String decrypt(String text, final String key) {
	        String result = "";
	        text = text.toUpperCase();
	        for (int i = 0, j = 0; i < text.length(); i++) {
	            char c = text.charAt(i);
	            if (c < 'A' || c > 'Z') continue;
	            result += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
	            j = ++j % key.length();
	        }
	        return result.toLowerCase();
	    }

	    public static void main(String[] args) {
	        String key = "ADARSHVIJAY";
	        ReadFiles f=new ReadFiles();
	        String message=f.readFile("abc.txt");
	       // String message = "ADARSH";
	        WriteFiles fr=new WriteFiles();
	        fr.writeFiles(message,"amit.txt");
	         //f.readFile("amit.txt");
	        String encryptedMessage = encrypt(message, key);
	        System.out.println("Encrypted message: " + encryptedMessage);
	        String decryptedMessage = decrypt(encryptedMessage, key);
	        fr.writeFiles(decryptedMessage,"cipher.txt");
	        //System.out.println("Decrypted message: " + decryptedMessage);
	        System.out.println(decryptedMessage);
	       //System.out.println(f.readFile("cipher.txt"));
	    }
	


//	public static void main(String[] args) {
//		String str="adarsh";
//		ShuffleChar s = new ShuffleChar();
//		System.out.print(s.shuffle(str));
//	}
	
}
