package com.hackerearth.basicsofio;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		
		int factorial = 0;
		if (i>0) {
			factorial = 1;
			while (i > 1) {
				factorial *= i;
				i--;
			}
		}
		System.out.println(factorial);
	}
}