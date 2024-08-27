
import java.util.*;
/*Write a program that lets you enter a number of minutes, and that will calculate

the number of days, hours and minutes that represents.*/
public class ProblemSet2_1_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		System.out.print("Enter a number of minutes: ");
		int minutes = Integer.parseInt(in.nextLine());
		int days = minutes / (24*60);
		int hours = minutes % (24*60) / 60;
		int rem = (minutes%(24*60))%60;
		System.out.println(days + " days, " + hours + " hours and " + rem + " minutes");
		in.close();
	}

}
