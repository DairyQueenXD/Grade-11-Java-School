

public class SystemOutPrintf {

	public static void main(String[] args) {
		
		int num = 10;
		System.out.printf("Hello %d Bye", num);
		double stat = 5629.75;
		System.out.printf ("%+-14.4f", stat);
		
		System.out.printf("%8d%8f%8d", num, stat);
	}

}
