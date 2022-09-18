package labs.lab4;

/**
 * A onetime appointment.
 */
public class OnetimeAppointment extends Appointment {

	private int y;
	private int m;
	private int d;

	/**
	 * Initializes appointment for a given date.
	 * 
	 * @param year        the year
	 * @param month       the month
	 * @param day         the day
	 * @param description the text description of the appointment
	 */
	public OnetimeAppointment(int year, int month, int day, String description) {
		y = year;
		m = month;
		d = day;
		super.setDescription(description);
	}


	public int getYear() {
		return y;
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
		return y == year && m == month && d == day;
	}


	/**
	 * Returns true if the given object has the same instance variable
	 * value(s) as this OnetimeAppointment
	 */
	@Override
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject))
		{
			return false;
		}
		if (otherObject instanceof OnetimeAppointment)
		{
			OnetimeAppointment other = (OnetimeAppointment) otherObject;
			return super.equals(otherObject) && y == other.y && d == other.d && m == other.m;
		}
		return false;
		
	}

}
