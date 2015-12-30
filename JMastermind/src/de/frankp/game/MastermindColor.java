package de.frankp.game;

import java.awt.Color;

public enum MastermindColor {
	RED(Color.RED), //
	GREEN(Color.GREEN), //
	YELLOW(Color.YELLOW), //
	BLUE(Color.BLUE), //
	GRAY(Color.GRAY), //
	WHITE(Color.WHITE);//

	private Color color;

	private MastermindColor(Color color) {
		this.color = color;
	}
}
