package com.codesignal.core.wellofintegration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimedReading {

	public static void main(String[] args) {
		System.out.println(timedReading(4, "The Fox asked the stork, 'How is the soup?'"));
	}
	
	private static int timedReading(int maxLength, String text) {
		Pattern p = Pattern.compile("\\b[a-zA-Z]{1,"+maxLength+"}\\b");
		Matcher m = p.matcher(text);
	
		int i=0;
		while (m.find()) {
			i++;
		}
		return i;
	}

}
