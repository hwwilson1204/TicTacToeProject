import java.util.*;

public class seekandDestroy {

	public static Scanner con = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] data = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		System.out.println("Data = " + Arrays.toString(data));
		System.out.print("Digit? = ");
		while(!con.hasNextInt()) {
			nonInteger(con);
		}
		int input=con.nextInt();	
		boolean valid=false;
		do {

			if (input<1||input>9) {
				input=invalidDigit();
			}
			else {
				valid = true;
			}
		}while(valid==false);
		int digit = input;
		char ch = (char) (digit+49);
		boolean found = false;
		do {
			for (int i=0;i<data.length;i++) {
				if (ch==data[i]) {
					found=true;
					data[i-1]='X';
				}
			}
		}  while(found==false);
		System.out.println("Found at X:" + Arrays.toString(data));
	}

	public static int invalidDigit() {
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


/* Currently this code works except for when the inputed digit is 9*/



