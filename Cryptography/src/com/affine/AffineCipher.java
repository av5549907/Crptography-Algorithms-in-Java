package com.affine;

import java.util.*;
import com.crypt.*;
public class AffineCipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] zstar26= {1,3,5,7,9,11,15,17,19,21,23,25};
		int[] z26= {0,1,2,3,4,5,6,7,8,9,10,11,1,2,13,14,15,16,17,18,19,20,21,22,23,24,25};
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The Message");
		//String message=sc.nextLine();
		String message="iamadarsh";
		EnD ed=new EnD();
		ShuffleChar c=new ShuffleChar();
		int a=c.shuffleintlist(zstar26);
		int b=c.shuffleintlist(z26);
		System.out.println(a);
		System.out.println(ed.modInverse26(a));
		String ciph=ed.encryption(message, a, b);
		System.out.println(ciph);
		System.out.println(ed.decryption(ciph, a, b));

	}

}
