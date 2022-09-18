package labs.lab1;

/**
 * A rechargeable battery.
 */
public class Battery {

	private double capacity;
	private double current;
	/**
	 * Create a battery with specified capacity.
	 * 
	 * @param capacity maximum capacity, measured in milliampere hours
	 */
	public Battery(double capacity) {
		this.capacity = capacity;
		this.current = capacity;
	}


	/**
	 * Drain capacity of the battery by given amount.
	 * 
	 * @param amount amount of battery used (assume it will not be > its current capacity
	 */
	public void drain(double amount) {
		this.current -= amount;
	}


	/**
	 * Recharge the battery to maximum capacity.
	 */
	public void charge() {
		this.current = this.capacity;
	}


	/**
	 * Retrieve the battery's current capacity.
	 * 
	 * @return remaining capacity
	 */
	public double getRemainingCapacity() {
		return this.current;
	}
}
