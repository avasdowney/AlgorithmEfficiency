package assignmentThree;

import java.util.Random;

public class Search {
	
	int steps = 0;

	public Search() {

	}

	/**
	 * randomly generates a value between 0(inclusive) and maxValue(exclusive)
	 * 
	 * @param maxValue maximum value exclusive to possibly be generated
	 * @return random value between 0 to maxValue
	 */
	public int getRandomKey(int maxValue) {
		Random random = new Random();
		return random.nextInt(maxValue);
	}
	
	public int getSteps() {
		return steps;
	}

	/**
	 * Searches an array of integers index by index. If the key is not found in that
	 * index, the next index is searched. This is repeated until the key is found
	 * 
	 * I took code from zybook and optimized it.
	 * 
	 * @param numbers array of integers
	 * @param key value to be searched for
	 * @param comparisons
	 * @return first index value can be found at. -1 if value not found
	 */
	public int linearSearch(int[] numbers, int key) {
		// Added parameter to hold total number of comparisons.

		for (int i = 0; i < numbers.length; i++) {
			steps ++;
			if (numbers[i] == key) {
				return i;
			}
		}
		System.out.println("Number of memory access: " + steps);
		return -1; // not found
	}

	/**
	 * Searches a sorted array of integers starting at the middle index of the
	 * array. If the middle index is the key, the search is done. If the middle
	 * index is less than the key, the array is cut in half and then searches the
	 * middle index of the split array. The same happens for if the key is larger
	 * than the value at the middle index, but the array that will be searched next
	 * is the larger half. This is repeated recursively until the key is found.
	 * 
	 * I took code from zybook and optimized it.
	 * 
	 * @param numbers sorted array of integers
	 * @param key value to be searched for
	 * @param comparisons
	 * @return first index value can be found at. -1 if value not found
	 */
	public int binarySearch(int[] numbers, int key) {
		// Added parameter to hold total number of comparisons.

		// Variables to hold the low, middle and high indices
		// of the area being searched. Starts with entire range.
		int low = 0;
		int mid = numbers.length / 2;
		int high = numbers.length - 1;

		// Loop until "low" passes "high"
		while (high >= low) {
			// Calculate the middle index
			mid = (high + low) / 2;

			// Cut the range to either the left or right half,
			// unless numbers[mid] is the key
			steps++;
			if (numbers[mid] < key) {
				low = mid + 1;
			} else if (numbers[mid] > key) {
				high = mid - 1;
				steps ++;
			} else {
				steps ++;
				return mid;
			}
		}
		System.out.println("Number of memory access: " + steps);
		return -1; // not found
	}

}
