
import java.util.*;
/*Write a program that converts degree measures to radian measures */
public class ProblemSet2_1_11 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		System.out.print("Enter a degree measure: ");
		int degree = Integer.parseInt(in.nextLine());
		double radian = degree*Math.PI/180;
		System.out.printf("The radian measure is %.2f", radian);
		in.close();
	}

}
