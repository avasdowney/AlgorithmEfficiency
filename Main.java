package assignmentThree;

import java.io.IOException;
import java.util.Scanner;

public class Main {	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Scanner scan = new Scanner(System.in);
		Sort sort = new Sort();
		Search search = new Search();
		String path = "C:\\Users\\avasd\\eclipse-workspace\\DataStructures\\src\\assignmentThree\\input.txt"; // this includes 50,000 ints 0-4999
		
		long startTime;
		long endTime;
		long totalTime;
		int choice = 0;
		
		// get random key for search algorithms
		int key = search.getRandomKey(5000);
		
		// read file initially so it does not interfere with times
		int[] data = sort.readData(path);
		
		System.out.println("Which search/sort do you want to test? \n"
				+ "1.) bubble sort \n"
				+ "2.) selection sort \n"
				+ "3.) merge sort \n"
				+ "4.) quick sort \n"
				+ "5.) linear search \n"
				+ "6.) binary search");
		choice = scan.nextInt();
		
		if (choice == 1) {
			// bubbleSort times
			System.out.println("Sorting an array using bubble sort...");
			startTime = System.nanoTime();
			sort.bubbleSort(data);
			endTime = System.nanoTime();
			totalTime = (endTime - startTime) / 1000000000;	// divide by 1000000000 to get nanoseconds to seconds
			System.out.println("Time taken: " + totalTime + " seconds");
		} else if (choice == 2) {		
			// selectionSort times
			System.out.println("Sorting an array using selection sort...");
			startTime = System.nanoTime();
			sort.selectionSort(data);
			endTime = System.nanoTime();
			totalTime = (endTime - startTime) / 1000000000;	// divide by 1000000000 to get nanoseconds to seconds
			System.out.println("Time taken: " + totalTime + " seconds");
		} else if(choice == 3) {
			// mergeSort times
			System.out.println("Sorting an array using merge sort...");
			startTime = System.nanoTime();
			sort.mergeSort(data, 0, data.length - 1);
			endTime = System.nanoTime();
			totalTime = (endTime - startTime) / 1000000000;	// divide by 1000000000 to get nanoseconds to seconds
			System.out.println("Number of memory access: " + sort.getSteps());
			System.out.println("Time taken: " + totalTime + " seconds");
		} else if(choice == 4) {	
			// quickSort times
			System.out.println("Sorting an array using quick sort...");
			startTime = System.nanoTime();
			sort.quickSort(data, 0, data.length - 1);
			endTime = System.nanoTime();
			totalTime = (endTime - startTime) / 1000000000;	// divide by 1000000000 to get nanoseconds to seconds
			System.out.println("Number of memory access: " + sort.getSteps());
			System.out.println("Time taken: " + totalTime + " seconds");
		} else if(choice == 5) {
			// linearSearch times
			System.out.println("Searching an array using linear search, searching for value " + key + "...");
			startTime = System.nanoTime();
			search.linearSearch(data, key);
			endTime = System.nanoTime();
			totalTime = (endTime - startTime) / 1000000000;	// divide by 1000000000 to get nanoseconds to seconds
			System.out.println("Number of memory access: " + search.getSteps());
			System.out.println("Time taken: " + totalTime + " seconds");
		} else if(choice == 6) {
			// binarySearch times
			System.out.println("Searching an array using binary search, searching for value " + key + "...");
			startTime = System.nanoTime();
			search.binarySearch(sort.quickSort(data, 0, data.length - 1), key);
			endTime = System.nanoTime();
			totalTime = (endTime - startTime) / 1000000000;	// divide by 1000000000 to get nanoseconds to seconds
			System.out.println("Number of memory access: " + search.getSteps());
			System.out.println("Time taken: " + totalTime + " seconds");
		}
		
		// TODO: in readme, explain why the times and memory access are what they are

	}

}
