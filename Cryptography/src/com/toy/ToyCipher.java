package com.toy;


import java.util.Scanner;

public class ToyCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine();
        System.out.print("Enter the key: ");
        String key = scanner.nextLine();
        
        String ciphertext = encrypt(plaintext, key);
        System.out.println("Ciphertext: " + ciphertext);
        
        String decryptedText = decrypt(ciphertext, key);
        System.out.println("Decrypted plaintext: " + decryptedText);
    }
    
    public static String encrypt(String plaintext, String key) {
        String ciphertext = "";
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            int k = key.charAt(i % key.length()) - 'a';
            char encryptedChar = (char) ((c - 'a' + k) % 26 + 'a');
            ciphertext += encryptedChar;
        }
        return ciphertext;
    }
    
    public static String decrypt(String ciphertext, String key) {
        String plaintext = "";
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            int k = key.charAt(i % key.length()) - 'a';
            char decryptedChar = (char) ((c - 'a' - k + 26) % 26 + 'a');
            plaintext += decryptedChar;
        }
        return plaintext;
    }
}

