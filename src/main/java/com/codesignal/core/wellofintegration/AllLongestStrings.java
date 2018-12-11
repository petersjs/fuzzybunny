package com.codesignal.core.wellofintegration;

import java.util.*;
import java.util.stream.IntStream;

public class AllLongestStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"Tom", "Jonat", "Fred", "Betty", "Qi", "Clark"};
		System.out.println(allLongestStrings(a).length);
	}
	
	private static String[] allLongestStrings(String[] a) {
		
		return Arrays.stream(a).filter(i->i.length()==IntStream.range(0,a.length).map(j->a[j].length()).max().getAsInt()).toArray(String[]::new);
		
	}
}
