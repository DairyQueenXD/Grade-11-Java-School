
import java.util.*;
public class IntroToJavaExercise9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		System.out.println("Enter the height: ");
		double height = Double.parseDouble(in.nextLine());
		System.out.println("Enter the radius: ");
		double radius = Double.parseDouble(in.nextLine());
		double surfaceArea = 2*Math.PI*radius*(radius+height);
		double volume = Math.PI*radius*radius*height;
		System.out.printf("The surface area is %.1f and the volume is %.1f", surfaceArea, volume);
		in.close();
	}

}
