package labs.lab7;

import java.awt.Point;
import java.util.PriorityQueue;

/**
 * Represents a player in the survival game
 *
 */
public class Player {

	private Point location;
	private int energy;
	private PriorityQueue<Food> foods; // foods in the world

	/**
	 * Constructs a new player with location 0, 0 and energy 100
	 */
	public Player() {
		// FILL IN
	}


	public Point getLocation() {
		return new Point(0, 0); // FIX ME
	}


	public int getEnergy() {
		return -1; // FIX ME
	}


	public void setEnergy(int newEnergy) {
		// FILL IN
	}


	/**
	 * Adds the given food item to this player's priority queue
	 * 
	 * @param f the food item
	 */
	public void addFoodToQueue(Food f) {
		// FILL IN
	}


	/**
	 * Moves player to location of food with highest priority and eats it (removes
	 * it from the queue). Updates player's energy accordingly from the net energy
	 * value of the food.
	 * 
	 * Causes the food queue to be updated (all items removed and re-added), since
	 * their priorities have changed based on the player's changed location
	 * 
	 * @return the food with highest priority
	 */
	public Food getFood() {
		return null; // FIX ME
	}

}