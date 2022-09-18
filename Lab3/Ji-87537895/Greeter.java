package labs.lab1;

/**
 * Produces customized greetings, based on your name
 *
 */
public class Greeter {

	private String name;

	/**
	 * Creates a Greeter based on the provided name
	 * 
	 * @param name name of person to greet
	 */
	public Greeter(String name) {
		this.name = name;
	}


	/**
	 * Returns a greeting message ("Hello, [name]")
	 * 
	 * @return the greeting
	 */
	public String sayHello() {
		return "Hello, "+ this.name;
	}


	/**
	 * Returns a farewell message ("Goodbye, [name]")
	 * 
	 * @return the farewell message
	 */
	public String sayGoodbye() {
		return "Goodbye, " + this.name; 
	}
}
