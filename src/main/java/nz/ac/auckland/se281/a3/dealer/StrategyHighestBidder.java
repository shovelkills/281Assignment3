package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public class StrategyHighestBidder implements DealerStrategy {

	private Player highestBidder;

	@Override
	public Action getAction(Hand hand, List<Player> players) {
		highestBidder = players.get(0);
		for (Player player : players) {// Finds the player with the highest bet
			if (highestBidder.getHand().getBet() < player.getHand().getBet()) {
				highestBidder = player;
			}
		}
		if (highestBidder.getHand().isBlackJack() && hand.getScore() >= 17) {// Checks if the highestbidder has blackjack
			return Action.HOLD;
		} else {
			if (hand.getScore() >= highestBidder.getHand().getScore() || highestBidder.getHand().isBust()) {//checks if the dealer beats the highestbidder
				return Action.HOLD;
			} else {
				return Action.HIT;
			}

		}

	}

}
