

public class ForWhileLoopExercise {

	public static void main(String[] args) {
		int index = -1;
		int counter = 0;
		for (int i=21; i<=63; i += 3) {
			counter += Math.pow(i,3)*index;
			index *= -1;
		}
		System.out.println(counter);
		
		int index2 = 0;
		int counter2 = 0;
		int x = 21;
		while (x <= 63) {
			if (index2 % 2 == 0) {
				counter2 += Math.pow(x, 3)*-1;
			} else {
				counter2 += Math.pow(x,3);
			} 
			index2++;
			x += 3;
		}
		System.out.println(counter2);
	}

}
