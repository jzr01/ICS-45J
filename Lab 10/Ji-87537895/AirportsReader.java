package labs.lab10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * A utility class for reading a CSV-type formatted file of airports
 *
 */
public class AirportsReader {
	
	/**
	 * Reads a CSV-type formatted file of airport data, and returns a list of airports
	 * 
	 * @param filename	the CSV file with the airport data to read
	 * @return	a list of airports from the file
	 */
	public static List<Airport> readAirports(String filename) {
		List<Airport> airports = new ArrayList<>();
		try (Scanner in = new Scanner(new File(filename))) {
			while (in.hasNextLine()) {
				String line = in.nextLine();
				/*
				 * The format of each line is idnumber,"Airport Name","City Name", ... There are
				 * no commas in the the airport or city name fields.
				 */

				Scanner scanner = new Scanner(line);

				scanner.useDelimiter(",");
				int airportID = scanner.nextInt();
//				System.out.println("airportID: " + airportID);
				String name = removeQuotes(scanner.next());
//				System.out.println("name: " + name);
				String city = removeQuotes(scanner.next());
//				System.out.println("city: " + city);
				String country = removeQuotes(scanner.next());
//				System.out.println("country: " + country);
				String iataCode = removeQuotes(scanner.next());
//				System.out.println("iataCode: " + iataCode);
				String icaoCode = removeQuotes(scanner.next());
//				System.out.println("icaoCode: " + icaoCode);
				double latitude = scanner.nextDouble();
//				System.out.println("lat: " + latitude);
				double longitude = scanner.nextDouble();
//				System.out.println("lon: " + longitude);
				Coordinates coordinates = new Coordinates(latitude, longitude);
				double altitude = scanner.nextDouble();
//				System.out.println("altitude: " + altitude);
//				double timeZone = scanner.nextDouble();
////				System.out.println("timeZone: " + timeZone);
//				String dst = removeQuotes(scanner.next());
////				System.out.println("dst: " + dst);
//				String tzDatabaseTime = removeQuotes(scanner.next());
////				System.out.println("tzDatabaseTime: " + tzDatabaseTime);
				
				scanner.close();
				
				airports.add(new Airport(airportID, name, city, country, iataCode, icaoCode, coordinates,
						altitude));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File: " + filename + " not found");
		} 
		return airports;
	}
	
	
	private static String removeQuotes(String str) {
		return str.replaceAll("\"", "");
	}
	
	
//	public static void main(String[] args) {
//		List<Airport> airports = AirportsReader.readAirports("res/airports.dat");
////		System.out.println(airports);
//	}
}
