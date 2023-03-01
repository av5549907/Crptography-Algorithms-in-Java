package com.shift;

public class ShiftCipher {



	public static String encrypt(String text, int s)
	{
		String result="";

		for (int i=0; i<text.length(); i++)
		{
			if (Character.isUpperCase(text.charAt(i)))
			{
				char ch = (char)(((int)text.charAt(i) +
								s - 65) % 26 + 65);
				result+=ch;
			}
			else
			{
				char ch = (char)(((int)text.charAt(i) +
								s - 97) % 26 + 97);
				result+=ch;
				
			}
		}
		return result;
	}
	public static String decrypt(String text, int s)
	{
		String result="";

		for (int i=0; i<text.length(); i++)
		{
			if (Character.isUpperCase(text.charAt(i)))
			{
				char ch = (char)(((int)text.charAt(i)- s-65) % 26 +65);
				result+=ch;
			}
			else
			{
				char ch = (char)(((int)text.charAt(i) - s- 97) % 26 + 97);
				result+=ch;
				
			}
		}
		return result;
	}


	public static void main(String[] args)
	{
		String text = "iamadarsh";
		int s = 4;
		System.out.println("Text : " + text);
		System.out.println("Shift : " + s);
		System.out.println("Cipher: " + encrypt(text, s));
		System.out.println("message: " + decrypt(encrypt(text, s), s));
	}
}
