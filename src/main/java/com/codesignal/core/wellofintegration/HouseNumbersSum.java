package com.codesignal.core.wellofintegration;

public class HouseNumbersSum {

	public static void main(String[] args) {
		int[] a = {5, 1, 2, 3, 0, 1, 5, 0, 2};
		System.out.println(houseNumbersSum(a));

	}
	
	private static int houseNumbersSum(int[] inputArray) {
		int sum = 0;
		
		for (int i : inputArray) {
			if (i==0) break;
			sum += i;
		}
		return sum;
	}

}
