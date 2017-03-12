package org.jklabs.tddkatas;

import static org.jklabs.tddkatas.TicTacToe.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class TicTacToeTest {
	
	@Test
	public void intitialUnplayedBoard_onPlay_givesCenterCell() {
		int[][] board = new int[][]{
				new int[] {E, E ,E},
				new int[] {E, E, E},
				new int[] {E, E, E}
		};
		
		assertEquals(TicTacToe.play(board, X), 4);
	}
	
	@Test
	public void centreCellTaken_onPlay_takesAnyCornerCell() {
		int[][] board = new int[][]{
				new int[] {E, E ,E},
				new int[] {E, O, E},
				new int[] {E, E, E}
		};
		
		assertTrue(Arrays.asList(0, 2, 6, 8).contains(TicTacToe.play(board, X)));
	}
	
	@Test
	public void higherPriorityCellsTaken_onPlay_takesNextHigherPriorityCell() {
		int[][] board = new int[][]{
				new int[] {O, E ,O},
				new int[] {E, O, E},
				new int[] {X, E, X}
		};
		
		assertTrue(Arrays.asList(1, 3, 5, 7).contains(TicTacToe.play(board, X)));
	}
	
	@Test
	public void fullBoard_onPlay_returnsErrorCode() {
		int[][] board = new int[][]{
				new int[] {X, O ,X},
				new int[] {X, X, O},
				new int[] {O, X, O}
		};
		
		assertEquals(TicTacToe.play(board, X), ERROR_CODE);
	}
	
	@Test
	public void winnableHorizontalCellsExist_onPlay_winsTheGame() {
		int[][] board = new int[][]{
				new int[] {O, E ,O},
				new int[] {E, O, E},
				new int[] {X, E, X}
		};
		
		assertEquals(TicTacToe.play(board, X), 7);
	}
	
	@Test
	public void winnableVerticalCellExist_onPlay_winsTheGame() {
		int[][] board = new int[][]{
				new int[] {O, X ,O},
				new int[] {E, X, E},
				new int[] {E, E, E}
		};
		
		assertEquals(TicTacToe.play(board, X), 7);
	}
	
	@Test
	public void winnableForwardDiagonalCellExist_onPlay_winsTheGame() {
		int[][] board = new int[][]{
				new int[] {X, E ,E},
				new int[] {O, X, E},
				new int[] {O, E, E}
		};
		
		assertEquals(TicTacToe.play(board, X), 8);
	}
	
	@Test
	public void winnableBackwardDiagonalCellExist_onPlay_winsTheGame() {
		int[][] board = new int[][]{
				new int[] {E, O ,E},
				new int[] {O, X, E},
				new int[] {X, E, E}
		};
		
		assertEquals(TicTacToe.play(board, X), 2);
	}
	
	@Test
	public void opponentWinnableCellExist_onPlay_stopsOpponentFromWinning() {
		int[][] board = new int[][]{
				new int[] {O, X ,E},
				new int[] {E, O, E},
				new int[] {X, E, E}
		};
		
		assertEquals(TicTacToe.play(board, X), 8);
	}
}