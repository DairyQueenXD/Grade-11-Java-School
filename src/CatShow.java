
import java.util.*;
public class CatShow {
	public static void main(String[] args) {
		double ticket = 28.50;
		boolean error = true;
		Scanner in = new Scanner (System.in);
		System.out.print("Enter your age: ");
		int age = Integer.parseInt(in.nextLine());

		if (age > 120 || age < 0) {
			System.out.print("Invalid age. Please enter a new age.");
			error = false;
		} else if (age <= 12) { // child
			ticket *= 0.5;
		} else if (age > 65) { // senior
			ticket *= 0.35;
		} else if (age < 18) { // teenager
			ticket *= 0.7;
		} else { // adult
			System.out.print("How many cats do you have?: ");
			int cats = Integer.parseInt(in.nextLine());
			if (cats < 0) {
				System.out.print("You can't own a negative number of cats...");
				error = false;
			} else if (cats >= 1 ) {
				System.out.print("Do you own a cat named Suki, Snuggles or Spotty? (yes/no): ");
				String nameCat = in.nextLine();
				if (nameCat.equals("Yes") || nameCat.equals("yes")) {
					ticket = 0;
				} else {
					if (cats == 1) {
						ticket *= 0.95;
					} else {
						ticket *= 0.92;
					}
				}	
			} else {
				ticket *= 1.02;
			}
		}
		if (error) {
			System.out.printf("Your ticket price will be %.2f.", ticket);
		}
		in.close();

	}
}
