package com.hill;

import java.util.*;

import com.crypt.MatrixInverseModulo;

public class HillCipher {
  static int N = 3;

  /// Encryption Method
  static int[][] encrypt(int[][] plainText, int[][] key) {
    int[][] cipherText = new int[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          cipherText[i][j] += key[i][k] * plainText[k][j];
        }
        cipherText[i][j] = cipherText[i][j] % 26;
      }
    }

    return cipherText;
  }
  
  
/// Decyption Method
  
  public static int[][] decrypt(int[][] cipherText, int[][] key) {
    int[][] plainText = new int[N][N];
    MatrixInverseModulo mi=new MatrixInverseModulo();
    int invKey[][] = mi.inverse(key);

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          plainText[i][j] += invKey[i][k] * cipherText[k][j];
        }
        plainText[i][j] = plainText[i][j] % 26;
      }
    }

    return plainText;
  }
  
  public static int[][] key(int[][] cipher,int[][] message){
	  int[][] plainText = new int[N][N];
	    MatrixInverseModulo mi=new MatrixInverseModulo();
	    int invKey[][] = mi.inverse(message);

	    for (int i = 0; i < N; i++) {
	      for (int j = 0; j < N; j++) {
	        for (int k = 0; k < N; k++) {
	          plainText[i][j] += cipher[i][k]*message[k][j];
	        }
	        plainText[i][j] = plainText[i][j] % 26;
	      }
	    }

	    return plainText;
  }


 
 public static void display(int[][] matrix) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
  
  public static void getKeyMatrix(String key, int keyMatrix[][])
  {
      int k = 0;
      for (int i = 0; i < 3; i++)
      {
          for (int j = 0; j < 3; j++)
          {
              keyMatrix[i][j] = (key.charAt(k)) % 65;
              k++;
          }
      }
  }
  
  ///Get Message Matrix
  
  public static void getMessMatrix(String message, int messMatrix[][])
  {
      int k = 0;
      for (int i = 0; i < N; i++)
      {
          for (int j = 0; j < N; j++)
          {
              messMatrix[i][j] = (message.charAt(k)) % 65;
              k++;
          }
      }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //String message=sc.nextLine();
    String message="ADARSHVIJ";
    //String key=sc.nextLine();
    String key="GYBNQKURP"; //key length must be equal to row*column
    sc.close();
    int keyMatrix[][]=new int[N][N];
    getKeyMatrix(key,keyMatrix);
    for(int i=0;i<N;i++) {
    	for(int j=0;j<N;j++) {
    		System.out.print(keyMatrix[i][j]+" ");
    	}
    	System.out.println();
    }
    int[][] messmat=new int[N][N];
    getMessMatrix(message,messmat);
    for(int i=0;i<N;i++) {
    	for(int j=0;j<N;j++)
    	System.out.print(messmat[i][j]+" ");
     System.out.println();	
    	
    }
    int cipher[][]=new int[N][N];
    ///encryption process
    cipher=encrypt(messmat,keyMatrix);
    System.out.println("After Encryption ");
    for(int i=0;i<cipher.length;i++) {
    	for(int j=0;j<cipher[0].length;j++) {
    		char c=(char)(cipher[i][j]+65);
    		System.out.print(c+" ");
    	}
    	System.out.println();
    }
    //Decryption
    int mess[][]=new int[N][N];
    mess=decrypt(cipher,keyMatrix);
    
    System.out.println("After Decryption ");
    for(int i=0;i<mess.length;i++) {
    	for(int j=0;j<mess[0].length;j++) {
    		char c=(char)(mess[i][j]+65);
    		System.out.print(c+" ");
    	}
    	System.out.println();
    }
    
    System.out.println("Key finding");
    
    int k[][]=new int[N][N];
    k=key(cipher,mess);
    for(int i=0;i<N;i++) {
    	for(int j=0;j<N;j++) {
    		char c=(char)(k[i][j]+65);
    		System.out.print(c+" ");
    	}
    	System.out.println();
    }
    
  }
}

