package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class StrategyLowRisk implements BotStrategy {

	@Override
	public Action getAction(Hand hand) {
		if (hand.getScore() >= 17) {
			return Action.HOLD;
		} else {
			return Action.HIT;
		}
	}

	@Override
	public int getBet() {
		return (int) Math.floor(Math.random() * (50 - 10 + 1) + 10);
	}

}
