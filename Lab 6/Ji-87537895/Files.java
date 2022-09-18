package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Files {

	/**
	 * Sorts the words in each line of a file lexicographically, then sorts the
	 * lines lexicographically, and writes the result back to the original file with
	 * a space between each word and no space between each line. Ignores blank lines
	 * and does not write them to the revised file.
	 * 
	 * @param fileName name of the input file
	 */
	public static void sortFile(String fileName) {
		try {
			File inputFile = new File(fileName);
			Scanner in = new Scanner(inputFile);
			ArrayList<String> line_list = new ArrayList<String>();
 			while (in.hasNext())
			{
				String Line = in.nextLine();
				if (!Line.isEmpty()) {
					String[] str_list = Line.trim().split("\\s+");
					for (int i = 0; i < str_list.length; i++) {
			            for (int j = i + 1; j < str_list.length; j++) {
			                if (str_list[i].compareTo(str_list[j])
			                    > 0) {
			                    String temp = str_list[i];
			                    str_list[i] = str_list[j];
			                    str_list[j] = temp;
			                }
			            }
			        }
					String str = "";
					for (int i = 0 ; i < str_list.length; i++) {
						str += str_list[i]+" ";
					}
					str = str.substring(0,str.length()-1);
					line_list.add(str);
					
				}
			}
 			
	 			for (int i = 0; i < line_list.size(); i++) {
		            for (int j = i + 1; j < line_list.size(); j++) {
		                if ((line_list.get(i)).compareTo(line_list.get(j))
		                    > 0) {
		                    String temp = line_list.get(i);
		                    line_list.set(i,line_list.get(j));
		                    line_list.set(j,temp);
		                }
		            }
		        }
	 			PrintWriter out = new PrintWriter(fileName);
	 			for (int i = 0; i < line_list.size(); i++)
	 			{
	 				out.println(line_list.get(i));
	 			}
 			in.close();
 			out.close();
		}catch(FileNotFoundException e)
		{
			System.out.print("File: "+fileName + " not found");
		}
	}


	/**
	 * Replaces each occurrence of a digit (0-9) in a file with the word (in all
	 * caps) that spells out that digit, e.g., ZERO, ONE, TWO, etc.
	 * 
	 * @param fileName name of the input file
	 */
	public static void spellDigits(String fileName)
	{
		final String[] info_list = {"ZERO","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};
		Pattern pat = Pattern.compile(".*\\R|.+\\z");
		
		try {
        	File inputFile = new File(fileName);
			Scanner in = new Scanner(inputFile);
			ArrayList<String> line_list = new ArrayList<String>();
			String Line;
			
			while ((Line = in.findWithinHorizon(pat, 0)) != null)
			{
				boolean Y = false;
				
				for (int i = 0; i < Line.length();i++)
				{
					if (Character.isDigit(Line.charAt(i)))
					{
						Y = true;
						break;
					}
				}
				
				if (Y)
				{		
					String str_new = "";
					for (int i = 0; i < Line.length(); i++)
					{
			            if (Character.isDigit(Line.charAt(i)))
			            {
			            	str_new += info_list[Character.getNumericValue(Line.charAt(i))];
			            }else
			            {
			            	str_new += Line.charAt(i);
			            }
					}
					line_list.add(str_new);	
				}
				else
				{
					line_list.add(Line);
	
				}
			}
			
			PrintWriter out = new PrintWriter(fileName);
			
			for (int i = 0; i < line_list.size();i++)
			{
				out.print(line_list.get(i));
		    }
			
			in.close();
			out.close();
			
        }
		catch(FileNotFoundException e)
		{
			System.out.print("File: "+fileName + " not found");
		}
	}


	private static boolean isNumeric(String string) {
		 if (string == null) {
		        return false;
		    }
		    try {
		        double d = Double.parseDouble(string);
		    } catch (NumberFormatException nfe) {
		        return false;
		    }
		    return true;
		}
	}


