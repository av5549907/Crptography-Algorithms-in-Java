package com.vigenere;

import com.crypt.*;
import java.util.Scanner;

public class VigenereCryptanalysis {
    public static final int ALPHABET_SIZE = 26;

    public static void main(String[] args) {
    	ReadFiles rf=new ReadFiles();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ciphertext: ");
        //String ciphertext = scanner.nextLine();
          String ciphertext=rf.readFile("cipher.txt");
        int keyLength = guessKeyLength(ciphertext);
        System.out.println("The guessed key length is: " + keyLength);

        String key = findKey(ciphertext, keyLength);
        System.out.println("The key is: " + key);

        String plaintext = decrypt(ciphertext, key);
        System.out.println("The decrypted plaintext is: " + plaintext);
    }

    public static int guessKeyLength(String ciphertext) {
        int[] distances = new int[ciphertext.length()];
        int count = 0;
        try {
        for (int i = 1; i < ciphertext.length(); i++) {
            String first = ciphertext.substring(0, i);
            String second = ciphertext.substring(i, 2 * i);
            int distance = getHammingDistance(first, second);
            distances[count++] = distance;
        }
        }catch(Exception e) {
        	
        }
        int maxDistance = 0;
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (distances[i] > maxDistance) {
                maxDistance = distances[i];
                index = i;
            }
        }

        return index + 1;
    }

    public static int getHammingDistance(String first, String second) {
        int distance = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    public static String findKey(String ciphertext, int keyLength) {
        String key = "";
        for (int i = 0; i < keyLength; i++) {
            String current = "";
            for (int j = i; j < ciphertext.length(); j += keyLength) {
                current += ciphertext.charAt(j);
            }

            int[] frequencies = getFrequency(current);
            int maxIndex = getMaxIndex(frequencies);
            int shift = maxIndex - 4;
            if (shift < 0) {
                shift = ALPHABET_SIZE + shift;
            }
            char keyChar = (char) (shift + 'A');
            key += keyChar;
        }
        return key;
    }

    public static int[] getFrequency(String current) {
        int[] frequencies = new int[ALPHABET_SIZE];
        for (int i = 0; i < current.length(); i++) {
            char c = current.charAt(i);
            int index = c - 'A';
            frequencies[index]++;
        }
        return frequencies;
    }

    public static int getMaxIndex(int[] frequencies) {
        int max = 0;

        int maxIndex = 0;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (frequencies[i] > max) {
                max = frequencies[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static String decrypt(String ciphertext, String key) {
        String plaintext = "";
        int j = 0;
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            int cValue = c - 'A';
            int kValue = key.charAt(j % key.length()) - 'A';
            int pValue = (cValue - kValue + ALPHABET_SIZE) % ALPHABET_SIZE;
            char p = (char) (pValue + 'A');
            plaintext += p;
            j++;
        }
        return plaintext;
    }
}
