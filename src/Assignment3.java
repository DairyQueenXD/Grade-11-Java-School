import java.io.*;
import java.util.*;

/* 
Name: Dequan Kong
Assignment #: Assignment 3 - Secret Messages
Date: November 3rd 2023
Description: This is a program that runs an encryption or a decryption on a text file (.txt) message.
The program will ask if the user wants to encrypt or decrypt, then it will ask the name of the input 
(where to read the message from) and output (where to print the encrypted/decrypted) files.
 */

public class Assignment3 {

	public static void main(String[] args) throws IOException{
		// Scanner 1 (in): this Scanner allows the user to input the action the user wants to perform. 
		// It also asks the user for the name of the input/output files.
		Scanner in = new Scanner (System.in);
		// Actions: 1 for encrypt, 2 for decrypt, 3 to exit the program
		int action = 0; 
		// Variables to store the number of spaces before/after the text each line
		int spaceBefore = 0, spaceAfter = 0; 
		// Variables to store the input/output files' names
		String input, output;
		// Variable to store the text message on each line of the input file
		String line;
		// Character substitutions: if the original text message was "BEFO", then the encrypted message will be
		// "!=@)"; vice-versa for decryption.
		String original = "BFASTUWDMOE "; 
		String sub = "!@#$%^&*()=?";
		while (true) {
			// Reset the action variable
			action = 0; 
			// The user chooses what action to perform. If the input is anything else than 1, 2, or 3 then 
			// the user will be prompted to input a valid number.
			while (!(action == 1 || action == 2 || action == 3)) {
				System.out.print("Do you want to encrypt or decrypt?\nFor encrypting, enter 1; for decrypting, enter 2;"
						+ " to exit the program, enter 3: ");
				action = Integer.parseInt(in.nextLine());
				if (!(action == 1 || action == 2 || action == 3)) {
					System.out.println("Please input a valid number!");
				}
			}
			// The user can input 3 to exit the program
			if (action == 3) {
				break;
			}
			// Otherwise, the user will be prompted to input the names of the input/output files.
			System.out.println("Enter the name of the text file to read from: ");
			input = in.nextLine();
			// Scanner 2 (inFile): this Scanner will mainly read every line from the input file.
			Scanner inFile = new Scanner (new FileReader (input));
			System.out.println("Enter the name of the text file to output to: ");
			output = in.nextLine();
			// PrintWriter 1 (outFile): this PrintWriter will mainly output the encrypted/decrypted message
			// to the output file previously chosen by the user.
			PrintWriter outFile = new PrintWriter (new FileWriter (output));

			// Action 1: Encryption
			if (action == 1) {
				// Repeat for each line of text message
				while (inFile.hasNextLine()) {
					// Resetting variables
					spaceBefore = 0; 
					spaceAfter = 0;
					// Read one line from the input file
					line = inFile.nextLine();
					// Count the number of spaces before the text message
					for (int i = 0; i < line.length(); i++) {
						// Starting from the first character, if the character is a space then increase
						// the space counter by 1; otherwise proceed.
						if (line.charAt(i) == ' ') {
							spaceBefore++;
						} else {
							break;
						}
					}
					// Count the number of spaces after the text message
					for (int i = line.length()-1; i >= 0; i--) {
						// Starting from the last character, if the character is a space then increase
						// the space counter by 1; otherwise proceed.
						if (line.charAt(i) == ' ') {
							spaceAfter++;
						} else {
							break;
						}

					}
					// Steps 1 & 2: remove all the spaces & capitalize
					line = line.trim().toUpperCase();
					// Step 3: Character substitutions
					for (int i = 0; i < line.length(); i++) {
						if (original.indexOf(line.charAt(i)+"") != -1) {
							line = line.substring(0,i)+sub.charAt(original.indexOf(line.charAt(i)+""))
							+ line.substring(i+1);
						}
					}
					System.out.println(line);
					// Step 4: Swap the first 2 characters with the last 2
					line = line.substring(line.length()-2) + line.substring(2,line.length()-2) + line.substring(0,2);
					System.out.println(line);
					if (line.length() % 2 == 0) { // If the character has an even number of characters
						// Step 5: Reverse the 1st half of the string with the 2nd half
						line = line.substring((line.length()+1)/2)+line.substring(0,(line.length()+1)/2);
						System.out.println(line);
						// Step 6: Swap the two characters immediately to the left of the middle of the string with the two
						// characters that immediately follow them.
						line = line.substring(0,line.length()/2-3) + line.substring(line.length()/2-1, line.length()/2+1) + 
								line.substring(line.length()/2-3,line.length()/2-1) + line.substring(line.length()/2+1);
						System.out.println(line);
						// Step 7: Swap the places of every 2 characters
						for (int i = 0; i < line.length(); i+=2) {
							line = line.substring(0,i) + line.charAt(i+1) + "" + line.charAt(i) + line.substring(i+2);
						}
						System.out.println(line);
					} else { // If the character has an odd number of characters
						// Step 5: Reverse the 1st half of the string with the 2nd half
						// The 1st half will have one more character than the 2nd half
						line = line.substring((line.length()+1)/2)+line.substring(0,(line.length()+1)/2);
						System.out.println(line);
						// Step 6: Swap the two characters immediately to the left of the middle of the string with the two
						// characters that immediately follow them.
						line = line.substring(0,line.length()/2-2)+line.substring(line.length()/2,line.length()/2+2)
						+ line.substring(line.length()/2-2,line.length()/2) + line.substring(line.length()/2+2);
						System.out.println(line);
						// Step 7: Swap the places of every 2 characters
						// The last character will always remain the same 
						for (int i = 0; i < line.length()-2; i+=2) {
							line = line.substring(0,i) + line.charAt(i+1) + "" + line.charAt(i) + line.substring(i+2);
						}
						System.out.println(line);				
					}
					// Each encrypted message will have 3 parts to output:
					// 1. The encrypted message
					outFile.println(line);
					// 2. Number of spaces in front of the original text message
					outFile.println(spaceBefore);
					// 3. Number of spaces after the original text message
					outFile.println(spaceAfter);
				}
				// Action 2: Decryption
			} else {
				// Repeat for every line of encrypted message
				while (inFile.hasNextLine()) {
					// Each encrypted message will have 3 parts to read in:
					// 1. The encrypted message
					line = inFile.nextLine();
					// 2. Number of spaces in front of the original text message
					spaceBefore = Integer.parseInt(inFile.nextLine());
					// 3. Number of spaces after the original text message
					spaceAfter = Integer.parseInt(inFile.nextLine());
					
					// Reverse the encryption process to decrypt the message
					if (line.length() % 2 == 0) { // If the message has an even number of characters
						// Step 7: Swap every 2 characters
						for (int i = 0; i < line.length(); i+=2) {
							line = line.substring(0,i) + line.charAt(i+1) + "" + line.charAt(i) + line.substring(i+2);
						}
						System.out.println(line);
						// Step 6: Swap the two characters immediately to the left of the middle of the string with the two
						// characters that immediately follow them.
						line = line.substring(0,line.length()/2-3) + line.substring(line.length()/2-1, line.length()/2+1) + 
								line.substring(line.length()/2-3,line.length()/2-1) + line.substring(line.length()/2+1);
						System.out.println(line);
						// Step 5: Reverse the 1st half of the string with the 2nd half
						line = line.substring((line.length()+1)/2)+line.substring(0,(line.length()+1)/2);
						System.out.println(line);
					} else { // If the message has an odd number of characters
						// Step 7: Swap every 2 charactesr
						for (int i = 0; i < line.length()-2; i+=2) {
							line = line.substring(0,i) + line.charAt(i+1) + "" + line.charAt(i) + line.substring(i+2);
						}
						System.out.println(line);
						// Step 6: Swap the two characters immediately to the left of the middle of the string with the two
						// characters that immediately follow them.
						line = line.substring(0,line.length()/2-2)+line.substring(line.length()/2,line.length()/2+2)
						+ line.substring(line.length()/2-2,line.length()/2) + line.substring(line.length()/2+2);
						System.out.println(line);
						// Step 5: Reverse the 1st half of the string with the 2nd half
						// The 1st half will have one less character than the 2nd half (since we are reversing the process)
						line = line.substring((line.length()+1)/2-1)+line.substring(0,(line.length()+1)/2-1);
						System.out.println(line);
					}
					// Step 4: Swap the first 2 characters with the last 2
					line = line.substring(line.length()-2) + line.substring(2,line.length()-2) + line.substring(0,2);
					System.out.println(line);
					// Step 3: Character substitutions
					for (int i = 0; i < line.length(); i++) {
						if (sub.indexOf(line.charAt(i)+"") != -1) {
							line = line.substring(0,i)+original.charAt(sub.indexOf(line.charAt(i)+""))
							+ line.substring(i+1);
						}
					}
					// Step 2: Change all characters to lower case 
					// (reversing the process of capitalizing every character)
					line = line.toLowerCase();
					// Step 1: Adding back the spaces
					// Add the spaces before the text message
					for (int i = 1; i <= spaceBefore; i++) {
						line = " " + line;
					}
					// Add the spaces after the text message
					for (int i = 1; i <= spaceBefore; i++) {
						line = line + " ";
					}
					// Output the decrypted message to the output file
					outFile.println(line);
					// Current issue: see example "hello?"
				}
			}
			// Close the Scanner inFile & the PrintWriter outFile
			// They will be created again if the user chooses to encrypt/decrypt again
			outFile.close();
			inFile.close();
		}
		// After the user exits the program (by inputting 3), close the Scanner in
		in.close();
	}

}
