package labs.lab7;

import java.awt.Point;

/**
 * Class representing a food item in the survival game
 */
public class Food implements Comparable {

	// ADD YOUR INSTANCE VARIABLES HERE

	/**
	 * Constructs a new food item
	 * 
	 * @param location    location of the food item
	 * @param player      player in the game
	 * @param description description of the food item
	 * @param energyValue energy value of the food item
	 */
	public Food(Point location, Player player, String description, int energyValue) {
		// FILL IN
	}


	public Point getLocation() {
		return new Point(0, 0); // FIX ME
	}


	public String getDescription() {
		return ""; // FIX ME
	}


	/**
	 * Compares based on the net energy value of this food item to the player; A
	 * higher net energy means a more urgent priority.
	 */
	@Override
	public int compareTo(Object otherObject) {
		return -1; // FIX ME
	}


	/**
	 * Returns a string representation of the food in the format: 
	 * "[description] at location [x], [y], energy value [energy value]
	 */
	@Override
	public String toString() {
		return ""; // FIX ME
	}


	/**
	 * Calculates the net energy gain/loss to the player of getting this food item.
	 * Net energy = (food energy value) - (distance from food (rounded to the nearest int))
	 * 
	 * @return	the net energy
	 */
	public long getNetEnergy() {
		return -1; // FIX ME
	}
}