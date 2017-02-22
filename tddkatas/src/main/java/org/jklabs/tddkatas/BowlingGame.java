package org.jklabs.tddkatas;

/**
 * Bowling Game score calculator Kata
 * 
 * (https://www.youtube.com/watch?v=OPGTPQ4kURU)
 *
 */
public class BowlingGame {
	int score = 0;
	int currentRole = 0;

	public void roll(int... rolls) {
		int cursor = 0;

		for (int frame = 0; frame < 10; frame++) {
			if (isStrike(cursor, rolls)) {
				score += 10 + rolls[cursor + 1] + rolls[cursor + 2];
				cursor++;

			} else if (isSpare(cursor, rolls)) {
				score += 10 + rolls[cursor + 2];
				cursor += 2;

			} else {
				score += rolls[cursor] + rolls[cursor + 1];
				cursor += 2;
			}
		}
	}

	private boolean isStrike(int cursor, int... rolls) {
		return rolls[cursor] == 10;
	}

	private boolean isSpare(int cursor, int[] rolls) {
		return rolls[cursor] + rolls[cursor + 1] == 10;
	}

	public int score() {
		return score;
	}

}
