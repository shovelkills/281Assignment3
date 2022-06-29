package nz.ac.auckland.se281.a3;

/**
 * 
 * You can (and should) add new fields and/or methods
 *
 */
public abstract class Player extends Participant {
	// instance fields
	private int wins;
	private int losses;

	/**
	 * A constructor to create a player instance and stores the name in Participant
	 * 
	 * @param name the name of the player
	 */
	public Player(String name) {
		super(name);
	}

	/**
	 * Depending on what strategy the bot is, it gets the amount it is going to bet
	 * 
	 * @return the amount the bot is going to bet
	 */
	public abstract int makeABet();

	/**
	 * increase the amount of wins that the player has by increasing the wins
	 * instance
	 */
	public void increaseWins() {
		wins++;
	}

	/**
	 * increase the amount of losses that the player has by increasing the loss
	 * instance
	 */
	public void increaseLosses() {
		losses++;
	}

	public int getWins() {// gets the wins field
		return wins;
	}

	public int getLoss() {// gets the losses fields
		return losses;
	}

	/**
	 * Gets the net wins by calculating the differences between wins and losses
	 * 
	 * @return the net amount of wins that the player has
	 */
	public int netWins() {
		return wins - losses;
	}
}
