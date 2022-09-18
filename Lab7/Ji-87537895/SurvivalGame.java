package labs.lab7;

import java.awt.Point;

public class SurvivalGame {

	Player p;

	/**
	 * Constructs a new survival game with player
	 */
	public SurvivalGame() {
		p  = new Player();
	}


	public Player getPlayer() {
		return p;
	}


	/**
	 * Drops food into the game
	 * 
	 * @param location    food drop location
	 * @param description description of food item
	 * @param energyValue energy value of food item
	 */
	public void dropFood(Point location, String description, int energyValue) {
		p.addFoodToQueue(new Food(location,p, description,energyValue));
	}

}