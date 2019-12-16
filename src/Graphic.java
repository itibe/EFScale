import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JComponent;

public class Graphic extends JComponent {
	// Ian Tibe
	// data fields and constants
	private int yCoordinate;
	private int leftXCoordinate;
	private int rightXCoordinate;
	private Color triangleColor;
	private final double TRIANGLEHEIGHT = 200;
	private final double MAXEFLEVEL = 5; // keep as double, or program will not work
	private final int NUMBEROFSIDESINTRIANGLE = 3;
	private final int initialLeftXCoordinate = 100;
	private final int initialrightXCoordinate = 100;
	private final int initialYCoordinate = 100;

	// The following arrays contain a point that define the outline of the triangle
	private final int[] BOTTOMVERTEX = { 100, 100 };
	private final int[] LEFTVERTEX = { 0, 0 };
	private final int[] RIGHTVERTEX = { 200, 0 };

	// constructors
	Graphic() {
		leftXCoordinate = initialLeftXCoordinate;
		rightXCoordinate = initialrightXCoordinate;
		yCoordinate = initialYCoordinate;

	}

	// getter and setters
	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoord) {
		yCoordinate = yCoord;
	}

	public int getLeftXCoordinate() {
		return leftXCoordinate;
	}

	public void setLeftXCoordinate(int leftXCoord) {
		leftXCoordinate = leftXCoord;
	}

	public int getRightXCoordinate() {
		return rightXCoordinate;
	}

	public void setRightXCoordinate(int rightXCoord) {
		rightXCoordinate = rightXCoord;
	}

	public Color gettriangleColor() {
		return triangleColor;
	}

	public void settriangleColor(Color triangleColor) {
		this.triangleColor = triangleColor;
	}

	// paintComponent method
	public void paintComponent(Graphics g) {
		// draw lines that define upside down triangle
		g.drawLine(LEFTVERTEX[0], LEFTVERTEX[1], BOTTOMVERTEX[0], BOTTOMVERTEX[1]);
		g.drawLine(RIGHTVERTEX[0], RIGHTVERTEX[1], BOTTOMVERTEX[0], BOTTOMVERTEX[1]);
		// calls method to fill in triangle
		drawTriangle(g);

	}

	// helper methods
	private void drawTriangle(Graphics g) {
		/*
		 * this method draws an upside down triangle based on inputs of the coordinates
		 * of the top two vertices of the triangle. There is only one y coordinate data field because
		 * the top of the triangle is a line and the y coordinate is always the same in both vertices
		 */
		int[] xcoord = { BOTTOMVERTEX[0], getLeftXCoordinate(), getRightXCoordinate() };
		int[] ycoord = { BOTTOMVERTEX[1], getyCoordinate(), getyCoordinate() };

		Polygon shape = new Polygon(xcoord, ycoord, NUMBEROFSIDESINTRIANGLE);
		g.setColor(gettriangleColor());
		g.fillPolygon(shape);

	}

	public void generateCoordinates(int EFLevel) {
		/*
		 * this method takes in the EF level and generates coordinates for the upside
		 * down triangle. the coordinates are taken in by the drawTrangle method
		 */

		double EFPercentage = EFLevel / MAXEFLEVEL;

		double change = TRIANGLEHEIGHT * EFPercentage;
		int integerChange = (int) change;

		setLeftXCoordinate((-integerChange / 2) + 100);
		setRightXCoordinate((integerChange / 2) + 100);
		setyCoordinate((-integerChange / 2) + 100);

		// set triangle color based on EF Level
		if (EFLevel >= 5) {
			this.settriangleColor(Color.magenta);
		}
		if (EFLevel == 4) {
			this.settriangleColor(Color.red);
		}
		if (EFLevel == 2 | EFLevel == 3) {
			this.settriangleColor(Color.yellow);
		}
		if (EFLevel == 0 | EFLevel == 1) {
			this.settriangleColor(Color.green);
		}
		repaint();
	}
}
