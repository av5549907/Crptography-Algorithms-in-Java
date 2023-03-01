package com.crypt;

import java.util.Scanner;

public class MatrixInverseModulo {

    // Function to calculate the inverse of a matrix modulo 26
    public  int[][] inverse(int[][] matrix) {
        int n = matrix.length;
        int[][] adj = new int[n][n];
        int[][] inverse = new int[n][n];
        int det = determinant(matrix, n);

        if (det == 0 || gcd(det, 26) != 1) {
            System.out.println("Inverse doesn't exist.");
            return null;
        }

        adjoint(matrix, adj, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[i][j] = adj[i][j] * modInverse(det, 26) % 26;
            }
        }
        for(int i=0;i<inverse.length;i++) {
        	for(int j=0;j<inverse[0].length;j++) {
        		if(inverse[i][j]<0) {
        			inverse[i][j]+=26;
        		}
        	}
        }

        return inverse;
    }

    // Function to calculate the determinant of a matrix
    public  int determinant(int[][] matrix, int n) {
        int det = 0;

        if (n == 1) {
            det = matrix[0][0];
        } else if (n == 2) {
            det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            for (int j1 = 0; j1 < n; j1++) {
                int[][] submatrix = new int[n-1][n-1];

                for (int i = 1; i < n; i++) {
                    int j2 = 0;

                    for (int j = 0; j < n; j++) {
                        if (j == j1) {
                            continue;
                        }

                        submatrix[i-1][j2] = matrix[i][j];
                        j2++;
                    }
                }

                det += Math.pow(-1, j1) * matrix[0][j1] * determinant(submatrix, n-1);
            }
        }

        return det % 26;
    }

    // Function to calculate the adjoint of a matrix
    public  void adjoint(int[][] matrix, int[][] adj, int n) {
        if (n == 1) {
            adj[0][0] = 1;
        }

        int sign = 1;
        int[][] temp = new int[n-1][n-1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                getCofactor(matrix, temp, i, j, n);
                sign = ((i+j)%2 == 0) ? 1 : -1;
                adj[j][i] = sign * determinant(temp, n-1);
            }
        }
    }

    // Function to get the cofactor of a matrix
    public  void getCofactor(int[][] matrix, int[][] temp, int p, int q, int n) {
        int i = 0;
        int j = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != p && col != q) {
                    temp[i][j++] = matrix[row][col];

                    if (j == n-1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
    
   public  int modInverse(int A, int M)
    {
 
        for (int X = 1; X < M; X++)
            if (((A % M) * (X % M)) % M == 1)
                return X;
        return 1;
    }
   
   
   
   public  int gcd(int a, int b)
   {
       // if b=0, a is the GCD
       if (b == 0)
           return a;
       else
           return gcd(b, Math.abs(a - b));
   }
    
}
   

