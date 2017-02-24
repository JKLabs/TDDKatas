package org.jklabs.tddkatas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {

	@Test(expected = NullPointerException.class)
	public void addingNull_ShouldThrowException() {
		StringCalculator.add(null);
	}

	@Test
	public void addingEmptyString_ShouldReturnZero() {
		assertEquals(StringCalculator.add(""), 0);
	}

	@Test
	public void addingSingleDigit_ShouldReturnDigit() {
		assertEquals(StringCalculator.add("4"), 4);
	}

	@Test
	public void addingSingleDigit_WithWhiteSpaces_ShouldReturnDigit() {
		assertEquals(StringCalculator.add("   8  "), 8);
	}

	@Test
	public void addingTwoNumbers_ShouldReturnSum() {
		assertEquals(StringCalculator.add("1, 2"), 3);
	}

	@Test
	public void addingTwoNumbers_withLeadingAndTrailingSpaces_ShouldReturnSum() {
		assertEquals(StringCalculator.add("3, 2"), 5);
	}

	@Test
	public void addingCommaSeperatedEmptyString_ShouldReturnZero() {
		assertEquals(StringCalculator.add(" , ,  , "), 0);
	}

	@Test
	public void addingNumber_withNegatives_shouldReturnSum() {
		assertEquals(StringCalculator.add("6, -4"), 2);
	}

	@Test
	public void addingMultipleDigits_shouldReturnSum() {
		assertEquals(StringCalculator.add("1, 2, 3, 4, 5"), 15);
	}

	@Test
	public void acceptanceTest() {
		assertEquals(StringCalculator.add("  9,   0 , -2, 8, , 8, -4, -4  "),
				15);
	}
}
