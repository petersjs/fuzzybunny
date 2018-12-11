package com.codesignal.core.wellofintegration;

public class SwitchLights {

	public static void main(String[] args) {
		int[] res = switchLights(new int[] {1,1,1,1,1});
		
		for (int i: res) {
			System.out.println(i);
		}
	}
	
	private static int[] switchLights(int[] a) {
		for (int i=0; i<a.length; i++) {
			if (a[i] == 1) {
				for (int j=0; j<=i; j++) {
					a[j] = (a[j]+1)%2;
				}
			}
		}
		return a;
	}
}
