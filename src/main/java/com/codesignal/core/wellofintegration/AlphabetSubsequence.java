package com.codesignal.core.wellofintegration;

public class AlphabetSubsequence {

	public static void main(String[] args) {
		System.out.println(alphabetSubsequence("abefx"));
		System.out.println(alphabetSubsequence("ab.fx"));
		System.out.println(alphabetSubsequence("aebfx"));
		System.out.println(alphabetSubsequence("a"));
		System.out.println(alphabetSubsequence("?"));
	}
	
	private static boolean alphabetSubsequence(String s) {
		boolean isSequence = true;
		String seq = "abcdefghijklmnopqrstuvwxyz";
		int prev = -1;
		
		for (int i=0; i<s.length() && isSequence; i++) {
			int pos = seq.indexOf(s.charAt(i));
			isSequence &= pos > prev;
			prev = pos;
		}
		
		return isSequence;
	}

}
