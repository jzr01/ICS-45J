package labs.lab6;

/**
 * A box of coins.
 */
public class CoinBox {

	int n;
	int d;
	int q;
	int d1;

	/**
	 * Constructs an empty CoinBox object.
	 */
	public CoinBox() {
		n = 0;
		d = 0;
		q = 0;
		d1 = 0;
		
	}


	/**
	 * Adds a coin.
	 * 
	 * @param c the coin to add
	 */
	public void addCoin(Coin c) {
		if (c.getName().equals("nickel"))
		{
			n += 1;
		}else if (c.getName().equals("dime"))
		{
			d += 1;
		}
		else if (c.getName().equals("quarter"))
		{
			q += 1;
		}else if (c.getName().equals("dollar"))
		{
			d1 += 1;
		}
	}


	/**
	 * Removes coins from another coinbox and adds them to this one. 
	 * 
	 * @param other the box of coins from which to add
	 */
	public void addCoins(CoinBox other) {
		q += other.q;
		d += other.d;
		n += other.n;
		d1 += other.d1;
		other.removeAllCoins();
		
	}


	/**
	 * Gets the value of all the coins.
	 * 
	 * @return total the total value of all the coins
	 */
	public double getValue() {
		return 1* d1+0.1*d+0.25*q + 0.05*n;
	}


	/**
	 * Removes all the coins.
	 */
	public void removeAllCoins() {
		d = 0;
		d1 = 0;
		n = 0;
		q = 0;
	}

}