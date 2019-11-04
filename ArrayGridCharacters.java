import java.io.*;
import java.util.*;


public class ArrayGridCharacters {

	public static Scanner console = new Scanner(System.in);
	public static Random r = new Random();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] spaces = {'1', '|', '2', '|', '3', '4', '|', '5', '|', '6', '7', '|', '8', '|', '9'};
		aiInput(spaces);
		updateGrid(spaces);
	}







	public static void aiInput(char[] spaces) {
		int randInt=r.nextInt(9)+49;
		char randChar = (char) randInt;
		for (char ch : spaces) {
			if (randChar != ch) {
				
			}
		}
	}

	public static void hInput(char[] spaces) {
		
	}

	public static void updateGrid(char[] spaces) {
			char[] row1= Arrays.copyOfRange(spaces, 0, 5); //top 3 squares
			char[] row2= Arrays.copyOfRange(spaces, 5, 10);//middle 3 squares
			char[] row3= Arrays.copyOfRange(spaces, 10, 15);//bottom 3 squares
			for (int n=0; n<5; n++) {
				System.out.print(" " +row1[n]);
			}
			System.out.println("\n"+hgLine);
			for (int n=0; n<5; n++) {
				System.out.print(" "+row2[n]);
			}
			System.out.println("\n"+hgLine);
			for (int n=0; n<5; n++) {
				System.out.print(" "+row3[n]);
			}
			// fencepost algorithm row 1 --> then hgLine and next row
		}
}



