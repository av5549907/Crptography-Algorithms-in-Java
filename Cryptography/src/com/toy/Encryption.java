package com.toy;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Encryption {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("c:/Users/av554/Downloads/Toy Block Cipher/Toy Block Cipher/txts/smpltxt.txt"));
        String pt = reader.readLine();
        reader.close();
        ToyCipherAlgo TBC=new ToyCipherAlgo();
        if (pt.length() % 2 == 0) {
            pt += 'a';
        }
        byte[] ptBytes = pt.getBytes(StandardCharsets.UTF_8);
        StringBuilder ptbits = new StringBuilder();
        for (byte b : ptBytes) {
            ptbits.append(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0'));
        }
        
        ArrayList<Integer> op = new ArrayList<>();
        for (int i = 0; i < ptbits.length(); i += 16) {
            op.add(TBC.encrypt(Integer.parseInt(ptbits.substring(i, i+16), 2)));
        }
        StringBuilder ct = new StringBuilder();
        for (Integer i : op) {
            ct.append(String.format("%16s", Integer.toBinaryString(i)).replace(' ', '0'));
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("c:/Users/av554/Downloads/Toy Block Cipher/Toy Block Cipher/txts/cphrtxt.txt"));
        writer.write(ct.toString());
        writer.close();
    }
}
