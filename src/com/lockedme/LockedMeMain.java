package com.lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeMain {

	static final String folderPath = "D:\\java-01\\Phase-01 Project\\LockedMeProjectFiles";

	public static void main(String[] args) {

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

	}
}