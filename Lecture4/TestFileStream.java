
/**
 * Demonstrates input/output streams for binary files.
 * @author https://liveexample.pearsoncmg.com/html/TestFileStream.html
 *
 */

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestFileStream {
	  public static void main(String[] args) throws IOException {
	    try (
	      // Create an output stream to the file
	      FileOutputStream output = new FileOutputStream("temp.dat");
	    ) {
	      // Output values to the file
	      for (int i = 1; i <= 10; i++)
	        output.write(i);
	      output.close();
	    }

	    try (
	      // Create an input stream for the file
	      FileInputStream input = new FileInputStream("temp.dat");
	    ) {
	      // Read values from the file
	      int value;
	      while ((value = input.read()) != -1)
	        System.out.print(value + " ");
	      input.close();
	    }
	  }
	}