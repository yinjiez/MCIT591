package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Abstract class to read data from CSV files
 * 
 * @author porth
 *
 */
public abstract class CSVReader {

	public CSVReader() {
	}

	/**
	 * abstract method putData to populate various data structures with values from
	 * the input file
	 * 
	 * @param columnInfo
	 */
	public abstract void putData(String[] columnInfo);

	/**
	 * Read file method accepts name (path) of .csv file, skips first line and
	 * processes file line by line, calling putData at each line
	 * 
	 * @param filename
	 */
	public void readFile(String filename) {
		File file = new File(filename);
		try {
			Scanner scan = new Scanner(file);
			scan.nextLine();
			while (scan.hasNextLine()) {
				String itemRow = scan.nextLine();
				// System.out.println(itemRow);
				String[] columnInfo = itemRow.split(",");
				putData(columnInfo);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
/**
 * ReadLine method creates BufferedReader to read a single line of 
 * text after skipping the first line of a file
 * @param fileName
 * @throws FileNotFoundException
 */
	public void readOneLine(String fileName) throws FileNotFoundException {
		BufferedReader rdr;

		rdr = new BufferedReader(new FileReader(fileName));
		try {
			//skip the first line
			rdr.readLine();
			//read the second line and assign to itemRow
			String itemRow = rdr.readLine();
			//if row has contents split into fields
			if(itemRow != null) {
				String[] columnInfo = itemRow.split(",");
				putData(columnInfo);
			}
			rdr.close();
		}

		catch (IOException e) {

			e.printStackTrace();

		}

	}

	/**
	 * Reads file and counts the number of non-empty lines.
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	public static int readNumberOfLines(String filename) throws FileNotFoundException {

		BufferedReader br;

		br = new BufferedReader(new FileReader(filename));
		int counter = 0;
		String currentLine;
		try {
			while ((currentLine = br.readLine()) != null) {
				counter++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return counter;

	}

}
