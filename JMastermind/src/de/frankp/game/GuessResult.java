package de.frankp.game;

public class GuessResult {

	private int correctColors;
	private int correctPositions;

	public GuessResult(int correctColors, int correctPositions) {
		this.correctColors = correctColors;
		this.correctPositions = correctPositions;
	}

	public int getCorrectColors() {
		return correctColors;
	}

	public int getCorrectPositions() {
		return correctPositions;
	}
}
