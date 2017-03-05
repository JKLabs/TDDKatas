package org.jklabs.tddkatas;

public class BinarySearch {

	public static final int NOTFOUND = -1;

	public static int search(int[] array, int element) {
		if (array.length == 0)
			return NOTFOUND;

		int start = 0;
		int end = array.length - 1;

		return search(array, element, start, end);
	}

	private static int search(int[] array, int element, int start, int end) {
		if (start > end)
			return NOTFOUND;

		int mid = (start + end) / 2;

		if (array[mid] == element) {
			return mid;
			
		} else if (array[mid] < element) {
			return search(array, element, mid + 1, end);
			
		} else {
			return search(array, element, start, end);
		}
	}

}
