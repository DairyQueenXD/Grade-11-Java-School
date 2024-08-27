
import java.util.*;
public class StringExercise2Substring {

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
		
		if (!(index <0)) {
			System.out.print((name.charAt(index+1)+"").toUpperCase());
			System.out.print(name.substring(index+2));
		}
		
		if (index != -2) {
			System.out.print(", ");
		} else {
			System.out.print(name);
		}
		
		if (!(index<0)) {
			System.out.print((name.charAt(0)+"").toUpperCase());
			System.out.print(name.substring(1,index));
		}
		in.close();
		}
	}

