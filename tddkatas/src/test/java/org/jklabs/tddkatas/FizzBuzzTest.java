package org.jklabs.tddkatas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FizzBuzzTest {
	
	@Test
	public void of_0_is_0() {
		assertEquals(FizzBuzz.of(0), "0");
	}
	
	@Test
	public void of_1_is_1() {
		assertEquals(FizzBuzz.of(1), "1");
	}
	
	@Test
	public void of_3_is_Fizz() {
		assertEquals(FizzBuzz.of(3), "Fizz");
	}
	
	@Test
	public void of_6_is_Fizz() {
		assertEquals(FizzBuzz.of(6), "Fizz");
	}
	
	@Test
	public void of_5_is_Buzz() {
		assertEquals(FizzBuzz.of(5), "Buzz");
	}
	
	@Test
	public void of_10_is_Buzz() {
		assertEquals(FizzBuzz.of(10), "Buzz");
	}
	
	@Test
	public void of_15_is_FizzBuzz() {
		assertEquals(FizzBuzz.of(15), "FizzBuzz");
	}
}
