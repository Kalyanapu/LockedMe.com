package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {

	public static List<String> getAllFiles(String folderPath) {
		// Creating the file Object
		File file = new File(folderPath);

		// getting all the files into FileArray
		File[] listOfFiles = file.listFiles();

		// Declare a ArrayList to store the file names
		List<String> fileNames = new ArrayList<String>();
		// We are looping the listOfFiles and we will return the filenames
		for (File f : listOfFiles)
			fileNames.add(f.getName());

		// return the List
		return fileNames;

	}

}