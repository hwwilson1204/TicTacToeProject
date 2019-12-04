// add end method, to show you win, and you lose, include pictures
// update what the interface is in the documentation
// add a flow chart for the program
import java.io.*;
import java.util.*;

public class ArrayGridCharacters {

	public static Scanner con = new Scanner(System.in);
	public static Random r = new Random();
	public static final String hgLine = "-----------"; //horizontal lines that intersect vertical lines to create 3x3 grid	
	public static userInterface ticTacToeBoard = new userInterface();
	/*
	 * This is the representation of spaces[][] array
	 [0][0]  [0][1]  [0][2]  [0][3]  [0][4]
	 [1][0]  [1][1]  [1][2]  [1][3]  [1][4]
	 [2][0]  [2][1]  [2][2]  [2][3]  [2][4] 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ticTacToeBoard.setScreenBlank();
		
		char[][] spaces = {
				{'1', '|', '2', '|', '3'}, 
				{'4', '|', '5', '|', '6'}, 
				{'7', '|', '8', '|', '9'}
				};														//initialize the spaces[][] array
		boolean victory = false;
																		//computer goes first, generate random & markX for CPU
		intInput(spaces, ticTacToeBoard);
		updateGrid(spaces);
		for(int iterations=1; iterations<=4; iterations++) {
			hInput(spaces, ticTacToeBoard);								//call human input function passing in spaces and ticTacToeBoard objects
			updateGrid(spaces);											//call updateGrid() to update spaces object
			victory=victorious(spaces);									//calls victorious() to determine if game is won  
			if(victory==true) {
				break;
			}
			aiInput(spaces, ticTacToeBoard);							//computer gets called to go again
			updateGrid(spaces);			
			victory=victorious(spaces);									//calls victorious() to determine if game is won
			if(victory==true) {
				break;
			}
		}
		if(victory==true) {
			char victor=victor(spaces);									//calls victor() to determine who won the game
			if (victor=='X') {
				System.out.println("CPU Wins!");
				ticTacToeBoard.endGame("X");							//display "CPU Wins!" on screen
			}	
			else if(victor=='O') {
				System.out.println("You Win!");
				ticTacToeBoard.endGame("O");							// display "You Win!" on screen
			}
		}
		else {
			System.out.println("No Winner. Cat Game.");
		}
	} 

	public static int generateRandom() {								// generates a random integer between 1-9 and returns value
		int randInt;
		randInt = r.nextInt(9-1) + 1;
		return randInt;
	}

	public static void intInput(char[][] spaces, userInterface ticTacToeBoard) {		//intInput() begins game
		int randInt=generateRandom();										//call generateRandom()
		char randChar=intConversion(randInt);								//call intConversion()
		for (int i=0;i<3;i++) {												
			for(int j=0;j<=4; j=j+2)										//for every other column
				if (randChar==spaces[i][j]) {								//if the character at spaces[i][j] is the same as randChar
					spaces[i][j]='X';										//replace the value with 'X'
					ticTacToeBoard.draw(randInt, "X");						//draw x to ticTacToeBoard
				}
			
		}
		System.out.println("CPU Input = "+randChar);									
	}

	public static void aiInput(char[][] spaces, userInterface ticTacToeBoard) {							//aiInput() produces CPU input after first input
		int randInt=generateRandom();										//call generateRandom()
		char randChar=intConversion(randInt);								//call intConversion()
		boolean found = false;												
		do {																//begin do-while loop
			for (int i=0;i<3;i++) {											//for each of 3 rows
				for(int j=0;j<=4;j=j+2)										//for every other column 
					if (randChar==spaces[i][j]) {							
						found=true;											
						spaces[i][j]='X';									//replace spaces[i][j] with 'X'
						ticTacToeBoard.draw(randInt, "X");					//draw x to ticTacToeBoard
						System.out.println("CPU Input = "+randChar);		
						break;												//break from inner for loop
					}
					else {													//else if it doesn't equal, generate new input
						randInt=generateRandom();							//call generateRandom()
						randChar=intConversion(randInt);					//call intConversion
					}
			}
			if (found==true) {											
				break;												
			}
		}  while(found==false);												//do-while loop active while found is false						
	}

	public static void hInput(char[][] spaces, userInterface ticTacToeBoard) {							//hInput() produces the players input
		int input=digitSelection();											//call digitSelection()
		char charIn=intConversion(input);									//call intConversion()
		boolean found=false;											
		do {																//begin do-while loop
			for (int i=0;i<3;i++) {											//for each of 3 rows
				for(int j=0;j<=4;j=j+2) {									//for every other column
					if (charIn==spaces[i][j]) {							
						found=true;								
						spaces[i][j]='O';									//replace char at spaces[][j] with 'O'	
						ticTacToeBoard.draw(input, "O");					//draw "O" to ticTacToeBoard
						break;									
					}
				}
				if(found==true) {									
					break;										
				}
			} 
			if (found==false) {												//if found is false after looking through spaces
				System.out.println("Space in use. Please select another box.");			
				input=digitSelection();										//call digitSelection()
				charIn=intConversion(input);								//call intConversion()
			}
		}while(found==false);												//do-while loop continues for found is false
	}
	
	
	public static int digitSelection() {									//digitSelection() helps produce the human input for the console
		System.out.print("Digit? = ");										
		while(!con.hasNextInt()) {											//while input is not an integer
			validity.nonInteger(con);										//call nonInteger() from validity class
		}
		int input=con.nextInt();											//otherwise input is integer,set it to input	
		boolean valid=false;											
		do {																//begin do-while loop
			if (input<1||input>9) {									
				input=validity.invalidDigit(con);							//call invalidDigit() from validity class
			}
			else {											 
				valid = true;										
			}
		}while(valid==false);												//do-while loop occurs while valid is false
		return input;												
	}

	public static char intConversion(int input) {							//intConversion converts int input into ASCII char
		char inChar=(char) (input+48);										//ASCII chars for digits 1-9 are represented by ints 49-57
		return inChar;												
	}

	public static void updateGrid(char[][] spaces) {						//print the 3x3 grid into the console
		for(int l=0; l<5; l++) {											//fencepost algorithm, for each of 5 columns
			System.out.print(" "+spaces[0][l]);								
		}
		System.out.println();												
		for (int n=1; n<3; n++) {										
			System.out.println(hgLine);										//print horizontal line
			for (int m=0; m<5; m++) {									
				System.out.print(" "+spaces[n][m]);							
			}
			System.out.println();										
		}							
		System.out.println();											
	}



	public static boolean victorious(char[][] spaces) {						//victorious() tests to see if victory conditions are satisfied										
		boolean victory=false;												//initalize victory as false
		/*
		 for each row
		 if there is a horizontal line of the same character ('X' or 'O')
		 victory is true
		 return victory
		 */
		for(int row=0; row<=2; row++) {
			if((spaces[row][0]==spaces[row][2])&&(spaces[row][0]==spaces[row][4])&&(spaces[row][4]==spaces[row][2])) {
				victory=true;
				return victory;
			}
		}
		/*
		 for each other column
		 if there is a vertical line of the same character ('X' or 'O')
		 victory is true
		 return victory
		 */
		for(int column=0; column<=4; column=column+2) {
			if((spaces[0][column]==spaces[1][column])&&(spaces[0][column]==spaces[2][column])&&(spaces[1][column]==spaces[2][column])) {
				victory=true;
				return victory;
			}
		}
		/*
		 if there is a downwards (negative slope) line of the same character ('X' or 'O')
		 victory is true
		 return victory
		 */
		if((spaces[0][0]==spaces[1][2])&&(spaces[1][2]==spaces[2][4])&&(spaces[2][4]==spaces[0][0])) {
			victory=true;
			return victory;
		}
		/*
		 if there is an upwards (positive slope) line of the same character ('X' or 'O')
		 victory is true
		 return victory
		 */
		else if((spaces[2][0]==spaces[1][2])&&(spaces[2][0]==spaces[0][4])&&(spaces[0][4]==spaces[1][2])) {
			victory=true;
			return victory;
		}
		/*
		 * otherwise victory is false return victory
		 */
		else {
			victory=false;
			return victory;
		}
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
	public static char victor(char[][] spaces) {								//victor() determines victor
		char victor = 'N';														//intialize the char victor as 'N'
		/*
		 for each row
		 if there is a horizontal line of the same character ('X' or 'O')
		 	if char is 'X'
		 		victor is 'X'
		 		return victor
		 	if char is 'O'
		 		victor is 'O'
		 		return victor
		 */
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
		/*
		 for each other column
		 if there is a horizontal line of the same character ('X' or 'O')
		 	if char is 'X'
		 		victor is 'X'
		 		return victor
		 	if char is 'O'
		 		victor is 'O'
		 		return victor
		 */
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
		/*
		 if there is a downwards (negative slope) line of the same character ('X' or 'O')
		 	if char is 'X'
		 		victor is 'X'
		 		return victor
		 	if char is 'O'
		 		victor is 'O'
		 		return victor
		 */
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
		/*
		 if there is a downwards (negative slope) line of the same character ('X' or 'O')
		 	if char is 'X'
		 		victor is 'X'
		 		return victor
		 	if char is 'O'
		 		victor is 'O'
		 		return victor
		 */
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




