package nz.ac.auckland.se281.a3.bot;

public class BotFactory {
	/**
	 * Determines which strategy that the bot should use by checking the string that
	 * is passed through the method
	 * 
	 * @param strategy a string that determines which strategy it should use
	 * @return the class of the both strategy it should use
	 */
	public static BotStrategy gatherBotActivity(String strategy) {
		switch (strategy) { // switch case depending on what the string is
		case "LR":
			return new StrategyLowRisk();
		case "HR":
			return new StrategyHighRisk();
		default:
			return new StrategyRandomAction();
		}
	}
}
