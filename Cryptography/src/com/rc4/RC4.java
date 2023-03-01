package com.rc4;

import java.util.*;


public class RC4 {

	
	public static void main(String[] args) {
		int temp=0; 
		int s[]=new int[256]; 
		int k[]=new int[256];
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Message for encryption : ");
		String ptext=sc.nextLine();
		//String ptext="iamadarsh";
		
		System.out.println("Enter Key");
		String key=sc.nextLine();
		//String key="cse";
		
		char ptextc[]=ptext.toCharArray(); 
		char keyc[]=key.toCharArray(); 
		
		int cipher[]=new int[ptext.length()]; 
		int decrypt[]=new int[ptext.length()]; 
		
		int ptexti[]=new int[ptext.length()]; 
		int keyi[]=new int[key.length()]; 
		
		for(int i=0;i<ptext.length();i++) 
		{ 
		ptexti[i]=(int)ptextc[i]; 
		} 
		for(int i=0;i<key.length();i++) 
		{ 
		keyi[i]=(int)keyc[i]; 
		} 
		for(int i=0;i<255;i++) 
		{ 
		s[i]=i; k[i]=keyi[i%key.length()]; 
		} 
		int j=0; 
		 for(int i=0;i<255;i++) 
		 { 
		   j=(j+s[i]+k[i])%256; 
		   temp=s[i]; 
		   s[i]=s[j]; 
		   s[j]=temp; 
		  } 
		  int i=0; 
		  j=0; 
		  int z=0; 
		for(int l=0;l<ptext.length();l++) 
		{ 
		   i=(l+1)%256; 
		   j=(j+s[i])%256; 
		   temp=s[i]; 
		   s[i]=s[j]; 
		   s[j]=temp; 
		   z=s[(s[i]+s[j])%256]; 
		   cipher[l]=z^ptexti[l]; 
		    decrypt[l]=z^cipher[l]; 
		} 
		Rcex rc=new Rcex();
		System.out.print("Encrypted Message : ");
		rc.display(cipher);;
		System.out.println();
		System.out.print("Decrypted Message : ");
		rc.display(decrypt);
	}



}
