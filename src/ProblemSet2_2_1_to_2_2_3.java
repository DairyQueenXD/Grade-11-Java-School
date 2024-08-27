

public class ProblemSet2_2_1_to_2_2_3 {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) { // 2.2.1
			System.out.println(i);
		} for (int i = 10; i >= 1; i--) { // 2.2.2
			System.out.println(i);
		} for (int i = 2; i <= 29; i++) { // 2.2.3
			for (int k = 1; k <= 30; k += i) {
				System.out.println(k);
			}
		}
	}

}
