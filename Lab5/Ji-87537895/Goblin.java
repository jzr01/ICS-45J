package labs.lab5;

/**
 * A goblin enemy
 *
 */

public class Goblin extends Enemy {

	private String color;

	/**
	 * Constructs a new Goblin with color purple
	 */
	public Goblin() {
		this.color = "purple";
	}


	public String getColor() {
		return this.color;
	}


	/**
	 * 1) changes the Goblin's color to "red"; 2) decrements the Goblin's health by
	 * 50; 3) returns 50 (the number of strength points awarded to a player for
	 * attacking this Goblin)
	 * 
	 * @return 50 (the number of strength points awarded to a player for attacking
	 *         this Goblin)
	 */
	public int attack() {
		this.color = "red";
		this.setHealth(this.getHealth()-50);
		return 50;
	}


	/**
	 * 1) decrements the Goblin's health by 20; 2) changes Goblin's color to the next
	 * one in the cycle purple, orange, black, purple, orange, black, ..., OR if the
	 * Goblin is red (from a stomp), starts the cycle over again with purple
	 */
	public void advanceTime() {
		this.setHealth(this.getHealth()-20);
		if (this.color == "purple")
		{
			this.color = "orange";
		}else if (this.color == "orange")
		{
			this.color = "black";
		}else if (this.color == "black")
		{
			this.color = "purple";
		}else
		{
			this.color = "purple";
		}
	}

}