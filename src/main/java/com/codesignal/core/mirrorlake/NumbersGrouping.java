package com.codesignal.core.mirrorlake;

import java.util.*;

public class NumbersGrouping {
	
	public static void main (String[] args) {
		int[] a = {20000, 239, 10001, 999999, 10000, 20566, 29999};
		System.out.println(numbersGrouping(a));
		
		int[] b = {685400881, 696804468, 696804942, 803902442, 976412678, 976414920, 47763597, 803900633, 233144924, 47764349, 233149077, 214990733, 214994039, 280528089, 280524347, 685401797};
		System.out.println(numbersGrouping(b));
	}
	
	private static int numbersGrouping(int[] a) {
		Set<Integer> headers = new HashSet<Integer>();
		
		for (int x:a) {
			headers.add((x-1)/10000);
		}
		
		return headers.size() + a.length;
	}
}
