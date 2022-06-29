package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class StrategyHighRisk implements BotStrategy {

	@Override
	public Action getAction(Hand hand) {
		if (hand.getScore() >= 19) {
			return Action.HOLD;
		} else {
			return Action.HIT;
		}
	}

	@Override
	public int getBet() {
		return (int) Math.floor(Math.random() * (100 - 50 + 1) + 50);
	}

}
