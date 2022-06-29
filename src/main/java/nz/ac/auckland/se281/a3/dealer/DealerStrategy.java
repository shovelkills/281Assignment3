package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public interface DealerStrategy {
	/**
	 * Gets the action of what the dealer should do by seeing it's hand and the hand
	 * of other players
	 * 
	 * @param hand    the hand of the dealer
	 * @param players the list of players
	 * @return the action that the dealer should do
	 */
	public Action getAction(Hand hand, List<Player> players);

}
