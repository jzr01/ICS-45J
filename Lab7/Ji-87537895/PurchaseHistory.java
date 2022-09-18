package labs.lab7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a record of purchases
 *
 */
public class PurchaseHistory {

	ArrayList<Purchase> p_list;

	public PurchaseHistory() {
		p_list = new ArrayList<Purchase>();
	}


	/**
	 * Adds a purchase to the history
	 * 
	 * @param date        date of purchase
	 * @param description description of purchase
	 * @param amount      amount of purchase
	 */
	public void addPurchase(LocalDate date, String description, double amount) {
		p_list.add(new Purchase(date,description,amount));
	}


	/**
	 * Removes all purchases matching the given parameters from the history
	 * 
	 * @param date        date of purchase
	 * @param description description of purchase
	 * @param amount      amount of purchase
	 * 
	 * @return the number of purchases matching the parameters and therefore removed
	 */
	public int removePurchase(LocalDate date, String description, double amount) {
		int i = 0;
		List<Purchase> p1_list = new ArrayList<Purchase>(p_list);
		Purchase p1 = new Purchase(date,description,amount);
		for (Purchase p: p1_list)
		{
			if (p.compareTo(p1)==0)
			{
				p_list.remove(p);
				i = i + 1;
			}
		}
		return i;
	}


	/**
	 * Gets a list of all purchases that fall within a date range
	 * 
	 * @param start start of the date range (inclusive)
	 * @param end   end of the date range (inclusive)
	 * 
	 * @return a list of purchases in the date range, in sorted order
	 */
	public List<Purchase> getPurchasesInDateRange(LocalDate start, LocalDate end) {
		List<Purchase> p1_list = new ArrayList<Purchase>();
		for (Purchase p: p_list) {
			if (p.getDate().compareTo(end) <= 0 & p.getDate().compareTo(start) >= 0)
			{
				p1_list.add(p);
			}
		}
		Collections.sort(p1_list);
		return p1_list;
	}


	/**
	 * Gets the total of all purchases that fall within a date range
	 * 
	 * @param start start of the date range (inclusive)
	 * @param end   end of the date range (inclusive)
	 * 
	 * @return the total of purchases in the date range
	 */
	public double getPurchaseTotalInDateRange(LocalDate start, LocalDate end) {
		double t = 0;
		for (Purchase p:p_list)
			if (p.getDate().compareTo(end) <= 0 & p.getDate().compareTo(start) >= 0)
			{
				t += p.getAmount();
			}
		return t;
	}


	/**
	 * Gets a list of all purchases that match a description
	 * 
	 * @param description the description to match
	 * 
	 * @return a list of purchases matching the description, in sorted order
	 */
	public List<Purchase> getPurchasesMatchingDescription(String description) {
		List<Purchase> p1_list = new ArrayList<Purchase>();
		for (Purchase p:p_list)
			if (p.getDescription().equals(description))
			{
				p1_list.add(p);
			}
		Collections.sort(p1_list);
		return p1_list;
	}


	/**
	 * Gets the total of all purchases that match a description
	 * 
	 * @param description the description to match
	 * 
	 * @return the total of purchases that match the description
	 */
	public double getPurchaseTotalMatchingDescription(String description) {
		double t = 0;
		for (Purchase p:p_list)
			if (p.getDescription().equals(description))
			{
				t += p.getAmount();
			}
		return t;
	}


	/**
	 * Gets a list of all purchases that fall within an amount range
	 * 
	 * @param min lower bound of the amount range (inclusive)
	 * @param max upper bound of the amount range (inclusive)
	 * 
	 * @return a list of purchases in the amount range, in sorted order
	 */
	public List<Purchase> getPurchasesInAmountRange(double min, double max) {
		List<Purchase> p1_list = new ArrayList<Purchase>();
		for (Purchase p:p_list)
			if (p.getAmount() <= max & p.getAmount() >= min)
			{
				p1_list.add(p);
			}
		Collections.sort(p1_list);
		return p1_list;
	}


	/**
	 * Gets the total of all purchases that fall within an amount range
	 * 
	 * @param min lower bound of the amount range (inclusive)
	 * @param max upper bound of the amount range (inclusive)
	 * 
	 * @return the total of purchases in the amount range
	 */
	public double getPurchaseTotalInAmountRange(double min, double max) {
		double t = 0;
		for (Purchase p:p_list)
			if (p.getAmount() <= max & p.getAmount() >= min)
			{
				t += p.getAmount();
			}
		return t;
	}


	/**
	 * Gets the most expensive purchase(s) made within a date range.
	 * 
	 * @param start start of the date range (inclusive)
	 * @param end   end of the date range (inclusive)
	 * 
	 * @return a sorted list of the most expensive purchase(s) made within the date
	 *         range
	 */
	public List<Purchase> getMaxPurchaseInDateRange(LocalDate start, LocalDate end) {
		List<Double> d_list = new ArrayList<Double>();
		List<Purchase> p1_list = new ArrayList<Purchase>(); 
		for (Purchase p : p_list)
		{
			if (p.getDate().compareTo(end) <= 0 & p.getDate().compareTo(start) >= 0)
				{d_list.add(p.getAmount());}
		}
		if (d_list.isEmpty())
			return p1_list;
		else {
		double max = Collections.max(d_list);
		
		for (Purchase p: p_list)
		{
			if (p.getDate().compareTo(end) <= 0 & p.getDate().compareTo(start) >= 0)
				
				{
					if (Double.compare(p.getAmount(),max) == 0)
					{
						p1_list.add(p);
					}
				}
		}
		
		Collections.sort(p1_list);
		return p1_list;
		}
	}


	/**
	 * Gets the least expensive purchase(s) made within a date range.
	 * 
	 * @param start start of the date range (inclusive)
	 * @param end   end of the date range (inclusive)
	 * 
	 * @return a sorted list of the least expensive purchase(s) made within the date
	 *         range
	 */
	public List<Purchase> getMinPurchaseInDateRange(LocalDate start, LocalDate end) {
		List<Double> d_list = new ArrayList<Double>();
		List<Purchase> p1_list = new ArrayList<Purchase>(); 
		for (Purchase p : p_list)
		{
			if (p.getDate().compareTo(end) <= 0 & p.getDate().compareTo(start) >= 0)
				{d_list.add(p.getAmount());}
		}
		if (d_list.isEmpty())
			return p1_list;
		else {
		double min = Collections.min(d_list);
		
		for (Purchase p: p_list)
		{
			if (p.getDate().compareTo(end) <= 0 & p.getDate().compareTo(start) >= 0)
				
				{
					if (Double.compare(p.getAmount(),min) == 0)
					{
						p1_list.add(p);
					}
				}
		}
		
		Collections.sort(p1_list);
		return p1_list;
		}
		
	}


	/**
	 * Returns a string representing all the purchases in the history, sorted, with
	 * a comma and space between each one
	 */
	@Override
	public String toString() {
		String s = "";
		Collections.sort(p_list);
		for (Purchase p : p_list)
		{
			s += p.toString()+", ";
		}
		s = s.substring(0,s.length()-2);
		return s;
	}

}
