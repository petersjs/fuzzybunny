package com.codesignal.com.laboftranformations;

public class RelflectString {

	public static void main(String[] args ) {
		System.out.println(reflectString("abcxyz"));
	}
	
	private static String reflectString(String inputString) {
		StringBuffer out = new StringBuffer();
		
		for (char s : inputString.toCharArray()) {
			out.append((char) ('n' - (s-'m')));
		}
		
		return out.toString();
	}
}
