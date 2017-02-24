package org.jklabs.tddkatas;

public class FizzBuzz {

	public static String of(int i) {
		if (i == 0) {
			return "0";
		}

		return _of(i);
	}

	private static String _of(int i) {
		String fizzBuzValue = "";

		if (i % 3 == 0) {
			fizzBuzValue += "Fizz";
		}

		if (i % 5 == 0) {
			fizzBuzValue += "Buzz";
		}

		return !fizzBuzValue.isEmpty() ? fizzBuzValue : String.valueOf(i);
	}

}
