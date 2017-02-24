package org.jklabs.tddkatas;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

	public static int add(String input) {
		if (input.length() == 0) {
			return 0;
		}

		input = ignoreWhiteSpaces(input);

		return extractNumbersAndAdd(input);
	}

	private static int extractNumbersAndAdd(String input) {
		int sum = 0;
		List<String> integers = Arrays.asList(input.split(","));

		for (String integer : integers) {
			sum += getIntegerValue(integer);
		}

		return sum;
	}

	private static Integer getIntegerValue(String stringRepresentation) {
		if (stringRepresentation.length() == 0)
			return 0;

		return Integer.valueOf(stringRepresentation);
	}

	private static String ignoreWhiteSpaces(String input) {
		return input.replaceAll(RegularExpressions.ANY_NUMBER_OF_SPACES, "");
	}
}
