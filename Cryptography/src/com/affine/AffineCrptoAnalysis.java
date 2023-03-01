package com.affine;

public class AffineCrptoAnalysis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] zstar26= {1,3,5,7,9,11,15,17,19,21,23,25};
		String message="iamadarsh";
		EnD ed=new EnD();
		int a=5;//we can take any value of a belonging to z26star( all those element co-prime with 26 of modulo26 )
		int b=13; // any element of modulo26
		  //so there will be only 26*12=312 combination .so by using brute-force we can get all possible 312 combination
		  //and the useful message will give pair (a,b) such that c=am+b  and m=(c-b)*modInverse26(a)
		String cipher=ed.encryption(message, a, b);
		
		//Cryptanalysis  
		for(int i=0;i<26;i++) {
			for(int j=0;j<zstar26.length;j++) {
				String mess=ed.decryption(cipher,zstar26[j],i);
				System.out.println(mess+"   "+zstar26[j]+"  "+i);// only at zstar26[j]=5 and i=13 we will get usefull message
			}
		}
		

	}

}
