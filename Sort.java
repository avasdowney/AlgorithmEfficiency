package assignmentThree;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Sort {
	
	int steps;

	public Sort() {

	}
	
	public int getSteps() {
		return steps;
	}

	/**
	 * Reads values from a file and puts them into an integer array
	 * 
	 * @SeeLink code taken and modified from <a href=
	 *          "https://stackoverflow.com/questions/326390/how-do-i-create-a-java-string-from-the-contents-of-a-file">https://stackoverflow.com</a>
	 * 
	 * @param path position of file as a String
	 * @throws IOException exception thrown if file cannot be read
	 * @return array of integers read from the data
	 */
	public int[] readData(String path) throws IOException {
		// read file to string
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		String dataString = new String(encoded, Charset.forName("UTF-8"));

		// string to int array
		String[] split = dataString.split(",");
		int[] data = new int[split.length];
		for (int i=0; i<split.length; i++) {
			data[i] = Integer.parseInt(split[i].trim());
		}
		
		return data;
		
	}

	/**
	 * Sorts an array of integers by swapping elements until the entire array is
	 * sorted. Checks index and index+1 to see which one is larger. If index+1 is
	 * larger then index, then move to next index. If index is larger, switch the
	 * value in index with the value in index+1.
	 * 
	 * @SeeLink code taken and modified from geeksforgeeks <a href=
	 *          "https://www.geeksforgeeks.org/java-program-for-bubble-sort/">http://geeksforgeeks.com</a>
	 * 
	 * @param numbers array of integers to be sorted
	 * @return sorted array of integers
	 */
	public int[] bubbleSort(int[] numbers) {
		int steps = 0;
		int n = numbers.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					// swap temp and arr[i]
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
					steps = steps + 6; // access array 6 times in this code
				}
				
			}
			
		}
		System.out.println("Number of memory access: " + steps);
		return numbers;
	}

	/**
	 * Sorts an array of integers by searching for the smallest element in the array
	 * and switching it with the value in index i, which is the index where that
	 * value belongs. The array is iterated through until the whole array has been
	 * sorted.
	 * 
	 * I took psuedocode from the zybook and turned it into actual code, optimizing
	 * it at the same time.
	 * 
	 * @param numbers an array of numbers to be sorted
	 * @return sorted array of integers
	 */
	public int[] selectionSort(int[] numbers) {
		int indexSmallest;
		int steps = 0;
		int temp = 0; // Temporary variable for swap

		for (int i = 0; i < numbers.length - 1; ++i) {
			// Find index of smallest remaining element
			indexSmallest = i;
			for (int j = i + 1; j < numbers.length; ++j) {
				if (numbers[j] < numbers[indexSmallest]) {
					indexSmallest = j;
					steps = steps + 2;
				}

			}
			// Swap numbers[i] and numbers[indexSmallest]
			temp = numbers[i];
			numbers[i] = numbers[indexSmallest];
			numbers[indexSmallest] = temp;
			steps = steps + 4;
		}
		System.out.println("Number of memory access: " + steps);
		return numbers;

	}

	/**
	 * Sorts a subsection of a larger array, then merges the sorted subsections
	 * together.
	 * 
	 * I took code from zybook and optimized it.
	 * 
	 * @param numbers array of integers to be sorted
	 * @param i       left partition position value
	 * @param j       right partition position value
	 * @param k       length of array
	 * @return sorted subsection of an array of integers
	 */
	private int[] merge(int[] numbers, int i, int j, int k) {
		int mergedSize = k - i + 1; // Size of merged partition
		int[] mergedNumbers = new int[mergedSize]; // Dynamically allocates temporary
													// array for merged numbers
		int mergePos = 0; // Position to insert merged number
		int leftPos = i; // Initialize left partition position
		int rightPos = j + 1; // Initialize right partition position

		// Add smallest element from left or right partition to merged numbers
		while (leftPos <= j && rightPos <= k) {
			if (numbers[leftPos] <= numbers[rightPos]) {
				mergedNumbers[mergePos] = numbers[leftPos];
				leftPos++;
				steps = steps + 4;
			} else {
				mergedNumbers[mergePos] = numbers[rightPos];
				rightPos++;
				steps = steps + 2;
			}
			mergePos++;
		}

		// If left partition is not empty, add remaining elements to merged numbers
		while (leftPos <= j) {
			mergedNumbers[mergePos] = numbers[leftPos];
			leftPos++;
			mergePos++;
			steps = steps + 2;
		}

		// If right partition is not empty, add remaining elements to merged numbers
		while (rightPos <= k) {
			mergedNumbers[mergePos] = numbers[rightPos];
			rightPos++;
			mergePos++;
			steps = steps + 2;
		}

		// Copy merged numbers back to numbers
		for (mergePos = 0; mergePos < mergedSize; mergePos++) {
			numbers[i + mergePos] = mergedNumbers[mergePos];
			steps = steps + 2;
		}
		return mergedNumbers;
	}

	/**
	 * Sorts an array of integers by splitting the array into sections and
	 * sorting each subsection, then merging all the subsections together into a
	 * sorted array.
	 * 
	 * I took code from the zybook and optimized it.
	 * 
	 * @param numbers array of integers to be sorted
	 * @param i       left partition position value
	 * @param j       right partition position value
	 * @param k       length of array
	 * @return sorted array of integers
	 */
	public int[] mergeSort(int[] numbers, int i, int k) {
		int j = 0;

		if (i < k) {
			j = (i + k) / 2; // Find the midpoint in the partition

			// Recursively sort left and right partitions
			mergeSort(numbers, i, j);
			mergeSort(numbers, j + 1, k);

			// Merge left and right partition in sorted order
			merge(numbers, i, j, k);
		}
		
		return numbers;
	}

	/**
	 * Selects the value of the pivot by finding the midpoint of the start and end
	 * indices. This pivot is then used to split the array into a section of values
	 * greater than the value of the pivot (right) and a section less than the value
	 * of the pivot (left).
	 * 
	 * I took code from the zybook and optimized it
	 * 
	 * @param numbers    array of integers to be sorted
	 * @param startIndex index to start sorting at
	 * @param endIndex   index to end sorting at
	 * @return last index in left section
	 */
	private int partition(int[] numbers, int startIndex, int endIndex) {
		// Select the middle value as the pivot.
		int midpoint = startIndex + (endIndex - startIndex) / 2;
		int pivot = numbers[midpoint];
		steps ++;

		// "low" and "high" start at the ends of the array segment
		// and move towards each other.
		int low = startIndex;
		int high = endIndex;

		boolean done = false;
		while (!done) {
			// Increment low while numbers[low] < pivot
			while (numbers[low] < pivot) {
				low = low + 1;
				steps ++;
			}

			// Decrement high while pivot < numbers[high]
			while (pivot < numbers[high]) {
				high = high - 1;
				steps ++;
			}

			// If low and high have crossed each other, the loop
			// is done. If not, the elements are swapped, low is
			// incremented and high is decremented.
			if (low >= high) {
				done = true;
			} else {
				int temp = numbers[low];
				numbers[low] = numbers[high];
				numbers[high] = temp;
				low++;
				high--;
				steps = steps + 4;
			}
		}

		// "high" is the last index in the left segment.
		return high;
	}

	/**
	 * Sorts an array of integers by placing values at indexes to the right or left
	 * of the pivot, depending on if they are greater than or less than the value of
	 * the pivot. startIndex and endIndex then get closer and closer, also changing
	 * the pivot, together making the array become more and more sorted. The Array
	 * is sorted when startIndex is greater than or equal to the endIndex, meaning
	 * the entire array has been checked and sorted.
	 * 
	 * I took code from the zybook and optimized it.
	 * 
	 * @param numbers    array of integers to be sorted
	 * @param startIndex index to start sorting at
	 * @param endIndex   index to end sorting at
	 * @return sorted array of integers
	 */
	public int[] quickSort(int[] numbers, int startIndex, int endIndex) {
		// Only attempt to sort the array segment if there are
		// at least 2 elements
		if (endIndex <= startIndex) {
			return numbers;
		}

		// Partition the array segment
		int high = partition(numbers, startIndex, endIndex);

		// Recursively sort the left segment
		quickSort(numbers, startIndex, high);

		// Recursively sort the right segment
		quickSort(numbers, high + 1, endIndex);

		return numbers;
	}

}
