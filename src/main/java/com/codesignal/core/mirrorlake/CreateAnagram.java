package com.codesignal.core.mirrorlake;

public class CreateAnagram {

	public static void main(String[] args) {
		System.out.println(createAnagram("AABAA", "ABBAA"));
		System.out.println(createAnagram("OVGHK", "RPGUC"));
	}
	
	public static int createAnagram(String s1, String s2) {
		for (int i=0; i<s1.length(); i++) {
			s2 = s2.replaceFirst(s1.substring(i,i+1),  "");
		}
		return s2.length();
	}
}
