package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Player;

/**
 * you should change this class for TASK 1
 */
public class Bot extends Player {
	// Instance fields
	private BotStrategy botAction;
	private String botStrategy;

	/**
	 * A constructor for the class bot and stores the name in the superclass
	 * 
	 * @param name the name of the bot
	 */
	public Bot(String name) {
		super(name);
	}

	@Override
	public Action decideAction(Hand hand) {
		return this.botAction.getAction(hand);

	}

	@Override
	public int makeABet() {
		return botAction.getBet();
	}

	/**
	 * Determines what strategy the bot should use by getting the string of the bot
	 * and finding the bot strategy depending on the string
	 * 
	 * @param botStrategy a string to decide what bot strategy it should use
	 */
	public void setBotStrategy(String botStrategy) {// method to get the strategy
		this.botStrategy = botStrategy;
		botAction = BotFactory.gatherBotActivity(this.botStrategy);
	}

}
