package com.substitution;

import java.util.*;

public class KeyPairTable {

	
	public LinkedHashMap<Character, Character> MessageToCipherMap(String key) {
		LinkedHashMap<Character,Character> m=new LinkedHashMap<Character,Character>();
		//HashMap<Character,Character> m=new HashMap<Character,Character>();
		int j=0;
		for(char i='a';i<='z';i++) {
        	char ch=i;
        	char k=key.charAt(j++);
        	m.put(i,k);
        	//c.put(k,ch);
        }
		return m;
	}
	public LinkedHashMap<Character, Character> CipherToMessageMap(LinkedHashMap<Character, Character> m) {
		LinkedHashMap<Character,Character> c=new LinkedHashMap<Character,Character>();
		for(Map.Entry<Character, Character> k:m.entrySet()) {
			c.put(k.getValue(), k.getKey());
		}
		return c;
	}
}
