package nz.ac.auckland.se281.a3;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.a3.bot.Bot;
import nz.ac.auckland.se281.a3.dealer.Dealer;
import nz.ac.auckland.se281.a3.dealer.StrategyHighestBidder;
import nz.ac.auckland.se281.a3.dealer.StrategyTopWinner;

/**
 * Unless it is specified in the JavaDoc, you cannot change any methods.
 * 
 * You can add new methods and/or new instance fields
 */
public class BlackJack {

	private List<Player> players;
	private Dealer dealer;
	private Deck deck;

	public BlackJack(Deck deck) {
		this.deck = deck;
		players = new ArrayList<>();
		players.add(new Human("Player1")); // add the Human player first.
	}

	/**
	 * Thi constructor is for testing reasons
	 * 
	 * @param cards
	 */
	protected BlackJack(Card... cards) {
		this(new Deck(cards));

	}

	public BlackJack() {
		this(new Deck());
	}

	public List<Player> getPlayers() {
		return players;
	}

	private String getBotStrategy() {
		System.out.println("Choose Bot strategy: random (R) - low risk (LR) - high risk (HR)");
		String result = Main.scanner.next();
		while (!result.equals("R") && !result.equals("LR") && !result.equals("HR") && !result.equals("A")) {
			System.out.println("please type \"R\", \"LR\",  \"HR\"");
			result = Main.scanner.next();
		}
		return result;
	}

	// do not change this method
	public void start() {
		initBots();
		initDealer();
		String res;
		int round = 0;
		do {
			round++;
			for (Participant p : players) {
				p.play(deck, round);
			}
			dealer.play(deck, round);
			printAndUpdateResults(round); // after each game print result and update scoreboard
			System.out.println("Do you want to play again?");
			res = Main.scanner.next();
			while (!res.equals("yes") && !res.equals("no")) {
				System.out.println("please type either \"yes\" or \"no\"");
				res = Main.scanner.next();
			}
		} while (res.equals("yes"));
		printGameStatistics(); // when the user terminates the game print the statistics
	}

	/**
	 * Creates two new bots and sets the strategy for each bot
	 */
	protected void initBots() {
		Bot bot1 = new Bot("Bot1");
		Bot bot2 = new Bot("Bot2");
		String botStrategyString = getBotStrategy();
		// create and set Bots strategy here
		bot1.setBotStrategy(botStrategyString);
		bot2.setBotStrategy(botStrategyString);
		players.add(bot1);
		players.add(bot2);

	}

	/**
	 * Creates the dealer class and updates the dealer strategy by using the
	 * updateDealerStrategy function
	 */
	protected void initDealer() {
		// set the initial strategy using the Strategy pattern
		dealer = new Dealer("Dealer", getPlayers());
		updateDealerStrategy();

	}

	/**
	 * Checks if any of the players have net wins of 2 or higher and changes the
	 * strategy of the dealer
	 */
	protected void updateDealerStrategy() {
		for (Player player : getPlayers()) {// For loop to check all the players have net 2 wins
			if (player.netWins() >= 2) {
				dealer.setStrategy(new StrategyTopWinner());
				break;
			} else {
				dealer.setStrategy(new StrategyHighestBidder());
			}
		}
	}

	/**
	 * Sees which players have won and lost the round and updates the results of
	 * each player
	 * 
	 * @param round the number of rounds the game has played
	 */
	protected void printAndUpdateResults(int round) {
		for (Player player : getPlayers()) {// For loop to check if each player has won against the dealer or not
			if ((!(dealer.getHand().isBlackJack()) && !(player.getHand().isBust())
					&& ((player.getHand().getScore() > dealer.getHand().getScore()) || dealer.getHand().isBust()
							|| player.getHand().isBlackJack() && dealer.getHand().getCards().size() > 2))) {// Checks if
																											// the hand
																											// of the
																											// player is
																											// bust, if
																											// the
																											// dealer
				// has blackjack or that the player beats the dealer's hand
				player.increaseWins();
				System.out.println(// Prints if the player won
						"Round " + round + ": " + player.getName() + " won " + player.getHand().getBet() + " chips");
			} else {
				player.increaseLosses();
				System.out.println(// Prints if the player lost
						"Round " + round + ": " + player.getName() + " lost " + player.getHand().getBet() + " chips");
			}
		}

		updateDealerStrategy();// Updates the dealer strategy
	}

	/**
	 * Displays the number of times each player has won and lost for the entire game
	 */
	protected void printGameStatistics() {
		for (Player player : getPlayers()) {
			System.out.println(
					player.getName() + " won " + player.getWins() + " times and lost " + player.getLoss() + " times");
		}

	}

}
