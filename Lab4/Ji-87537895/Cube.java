package labs.lab4;

/**
 * A class that represents a cube and can calculate its volume and surface
 * area.
 */
public class Cube {

	private double l;

	/**
	 * Creates a cube with the given side length.
	 * 
	 * @param sideLength the side length (assume > 0)
	 */
	public Cube(double sideLength) {
		l = sideLength;
	}


	/**
	 * Calculates the volume of the cube.
	 * 
	 * @return the volume of the cube.
	 */
	public double getVolume() {
		return l*l*l;
	}


	/**
	 * Calculates the surface area of the cube.
	 * 
	 * @return the surface area of the cube.
	 */
	public double getSurface() {
		return 6*l*l;
	}
}
