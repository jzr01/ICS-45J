package labs.lab4;

/**
 * A class that represents a rectangular and can calculate its volume and surface area.
 */
public class Prism {

	private double w;
	private double l;
	private double h;

	/**
	 * Creates a rectangular prism of given width, length, and height.
	 * 
	 * @param 	width	the width of the prism's base (assume > 0)
	 * @param 	length	the length of the prism's base (assume > 0)
	 * @param 	height	the height of the prism (assume > 0)
	 * @return 	the volume of the rectangular prism
	 */
	public Prism(double width, double length, double height) {
		w = width;
		l = length;
		h = height;
	}


	/**
	 * Calculates the volume of the prism.
	 * 
	 * @return the volume of the prism
	 */
	public double getVolume() {
		return w*l*h;
	}


	/**
	 * Calculates the surface area of the prism.
	 * 
	 * @return the surface area of the prism
	 */
	public double getSurface() {
		return 2*(l*w+l*h+w*h);
	}

}
