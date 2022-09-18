package labs.lab6;

/**
 * A customer that is represented by a name, amount spent, and type
 */
public class Customer {

	String name;
	double spent;
	CustomerType ct;

	public static enum CustomerType {
		CORPORATE, PERSONAL
	};

	/**
	 * Constructs a bank account with a name, amount spent, and customer type
	 * 
	 * If amountSpent < 0, sets it to 0
	 */
	public Customer(String name, double amountSpent, CustomerType custType) {
		this.name = name;
		if (amountSpent >= 0)
		{
			spent = amountSpent;
		}else
		{
			spent = 0;
		}
		ct = custType;
	}


	/**
	 * Gets the name of the customer.
	 * 
	 * @return the name of the customer
	 */
	public String getName() {
		return this.name;
	}


	/**
	 * Gets the amount spent by the customer.
	 * 
	 * @return the amount spent by the customer
	 */
	public double getAmountSpent() {
		return spent;
	}


	/**
	 * Sets amountSpent to the new amount
	 * 
	 * If amountSpent < 0, sets it to 0
	 * 
	 * @param amountSpent the new amount spent
	 */
	public void setAmountSpent(double amountSpent) {
		if (amountSpent >= 0)
		{
			spent = amountSpent;
		}else
		{
			spent = 0;
		}
	}


	/**
	 * Gets the customer type of the customer.
	 * 
	 * @return the customer type of the customer
	 */
	public CustomerType getCustomerType() {
		return ct;
	}


	/**
	 * Sets customer type to the new type
	 * 
	 * @param custType the new customer type
	 */
	public void setCustomerType(CustomerType custType) {
		ct = custType;
	}


	/**
	 * Returns a string representation of this Customer, consisting of the name,
	 * amount spent, and customer type, each separated by a comma and one space
	 */
	@Override
	public String toString() {
		return this.name+", "+spent+", "+ct;
	}


	/**
	 * Returns true if the name, amount spent, and type are equal to this customer,
	 * false otherwise
	 */
	@Override
	public boolean equals(Object otherObj) {
//		if (this == otherObj)
//		{
//			return true;
//		}
//		if (! (otherObj instanceof Customer))
//		{
//			return false;
//		}
		Customer c = (Customer)otherObj;
		return name.equals(c.name) & spent == c.spent & ct == c.ct;
	}

}
