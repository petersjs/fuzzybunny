package com.codesignal.core.mirrorlake;

public class CrosswordFormation {

	public static void main(String[] args) {
		
		String[] input = {"crossword", "square", "formation", "something"};
		int count = 0;
		
		for (int top=0; top<input.length; top++) {
			for (int bottom=0; bottom<input.length; bottom++) {
				for (int left=0; left<input.length; left++) {
					for (int right=0; right<input.length; right++) {
						if (allDifferent(left, right, top, bottom)) {
							String tWord = input[top];
							String bWord = input[bottom];
							String lWord = input[left];
							String rWord = input[right];
							
							for (int t=0; t<tWord.length()-2; t++) {
								for (int b=0; b<bWord.length()-2; b++) {
									for (int l=0; l<lWord.length()-2; l++) {
										for (int r=0; r<rWord.length()-2; r++) {
											int maxh = Math.min(tWord.length()-t,bWord.length()-b);
											int maxv = Math.min(lWord.length()-l,rWord.length()-r);
									
											for (int h=2; h<maxh; h++) { 
												for (int v=2;v<maxv; v++) {
													if (true) {
														if (tWord.charAt(t) == lWord.charAt(l) &&
																tWord.charAt(t+h) == rWord.charAt(r) &&
																bWord.charAt(b) == lWord.charAt(l+v) &&
																bWord.charAt(b+h) == rWord.charAt(r+v)
																) 
														count++;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static boolean allDifferent(int t, int b, int l, int r) {
		return (t!=b && t!=l && t!=r && b!=l && b!=r && l!=r);
	}
}
