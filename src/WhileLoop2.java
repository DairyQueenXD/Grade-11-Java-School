
import java.util.*;
public class WhileLoop2 {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int mine = (int) (Math.random()*10);
		int i = 1;
		int guess;
		boolean error = false;
		System.out.println("Welcome to my Number Mine game!  You have 5 guesses to dodge my mine!");
		while (i <= 5 && !(error)) {
			System.out.print("Guess #" + i + ": ");
			guess = in.nextInt();
			if (guess == mine) {
				error = true;
				System.out.println("\nUH OH !! You have unfortunately stepped on my mine :(");
			} else if (i == 5 && !(error)) {
				System.out.println("\nWOOHOOOOO!!!  Good job!  My secret number is " + mine + "!");
			}
			i++;
		}
		System.out.printf("%d", i);
		System.out.printf("%d", i);
		in.close();
	}

}
