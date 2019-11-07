import java.io.*;
import java.util.*;

public class arrayCharGrid {

	public static Scanner console = new Scanner(System.in);
	public static Random r = new Random();
	public static final String hgLine = "-----------"; //horizontal lines that intersect vertical lines to create 3x3 grid	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] spaces = {{'1', '|', '2', '|', '3'}, {'4', '|', '5', '|', '6'}, {'7', '|', '8', '|', '9'}};
		aiInput(spaces);
		updateGrid(spaces);
	}







	public static void aiInput(char[][] spaces) {
		int randInt=r.nextInt(9)+49;
		char randChar = (char) randInt;

	}



	public static void hInput(char[][] spaces) {

	}

	public static void updateGrid(char[][] spaces) {
		for(int l=0; l<5; l++) {
			System.out.print(" "+spaces[0][l]);
		}
		System.out.println();
		for (int n=1; n<3; n++) {
			System.out.println(hgLine);
			for (int m=0; m<5; m++) {
				System.out.print(" "+spaces[n][m]);
			}
			System.out.println();
		}
	
	}

}



