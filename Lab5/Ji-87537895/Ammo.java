package labs.lab5;

/**
 * Represents ammo that the player can pick up and use to attack enemies
 *
 */

public abstract class Ammo implements Collectable {

	double weight;

	/**
	 * constructs a new Ammo with the given weight
	 * 
	 * @param weight weight of ammo (in pounds)
	 */
	public Ammo(double weight) {
		this.weight = weight;
	}


	public double getWeight() {
		return this.weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	/**
	 * returns the number of ammo (how many attacks can come from this Ammo)
	 * 
	 * @return the number of ammo (how many attacks can come from this Ammo)
	 */
	public abstract int getNumAmmo();

}