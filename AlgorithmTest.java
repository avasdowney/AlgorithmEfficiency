package assignmentThree;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class AlgorithmTest {
	
	final int[] nums = {5, 7, 3, 2, 1, 4, 6, 8, 10, 9};
	final int[] numsSorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	Sort sort;
	Search search;
	int[] dataArray;
	
	@Test
	void readFileTest() throws IOException {
		sort = new Sort();
		assertArrayEquals(nums, sort.readData("C:\\Users\\avasd\\eclipse-workspace\\DataStructures\\src\\assignmentThree\\inputTest.txt"));
	}
	
	@Test
	void bubbleSortTest() {
		sort = new Sort();
		int[] numsCopy = nums.clone();
		Arrays.sort(numsCopy);
		int[] results = sort.bubbleSort(nums);
		assertArrayEquals(numsCopy, results);
	}
	
//	@Test
//	void bubbleSortBigFileTest() throws IOException {
//		sort = new Sort();
//		int data[] = sort.readData("C:\\Users\\avasd\\eclipse-workspace\\DataStructures\\src\\assignmentThree\\input.txt");
//		int[] dataCopy = data.clone();
//		Arrays.sort(dataCopy);
//		int[] results = sort.bubbleSort(data);
//		assertArrayEquals(dataCopy, results);
//	}
	
	@Test
	void selectionSortTest() {
		sort = new Sort();
		assertArrayEquals(numsSorted, sort.selectionSort(nums));
	}
	
	@Test
	void selectionSortBigFileTest() throws IOException {
		sort = new Sort();
		int data[] = sort.readData("C:\\Users\\avasd\\eclipse-workspace\\DataStructures\\src\\assignmentThree\\input.txt");
		int[] dataCopy = data.clone();
		Arrays.sort(dataCopy);
		int[] results = sort.selectionSort(data);
		assertArrayEquals(dataCopy, results);
	}
	
	@Test
	void mergeSortTest() {
		sort = new Sort();
		sort.mergeSort(nums, 0, nums.length-1);
		assertArrayEquals(numsSorted, nums);
	}
	
	@Test
	void mergeSortBigFileTest() throws IOException {
		sort = new Sort();
		int data[] = sort.readData("C:\\Users\\avasd\\eclipse-workspace\\DataStructures\\src\\assignmentThree\\input.txt");
		int[] dataCopy = data.clone();
		Arrays.sort(dataCopy);
		sort.mergeSort(data, 0, data.length-1);
		System.out.println(Arrays.toString(data));
		assertArrayEquals(dataCopy, data);
	}
	
	@Test
	void quickSortTest() {
		Sort sort = new Sort();
		assertArrayEquals(numsSorted, sort.quickSort(nums, 0, nums.length-1));
	}
	
	@Test
	void quickSortBigFileTest() throws IOException {
		sort = new Sort();
		int data[] = sort.readData("C:\\Users\\avasd\\eclipse-workspace\\DataStructures\\src\\assignmentThree\\input.txt");
		int[] dataCopy = data.clone();
		Arrays.sort(dataCopy);
		int[] results = sort.quickSort(data, 0, data.length-1);
		assertArrayEquals(dataCopy, results);
	}
	
	@Test
	void linearSearchTest() {
		search = new Search();
		assertEquals(3, search.linearSearch(nums, 2));
	}
	
	@Test
	void binarySearchTest() {
		Search search = new Search();
		assertEquals(1, search.binarySearch(numsSorted, 2));
	}

}
