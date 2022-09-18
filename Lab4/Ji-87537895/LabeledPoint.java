package labs.lab4;

import java.awt.Point;

/**
 * A class to represent a labeled point.
 */
public class LabeledPoint extends Point {

	private String s;

	/**
	 * Constructs a labeled point at (x,y) with a given label.
	 * 
	 * @param x     the x coordinate
	 * @param y     the y coordinate
	 * @param label the point label
	 */
	public LabeledPoint(int x, int y, String label) {
		super(x,y);
		s = label;
	}


	/**
	 * Displays the (x,y) and point label
	 */
	@Override
	public String toString() {
		
		return super.toString() + " label=" + s;
	}
}
