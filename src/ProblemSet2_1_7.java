
/*Write a program that lets you enter a number of hours, and that converts it to days

and hours. For example, 111 hours = 4 days and 15 hours.*/
import java.util.*;
public class ProblemSet2_1_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		System.out.print("Enter a number of hours: ");
		int hours = Integer.parseInt(in.nextLine());
		int days = hours / 24;
		int rem = hours % 24;
		System.out.println(hours + " hours is equal to " + days + " days and " + rem + " hours.");
		in.close();
	}

}
