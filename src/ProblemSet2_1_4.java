
import java.util.*;
public class ProblemSet2_1_4 {
//Write a program that lets you enter the radius of a circle and that prints both the

//circumference and the area of the circle
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the radius of a circle: ");
		double radius = Double.parseDouble(in.nextLine());
		double circumference = 2*Math.PI*radius;
		double area = Math.pow(radius, 2)*Math.PI;
		System.out.printf("The circumference is %.2f and the area is %.2f.", circumference, area);
		in.close();
	}

}
