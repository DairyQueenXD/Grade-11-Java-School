
import java.util.*;
/* Write a program that let you enter two numbers a,b, and that prints 
 * out a^b
 */
public class ProblemSet2_1_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		System.out.print("Enter number 1: ");
		double num1 = Double.parseDouble(in.nextLine());
		System.out.print("Enter number 2: ");
		double num2 = Double.parseDouble(in.nextLine());
		double result = Math.pow(num1, num2);
		System.out.printf(num1 + " to the power of " + num2 + " is %.2f", result);
		in.close();
	}

}
