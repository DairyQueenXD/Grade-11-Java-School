
import java.util.*;
/* cosine law */
public class ProblemSet2_1_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		System.out.print("Enter side 1 of triangle: ");
		double side1 = Double.parseDouble(in.nextLine());
		System.out.print("Enter side 2: ");
		double side2 = Double.parseDouble(in.nextLine());
		System.out.print("Enter contained angle: ");
		double angle = Double.parseDouble(in.nextLine());
		double side3 = Math.sqrt(Math.pow(side1, 2)+Math.pow(side2, 2)-2*side1*side2*Math.cos(angle*Math.PI/180));
		System.out.printf("The third side is %.2f", side3);
		in.close();
	}

}
