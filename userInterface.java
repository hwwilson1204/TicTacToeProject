import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
																	// Class which implements a screen that displays the results of console input
public class userInterface {
	public static DrawingPanel panel;
	public static Graphics g;
	
	public void setScreenBlank() {
		
		panel = new DrawingPanel(470, 470);							// creating a tic-tac toe table without any X's or O's
		g = panel.getGraphics();
		// board size will be 500 * 500
		g.setColor(Color.black);
		
		g.drawRect(10, 10, 450, 450);
		//vertical line 1
		g.drawLine(150, 10, 150, 460);
		// vertical line 2
		g.drawLine(300, 10, 300, 460);
		
		//horizontal line 1
		g.drawLine(10, 150, 460, 150);
		// horizontal line 2
		g.drawLine(10, 300, 460, 300);
	}
	
	public void draw(int square, String symbol) {
		g.setFont(new Font ("SansSerif", Font.BOLD, 50));
		
		if (symbol == "X") {
			g.setColor(Color.red);									// setting color to be red for X (CPU), blue for O (human)
		}
		else {
			g.setColor(Color.blue);
		}
		
		
		if (square == 1) {											//drawing X's or O's to their corresponding spots in each of the 9 grid spaces
			g.drawString(symbol, 55, 103);
		}
		if (square == 2) {
			g.drawString(symbol, 205, 103);
		}
		if (square == 3){
			g.drawString(symbol, 355, 103);
		}
		if (square == 4) {
			g.drawString(symbol, 55, 253);
		}
		if (square == 5) {
			g.drawString(symbol, 205, 253);
		}
		if (square == 6) {
			g.drawString(symbol, 355, 253);
		}
		if (square == 7) {
			g.drawString(symbol, 55, 403);
		}
		if (square == 8) {
			g.drawString(symbol, 205, 403);
		}
		if (square == 9) {
			g.drawString(symbol, 355, 403);
		}
	}
	
	public void endGame(String winner) {
		g.setFont(new Font ("SansSerif", Font.BOLD, 75));
		if (winner=="X") {
			g.setColor(Color.red);
			g.drawString("CPU Wins!" , 47, 200);
		}	
		else if(winner=="O") {
			g.setColor(Color.blue);
			g.drawString("You win!" , 70, 200);
			
		}
	}
}