
import java.util.*;
public class StringExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		System.out.print("Enter a sentence: ");
		String sentence = in.nextLine();
		System.out.print("Enter a letter: ");
		char letter = in.nextLine().charAt(0);
		int counter = 0;
		
		for (int i=0; i < sentence.length();i++) {
			if ((""+sentence.charAt(i)).equalsIgnoreCase("" + letter)) {
				counter++;
			}
			if (i != sentence.length()-1 && (""+sentence.charAt(i)).equalsIgnoreCase(""+sentence.charAt(i+1))) {
				counter --;
			}
			
		}
		System.out.println(sentence + " has " + counter + " " + letter + "'s");
		in.close();
	}
	

}
