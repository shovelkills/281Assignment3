package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class StrategyRandomAction implements BotStrategy {
	private Random random = new Random();

	@Override
	public Action getAction(Hand hand) {
		if (random.nextDouble() > 0.5) {
			return Action.HOLD;
		} else {
			return Action.HIT;
		}
	}

	@Override
	public int getBet() {
		return (int) Math.floor(Math.random() * (100 - 1 + 1) + 1);
	}

}
