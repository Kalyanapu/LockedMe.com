package com.lockedme;

import java.util.Scanner;

public class LockedMeMain {

	static final String folderPath = "D:\\java-01\\Phase-01 Project\\LockedMeProjectFiles";

	public static void main(String[] args) {

		String f;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the file name to be deleted:");
		f = scanner.nextLine();

		boolean isDeleted = FileOperations.deleteFile(folderPath, f);
		if (isDeleted)
			System.out.println("file deleted successfully");
		else
			System.out.println("Either file is no there  or some access failure");

	}
	



	}