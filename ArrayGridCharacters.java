
import java.io.*;
import java.util.*;

public class ArrayGridCharacters {

	public static Scanner con = new Scanner(System.in);
	public static Random r = new Random();
	public static final String hgLine = "-----------"; //horizontal lines that intersect vertical lines to create 3x3 grid	
	/*
	 [0][0]  [0][1]  [0][2]  [0][3]  [0][4]
	 [1][0]  [1][1]  [1][2]  [1][3]  [1][4]
	 [2][0]  [2][1]  [2][2]  [2][3]  [2][4] 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		userInterface ticTacToeBoard = new userInterface();
		ticTacToeBoard.setScreenBlank();
		
		char[][] spaces = {
				{'1', '|', '2', '|', '3'}, 
				{'4', '|', '5', '|', '6'}, 
				{'7', '|', '8', '|', '9'}
				};
		boolean victory = false;
		// computer goes first, generate random & markX for CPU
		intInput(spaces, ticTacToeBoard);
		updateGrid(spaces);
		for(int iterations=1; iterations<=4; iterations++) {
			hInput(spaces, ticTacToeBoard);
			updateGrid(spaces);
			victory=victorious(spaces);
			if(victory==true) {
				break;
			}
			aiInput(spaces, ticTacToeBoard);
			updateGrid(spaces);
			victory=victorious(spaces);
			if(victory==true) {
				break;
			}
		}
		if(victory==true) {
			char victor=victor(spaces);
			if (victor=='X') {
				System.out.println("CPU Wins!");
			}
			else if(victor=='O') {
				System.out.println("You Win!");
			}
		}
		else {
			System.out.println("No Winner. Cat Game.");
		}
	}

	public static int generateRandom() {
		int randInt;
		randInt = r.nextInt(9-1) + 1;;
		return randInt;
	}

	public static void intInput(char[][] spaces, userInterface ticTacToeBoard) {
		int randInt=generateRandom();
		char randChar=intConversion(randInt);
		for (int i=0;i<3;i++) {
			for(int j=0;j<=4; j=j+2)
				if (randChar==spaces[i][j]) {
					spaces[i][j]='X';
					// draw x on drawing board:
					ticTacToeBoard.drawX(randInt);
				}
		}
		System.out.println("CPU Input = "+randChar);
	}

	public static void aiInput(char[][] spaces, userInterface ticTacToeBoard) {
		int randInt=generateRandom();
		char randChar=intConversion(randInt);
		boolean found = false;
		do {
			for (int i=0;i<3;i++) {
				for(int j=0;j<=4;j=j+2)
					if (randChar==spaces[i][j]) {
						found=true;
						spaces[i][j]='X';
						// draw x on board:
						ticTacToeBoard.drawX(randInt);
						System.out.println("CPU Input = "+randChar);
						break;
					}
					else {
						randInt=generateRandom();
						randChar=intConversion(randInt);
					}
			}
			if (found==true) {
				break;
			}
		}  while(found==false);
	}

	public static void hInput(char[][] spaces, userInterface ticTacToeBoard) {
		int input=digitSelection();
		char charIn=intConversion(input);
		boolean found=false;
		do {
			for (int i=0;i<3;i++) {
				for(int j=0;j<=4;j=j+2) {
					if (charIn==spaces[i][j]) {
						found=true;
						spaces[i][j]='O';
						// draw O on drawing board:
						ticTacToeBoard.drawO(input);
						break;
					}
				}
				if(found==true) {
					break;
				}
			} 
			if (found==false) {
				System.out.println("Space in use. Please select another box.");
				input=digitSelection();
				charIn=intConversion(input);
			}
		}while(found==false);
	}

	public static int digitSelection() {
		System.out.print("Digit? = ");
		while(!con.hasNextInt()) {
			validity.nonInteger(con);
		}
		int input=con.nextInt();	
		boolean valid=false;
		do {
			if (input<1||input>9) {

				input=validity.invalidDigit(con);
			}
			else {
				valid = true;
			}
		}while(valid==false);
		return input;
	}

	public static char intConversion(int input) {
		char inChar=(char) (input+48);
		return inChar;
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
		System.out.println();
	}

	public static boolean victorious(char[][] spaces) {
		boolean victory=false;
		for(int row=0; row<=2; row++) {
			if((spaces[row][0]==spaces[row][2])&&(spaces[row][0]==spaces[row][4])&&(spaces[row][4]==spaces[row][2])) {
				victory=true;
				return victory;
			}
		}
		for(int column=0; column<=4; column=column+2) {
			if((spaces[0][column]==spaces[1][column])&&(spaces[0][column]==spaces[2][column])&&(spaces[1][column]==spaces[2][column])) {
				victory=true;
				return victory;
			}
		}
		if((spaces[0][0]==spaces[1][2])&&(spaces[1][2]==spaces[2][4])&&(spaces[2][4]==spaces[0][0])) {
			victory=true;
			return victory;
		}
		else if((spaces[2][0]==spaces[1][2])&&(spaces[2][0]==spaces[0][4])&&(spaces[0][4]==spaces[1][2])) {
			victory=true;
			return victory;
		}
		else {
			victory=false;
			return victory;
		}

		/* for each row
`			if spaces[row][0]==spaces[row][2]==spaces[row][4]		
			victory==true
		   for each column
		   	if spaces[0][column]==spaces[1][column]==spaces[2][column]
		   	victory==true
		   if spaces[0][0]==spaces[1][2]==spaces[2][4]
		    victory==true
		   if spaces[2][0]==spaces[1][2]==spaces[0][4]
		    victory==true
		   else
		    victory==false */
	}

	public static char victor(char[][] spaces) {
		char victor = 'N';
		for(int row=0; row<=2; row++) {
			if((spaces[row][0]==spaces[row][2])&&(spaces[row][0]==spaces[row][4])&&(spaces[row][4]==spaces[row][2])) {
				if(spaces[row][0]=='X') {
					victor='X';
					return victor;
				}
				else if(spaces[row][0]=='O') {
					victor='O';
					return victor;
				}
			}
		}
		for(int column=0; column<=4; column=column+2) {
			if((spaces[0][column]==spaces[1][column])&&(spaces[0][column]==spaces[2][column])&&(spaces[1][column]==spaces[2][column])) {
				if(spaces[0][column]=='X') {
					victor='X';
					return victor;
				}
				else if(spaces[0][column]=='O') {
					victor='O';
					return victor;
				}
			}
		}
		if((spaces[0][0]==spaces[1][2])&&(spaces[1][2]==spaces[2][4])&&(spaces[2][4]==spaces[0][0])) {
			if(spaces[0][0]=='X') {
				victor='X';
				return victor;
			}
			else if(spaces[0][0]=='O') {
				victor='O';
				return victor;
			}
		}
		else if((spaces[2][0]==spaces[1][2])&&(spaces[2][0]==spaces[0][4])&&(spaces[0][4]==spaces[1][2])) {
			if(spaces[2][0]=='X') {
				victor='X';
				return victor;
			}
			else if(spaces[2][0]=='O') {
				victor='O';
				return victor;
			}
		}
		return victor;
	}
}

