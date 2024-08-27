
// Import Scanner from java.util
import java.util.Scanner;

/* 
Name: Dequan Kong
Assignment #: Assignment 2 - Nim Game
Date: October 2nd 2023
Description: This is a program that allows two players to play a game of Nim together.
There are 3 piles at the start of the game with random amounts of matches.
On each player's turn, the player can choose ONE pile to take matches from. 
The player can choose to remove any amount of matches from that pile, except 0 
or any amount greater than the number of matches that were present in that pile.
Whoever takes the last match loses. 
 */

public class Assignment2 {

	public static void main(String[] args) {
		// Creating a new Scanner
		Scanner in = new Scanner (System.in);

		// Initializing variables for option and character
		int option;
		char character = ' ';
		
		// *** LOOP 0 BEGINS ***
		// Loop 0: Let the user choose how the game will be displayed
		// The input should be 1, 2 or 3.
		// If the input is invalid, the program will output a statement telling the user to try again.
		do {
			System.out.print("Please choose how you wish the game to be displayed.\n" + 
					"Option 1: Numerical view\nOption 2: Horizontal view\nOption 3: Vertical view"
					+ "\n\nTo choose an option, enter a number (1, 2 or 3): ");
			option = Integer.parseInt(in.nextLine());
			if ((option != 1) && (option != 2) && (option != 3)) {
				System.out.println("\nPlease enter a valid number (1, 2 or 3).\n");
			}
		} while ((option != 1) && (option != 2) && (option != 3));
		// While the input is not 1 or 2 or 3, the program will continue to ask the user for a valid input.
		// *** LOOP 0 ENDS***
		
		// If option 2 or 3 are chosen, the program will let the user input a character
		// that will be displayed throughout the game.
		if (option == 2 || option == 3) {
			System.out.print("\nPlease choose a character that will be displayed throughout the game.\n" + 
					"\nChoose a character: ");
			character = in.nextLine().charAt(0);
		}
		
		// Asking the names of the 2 players
		System.out.print("\nPlayer 1:  Enter your name:  ");
		String player1 = in.nextLine();
		System.out.print("Player 2:  Enter your name:  ");
		String player2 = in.nextLine();

		// Initialize variables
		int player1Wins = 0; // number of player one's wins
		int player2Wins = 0; // number of player two's wins
		char playAgain = 'n'; // character that stores whether the players want to continue playing the game
		char pileChosen; // During a turn, this represents the pile the player chose to remove matches from
		int matchesRemoved; // the amount of matches the player wants to remove
		int roundNumber = 0; // we start at round #1. We set the variable to be zero because we will update the variable in the loop.
		int currentPlayer = 1; // 1 when player 1's turn, 2 when player 2's turn
		String nameOfCurrentPlayer; // stores the name of the player who's next to play
		
		// *** LOOP 1 begins ***
		// Loop 1: As long as the players still wish to play the game, the loop continues.
		// Note that the game will be played at least once (so we use a do-while loop).
		do {
			// Updating / Resetting variables
			roundNumber++; // increase the round number
			currentPlayer = 1; // reset the current player variable to 1 (since we always start with player 1)

			// Options Menu again
			// If it's round 1, we don't display this (already displayed before the loop)
			// Otherwise, display the options menu
			if (roundNumber != 1) {
				do {
					System.out.print("\nPlease choose how you wish the game to be displayed.\n" + 
							"Option 1: Numerical view\nOption 2: Horizontal view\nOption 3: Vertical view"
							+ "\n\nTo choose an option, enter a number (1, 2 or 3): ");
					option = Integer.parseInt(in.nextLine());
					if ((option != 1) && (option != 2) && (option != 3)) {
						System.out.println("\nPlease enter a valid number (1, 2 or 3).\n");
					}
				} while ((option != 1) && (option != 2) && (option != 3));
				
				// If options 2 or 3 are chosen, let the players choose a character to be displayed during the game
				if (option == 2 || option == 3) {
					System.out.print("\nPlease choose a character that will be displayed throughout the game.\n" + 
							"\nChoose a character: ");
					character = in.nextLine().charAt(0);
				}
			}

			// Generating randomly the number of matches in each pile
			// The number of matches in each pile will be different each round
			int pileA = (int)(Math.random()*7+1);
			int pileB = (int)(Math.random()*7+1);
			int pileC = (int)(Math.random()*7+1);

			// Indicating the round number and the number of matches in each pile
			System.out.println("\nRound #" + roundNumber + ":\nPile A = " + pileA + " matches, Pile B = " + pileB
					+ " matches, Pile C = " + pileC + " matches");

			// *** LOOP 2 BEGINS ***
			// Loop 2: if the end of game has not been reached (i.e. 2 piles are empty and 1 pile have 1 match left 
			// OR all 3 piles are empty), the loop continues.
			// In other words, let the number of matches in each of the piles A, B, C be denoted as (A,B,C).
			// Then the loop ends in the following 4 scenarios: (1,0,0); (0,1,0); (0,0,1); (0,0,0).
			while (!((pileA == 1 && pileB == 0 && pileC == 0) || (pileA == 0 && pileB == 1 && pileC == 0) || 
					(pileA == 0 && pileB == 0 && pileC == 1) || (pileA == 0 && pileB == 0 && pileC == 0))) {

				// Outputting the number of matches in each pile
				if (option == 2) { // Option 2: display horizontally (with the character chosen before)
					System.out.print("\nA:  ");
					for (int i = 1; i <= pileA; i++) {
						System.out.print(character);
					} 
					System.out.print("\nB:  ");
					for (int i = 1; i <= pileB; i++) {
						System.out.print(character);
					} 
					System.out.print("\nC:  ");
					for (int i = 1; i <= pileC; i++) {
						System.out.print(character);
					} 
				} else if (option == 3){ // Option 3: display vertically (with the character chosen before)
					System.out.println("\nA    B    C");
					// Repeat until the largest pile has been all displayed
					// To do this, repeat the number of times equal to the number of matches in the largest pile
					for (int i = 1; i <= Math.max(Math.max(pileA, pileB),pileC); i++) {
						if (i > pileA) {
							System.out.print("     ");
						} else {
							System.out.print(character + "    ");
						}
						if (i > pileB) {
							System.out.print("     ");
						} else {
							System.out.print(character + "    ");
						}
						if (i > pileC) {
							System.out.print("     ");
						} else {
							System.out.print(character + "    ");
						}
						System.out.print("\n");
					}
				} else { // Option 1: display numerically
					System.out.println("\nA: " + pileA + "\t   B:  " + pileB + "      C:  " + pileC);
				}
				
				// If it's player 1's turn, set the name of current player to what player 1 chose as his/her name
				// Otherwise, set the name of current player to what player 2 chose as his/her name
				// When it's player 1's turn, currentPlayer is actually equal to 2, and vice-versa.
				if (currentPlayer == 1) {
					nameOfCurrentPlayer = player1;
					currentPlayer = 2;
				} else {
					nameOfCurrentPlayer = player2;
					currentPlayer = 1;
				}

				// *** LOOP 3 BEGINS ***
				// Loop 3: lets the player input a pile, repeats if the input is not A, B or C
				// OR if the chosen pile is empty.
				do { 
					// 1) Choose a pile to remove matches from.
					System.out.print("\n" + nameOfCurrentPlayer + ", choose a pile:  ");
					pileChosen = in.nextLine().charAt(0);
					// 2) Check if the input is invalid (i.e. if the input is something else than A, B or C).
					//    If so,jirdsfsd tell the user to input a valid pile.
					if (pileChosen != 'A' && pileChosen != 'a' && pileChosen != 'B' && pileChosen != 'b'
							&& pileChosen != 'C' && pileChosen != 'c') {
						System.out.println("\nPlease enter a valid pile! (A, B or C)");
						// 3) Now we know that the input is valid, we check if the corresponding pile is empty.
						//    If so, tell the player to choose another pile.
						//    Note that although we know the input is valid, we do not know which pile the input corresponds to.
						//    For this reason, we check if the input is A, B, or C to determine the corresponding pile.
					} else if ((pileChosen == 'A' || pileChosen == 'a') && pileA == 0) {
						System.out.println("\nThis pile is empty. Please choose another pile.\n");
					} else if ((pileChosen == 'B' || pileChosen == 'b') && pileB == 0) {
						System.out.println("\nThis pile is empty. Please choose another pile.\n");
					} else if ((pileChosen == 'C' || pileChosen == 'c') && pileC == 0) {
						System.out.println("\nThis pile is empty. Please choose another pile.\n");
					}

				} while (!(((pileChosen == 'A' || pileChosen == 'a') && pileA != 0) ||  
						((pileChosen == 'B' || pileChosen == 'b') && pileB != 0) || 
						((pileChosen == 'C' || pileChosen == 'c') && pileC != 0)));  
				// Loop continues until the input is valid AND the pile corresponding to the input is NOT empty
				// *** LOOP 3 ENDS ***

				// *** LOOP 4 BEGINS ***
				// Loop 4: Lets the user input the amount of matches the user wants to remove
				// If the input is larger than the amount of matches OR is zero OR is a negative number,
				// the program will ask the user to try again.
				do {
					System.out.print("How many to remove from pile " + pileChosen + ":  ");
					matchesRemoved = Integer.parseInt(in.nextLine());
					if (matchesRemoved < 0) {
						System.out.println("\nYou just entered a negative number of matches.\n"
								+ "Please enter a valid number of matches (larger than 0, smaller than the amount of matches in the pile you chose previously).\n");
					} else if (matchesRemoved == 0) {
						System.out.println("\nYou cannot take nothing away from a pile.\n" 
								+ "Please enter a valid number of matches (larger than 0, smaller than the amount of matches in the pile you chose previously).\n");
					} else if (((pileChosen == 'A' || pileChosen == 'a') && matchesRemoved > pileA) || ((pileChosen == 'B' || pileChosen == 'b') && matchesRemoved > pileB)
							|| ((pileChosen == 'C' || pileChosen == 'c') && matchesRemoved > pileC)) {
						System.out.println("\nYou cannot take away more matches than there already is in the pile you chose previously.\n"
								+ "Please enter a valid number of matches (larger than 0, smaller than the amount of matches in the pile you chose previously).\n");
					} 
				} while ((matchesRemoved <= 0) || ((pileChosen == 'A' || pileChosen == 'a') && matchesRemoved > pileA)
						|| ((pileChosen == 'B' || pileChosen == 'b') && matchesRemoved > pileB)
						|| ((pileChosen == 'C' || pileChosen == 'c') && matchesRemoved > pileC));
				// Ends when there is a valid input (larger than 0, smaller than the number of matches in the pile chosen)
				// *** LOOP 4 ENDS ***
				
				// Remove the number of matches the user wants to remove from the pile the user chose before
				if (pileChosen == 'A' || pileChosen == 'a') {
					pileA -= matchesRemoved;
				} else if (pileChosen == 'B' || pileChosen == 'b') {
					pileB -= matchesRemoved;
				} else if (pileChosen == 'C' || pileChosen == 'c') {
					pileC -= matchesRemoved;
				}
			}
			// Ends when the game is over (zero or one match is left)
			// *** LOOP 2 ENDS ***
			
			// Outputting the number of matches in each pile
			if (option == 2) {
				System.out.print("\nA:  ");
				for (int i = 1; i <= pileA; i++) {
					System.out.print(character);
				} 
				System.out.print("\nB:  ");
				for (int i = 1; i <= pileB; i++) {
					System.out.print(character);
				} 
				System.out.print("\nC:  ");
				for (int i = 1; i <= pileC; i++) {
					System.out.print(character);
				} 
			} else if (option == 3){
				System.out.println("\nA    B    C");
				for (int i = 1; i <= Math.max(Math.max(pileA, pileB),pileC); i++) {
					if (i > pileA) {
						System.out.print("     ");
					} else {
						System.out.print(character + "    ");
					}
					if (i > pileB) {
						System.out.print("     ");
					} else {
						System.out.print(character + "    ");
					}
					if (i > pileC) {
						System.out.print("     ");
					} else {
						System.out.print(character + "    ");
					}
					System.out.print("\n");
				}
			} else {
				System.out.println("\nA: " + pileA + "\t   B:  " + pileB + "      C:  " + pileC);
			}
			
			// If only 1 match is left, then the player who just played the last turn wins
			// since the next player is forced to take 1 match.
			// If currentPlayer is equal to 1, it means that player 2 played the last turn, and vice-versa.
			if ((pileA == 1 && pileB == 0 && pileC == 0) || (pileA == 0 && pileB == 1 && pileC == 0) || 
					(pileA == 0 && pileB == 0 && pileC == 1)) {
				if (currentPlayer == 1) {
					System.out.println("\n" + player2 + " won this round!!!\n");
					player2Wins++;
				} else {
					System.out.println("\n" + player1 + " won this round!!!\n");
					player1Wins++;
				}
			// If no match is left, then the player who just played the last turn lost
			// since that player took all the matches left, therefore that player also took the last match
			// If currentPlayer is equal to 1, it means that player 2 played the last turn, so player 2 lost and player 1 won, and vice-versa.
			} else {
				if (currentPlayer == 1) {
					System.out.println("\n" + player1 + " won this round!!!\n");
					player1Wins++;
				} else {
					System.out.println("\n" + player2 + " won this round!!!\n");
					player2Wins++;
				}
			}
			
			// *** LOOP 5 BEGINS ***
			// Ask the players to input if they want to play again.
			// The input should be 'y' or 'n'
			do {
				System.out.print("Play again?   (Enter Y/N): ");
				playAgain = in.nextLine().charAt(0);
				if ((playAgain != 'y') && (playAgain != 'Y') && (playAgain != 'N') && (playAgain != 'n')) {
					System.out.println("\nPlease enter 'Y' or 'N' and not anything else.");
				}
			} while ((playAgain != 'y') && (playAgain != 'Y') && (playAgain != 'N') && (playAgain != 'n'));
			// The loop continues until a valid input is entered
		    // *** LOOP 5 ENDS ***
			
		} while (playAgain == 'y' || playAgain == 'Y');
		// If the players want to play the game again (i.e. they input 'Y'), the loop continues
		// Otherwise, if the players input anything else than 'Y' or 'N', the program will output a statement telling the players to input a valid character.
		// Otherwise, the program ends.
		// *** LOOP 1 ENDS ***
		
		// At the end of game, output the number of rounds and the number of wins for each player
		System.out.println("Final Score: # of rounds played:  " + roundNumber);
		System.out.println("             " + player1 + " = " + player1Wins + ", " + player2 + " = " + player2Wins);
		
		// Based on the number of wins of each player, output who won the game.
		if (player1Wins > player2Wins){
			System.out.println("             " + player1 + " won this game!!!");
		} else if (player1Wins < player2Wins) {
			System.out.println("             " + player2 + " won this game!!!");
		} else {
			System.out.println("             " + "Tie!!! You both won this game!!!");
		}
		
		// Thanks for playing!
		System.out.println("\nThank you for playing!");
		in.close();
	}
}
