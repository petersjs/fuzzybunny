package com.codesignal.core.mirrorlake;

import java.util.*;

public class NumberOfClans {

	public static void main(String[] args) {
		int[] a = {6, 2, 2, 8, 9, 2, 2, 2, 2};
		System.out.println(numberOfClans(a, 10));
	}
	
	private static int numberOfClans(int[] divisors, int k) {
		Set<String> clans = new HashSet<String>();
		String key;
		
		for (int i=1; i<=k; i++) {
			key = ":";
			for (int j=0; j<divisors.length; j++) {
				if (i%divisors[j] == 0) {
					key += j + ":";
				}
			}
			clans.add(key);
		}
		
		return clans.size();
	}
}