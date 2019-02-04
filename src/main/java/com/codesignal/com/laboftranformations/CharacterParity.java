package com.codesignal.com.laboftranformations;

public class CharacterParity {
	
	public static void main (String[] args) {
		System.out.println(characterParity('a'));
		System.out.println(characterParity('4'));
	}

	private static String characterParity(char symbol) {
		String result = "";
		
		int i = Character.digit(symbol, 10);
		if (i < 0) {
			result = "not a digit";
		} else {			
			result = i % 2 == 0 ? "even" : "odd";
		}
		
		return result;	
	}
}