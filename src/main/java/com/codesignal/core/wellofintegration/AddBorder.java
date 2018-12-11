package com.codesignal.core.wellofintegration;

public class AddBorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] res = addBorder(new String[] {"abc", "def"});
		for (String s : res) {
			System.out.println(s);
		}

	}

	private static String[] addBorder(String[] picture) {
		String[] result = new String[picture.length+2];
		
		result[0] = new String(new char[picture[0].length()+2]).replace("\0", "*");
		result[result.length-1] = result[0];
		for (int i=0; i<=picture.length-1; i++) {
			result[i+1] = "*" + picture[i] + "*";
		}
		
		return result;
	}
	

}
