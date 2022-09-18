package labs.lab4;

import java.util.ArrayList;

public class TimeKeeper {
	ArrayList<Activity> info;
	
	
	/**
	 * Constructs a new TimeKeeper, with no activities
	 */
	public TimeKeeper() {
		info  = new ArrayList<Activity>();
	}
	
	
	/**
	 * Causes TimeKeeper to record the given activity
	 * 
	 * @param a	the activity to record
	 */
	public void doActivity(Activity a) {
		info.add(a);
	}
	
	
	/**
	 * Returns the total time (in hours) spent in the given category
	 * 
	 * @param 	category	category to calculate the time spent in
	 * @return	total time (in hours) spent in the category	
	 */
	public double getTotalTimeForCategory(Activity.Category category) {
		double time = 0.0;
		for (Activity a : info)
		{
			if (a.getCategory() == category)
			{
				time += a.getTime();
			}
		}
		return time;
		
	}
	
	
	/**
	 * Returns the total percentage of time spent in the given category
	 * 
	 * @param 	category	category to calculate the time spent in
	 * @return	total percentage of time spent in the category	
	 */
	public double getPercentageOfTimeSpentInCategory(Activity.Category category) {
		double time = 0.0;
		double total = 0.0;
		for (Activity a : info)
		{
			total += a.getTime();
			if (a.getCategory() == category)
			{
				time += a.getTime();
			}
		}
		if (total != 0.0)
		{
			return 100.0*time/total;
		}else
		{
			return 0.0;
		}
	}
}