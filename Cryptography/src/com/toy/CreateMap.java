package com.toy;

import java.util.*;
public class CreateMap {

	public static HashMap<Character,Integer> KeyMap1() {
		char ch='a';
		HashMap<Character,Integer> hm=new HashMap<Character,Integer>(); 
		for(int i=0;i<26;i++) {
			hm.put((char)(ch+i), i);
		}
		return hm;
	}
	public static HashMap<Integer,Character> KeyMap2() {
		HashMap<Character,Integer> hm=KeyMap1();
		HashMap<Integer,Character> res=new HashMap<Integer,Character>(); 
		for(Map.Entry<Character,Integer> h:hm.entrySet()) {
			res.put(h.getValue(), h.getKey());
		}
		return res;
	}
	
	
	public static void main(String args[]) {
		HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
		hm=KeyMap1();
		System.out.println(hm);
		HashMap<Integer,Character> h=new HashMap<Integer,Character>();
		h=KeyMap2();
		System.out.println(h);
	}
	
	
}
