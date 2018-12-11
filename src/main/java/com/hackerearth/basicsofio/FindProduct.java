package com.hackerearth.basicsofio;

import java.util.*;

class FindProduct {
	public static void main(String args[] ) throws Exception {
	
	    Scanner s = new Scanner(System.in);
	    int numberOfItems = s.nextInt();      
	    int total = 0;
	    if (numberOfItems > 0) {
	        total = 1;
	        while (s.hasNextInt()) {
	        		total = (total * s.nextInt()) % (1000000000 + 7);
	        }
	    }
	
	    System.out.println(total);
	
	}
}