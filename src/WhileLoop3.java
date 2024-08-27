
import java.util.*;
public class WhileLoop3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = in.nextInt();
		int factor = 1;
		int x = 1;
		int primeCounter = 0;
		while (x <= num){
			primeCounter = 0;
			factor = 1;
			while (factor <= x) {
				if (x % factor == 0) {
					primeCounter++;
				}
				factor++;
			}
			if (primeCounter == 2) {
				System.out.print(x+", ");
			}
			x++;
		}
		
		in.close();
	}

}
