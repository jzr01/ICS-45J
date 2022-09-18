package labs.lab5;

/**
 * Formats integers in accounting format
 * 
 */
public class AccountingFormatter implements NumberFormatter {

	/**
	 * Formats integer with a dollar sign, and negative numbers with parentheses,
	 * for example, -1 as $(1), and 1 as $1
	 * 
	 * @param n the number to format
	 */
	public String format(int n) {
		if (n < 0)
		{
			return "$" + "(" + Integer.toString(-n) + ")" ;
		}else 
		{
			return "$" +  Integer.toString(n); 
		}
	}

}
