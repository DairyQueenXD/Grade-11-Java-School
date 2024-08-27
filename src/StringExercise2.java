
import java.util.*;
public class StringExercise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		String name = in.nextLine().trim();
		int index = -2;
		for (int i = name.length()-1; i >= 0; i--) {
			if (name.charAt(i) == ' ') {
				index = i;
				break;
			}
		}
		for (int x = index+1; x <= name.length()-1 && x >= 0; x++) {
			if (x == index+1) {
				System.out.print((name.charAt(x)+"").toUpperCase());
			} else {
				System.out.print(name.charAt(x));
			}
		}
		if (index != -2) {
			System.out.print(", ");
		} else {
			System.out.print(name);
		}
		
		for (int y = 0; y <= index-1; y++) {
			if (y == 0) {
				System.out.print((name.charAt(y)+"").toUpperCase());
			} else {
				System.out.print(name.charAt(y));
			}
			
		}
		in.close();
		
	}

}
