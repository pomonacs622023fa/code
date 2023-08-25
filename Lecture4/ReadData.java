
/**
 * Demonstrates how to read data from a text file.
 * @author https://liveexample.pearsoncmg.com/html/ReadData.html
 *
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadData {
	public static void main(String[] args) {

		Scanner input = null;
		// Create a Scanner for the file
		try {
			input = new Scanner(new File("addresses.txt"));

			// Read data from a file
			while (input.hasNext()) {
				String firstName = input.next();
				String lastName = input.next();
				int room = input.nextInt();
				System.out.println(firstName + " " + lastName + " " + room);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (input != null)
				input.close();
		}

	}
}
