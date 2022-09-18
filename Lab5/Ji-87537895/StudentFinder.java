package labs.lab5;

/**
 * Test class for Comparable Student objects.
 */
public class StudentFinder {

	/**
	 * Determines first student in a non-empty array of Student objects.
	 * 
	 * @param students array of Student objects
	 * @return first Student
	 */
	public static Student firstStudent(Student[] students) {
		Student s = students[0];
		for (int i = 1; i < students.length; i++)
		{
			if (s.compareTo(students[i]) > 0)
			{
				s = students[i];
			}
		}
		return s;
	}


	/**
	 * Determines last student in a non-empty array of Student objects.
	 * 
	 * @param students array of Student objects
	 * @return last Student
	 */
	public static Student lastStudent(Student[] students) {
		Student s = students[0];
		for (int i = 1; i < students.length; i++)
		{
			if (s.compareTo(students[i]) < 0)
			{
				s = students[i];
			}
		}
		return s;
	}

}
