package labs.lab6;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class Lab6Test {

	private final double EPSILON = 1e-3;

	@Test
	void problems1And2() throws IOException {
		
		// test sortFile:
		
		// alice.txt:
		String testFileName = "res/alice.txt";
		Files.sortFile(testFileName);
		List<String> linesList = Arrays.asList(
				"'Dinah'll I again. me miss much should talking think!' to-night, very",
				"(Dinah cat.) the was",
				"12 Alice old. was years",
				"Alice Down, There began do, down, down. else nothing so soon to was"
				);
		assertLinesMatch(linesList, java.nio.file.Files.readAllLines(new File(testFileName).toPath()));
		
		// alice2.txt:
		testFileName = "res/alice2.txt";
		Files.sortFile(testFileName);
		linesList = Arrays.asList(
				"'Dinah'll I again. me miss much should talking think!' to-night, very",
				"(Dinah cat.) the was",
				"Alice Down, There began do, down, down. else nothing so soon to was",
				"Alice old. twelve was years"
				);
		assertLinesMatch(linesList, java.nio.file.Files.readAllLines(new File(testFileName).toPath()));
		
		// alice3.txt:
		testFileName = "res/alice3.txt";
		Files.sortFile(testFileName);
		linesList = Arrays.asList(
				"2021. Alice Darkness, END It Light, THE The age age belief, best despair. epoch epoch foolishness, has hope, incredulity, is it it it it it it it it it left long of of of of of of of of of of season season since spring the the the the the the the the the the times, times, was was was was was was was was was was winter wisdom, wonderland. worst year"
				);
		assertLinesMatch(linesList, java.nio.file.Files.readAllLines(new File(testFileName).toPath()));
		
		// alice4.txt:
		testFileName = "res/alice4.txt";
		Files.sortFile(testFileName);
		linesList = Arrays.asList(
				"2021. Alice The has is left long since wonderland. year",
				"Darkness, it of season the was",
				"END THE",
				"It best of the times, was",
				"Light, it of season the was",
				"age foolishness, it of the was",
				"age it of the was wisdom,",
				"belief, epoch it of the was",
				"despair. it of the was winter",
				"epoch incredulity, it of the was",
				"hope, it of spring the was",
				"it of the times, was worst"
				);
		assertLinesMatch(linesList, java.nio.file.Files.readAllLines(new File(testFileName).toPath()));
		
		// babynames.txt:
		testFileName = "res/babynames.txt";
		Files.sortFile(testFileName);
		linesList = Arrays.asList(
				"0.8609 1.2681 10 160312 260365 Joseph Megan",
				"0.8609 1.2771 168977 262218 9 Taylor Tyler",
				"0.8783 1.3235 172383 271734 8 Daniel Elizabeth",
				"0.9720 1.3277 190779 272600 7 Andrew Brittany",
				"0.9726 1.3405 190901 275222 6 Amanda Nicholas",
				"1 1.5436 2.2506 302962 462085 Jessica Michael",
				"1.1408 1.4515 223913 298016 5 Jacob Samantha",
				"1.1413 1.6022 224000 328955 4 Joshua Sarah",
				"1.2082 1.7119 237133 3 351477 Emily Matthew",
				"1.5372 1.7595 2 301702 361250 Ashley Christopher"
				);
		assertLinesMatch(linesList, java.nio.file.Files.readAllLines(new File(testFileName).toPath()));
		
		// blank.txt:
		testFileName = "res/blank.txt";
		Files.sortFile(testFileName);
		linesList = new ArrayList<String>();
		assertLinesMatch(linesList, java.nio.file.Files.readAllLines(new File(testFileName).toPath()));
		
		// numbers.txt:
		testFileName = "res/numbers.txt";
		Files.sortFile(testFileName);
		linesList = Arrays.asList(
				"-0.000",
				"-1998.332",
				"-9283.4534 -998, 198, 8392743,",
				"0",
				"0.00",
				"28937483",
				"897.2"
				);
		assertLinesMatch(linesList, java.nio.file.Files.readAllLines(new File(testFileName).toPath()));
		
		// test exception message is printed out:
		String nonExistentFileName = "res/nothing.txt";
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		Files.sortFile(nonExistentFileName);
		
		String result = output.toString();
		assertEquals("File: " + nonExistentFileName + " not found", result);
		

		// test spellDigits:
		
		// aliceR.txt:
		testFileName = "res/aliceR.txt";
		Files.spellDigits(testFileName);
		linesList = Arrays.asList(
				"",
				"Down, down, down. There was nothing else to do, so Alice soon began",
				"talking again. 'Dinah'll miss me very much to-night, I should think!'",
				"(Dinah was the cat.)",
				"",
				"",
				"Alice was ONETWO years old.",
				"",
				"",
				""
				);
		assertLinesMatch(linesList, java.nio.file.Files.readAllLines(new File(testFileName).toPath()));

		// alice2R.txt:
		testFileName = "res/alice2R.txt";
		Files.spellDigits(testFileName);
		linesList = Arrays.asList(
				"",
				"Down, down, down. There was nothing else to do, so Alice soon began",
				"talking again. 'Dinah'll miss me very much to-night, I should think!'",
				"(Dinah was the cat.)",
				"",
				"",
				"Alice was twelve years old.",
				"",
				"",
				""
				);
		assertLinesMatch(linesList, java.nio.file.Files.readAllLines(new File(testFileName).toPath()));
		
		// alice3R.txt:
		testFileName = "res/alice3R.txt";
		Files.spellDigits(testFileName);
		linesList = Arrays.asList(
				"The year is TWOZEROTWOONE. Alice has long since left wonderland. It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter of despair. THE END"
				);
		assertLinesMatch(linesList, java.nio.file.Files.readAllLines(new File(testFileName).toPath()));
		
		// alice4R.txt:
		testFileName = "res/alice4R.txt";
		Files.spellDigits(testFileName);
		linesList = Arrays.asList(
				"The year is TWOZEROTWOONE. Alice has long since left wonderland.",
				"",
				"It was the best of times, ",
				"it was the worst of times, ",
				"it was the age of wisdom, ",
				"it was the age of foolishness, ",
				"it was the epoch of belief, ",
				"it was the epoch of incredulity, ",
				"it was the season of Light, ",
				"it was the season of Darkness, ",
				"it was the spring of hope, ",
				"it was the winter of despair.",
				"",
				"THE END"
				);
		assertLinesMatch(linesList, java.nio.file.Files.readAllLines(new File(testFileName).toPath()));
		
		// babynamesR.txt:
		testFileName = "res/babynamesR.txt";
		Files.spellDigits(testFileName);
		linesList = Arrays.asList(
				"ONE  Michael  FOURSIXTWOZEROEIGHTFIVE  TWO.TWOFIVEZEROSIX  Jessica  THREEZEROTWONINESIXTWO  ONE.FIVEFOURTHREESIX",
				"TWO  Christopher  THREESIXONETWOFIVEZERO  ONE.SEVENFIVENINEFIVE  Ashley  THREEZEROONESEVENZEROTWO  ONE.FIVETHREESEVENTWO",
				"THREE  Matthew  THREEFIVEONEFOURSEVENSEVEN  ONE.SEVENONEONENINE  Emily  TWOTHREESEVENONETHREETHREE  ONE.TWOZEROEIGHTTWO",
				"FOUR  Joshua  THREETWOEIGHTNINEFIVEFIVE  ONE.SIXZEROTWOTWO  Sarah  TWOTWOFOURZEROZEROZERO  ONE.ONEFOURONETHREE",
				"FIVE  Jacob  TWONINEEIGHTZEROONESIX  ONE.FOURFIVEONEFIVE  Samantha  TWOTWOTHREENINEONETHREE  ONE.ONEFOURZEROEIGHT",
				"SIX  Nicholas  TWOSEVENFIVETWOTWOTWO  ONE.THREEFOURZEROFIVE  Amanda  ONENINEZERONINEZEROONE  ZERO.NINESEVENTWOSIX",
				"SEVEN  Andrew  TWOSEVENTWOSIXZEROZERO  ONE.THREETWOSEVENSEVEN  Brittany  ONENINEZEROSEVENSEVENNINE  ZERO.NINESEVENTWOZERO",
				"EIGHT  Daniel  TWOSEVENONESEVENTHREEFOUR  ONE.THREETWOTHREEFIVE  Elizabeth  ONESEVENTWOTHREEEIGHTTHREE  ZERO.EIGHTSEVENEIGHTTHREE",
				"NINE  Tyler  TWOSIXTWOTWOONEEIGHT  ONE.TWOSEVENSEVENONE  Taylor  ONESIXEIGHTNINESEVENSEVEN  ZERO.EIGHTSIXZERONINE",
				"ONEZERO  Joseph  TWOSIXZEROTHREESIXFIVE  ONE.TWOSIXEIGHTONE  Megan  ONESIXZEROTHREEONETWO  ZERO.EIGHTSIXZERONINE"
				);
		assertLinesMatch(linesList, java.nio.file.Files.readAllLines(new File(testFileName).toPath()));
		
		// blank.txt:
		testFileName = "res/blankR.txt";
		Files.spellDigits(testFileName);
		linesList = new ArrayList<String>();
		assertLinesMatch(linesList, java.nio.file.Files.readAllLines(new File(testFileName).toPath()));
		
		// numbers.txt:
		testFileName = "res/numbersR.txt";
		Files.spellDigits(testFileName);
		linesList = Arrays.asList(
				"-ONENINENINEEIGHT.THREETHREETWO",
				"EIGHTNINESEVEN.TWO",
				"-ZERO.ZEROZEROZERO",
				"ZERO.ZEROZERO",
				"ZERO",
				"TWOEIGHTNINETHREESEVENFOUREIGHTTHREE",
				"EIGHTTHREENINETWOSEVENFOURTHREE, ONENINEEIGHT, -NINENINEEIGHT, -NINETWOEIGHTTHREE.FOURFIVETHREEFOUR"
				);
		assertLinesMatch(linesList, java.nio.file.Files.readAllLines(new File(testFileName).toPath()));
		
		// test exception message is printed out:
		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		Files.spellDigits(nonExistentFileName);
		
		result = output.toString();
		assertEquals("File: " + nonExistentFileName + " not found", result);
	}

	@Test
	void problem3() {

		// success operations:
		BankAccount harrysChecking = new BankAccount(1);
		assertEquals(1, harrysChecking.getBalance());

		harrysChecking.deposit(300);
		assertEquals(301, harrysChecking.getBalance());

		harrysChecking.withdraw(100);
		assertEquals(201, harrysChecking.getBalance());

		// exception operations:

		// depositing negative amount:
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			harrysChecking.deposit(-100);
		});
		String expectedMessage = "Cannot deposit negative amount";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
		assertEquals(201, harrysChecking.getBalance());

		// withdrawing amount greater than balance:
		exception = assertThrows(IllegalArgumentException.class, () -> {
			harrysChecking.withdraw(300);
		});
		expectedMessage = "Cannot withdraw this amount";
		actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
		assertEquals(201, harrysChecking.getBalance());

		// withdrawing negative amount:
		exception = assertThrows(IllegalArgumentException.class, () -> {
			harrysChecking.withdraw(-3);
		});
		expectedMessage = "Cannot withdraw this amount";
		actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
		assertEquals(201, harrysChecking.getBalance());

		// constructing new account with negative initial balance:
		exception = assertThrows(IllegalArgumentException.class, () -> {
			BankAccount a = new BankAccount(-100);
		});
		expectedMessage = "Cannot enter negative initial balance";
		actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}


	@Test
	void problem4() {
		assertEquals("End of day total is properly balanced.",
				BalanceTransactions.balance(0, 55.55, "res/transactions1.txt"));

		assertEquals("End of day total is properly balanced.",
				BalanceTransactions.balance(10.05, 65.60, "res/transactions1.txt"));

		assertEquals("End of day total is not balanced.",
				BalanceTransactions.balance(25, 55.55, "res/transactions1.txt"));

		assertEquals("End of day total is properly balanced.",
				BalanceTransactions.balance(0, 0, "res/transactionsBlank.txt"));

		assertEquals("End of day total is not balanced.",
				BalanceTransactions.balance(0, 55.55, "res/transactionsBlank.txt"));

		assertEquals("End of day total is properly balanced.",
				BalanceTransactions.balance(0, -176.62, "res/transactions2.txt"));

		assertEquals("End of day total is properly balanced.",
				BalanceTransactions.balance(200, 23.38, "res/transactions2.txt"));

		assertEquals("End of day total is not balanced.",
				BalanceTransactions.balance(100, 23.38, "res/transactions2.txt"));

		assertEquals("End of day total is properly balanced.",
				BalanceTransactions.balance(0, 190.79, "res/transactions3.txt"));

		assertEquals("End of day total is properly balanced.",
				BalanceTransactions.balance(10, 200.79, "res/transactions3.txt"));

		assertEquals("End of day total is not balanced.",
				BalanceTransactions.balance(100, 190.79, "res/transactions3.txt"));

		// test exception message is printed out:
		String nonExistentFileName = "doesnotexist.txt";
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		BalanceTransactions.balance(0, 55.55, nonExistentFileName);
		String result = output.toString();
		assertEquals("File: " + nonExistentFileName + " not found", result);
	}


	@Test
	void problem5() {
		
		// customers1.txt:
		CustomerData data = new CustomerData("res/customers1.txt");
		
		List<Customer> expected = Arrays.asList(
				new Customer("DoggySpa", 99.5, Customer.CustomerType.CORPORATE)
				);
		List<Customer> actual = data.getBestCustomer();
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		expected = Arrays.asList(
				new Customer("Robert", 56.67, Customer.CustomerType.PERSONAL)
				);
		actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		

		// customers2.txt:
		data = new CustomerData("res/customers2.txt");
		
		expected = Arrays.asList(
				new Customer("Robert", 99.5, Customer.CustomerType.PERSONAL),
				new Customer("DoggySpa", 99.5, Customer.CustomerType.CORPORATE)
				);
		actual = data.getBestCustomer();
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		expected = Arrays.asList(new Customer("DoggySpa", 99.5, Customer.CustomerType.CORPORATE));
		actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		expected = Arrays.asList(
				new Customer("Robert", 99.5, Customer.CustomerType.PERSONAL)
				);
		actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		
		// customers3.txt:
		data = new CustomerData("res/customers3.txt");
		
		expected = Arrays.asList(
				new Customer("Robert", 99.5, Customer.CustomerType.PERSONAL),
				new Customer("DoggyDayCare", 99.5, Customer.CustomerType.CORPORATE),
				new Customer("DoggySpa", 99.5, Customer.CustomerType.CORPORATE),
				new Customer("Fluffy", 99.5, Customer.CustomerType.PERSONAL)
				);
		actual = data.getBestCustomer();
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		expected = Arrays.asList(
				new Customer("DoggyDayCare", 99.5, Customer.CustomerType.CORPORATE),
				new Customer("DoggySpa", 99.5, Customer.CustomerType.CORPORATE)
				);
		actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		expected = Arrays.asList(
				new Customer("Robert", 99.5, Customer.CustomerType.PERSONAL),
				new Customer("Fluffy", 99.5, Customer.CustomerType.PERSONAL)
				);
		actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));

		
		// customers4.txt:
		data = new CustomerData("res/customers4.txt");
		
		expected = Arrays.asList(
				new Customer("DoggyDayCare", 23.67, Customer.CustomerType.CORPORATE)
				);
		actual = data.getBestCustomer();
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		expected = Arrays.asList(
				new Customer("Robert", 0.0, Customer.CustomerType.PERSONAL),
				new Customer("Fluffy", 0.0, Customer.CustomerType.PERSONAL)
				);
		actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		
		// customers5.txt:
		data = new CustomerData("res/customers5.txt");
		
		expected = Arrays.asList(
				new Customer("Robert", 0.0, Customer.CustomerType.PERSONAL),
				new Customer("DoggyDayCare", 0.0, Customer.CustomerType.CORPORATE),
				new Customer("DoggySpa", 0.0, Customer.CustomerType.CORPORATE),
				new Customer("Fluffy", 0.0, Customer.CustomerType.PERSONAL)
				);
		actual = data.getBestCustomer();
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		expected = Arrays.asList(
				new Customer("DoggyDayCare", 0.0, Customer.CustomerType.CORPORATE),
				new Customer("DoggySpa", 0.0, Customer.CustomerType.CORPORATE)
				);
		actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		expected = Arrays.asList(
				new Customer("Robert", 0.0, Customer.CustomerType.PERSONAL),
				new Customer("Fluffy", 0.0, Customer.CustomerType.PERSONAL)
				);
		actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		
		// customers6.txt:
		data = new CustomerData("res/customers6.txt");
		
		expected = Arrays.asList(
				new Customer("Robert", 99.5, Customer.CustomerType.PERSONAL)
				);
		actual = data.getBestCustomer();
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		expected = Arrays.asList(
				new Customer("Fluffy", 10.95, Customer.CustomerType.CORPORATE)
				);
		actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		expected = Arrays.asList(
				new Customer("Robert", 99.5, Customer.CustomerType.PERSONAL)
				);
		actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		
		// customers7.txt:
		data = new CustomerData("res/customers7.txt");
		
		expected = Arrays.asList(
				new Customer("Dogazon", 101.35, Customer.CustomerType.PERSONAL)
				);
		actual = data.getBestCustomer();
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		expected = Arrays.asList(
				new Customer("Chewy.com", 10.95, Customer.CustomerType.CORPORATE)
				);
		actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		expected = Arrays.asList(
				new Customer("Dogazon", 101.35, Customer.CustomerType.PERSONAL)
				);
		actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		
		// customers8.txt:
		data = new CustomerData("res/customers8.txt");
		
		expected = Arrays.asList(
				new Customer("Dogazon", 101.35, Customer.CustomerType.PERSONAL)
				);
		actual = data.getBestCustomer();
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		expected = Arrays.asList();
		actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		expected = Arrays.asList(
				new Customer("Dogazon", 101.35, Customer.CustomerType.PERSONAL)
				);
		actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		
		// customers9.txt:
		data = new CustomerData("res/customers9.txt");
		
		expected = Arrays.asList(
				new Customer("Dogazon", 101.35, Customer.CustomerType.CORPORATE)
				);
		actual = data.getBestCustomer();
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		expected = Arrays.asList(
				new Customer("Dogazon", 101.35, Customer.CustomerType.CORPORATE)
				);
		actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		expected = Arrays.asList();
		actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		

		// blank.txt:
		data = new CustomerData("res/blank.txt");
		
		actual = data.getBestCustomer();
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		actual = data.getBestCustomer(Customer.CustomerType.CORPORATE);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
		
		actual = data.getBestCustomer(Customer.CustomerType.PERSONAL);
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
	
		
		// test exception message is printed out:
		String nonExistentFileName = "doesnotexist.txt";
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		data = new CustomerData(nonExistentFileName);
		String result = output.toString();
		assertEquals("File: " + nonExistentFileName + " not found", result);

	}

	
	
	@Test
	void problems6Through10() {
		// Product:
		Product candyBar = new Product("Candy bar", 0.55);
		assertEquals("Candy bar", candyBar.getDescription());
		assertEquals(0.55, candyBar.getPrice(), EPSILON);
		assertEquals("Candy bar @ $0.55", candyBar.toString());
		Product soda = new Product("Soda", 0.65);
		assertEquals("Soda", soda.getDescription());
		assertEquals(0.65, soda.getPrice(), EPSILON);
		assertEquals("Soda @ $0.65", soda.toString());
		Product sameCandyBar = new Product("Candy bar", 0.55);
		Product expensiveCandyBar = new Product("Candy bar", 0.95);
		Product capsCandyBar = new Product("CANDY BAR", 0.55);
		assertEquals(sameCandyBar, candyBar);
		assertFalse(candyBar.equals(expensiveCandyBar));
		assertFalse(candyBar.equals(capsCandyBar));
		
		
		// Coin:
		assertEquals(0.25, Coin.QUARTER.getValue(), EPSILON);
		assertEquals("quarter", Coin.QUARTER.getName());
		assertEquals("quarter @ $0.25", Coin.QUARTER.toString());
		
		assertEquals(0.05, Coin.NICKEL.getValue(), EPSILON);
		assertEquals("quarter", Coin.QUARTER.getName());
		assertEquals("quarter @ $0.25", Coin.QUARTER.toString());
		
		Coin quime = new Coin(0.175, "quime");
		assertEquals(0.175, quime.getValue(), EPSILON);
		assertEquals("quime", quime.getName());
		assertEquals("quime @ $0.18", quime.toString());
		
		
		// CoinBox:
		CoinBox box1 = new CoinBox();
		assertEquals(0, box1.getValue(), EPSILON);
		box1.addCoin(Coin.DOLLAR);
		box1.addCoin(Coin.QUARTER);
		box1.addCoin(Coin.NICKEL);
		assertEquals(1.3, box1.getValue(), EPSILON);
		CoinBox box2 = new CoinBox();
		assertEquals(0, box2.getValue(), EPSILON);
		box2.addCoins(box1);
		assertEquals(0, box1.getValue(), EPSILON);
		assertEquals(1.3, box2.getValue(), EPSILON);
		box2.removeAllCoins();
		assertEquals(0, box2.getValue(), EPSILON);
		
		
		// VendingMachine:
		VendingMachine machine = new VendingMachine();
		List<Product> expectedProducts = Arrays.asList();
		List<Product> actualProducts = machine.getProductTypes();
		assertTrue(expectedProducts.size() == actualProducts.size() && expectedProducts.containsAll(actualProducts) &&
				actualProducts.containsAll(expectedProducts));
		machine.addProduct(candyBar, 2);
		machine.addProduct(soda, 5);
		expectedProducts = Arrays.asList(
				candyBar,
				soda
				);
		actualProducts = machine.getProductTypes();
		assertTrue(expectedProducts.size() == actualProducts.size() && expectedProducts.containsAll(actualProducts) &&
				actualProducts.containsAll(expectedProducts));
		assertEquals(0.25, machine.addCoin(Coin.QUARTER), EPSILON);
		assertEquals(0.5, machine.addCoin(Coin.QUARTER), EPSILON);
		assertEquals(0.55, machine.addCoin(Coin.NICKEL), EPSILON);
		assertEquals("OK", machine.buyProduct(candyBar));
		assertEquals(1.0, machine.addCoin(Coin.DOLLAR), EPSILON);
		assertEquals("OK", machine.buyProduct(soda));
		assertEquals(1.55, machine.removeStoredMoney(), EPSILON);
		
		machine = new VendingMachine();
		Product gum = new Product("Gum", 0.45);
		machine.addProduct(gum, 2);
		Product chips = new Product("Chips", 1.0);
		machine.addProduct(chips, 2);
		Product nuts = new Product("Nuts", 1.25);
		machine.addProduct(nuts, 3);
		expectedProducts = Arrays.asList(
				gum,
				chips,
				nuts
				);
		actualProducts = machine.getProductTypes();
		assertTrue(expectedProducts.size() == actualProducts.size() && expectedProducts.containsAll(actualProducts) &&
				actualProducts.containsAll(expectedProducts));
		assertEquals("No such product", machine.buyProduct(candyBar));
		assertEquals("Insufficient money", machine.buyProduct(gum));
		assertEquals(1.0, machine.addCoin(Coin.DOLLAR), EPSILON);
		assertEquals("OK", machine.buyProduct(gum));
		assertEquals("Insufficient money", machine.buyProduct(gum));
		assertEquals(1.0, machine.addCoin(Coin.DOLLAR), EPSILON);
		assertEquals("OK", machine.buyProduct(gum));
		assertEquals(2.0, machine.removeStoredMoney(), EPSILON);
		assertEquals(.10, machine.addCoin(Coin.DIME), EPSILON);
		assertEquals("No such product", machine.buyProduct(gum));
		assertEquals("Insufficient money", machine.buyProduct(chips));
		assertEquals(0.35, machine.addCoin(Coin.QUARTER), EPSILON);
		assertEquals(0.6, machine.addCoin(Coin.QUARTER), EPSILON);
		assertEquals(0.85, machine.addCoin(Coin.QUARTER), EPSILON);
		assertEquals(0.95, machine.addCoin(Coin.DIME), EPSILON);
		assertEquals(1.05, machine.addCoin(Coin.DIME), EPSILON);
		assertEquals("OK", machine.buyProduct(chips));
		assertEquals(1.05, machine.removeStoredMoney(), EPSILON);
	}
}
