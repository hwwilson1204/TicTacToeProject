import java.io.*;
import java.util.*;

public class arrayCharGrid {

	public static Scanner console = new Scanner(System.in);
	public static Random r = new Random();
	public static final String hgLine = "-----------"; //horizontal lines that intersect vertical lines to create 3x3 grid	

	 /*
	 [0][0]  [0][1]  [0][2]  [0][3]  [0][4]
	 [1][0]  [1][1]  [1][2]  [1][3]  [1][4]
	 [2][0]  [2][1]  [2][2]  [2][3]  [2][4] 
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] spaces = {{'1', '|', '2', '|', '3'}, {'4', '|', '5', '|', '6'}, {'7', '|', '8', '|', '9'}};
		boolean victory = false;
		intInput(spaces);
		updateGrid(spaces);
		do {
			hInput(spaces);
			updateGrid(spaces);
			victory=victorious(spaces);
			aiInput(spaces);
			updateGrid(spaces);
			victory=victorious(spaces);
		}while(victory==false);
	}

	public static char generateRandom() {
		int randInt;
		// generate a random number between 1 and 9
		randInt = r.nextInt(9-1+1) + 49;
		//ASCII Characters '1'-'9' are integers 49-57
		char randChar = (char) randInt;
		return randChar;
		}
	
	public static void intInput(char[][] spaces) {
		char randChar=generateRandom();
		for (int i=0;i<3;i++) {
			for(int j=0;j<=4; j=j+2)
				if (randChar==spaces[i][j]) {
					spaces[i][j]='X';
				}
		}
	}

	public static void aiInput(char[][] spaces) {
		char randChar = generateRandom();
		boolean found = false;
		do {
			for (int i=0;i<3;i++) {
				for(int j=0;j<=4;j=j+2)
					if (randChar==spaces[i][j]) {
						found=true;
						spaces[i][j]='X';
					}
					else {
						randChar=generateRandom();
					}
			}
		}  while(found==false);
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
}


