package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import labs.lab6.Customer.CustomerType;

/**
 * Contains data and does some analysis about all customers in a store
 */
public class CustomerData {

	String name;
	ArrayList<Customer> info_list;
	ArrayList<Double> spent_list;
	

	/**
	 * Constructs a new CustomerData object from the data in the file
	 * 
	 * If a file contains more than one customer with the same name, the data from
	 * the last one read overwrites the previously read data.
	 */
	public CustomerData(String fileName) {
		name = fileName;
		try {
			Scanner in = new Scanner(new File(name));
			ArrayList<Customer> info_list1 = new ArrayList<Customer>();
			ArrayList<Double> spent_list1 = new ArrayList<Double>();
			while (in.hasNext())
			{
				String Line = in.nextLine();
				if (!Line.isEmpty()) 
				{
					String[] str_list = Line.trim().split("\\s+");
					Customer c = new Customer(str_list[0],Double.parseDouble(str_list[1]), CustomerType.valueOf(str_list[2]));
					info_list1.add(c);
					spent_list1.add(c.getAmountSpent());
				}
			}
			info_list = info_list1;
			spent_list = spent_list1;
			in.close();
	}catch (FileNotFoundException e)
		{
		System.out.print("File: "+name+" not found");
		}
		
	}


	/**
	 * Gets the customer(s) with the highest amount spent.
	 * 
	 * @return a list containing the customer(s) with the highest amount spent. If
	 *         there is only 1 customer with the highest amount, the list contains
	 *         only that one customer. If there are > 1 customer with the highest
	 *         amount, the list contains them all, in an undetermined order.
	 */
	public List<Customer> getBestCustomer() {
		List<Customer> final_list = new ArrayList<Customer>();	
		for (Customer c : this.info_list)
			{
				if (c.getAmountSpent() == Collections.max(this.spent_list))
				{
					final_list.add(c);
				}
			}
			return final_list;
	}


	/**
	 * Gets the customer(s) of the given customer type with the highest amount
	 * spent.
	 * 
	 * @return a list containing the customer(s) of the given type with the highest
	 *         amount spent. If there is only 1 customer with the highest amount,
	 *         the list contains only that one customer. If there are > 1 customer
	 *         with the highest amount, the list contains them all, in an
	 *         undetermined order.
	 */
	public List<Customer> getBestCustomer(Customer.CustomerType custType) {
		List<Customer> final_list = new ArrayList<Customer>();	
		ArrayList<Double> spend_list1 = new ArrayList<Double>();
		for (Customer c : info_list)
		{
			if (c.getCustomerType() ==custType )
			{
				spend_list1.add(c.getAmountSpent());
			}
		}
		
		for (Customer c : info_list)
		{
			if (!spend_list1.isEmpty())
			{
				if (c.getAmountSpent() == Collections.max(spend_list1) && c.getCustomerType() == custType)
				{
					final_list.add(c);
				}
			}
		}
		return final_list;
	}
}