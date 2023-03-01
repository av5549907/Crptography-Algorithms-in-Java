package com.hill;

import com.crypt.*;

public class FindModInverse {
	
	public static void main(String[] args) {
		
		MatrixInverseModulo mi=new MatrixInverseModulo();
		int[][] m= {{6,24,1},{13,16,10},{20,17,15}};
		int [][] k=mi.inverse(m);
		for(int i=0;i<k.length;i++) {
			for(int j=0;j<k[0].length;j++){
				System.out.print(k[i][j]+" ");
			}
			System.out.println();
		}
	}

}
