
import java.util.*;
/*Write a program that lets you enter a degree measure in Fahrenheit, and that

prints the result in celsius degree measure: c = 5/9 *(f-32)
5
9
( f - 32)*/
public class ProblemSet2_1_5 {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter a degree measure in Fahrenheit: ");
		double degreeF = Double.parseDouble(in.nextLine());
		double degreeC = 5*(degreeF-32)/9;
		System.out.printf("The degree in Celsius is %.2f", degreeC);
		in.close();

	}

}
