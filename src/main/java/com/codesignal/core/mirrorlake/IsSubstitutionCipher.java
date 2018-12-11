package com.codesignal.core.mirrorlake;

import java.util.*;

public class IsSubstitutionCipher {

	public static void main (String... args) {
		System.out.println(isSubstitutionCipher("aaxyaa", "aazzaa"));
	}
	
	public static boolean isSubstitutionCipher(String s1, String s2) {
		boolean isCipher = s1 != null && s2 != null && s1.length() == s2.length();
		
		Map<String, String> leftToRight = new HashMap<String, String>();
		Map<String, String> rightToLeft = new HashMap<String, String>();
		
		for (int i=0; i < s1.length() && isCipher; i++) {
			String left = s1.substring(i, i+1);
			String right = s2.substring(i, i+1);
			
			if (leftToRight.containsKey(left)) {
				isCipher = leftToRight.get(left).equals(right) && rightToLeft.get(right).equals(left);
			} else {
				if (rightToLeft.containsKey(right)) {
					isCipher = false;
				} else {
					leftToRight.put(left, right);
					rightToLeft.put(right, left);
				}
			} 		
		}
		
		return isCipher;
	}
}
