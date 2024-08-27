
// Import Scanner from java.util
import java.util.*;

public class Assignment2Backup {

	public static void main(String[] args) {
		// Creating a new Scanner
		Scanner in = new Scanner (System.in);
		
		// Menu
		
		
		// Asking the names of the 2 players
		System.out.print("Player 1:  Enter your name:  ");
		String player1 = in.nextLine();
		System.out.print("Player 2:  Enter your name:  ");
		String player2 = in.nextLine();

		// Initialize variables
		int player1Wins = 0; // number of player one's wins
		int player2Wins = 0; // number of player two's wins
		char playAgain = 'n'; // NEED TO CHANGE THIS TO NOTHING
		char pileChosen;
		int matchesRemoved;
		int roundNumber = 0; // we start at round #1. We set the variable to be zero because we will update the variable in loop 1.
		int currentPlayer = 1; // 1 when player 1's turn, 2 when player 2's turn
		String nameOfCurrentPlayer;

		// *** LOOP 1 BEGINS ***
		// Loop 1: As long as the players still wish to play the game, the loop continues.
		// Note that the game will be played at least once (so we use a do-while loop).
		do {
			// Updating / Resetting variables
			roundNumber++;
			currentPlayer = 1;
			// Generating randomly the number of matches in each pile
			// The number of matches in each pile will be different each round
			int pileA = (int)(Math.random()*7+1);
			int pileB = (int)(Math.random()*7+1);
			int pileC = (int)(Math.random()*7+1);

			// Indicating the round number and the number of matches in each pile
			System.out.println("\nRound #" + roundNumber + ":\nPile A = " + pileA + " matches, Pile B = " + pileB
					+ " matches, Pile C = " + pileC + " matches");

			// *** LOOP 2 BEGINS ***
			// Loop 2: if the end of game has not been reached (i.e. 2 piles are empty and 1 pile have 1 match left), the loop continues.
			// In other words, let the number of matches in each of the piles A, B, C be denoted as (A,B,C).
			// Then the game ends in the following 3 scenarios: (1,0,0); (0,1,0); (0,0,1).
			while (!((pileA == 1 && pileB == 0 && pileC == 0) || (pileA == 0 && pileB == 1 && pileC == 0) || 
					(pileA == 0 && pileB == 0 && pileC == 1) || (pileA == 0 && pileB == 0 && pileC == 0))) {

				// Outputting the number of matches in each pile
				System.out.println("\nA: " + pileA + "\t   B:  " + pileB + "      C:  " + pileC + "\n");

				// If it's player 1's turn, set the name of current player to what player 1 chose as his/her name
				// Otherwise set the name of current player to what player 2 chose as his/her name
				if (currentPlayer == 1) {
					nameOfCurrentPlayer = player1;
					currentPlayer = 2;
				} else {
					nameOfCurrentPlayer = player2;
					currentPlayer = 1;
				}

				// *** LOOP 3 BEGINS ***
				// Loop 3: lets the player input a pile, repeats if the input is not A, B or C OR if the chosen pile is empty.
				do { 
					// 1) Choose a pile to remove matches from.
					System.out.print(nameOfCurrentPlayer + ", choose a pile:  ");
					pileChosen = in.nextLine().charAt(0);
					// 2) Check if the input is invalid (i.e. if the input is something else than A, B or C).
					//    If so, tell the user to input a valid pile.
					if (pileChosen != 'A' && pileChosen != 'a' && pileChosen != 'B' && pileChosen != 'b'
							&& pileChosen != 'C' && pileChosen != 'c') {
						System.out.println("\nPlease enter a valid pile! (A, B or C)\n");
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
				// Loop 4: 
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
				// *** LOOP 4 ENDS ***
				if (pileChosen == 'A' || pileChosen == 'a') {
					pileA -= matchesRemoved;
				} else if (pileChosen == 'B' || pileChosen == 'b') {
					pileB -= matchesRemoved;
				} else if (pileChosen == 'C' || pileChosen == 'c') {
					pileC -= matchesRemoved;
				}
			}
			// *** LOOP 2 ENDS ***
			System.out.println("\nA: " + pileA + "\t   B:  " + pileB + "      C:  " + pileC + "\n");
			if ((pileA == 1 && pileB == 0 && pileC == 0) || (pileA == 0 && pileB == 1 && pileC == 0) || 
					(pileA == 0 && pileB == 0 && pileC == 1)) {
				if (currentPlayer == 1) {
					System.out.println(player2 + " won this round!!!\n");
					player2Wins++;
				} else {
					System.out.println(player1 + " won this round!!!\n");
					player1Wins++;
				}
			} else {
				if (currentPlayer == 1) {
					System.out.println(player1 + " won this round!!!\n");
					player1Wins++;
				} else {
					System.out.println(player2 + " won this round!!!\n");
					player2Wins++;
				}
			}
			// *** LOOP 5 BEGINS ***
			do {
				System.out.print("Play again?   (Enter Y/N): ");
				playAgain = in.nextLine().charAt(0);
				if ((playAgain != 'y') && (playAgain != 'Y') && (playAgain != 'N') && (playAgain != 'n')) {
					System.out.println("\nPlease enter 'Y' or 'N' and not anything else.");
				}
			} while ((playAgain != 'y') && (playAgain != 'Y') && (playAgain != 'N') && (playAgain != 'n'));
		} while (playAgain == 'y' || playAgain == 'Y');
		// If the players want to play the game again (i.e. they input 'Y'), the loop continues
		// Otherwise, if the players input anything else than 'Y' or 'N', the program will output a statement telling the players to input a valid character.
		// Otherwise, the program ends.
		// *** LOOP 1 ENDS ***
		System.out.println("Final Score: # of rounds played:  " + roundNumber);
		System.out.println("             " + player1 + " = " + player1Wins + ", " + player2 + " = " + player2Wins);
		if (player1Wins > player2Wins){
			System.out.println("             " + player1 + " won this game!!!");
		} else if (player1Wins < player2Wins) {
			System.out.println("             " + player2 + " won this game!!!");
		} else {
			System.out.println("             " + "Tie!!! You both won this game!!!");
		}
		System.out.println("\nThank you for playing!");
		in.close();
	}
}
