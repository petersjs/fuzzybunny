package com.codesignal.core.wellofintegration;

public class MinimalNumberOfCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(minimalNumberOfCoins(new int[]{1,2,10}, 38));

	}

	private static int minimalNumberOfCoins(int[] coins, int price) {
		int  numCoins = 0;
		
		for (int i=coins.length-1; i>=0; i--) {
			while (price >= coins[i]) {
					numCoins++;
				price -= coins[i];
			}
		}
		
		return numCoins;
	}
}
