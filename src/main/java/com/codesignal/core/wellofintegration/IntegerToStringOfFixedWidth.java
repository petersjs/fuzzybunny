package com.codesignal.core.wellofintegration;

public class IntegerToStringOfFixedWidth {

	public static void main (String[] args) {
		System.out.println(integerToStringOfFixedWidth(1234, 2));
		System.out.println(integerToStringOfFixedWidth(1234, 4));
		System.out.println(integerToStringOfFixedWidth(1234, 5));
	}
	
	private static String integerToStringOfFixedWidth(int number, int width) {
		String numAsString = String.valueOf(number);
		int len = numAsString.length();
		
		if (width < len) {
			numAsString = numAsString.substring(len-width);
		} else if (width > len) {
			numAsString = new String(new char[width-len]).replace("\0", "0") + numAsString;
		}
		return numAsString;
	}
}