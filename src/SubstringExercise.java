
import java.util.*;
public class SubstringExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		String word = in.nextLine();
		// length = 6, index = 2, index = length/2
		// length = 7 0123456, index middle = length/2
		// length = 9, 012345678
		// turrur?
		if (word.length() % 2 == 0) {
			System.out.print((word.substring(word.length()/2)).toUpperCase());
			System.out.println((word.substring(0,word.length()/2).toUpperCase()));
		
		} else {
			System.out.print((word.substring(word.length()/2+1)).toLowerCase());
			System.out.println((word.substring(0,word.length()/2)).toLowerCase());
		}
		in.close();
	}

}
