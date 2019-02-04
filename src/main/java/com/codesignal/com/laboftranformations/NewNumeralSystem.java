package com.codesignal.com.laboftranformations;

import java.util.ArrayList;

public class NewNumeralSystem {

	public static void main(String[] args) {
		String[] result = newNumeralSystem('H');
		for (String s : result) {
			System.out.println("> " + s);
		}
	}
	
	public static String[] newNumeralSystem(char number) {
		ArrayList<String> result = new ArrayList<String>();
		
		for (char c1='A', c2=number; c1<=c2; c1++, c2--) {
			result.add(String.valueOf(c1) + " + " + String.valueOf(c2));
		}
		
		return result.toArray(new String[result.size()]);		
	}
}