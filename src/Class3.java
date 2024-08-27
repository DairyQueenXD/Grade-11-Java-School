
// import java.util.*; (import all)
import java.util.Scanner;
public class Class3 {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.println("How old are you?: ");
		int age = Integer.parseInt(in.nextLine()); 
		// double version: double age = in.nextDouble();
		// double version: Double.parseDouble (in.nextLine());
		System.out.println("Your age is " + age);
		
		
		System.out.println("What is your name?: ");
		String name = in.nextLine();
		System.out.println("Your name is " + name);
		in.close();
		
	}

}
