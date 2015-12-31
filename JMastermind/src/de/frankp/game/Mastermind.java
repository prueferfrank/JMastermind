package de.frankp.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Mastermind {

	// a game consists of this number of colors
	private static int COLORS = 4;

	// a game should be solved with this number of guesses
	private static int MAX_GUESSES = 12;

	private MastermindColor[] game;

	private List<Guess> guesses;

	private List<GuessResult> results;

	private boolean solved;

	/**
	 * starts a new game
	 * <p>
	 * all previous guesses are removed
	 */
	public void start() {
		game = new MastermindColor[COLORS];
		// farben neu belegen
		Set<MastermindColor> gameColors = new HashSet<>();
		for (MastermindColor color : MastermindColor.values()) {
			gameColors.add(color);
		}

		for (int i = 0; i < COLORS; i++) {
			game[i] = randomColor(gameColors);
			gameColors.remove(game[i]);
		}
		guesses = new ArrayList<>();
		results = new ArrayList<>();
		solved = false;
		printColors(game);
	}

	public void guess(Guess guess)
			throws MaxGuessException, InvalidGuessException, GameSolvedException, GameNotStartedException {

		if (solved) {
			throw new GameSolvedException();
		}
		if (game == null) {
			throw new GameNotStartedException();
		}
		//
		if (guesses.size() >= MAX_GUESSES) {
			throw new MaxGuessException();
		}
		// check guess for validity
		// the guess may not contain any double color
		Set<MastermindColor> guessColorSet = new HashSet<>();
		for (MastermindColor color : guess.getColors()) {
			guessColorSet.add(color);
		}
		if (guessColorSet.size() != game.length) {
			throw new InvalidGuessException();
		}
		// ok, it's a valid guess right now
		guesses.add(guess);

		// add Result
		GuessResult result = evaluateGuess(guess, game);
		results.add(result);

	}

	protected GuessResult evaluateGuess(Guess guess, MastermindColor[] validGame) {
		// calculate Result
		int correctColors = 0;
		Set<MastermindColor> gameColorSet = new HashSet<>();
		for (MastermindColor color : validGame) {
			gameColorSet.add(color);

		}
		for (MastermindColor gc : guess.getColors()) {
			if (gameColorSet.contains(gc)) {
				correctColors++;
			}
		}
		int correctPositions = 0;
		for (int i = 0; i < validGame.length; i++) {
			if (guess.getColors()[i] == validGame[i]) {
				correctPositions++;
			}
		}
		GuessResult result = new GuessResult(correctColors, correctPositions);
		return result;
	}

	private void printColors(MastermindColor[] colorArray) {
		for (MastermindColor mmc : colorArray) {
			System.out.print(mmc.name() + ", ");
		}
		System.out.println();
	}

	// returns a random color out of this set..
	private MastermindColor randomColor(Set<MastermindColor> gameColors) {
		int num = (int) Math.round((gameColors.size() - 1) * Math.random());
		List<MastermindColor> unsortedColors = new ArrayList<>();
		unsortedColors.addAll(gameColors);
		return unsortedColors.get(num);
	}

	public static void main(String[] args) {
		Mastermind mm = new Mastermind();
		mm.start();
	}

}
