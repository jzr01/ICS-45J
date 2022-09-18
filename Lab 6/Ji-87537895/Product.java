package labs.lab6;

/**
 * A product in a vending machine.
 */
public class Product {

	String d;
	double p;
	int q = 0;

	/**
	 * Constructs a Product object
	 * 
	 * @param aDescription the description of the product
	 * @param aPrice       the price of the product
	 */
	public Product(String aDescription, double aPrice) {
		d = aDescription;
		p  = aPrice;
	}


	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return d;
	}


	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	public double getPrice() {
		return p;
	}


	/**
	 * Determines of this product is the same as the other product.
	 * 
	 * @param other the other product
	 * @return true if the products have the same description and price, false otherwise
	 */
	@Override
	public boolean equals(Object other) {
		Product p1 = (Product)other;
		return d.equals(p1.d) && p == p1.p; 
	}


	/**
	 * Returns a string representation of the product consisting of the description,
	 * " @ $", and the prices, formatted with two decimal places after the decimal
	 * point
	 */
	@Override
	public String toString() {
		return d+" @ $"+String.format("%.2f",p);
	}

}
