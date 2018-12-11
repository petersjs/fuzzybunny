package com.codesignal.core.wellofintegration;

import java.util.Arrays;

public class ElectionsWinners {
	
	public static void main (String[] args) {
		System.out.println(electionsWinners(new int[] {2,3,5,2}, 3));
		System.out.println(electionsWinners(new int[] {5,1,3,4,1}, 0));
		System.out.println(electionsWinners(new int[] {5,1,5,4,1}, 0));
	}
	
	private static int electionsWinners(int[] votes, int k) {
		int max = Arrays.stream(votes).max().getAsInt();
		int numMax = (int) Arrays.stream(votes).filter(x->x==max).count();
		int numWinners = (int) Arrays.stream(votes).filter(x->x+k>max).count();
		
		return k > 0 ? numWinners : numMax == 1 ? 1 : 0;
	}
}