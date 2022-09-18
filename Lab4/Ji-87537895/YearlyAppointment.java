package labs.lab4;

/**
 * A yearly appointment.
 */
public class YearlyAppointment extends Appointment {

	private int m;
	private int d;

	/**
	 * Initializes appointment that happens every year on a given date.
	 * 
	 * @param month       the month
	 * @param day         the day
	 * @param description the text description of the appointment
	 */
	public YearlyAppointment(int month, int day, String description) {
		super.setDescription(description);
		m = month;
		d = day;
	}


	public int getMonth() {
		return m;
	}


	public int getDay() {
		return d;
	}


	/**
	 * Determines if this appointment occurs on the given date.
	 * 
	 * @param year  the year
	 * @param month the month
	 * @param day   the day
	 * 
	 * @return true if the appointment occurs on the given date.
	 */
	public boolean occursOn(int year, int month, int day) {
		return m == month && d == day;
	}


	/**
	 * Returns true if the given object has the same instance variable
	 * value(s) as this YearlyAppointment
	 */
	@Override
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject))
		{
			return false;
		}
		if (otherObject instanceof YearlyAppointment)
		{
			YearlyAppointment other = (YearlyAppointment) otherObject;
			return m == other.m && d == other.d;
		}
		return false;
	}

}
