package labs.lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeKeeperTest {
	
	private final double EPSILON = 1e-3;
	
	
	@Test
    public void testAllActivitiesInOneCategory() {
		TimeKeeper tk = new TimeKeeper();

		tk.doActivity(new Activity("Bring in the newspaper", 0.03, Activity.Category.WORK));
		tk.doActivity(new Activity("Take my siblings to school", 0.75, Activity.Category.WORK));
		tk.doActivity(new Activity("Attend Mom's 45J lecture", 1.3, Activity.Category.WORK));
		tk.doActivity(new Activity("Pick my siblings up from school", 1.0, Activity.Category.WORK));
		tk.doActivity(new Activity("Go outside and bark at nothing", 0.15, Activity.Category.WORK));
		
		assertEquals(3.23,tk.getTotalTimeForCategory(Activity.Category.WORK));
		assertEquals(100.0,tk.getPercentageOfTimeSpentInCategory(Activity.Category.WORK));
    }
	
	
	@Test
	public void testNoActivities() {
		TimeKeeper tk = new TimeKeeper();
		assertEquals(0.0, tk.getTotalTimeForCategory(Activity.Category.WORK));
		assertEquals(0.0, tk.getTotalTimeForCategory(Activity.Category.PLAY));
		assertEquals(0.0, tk.getTotalTimeForCategory(Activity.Category.SLEEP));
		assertEquals(0.0, tk.getTotalTimeForCategory(Activity.Category.OTHER));
		assertEquals(0.0, tk.getTotalTimeForCategory(Activity.Category.EXERCISE));
		
		assertEquals(0.0, tk.getPercentageOfTimeSpentInCategory(Activity.Category.WORK));
		assertEquals(0.0, tk.getPercentageOfTimeSpentInCategory(Activity.Category.PLAY));
		assertEquals(0.0, tk.getPercentageOfTimeSpentInCategory(Activity.Category.SLEEP));
		assertEquals(0.0, tk.getPercentageOfTimeSpentInCategory(Activity.Category.OTHER));
		assertEquals(0.0, tk.getPercentageOfTimeSpentInCategory(Activity.Category.EXERCISE));
	}
	
	
	@Test
	public void testDuplicateActivities() {
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

		assertEquals(2*3.23, tk.getTotalTimeForCategory(Activity.Category.WORK));
		assertEquals(29.55169258920402, tk.getPercentageOfTimeSpentInCategory(Activity.Category.WORK));
		assertEquals(2*0.1, tk.getTotalTimeForCategory(Activity.Category.PLAY), EPSILON);
		assertEquals(0.9149130832570904, tk.getPercentageOfTimeSpentInCategory(Activity.Category.PLAY));
		assertEquals(2*1.5, tk.getTotalTimeForCategory(Activity.Category.EXERCISE), EPSILON);
		assertEquals(13.723696248856356, tk.getPercentageOfTimeSpentInCategory(Activity.Category.EXERCISE));
		assertEquals(2*5.5, tk.getTotalTimeForCategory(Activity.Category.SLEEP), EPSILON);
	}
}
