
import java.util.*;
/*Write a program that lets you enter the two sides of a right angled triangle, and

that prints the hypothenuse.*/
public class ProblemSet2_1_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		System.out.print("Enter side 1 of a right angled triangle: ");
		double side1 = Double.parseDouble(in.nextLine());
		System.out.print("Enter side 2: ");
		double side2 = Double.parseDouble(in.nextLine());
		double hypo = Math.sqrt(Math.pow(side1, 2)+Math.pow(side2, 2));
		System.out.printf("The hypotenuse is %.2f", hypo);
		in.close();
	}

}
