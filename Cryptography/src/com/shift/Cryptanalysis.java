package com.shift;


public class Cryptanalysis {
	
	
	public static void main(String[] args) {
		ShiftCipher s=new ShiftCipher();
		String str=s.encrypt("iamadarsh", 4);
		System.out.println(str);
		for(int i=0;i<26;i++) {
			String m=s.decrypt(str, i);
			System.out.println(m+" "+i);
		}
	}
	

}
