package labs.lab5;

/**
 * This class represents a student with a name and ID.
 */
public class Student implements Comparable {

	String name;
	int id;

	/**
	 * Constructs a student object
	 * 
	 * @param name the student's name
	 * @param id   the student's id
	 */
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}


	/**
	 * Gets the student's name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Gets the student's id
	 * 
	 * @return the name
	 */
	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return this.getName()+", " + this.getId();
	}


	@Override
	public boolean equals(Object otherObject) {
		Student s = (Student) otherObject;
		return this.getName().equals(s.getName()) && this.getId() == s.getId();
	}


	/**
	 * Compares student objects first by name, then by id
	 * 
	 * @param other Other student against which to compare
	 * @return negative int if this students comes before, 0 if equal, positive int
	 *         if this student comes after
	 */
	public int compareTo(Object other) {
		Student s = (Student) other;
		if (this.getName().equals(s.getName()))
		{
			if (this.getId() > s.getId())
			{
				return 1;
			}else if (this.getId() == s.getId())
			{
				return 0;
			}
			else
			{
				return -1;
			}
		}else
		{
			return this.getName().compareTo(s.getName());
		}
	}

}
