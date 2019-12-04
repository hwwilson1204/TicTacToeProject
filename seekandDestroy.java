//This method has no actual purpose towards the main code besides being an outline

import java.util.*;

public class seekandDestroy {

	public static Scanner con = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] data = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '9', '8'}};	//given data set is 3x3 array
		System.out.println("Data:");						//print data within array
		for(int n=0; n<3; n++) {
			for(int m=0; m<3; m++) {
				System.out.print(data[n][m]+" ");
			}
			System.out.println();
		}
		System.out.print("Digit? = ");						//prompt for input
		while(!con.hasNextInt()) {						//while input is NOT an integer
			validity.nonInteger(con);					//call nonInteger() method from validity class
		}
		int input=con.nextInt();						//otherwise input is an integer, set it to variable input
		boolean valid=false;							//new boolean variable valid is set to false
		do {									//initialize do-while loop
			if (input<1||input>9) {						//if input < 1 or input > 9  
				input=validity.invalidDigit(con);			//call invalidDigit() method from validity class
			}
			else {								//otherwise input is valid
				valid = true;						//therefore valid is true and we can exit loop
			}
		}while(valid==false);							//go through do-while loop as long as valid is flase
		int digit = input;							//with a valid input we can set a new integer digit to the same value as input
		char ch = (char) (digit+48);						//ASCII characters for digits 1-9 are found with the numbers 49-57 so convert the digit into char
		boolean found = false;							//new boolean variable found is set to false
		do {									//begin do-while loop
			for (int i=0;i<3;i++) {						//for each of three rows					
				for(int j=0;j<3;j++)					//for each of three columns
					if (ch==data[i][j]) {				//if ASCII character is equal to char at data[i][j]
						found=true;				//boolean found is true
						data[i][j]='X';				//data[i][j] is replaced with 'X' 
						break;					//break out of inner for loop
					}
				if(found==true) {					//if the boolean found is true
					break;						//break out of outer for loop
				}
			}
		}  while(found==false);							//go through do-while loop as long as found is false 
		System.out.println("Found at X:");					//print Statements
		for(int n=0; n<3; n++) {						//print updated data array
			for(int m=0; m<3; m++) {
				System.out.print(data[n][m]+" ");
			}
			System.out.println();
		}
	}
}