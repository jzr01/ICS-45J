package labs.lab5;

/**
 * A Bugaboo enemy
 *
 */

public class Bugaboo extends Enemy {

	private double strength;

	/**
	 * Constructs a new Bugaboo with the given strength
	 * 
	 * @param strength
	 */
	public Bugaboo(double strength) {
		this.strength = strength;
	}


	public double getStrength() {
		return strength;
	}


	/**
	 * 1) decreases the Bugaboo's strength by 25%; 2) returns 0 (no strength points
	 * awarded or deducted to the player attacking this Bugaboo)
	 * 
	 * @return 0 (no strength points awarded or deducted to the player attacking
	 *         this Bugaboo)
	 */
	public int attack() {
		strength = 0.75 * strength;
		return 0;
	}


	/**
	 * increases strength by 15%
	 */
	public void advanceTime() {
		strength = 1.15 * strength;
	}

}