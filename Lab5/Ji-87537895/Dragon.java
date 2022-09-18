package labs.lab5;

/**
 * A dragon enemy
 *
 */

public class Dragon extends Enemy {

	private boolean fireBreathing;

	/**
	 * Constructs a new Dragon
	 * 
	 * @param fireBreathing whether or not it's fire-breathing
	 */
	public Dragon(boolean fireBreathing) {
		this.fireBreathing = fireBreathing;
	}


	public boolean isFireBreathing() {
		return this.fireBreathing;
	}


	/**
	 * 1) increments the Dragon's health by 25; 2) returns -25 (the number of
	 * strength points deducted for a player attacking this Dragon)
	 * 
	 * @return -25 (the number of strength points deducted for a player attacking
	 *         this Dragon)
	 */
	public int attack() {
		if (this.getHealth() <= 75)
		{
			this.setHealth(this.getHealth()+25);
		}else
		{
			this.setHealth(100);
		}
		return -25;
	}


	/**
	 * 1) toggles fireBreathing from true to false or vice-versa; 2) decrements the
	 * Dragon's health by 10
	 */
	public void advanceTime() {
		this.fireBreathing = ! this.fireBreathing;
		this.setHealth(this.getHealth()-10);
	}

}