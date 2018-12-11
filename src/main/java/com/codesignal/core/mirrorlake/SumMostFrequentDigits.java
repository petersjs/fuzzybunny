package com.codesignal.core.mirrorlake;

import java.util.*;

public class SumMostFrequentDigits {

	public static void main(String[] args) {
		System.out.println(mostFrequentDigitSum(88));
		System.out.println(mostFrequentDigitSum(8));
	}
	
	private static int mostFrequentDigitSum(int n) {
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		while (n>0) {
			int x = sumDigits(n);
			if (!m.containsKey(x)) {
				m.put(x, 1);
			} else {
				int count = m.get(x);
				m.put(x, count+1);
			}
			n-=x;
		}
		m.put(0, 1);
		
		return mostCommon(m);
	}
	
	private static int sumDigits(int i) {
		int sum = 0;
		
		while (i>0) {
			sum += i%10;
			i /= 10;
		}
		
		return sum;
	}
	
	private static int mostCommon(Map<Integer, Integer> m) {
		int maxValue = -1;
		int maxKey = -1;
		
		for(Map.Entry<Integer, Integer> entry : m.entrySet()) {
			if (entry.getValue() > maxValue) {
				maxKey = entry.getKey();
				maxValue = entry.getValue();
			} else if (entry.getValue() == maxValue && entry.getKey() > maxKey){
				maxKey = entry.getKey();
			}
		}
		
		return maxKey;
	}
}
