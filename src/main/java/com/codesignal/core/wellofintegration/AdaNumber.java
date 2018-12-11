package com.codesignal.core.wellofintegration;

public class AdaNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(adaNumber("123_456_789"));
		System.out.println(!adaNumber("123_456_789a"));
		System.out.println(adaNumber("16#123abc#"));
		System.out.println(!adaNumber("10#123abc#"));
		System.out.println(!adaNumber("10#10#123ABC#"));
		System.out.println(adaNumber("10#0#"));
		System.out.println(!adaNumber("10##"));
		System.out.println(adaNumber("16#1234567890ABCDEFabcdef#"));
		System.out.println(!adaNumber("A16#1234567890ABCDEFabcdef#"));
	
	}
	
	private static boolean adaNumber(String line) {
		// Strip out all underscores
		line = line.replaceAll("_", "");
		
		return line.indexOf("#") < 0 ? isValidBase10(line) : isValidBaseN(line);
	}
	
	private static boolean isValidBase10(String line) {
		return line.matches("^[0-9]+$");
	}

	private static boolean isValidBaseN(String line) {
		String[] splitLine = line.split("#", 2);
		
		// Parse the base and check if in range
		int base;
		try {
			base = Integer.valueOf(splitLine[0]);
		} catch (NumberFormatException e) {
			base = -1;
		}
		if (base < 2 || base > 16) {
			return false;
		}
		
		// build the regex
		String regexRange= ""; 
		switch (base) {
			case 16: 
				regexRange = "[0-9a-fA-F]";
				break;
			case 15: 
				regexRange = "[0-9a-eA-E]";
				break;
			case 14: 
				regexRange = "[0-9a-dA-D]";
				break;
			case 13: 
				regexRange = "[0-9a-cA-C]";
				break;
			case 12: 
				regexRange = "[0-9a-bA-B]";
				break;
			case 11: 
				regexRange = "[0-9aA]";
				break;
			default:
				regexRange = "[0-" + String.valueOf(base-1) + "]";
		}

		return splitLine[1].matches("^" + regexRange + "+#$");
	}
}