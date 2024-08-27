

public class WhileLoop1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		int num1, num2;
		while (i <= 100) {
			num1 = (int) (Math.random()*6)+1;
			num2 = (int) (Math.random()*6)+1;
			if (num1+num2 == 7) {
				System.out.println("Round " + i + ": Dice 1 = " + num1 + ", Dice 2 = " + num2 + " --> LUCKY SEVEN!!!");
			} else if (num1+num2 == 2) {
				System.out.println("Round " + i + ": Dice 1 = " + num1 + ", Dice 2 = " + num2 + " --> SNAKE EYES!!!");
			}
			i++;
		}
	}

}
