package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;

/**
 * A utility class for validating the cash on hand amount at the end of the day with the 
 * amount recorded in a file
 */

public class BalanceTransactions {

	/**
	 * Given a starting balance (amount of cash at the beginning of the day) and an
	 * ending balance (amount of cash at the end of the day), checks whether the
	 * actual amount of cash at the end of the day equals the expected value (within
	 * an 1E-3 error margin)
	 * 
	 * @param startBalance amount of cash at the beginning of the day; assume always
	 *                     >= 0
	 * @param endBalance   amount of cash at the end of the day
	 * @param filename     name of file containing transactions
	 * 
	 * @return a string indicating whether the end of day total was balanced or not
	 *         (either "End of day total is properly balanced." or "End of day total
	 *         is not balanced."
	 */
	public static String balance(double startBalance, double endBalance, String filename) {
		try
		{
			double i1 = startBalance;
			File input = new File(filename);
			Scanner in = new Scanner(input);
			while (in.hasNext())
			{
				String Line = in.nextLine();
				if (!Line.isEmpty()) 
				{
					String[] str_list = Line.trim().split("\\s+");
					if (str_list[2].equals("P"))
					{
						i1 -= Double.parseDouble(str_list[1]);
					}else
					{
						i1 += Double.parseDouble(str_list[1]);
					}
				}
			}
			if (Math.abs(i1 - endBalance) < 0.01)
			{
				return "End of day total is properly balanced.";
			}else
			{
				return "End of day total is not balanced.";
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.print("File: "+filename+ " not found");
		}
		return "";
	}
}
