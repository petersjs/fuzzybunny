package com.hackerearth.basicsofio;

import java.util.Scanner;

public class PalindromicString {

	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		String in = s.nextLine();
		
		boolean palindrome = false;
		if (in.length() > 0) {
			palindrome = true;
			for (int i=0; i<in.length() && palindrome; i++) {
				palindrome &= in.charAt(i) == in.charAt(in.length()-1-i);
			}
		}
		
		System.out.println(palindrome ? "YES" : "NO");
		System.out.println("test");
	}
}