package labs.lab5;

/**
 * Player in the battle game
 *
 */
public class Player {

	private String name;
	private int strengthpoint;
	private int ammo;
	

	/**
	 * Constructs a new Player with the given name, 0 strength points, and 0 ammo
	 * 
	 * @param name name of the player
	 */
	public Player(String name) {
		this.name = name;
		this.strengthpoint = 0;
		this.ammo = 0;
	}


	public String getName() {
		return this.name;
	}


	public int getStrengthPoints() {
		return this.strengthpoint;
	}


	public int getAmmo() {
		return this.ammo;
	}


	/**
	 * If the item is a PowerUp: Collects the given PowerUp if it's not already
	 * collected, and increments the player's strength points by the number of
	 * points the PowerUp is worth
	 * 
	 * If the item is Ammo: Collects the given ammo if it's not already collected,
	 * and if the player has enough strength points (each pound of ammo requires 10
	 * strength points); adds to the player's ammo the number of items in the ammo
	 * 
	 * @param c the item to collect
	 * 
	 * @return whether or not the item was collected
	 */
	public boolean collectItem(Collectable c) {
		if (! c.isCollected())
		{
			if (c instanceof PowerUp)
			{
				PowerUp b = (PowerUp) c;
				this.strengthpoint += b.collect();
			}
			else
			{
				Ammo a = (Ammo) c;
				if (this.getStrengthPoints() >= 10*a.getWeight())
				{
					this.ammo += a.collect();
				}else
				{
					return false;
				}
			}
			return true;
		}else
		{
			return false;
		}
	}


	/**
	 * If the Player has ammo, attacks the given enemy with one ammo (and uses up
	 * one ammo)
	 * 
	 * @param enemy the Enemy to attack
	 * 
	 * @return whether or not the Enemy was attacked
	 */
	public boolean attackEnemy(Enemy enemy) {
		if (this.ammo > 0)
		{
			this.strengthpoint += enemy.attack();
			this.ammo -= 1;
			return true;
		}
		else
		{
			return false;
		}
	}

}