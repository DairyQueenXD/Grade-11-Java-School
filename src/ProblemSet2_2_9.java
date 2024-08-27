

import java.util.Scanner;

public class ProblemSet2_2_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		double min = 0; 
		double input;
		for (int i = 1; i <= 5; i++) {
			System.out.print("Enter a number: ");
			input = Integer.parseInt(in.nextLine());
			if (input < min || i == 1) {
				min = input;
			}
		}
		System.out.println("The largest number is " + min);
		in.close();
	}

}
