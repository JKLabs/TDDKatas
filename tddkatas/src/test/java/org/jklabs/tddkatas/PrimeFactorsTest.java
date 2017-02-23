package org.jklabs.tddkatas;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class PrimeFactorsTest {
	
	private PrimeFactors primeFactors;
	
	@Before
	public void setUp() {
		primeFactors = new PrimeFactors();
	}
	
	@Test
	public void of1isEmplyList() {
		assertEquals(primeFactors.of(1), Arrays.asList());
	}
	
	@Test
	public void of2is2() {
		assertEquals(primeFactors.of(2), Arrays.asList(2));
	}
	
	@Test
	public void of4is2_2() {
		assertEquals(primeFactors.of(4), Arrays.asList(2, 2));
	}
	
	@Test
	public void of3is3() {
		assertEquals(primeFactors.of(3), Arrays.asList(3));
	}
	
	@Test
	public void of10is5_2() {
		assertEquals(primeFactors.of(10), Arrays.asList(2, 5));
	}
	
	@Test
	public void primeFactorsAcceptanceTest() {
		assertEquals(primeFactors.of(2 * 3 * 3 * 5 * 7 * 11), Arrays.asList(2, 3, 3, 5, 7, 11));
	}
	
	@Test
	public void primeFactorsAcceptanceTest2() {
		assertEquals(primeFactors.of(19 * 11), Arrays.asList(11, 19));
	}
}
