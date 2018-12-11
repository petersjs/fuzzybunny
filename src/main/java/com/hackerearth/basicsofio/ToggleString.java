package com.hackerearth.basicsofio;

import java.util.Scanner;

public class ToggleString {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		char[] chars = s.next().toCharArray();
		StringBuffer out = new StringBuffer();

		for (char c : chars) {
			if (Character.isLowerCase(c)) {
				out.append(Character.toUpperCase(c));
			} else if (Character.isUpperCase(c)) {
				out.append(Character.toLowerCase(c));
			} else {
				out.append(c);
			}
		}

		System.out.println(out.toString());
	}
}
