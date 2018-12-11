package com.codesignal.core.wellofintegration;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class HouseOfCats {

	public static void main(String[] args) {
		int[] a = houseOfCats(8);
	
		for (int i : a) {
			System.out.println(i);
		}
	}
	
	private static int[] houseOfCats(int legs) {
		return IntStream.range(0, (legs/2)+1).filter(i->(legs-(i*2))%4==0).toArray();
	}

}
