package com.codesignal.com.laboftranformations;

public class Cipher26 {

	public static void main(String[] args) {
		System.out.println(cipher26("taiaiaertkixquxjnfxxdh"));
	}
	
	private static String cipher26(String message) {
		final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
		
		StringBuffer result = new StringBuffer("");
		int runningTotal = 0;
		char[] cArray = message.toCharArray();
		
		for (char c : cArray) {
			int iIndex = ALPHA.indexOf(c);
			int dIndex = 0;
			if (iIndex >= runningTotal) {
				dIndex = iIndex - runningTotal;
			} else {
				dIndex = 26 - runningTotal + iIndex;
			}
			result.append(ALPHA.charAt(dIndex));
			
			runningTotal = (runningTotal + dIndex) % 26;
			System.out.println(runningTotal);
		}
		
		return result.toString();
	}

}
