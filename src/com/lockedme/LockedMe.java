package com.lockedme;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMe {
	// Declaring the initial parameters
	static String DIRECTORY;
	File folder_name;

	/**
	 * If the folder & Directory is not present we are creating the folder And we
	 * are displaying the folderpath in the user interface
	 */
	// Constructor to initialize the Parameters
	public LockedMe() {
		DIRECTORY = System.getProperty("user.dir");
		folder_name = new File(DIRECTORY + "/filesStorage");
		if (!folder_name.exists())
			folder_name.mkdirs();
		System.out.println("DIRECTORY : " + folder_name.getAbsolutePath());
	}

	// Displaying the printWelcomeScreen
	private static final String printWelcomeScreen = "\n*****************  LockedMe.com *******************"
			+ "\n***************** Naveen kumar.k *******************\n";
	// Displaying the menuOptions so that user can choose one of the following
	private static final String menuOptions = "\nMAIN MENU - Select any of the following: \n"
			+ "1 -> List files in directory\n" + "2 -> Add, Delete or Search\n" + "3 -> Exit Program";
	// Displaying the BusinessLevel operations so that user can choose one of the
	// following
	private static final String HandleOptions = "   \nSelect any of the following: \n" + "   a -> Add a file\n"
			+ "   b -> Delete a file\n" + "   c -> Search a file\n" + "   d -> GoBack";

	/**
	 * We are Displaying the menuOptions so that user can able to know what are the
	 * functionalities are there in this application
	 */
	void showPrimaryMenu() {
		System.out.println(menuOptions);
		try {
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			switch (option) {
			case 1: {
				showFiles();
				showPrimaryMenu();
			}
			case 2: {
				showSecondaryMenu();
			}
			case 3: {
				System.out.println("Thank You");
				System.exit(0);
			}
			default:
				showPrimaryMenu();
			}
		} catch (Exception e) {
			System.out.println("Please enter 1, 2 or 3");
			showPrimaryMenu();
		}
	}

	/**
	 * The Business level operations we are performing in the switchCase so that
	 * user can do whatever operation he want
	 */
	void showSecondaryMenu() {
		System.out.println(HandleOptions);
		try {
			Scanner scanner = new Scanner(System.in);
			char[] input = scanner.nextLine().toLowerCase().trim().toCharArray();
			char option = input[0];

			switch (option) {
			case 'a': {
				System.out.print("↳ Adding a file...Please Enter a File Name : ");
				String filename = scanner.next().trim().toLowerCase();
				addFile(filename);
				break;
			}
			case 'b': {
				System.out.print("↳ Deleting a file...Please Enter a File Name : ");
				String filename = scanner.next().trim();
				deleteFile(filename);
				break;
			}
			case 'c': {
				System.out.print("↳ Searching a file...Please Enter a File Name : ");
				String filename = scanner.next().trim();
				searchFile(filename);
				break;
			}
			case 'd': {
				System.out.println("Going Back to MAIN menu");
				showPrimaryMenu();
				break;
			}
			default:
				System.out.println("Please enter a, b, c or d");
			}
			showSecondaryMenu();
		} catch (Exception e) {
			System.out.println("Please enter a, b, c or d");
			showSecondaryMenu();
		}
	}

	/**
	 * This method will display which are files present in the folder & we will sort
	 * in the ascending order
	 */
	void showFiles() {
		if (folder_name.list().length == 0)
			System.out.println("The folder is empty");
		else {
			String[] list = folder_name.list();
			System.out.println("The files in " + folder_name + " are :");
			Arrays.sort(list);
			for (String str : list) {
				System.out.println(str);
			}
		}
	}

	/**
	 * user will able to add the file if file is not present we will create a new
	 * file as requried by the user
	 * 
	 * @param filename
	 * @throws IOException
	 */
	void addFile(String filename) throws IOException {
		File filepath = new File(folder_name + "/" + filename);
		String[] list = folder_name.list();
		for (String file : list) {
			if (filename.equalsIgnoreCase(file)) {
				System.out.println("File " + filename + " already exists at " + folder_name);
				return;
			}
		}
		// Creating the file in the filepath
		filepath.createNewFile();
		System.out.println("File " + filename + " added to " + folder_name);
	}

	/**
	 * user will able to delete the file which is present in the folder if file not
	 * present (FILE NOT FOUND)
	 * 
	 * @param filename
	 */
	void deleteFile(String filename) {
		File filepath = new File(folder_name + "/" + filename);
		String[] list = folder_name.list();
		for (String file : list) {
			if (filename.equals(file) && filepath.delete()) {
				System.out.println("File " + filename + " deleted from " + folder_name);
				return;
			}
		}
		System.out.println("Delete Operation failed. FILE NOT FOUND");
	}

	/**
	 * User will search the file present in the folder if its found will display it
	 * otherwise will display FNF
	 * 
	 * @param filename
	 */
	void searchFile(String filename) {
		String[] list = folder_name.list();
		for (String file : list) {
			if (filename.equals(file)) {
				System.out.println("FOUND : File " + filename + " exists at " + folder_name);
				return;
			}
		}
		System.out.println("File NOT found (FNF)");
	}

	public static void main(String[] args) {
		System.out.println(printWelcomeScreen);
		LockedMe menu = new LockedMe();
		menu.showPrimaryMenu();
	}
}