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
		char[] row1= Arrays.copyOfRange(spaces, 0, 4);
		char[] row2= Arrays.copyOfRange(spaces, 5, 9);
		char[] row3= Arrays.copyOfRange(spaces, 10, 14);
	}
}



