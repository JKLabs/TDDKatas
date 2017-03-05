package org.jklabs.tddkatas;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.jklabs.tddkatas.helpers.Item;

public class SuperMarketCheckout {
	private Map<Item, Integer> items;

	public SuperMarketCheckout() {
		items = new HashMap<Item, Integer>();
	}

	public void addItem(Item item) {
		items.put(item, 1);
	}

	public void addItem(Item item, int count) {
		items.put(item, count);
	}

	public int getItemCount(String itemName) {
		int itemCount = 0;

		for (Entry<Item, Integer> entry : items.entrySet()) {
			Item item = entry.getKey();
			int count = entry.getValue();

			if (item.getName().equals(itemName))
				itemCount += count;
		}

		return itemCount;
	}

	public void removeItem(String itemName) {
		for (Entry<Item, Integer> entry : items.entrySet()) {

			Item item = entry.getKey();
			if (item.getName().equals(itemName)) {

				int count = items.get(item);

				if (count > 1)
					items.put(item, count - 1);
				else
					items.remove(item);
			}
		}
	}

	public int checkOut() {
		if (items.size() == 0)
			throw new UnsupportedOperationException("Cart is Empty");

		int total = 0;

		for (Entry<Item, Integer> entry : items.entrySet()) {
			int itemPrice = entry.getKey().getPrice();
			int count = entry.getValue();

			total += count * itemPrice;
		}

		return total;
	}

}
