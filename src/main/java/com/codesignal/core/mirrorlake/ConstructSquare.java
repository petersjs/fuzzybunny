package com.codesignal.core.mirrorlake;

import java.util.*;

public class ConstructSquare {
	
	public static void main (String[] args) {
		System.out.println(constructSquare("aaaabbcde"));
	}
	
	public static int constructSquare(String s) {
		int root = 100000;
		boolean rootFound = false;
		String pattern = encode(s);
		
		for (; root>1 && !rootFound; root--) {
			long x = (long) root * (long) root;
			String square = String.valueOf(x);
			
			if (square.length() < s.length()) {
				root = -1;
				break;
			} else if (square.length() == s.length()) {
				rootFound = pattern.equals(encode(square));
				if (rootFound) break;
			}
		}
		
		return rootFound ? root * root : -1;
	}
	
	public static String encode(String s) {
		System.out.println("encoding: " + s);
		String encodedString = "";
		List<String> aList = new ArrayList<String>();

		while (s.length() > 0) {
			int oldLen = s.length();
			s = s.replace(s.substring(0, 1), "");
			aList.add(String.valueOf(oldLen-s.length()));
		}
		String[] arr = new String[aList.size()];
		arr = aList.toArray(arr);
		Arrays.sort(arr);
		
		encodedString = String.join("", arr);
		System.out.println("result: " + encodedString);

		return encodedString;
	}

}
