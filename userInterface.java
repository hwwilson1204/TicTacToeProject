import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class userInterface {
	public static DrawingPanel panel;
	public static Graphics g;
	
	public static void setScreenBlank() {
		
		panel = new DrawingPanel(470, 470);
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
	
	public static void drawX(int square) {
		g.setColor(Color.red);
		g.setFont(new Font ("SansSerif", Font.BOLD, 50));
		
		if (square == 1) {
			g.drawString("X", 55, 103);
		}
		if (square == 2) {
			g.drawString("X", 205, 103);
		}
		if (square == 3){
			g.drawString("X", 355, 103);
		}
		if (square == 4) {
			g.drawString("X", 55, 253);
		}
		if (square == 5) {
			g.drawString("X", 205, 253);
		}
		if (square == 6) {
			g.drawString("X", 355, 253);
		}
		if (square == 7) {
			g.drawString("X", 55, 403);
		}
		if (square == 8) {
			g.drawString("X", 205, 403);
		}
		if (square == 9) {
			g.drawString("X", 355, 403);
		}
	}
	public static void drawO(int square) {
		g.setColor(Color.black);
		g.setFont(new Font ("SansSerif", Font.BOLD, 50));
		
		if (square == 1) {
			g.drawString("O", 55, 103);
		}
		if (square == 2) {
			g.drawString("O", 205, 103);
		}
		if (square == 3){
			g.drawString("O", 355, 103);
		}
		if (square == 4) {
			g.drawString("O", 55, 253);
		}
		if (square == 5) {
			g.drawString("O", 205, 253);
		}
		if (square == 6) {
			g.drawString("O", 355, 253);
		}
		if (square == 7) {
			g.drawString("O", 55, 403);
		}
		if (square == 8) {
			g.drawString("O", 205, 403);
		}
		if (square == 9) {
			g.drawString("O", 355, 403);
		}
	}
}
