package labs.lab5;

/**
 * A clown enemy
 *
 */

public class Clown extends Enemy {

	private boolean weapon;

	/**
	 * Constructs a new Clown with the given weapon status
	 * 
	 * @param weapon status
	 */
	public Clown(boolean weapon) {
		this.weapon = weapon;
	}


	public boolean hasWeapon() {
		return this.weapon;
	}


	/**
	 * If the clown has a weapon: 1) Decreases this Clown's health by 5 2) Returns
	 * -25 (number of strength points deducted from the player attacking this Clown)
	 * 
	 * If the clown doesn't have a weapon: 1) Decreases this Clown's health by 20 2)
	 * Returns 25 (number of strength points awarded to the player attacking this
	 * Clown)
	 * 
	 * @return -25 if the clown has a weapon, 25 otherwise
	 */
	public int attack() {
		if (this.hasWeapon())
		{
			this.setHealth(this.getHealth()-5);
			return -25;
		}else
		{
			this.setHealth(this.getHealth()-20);
			return 25;
		}
	}


	/**
	 * 1) Decrements this Clown's health by 1; 2) Toggles the presence of a weapon
	 */
	public void advanceTime() {
		this.setHealth(this.getHealth()-1);
		this.weapon = ! this.weapon;
	}

}