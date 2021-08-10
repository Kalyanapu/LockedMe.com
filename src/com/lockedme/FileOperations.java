package com.lockedme;

import java.io.File;

public class FileOperations {

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
