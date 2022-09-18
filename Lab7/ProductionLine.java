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
		// FILL IN
	}


	/**
	 * Adds an order to the standard queue
	 * 
	 * @param customerID the customer ID
	 */
	public void addStandardOrder(Integer customerID) {
		// FILL IN
	}


	/**
	 * Adds an order to the rush queue
	 * 
	 * @param customerID the customer ID
	 */
	public void addRushOrder(Integer customerID) {
		// FILL IN
	}


	/**
	 * Handles the next order to be produced
	 * 
	 * @return a string that describes the order that was handled, in the format
	 *         "Producing [rush/standard] order for customer [customerID]"
	 */
	public String handleNextOrder() {
		return ""; // FIX ME
	}

}
