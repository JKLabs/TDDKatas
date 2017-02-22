package org.jklabs.tddkatas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {
	private BowlingGame game;
	
	@Before
	public void setUp() {
		game = new BowlingGame();
	}

	
	@Test
	public void canScoreAllZeros() {		
		game.roll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
		
		assertEquals(0, game.score());
	}
	
	@Test
	public void canSoreAllOnes() {		
		game.roll(1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1);
		
		assertEquals(20, game.score());
	}
	
	@Test
	public void canScoreSpareFollowedByThree() {
		game.roll(1,9, 3,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
		
		assertEquals(16, game.score());
	}
	
	@Test
	public void canScoreStrikeFollowedByFourThenFour() {
		game.roll(10, 4,4, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
		
		assertEquals(26, game.score());
	}
	
	@Test
	public void canScorePerfectGame() {
		game.roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
		
		assertEquals(300, game.score());
	}
	
	@Test
	public void canScoreNineStrikesAndASpareFollwedByAThree() {
		game.roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 5,5, 3);
		
		assertEquals(268, game.score());
	}
}
