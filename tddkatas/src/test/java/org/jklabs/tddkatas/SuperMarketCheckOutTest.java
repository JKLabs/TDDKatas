package org.jklabs.tddkatas;

import static org.junit.Assert.assertEquals;

import org.jklabs.tddkatas.helpers.Item;
import org.junit.Before;
import org.junit.Test;

public class SuperMarketCheckOutTest {

	private SuperMarketCheckout superMarket;

	@Before
	public void setUp() {
		superMarket = new SuperMarketCheckout();
	}

	@Test
	public void superMarket_supportsItemAddition() {
		superMarket.addItem(new Item("A", 20));
	}

	@Test
	public void superMarket_supportsMultipleAdditions() {
		superMarket.addItem(new Item("A", 20), 3);
	}

	@Test
	public void superMarket_reportsUnAddedItemCountsAsZero() {
		assertEquals(superMarket.getItemCount("A"), 0);
		assertEquals(superMarket.getItemCount("B"), 0);
	}

	@Test
	public void superMarket_tracksItemsCorrectly() {
		superMarket.addItem(new Item("A", 20));
		superMarket.addItem(new Item("A", 20), 3);

		assertEquals(superMarket.getItemCount("A"), 4);
	}

	@Test
	public void superMarket_supportsItemRemoval() {
		superMarket.addItem(new Item("A", 20));

		superMarket.removeItem("A");

		assertEquals(superMarket.getItemCount("A"), 0);
	}

	@Test
	public void superMarket_supportsRemovalOfSingleItems() {
		superMarket.addItem(new Item("A", 20), 3);

		superMarket.removeItem("A");

		assertEquals(superMarket.getItemCount("A"), 2);
	}
	
	@Test
	public void superMarket_supportsCheckOut() {
		superMarket.addItem(new Item("A", 20));
		superMarket.addItem(new Item("A", 20), 3);
		superMarket.addItem(new Item("B", 3), 2);
		
		assertEquals(superMarket.checkOut(), 86);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void superMarket_throwsException_forEmptyShoppingCart() {
		superMarket.checkOut();
	}
}
