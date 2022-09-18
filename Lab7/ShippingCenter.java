package labs.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Class for simulating a shipping center using stacks of products with
 * descriptions as representation.
 */
public class ShippingCenter {

	private Stack<String> shippingStack; // products ready to be shipped
	private Stack<String> temporaryStack; // products placed on a temporary stack while shuffling around products ready
											// to be shipped

	/**
	 * Constructs a new shipping center with empty stacks
	 */
	public ShippingCenter() {
		// FILL IN
	}


	/**
	 * Returns a string containing the contents of the storage stack, each item
	 * separated by a comma and space
	 * 
	 * @return a string containing the contents of the storage stack, each item
	 *         separated by a comma and space
	 */
	public String getShippingStack() {
		return ""; // FIX ME
	}


	/**
	 * Returns a string containing the contents of the temporary stack, each item
	 * separated by a comma and space
	 * 
	 * @return a string containing the contents of the temporary stack, each item
	 *         separated by a comma and space
	 */
	public String getTemporaryStack() {
		return ""; // FIX ME
	}


	/**
	 * Add the given product to the shipping stack. Returns a log of the process.
	 * 
	 * @param product description of product
	 * @return a log of the process
	 */
	public List<String> add(String product) {
		return new ArrayList<String>(); // FIX ME
	}


	/**
	 * Ships the given product (removes it from the shipping stack if it's on the
	 * shipping stack). Returns a log of the process
	 * 
	 * @param product description of product
	 * @return a log of the process (see example and test file for format)
	 */
	public List<String> ship(String product) {
		return new ArrayList<String>(); // FIX ME
	}
}
