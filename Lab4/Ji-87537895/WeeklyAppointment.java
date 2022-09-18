package labs.lab4;

import java.time.DayOfWeek;

/**
 * Weekly appointment.
 */
public class WeeklyAppointment extends Appointment {

	private DayOfWeek d;

	/**
	 * Initializes appointment for a given day of the week.
	 * 
	 * @param dayOfWeek   the day of the wee
	 * @param description the text description of the appointment
	 */
	public WeeklyAppointment(DayOfWeek dayOfWeek, String description) {
		d = dayOfWeek;
	}


	public DayOfWeek getDayOfWeek() {
		return d;
	}


	/**
	 * Determines if this appointment occurs on the given date.
	 * 
	 * @param year  the year
	 * @param month the month
	 * @param day   the day
	 * @return true if the appointment occurs on the given date.
	 */
	public boolean occursOn(int year, int month, int day) {
		int year_code = ((year % 100) / 4 + year % 100)%7;
		int[] s = {0,3,3,6,1,4,6,2,5,0,3,5};
		int month_code = s[month-1];
		int[] a = {4,2,0,6,4,2,0};
		int centruy_code = a[year/100-17];
		int leap_year;
		if (year % 400 == 0)
		{
			leap_year = 1;
		}else
		{
			if (year % 4 == 0 && year % 100 != 0)
			{
				leap_year = 1;
			}else
			{
				leap_year = 0;
			}
		}
		return (year_code + month_code - leap_year + day + centruy_code) % 7 == d.getValue() % 7;
	}


	/**
	 * Returns true if the given object has the same instance variable
	 * value(s) as this WeeklyAppointment
	 */
	@Override
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject))
		{
			return false;
		}
		if (otherObject instanceof WeeklyAppointment)
		{
			WeeklyAppointment other = (WeeklyAppointment) otherObject;
			return other.d.getValue() == d.getValue() ;
		}
		return false;
		
	}
}
