package labs.lab5;

/**
 * Represents an item the player can pick up that benefits them in some way
 *
 */
public abstract class PowerUp implements Collectable {

	int initialPointValue;

	/**
	 * Constructs a new PowerUp with the given initial pointValue
	 * 
	 * @param initialPointValue
	 */
	public PowerUp(int initialPointValue) {
		this.initialPointValue = initialPointValue;
	}


	public int getInitialPointValue() {
		return this.initialPointValue;
	}

}