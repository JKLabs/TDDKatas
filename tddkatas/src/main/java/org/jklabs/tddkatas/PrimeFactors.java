package org.jklabs.tddkatas;

import java.util.ArrayList;
import java.util.List;

/**
 * Prime factors kata
 * 
 * https://www.youtube.com/watch?v=9flsVKN4tZM
 *
 */
public class PrimeFactors {

	public static List<Integer> of(int n) {
		List<Integer> primeFactors = new ArrayList<Integer>();
		int divisor = 2;

		while (n > 1) {
			while (n % divisor == 0) {
				primeFactors.add(divisor);
				n = n / divisor;
			}

			divisor++;
		}

		return primeFactors;
	}

}
