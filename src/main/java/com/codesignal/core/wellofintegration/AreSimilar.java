package com.codesignal.core.wellofintegration;

public class AreSimilar {

	public static void main(String[] args) {
		System.out.println(areSimilar(new int[] {1,2,2}, new int[] {2,1,2}));
		System.out.println(areSimilar(new int[] {2,1,2}, new int[] {2,1,2}));
		System.out.println(areSimilar(new int[] {1,2,3}, new int[] {3,1,2}));
	}
	
	private static boolean areSimilar(int[] a, int[] b) {
		boolean isSimilar = true;
		int missCount = 0;
		int aMiss = 0;
		int bMiss = 0;
		
		for (int i=0; i<a.length && isSimilar; i++) {
			if (a[i] != b[i]) {
				if (missCount==0) {
					aMiss = a[i];
					bMiss = b[i];
				} else if (missCount == 1) {
					if (bMiss != a[i] || aMiss != b[i]) {
						isSimilar = false;
					}
				} else {
					isSimilar = false;
				}
				missCount++;
			}
		}
		
		return isSimilar;
	}

}
