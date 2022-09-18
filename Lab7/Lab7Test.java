package labs.lab7;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

class Lab7Test {

	private final double EPSILON = 1e-3;

	@Test
	void problem1() {
		assertEquals("rexx", Main.problem1_moveXToEnd("xxre"));
		assertEquals("hixxxx", Main.problem1_moveXToEnd("xxhixx"));
		assertEquals("hihixxx", Main.problem1_moveXToEnd("xhixhix"));
		assertEquals("hiy", Main.problem1_moveXToEnd("hiy"));
		assertEquals("h", Main.problem1_moveXToEnd("h"));
		assertEquals("x", Main.problem1_moveXToEnd("x"));
		assertEquals("xx", Main.problem1_moveXToEnd("xx"));
		assertEquals("", Main.problem1_moveXToEnd(""));
		assertEquals("bxx", Main.problem1_moveXToEnd("bxx"));
		assertEquals("baxx", Main.problem1_moveXToEnd("bxax"));
		assertEquals("aaaxxx", Main.problem1_moveXToEnd("axaxax"));
		assertEquals("hixxx", Main.problem1_moveXToEnd("xxhxi"));
		assertEquals("XXhix", Main.problem1_moveXToEnd("XXhxi"));
		assertEquals("XXhXi", Main.problem1_moveXToEnd("XXhXi"));
	}


	@Test
	void problem2() {
		assertEquals(2, Main.problem2_countSubs("catcowcat", "cat"));
		assertEquals(1, Main.problem2_countSubs("catcowcat", "cow"));
		assertEquals(0, Main.problem2_countSubs("catcowcat", "dog"));
		assertEquals(2, Main.problem2_countSubs("cacatcowcat", "cat"));
		assertEquals(2, Main.problem2_countSubs("xyx", "x"));
		assertEquals(4, Main.problem2_countSubs("iiiijj", "i"));
		assertEquals(2, Main.problem2_countSubs("iiiijj", "ii"));
		assertEquals(2, Main.problem2_countSubs("iiiiijj", "ii"));
		assertEquals(1, Main.problem2_countSubs("iiiijj", "iii"));
		assertEquals(2, Main.problem2_countSubs("iiiijj", "j"));
		assertEquals(1, Main.problem2_countSubs("iiiijj", "jj"));
		assertEquals(4, Main.problem2_countSubs("aaabababab", "ab"));
		assertEquals(1, Main.problem2_countSubs("aaabababab", "aa"));
		assertEquals(6, Main.problem2_countSubs("aaabababab", "a"));
		assertEquals(4, Main.problem2_countSubs("aaabababab", "b"));
		assertEquals(0, Main.problem2_countSubs("aaabababab", "aaababababaaabababab"));
		assertEquals(0, Main.problem2_countSubs("", "b"));
	}


	@Test
	void problem3() {
		assertEquals(1, Main.problem3_countHis("ahixhi"));
		assertEquals(2, Main.problem3_countHis("ahibhi"));
		assertEquals(0, Main.problem3_countHis("xhixhi"));
		assertEquals(1, Main.problem3_countHis("hixhi"));
		assertEquals(2, Main.problem3_countHis("hixhhi"));
		assertEquals(3, Main.problem3_countHis("hihihi"));
		assertEquals(3, Main.problem3_countHis("hihihix"));
		assertEquals(2, Main.problem3_countHis("xhihihix"));
		assertEquals(0, Main.problem3_countHis("xxhi"));
		assertEquals(1, Main.problem3_countHis("hixxhi"));
		assertEquals(1, Main.problem3_countHis("hi"));
		assertEquals(0, Main.problem3_countHis("xxxx"));
		assertEquals(0, Main.problem3_countHis("h"));
		assertEquals(0, Main.problem3_countHis("x"));
		assertEquals(0, Main.problem3_countHis(""));
		assertEquals(1, Main.problem3_countHis("Hellohi"));
	}


	@Test
	void problems4Through5() {
		PurchaseHistory history = new PurchaseHistory();
		history.addPurchase(LocalDate.of(2021, 12, 19), "Christmas pillow for Robert", 10.00);
		history.addPurchase(LocalDate.of(2021, 12, 19), "Christmas jammies for Robert", 19.99);
		history.addPurchase(LocalDate.of(2021, 12, 31), "Champagne", 18.50);
		history.addPurchase(LocalDate.of(2022, 1, 2), "Takeout food", 57.89);
		history.addPurchase(LocalDate.of(2022, 1, 2), "Takeout food", 7.89);
		history.addPurchase(LocalDate.of(2022, 1, 2), "Takeout food", 98.17);
		history.addPurchase(LocalDate.of(2021, 3, 1), "Cable/Internet bill", 243.00);
		history.addPurchase(LocalDate.of(2021, 2, 19), "Cell phone bill", 78.53);
		history.addPurchase(LocalDate.of(2021, 7, 28), "Rent", 2000.00);
		history.addPurchase(LocalDate.of(2022, 4, 18), "Gas", 74.33);
		history.addPurchase(LocalDate.of(2022, 4, 18), "Gas", 74.33);
		history.addPurchase(LocalDate.of(2022, 4, 18), "Takeout food", 196.31);
		history.addPurchase(LocalDate.of(2021, 11, 23), "New running shoes", 72.10);
		history.addPurchase(LocalDate.of(2021, 9, 19), "Life insurance", 110.00);
		history.addPurchase(LocalDate.of(2020, 9, 30), "Pet insurance", 44.99);
		history.addPurchase(LocalDate.of(2020, 8, 22), "Church charitable gift", 100.00);

		// PurchaseHistory.toString():
		String expectedPHStr = "2020-08-22 Church charitable gift 100.0, 2020-09-30 Pet insurance 44.99, 2021-02-19 Cell phone bill 78.53, 2021-03-01 Cable/Internet bill 243.0, 2021-07-28 Rent 2000.0, 2021-09-19 Life insurance 110.0, 2021-11-23 New running shoes 72.1, 2021-12-19 Christmas jammies for Robert 19.99, 2021-12-19 Christmas pillow for Robert 10.0, 2021-12-31 Champagne 18.5, 2022-01-02 Takeout food 98.17, 2022-01-02 Takeout food 57.89, 2022-01-02 Takeout food 7.89, 2022-04-18 Takeout food 196.31, 2022-04-18 Gas 74.33, 2022-04-18 Gas 74.33";
		assertEquals(expectedPHStr, history.toString());

		// removing purchases:
		assertEquals(1, history.removePurchase(LocalDate.of(2022, 1, 2), "Takeout food", 57.89));
		expectedPHStr = "2020-08-22 Church charitable gift 100.0, 2020-09-30 Pet insurance 44.99, 2021-02-19 Cell phone bill 78.53, 2021-03-01 Cable/Internet bill 243.0, 2021-07-28 Rent 2000.0, 2021-09-19 Life insurance 110.0, 2021-11-23 New running shoes 72.1, 2021-12-19 Christmas jammies for Robert 19.99, 2021-12-19 Christmas pillow for Robert 10.0, 2021-12-31 Champagne 18.5, 2022-01-02 Takeout food 98.17, 2022-01-02 Takeout food 7.89, 2022-04-18 Takeout food 196.31, 2022-04-18 Gas 74.33, 2022-04-18 Gas 74.33";
		assertEquals(expectedPHStr, history.toString());

		assertEquals(0, history.removePurchase(LocalDate.of(2022, 4, 19), "Gas", 74.33));
		expectedPHStr = "2020-08-22 Church charitable gift 100.0, 2020-09-30 Pet insurance 44.99, 2021-02-19 Cell phone bill 78.53, 2021-03-01 Cable/Internet bill 243.0, 2021-07-28 Rent 2000.0, 2021-09-19 Life insurance 110.0, 2021-11-23 New running shoes 72.1, 2021-12-19 Christmas jammies for Robert 19.99, 2021-12-19 Christmas pillow for Robert 10.0, 2021-12-31 Champagne 18.5, 2022-01-02 Takeout food 98.17, 2022-01-02 Takeout food 7.89, 2022-04-18 Takeout food 196.31, 2022-04-18 Gas 74.33, 2022-04-18 Gas 74.33";
		assertEquals(expectedPHStr, history.toString());

		assertEquals(0, history.removePurchase(LocalDate.of(2022, 4, 18), "Gas", 74.34));
		expectedPHStr = "2020-08-22 Church charitable gift 100.0, 2020-09-30 Pet insurance 44.99, 2021-02-19 Cell phone bill 78.53, 2021-03-01 Cable/Internet bill 243.0, 2021-07-28 Rent 2000.0, 2021-09-19 Life insurance 110.0, 2021-11-23 New running shoes 72.1, 2021-12-19 Christmas jammies for Robert 19.99, 2021-12-19 Christmas pillow for Robert 10.0, 2021-12-31 Champagne 18.5, 2022-01-02 Takeout food 98.17, 2022-01-02 Takeout food 7.89, 2022-04-18 Takeout food 196.31, 2022-04-18 Gas 74.33, 2022-04-18 Gas 74.33";
		assertEquals(expectedPHStr, history.toString());

		assertEquals(2, history.removePurchase(LocalDate.of(2022, 4, 18), "Gas", 74.33));
		expectedPHStr = "2020-08-22 Church charitable gift 100.0, 2020-09-30 Pet insurance 44.99, 2021-02-19 Cell phone bill 78.53, 2021-03-01 Cable/Internet bill 243.0, 2021-07-28 Rent 2000.0, 2021-09-19 Life insurance 110.0, 2021-11-23 New running shoes 72.1, 2021-12-19 Christmas jammies for Robert 19.99, 2021-12-19 Christmas pillow for Robert 10.0, 2021-12-31 Champagne 18.5, 2022-01-02 Takeout food 98.17, 2022-01-02 Takeout food 7.89, 2022-04-18 Takeout food 196.31";
		assertEquals(expectedPHStr, history.toString());

		// getting all purchases in a date range:
		List<Purchase> expList2020 = Arrays.asList(
				new Purchase(LocalDate.of(2020, 8, 22), "Church charitable gift", 100.0),
				new Purchase(LocalDate.of(2020, 9, 30), "Pet insurance", 44.99));
		List<Purchase> actualList2020 = history.getPurchasesInDateRange(LocalDate.of(2020, 1, 1),
				LocalDate.of(2020, 12, 31));
		assertEquals(expList2020, actualList2020);

		List<Purchase> expListDec2021 = Arrays.asList(
				new Purchase(LocalDate.of(2021, 12, 19), "Christmas jammies for Robert", 19.99),
				new Purchase(LocalDate.of(2021, 12, 19), "Christmas pillow for Robert", 10.00),
				new Purchase(LocalDate.of(2021, 12, 31), "Champagne", 18.5));
		List<Purchase> actualListDec2021 = history.getPurchasesInDateRange(LocalDate.of(2021, 12, 1),
				LocalDate.of(2021, 12, 31));
		assertEquals(expListDec2021, actualListDec2021);

		List<Purchase> expListDec19_2021 = Arrays.asList(
				new Purchase(LocalDate.of(2021, 12, 19), "Christmas jammies for Robert", 19.99),
				new Purchase(LocalDate.of(2021, 12, 19), "Christmas pillow for Robert", 10.00));
		List<Purchase> actualListDec19_2021 = history.getPurchasesInDateRange(LocalDate.of(2021, 12, 19),
				LocalDate.of(2021, 12, 19));
		assertEquals(expListDec19_2021, actualListDec19_2021);

		List<Purchase> expListMay2022 = Arrays.asList();
		List<Purchase> actualListMay2022 = history.getPurchasesInDateRange(LocalDate.of(2022, 5, 1),
				LocalDate.of(2022, 5, 31));
		assertEquals(expListMay2022, actualListMay2022);

		// add a couple of more purchases:
		history.addPurchase(LocalDate.of(2021, 12, 19), "Christmas tree", 64.00);
		history.addPurchase(LocalDate.of(2021, 12, 31), "Champagne", 1358.44);
		history.addPurchase(LocalDate.of(2019, 1, 19), "Movies", 36.12);
		history.addPurchase(LocalDate.of(2022, 2, 1), "boba", 4.95);
		history.addPurchase(LocalDate.of(2022, 2, 28), "boba", 4.95);
		expectedPHStr = "2019-01-19 Movies 36.12, 2020-08-22 Church charitable gift 100.0, 2020-09-30 Pet insurance 44.99, 2021-02-19 Cell phone bill 78.53, 2021-03-01 Cable/Internet bill 243.0, 2021-07-28 Rent 2000.0, 2021-09-19 Life insurance 110.0, 2021-11-23 New running shoes 72.1, 2021-12-19 Christmas tree 64.0, 2021-12-19 Christmas jammies for Robert 19.99, 2021-12-19 Christmas pillow for Robert 10.0, 2021-12-31 Champagne 1358.44, 2021-12-31 Champagne 18.5, 2022-01-02 Takeout food 98.17, 2022-01-02 Takeout food 7.89, 2022-02-01 boba 4.95, 2022-02-28 boba 4.95, 2022-04-18 Takeout food 196.31";
		assertEquals(expectedPHStr, history.toString());

		// getting purchase total in date range:
		assertEquals(9.9, history.getPurchaseTotalInDateRange(LocalDate.of(2022, 2, 1), LocalDate.of(2022, 2, 28)),
				EPSILON);
		assertEquals(36.12, history.getPurchaseTotalInDateRange(LocalDate.of(2019, 1, 1), LocalDate.of(2019, 6, 30)),
				EPSILON);
		assertEquals(1470.93,
				history.getPurchaseTotalInDateRange(LocalDate.of(2021, 12, 1), LocalDate.of(2021, 12, 31)), EPSILON);
		assertEquals(0, history.getPurchaseTotalInDateRange(LocalDate.of(2023, 2, 1), LocalDate.of(2023, 12, 31)),
				EPSILON);
		assertEquals(4467.94, history.getPurchaseTotalInDateRange(LocalDate.of(2019, 1, 1), LocalDate.of(2023, 12, 31)),
				EPSILON);

		// getting purchases matching description:
		history.addPurchase(LocalDate.of(2022, 2, 1), "boba", 8.95);
		List<Purchase> expList = Arrays.asList(new Purchase(LocalDate.of(2022, 2, 1), "boba", 8.95),
				new Purchase(LocalDate.of(2022, 2, 1), "boba", 4.95),
				new Purchase(LocalDate.of(2022, 2, 28), "boba", 4.95));
		assertEquals(expList, history.getPurchasesMatchingDescription("boba"));

		assertEquals(new ArrayList<Purchase>(), history.getPurchasesMatchingDescription("Home Depot stuff"));

		expList = Arrays.asList(new Purchase(LocalDate.of(2020, 9, 30), "Pet insurance", 44.99));
		assertEquals(expList, history.getPurchasesMatchingDescription("Pet insurance"));

		// getting purchase total matching description:
		history.removePurchase(LocalDate.of(2022, 2, 1), "boba", 4.95);
		assertEquals(13.9, history.getPurchaseTotalMatchingDescription("boba"), EPSILON);
		assertEquals(78.53, history.getPurchaseTotalMatchingDescription("Cell phone bill"), EPSILON);
		assertEquals(302.37, history.getPurchaseTotalMatchingDescription("Takeout food"), EPSILON);
		assertEquals(0.0, history.getPurchaseTotalMatchingDescription("Groceries"), EPSILON);

		// getting all purchases in an amount range:
		List<Purchase> cheapPurchasesExp = Arrays.asList(
				new Purchase(LocalDate.of(2021, 12, 19), "Christmas jammies for Robert", 19.99),
				new Purchase(LocalDate.of(2021, 12, 19), "Christmas pillow for Robert", 10.00),
				new Purchase(LocalDate.of(2021, 12, 31), "Champagne", 18.5),
				new Purchase(LocalDate.of(2022, 1, 2), "Takeout food", 7.89),
				new Purchase(LocalDate.of(2022, 2, 1), "boba", 8.95),
				new Purchase(LocalDate.of(2022, 2, 28), "boba", 4.95));
		List<Purchase> cheapPurchasesActual = history.getPurchasesInAmountRange(1, 20);
		assertEquals(cheapPurchasesExp, cheapPurchasesActual);

		List<Purchase> mediumPurchasesExp = Arrays.asList(new Purchase(LocalDate.of(2019, 1, 19), "Movies", 36.12),
				new Purchase(LocalDate.of(2020, 8, 22), "Church charitable gift", 100.00),
				new Purchase(LocalDate.of(2020, 9, 30), "Pet insurance", 44.99),
				new Purchase(LocalDate.of(2021, 2, 19), "Cell phone bill", 78.53),
				new Purchase(LocalDate.of(2021, 11, 23), "New running shoes", 72.10),
				new Purchase(LocalDate.of(2021, 12, 19), "Christmas tree", 64.00),
				new Purchase(LocalDate.of(2022, 1, 2), "Takeout food", 98.17));
		List<Purchase> mediumPurchasesActual = history.getPurchasesInAmountRange(20, 100);
		assertEquals(mediumPurchasesExp, mediumPurchasesActual);

		List<Purchase> expensivePurchasesExp = Arrays.asList(
				new Purchase(LocalDate.of(2020, 8, 22), "Church charitable gift", 100.00),
				new Purchase(LocalDate.of(2021, 3, 1), "Cable/Internet bill", 243.00),
				new Purchase(LocalDate.of(2021, 7, 28), "Rent", 2000.00),
				new Purchase(LocalDate.of(2021, 9, 19), "Life insurance", 110.00),
				new Purchase(LocalDate.of(2021, 12, 31), "Champagne", 1358.44),
				new Purchase(LocalDate.of(2022, 4, 18), "Takeout food", 196.31));
		List<Purchase> expensivePurchasesActual = history.getPurchasesInAmountRange(100, 2000);
		assertEquals(expensivePurchasesExp, expensivePurchasesActual);

		assertEquals(new ArrayList<Purchase>(), history.getPurchasesInAmountRange(2000.01, 100000));

		// getting purchase totals in an amount range:
		assertEquals(70.28, history.getPurchaseTotalInAmountRange(1, 20), EPSILON);
		assertEquals(493.91, history.getPurchaseTotalInAmountRange(20, 100), EPSILON);
		assertEquals(4007.75, history.getPurchaseTotalInAmountRange(100, 2000), EPSILON);
		assertEquals(0, history.getPurchaseTotalInAmountRange(2000.01, 100000), EPSILON);
		assertEquals(36.12, history.getPurchaseTotalInAmountRange(36.12, 36.12), EPSILON);

		// getting max purchase in date range:
		expList = Arrays.asList(new Purchase(LocalDate.of(2020, 8, 22), "Church charitable gift", 100.0));
		List<Purchase> actualList = history.getMaxPurchaseInDateRange(LocalDate.of(2020, 1, 1),
				LocalDate.of(2020, 12, 31));
		assertEquals(expList, actualList);

		expList = Arrays.asList(new Purchase(LocalDate.of(2021, 12, 31), "Champagne", 1358.44));
		actualList = history.getMaxPurchaseInDateRange(LocalDate.of(2021, 12, 1), LocalDate.of(2021, 12, 31));
		assertEquals(expList, actualList);

		history.addPurchase(LocalDate.of(2021, 12, 19), "Canidae dog food for Robert", 64.00);
		expList = Arrays.asList(new Purchase(LocalDate.of(2021, 12, 19), "Canidae dog food for Robert", 64.00),
				new Purchase(LocalDate.of(2021, 12, 19), "Christmas tree", 64.00));
		actualList = history.getMaxPurchaseInDateRange(LocalDate.of(2021, 12, 19), LocalDate.of(2021, 12, 19));
		assertEquals(expList, actualList);

		actualList = history.getMaxPurchaseInDateRange(LocalDate.of(2022, 5, 1), LocalDate.of(2022, 5, 31));
		assertEquals(new ArrayList<Purchase>(), actualList);

		// getting min purchase in date range:
		expList = Arrays.asList(new Purchase(LocalDate.of(2020, 9, 30), "Pet insurance", 44.99));
		actualList = history.getMinPurchaseInDateRange(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 12, 31));
		assertEquals(expList, actualList);

		history.addPurchase(LocalDate.of(2021, 12, 2), "mints", 0.5);
		history.addPurchase(LocalDate.of(2021, 12, 1), "gum", 0.5);
		history.addPurchase(LocalDate.of(2021, 12, 2), "gum", 0.5);

		expList = Arrays.asList(new Purchase(LocalDate.of(2021, 12, 1), "gum", 0.5),
				new Purchase(LocalDate.of(2021, 12, 2), "gum", 0.5),
				new Purchase(LocalDate.of(2021, 12, 2), "mints", 0.5));
		actualList = history.getMinPurchaseInDateRange(LocalDate.of(2021, 12, 1), LocalDate.of(2021, 12, 31));
		assertEquals(expList, actualList);

		expList = Arrays.asList(new Purchase(LocalDate.of(2021, 12, 19), "Christmas pillow for Robert", 10.00));
		actualList = history.getMinPurchaseInDateRange(LocalDate.of(2021, 12, 19), LocalDate.of(2021, 12, 19));
		assertEquals(expList, actualList);

		actualList = history.getMinPurchaseInDateRange(LocalDate.of(2022, 5, 1), LocalDate.of(2022, 5, 31));
		assertEquals(new ArrayList<Purchase>(), actualList);
	}


	@Test
	void problem6() {

		// firstLetter1.txt:
		FirstLetterMap map = new FirstLetterMap("res/firstLetter1.txt");
		assertEquals(
				"{a=[a, across, actually, alice, and, at], b=[before], e=[either], f=[feet, flashed, for], h=[had, her, hurried], i=[it, its], l=[looked], m=[mind], n=[never], o=[of, on, or, out], r=[rabbit], s=[seen, she, started], t=[take, that, the, then, to, took], w=[waistcoatpocket, watch, when, with]}",
				map.toString());

		Set<String> expected = new TreeSet<>();
		expected.add("had");
		expected.add("her");
		expected.add("hurried");
		assertEquals(expected, map.getWordsThatStartWith('h'));

		// firstLetter2.txt:
		map = new FirstLetterMap("res/firstLetter2.txt");
		assertEquals(
				"{a=[a, as], b=[but], d=[disappointment, down], e=[empty], f=[from], g=[great], h=[her], i=[it], j=[jar], l=[labelled], m=[marmalade], o=[of, one, orange], p=[passed], s=[she, shelves], t=[the, to, took], w=[was]}",
				map.toString());

		expected = new TreeSet<>();
		expected.add("her");
		assertEquals(expected, map.getWordsThatStartWith('h'));

		// firstLetter3.txt:
		map = new FirstLetterMap("res/firstLetter3.txt");
		assertEquals(
				"{a=[again, alice], b=[began], c=[cat], d=[dinah, dinahll, do, down], e=[else], i=[i], m=[me, miss, much], n=[nothing], s=[should, so, soon], t=[talking, the, there, think, to, tonight], v=[very], w=[was]}",
				map.toString());

		assertEquals(null, map.getWordsThatStartWith('h'));

		expected = new TreeSet<>();
		expected.add("talking");
		expected.add("the");
		expected.add("there");
		expected.add("think");
		expected.add("to");
		expected.add("tonight");
		assertEquals(expected, map.getWordsThatStartWith('t'));

		// firstLetter4.txt:
		map = new FirstLetterMap("res/firstLetter4.txt");
		assertEquals(
				"{a=[again, alice], b=[began, bowls], c=[cat, cream], d=[dinah, dinahll, do, down], e=[eat, else, end], i=[i, ice], m=[me, miss, much], n=[nothing], o=[of], s=[should, so, soon], t=[talking, the, there, think, to, tonight], v=[very], w=[want, was]}",
				map.toString());
		
		expected = new TreeSet<>();
		expected.add("dinah");
		expected.add("dinahll");
		expected.add("do");
		expected.add("down");
		assertEquals(expected, map.getWordsThatStartWith('d'));
		
		expected = new TreeSet<>();
		expected.add("cat");
		expected.add("cream");
		assertEquals(expected, map.getWordsThatStartWith('c'));
		
		// test exception message is printed out:
		String nonExistentFileName = "res/firstLetterDoesNotExist.txt";
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		map = new FirstLetterMap(nonExistentFileName);
		
		String result = output.toString();
		assertEquals("File: " + nonExistentFileName + " not found", result);
	}
	
	
	@Test
	void problem7() {
		ShippingCenter center = new ShippingCenter();
		assertEquals("", center.getShippingStack());
		assertEquals("", center.getTemporaryStack());
		
		List<String> expected = Arrays.asList(
				"Shipping stack: product 1", 
				"Temporary stack: ");
		assertEquals(expected, center.add("product 1"));
		
		expected = Arrays.asList(
				"Shipping stack: product 1, product 2", 
				"Temporary stack: ");
		assertEquals(expected, center.add("product 2"));
		
		expected = Arrays.asList(
				"Shipping stack: product 1, product 2, product 3", 
				"Temporary stack: ");
		assertEquals(expected, center.add("product 3"));
		
		expected = Arrays.asList("That product is already on the shipping stack.");
		assertEquals(expected, center.add("product 3"));
		
		expected = Arrays.asList(
				"Shipping stack: product 1, product 2, product 3, product 4", 
				"Temporary stack: ");
		assertEquals(expected, center.add("product 4"));
		
		expected = Arrays.asList(
				"Shipping stack: product 1, product 2, product 3", 
				"Temporary stack: product 4",
				"Shipping stack: product 1, product 2",
				"Temporary stack: product 4, product 3",
				"Shipping stack: product 1, product 3",
				"Temporary stack: product 4",
				"Shipping stack: product 1, product 3, product 4",
				"Temporary stack: "
				);
		assertEquals(expected, center.ship("product 2"));

		expected = Arrays.asList(
				"Shipping stack: product 1, product 3",
				"Temporary stack: "
				);
		assertEquals(expected, center.ship("product 4"));
		
		expected = Arrays.asList(
				"Shipping stack: product 1, product 3, product 5",
				"Temporary stack: "
				);
		assertEquals(expected, center.add("product 5"));
		
		expected = Arrays.asList(
				"Shipping stack: product 1, product 3, product 5, product 6",
				"Temporary stack: "
				);
		assertEquals(expected, center.add("product 6"));

		expected = Arrays.asList(
				"Shipping stack: product 1, product 3, product 5", 
				"Temporary stack: product 6", 
				"Shipping stack: product 1, product 3", 
				"Temporary stack: product 6, product 5", 
				"Shipping stack: product 1", 
				"Temporary stack: product 6, product 5, product 3",
				"Shipping stack: product 3", 
				"Temporary stack: product 6, product 5", 
				"Shipping stack: product 3, product 5", 
				"Temporary stack: product 6", 
				"Shipping stack: product 3, product 5, product 6", 
				"Temporary stack: "
				);
		assertEquals(expected, center.ship("product 1"));
		
		expected = Arrays.asList("That product is not on the shipping stack.");
		assertEquals(expected, center.ship("product 1"));
		assertEquals(expected, center.ship("product 99"));
	}
	
	
	@Test
	void problem8() {
		ProductionLine pl = new ProductionLine();
		assertEquals("", pl.handleNextOrder());
		pl.addStandardOrder(34);
		pl.addStandardOrder(889);
		pl.addRushOrder(18);
		pl.addRushOrder(203);
		assertEquals("Producing rush order for customer 18", pl.handleNextOrder());
		assertEquals("Producing rush order for customer 203", pl.handleNextOrder());
		assertEquals("Producing standard order for customer 34", pl.handleNextOrder());
		pl.addRushOrder(78);
		assertEquals("Producing rush order for customer 78", pl.handleNextOrder());
		assertEquals("Producing standard order for customer 889", pl.handleNextOrder());
		assertEquals("", pl.handleNextOrder());
	}
	
	
	@Test
	void problems9and10() {
		SurvivalGame game = new SurvivalGame();
		assertEquals(0, game.getPlayer().getLocation().x);
		assertEquals(0, game.getPlayer().getLocation().y);
		assertEquals(100, game.getPlayer().getEnergy());
		
		game.dropFood(new Point(3, 3), "granola bar", 2); // net energy: -2
		game.dropFood(new Point(-1, 1), "steak", 8); // net energy: 7
		game.dropFood(new Point(16, 6), "candy bar", 1); // net energy: -16
		game.dropFood(new Point(1, 0), "sandwich", 10); // net energy: 9

		Food f = game.getPlayer().getFood();
		assertEquals("sandwich at location 1, 0, energy value 10", f.toString());
		assertEquals("sandwich", f.getDescription());
		Point p = new Point(1, 0);
		assertEquals(p, f.getLocation());
		assertEquals(p, game.getPlayer().getLocation());
		assertEquals(109, game.getPlayer().getEnergy());
		
		f = game.getPlayer().getFood();
		assertEquals("steak at location -1, 1, energy value 8", f.toString());
		assertEquals("steak", f.getDescription());
		p = new Point(-1, 1);
		assertEquals(p, f.getLocation());
		assertEquals(p, game.getPlayer().getLocation());
		assertEquals(115, game.getPlayer().getEnergy());

		game.dropFood(new Point(15, 5), "pizza", 20); // net energy: 4
		
		f = game.getPlayer().getFood();
		assertEquals("pizza at location 15, 5, energy value 20", f.toString());
		assertEquals("pizza", f.getDescription());
		p = new Point(15, 5);
		assertEquals(p, f.getLocation());
		assertEquals(p, game.getPlayer().getLocation());
		assertEquals(119, game.getPlayer().getEnergy());
		
		f = game.getPlayer().getFood();
		assertEquals("candy bar at location 16, 6, energy value 1", f.toString());
		assertEquals("candy bar", f.getDescription());
		p = new Point(16, 6);
		assertEquals(p, f.getLocation());
		assertEquals(p, game.getPlayer().getLocation());
		assertEquals(119, game.getPlayer().getEnergy());

		f = game.getPlayer().getFood();
		assertEquals("granola bar at location 3, 3, energy value 2", f.toString());
		assertEquals("granola bar", f.getDescription());
		p = new Point(3, 3);
		assertEquals(p, f.getLocation());
		assertEquals(p, game.getPlayer().getLocation());
		assertEquals(108, game.getPlayer().getEnergy());
		
		assertNull(game.getPlayer().getFood());
	}

}
