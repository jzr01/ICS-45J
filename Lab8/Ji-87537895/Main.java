package labs.lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	/**
	 * Takes a generic list, reverses it and returns it. Note: the method must
	 * modify the original list.
	 * 
	 * @param <T> the type of element in the list
	 * @param a   the list to reverse
	 * 
	 * @return the reversed list
	 */
	// WRITE PROBLEM 3 METHOD HERE
	static <T> List<T> problem3_reverse(List<T> a)
	{
		Collections.reverse(a);
		return a;
	}

	/**
	 * Takes a generic list and returns true if it its elements are in decreasing
	 * order, or false if not. Decreasing order in this case means non-increasing,
	 * so there can be multiple equivalent elements next to each other (e.g., 4, 2,
	 * 2, 0) and it will still be considered decreasing.
	 * 
	 * @param <T> the type of element in the list
	 * @param a   the list to check for decreasing order
	 * 
	 * @return true if decreasing, false if not
	 */
	// WRITE PROBLEM 4 METHOD HERE
	static <T extends Comparable<T>> boolean problem4_isDecreasing(List<T> a)
	{
		boolean b = true;
		for (int i = 0; i < a.size()-1; i++)
		{
			if (a.get(i).compareTo(a.get(i+1)) < 0)
			{
				b = false;
				break;
			}
		}
		return b;
	}

	/**
	 * Given a List<Pair<K, V>> as a parameter, returns a Map<K, V> of the pairs in
	 * the list (Each pair's first element is mapped to its second element)
	 * 
	 * @param <K>  type of the first element in each pair
	 * @param <V>  type of the second element in each pair
	 * @param list the list to make into a map
	 * 
	 * @return a map of the pairs in the list, with each pair's first element mapped
	 *         to its second element
	 */
	// WRITE PROBLEM 5 METHOD HERE
	static <K,V> Map<K,V> problem5_listToMap(List<Pair<K,V>> a)
	{
		Map<K,V> m = new HashMap<K,V>();
		for (Pair<K,V> ele : a)
		{
			m.put(ele.getFirst(),ele.getSecond());
		}
		return m;
	}

}