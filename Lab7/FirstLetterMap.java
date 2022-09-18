package labs.lab7;

/**
 * Reads all words from a file and adds them to a map 
 * whose keys are the first letters of the words and
 * whose values are sets of words that start with
 * that same letter. 
*/

import java.util.Map;
import java.util.Set;
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
		// FILL IN
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
		return new TreeSet<String>(); // FIX ME
	}


	/**
	 * Returns a string representation of the map with the keys and each set of
	 * words sorted in lexicographic order (HINT: call the toString method of the
	 * words map
	 */
	@Override
	public String toString() {
		return ""; // FIX ME
	}
}
