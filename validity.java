//The validity class prompts for new inputs as a result of input not being an integer OR int < 1 OR int > 9

import java.util.Scanner;

public class validity {
	
	public static Scanner con = new Scanner(System.in);

	public static int invalidDigit(Scanner con) {					//called if console input is an int < 1 or > 9
		con.nextLine();								//waste input
		System.out.println("Invalid Digit, Digit must be between 1 and 9");	//print Statements
		System.out.print("\nDigit(1-9)? = ");					//prompt for new input
		while(!con.hasNextInt()) {						//while con input is not an integer
			nonInteger(con);						//call nonInteger()
		}
		int n=con.nextInt();							//otherwise input is an integer therefore we can set new input to n
		return n;								//return new input		
	}

	public static void nonInteger(Scanner con) {					//called while console input is not an integer
		String inv=con.nextLine();						//set Input to inv, which is used nowhere else in code, effectively wasting input
		System.out.println("Input is not an Integer");				//print Statements
		System.out.print("\nDigit(1-9)? = ");					//prompt new input
	}
}
