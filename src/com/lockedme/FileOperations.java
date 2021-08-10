package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileOperations {

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
}
