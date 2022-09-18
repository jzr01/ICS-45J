package labs.lab7;

import java.awt.Point;

/**
 * Class representing a food item in the survival game
 */
public class Food implements Comparable {

	Point l;
	Player p;
	String des;
	int e;

	/**
	 * Constructs a new food item
	 * 
	 * @param location    location of the food item
	 * @param player      player in the game
	 * @param description description of the food item
	 * @param energyValue energy value of the food item
	 */
	public Food(Point location, Player player, String description, int energyValue) {
		l = location;
		p = player;
		des = description;
		e = energyValue;
	}


	public Point getLocation() {
		return l;
	}


	public String getDescription() {
		return des;
	}


	/**
	 * Compares based on the net energy value of this food item to the player; A
	 * higher net energy means a more urgent priority.
	 */
	@Override
	public int compareTo(Object otherObject) {
		Food f = (Food) otherObject;
		return (int) -(this.getNetEnergy() - f.getNetEnergy());
	}


	/**
	 * Returns a string representation of the food in the format: 
	 * "[description] at location [x], [y], energy value [energy value]
	 */
	@Override
	public String toString() {
		return des + " at location " + (int) l.getX() + ", "+(int) l.getY()+","+ " energy value " + e;
	}


	/**
	 * Calculates the net energy gain/loss to the player of getting this food item.
	 * Net energy = (food energy value) - (distance from food (rounded to the nearest int))
	 * 
	 * @return	the net energy
	 */
	public long getNetEnergy() {
		int dis = (int) Math.sqrt((p.getLocation().getX() - l.getX())*(p.getLocation().getX() - l.getX()) + (p.getLocation().getY() - l.getY())*(p.getLocation().getY() - l.getY()));
		return e - dis;
	}
}