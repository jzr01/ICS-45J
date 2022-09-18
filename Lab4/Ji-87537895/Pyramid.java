package labs.lab4;

import java.lang.Math;
/**
 * A class that represents a right square pyramid and can calculate its volume and surface
 * area.
 */
public class Pyramid {

	 private double l;
	 private double h;

	/**
	 * Creates a new right square pyramid of given edge length and height.
	 * 
	 * @param 	edgeLength		the length of one of the pyramid's base edges (assume > 0)
	 * @param 	height			the height of the pyramid (assume > 0)
	 */
	public Pyramid(double edgeLength, double height) {
		l = edgeLength;
		h = height;
	}


	/**
	 * Calculates the volume of the pyramid.
	 * 
	 * @return the volume of the pyramid
	 */
	public double getVolume() {
		return l*l*h/3.0;
	}


	/**
	 * Calculates the surface area of the pyramid.
	 * 
	 * @return the surface area of the pyramid
	 */
	public double getSurface() {
		return l*l+2*l*Math.sqrt(l*l/4.0+h*h);
	}
}
