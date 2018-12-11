package com.codesignal.core.mirrorlake;

import java.util.*;

public class DifferentSquares {
	
	public static void main(String[] args) {
		int[][] m = {{1,2,1}, {2,2,2}, {2,2,2}, {1,2,3}, {2,2,1}};
		System.out.println(differentSquares(m));
	}
	
	private static int differentSquares(int[][] matrix) {
		Set<String> m = new HashSet<String>();
		
		for (int row=0; row<matrix.length-1; row++) {
			for (int col=0; col<matrix[row].length-1; col++) {
				m.add(matrix[row][col] + ":" + matrix[row][col+1] + ":" + matrix[row+1][col] + ":" + matrix[row+1][col+1]);
			}
		}
		
		return m.size();
	}
}