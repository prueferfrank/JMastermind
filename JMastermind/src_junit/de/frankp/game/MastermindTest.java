package de.frankp.game;

import static de.frankp.game.MastermindColor.BLUE;
import static de.frankp.game.MastermindColor.GREEN;
import static de.frankp.game.MastermindColor.RED;
import static de.frankp.game.MastermindColor.YELLOW;
import static org.junit.Assert.*;

import org.junit.Test;
public class MastermindTest {

	@Test
	public void test() {
		
		MastermindColor[] testGame = new MastermindColor[]{RED, GREEN,BLUE, YELLOW };
		
		Mastermind testee = new Mastermind();
		
		Guess guess = new Guess(new MastermindColor[]{ GREEN,BLUE, YELLOW ,RED});
		GuessResult gr = testee.evaluateGuess(guess, testGame);
		
		assertEquals(4, gr.getCorrectColors());
		assertEquals(0, gr.getCorrectPositions());	
	}
	
	@Test
	public void test2() {
		
		MastermindColor[] testGame = new MastermindColor[]{RED, GREEN,BLUE, YELLOW };
		
		Mastermind testee = new Mastermind();
		
		Guess guess = new Guess(new MastermindColor[]{ GREEN,GREEN,GREEN,GREEN});
		GuessResult gr = testee.evaluateGuess(guess, testGame);
		
		assertEquals(4, gr.getCorrectColors());
		assertEquals(1, gr.getCorrectPositions());	
	}

}
