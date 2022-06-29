package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public class StrategyTopWinner implements DealerStrategy {

	private Player topWinner;

	@Override
	public Action getAction(Hand hand, List<Player> players) {
		topWinner = players.get(0);
		for (Player player : players) {// Checks all the players to see the top winner of the group
			if (topWinner.netWins() < player.netWins()) {
				topWinner = player;
			}
		}
		if (topWinner.getHand().isBlackJack() && hand.getScore() >= 17) {// Checks if the top winner has blackjack
			return Action.HOLD;
		} else {
			if (topWinner.getHand().getScore() <= hand.getScore() || topWinner.getHand().isBust()) {// Checks if dealer
																									// should hold
				return Action.HOLD;
			} else {
				return Action.HIT;
			}
		}
	}

}
