package de.frankp.game;

public class Guess {
	
	private MastermindColor[] colors;

	public Guess(MastermindColor[] colors){
		this.colors = colors;
	}
	
	public MastermindColor[] getColors(){
		return colors;
	}

}
