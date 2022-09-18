package labs.lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Reads all words from a file and adds them to a map 
 * whose keys are the first letters of the words and
 * whose values are sets of words that start with
 * that same letter. 
*/

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class FirstLetterMap {

	private Map<Character, Set<String>> words;

	/**
	 * Constructs a new FirstLetterMap based on the given file. Reads all words from
	 * the file with the given name and adds them to a map whose keys are the first
	 * letters of the words and whose values are sets of words that start with that
	 * same letter.
	 * 
	 * All non-letter characters are ignored. All letters are converted to lower
	 * case for processing.
	 * 
	 * @param fileName name of the file on which to construct the map
	 */
	public FirstLetterMap(String fileName) {
		words = new TreeMap<>();
		try {
			File inputFile = new File(fileName);
			Scanner in = new Scanner(inputFile);
			List<String> word_list = new ArrayList<String>();
			
			while (in.hasNext())
			{
				String s = in.next().toLowerCase();
				s = s.replaceAll("[^a-zA-Z]", "");
				if (!s.equals(""))
					{word_list.add(s);}
			}
			
			for (String str : word_list)
			{
				if (words.containsKey(str.charAt(0)))
				{
					Set s = words.get(str.charAt(0));
					s.add(str);
					words.replace(str.charAt(0), s);
				}else
				{
					Set <String> s = new TreeSet<String>();
					s.add(str);
					words.put(str.charAt(0), s);
				}
				
			}
			in.close();
		}catch(FileNotFoundException e)
		{
			System.out.print("File: "+fileName + " not found");
		}
	}


	/**
	 * Returns a sorted set of all words in the map that start with the given
	 * character
	 * 
	 * @param c the character beginning the words
	 * @return a sorted set of all words in the map that start with the given
	 *         character
	 */
	public Set<String> getWordsThatStartWith(char c) {
		return words.get(c);
	}


	/**
	 * Returns a string representation of the map with the keys and each set of
	 * words sorted in lexicographic order (HINT: call the toString method of the
	 * words map
	 */
	@Override
	public String toString() {
		return words.toString();
	}
}
