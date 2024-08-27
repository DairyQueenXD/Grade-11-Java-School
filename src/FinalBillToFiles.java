import java.util.Scanner;
import java.io.*;
public class FinalBillToFiles {

	public static void main(String[] args) throws IOException, FileNotFoundException{
		PrintWriter outFile = new PrintWriter (new FileWriter ("output.txt"));
		Scanner in = new Scanner (new FileReader ("input.txt"));
		
		double cost = Double.parseDouble(in.nextLine());
		cost = Math.round(cost*100)/100.0;
		
		int numPokemon = Integer.parseInt(in.nextLine());
		
		int numPersons = Integer.parseInt(in.nextLine());
		
		double finalCost = cost * 1.13 * 1.1 - 0.5*numPokemon;
		finalCost = Math.round(finalCost*100)/100.0;
		double finalCostPerPerson = finalCost / numPersons;
		finalCostPerPerson = Math.round(finalCostPerPerson*100)/100.0;
		
		outFile.printf("Final Bill: $%.2f%nFinal Cost Per Person: $%.2f", finalCost, finalCostPerPerson);
		in.close();
		outFile.close();
	}
}