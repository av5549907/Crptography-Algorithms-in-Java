package com.toy;


import java.io.*;
import java.util.*;

public class ToyCipherAlgo {
    static List<Integer> sBox;
    static List<Integer> permTbl;
    static List<Integer> subKeys;
    
    // the program is written for only 16 bit block encryption and decryption
    // if it has more than 16 bit then make multiple block of 16 bit
    public static void main(String[] args) {
        try {
            // Read input from file
            BufferedReader reader = new BufferedReader(new FileReader("c:/Users/av554/Downloads/Toy Block Cipher/Toy Block Cipher/txts/creds - Copy.txt"));
            sBox = new ArrayList<>();
            permTbl = new ArrayList<>();
            subKeys = new ArrayList<>();
            
            String[] line = reader.readLine().split(" ");
//            for(String s: line) {
//            	System.out.println(s);
//            }
//            System.out.println(Integer.parseInt("E", 16));
            for (String s : line) {
                 sBox.add(Integer.parseInt(s, 16));
                //sBox.add(Integer.parseInt(s));
            }
            line = reader.readLine().split(" ");
            for (String s : line) {
                permTbl.add(Integer.parseInt(s));
            }
            //System.out.println(permTbl);
            String key = reader.readLine().trim();
            subKeys = KSA(key);
           
            reader.close();

            // Testing
            int plaintxt =814590098;
            int k=encrypt(plaintxt);
            System.out.println(k);
            int pc=decrypt(plaintxt);
            System.out.println(pc);
            int ciphertxt = perm(plaintxt,false);
            int decryptedPlaintxt = perm(ciphertxt, true);
            System.out.println(Integer.toBinaryString(plaintxt));
            System.out.println(Integer.toBinaryString(ciphertxt));
            System.out.println(Integer.toBinaryString(decryptedPlaintxt));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static int subs(int ip, boolean inv) {
        List<Integer> invSBox = new ArrayList<>(Collections.nCopies(16, 0));
        for (int i = 0; i < sBox.size(); i++) {
            invSBox.set(sBox.get(i), i);
        }
        String bstr = String.format("%16s", Integer.toBinaryString(ip)).replace(' ', '0');
        List<String> sbBlks = new ArrayList<>();
        for (int i = 0; i < 16; i += 4) {
            sbBlks.add(bstr.substring(i, i + 4));
        }
        if (!inv) {
            for (int i = 0; i < sbBlks.size(); i++) {
                sbBlks.set(i, Integer.toBinaryString(sBox.get(Integer.parseInt(sbBlks.get(i), 2))));
            }
        } else {
            for (int i = 0; i < sbBlks.size(); i++) {
                sbBlks.set(i, Integer.toBinaryString(invSBox.get(Integer.parseInt(sbBlks.get(i), 2))));
            }
        }
        String op = String.join("", sbBlks);
        return Integer.parseInt(op, 2);
    }
    
    public static int perm(int ip, boolean inv) {
        String bstr = String.format("%16s", Integer.toBinaryString(ip)).replace(' ', '0');
        StringBuilder op = new StringBuilder();
        if (!inv) {
            for (int i = 0; i < 16; i++) {
                op.append(bstr.charAt(permTbl.get(i)));
            }
        } else {
            for (int i = 0; i < 16; i++) {
                op.insert(0, bstr.charAt(15 - permTbl.get(i)));
            }
        }
        return Integer.parseInt(op.toString(), 2);
    }
    
    // Key mixing
    public static int keyMxn(int ip, int sk) {
        return ip ^ sk;
    }
    
    /// Key scheduling Algorithm
    public static List<Integer> KSA(String key) {
    	try {
        List<Integer> sKey = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sKey.add(Integer.parseInt(key.substring(i * 16, (i + 1) * 16), 2));
        }
        int[] T = new int[16];
        for (int i = 0; i < 16; i++) {
          T[i] = i;
        }
        int j = 0;
        for (int i = 0; i < 16; i++) {
           j = (j + T[i] + sKey.get(i % sKey.size())) % 16;
           int temp = T[i];
           T[i] = T[j];
           T[j] = temp;
        }
        List<Integer> subKeys = new ArrayList<>();
        j = 0;
        for (int i = 0; i < 16; i++) {
           j = (j + T[i]) % 16;
           int temp = T[i];
           T[i] = T[j];
           T[j] = temp;
           int k = T[(T[i] + T[j]) % 16];
           subKeys.add(k);
            }
         }catch(Exception e) {
        	
         }
           return subKeys;
        }
      

   public static int encrypt(int ip) {
	try {   
    for (int i = 0; i < 4; i++) {
        ip = subs(ip, false);
        ip = perm(ip, false);
        ip = keyMxn(ip, subKeys.get(i));
    }
    ip = keyMxn(ip, subKeys.get(subKeys.size() - 1));
	}catch(Exception e) {}
    return ip;
   }

   public static int decrypt(int ip) {
   try {    
    ip = keyMxn(ip, subKeys.get(subKeys.size() - 1));
    for (int i = 3; i >= 0; i--) {
        ip = keyMxn(ip, subKeys.get(i));
        ip = perm(ip, true);
        ip = subs(ip, true);
    }
    }catch(Exception e) {}
    return ip;
  }
}





