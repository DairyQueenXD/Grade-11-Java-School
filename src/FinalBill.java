
import java.util.*;
public class FinalBill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		System.out.print("Enter the cost of food: ");
		double cost = Double.parseDouble(in.nextLine());
		cost = Math.round(cost*100)/100.0;
		System.out.print("Enter the number of Pokemon caught: ");
		int numPokemon = Integer.parseInt(in.nextLine());
		System.out.print("Enter the number of persons: ");
		int numPersons = Integer.parseInt(in.nextLine());
		
		double finalCost = cost * 1.13 * 1.1 - 0.5*numPokemon;
		finalCost = Math.round(finalCost*100)/100.0;
		double finalCostPerPerson = finalCost / numPersons;
		finalCostPerPerson = Math.round(finalCostPerPerson*100)/100.0;
		
		System.out.printf("Final Bill: $%.2f%nFinal Cost Per Person: $%.2f", finalCost, finalCostPerPerson);
		in.close();
	}

}
