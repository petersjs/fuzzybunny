package com.codesignal.core.wellofintegration;

import java.util.Arrays;

public class ThreeSplit {

	public static void main(String[] args) {
		System.out.println(threeSplit(new int[] {0, -1, 0, -1, 0, -1}));
	}
	
	private static int threeSplit(int[] a) {
		int count = 0;
		
		int aSum = Arrays.stream(a).sum();
		int target = aSum / 3;

		for (int sum1=0, i=0; i<a.length-2; i++) {
			sum1 += a[i];
			if (sum1 == target) {
				for (int sum2=0, j=i+1; j<a.length-1;j++) {
					sum2 += a[j];
					if (sum2 == target) {
						count++;
					}
				}
			}
		}

		return count;		
	}
}