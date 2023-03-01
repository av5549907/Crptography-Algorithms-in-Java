package com.toy;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Decrytion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("c:/Users/av554/Downloads/Toy Block Cipher/Toy Block Cipher/txts/cphrtxt.txt"));
        String ct = reader.readLine();
        reader.close();
        ToyCipherAlgo TBC=new ToyCipherAlgo();
        ArrayList<Integer> op = new ArrayList<>();
        for (int i = 0; i < ct.length(); i += 16) {
            op.add(TBC.decrypt(Integer.parseInt(ct.substring(i, i+16), 2)));
        }
        StringBuilder dpt_bits = new StringBuilder();
        for (Integer i : op) {
            dpt_bits.append(String.format("%16s", Integer.toBinaryString(i)).replace(' ', '0'));
        }
        
        ArrayList<Character> chars = new ArrayList<>();
        for (int i = 0; i < dpt_bits.length(); i += 8) {
            chars.add((char) Integer.parseInt(dpt_bits.substring(i, i+8), 2));
        }
        StringBuilder decplntxt = new StringBuilder();
        for (Character c : chars) {
            decplntxt.append(c);
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("c:/Users/av554/Downloads/Toy Block Cipher/Toy Block Cipher/txts/dcphred_cphrtxt.txt"));
        writer.write(decplntxt.toString());
        writer.close();
    }
}
