
import java.util.Scanner;

public class ExerciseClass3 {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter mark 1: ");
		int mark1 = Integer.parseInt(in.nextLine());
		System.out.print("Enter mark 2: ");
		int mark2 = Integer.parseInt(in.nextLine());
		System.out.print("Enter mark 3: ");
		int mark3 = Integer.parseInt(in.nextLine());
		System.out.print("What is your name: ");
		String name = in.nextLine();
		double average = (mark1+mark2+mark3)/3.0;
		int max = Math.max(Math.max(mark1, mark2), mark3);
		System.out.println("Hi " + name + "! Your marks were " + mark1 + "%, " +
		mark2 + "% and "+ mark3 + "%. Your average was " + average + "%.");
		System.out.println("The highest score was " + max + ".");
		in.close();
	}
}
