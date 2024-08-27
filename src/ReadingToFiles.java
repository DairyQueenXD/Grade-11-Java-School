import java.util.*;
import java.io.*;
public class ReadingToFiles {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner inFile = new Scanner (new FileReader ("input.txt"));
		String line;
		while (inFile.hasNextLine())  {
			// inFile.hasNextInt(), inFile.hasNextDouble()
			line = inFile.nextLine();
			System.out.println(line);
		}
		inFile.close();
	}

}
