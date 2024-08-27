
import java.util.*;
//Write a program that lets you enter a distance in kilometers and that converts it

//into miles. 0.621371
public class ProblemSet2_1_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		System.out.print("Enter a distance in km: ");
		double km = Double.parseDouble(in.nextLine());
		double miles = km*0.621371;
		System.out.printf("The distance in miles is %.2f", miles);
		in.close();
	}

}
