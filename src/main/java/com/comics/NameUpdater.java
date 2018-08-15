package com.comics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameUpdater {

	public static String updateFileName(String inputFileName) {
		String title = "";
		String volume = "";
		String issueNumber = "";
		String series = "";
		String coverDate = "";
		String fileExtension = "";
		
		if (inputFileName == null) {
			inputFileName = "";
		}
		
		// Prepare file
		inputFileName = inputFileName.replaceAll(" & ", " and ");
		inputFileName = inputFileName.replaceAll(" ", " ");
		inputFileName = inputFileName.replaceAll("(?i)\\(of ", "\\(of_");
		
		//fileExtension
		
		// Get Tokens
		boolean addToTitle = true;
		String[] result = inputFileName.split(" ");
		for (String token : result) {
			if (isVolume(token))  {
				volume = " " + token;
				addToTitle = false;
			}
			if (isIssueNumber(token)) {
				issueNumber = " " + token;
				addToTitle = false;
			}
			if (isSeries(token)) {
				series = " " + token.replaceAll("_", " ");
				addToTitle = false;
			}
			if (isCoverDate(token)) {
				coverDate = " " + token;
				addToTitle = false;
			}
			if (addToTitle) {
				title += (title.length() > 0 ? " " : "") + token;
			}
		}
		
		// Clean up string
		if (series.length() == 7) {series = series.replace("of ", "of 0");}
		
		return title + volume + issueNumber + series + coverDate;
	}
	
	private static boolean isVolume(String s) {
		Pattern pattern = Pattern.compile("^v[0-9]$");
		Matcher matcher = pattern.matcher(s);
		
		return matcher.find();
	}
	
	public static boolean isIssueNumber(String s) {
		Pattern pattern = Pattern.compile("^[0-1]?[0-9]?[0-9][0-9]$");
		Matcher matcher = pattern.matcher(s);
		
		return matcher.find();
	}
	
	public static boolean isSeries(String s) {
		Pattern pattern = Pattern.compile("^\\(of_[0-3]?[0-9]\\)$");
		Matcher matcher = pattern.matcher(s);
		
		return matcher.find();
	}
	
	public static boolean isCoverDate(String s) {
		Pattern pattern = Pattern.compile("^\\(([0-1][0-9]-)?[1-2][0-9]{3}\\)$");
		Matcher matcher = pattern.matcher(s);

		return matcher.find();
	}
	
	
	
}
