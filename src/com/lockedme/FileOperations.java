package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {
	/**
	 * This method will return the file names from the folder
	 * 
	 * @param folderPath
	 * @return List<String>
	 */
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

	/**
	 * 
	 * @param folderPath
	 * @param fileName
	 * @param content
	 * @return
	 */

	public static boolean writeContentToFile(String folderPath, String fileName, List<String> content) {

		File f = new File(folderPath, fileName);
		try {
			FileWriter fw = new FileWriter(f);

			for (String s : content) {
				fw.write(s + "\n");
			}
			fw.flush();
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;

		}

	}

	public static boolean deleteFile(String folderPath, String fileName) {

		File file = new File(folderPath + "\\" + fileName);
		try {
			if (file.delete())
				return true;
			else
				return false;

		} catch (Exception e) {
			return false;
		}
	}
}
