import java.util.Scanner;

public class validity {
	
	public static Scanner con = new Scanner(System.in);

	public static int invalidDigit(Scanner con) {
		con.nextLine();
		System.out.println("Invalid Digit, Digit must be between 1 and 9");
		System.out.print("\nDigit(1-9)? = ");
		while(!con.hasNextInt()) {
			nonInteger(con);
		}
		int n=con.nextInt();
		return n;
	}

	public static void nonInteger(Scanner con) {
		String inv=con.next();
		System.out.println("Input is not an Integer");
		System.out.print("\nDigit(1-9)? = ");
	}
}
