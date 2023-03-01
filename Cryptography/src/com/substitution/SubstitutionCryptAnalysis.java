package com.substitution;

import com.crypt.*;
import java.util.*;

//import com.crypt.ShuffleChar;
import com.crypt.SortMapByValue;
public class SubstitutionCryptAnalysis {
	
	public static LinkedHashMap<Character,Double> getPlainCharFreq(String ptx){
		LinkedHashMap<Character,Double> res=new LinkedHashMap<Character,Double>();
		for(int i=0;i<ptx.length();i++) {
			if(res.containsKey(ptx.charAt(i))) {
				res.put(ptx.charAt(i), 1+res.get(ptx.charAt(i)));
			}else {
				res.put(ptx.charAt(i), 1.0);
			}
		}
		SortMapByValue sv=new SortMapByValue();
		LinkedHashMap<Character,Double> h=new LinkedHashMap<Character,Double>(); 
		double x=ptx.length();
	    //System.out.println(x);
		for(Map.Entry<Character,Double> hm: res.entrySet()) {
			double k=hm.getValue()/x;
			char c=hm.getKey();
			//System.out.println(hm.getValue()+" "+k);
			  h.put(c,k);
		}
		 res=sv.sortByValDouble(res);
		//System.out.println(res);
		 res=sv.sortByValDouble(h);
		//System.out.println(res);
		return res;
	}
	public static HashMap<Character,Double> getCiphCharFreq(String ptx){
		HashMap<Character,Double> res=new HashMap<Character,Double>();
		for(int i=0;i<ptx.length();i++) {
			if(res.containsKey(ptx.charAt(i))) {
				res.put(ptx.charAt(i), 1+res.get(ptx.charAt(i)));
			}else {
				res.put(ptx.charAt(i), 1.0);
			}
		}
		SortMapByValue sv=new SortMapByValue();
		HashMap<Character,Double> h=sv.sortByValDouble(res);
		return h;
	}
//	public static String generateKey(String s) {
//		ShuffleChar c=new ShuffleChar();
//		return c.shuffle(s);
//	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  KeyPairTable kp=new KeyPairTable();	
	  ProbabilityTable tb=new ProbabilityTable();
      Scanner sc=new Scanner(System.in);
      String str="abcdefghijklmnopqrstuvwxyz";
      Substitution s=new Substitution();
      String key=s.generateKey(str);
      SortMapByValue sv=new SortMapByValue();
      LinkedHashMap<Character,Double> f=sv.sortByValDouble(tb.freqTable());
  
      System.out.println(f);
     
      ReadFiles fr=new ReadFiles();
      String message=fr.readFile("abc.txt").toLowerCase();
      //System.out.print(message);
      System.out.println();
     
      LinkedHashMap<Character,Character > m=kp.MessageToCipherMap(key);
      System.out.println(m);
      System.out.println();
      //HashMap<Character,Double> h=getPlainCharFreq(message);
      String cipher=s.encryption(message,m);
      //System.out.println("Encrypted Message: "+cipher);
      LinkedHashMap<Character,Double> hc=getPlainCharFreq(cipher);
      LinkedHashMap<Character,Character > c=kp.CipherToMessageMap(m);
      String mess=s.decryption(cipher,c);
      //System.out.println(hc);
      
      
    	  
      System.out.println(f.keySet());
      System.out.println(hc.keySet());
     
     // System.out.println(c);
     // System.out.println("Decrypted Message: "+mess);
      //System.out.println(message.equals(mess));

	}

}
