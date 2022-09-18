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
		shippingStack = new Stack<String>();
		temporaryStack = new Stack<String>();
	}


	/**
	 * Returns a string containing the contents of the storage stack, each item
	 * separated by a comma and space
	 * 
	 * @return a string containing the contents of the storage stack, each item
	 *         separated by a comma and space
	 */
	public String getShippingStack() {
		String s = "";
		if (!shippingStack.isEmpty())
		{
			for (String a : shippingStack)
			{
				s += a + ", ";
			}
			return s.substring(0,s.length()-2);
		}
		return s;
	}


	/**
	 * Returns a string containing the contents of the temporary stack, each item
	 * separated by a comma and space
	 * 
	 * @return a string containing the contents of the temporary stack, each item
	 *         separated by a comma and space
	 */
	public String getTemporaryStack() {
		String s = "";
		if (!temporaryStack.isEmpty())
		{
			for (String a : temporaryStack)
			{
				s += a + ", ";
			}
			return s.substring(0,s.length()-2);
		}
		return s;
	}


	/**
	 * Add the given product to the shipping stack. Returns a log of the process.
	 * 
	 * @param product description of product
	 * @return a log of the process
	 */
	public List<String> add(String product) {
		List<String> list = new ArrayList<String>();
		if (!shippingStack.contains(product))
		{
			shippingStack.push(product);
			list.add("Shipping stack: "+this.getShippingStack());
			list.add("Temporary stack: "+this.getTemporaryStack());
		}else
		{
			list.add("That product is already on the shipping stack.");
		}
		return list;
	}


	/**
	 * Ships the given product (removes it from the shipping stack if it's on the
	 * shipping stack). Returns a log of the process
	 * 
	 * @param product description of product
	 * @return a log of the process (see example and test file for format)
	 */
	public List<String> ship(String product) {
		List<String> list = new ArrayList<String>();
		if (shippingStack.contains(product))
		{
			while (!shippingStack.peek().equals(product))
			{
				String s = shippingStack.peek();
				shippingStack.pop();
				temporaryStack.push(s);
				list.add("Shipping stack: "+this.getShippingStack());
				list.add("Temporary stack: "+this.getTemporaryStack());
			}
			
			shippingStack.pop();
			
			if (temporaryStack.isEmpty())
			{
				list.add("Shipping stack: "+this.getShippingStack());
				list.add("Temporary stack: "+this.getTemporaryStack());
			}
			else
			{
			while (true)
			{
				if (!temporaryStack.isEmpty())
				{
					String s1 = temporaryStack.peek();
					temporaryStack.pop();
					shippingStack.push(s1);
					list.add("Shipping stack: "+this.getShippingStack());
					list.add("Temporary stack: "+this.getTemporaryStack());
				}else
				{
					break;
				}
			}
			}
			
		}
		else
		{
			list.add("That product is not on the shipping stack.");
		}
		return list;
	}
}
