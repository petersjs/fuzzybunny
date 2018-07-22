package com.geocaching;

public class ROT13 {

	public static final int ROTATE_AMOUNT = 13;
	
	public static String decode(String source) {
		StringBuffer sb = new StringBuffer();
		
		if (source != null) {
			for(int i = 0; i < source.length(); i++) {
				char c = source.charAt(i);
				
				if (c >= 'A' && c <= 'Z') {
					c += 13;
					if (c > 'Z') c -= 26;
				}
				if (c >= 'a' && c <= 'z') {
					c += 13;
					if (c > 'z') c -= 26;
				}
				
				sb.append(c);
			
			}
		}
		
		return sb.toString();		
	}
}