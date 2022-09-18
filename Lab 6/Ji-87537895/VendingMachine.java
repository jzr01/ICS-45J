package labs.lab6;

import java.util.ArrayList;
import java.util.List;

/**
 * A vending machine.
 */
public class VendingMachine {

	private List<Product> products; // the products in the machine
	public CoinBox storedCoins; // the coins that have already been used to purchase a product
	public CoinBox currentCoins; // the coins that have been inserted but have not yet been used to purchase a
									// product

	/**
	 * Constructs a VendingMachine object with no products or coins
	 */
	public VendingMachine() {
		products = new ArrayList<Product>();
		storedCoins = new CoinBox();
		currentCoins = new CoinBox();
	}


	/**
	 * Gets the type of products in the vending machine.
	 * 
	 * @return a list of products in this machine
	 */
	public List<Product> getProductTypes() {
		return products;
	}


	/**
	 * Adds a product to the vending machine.
	 * 
	 * @param p        the product to add
	 * @param quantity the quantity
	 */
	public void addProduct(Product p, int quantity) {
		products.add(p);
		p.q = quantity;
	}


	/**
	 * Adds the coin to the vending machine, and returns the total value of coins
	 * that have been inserted but not yet used to buy a product
	 * 
	 * @param c the coin to add
	 * @return the total value of coins that have been inserted but not yet used to
	 *         buy a product
	 */
	public double addCoin(Coin c) {
		currentCoins.addCoin(c);
		return currentCoins.getValue();
	}


	/**
	 * Buys a product from the vending machine, causing all the coins that have been
	 * inserted since the last purchase to be stored in the machine and unavailable
	 * to use for other purchases.
	 * 
	 * @param p the product to buy
	 * @return "OK" if the product was purchased, "Insufficient money" if the
	 *         product exists but there is not enough to purchase the product, or
	 *         "No such product" if the product doesn't exist in the machine
	 */
	public String buyProduct(Product p) {
		if (!this.products.contains(p) || p.q == 0)
		{
			return "No such product";
		}else {
		if (this.currentCoins.getValue() >= p.getPrice())
		{
			storedCoins.addCoins(currentCoins);
			currentCoins.removeAllCoins();
			p.q -= 1;
			return "OK";
		}else
		{
			return "Insufficient money";
		}
		}
	}


	/**
	 * Removes the stored money from the vending machine.
	 * 
	 * @return the amount of money removed
	 */
	public double removeStoredMoney() {
		double a = storedCoins.getValue();
		storedCoins.removeAllCoins();
		return a;
	}

}
