package com.lockedme;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HandleFileOptions {
	/**
	 * This method will return the file names from the folder
	 * @param floderPath
	 * @return List<String>
	 */

	public static List<String> getAllFiles(String floderPath) {
		// Creating the file Object
		File file = new File(floderPath);

		// getting all the files into FileArray
		File[] listOfFiles = file.listFiles();

		// Declare a ArrayList to store the file names
		List<String> fileNames = new ArrayList<String>();
		// We are looping the listOfFiles and
		for (File f : listOfFiles) {
			fileNames.add(f.getName());
		}
		return fileNames;

	}

}
