package labs.lab7;

import java.time.LocalDate;

/**
 * Represents a purchase
 *
 */
public class Purchase implements Comparable<Purchase> {

	LocalDate d;
	String des;
	double a;

	/**
	 * Constructs a new Purchase
	 * 
	 * @param date        the date of the purchase
	 * @param description a description of the purchase
	 * @param amount      the amount of the purchase (if < 0, sets it to 0)
	 */
	public Purchase(LocalDate date, String description, double amount) {
		this.d = date;
		des = description;
		a = amount;
	}


	public LocalDate getDate() {
		return d;
	}


	public String getDescription() {
		return des;
	}


	public double getAmount() {
		return a;
	}


	/**
	 * Returns a string representing this purchase, consisting of the date,
	 * description, and amount, each separated by a single space
	 */
	@Override
	public String toString() {
		return d.toString()+" "+ des + " " + a;
	}


	/**
	 * Returns true if the date, description, and amount all match
	 */
	@Override
	public boolean equals(Object o) {
		Purchase p = (Purchase) o;
		boolean a1 = (p.getDescription()).equals(des) ;
		boolean b1 = Double.compare(p.getAmount(), a) == 0; 
		boolean c1 = (p.getDate()).compareTo(d) == 0;
		return a1 & b1 & c1;
	}


	/**
	 * Compares first by date (earlier dates first), then by amount (higher amounts
	 * first), then by description (lexicographically)
	 */
	public int compareTo(Purchase other) {
		if (d.compareTo(other.d) != 0)
		{
			return d.compareTo(other.d);
		}
		else
		{
			if (a  != other.a)
			{
				if (a > other.a)
				{
					return -1;
				}else
				{
					return 1;
				}
			}
			else
			{
				if (des.compareTo(other.des)!= 0)
				{
					return des.compareTo(other.des);
				}else
				{
					return 0;
				}
					
			}
		}
			
	}

}