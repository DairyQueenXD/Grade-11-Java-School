
import java.util.*;

// Name: Dequan Kong
// Assignment: String Programming Exercise #2
// Date: October 17, 2023

public class StringProgrammingExercise2 {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		String phrase, insert, remove, replace;
		int option, position, lastRemoved;
		boolean var = true;
		while (var) {

			System.out.print("Choose from the following options: \n1) Insert\n2) Delete\n3) Replace"
					+ "\nEnter a number (1, 2, or 3): ");
			option = Integer.parseInt(in.nextLine());

			System.out.print("\nEnter a phrase: ");
			phrase = in.nextLine();
			if (option == 1) {
				System.out.print("What word would you like to add in your phrase?: ");
				insert = in.nextLine();
				do {
					System.out.print("What position would you like to insert the word?: ");
					position = Integer.parseInt(in.nextLine());
					if (position < 0 || position > phrase.length()) {
						System.out.println("Invalid input. Please try again!");
					}
				} while (position < 0 || position > phrase.length());
				phrase = phrase.substring(0, position) + insert + phrase.substring(position);
				System.out.println(phrase + "\n");
			} else if (option == 2) {
				System.out.print("What word would you like to remove from your phrase?: ");
				remove = in.nextLine().toLowerCase();
				while (phrase.toLowerCase().indexOf(remove) != -1) {
					phrase = phrase.substring(0,phrase.toLowerCase().indexOf(remove)) 
							+ phrase.substring(phrase.toLowerCase().indexOf(remove)+remove.length());
				}
				System.out.println(phrase);
			} else if (option == 3){
				System.out.print("What word would you like to remove from your phrase?: ");
				remove = in.nextLine().toLowerCase();
				System.out.print("What word would you like to replace the word with?: ");
				replace = in.nextLine();

				while (phrase.toLowerCase().indexOf(remove) != -1) {
					if (replace.toLowerCase().equals(remove)) {
						break;
					}
					if (replace.toLowerCase().indexOf(remove) != -1) {
						lastRemoved = 0;
						while (lastRemoved != phrase.toLowerCase().lastIndexOf(remove)+remove.length()){ 
							phrase = phrase.substring(0,phrase.toLowerCase().indexOf(remove, lastRemoved)) 
									+ replace + phrase.substring(phrase.toLowerCase().indexOf(remove, lastRemoved)+remove.length());

							lastRemoved = phrase.lastIndexOf(replace) + remove.length(); 
						}
						break;
					}
					phrase = phrase.substring(0,phrase.toLowerCase().indexOf(remove)) 
							+ replace + phrase.substring(phrase.toLowerCase().indexOf(remove)+remove.length());
				}
				System.out.println(phrase);
			}
		}
		in.close();
	}

}
