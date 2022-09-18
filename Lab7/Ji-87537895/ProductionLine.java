package labs.lab7;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Class for managing the production queue for Robert's business
 */
public class ProductionLine {

	private Queue<Integer> standard;
	private Queue<Integer> rush;

	/**
	 * Constructs a new production line with empty queues
	 */
	public ProductionLine() {
		standard = new LinkedList<Integer>();
		rush = new LinkedList<Integer>();
	}


	/**
	 * Adds an order to the standard queue
	 * 
	 * @param customerID the customer ID
	 */
	public void addStandardOrder(Integer customerID) {
		standard.add(customerID);
	}


	/**
	 * Adds an order to the rush queue
	 * 
	 * @param customerID the customer ID
	 */
	public void addRushOrder(Integer customerID) {
		rush.add(customerID);
	}


	/**
	 * Handles the next order to be produced
	 * 
	 * @return a string that describes the order that was handled, in the format
	 *         "Producing [rush/standard] order for customer [customerID]"
	 */
	public String handleNextOrder() {
		if (rush.size() > 0)
		{
			int a = rush.peek();
			rush.remove();
			return "Producing rush order for customer " + a;
			
		}else
		{
			if (standard.size()>0)
			{
				int a = standard.peek();
				standard.remove();
				return "Producing standard order for customer " + a;
			}
			else
			{
				return "";
			}
		}
	}

}
