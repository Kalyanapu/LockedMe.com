package com.lockedme;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeMain {

	// Here We are making static final so that it will be a constant user cannot
	// change the path
	static final String folderPath = "D:\\java-01\\Phase-01 Project\\LockedMeProjectFiles";

	public static void main(String[] args) {
		List<String> fileNames = FileOperations.getAllFiles(folderPath);
		for (String f : fileNames) {
			System.out.println(f);
		}

		Scanner sc = new Scanner(System.in);
		String fileName;
		int linesCount;
		List<String> content = new ArrayList<String>();
		System.out.println("Enter the filename");
		fileName = sc.nextLine();

		System.out.println("Enter the how many lines in the file:");
		linesCount = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= linesCount; i++) {
			System.out.println("Enter line" + i + ":");
			content.add(sc.nextLine());
		}

		boolean isSaved = FileOperations.writeContentToFile(folderPath, fileName, content);
		if (isSaved) {
			System.out.println("File and data saved successfully");
		} else {
			System.out.println("Some error occurred.Please contact development team");
		}

		String f;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the file name to be deleted:");
		f = scanner.nextLine();

		boolean isDeleted = FileOperations.deleteFile(folderPath, fileName);
		if (isDeleted)
			System.out.println("file deleted successfully");
		else
			System.out.println("Either file is no there  or some access failure");

	}
	

}
