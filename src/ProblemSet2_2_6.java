
import java.util.*;
public class ProblemSet2_2_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sum = 0;
		Scanner in = new Scanner (System.in);
		for (int i = 1; i <= 5; i++) {
			System.out.print("Enter a number: ");
			sum += Double.parseDouble(in.nextLine());
		}
		System.out.println("The sum is " + sum);
		in.close();
	}

}
