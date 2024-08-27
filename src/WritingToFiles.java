
import java.io.*;
public class WritingToFiles {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter outFile = new PrintWriter (new FileWriter ("output.txt", true));
		outFile.print("heheheha");
		outFile.print("heheheha");
		outFile.print("heheheha");
		outFile.print("I missed the part where thats mhy problem");
		//PrintWriter outFile = new PrintWriter (new FileWriter ("output.txt", true));
		// Add true if you wish file to not be overwritten
		outFile.close();
	}

}
