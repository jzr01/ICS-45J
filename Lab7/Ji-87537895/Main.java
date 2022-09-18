package labs.lab7;

public class Main {

	/**
	 * Given a string, compute recursively a new string where all the lowercase 'x'
	 * chars have been moved to the end of the string.
	 * 
	 * @param str the string in which to move the x's
	 * 
	 * @return the string with all the x's moved to the end
	 */
	public static String problem1_moveXToEnd(String str) {
		if (str.equals("")) {return "";}
		else {
			if (str.charAt(0) == 'x')
			{
				return problem1_moveXToEnd(str.substring(1)) + str.charAt(0);
			}else
			{
				return str.charAt(0) + problem1_moveXToEnd(str.substring(1));
			}
		}
	}


	/**
	 * Given a string and a non-empty substring sub, compute recursively the number
	 * of times that sub appears in the string, without the sub-strings overlapping.
	 * 
	 * @param str the string in which to count occurrences of sub
	 * @param sub the substring to count
	 * 
	 * @return the number of times that sub appears in the string, without the sub
	 *         strings overlapping
	 */
	public static int problem2_countSubs(String str, String sub) {
		if (str.equals("")) {return 0;}
		else
		{
			for (int j = 0; j < str.length()-sub.length()+1;j++)
			{
				if (str.substring(j, j + sub.length()).equals(sub))
				{
					return 1 + problem2_countSubs(str.substring(j+sub.length()),sub);
				}
			}
		}
		return 0;
	}



	/**
	 * Given a string, compute recursively the number of times lowercase "hi"
	 * appears in the string, however do not count "hi"s that have an 'x' immedately
	 * before them.
	 * 
	 * @param str the string in which to count occurrences of "hi"
	 * 
	 * @return the number of times lowercase "hi" (without an 'x' immediately before
	 *         it) appears in the string, however do
	 */
	public static int problem3_countHis(String str) {
		if (str.equals("")) {return 0;}
		else {
			for (int j = 0; j < str.length()-2+1;j++)
			{
		
				if (j == 0) {
					if (str.substring(j, j + 2).equals("hi"))
					{
						return 1 + problem3_countHis(str.substring(j+2));
					} 
				}else
				{
					if (str.substring(j, j + 2).equals("hi") && str.charAt(j-1) != 'x')
					{
						return 1 + problem3_countHis(str.substring(j+2));
					} 
				}
			}
		}
			return 0;
	}

}