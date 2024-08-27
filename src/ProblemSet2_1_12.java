
import java.util.*;
/*Write a program that uses the Math.sin() function to calculate the area
 *  of a
triangle, 
given two sides and the contained angle: If the sides are a,b and the
angle is C,
then the area is: absinC*/
public class ProblemSet2_1_12 {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter side 1 of triangle: ");
		double side1 = Double.parseDouble(in.nextLine());
		System.out.print("Enter side 2: ");
		double side2 = Double.parseDouble(in.nextLine());
		System.out.print("Enter contained angle: ");
		double degree = Double.parseDouble(in.nextLine());
		double area = side1*side2*Math.sin(degree*Math.PI/180)/2;
		System.out.printf("The area is %.2f", area);
		in.close();

	}

}
