package labs.lab4;

import java.awt.Point;
import java.util.List;

/**
 * A class for an adventure game with a player, traps, and jet packs. The game
 * world measures 10 x 10, and the center of the world is at coordinates 0, 0.
 */
public class AdventureGame {

	String dir;
	int num_jet;
	Point loc; 
	int num_move;
	List<Point> trap_list;
	List<Point> jet_list; 

	/**
	 * Constructs a new game with player location 0, 0 (in the center of the world)
	 * facing north, with the traps and jet packs given
	 * 
	 * @param traps    list of locations of traps (assume all within world bounds,
	 *                 and not at 0, 0)
	 * @param jetPacks list of locations of jet packs (assume all within world
	 *                 bounds, and not at 0, 0)
	 */
	public AdventureGame(List<Point> traps, List<Point> jetPacks) {
		trap_list = traps;
		jet_list = jetPacks;
		dir = "NORTH";
		num_jet = 0;
		num_move = 0;
		loc = new Point(0,0);
	}



	/**
	 * Turns the player to the left
	 */
	public void playerTurnLeft() {
		if (this.getPlayerDirection().equals("NORTH"))
		{
			dir = "WEST";
		}else if (this.getPlayerDirection().equals("WEST"))
		{
			dir = "SOUTH";
		}else if (this.getPlayerDirection().equals("SOUTH"))
		{
			dir = "EAST";
		}else 
		{
			dir = "NORTH";
		}
	}


	/**
	 * Turns the player to the right
	 */
	public void playerTurnRight() {
		if (this.getPlayerDirection().equals("NORTH"))
		{
			dir = "EAST";
		}else if (this.getPlayerDirection().equals("WEST"))
		{
			dir = "NORTH";
		}else if (this.getPlayerDirection().equals("SOUTH"))
		{
			dir = "WEST";
		}else 
		{
			dir = "SOUTH";
		}
	}


	/**
	 * Moves the player one step in the direction they're facing, as long as the
	 * move is a valid one (within the bounds of the world)
	 */
	public void movePlayer() {
		if (this.getNumMovesMade() < 30)
		{
			if (this.getPlayerDirection().equals("NORTH"))
			{
				if (loc.getY() < 5)
				{
					loc.setLocation(loc.getX(),loc.getY()+1);
					num_move++;
				}
			}else if (this.getPlayerDirection().equals("WEST"))
			{
				if (loc.getX()>-5)
				{
					loc.setLocation(loc.getX()-1,loc.getY());
					num_move++;
				}
			}else if (this.getPlayerDirection().equals("SOUTH"))
			{
				if (loc.getY()>-5)
				{
					loc.setLocation(loc.getX(),loc.getY()-1);
					num_move++;
				}
			}else 
			{
				if (loc.getX()<5)
				{
					loc.setLocation(loc.getX()+1,loc.getY());
					num_move++;
			
				}
			}
			if (jet_list.contains(this.getPlayerLocation()))
			{
				if (num_jet < 3)
				{
					num_jet++;
					System.out.print("Picked up jet pack! ");
					jet_list.remove(this.getPlayerLocation());
				}
			}if (trap_list.contains(this.getPlayerLocation()))
			{
				if (num_jet > 0)
				{
					num_jet--;
					System.out.print("Fell into a trap! Used jet pack! ");
				}else
				{
					System.out.print("Fell into a trap! You lose!");
				}
			}
			if (num_move == 30)
			{
				System.out.print("You win!");
			}
		}
	}


	/**
	 * Returns the player's current location
	 * 
	 * @return the player's current location
	 */
	public Point getPlayerLocation() {
		return loc;
	}


	/**
	 * Returns the direction in which the player is currently facing
	 * ("NORTH", "SOUTH", "EAST", OR "WEST")
	 * 
	 * @return	the direction in which the player is currently facing
	 */
	public String getPlayerDirection() {
		return dir;
	}
	
	
	/**
	 * Returns the number of moves the player has taken
	 * 
	 * @return	the number of moves the player has taken
	 */
	public int getNumMovesMade() {
		return num_move;
	}
}
