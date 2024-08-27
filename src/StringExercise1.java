
// Imports
import java.util.*;

// Name: Dequan Kong
// Date: October 12th, 2023
// Assignment: String Programming Exercises #1

public class StringExercise1 {
	
	public static void main(String[] args) {

		// Create a new Scanner
		Scanner in = new Scanner (System.in);
		
		// Exercise #1
		System.out.print("Enter a word: ");
		String word = in.nextLine();
		word = word.trim();
		for (int i = word.length()-1; i >= 0; i--) {
			if (!((word.charAt(i)) == ' ')) {
				System.out.print((word.charAt(i)+"").toUpperCase());
			}
		}
		
		// Exercise #2
		String phrase = "";
		int vowels, consonants, symbols;
		do {
			vowels= 0; consonants = 0; symbols = 0;
			System.out.print("\nEnter a phrase: ");
			phrase = in.nextLine();
			for (int i = 0; i <= phrase.length()-1; i++) {
				if ((65 <= phrase.charAt(i) && phrase.charAt(i) <= 90) 
						|| (97 <= phrase.charAt(i) && phrase.charAt(i) <= 122)) {
					if (phrase.charAt(i) == 'a' || phrase.charAt(i) == 'e' || phrase.charAt(i) == 'i' || phrase.charAt(i) == 'o'
							|| phrase.charAt(i) == 'u' || phrase.charAt(i) == 'A' || phrase.charAt(i) == 'E'
							|| phrase.charAt(i) == 'I' || phrase.charAt(i) == 'O' || phrase.charAt(i) == 'U') {
						vowels++;
					} else {
						consonants++;
					}
				} else {
					symbols++;
				}
			}
			if (!(phrase.trim().equalsIgnoreCase("stop"))) {
				System.out.println("Vowels = " + vowels + ", Consonants = " + consonants + ", Symbols = " + symbols);
			}
		} while (!(phrase.trim().equalsIgnoreCase("stop")));

		// Exercise 3
		String palindrome;
		boolean result;
		do {
			result = true;
			System.out.print("\nEnter a word: ");
			palindrome = in.nextLine().trim();
			for (int i = 0; i < palindrome.length()/2; i++) {
				if (!((palindrome.charAt(i)+"").equalsIgnoreCase(palindrome.charAt(palindrome.length()-1-i)+""))) {
					result = false;
				}
			}
			if (!(palindrome.equalsIgnoreCase("done"))) {
				System.out.print(result);
			}
		} while (!(palindrome.equalsIgnoreCase("done")));
		
		// Exercise 4
		String sentence = "";
		int cases;
		while (!(sentence.trim().equalsIgnoreCase("done"))) {
			cases = 0;
			System.out.print("\nEnter a sentence: ");
			sentence = in.nextLine();
			
			if (!(sentence.trim().equalsIgnoreCase("done"))) {
				for (int i = 0; i <= sentence.length()-1; i++) {
					if (Character.isLetter(sentence.charAt(i))) {
						if (cases == 0) {
							System.out.print(sentence.charAt(i));
							if (Character.isUpperCase(sentence.charAt(i))) {
								cases = 1;
							} else {
								cases = 2;
							}
						} else {
							if (cases % 2 == 0) {
								System.out.print(Character.toUpperCase(sentence.charAt(i)));
							} else {
								System.out.print(Character.toLowerCase(sentence.charAt(i)));
							}
							cases++;
						}
					} else {
						System.out.print(sentence.charAt(i));
					}
				}
			}
		}
		
		// Exercise #5
		System.out.print("Enter a word: ");
		String word2 = in.nextLine().trim();
		String wordTest;
		for (int i = 0; i <= word2.length()-1; i++) {
			// Block 1
			System.out.print(word2.substring(0,word2.length()-i));
			
			for (int x = 0; x <= word2.length()-1; x++) {
				System.out.print(" ");
			}
			
			for (int x = 0; x < i; x++) {
				System.out.print(" ");
			}
			// Block 2
			System.out.print(word2.substring(i));
			
			for (int x = 0; x <= word2.length()-1; x++) {
				System.out.print(" ");
			}
			
			for (int x = 0; x < i; x++) {
				System.out.print(" ");
			}
			// Block 3
			
			for (int x = 0; x < i; x++) {
				System.out.print(" ");
			}
			System.out.print(word2.substring(i));
			for (int x = 0; x <= word2.length()-1; x++) {
				System.out.print(" ");
			}
			
			// Block 4
			wordTest = word2.substring(0,word2.length()-i);
			for (int x = 0; x < i; x++) {
				System.out.print(" ");
			}
			for (int x = 0; x <= wordTest.length()-1; x++) {
				System.out.print(wordTest.charAt(x));
				if (!(x == wordTest.length()-1)) {
					System.out.print("-");
				}
			}
			for (int x = 0; x < i; x++) {
				System.out.print(" ");
			}
			for (int x = 0; x <= word2.length()-1; x++) {
				System.out.print(" ");
			}
			
			// Block 5
			wordTest = word2.substring(0,word2.length()-i);
			for (int x = 0; x < i; x++) {
				System.out.print(" ");
			}
			for (int x = wordTest.length()-1; x >= 0; x--) {
				System.out.print(wordTest.charAt(x));
			}
				
			for (int x = 0; x <= wordTest.length()-1; x++) {
				System.out.print(wordTest.charAt(x));
			}
			
			for (int x = 0; x < i; x++) {
				System.out.print(" ");
			}
			// New line
			System.out.print("\n");
		}
		in.close();
	}

}
