package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant;
import nz.ac.auckland.se281.a3.Player;

/**
 * 
 * You should change this class for Task 2
 *
 */
public class Dealer extends Participant {

	private DealerStrategy strategy;
	private List<Player> players;

	/**
	 * A constructor that adds the name and the list of players to the class
	 * 
	 * @param name    the players name
	 * @param players the list of players
	 */
	public Dealer(String name, List<Player> players) {
		super(name);
		this.players = players;
	}

	@Override
	public Action decideAction(Hand hand) {
		return strategy.getAction(hand, this.players);

	}

	public void setStrategy(DealerStrategy strategy) {// Sets the strategy
		this.strategy = strategy;

	}

}
