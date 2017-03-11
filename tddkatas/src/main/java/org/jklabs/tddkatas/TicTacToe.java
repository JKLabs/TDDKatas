package org.jklabs.tddkatas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	public static int play(int[][] board, int character) {

		return getHighestPriorityFreeCell(board);
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
