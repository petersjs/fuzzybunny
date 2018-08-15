package com.comics;

import java.io.File;

public class FileLister {
	
	public static void main(String... args) {
		final String ICLOUD_ROOT= "/users/joepeterson/library/mobile documents/com~apple~clouddocs";
		final File folder = new File(ICLOUD_ROOT + "/DC week+ (07-18-18)");
	
		listFilesForFolder(folder);
	}

	public static void listFilesForFolder(final File folder) {
		System.out.println("Listing files");
		
		for (final File fileEntry : folder.listFiles()) {
			if (!fileEntry.isDirectory()) {
				System.out.println(fileEntry.getName());
		
				System.out.println(NameUpdater.updateFileName(fileEntry.getName()));
			}
		}
		
		System.out.println("Done listing files");
	}
}
