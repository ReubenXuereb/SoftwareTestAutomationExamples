package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordCounter extends Task {

	private String textLocation;

	@Override
	public boolean configure(List<String> toCheck) {
		// TODO Auto-generated method stub

		textLocation = toCheck.get(0);
		if (textLocation == null || textLocation.isEmpty()) {
			return false;
		} else {

			File file = new File(textLocation);
			if (!file.exists()) {
				return false;
			}else {
				this.params = toCheck;
				return true;
			}
		}
	}

	@SuppressWarnings("resource")
	@Override
	public String run() {
		
		//text file location
		String path = "D://test.txt";
		File file = new File(path);
		Scanner scan;

		List<String> conf = new ArrayList<String>();
		conf.add(path);
		if (configure(conf) == true) {
			try {
				scan = new Scanner(file);
				// TODO Auto-generated method stub
				int count = 0;
				while (scan.hasNext()) {
					scan.next();
					count++;
				}
				return "Number of words: " + count;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				return "error";
			}

		} else
			return "Wrong path entered or no path entered. Please enter a proper path.";
	}
}

/*
 * @SuppressWarnings("resource") public String run() { File file = new
 * File(textLocation);
 * 
 * @SuppressWarnings("resource") Scanner scanner; int count = 0; try { scanner =
 * new Scanner(file);
 * 
 * while (scanner.hasNext()) { String word = scanner.next(); if
 * (word.indexOf("\\") == -1) { count++; } } return "Number of words: " + count;
 * 
 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } return null; }
 */
