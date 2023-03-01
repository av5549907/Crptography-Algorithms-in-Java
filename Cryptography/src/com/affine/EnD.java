package com.affine;

import java.math.BigInteger;
import java.util.*;
public class EnD {
	
	
	public String encryption(String message,int a,int b) {
		String cipher="";
		for(int i=0;i<message.length();i++) {
			int k= (int)(message.charAt(i)-97);
			cipher+=(char)((a*k+b)%26+97);
		}
		return cipher;
	}
	public String decryption(String cipher,int a,int b) {
		String message="";
		for(int i=0;i<cipher.length();i++) {
			int k= (int)(cipher.charAt(i)-97);
			int p=(((k-b+26)*modInverse26(a)%26));
			message+=(char)(p+97);
		}
		return message;
	}

	public int modInverse26(int a) {
		// create 2 BigInteger objects
        BigInteger biginteger1, biginteger2, result;
  
        // Initialize all BigInteger Objects
        biginteger1 = BigInteger.valueOf(a);
        biginteger2 = new BigInteger("26");
  
        // perform modInverse operation on biginteger1 using biginteger2.
        result = biginteger1.modInverse(biginteger2);
  
         return result.intValue();
	}
}
