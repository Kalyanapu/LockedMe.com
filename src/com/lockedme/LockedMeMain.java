package com.lockedme;

import java.util.List;

public class LockedMeMain {

	static final String folderPath = "D:\\java-01\\Phase-01 Project\\LockedMeProjectFiles";

	public static void main(String[] args) {

		List<String> fileNames = FileOperations.getAllFiles(folderPath);
		for (String f : fileNames) {
			System.out.println(f);
		}

	}
}
