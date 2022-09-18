package labs.lab5;

import java.lang.Math;
/**
 * Represents a box of rocks the player can collect and use for ammo to attack
 * enemies
 *
 */

public class BoxOfRocks extends Ammo {
	private boolean hollow;
	private boolean isCollected;

	/**
	 * Constructs a new BoxOfRocks with: 1) the given weight; 2) the given hollow
	 * status; 3) its status as not collected
	 * 
	 * @param weight weight of this BoxOfRocks
	 * @param hollow whether or not the rocks are hollow
	 */
	public BoxOfRocks(double weight, boolean hollow) {
		super(weight);
		this.hollow = hollow;
		this.isCollected = false;
	}


	/**
	 * Returns whether or not this item has been collected
	 * 
	 * @return whether or not this item has been collected
	 */
	public boolean isCollected() {
		return this.isCollected;
	}


	/**
	 * If this BoxOfRocks is not already collected, sets its status to collected,
	 * and returns the number of rocks in the box.
	 * 
	 * Solid rocks weigh 0.5 pounds. Hollow rocks weigh 0.25 pounds.
	 * 
	 * When calculating the number of rocks in the box, round it to the nearest
	 * integer.
	 * 
	 * If it is already collected, returns 0.
	 * 
	 * @return the number of rocks in the box
	 */
	public int collect() {
		if (this.isCollected)
		{
			return 0;
		}else
		{
			this.isCollected = true;
			if (this.hollow)
			{
				int num = (int) Math.round(this.weight / 0.25);
				return num;
			}else
			{
				int num = (int) Math.round(this.weight / 0.5);
				return num;
			}
		}
	}


	/**
	 * These are magical, disappearing rocks, so decreases the weight of this
	 * BoxOfRocks by 5%, only if it hasn't been collected yet. If it's already been
	 * collected, there is no change.
	 */
	public void advanceTime() {
		if (! this.isCollected())
		{
			this.weight = this.weight * 0.95;
		}
	}


	/**
	 * returns the number of ammo (how many attacks can come from this Ammo)
	 * 
	 * @return the number of ammo (how many attacks can come from this Ammo)
	 */
	public int getNumAmmo() {
		if (this.hollow)
		{
			int num = (int) Math.round(this.weight / 0.25);
			return num;
		}else
		{
			int num = (int) Math.round(this.weight / 0.5);
			return num;
		}
	}

}