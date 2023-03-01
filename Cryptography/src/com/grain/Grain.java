package com.grain;


import java.util.Scanner;

public class Grain {

    private final GrainCipher grain;

    public Grain() {
        this.grain = new GrainCipher();
    }

    public void encryptNdecrypt() {
        this.grain.init("absolute", "california"); //iv, key
        String keystream = this.grain.filter();
        System.out.println("Keystream : " + keystream);
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("Enetr Plain text");
        String ciphertext = this.grain.encrypt(input.next());
        System.out.println("Ciphertext : " + ciphertext);
        System.out.println("Enetr Cipher text");
        String plaintext = this.grain.decrypt(input.next(), keystream);
        System.out.println("Plaintext : " + plaintext);

    }

    public static void main(String[] args) {
        Grain g = new Grain();
        g.encryptNdecrypt();
        
    }
    
}
