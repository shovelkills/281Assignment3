package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public interface BotStrategy {
	/**
	 * Generates the action that the bot should use depending on the score of its
	 * hand
	 * 
	 * @param hand the hand of the bot
	 * @return the action of the bot
	 */
	public Action getAction(Hand hand);

	/**
	 * Generates a random number depending on what strategy that the bot is using.
	 * 
	 * @return the amount that the bot wants to bet
	 */
	public int getBet();

}
