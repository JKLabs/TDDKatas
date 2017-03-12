package org.jklabs.tddkatas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TicTacToe game strategy
 * 
 * @author eldo.joseph
 */
public class TicTacToe {
	public static final int E = 0;
	public static final int X = 1;
	public static final int O = 2;
	public static final int ERROR_CODE = -1;
	private static List<List<Integer>> priorityOfColumns;

	static {
		priorityOfColumns = new ArrayList<List<Integer>>();
		priorityOfColumns.add(Arrays.asList(4));
		priorityOfColumns.add(Arrays.asList(0, 2, 6, 8));
		priorityOfColumns.add(Arrays.asList(1, 3, 5, 7));
	}

	/**
	 * Play the game. Returns the best possible cell to fill with the character
	 * given the current board position
	 * 
	 * @param board
	 * @param character
	 * @return
	 */
	public static int play(int[][] board, int character) {
		// Return a possible win-able cell
		int winnableCell = getWinnableCell(board, character);

		if (winnableCell != ERROR_CODE)
			return winnableCell;

		// If no such cell exists, make sure opponent cannot win
		int opponentCharacter = getOppnentCharacter(character);
		int opponentWinnableCell = getWinnableCell(board, opponentCharacter);

		if (opponentWinnableCell != ERROR_CODE)
			return opponentWinnableCell;

		// Else Choose a random cell available with the highest priority
		return getHighestPriorityFreeCell(board);
	}

	private static int getOppnentCharacter(int character) {
		int opponentCharacter = O;

		if (character == O)
			opponentCharacter = X;

		return opponentCharacter;
	}

	private static int getWinnableCell(int[][] board, int character) {
		int winningCell = getHorizontalWinnableCell(board, character);

		if (winningCell != ERROR_CODE)
			return winningCell;

		winningCell = getVerticalWinnableCell(board, character);

		if (winningCell != ERROR_CODE)
			return winningCell;

		return getDiagonalWinnableCell(board, character);
	}

	private static int getHorizontalWinnableCell(int[][] board, int character) {
		for (int row = 0; row < 3; row++) {
			int characterCount = 0, emptyCellCount = 0, emptyCellI = 0, emptyCellJ = 0;

			for (int col = 0; col < 3; col++) {

				if (board[row][col] == character) {
					characterCount++;

				} else if (board[row][col] == E) {
					emptyCellCount++;
					emptyCellI = row;
					emptyCellJ = col;
				}
			}

			if ((characterCount == 2) && (emptyCellCount == 1)) {
				return getCellValueFromCoordinates(emptyCellI, emptyCellJ);
			}
		}

		return ERROR_CODE;
	}

	private static int getVerticalWinnableCell(int[][] board, int character) {
		for (int col = 0; col < 3; col++) {
			int characterCount = 0, emptyCellCount = 0, emptyCellI = 0, emptyCellJ = 0;

			for (int row = 0; row < 3; row++) {

				if (board[row][col] == character) {
					characterCount++;

				} else if (board[row][col] == E) {
					emptyCellCount++;
					emptyCellI = row;
					emptyCellJ = col;
				}
			}

			if ((characterCount == 2) && (emptyCellCount == 1)) {
				return getCellValueFromCoordinates(emptyCellI, emptyCellJ);
			}
		}

		return ERROR_CODE;
	}

	private static int getDiagonalWinnableCell(int[][] board, int character) {

		int winnableCell = getWinnableCellInForwardDiagonal(board, character);

		if (winnableCell != ERROR_CODE)
			return winnableCell;

		return getWinnableCellInBackwardDiagonal(board, character);
	}

	private static int getWinnableCellInBackwardDiagonal(int[][] board,
			int character) {
		int characterCount = 0, emptyCellCount = 0, emptyCellI = 0, emptyCellJ = 0;

		for (int i = 0; i < 3; i++) {
			int j = 3 - i - 1;
			if (board[i][j] == character)
				characterCount++;
			else if (board[i][j] == E) {
				emptyCellCount++;
				emptyCellI = i;
				emptyCellJ = j;
			}

		}

		if ((characterCount == 2) && (emptyCellCount == 1)) {
			return getCellValueFromCoordinates(emptyCellI, emptyCellJ);
		}

		return ERROR_CODE;
	}

	private static int getWinnableCellInForwardDiagonal(int[][] board,
			int character) {
		int characterCount = 0, emptyCellCount = 0, emptyCellI = 0, emptyCellJ = 0;

		for (int i = 0; i < 3; i++) {
			if (board[i][i] == character)
				characterCount++;
			else if (board[i][i] == E) {
				emptyCellCount++;
				emptyCellI = i;
				emptyCellJ = i;
			}

		}

		if ((characterCount == 2) && (emptyCellCount == 1)) {
			return getCellValueFromCoordinates(emptyCellI, emptyCellJ);
		}

		return ERROR_CODE;
	}

	private static int getCellValueFromCoordinates(int emptyCellI,
			int emptyCellJ) {

		return (3 * emptyCellI) + emptyCellJ;
	}

	private static int getHighestPriorityFreeCell(int[][] board) {
		for (List<Integer> cells : priorityOfColumns) {

			for (int cell : cells) {

				if (isCellFree(board, cell)) {

					return cell;
				}
			}
		}

		return -1;
	}

	private static boolean isCellFree(int[][] board, int cellId) {
		int i = 0;
		while (cellId >= 3) {

			cellId -= 3;
			++i;
		}

		int j = cellId;

		return board[i][j] == E;
	}
}
