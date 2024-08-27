
import java.util.*;
/*Write a program that lets you enter the three sides of any triangle, and that prints
the area of the triangle using Heron's formula: s(s - a)(s - b)(s - c) , where s
stands for half the perimeter: a + b + c*/
public class ProblemSet2_1_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		System.out.print("Enter side 1 of a triangle: ");
		double side1 = Double.parseDouble(in.nextLine());
		System.out.print("Enter side 2: ");
		double side2 = Double.parseDouble(in.nextLine());
		System.out.print("Enter side 3: ");
		double side3 = Double.parseDouble(in.nextLine());
		double half = (side1+side2+side3)/2;
		double area = Math.sqrt(half*(half-side1)*(half-side2)*(half-side3));
		System.out.printf("The area is %.2f", area);
		in.close();
	}

}
