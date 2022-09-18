package labs.lab5;

/**
 * A demogorgon enemy
 *
 */

public class Demogorgon extends Enemy {

	private double weight;

	/**
	 * Constructs a new Demogorgon with the given weight
	 * 
	 * @param weight
	 */
	public Demogorgon(double weight) {
		this.weight = weight;
	}


	public double getWeight() {
		return this.weight;
	}


	/**
	 * 1) decreases the Demogorgon's weight by 10%; 2) decrements the Demogorgon's
	 * health by 15; 3) returns 0 (no strength points awarded or deducted to the
	 * player attacking this Demogorgon)
	 * 
	 * @return 0 (no strength points awarded or deducted to the player attacking
	 *         this Demogorgon)
	 */
	public int attack() {
		this.weight = this.weight*0.9;
		this.setHealth(this.getHealth()-15);
		return 0;
	}


	/**
	 * 1) increases the Demogorgon's weight by 5%; 2) increments the Demogorgon's
	 * health by 10
	 */
	public void advanceTime() {
		this.weight = this.weight*1.05;
		if (this.getHealth() <= 90)
		{
			this.setHealth(this.getHealth()+10);
		}else
		{
			this.setHealth(100);
		}
	}

}