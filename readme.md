# Programming Assignment Three
### CS220P -- Data Structures
##### Ava Downey

##### How to run my code

1. Download code onto your computer and run Main class

1. Input a number corresponding to which searching or sorting algorithm you would
like to test 

##### Which sorting algorithm is the best?

| Algorithm      | Average Efficiency | Average Time | Memory Access |
| -------------- | ------------------ | ------------ | ------------- |
| Bubble Sort    | O(n^2)             | 12-23 seconds| 2,108,039,052 |
| Selection Sort | O(n^2)             | 2-4 seconds  | 1,995,928     |
| Merge Sort     | O(nlog(n))         | 0 seconds    | 8,228,760     |
| Quick Sort     | O(nlog(n))         | 0 seconds    | 3,173,606     |

The quick sort searching algorithm is the best. It is not only the most efficient
runtime, but it also accesses the memory the least amount of times. The runtime 
being smaller means that a program that uses this sorting method can execute 
faster, so a smaller runtime is ideal. The smaller the memory access number is, 
the better as well because less memory needs to be allocated for the program to 
be able to run. This can be seen in the big O notation as well, because 
O(nlog(n)) will result in a much smaller number than O(n^2), which bubble sort 
and selection sort use. This is reflected in their run times and memory access count.

I have made a list ranking the sorting algorithms based on my data:
1. Quick Sort
1. Merge Sort
1. Selection Sort
1. Bubble Sort

It is good to note that my findings are not very inclusive because I only used one
list of data to sort. Even though my list was 100,000 integers long, it might be
unproportionaly efficient to one of the algorithms. To combat this, I can try 
multiple different sets of integers rather than just one, and average my findings.
I also found that the more I ran and tested my program, the faster it got, even
though each instance I ran it was different. This is because the JVM tries to
optimize itself to run more efficiently.

##### Bubble Sort

Bubble sort sorts an array of integers by swapping elements until the entire array 
is sorted. Checks index and index+1 to see which one is larger. If index+1 is 
larger then index, then move to next index. If index is larger, switch the
value in index with the value in index+1.

##### Selection Sort

Selection sort sorts an array of integers by searching for the smallest element 
in the array and switching it with the value in index i, which is the index where 
that value belongs in the sorted array. The array is iterated through until the 
whole array has been sorted.

##### Merge Sort

Merge sort sorts an array of integers by splitting the array into sections and
sorting each subsection, then merging all the subsections together into a
sorted array.

##### Quick Sort

Quick sort sorts an array of integers by placing values at indexes to the right or 
left of the pivot, depending on if they are greater than or less than the value 
of the pivot. The startIndex and endIndex then get closer and closer, also changing
the pivot, together making the array become more and more sorted. The Array
is sorted when startIndex is greater than or equal to the endIndex, meaning
the entire array has been checked and sorted.

##### Which searching algorithm is the best?

| Algorithm      | Average Efficiency | Average Time | Memory Access |
| -------------- | ------------------ | ------------ | ------------- |
| Linear Search  | O(n)               | 0-1 seconds  | 1 - 100,000   |
| Binary Search  | O(log(n))          | 0 seconds    | 1 - 16        |

Binary search, unsurprisingly is the most efficient searching algorithm I tested.
While both were able to quickly find the key, it has a much lower big O notation 
which is reflected in its faster runtime and lower amount of memory access. The 
only reason linear search might be a better searching algorithm is if you are not
given a sorted list.

Here is my ranking of searching algorithms based on my data:
1. Binary search
1. Linear search

##### Linear Search

Linear search searches an array of integers index by index. If the key is not 
found in that index, the next index is searched. This is repeated until the key 
is found.

##### Binary Search

Binary search searches a sorted array of integers starting at the middle index of the
array. If the middle index is the key, the search is done. If the middle
index is less than the key, the array is cut in half and then searches the
middle index of the split array. The same happens for if the key is larger
than the value at the middle index, but the array that will be searched next
is the larger half. This is repeated recursively until the key is found.
