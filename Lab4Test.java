package labs.lab4;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Lab4Test {

	private final double EPSILON = 1e-2;

	@Test
	void problem1() {
		// static methods:
		assertEquals(1.0, Geometry.cubeVolume(1.0), EPSILON);
		assertEquals(6.0, Geometry.cubeSurface(1.0), EPSILON);
		assertEquals(151.419437, Geometry.cubeVolume(5.33), EPSILON);
		assertEquals(6605.4744, Geometry.cubeSurface(33.18), EPSILON);
		assertEquals(1.0, Geometry.prismVolume(1.0, 1.0, 1.0), EPSILON);
		assertEquals(6.0, Geometry.prismSurface(1.0, 1.0, 1.0), EPSILON);
		assertEquals(135.1647, Geometry.prismVolume(11.1, 12.3, 0.99), EPSILON);
		assertEquals(319.392, Geometry.prismSurface(11.1, 12.3, 0.99), EPSILON);
		assertEquals(0.3333, Geometry.pyramidVolume(1.0, 1.0), EPSILON);
		assertEquals(3.23607, Geometry.pyramidSurface(1.0, 1.0), EPSILON);
		assertEquals(0.00291667, Geometry.pyramidVolume(0.5, 0.035), EPSILON);
		assertEquals(0.50244, Geometry.pyramidSurface(0.5, 0.035), EPSILON);

		// Object-oriented:
		Cube cube = new Cube(1.0);
		assertEquals(1.0, cube.getVolume(), EPSILON);
		assertEquals(6.0, cube.getSurface(), EPSILON);
		cube = new Cube(5.33);
		assertEquals(151.419437, cube.getVolume(), EPSILON);
		cube = new Cube(33.18);
		assertEquals(6605.4744, cube.getSurface(), EPSILON);

		Prism prism = new Prism(1.0, 1.0, 1.0);
		assertEquals(1.0, prism.getVolume(), EPSILON);
		assertEquals(6.0, prism.getSurface(), EPSILON);
		prism = new Prism(11.1, 12.3, 0.99);
		assertEquals(135.1647, prism.getVolume(), EPSILON);
		assertEquals(319.392, prism.getSurface(), EPSILON);

		Pyramid pyramid = new Pyramid(1.0, 1.0);
		assertEquals(0.3333, pyramid.getVolume(), EPSILON);
		assertEquals(3.23607, pyramid.getSurface(), EPSILON);
		pyramid = new Pyramid(0.5, 0.035);
		assertEquals(0.00291667, pyramid.getVolume(), EPSILON);
		assertEquals(0.50244, pyramid.getSurface(), EPSILON);
	}


	@Test
	void problems2And3() {
		// Test Case #1 (losing because they fall into a trap without a jet pack):
		List<Point> traps = new ArrayList<>();
		traps.add(new Point(-1, 0));
		traps.add(new Point(4, 4));
		traps.add(new Point(3, -2));
		traps.add(new Point(-3, -1));
		traps.add(new Point(-4, -1));
		List<Point> jetPacks = new ArrayList<>();
		jetPacks.add(new Point(0, 1));
		jetPacks.add(new Point(-2, 5));
		jetPacks.add(new Point(0, -3));

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		AdventureGame game1 = new AdventureGame(traps, jetPacks);
		assertEquals(new Point(0, 0), game1.getPlayerLocation());
		assertEquals("NORTH", game1.getPlayerDirection());

		game1.movePlayer(); // prints out "Picked up jet pack! "
		assertEquals(new Point(0, 1), game1.getPlayerLocation());
		assertEquals("NORTH", game1.getPlayerDirection());
		game1.playerTurnLeft();
		assertEquals(new Point(0, 1), game1.getPlayerLocation());
		assertEquals("WEST", game1.getPlayerDirection());
		game1.movePlayer();
		assertEquals(new Point(-1, 1), game1.getPlayerLocation());
		assertEquals("WEST", game1.getPlayerDirection());
		game1.playerTurnLeft();
		assertEquals(new Point(-1, 1), game1.getPlayerLocation());
		assertEquals("SOUTH", game1.getPlayerDirection());
		game1.movePlayer(); // prints out "Fell into a trap! Used jet pack! "
		assertEquals(new Point(-1, 0), game1.getPlayerLocation());
		assertEquals("SOUTH", game1.getPlayerDirection());
		game1.playerTurnRight();
		assertEquals(new Point(-1, 0), game1.getPlayerLocation());
		assertEquals("WEST", game1.getPlayerDirection());
		game1.movePlayer();
		assertEquals(new Point(-2, 0), game1.getPlayerLocation());
		assertEquals("WEST", game1.getPlayerDirection());
		game1.movePlayer();
		assertEquals(new Point(-3, 0), game1.getPlayerLocation());
		assertEquals("WEST", game1.getPlayerDirection());
		game1.playerTurnLeft();
		assertEquals(new Point(-3, 0), game1.getPlayerLocation());
		assertEquals("SOUTH", game1.getPlayerDirection());

		game1.movePlayer(); // prints out "Fell into a trap! You lose!"
		String result = output.toString();
		assertEquals("Picked up jet pack! Fell into a trap! Used jet pack! Fell into a trap! You lose!", result);

		// Test Case #2 (try to pick up > 3 jet packs, go back to where they used to be
		// a jet pack)
		traps = new ArrayList<>();
		traps.add(new Point(-1, 0));
		traps.add(new Point(4, 4));
		traps.add(new Point(3, -2));
		traps.add(new Point(-3, -1));
		traps.add(new Point(-4, -1));
		jetPacks = new ArrayList<>();
		jetPacks.add(new Point(0, 1));
		jetPacks.add(new Point(0, 2));
		jetPacks.add(new Point(0, 3));
		jetPacks.add(new Point(0, 4));
		jetPacks.add(new Point(-2, 5));
		jetPacks.add(new Point(0, -3));

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		AdventureGame game2 = new AdventureGame(traps, jetPacks);
		assertEquals(new Point(0, 0), game2.getPlayerLocation());
		assertEquals("NORTH", game2.getPlayerDirection());

		game2.movePlayer(); // prints out "Picked up jet pack! "
		assertEquals(new Point(0, 1), game2.getPlayerLocation());
		assertEquals("NORTH", game2.getPlayerDirection());

		game2.movePlayer(); // prints out "Picked up jet pack! "
		assertEquals(new Point(0, 2), game2.getPlayerLocation());
		assertEquals("NORTH", game2.getPlayerDirection());

		game2.movePlayer(); // prints out "Picked up jet pack! "
		assertEquals(new Point(0, 3), game2.getPlayerLocation());
		assertEquals("NORTH", game2.getPlayerDirection());

		game2.movePlayer(); // player encounters a jet pack, but can't pick it up because they already have
							// 3
		assertEquals(new Point(0, 4), game2.getPlayerLocation());
		assertEquals("NORTH", game2.getPlayerDirection());

		game2.playerTurnRight();
		game2.movePlayer();
		assertEquals(new Point(1, 4), game2.getPlayerLocation());
		assertEquals("EAST", game2.getPlayerDirection());

		game2.movePlayer();
		game2.movePlayer();
		game2.movePlayer(); // prints out "Fell into a trap! Used jet pack! "
		assertEquals(new Point(4, 4), game2.getPlayerLocation());
		assertEquals("EAST", game2.getPlayerDirection());

		game2.playerTurnLeft();
		game2.playerTurnLeft();
		assertEquals(new Point(4, 4), game2.getPlayerLocation());
		assertEquals("WEST", game2.getPlayerDirection());
		game2.movePlayer();
		game2.movePlayer();
		game2.movePlayer();
		game2.movePlayer(); // prints out "Picked up jet pack! "
		assertEquals(new Point(0, 4), game2.getPlayerLocation());
		assertEquals("WEST", game2.getPlayerDirection());
		game2.playerTurnLeft();
		assertEquals("SOUTH", game2.getPlayerDirection());
		game2.movePlayer(); // used to be a jet pack here, shouldn't be one any longer
		game2.movePlayer(); // used to be a jet pack here, shouldn't be one any longer
		game2.movePlayer(); // used to be a jet pack here, shouldn't be one any longer
		game2.movePlayer();
		game2.playerTurnRight();
		assertEquals(new Point(0, 0), game2.getPlayerLocation());
		assertEquals("WEST", game2.getPlayerDirection());
		game2.movePlayer(); // prints out "Fell into a trap! Used jet pack! "

		game2.playerTurnLeft();
		game2.movePlayer();
		assertEquals(new Point(-1, -1), game2.getPlayerLocation());
		assertEquals("SOUTH", game2.getPlayerDirection());

		game2.playerTurnRight();
		game2.movePlayer();
		game2.movePlayer(); // prints out "Fell into a trap! Used jet pack! "
		assertEquals(new Point(-3, -1), game2.getPlayerLocation());
		assertEquals("WEST", game2.getPlayerDirection());
		game2.movePlayer(); // prints out "Fell into a trap! Used jet pack! "
		assertEquals(new Point(-4, -1), game2.getPlayerLocation());
		assertEquals("WEST", game2.getPlayerDirection());

		game2.playerTurnLeft();
		game2.movePlayer();
		game2.playerTurnLeft();
		game2.movePlayer();
		game2.movePlayer();
		game2.movePlayer();
		game2.movePlayer();
		game2.movePlayer();
		game2.movePlayer();
		game2.movePlayer(); // prints out "Fell into a trap! You lose! "

		result = output.toString();
		assertEquals(
				"Picked up jet pack! Picked up jet pack! Picked up jet pack! Fell into a trap! Used jet pack! Picked up jet pack! Fell into a trap! Used jet pack! Fell into a trap! Used jet pack! Fell into a trap! Used jet pack! Fell into a trap! You lose!",
				result);

		// Test Case #3 (try to move off the world, make 30 moves without dying and win:
		traps = new ArrayList<>();
		traps.add(new Point(-1, 0));
		jetPacks = new ArrayList<>();

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		AdventureGame game3 = new AdventureGame(traps, jetPacks);
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		assertEquals(new Point(0, 5), game3.getPlayerLocation());
		assertEquals("NORTH", game3.getPlayerDirection());

		game3.movePlayer(); // trying to move out of the world bounds, should not be allowed, and move
							// should not count toward 30
		game3.movePlayer(); // trying to move out of the world bounds, should not be allowed, and move
							// should not count toward 30
		game3.movePlayer(); // trying to move out of the world bounds, should not be allowed, and move
							// should not count toward 30
		assertEquals(5, game3.getNumMovesMade());
		assertEquals(new Point(0, 5), game3.getPlayerLocation());
		assertEquals("NORTH", game3.getPlayerDirection());

		game3.playerTurnLeft();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		assertEquals(new Point(-5, 5), game3.getPlayerLocation());
		assertEquals("WEST", game3.getPlayerDirection());
		game3.movePlayer(); // trying to move out of the world bounds, should not be allowed, and move
							// should not count toward 30
		assertEquals(10, game3.getNumMovesMade());
		assertEquals(new Point(-5, 5), game3.getPlayerLocation());
		assertEquals("WEST", game3.getPlayerDirection());

		game3.playerTurnLeft();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		assertEquals(20, game3.getNumMovesMade());

		game3.playerTurnLeft();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer();
		game3.movePlayer(); // prints out "You win!"

		result = output.toString();
		assertEquals("You win!", result);

		// Test Case #4 (one spot contains a jet pack and a trap):
		traps = new ArrayList<>();
		traps.add(new Point(0, 1));
		jetPacks = new ArrayList<>();
		jetPacks.add(new Point(0, 1));

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		AdventureGame game4 = new AdventureGame(traps, jetPacks);
		game4.movePlayer(); // prints out "Picked up jet pack! Fell into a trap! Used jet pack! "
		game4.movePlayer();
		game4.playerTurnRight();
		game4.playerTurnRight();
		game4.movePlayer(); // prints out "Fell into a trap! You lose!"

		result = output.toString();
		assertEquals("Picked up jet pack! Fell into a trap! Used jet pack! Fell into a trap! You lose!", result);
	}


	@Test
	void problem4() {
		TimeKeeper tk = new TimeKeeper();
		tk.doActivity(new Activity("Eat breakfast", 0.05, Activity.Category.OTHER));
		tk.doActivity(new Activity("Go for a run with Mommy", 1.0, Activity.Category.EXERCISE));
		tk.doActivity(new Activity("Bring in the newspaper", 0.03, Activity.Category.WORK));
		tk.doActivity(new Activity("Take my siblings to school", 0.75, Activity.Category.WORK));
		tk.doActivity(new Activity("Play ball with Mommy", 0.05, Activity.Category.PLAY));
		tk.doActivity(new Activity("Take a nap", 3.5, Activity.Category.SLEEP));
		tk.doActivity(new Activity("Sunbathe", 0.5, Activity.Category.OTHER));
		tk.doActivity(new Activity("Play tug of war with Daddy", 0.05, Activity.Category.PLAY));
		tk.doActivity(new Activity("Attend Mom's 45J lecture", 1.3, Activity.Category.WORK));
		tk.doActivity(new Activity("Afternoon nap", 2.0, Activity.Category.SLEEP));
		tk.doActivity(new Activity("Pick my siblings up from school", 1.0, Activity.Category.WORK));
		tk.doActivity(new Activity("Eat dinner", 0.05, Activity.Category.OTHER));
		tk.doActivity(new Activity("Evening walk around the neighborhood", 0.5, Activity.Category.EXERCISE));
		tk.doActivity(new Activity("Go outside and bark at nothing", 0.15, Activity.Category.WORK));

		assertEquals(3.23, tk.getTotalTimeForCategory(Activity.Category.WORK), EPSILON);
		assertEquals(29.55169258920402, tk.getPercentageOfTimeSpentInCategory(Activity.Category.WORK), EPSILON);
		assertEquals(0.1, tk.getTotalTimeForCategory(Activity.Category.PLAY), EPSILON);
		assertEquals(0.9149130832570904, tk.getPercentageOfTimeSpentInCategory(Activity.Category.PLAY), EPSILON);
		assertEquals(1.5, tk.getTotalTimeForCategory(Activity.Category.EXERCISE), EPSILON);
		assertEquals(13.723696248856356, tk.getPercentageOfTimeSpentInCategory(Activity.Category.EXERCISE), EPSILON);
		assertEquals(5.5, tk.getTotalTimeForCategory(Activity.Category.SLEEP), EPSILON);
		assertEquals(50.32021957913998, tk.getPercentageOfTimeSpentInCategory(Activity.Category.SLEEP), EPSILON);
		assertEquals(0.6, tk.getTotalTimeForCategory(Activity.Category.OTHER), EPSILON);
		assertEquals(5.489478499542544, tk.getPercentageOfTimeSpentInCategory(Activity.Category.OTHER), EPSILON);
	}


	@Test
	void problem6() {
		BetterRectangle r1 = new BetterRectangle(2, 3, 15, 17);
		assertEquals(2.0, r1.getX(), EPSILON);
		assertEquals(3.0, r1.getY(), EPSILON);
		assertEquals(15.0, r1.getWidth(), EPSILON);
		assertEquals(17.0, r1.getHeight());
		assertEquals(64.0, r1.getPerimeter());
		assertEquals(255.0, r1.getArea());
		assertTrue(BetterRectangle.class.getSuperclass() == Rectangle.class);
	}


	@Test
	void problem7() {
		LabeledPoint p1 = new LabeledPoint(0, 5, "location of buried treasure");
		assertEquals("labs.lab4.LabeledPoint[x=0,y=5] label=location of buried treasure", p1.toString());
		LabeledPoint p2 = new LabeledPoint(-5, 1, "quicksand here--watch out!");
		assertEquals("labs.lab4.LabeledPoint[x=-5,y=1] label=quicksand here--watch out!", p2.toString());
		assertTrue(LabeledPoint.class.getSuperclass() == Point.class);
	}


	@Test
	void problems8Thru10TestAppointment() {
		Appointment[] appointments = new Appointment[] { new DailyAppointment("Brush teeth"),
				new MonthlyAppointment(1, "Visit Grandma"), new OnetimeAppointment(2021, 11, 1, "Dentist appointment"),
				new OnetimeAppointment(2021, 10, 31, "Schedule yearly checkup"),
				new YearlyAppointment(10, 31, "Trick or Treat"), new DailyAppointment("Write some code"),
				new MonthlyAppointment(31, "Change mascara"), new YearlyAppointment(3, 28, "Robert's birthday"),
				new OnetimeAppointment(2020, 11, 1, "Doctor appointment"),
				new WeeklyAppointment(DayOfWeek.SUNDAY, "Plan my week"),
				new WeeklyAppointment(DayOfWeek.FRIDAY, "Lunch with Mom"),
				new WeeklyAppointment(DayOfWeek.WEDNESDAY, "Lunch with Dad"),
				new WeeklyAppointment(DayOfWeek.MONDAY, "Fight a case of \"The Mondays\""),
				new OnetimeAppointment(2021, 11, 1, "Dentist appointment"),
				new OnetimeAppointment(2022, 11, 1, "Dentist appointment"),
				new YearlyAppointment(7, 15, "Lunch with Mom") };

		int year = 2021, month = 10, day = 31;
		assertTrue(appointments[0].occursOn(year, month, day));
		assertFalse(appointments[1].occursOn(year, month, day));
		assertFalse(appointments[2].occursOn(year, month, day));
		assertTrue(appointments[3].occursOn(year, month, day));
		assertTrue(appointments[4].occursOn(year, month, day));
		assertTrue(appointments[5].occursOn(year, month, day));
		assertTrue(appointments[6].occursOn(year, month, day));
		assertFalse(appointments[7].occursOn(year, month, day));
		assertFalse(appointments[8].occursOn(year, month, day));
		assertTrue(appointments[9].occursOn(year, month, day));
		assertFalse(appointments[10].occursOn(year, month, day));
		assertFalse(appointments[11].occursOn(year, month, day));
		assertFalse(appointments[12].occursOn(year, month, day));
		assertFalse(appointments[13].occursOn(year, month, day));
		assertFalse(appointments[14].occursOn(year, month, day));
		assertFalse(appointments[15].occursOn(year, month, day));

		assertTrue(appointments[2].equals(appointments[13]));
		assertFalse(appointments[2].equals(appointments[14]));
		assertFalse(appointments[1].equals(appointments[6]));
		assertFalse(appointments[10].equals(appointments[15]));
	}


	@Test
	void problems8Thru10TestOnetimeAppointment() {
		OnetimeAppointment a = new OnetimeAppointment(2020, 11, 2, "Lab 4 Due");
		assertEquals(2020, a.getYear());
		assertEquals(11, a.getMonth());
		assertTrue(a.occursOn(2020, 11, 2));
		assertTrue(a.equals(new OnetimeAppointment(2020, 11, 2, "Lab 4 Due")));
		assertTrue(OnetimeAppointment.class.getSuperclass() == Appointment.class);
	}


	@Test
	void problems8Thru10TestDailyAppointment() {
		DailyAppointment a = new DailyAppointment("Remember to stay healthy!");
		assertTrue(a.occursOn(2020, 11, 2));
		assertTrue(a.equals(new DailyAppointment("Remember to stay healthy!")));
		assertTrue(DailyAppointment.class.getSuperclass() == Appointment.class);
	}


	@Test
	void problems8Thru10TestMonthlyAppointment() {
		MonthlyAppointment a = new MonthlyAppointment(1, "First day of the month!");
		assertEquals(1, a.getDay());
		assertTrue(a.occursOn(2020, 12, 1));
		assertTrue(a.equals(new MonthlyAppointment(1, "First day of the month!")));
		assertTrue(MonthlyAppointment.class.getSuperclass() == Appointment.class);
	}


	@Test
	void problems8Thru10TestYearlyAppointment() {
		YearlyAppointment a = new YearlyAppointment(1, 1, "Happy New Year!");
		assertEquals(1, a.getMonth());
		assertEquals(1, a.getDay());
		assertTrue(a.occursOn(2020, 1, 1));
		assertTrue(a.equals(new YearlyAppointment(1, 1, "Happy New Year!")));
		assertTrue(YearlyAppointment.class.getSuperclass() == Appointment.class);
	}


	@Test
	void problems8Thru10TestWeeklyAppointment() {
		WeeklyAppointment a = new WeeklyAppointment(DayOfWeek.FRIDAY, "CELEBRATE!");
		assertEquals(DayOfWeek.FRIDAY, a.getDayOfWeek());
		assertTrue(a.occursOn(2021, 12, 31));
		assertTrue(a.equals(new WeeklyAppointment(DayOfWeek.FRIDAY, "CELEBRATE!")));
		assertTrue(WeeklyAppointment.class.getSuperclass() == Appointment.class);
	}

}
