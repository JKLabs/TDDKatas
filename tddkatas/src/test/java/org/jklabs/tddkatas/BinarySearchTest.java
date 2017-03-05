package org.jklabs.tddkatas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTest {
	
	@Test(expected = NullPointerException.class)
	public void throwsException_for_NullInput() {
		BinarySearch.search(null, 1);
	}
	
	@Test
	public void emptyArray_Gives_NotFound() {
		assertEquals(BinarySearch.search(new int[] {}, 1), BinarySearch.NOTFOUND);
	}
	
	@Test
	public void nonExistingElement_Gives_NotFound() {
		assertEquals(BinarySearch.search(new int[] {1}, 2), BinarySearch.NOTFOUND);
	}
	
	@Test
	public void singleElementArraySearch_SucceedsForExistingELement() {
		assertEquals(BinarySearch.search(new int[] {1}, 1), 0);
	}
	
	@Test
	public void searchHits_For_presentElement() {
		assertEquals(BinarySearch.search(new int[] {1, 2, 3, 4, 5}, 4), 3);
	}
	
	@Test
	public void searchMisses_For_absentElement() {
		assertEquals(BinarySearch.search(new int[] {1, 2, 3, 4, 5}, 9), BinarySearch.NOTFOUND);
	}
	
	@Test
	public void searchHits_For_ArrayWithNegatives() {
		assertEquals(BinarySearch.search(new int[] {-9, -4, 0, 6, 7}, 6), 3);
	}
}
