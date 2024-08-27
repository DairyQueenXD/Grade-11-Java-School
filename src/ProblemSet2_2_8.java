
import java.util.*;
public class ProblemSet2_2_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		double max = 0; 
		double input;
		for (int i = 1; i <= 5; i++) {
			System.out.print("Enter a number: ");
			input = Integer.parseInt(in.nextLine());
			if (input > max || i == 1) {
				max = input;
			}
		}
		System.out.println("The largest number is " + max);
		in.close();
	}
	


}

